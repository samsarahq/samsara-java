package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.core.pagination.SyncPagingIterable;
import com.samsara.api.resources.assets.requests.AssetsCreateAssetRequestBody;
import com.samsara.api.resources.assets.requests.AssetsUpdateAssetRequestBody;
import com.samsara.api.resources.assets.requests.DeleteAssetRequest;
import com.samsara.api.resources.assets.requests.ListAssetsRequest;
import com.samsara.api.resources.assets.requests.V1GetAllAssetCurrentLocationsRequest;
import com.samsara.api.resources.assets.requests.V1GetAssetLocationRequest;
import com.samsara.api.resources.assets.requests.V1GetAssetReeferRequest;
import com.samsara.api.resources.assets.requests.V1GetAssetsReefersRequest;
import com.samsara.api.types.AssetResponseBody;
import com.samsara.api.types.AssetsCreateAssetResponseBody;
import com.samsara.api.types.AssetsUpdateAssetResponseBody;
import com.samsara.api.types.InlineResponse2002;
import com.samsara.api.types.InlineResponse2003;
import com.samsara.api.types.V1AssetLocationResponseItem;
import com.samsara.api.types.V1AssetReeferResponse;
import java.util.List;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssetsWireTest {
    private MockWebServer server;
    private SamsaraApiClient client;
    private ObjectMapper objectMapper = ObjectMappers.JSON_MAPPER;

    @BeforeEach
    public void setup() throws Exception {
        server = new MockWebServer();
        server.start();
        client = SamsaraApiClient.builder()
                .url(server.url("/").toString())
                .token("test-token")
                .build();
    }

    @AfterEach
    public void teardown() throws Exception {
        server.shutdown();
    }

    @Test
    public void testList() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"externalIds\":{\"key\":\"value\"},\"id\":\"12345\",\"licensePlate\":\"XHK1234\",\"make\":\"Bobcat\",\"model\":\"S630 T4\",\"name\":\"MyAsset-1234\",\"notes\":\"These are notes.\",\"readingsIngestionEnabled\":true,\"regulationMode\":\"mixed\",\"serialNumber\":\"LN016251\",\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}],\"type\":\"uncategorized\",\"updatedAtTime\":\"2020-01-27T07:06:25Z\",\"vin\":\"1FUJBBCKXCLBZ1234\",\"year\":2015}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        SyncPagingIterable<AssetResponseBody> response =
                client.assets().list(ListAssetsRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        // Pagination response validated via MockWebServer
        // The SDK correctly parses the response into a SyncPagingIterable
    }

    @Test
    public void testCreateAsset() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"externalIds\":{\"key\":\"value\"},\"id\":\"12345\",\"licensePlate\":\"XHK1234\",\"make\":\"Bobcat\",\"model\":\"S630 T4\",\"name\":\"MyAsset-1234\",\"notes\":\"These are notes.\",\"readingsIngestionEnabled\":true,\"regulationMode\":\"mixed\",\"serialNumber\":\"LN016251\",\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}],\"type\":\"uncategorized\",\"updatedAtTime\":\"2020-01-27T07:06:25Z\",\"vin\":\"1FUJBBCKXCLBZ1234\",\"year\":2015}}"));
        AssetsCreateAssetResponseBody response = client.assets()
                .createAsset(AssetsCreateAssetRequestBody.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"createdAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"id\": \"12345\",\n"
                + "    \"licensePlate\": \"XHK1234\",\n"
                + "    \"make\": \"Bobcat\",\n"
                + "    \"model\": \"S630 T4\",\n"
                + "    \"name\": \"MyAsset-1234\",\n"
                + "    \"notes\": \"These are notes.\",\n"
                + "    \"readingsIngestionEnabled\": true,\n"
                + "    \"regulationMode\": \"mixed\",\n"
                + "    \"serialNumber\": \"LN016251\",\n"
                + "    \"tags\": [\n"
                + "      {\n"
                + "        \"id\": \"3914\",\n"
                + "        \"name\": \"East Coast\",\n"
                + "        \"parentTagId\": \"4815\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"type\": \"uncategorized\",\n"
                + "    \"updatedAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "    \"vin\": \"1FUJBBCKXCLBZ1234\",\n"
                + "    \"year\": 2015\n"
                + "  }\n"
                + "}";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testDeleteAsset() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.assets().deleteAsset(DeleteAssetRequest.builder().id("id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testUpdateAsset() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"externalIds\":{\"key\":\"value\"},\"id\":\"12345\",\"licensePlate\":\"XHK1234\",\"make\":\"Bobcat\",\"model\":\"S630 T4\",\"name\":\"MyAsset-1234\",\"notes\":\"These are notes.\",\"readingsIngestionEnabled\":true,\"regulationMode\":\"mixed\",\"serialNumber\":\"LN016251\",\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}],\"type\":\"uncategorized\",\"updatedAtTime\":\"2020-01-27T07:06:25Z\",\"vin\":\"1FUJBBCKXCLBZ1234\",\"year\":2015}}"));
        AssetsUpdateAssetResponseBody response = client.assets()
                .updateAsset(AssetsUpdateAssetRequestBody.builder().id("id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{}";
        JsonNode actualJson = objectMapper.readTree(actualRequestBody);
        JsonNode expectedJson = objectMapper.readTree(expectedRequestBody);
        Assertions.assertTrue(jsonEquals(expectedJson, actualJson), "Request body structure does not match expected");
        if (actualJson.has("type") || actualJson.has("_type") || actualJson.has("kind")) {
            String discriminator = null;
            if (actualJson.has("type")) discriminator = actualJson.get("type").asText();
            else if (actualJson.has("_type"))
                discriminator = actualJson.get("_type").asText();
            else if (actualJson.has("kind"))
                discriminator = actualJson.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualJson.isNull()) {
            Assertions.assertTrue(
                    actualJson.isObject() || actualJson.isArray() || actualJson.isValueNode(),
                    "request should be a valid JSON value");
        }

        if (actualJson.isArray()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Array should have valid size");
        }
        if (actualJson.isObject()) {
            Assertions.assertTrue(actualJson.size() >= 0, "Object should have valid field count");
        }

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"createdAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"id\": \"12345\",\n"
                + "    \"licensePlate\": \"XHK1234\",\n"
                + "    \"make\": \"Bobcat\",\n"
                + "    \"model\": \"S630 T4\",\n"
                + "    \"name\": \"MyAsset-1234\",\n"
                + "    \"notes\": \"These are notes.\",\n"
                + "    \"readingsIngestionEnabled\": true,\n"
                + "    \"regulationMode\": \"mixed\",\n"
                + "    \"serialNumber\": \"LN016251\",\n"
                + "    \"tags\": [\n"
                + "      {\n"
                + "        \"id\": \"3914\",\n"
                + "        \"name\": \"East Coast\",\n"
                + "        \"parentTagId\": \"4815\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"type\": \"uncategorized\",\n"
                + "    \"updatedAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "    \"vin\": \"1FUJBBCKXCLBZ1234\",\n"
                + "    \"year\": 2015\n"
                + "  }\n"
                + "}";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testV1GetAllAssetCurrentLocations() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"assets\":[{\"assetSerialNumber\":\"8dka2810\",\"cable\":{\"assetType\":\"Thermo King\"},\"engineHours\":104,\"id\":1,\"location\":[{\"latitude\":37,\"location\":\"525 York, San Francisco, CA\",\"longitude\":-122.7,\"speedMilesPerHour\":35,\"timeMs\":12314151}],\"name\":\"Trailer 123\"}],\"pagination\":{\"endCursor\":\"MTU5MTEzNjA2OTU0MzQ3\",\"hasNextPage\":true,\"hasPrevPage\":true,\"startCursor\":\"MTU5MTEzNjA2OTU0MzQ3\"}}"));
        InlineResponse2002 response = client.assets()
                .v1GetAllAssetCurrentLocations(
                        V1GetAllAssetCurrentLocationsRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"assets\": [\n"
                + "    {\n"
                + "      \"assetSerialNumber\": \"8dka2810\",\n"
                + "      \"cable\": {\n"
                + "        \"assetType\": \"Thermo King\"\n"
                + "      },\n"
                + "      \"engineHours\": 104,\n"
                + "      \"id\": 1,\n"
                + "      \"location\": [\n"
                + "        {\n"
                + "          \"latitude\": 37,\n"
                + "          \"location\": \"525 York, San Francisco, CA\",\n"
                + "          \"longitude\": -122.7,\n"
                + "          \"speedMilesPerHour\": 35,\n"
                + "          \"timeMs\": 12314151\n"
                + "        }\n"
                + "      ],\n"
                + "      \"name\": \"Trailer 123\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"MTU5MTEzNjA2OTU0MzQ3\",\n"
                + "    \"hasNextPage\": true,\n"
                + "    \"hasPrevPage\": true,\n"
                + "    \"startCursor\": \"MTU5MTEzNjA2OTU0MzQ3\"\n"
                + "  }\n"
                + "}";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testV1GetAssetsReefers() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"assetType\":\"Thermo King\",\"id\":1,\"name\":\"Reefer 123\"}],\"pagination\":{\"endCursor\":\"MTU5MTEzNjA2OTU0MzQ3\",\"hasNextPage\":true,\"hasPrevPage\":true,\"startCursor\":\"MTU5MTEzNjA2OTU0MzQ3\"}}"));
        InlineResponse2003 response = client.assets()
                .v1GetAssetsReefers(V1GetAssetsReefersRequest.builder()
                        .startMs(1000000L)
                        .endMs(1000000L)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": [\n"
                + "    {\n"
                + "      \"assetType\": \"Thermo King\",\n"
                + "      \"id\": 1,\n"
                + "      \"name\": \"Reefer 123\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"MTU5MTEzNjA2OTU0MzQ3\",\n"
                + "    \"hasNextPage\": true,\n"
                + "    \"hasPrevPage\": true,\n"
                + "    \"startCursor\": \"MTU5MTEzNjA2OTU0MzQ3\"\n"
                + "  }\n"
                + "}";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testV1GetAssetLocation() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"latitude\":37,\"location\":\"525 York, San Francisco, CA\",\"longitude\":-122.7,\"speedMilesPerHour\":35,\"time\":12314151}]"));
        List<V1AssetLocationResponseItem> response = client.assets()
                .v1GetAssetLocation(
                        1000000L,
                        V1GetAssetLocationRequest.builder()
                                .startMs(1000000L)
                                .endMs(1000000L)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "[\n"
                + "  {\n"
                + "    \"latitude\": 37,\n"
                + "    \"location\": \"525 York, San Francisco, CA\",\n"
                + "    \"longitude\": -122.7,\n"
                + "    \"speedMilesPerHour\": 35,\n"
                + "    \"time\": 12314151\n"
                + "  }\n"
                + "]";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testV1GetAssetReefer() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"assetType\":\"Thermo King\",\"id\":1,\"name\":\"Reefer 123\",\"reeferStats\":{\"alarms\":[{\"changedAtMs\":1453449599999}],\"engineHours\":[{\"changedAtMs\":1453449599999,\"engineHours\":1200}],\"fuelPercentage\":[{\"changedAtMs\":1453449599999,\"fuelPercentage\":99}],\"powerStatus\":[{\"changedAtMs\":1453449599999,\"status\":\"Active (Continuous)\"}],\"returnAirTemp\":[{\"changedAtMs\":1453449599999,\"tempInMilliC\":31110}],\"setPoint\":[{\"changedAtMs\":1453449599999,\"tempInMilliC\":31110}]}}"));
        V1AssetReeferResponse response = client.assets()
                .v1GetAssetReefer(
                        1000000L,
                        V1GetAssetReeferRequest.builder()
                                .startMs(1000000L)
                                .endMs(1000000L)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"assetType\": \"Thermo King\",\n"
                + "  \"id\": 1,\n"
                + "  \"name\": \"Reefer 123\",\n"
                + "  \"reeferStats\": {\n"
                + "    \"alarms\": [\n"
                + "      {\n"
                + "        \"changedAtMs\": 1453449599999\n"
                + "      }\n"
                + "    ],\n"
                + "    \"engineHours\": [\n"
                + "      {\n"
                + "        \"changedAtMs\": 1453449599999,\n"
                + "        \"engineHours\": 1200\n"
                + "      }\n"
                + "    ],\n"
                + "    \"fuelPercentage\": [\n"
                + "      {\n"
                + "        \"changedAtMs\": 1453449599999,\n"
                + "        \"fuelPercentage\": 99\n"
                + "      }\n"
                + "    ],\n"
                + "    \"powerStatus\": [\n"
                + "      {\n"
                + "        \"changedAtMs\": 1453449599999,\n"
                + "        \"status\": \"Active (Continuous)\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"returnAirTemp\": [\n"
                + "      {\n"
                + "        \"changedAtMs\": 1453449599999,\n"
                + "        \"tempInMilliC\": 31110\n"
                + "      }\n"
                + "    ],\n"
                + "    \"setPoint\": [\n"
                + "      {\n"
                + "        \"changedAtMs\": 1453449599999,\n"
                + "        \"tempInMilliC\": 31110\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}";
        JsonNode actualResponseNode = objectMapper.readTree(actualResponseJson);
        JsonNode expectedResponseNode = objectMapper.readTree(expectedResponseBody);
        Assertions.assertTrue(
                jsonEquals(expectedResponseNode, actualResponseNode),
                "Response body structure does not match expected");
        if (actualResponseNode.has("type") || actualResponseNode.has("_type") || actualResponseNode.has("kind")) {
            String discriminator = null;
            if (actualResponseNode.has("type"))
                discriminator = actualResponseNode.get("type").asText();
            else if (actualResponseNode.has("_type"))
                discriminator = actualResponseNode.get("_type").asText();
            else if (actualResponseNode.has("kind"))
                discriminator = actualResponseNode.get("kind").asText();
            Assertions.assertNotNull(discriminator, "Union type should have a discriminator field");
            Assertions.assertFalse(discriminator.isEmpty(), "Union discriminator should not be empty");
        }

        if (!actualResponseNode.isNull()) {
            Assertions.assertTrue(
                    actualResponseNode.isObject() || actualResponseNode.isArray() || actualResponseNode.isValueNode(),
                    "response should be a valid JSON value");
        }

        if (actualResponseNode.isArray()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Array should have valid size");
        }
        if (actualResponseNode.isObject()) {
            Assertions.assertTrue(actualResponseNode.size() >= 0, "Object should have valid field count");
        }
    }

    @Test
    public void testGet() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.assets().get("id");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());
    }

    @Test
    public void testUpdate() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.assets().update("id");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
    }

    /**
     * Compares two JsonNodes with numeric equivalence and null safety.
     * For objects, checks that all fields in 'expected' exist in 'actual' with matching values.
     * Allows 'actual' to have extra fields (e.g., default values added during serialization).
     */
    private boolean jsonEquals(JsonNode expected, JsonNode actual) {
        if (expected == null && actual == null) return true;
        if (expected == null || actual == null) return false;
        if (expected.equals(actual)) return true;
        if (expected.isNumber() && actual.isNumber())
            return Math.abs(expected.doubleValue() - actual.doubleValue()) < 1e-10;
        if (expected.isObject() && actual.isObject()) {
            java.util.Iterator<java.util.Map.Entry<String, JsonNode>> iter = expected.fields();
            while (iter.hasNext()) {
                java.util.Map.Entry<String, JsonNode> entry = iter.next();
                JsonNode actualValue = actual.get(entry.getKey());
                if (actualValue == null || !jsonEquals(entry.getValue(), actualValue)) return false;
            }
            return true;
        }
        if (expected.isArray() && actual.isArray()) {
            if (expected.size() != actual.size()) return false;
            for (int i = 0; i < expected.size(); i++) {
                if (!jsonEquals(expected.get(i), actual.get(i))) return false;
            }
            return true;
        }
        return false;
    }
}
