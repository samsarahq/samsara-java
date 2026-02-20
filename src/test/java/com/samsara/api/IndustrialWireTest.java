package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.industrial.requests.AssetCreate;
import com.samsara.api.resources.industrial.requests.AssetDataOutputsPatchAssetDataOutputsRequestBody;
import com.samsara.api.resources.industrial.requests.AssetPatch;
import com.samsara.api.resources.industrial.requests.GetDataInputDataFeedRequest;
import com.samsara.api.resources.industrial.requests.GetDataInputDataHistoryRequest;
import com.samsara.api.resources.industrial.requests.GetDataInputDataSnapshotRequest;
import com.samsara.api.resources.industrial.requests.GetDataInputsRequest;
import com.samsara.api.resources.industrial.requests.GetIndustrialAssetsRequest;
import com.samsara.api.resources.industrial.requests.GetVisionRunsByCameraRequest;
import com.samsara.api.resources.industrial.requests.InlineObject3;
import com.samsara.api.resources.industrial.requests.V1GetVisionLatestRunCameraRequest;
import com.samsara.api.resources.industrial.requests.V1GetVisionRunsByCameraAndProgramRequest;
import com.samsara.api.resources.industrial.requests.V1GetVisionRunsRequest;
import com.samsara.api.types.AssetDataOutputsPatchAssetDataOutputsResponseBody;
import com.samsara.api.types.DataInputListResponse;
import com.samsara.api.types.DataInputSnapshotResponse;
import com.samsara.api.types.DataInputsTinyResponse;
import com.samsara.api.types.InlineResponse200;
import com.samsara.api.types.InlineResponse2008;
import com.samsara.api.types.ListIndustrialAssetsResponse;
import com.samsara.api.types.V1MachineHistoryResponse;
import com.samsara.api.types.V1ProgramsForTheCameraResponseItem;
import com.samsara.api.types.V1VisionCamerasResponseItem;
import com.samsara.api.types.V1VisionRunByCameraResponse;
import com.samsara.api.types.V1VisionRunsByCameraAndProgramResponse;
import com.samsara.api.types.V1VisionRunsByCameraResponseItem;
import com.samsara.api.types.V1VisionRunsResponse;
import java.util.HashMap;
import java.util.List;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IndustrialWireTest {
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
    public void testGetIndustrialAssets() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"customMetadata\":{\"manufacturer\":\"Samsara\",\"serialNumber\":\"123ABC\"},\"dataOutputs\":[{\"dataGroup\":\"Control Pressure\",\"deviceId\":\"123\",\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\"name\":\"Digital Output 1\"}],\"id\":\"123abcde-4567-8910-1112-fghi1314jklm\",\"isRunning\":true,\"location\":{\"formattedAddress\":\"350 Rhode Island St, San Francisco CA, 94103\",\"latitude\":37.765363,\"longitude\":-122.403098},\"locationDataInput\":{\"id\":\"id\"},\"locationType\":\"point\",\"name\":\"name\",\"parentAsset\":{\"id\":\"123abcde-4567-8910-1112-fghi1314jklm\",\"name\":\"name\"},\"runningStatusDataInput\":{\"id\":\"12345\"},\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}]}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        ListIndustrialAssetsResponse response = client.industrial()
                .getIndustrialAssets(GetIndustrialAssetsRequest.builder().build());
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
                + "      \"customMetadata\": {\n"
                + "        \"manufacturer\": \"Samsara\",\n"
                + "        \"serialNumber\": \"123ABC\"\n"
                + "      },\n"
                + "      \"dataOutputs\": [\n"
                + "        {\n"
                + "          \"dataGroup\": \"Control Pressure\",\n"
                + "          \"deviceId\": \"123\",\n"
                + "          \"id\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n"
                + "          \"name\": \"Digital Output 1\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"id\": \"123abcde-4567-8910-1112-fghi1314jklm\",\n"
                + "      \"isRunning\": true,\n"
                + "      \"location\": {\n"
                + "        \"formattedAddress\": \"350 Rhode Island St, San Francisco CA, 94103\",\n"
                + "        \"latitude\": 37.765363,\n"
                + "        \"longitude\": -122.403098\n"
                + "      },\n"
                + "      \"locationDataInput\": {\n"
                + "        \"id\": \"id\"\n"
                + "      },\n"
                + "      \"locationType\": \"point\",\n"
                + "      \"name\": \"name\",\n"
                + "      \"parentAsset\": {\n"
                + "        \"id\": \"123abcde-4567-8910-1112-fghi1314jklm\",\n"
                + "        \"name\": \"name\"\n"
                + "      },\n"
                + "      \"runningStatusDataInput\": {\n"
                + "        \"id\": \"12345\"\n"
                + "      },\n"
                + "      \"tags\": [\n"
                + "        {\n"
                + "          \"id\": \"3914\",\n"
                + "          \"name\": \"East Coast\",\n"
                + "          \"parentTagId\": \"4815\"\n"
                + "        }\n"
                + "      ]\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"MjkY\",\n"
                + "    \"hasNextPage\": true\n"
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
    public void testCreateIndustrialAsset() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"customMetadata\":{\"manufacturer\":\"Samsara\",\"serialNumber\":\"123ABC\"},\"dataOutputs\":[{\"dataGroup\":\"Control Pressure\",\"deviceId\":\"123\",\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\"name\":\"Digital Output 1\"}],\"id\":\"123abcde-4567-8910-1112-fghi1314jklm\",\"isRunning\":true,\"location\":{\"formattedAddress\":\"350 Rhode Island St, San Francisco CA, 94103\",\"latitude\":37.765363,\"longitude\":-122.403098},\"locationDataInput\":{\"id\":\"id\"},\"locationType\":\"point\",\"name\":\"name\",\"parentAsset\":{\"id\":\"123abcde-4567-8910-1112-fghi1314jklm\",\"name\":\"name\"},\"runningStatusDataInput\":{\"id\":\"12345\"},\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}]}}"));
        InlineResponse200 response = client.industrial()
                .createIndustrialAsset(AssetCreate.builder().name("name").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"name\": \"name\"\n" + "}";
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
                + "    \"customMetadata\": {\n"
                + "      \"manufacturer\": \"Samsara\",\n"
                + "      \"serialNumber\": \"123ABC\"\n"
                + "    },\n"
                + "    \"dataOutputs\": [\n"
                + "      {\n"
                + "        \"dataGroup\": \"Control Pressure\",\n"
                + "        \"deviceId\": \"123\",\n"
                + "        \"id\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n"
                + "        \"name\": \"Digital Output 1\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"id\": \"123abcde-4567-8910-1112-fghi1314jklm\",\n"
                + "    \"isRunning\": true,\n"
                + "    \"location\": {\n"
                + "      \"formattedAddress\": \"350 Rhode Island St, San Francisco CA, 94103\",\n"
                + "      \"latitude\": 37.765363,\n"
                + "      \"longitude\": -122.403098\n"
                + "    },\n"
                + "    \"locationDataInput\": {\n"
                + "      \"id\": \"id\"\n"
                + "    },\n"
                + "    \"locationType\": \"point\",\n"
                + "    \"name\": \"name\",\n"
                + "    \"parentAsset\": {\n"
                + "      \"id\": \"123abcde-4567-8910-1112-fghi1314jklm\",\n"
                + "      \"name\": \"name\"\n"
                + "    },\n"
                + "    \"runningStatusDataInput\": {\n"
                + "      \"id\": \"12345\"\n"
                + "    },\n"
                + "    \"tags\": [\n"
                + "      {\n"
                + "        \"id\": \"3914\",\n"
                + "        \"name\": \"East Coast\",\n"
                + "        \"parentTagId\": \"4815\"\n"
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
    public void testPatchIndustrialAsset() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"customMetadata\":{\"manufacturer\":\"Samsara\",\"serialNumber\":\"123ABC\"},\"dataOutputs\":[{\"dataGroup\":\"Control Pressure\",\"deviceId\":\"123\",\"id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\"name\":\"Digital Output 1\"}],\"id\":\"123abcde-4567-8910-1112-fghi1314jklm\",\"isRunning\":true,\"location\":{\"formattedAddress\":\"350 Rhode Island St, San Francisco CA, 94103\",\"latitude\":37.765363,\"longitude\":-122.403098},\"locationDataInput\":{\"id\":\"id\"},\"locationType\":\"point\",\"name\":\"name\",\"parentAsset\":{\"id\":\"123abcde-4567-8910-1112-fghi1314jklm\",\"name\":\"name\"},\"runningStatusDataInput\":{\"id\":\"12345\"},\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}]}}"));
        InlineResponse200 response = client.industrial()
                .patchIndustrialAsset("id", AssetPatch.builder().build());
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
                + "    \"customMetadata\": {\n"
                + "      \"manufacturer\": \"Samsara\",\n"
                + "      \"serialNumber\": \"123ABC\"\n"
                + "    },\n"
                + "    \"dataOutputs\": [\n"
                + "      {\n"
                + "        \"dataGroup\": \"Control Pressure\",\n"
                + "        \"deviceId\": \"123\",\n"
                + "        \"id\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n"
                + "        \"name\": \"Digital Output 1\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"id\": \"123abcde-4567-8910-1112-fghi1314jklm\",\n"
                + "    \"isRunning\": true,\n"
                + "    \"location\": {\n"
                + "      \"formattedAddress\": \"350 Rhode Island St, San Francisco CA, 94103\",\n"
                + "      \"latitude\": 37.765363,\n"
                + "      \"longitude\": -122.403098\n"
                + "    },\n"
                + "    \"locationDataInput\": {\n"
                + "      \"id\": \"id\"\n"
                + "    },\n"
                + "    \"locationType\": \"point\",\n"
                + "    \"name\": \"name\",\n"
                + "    \"parentAsset\": {\n"
                + "      \"id\": \"123abcde-4567-8910-1112-fghi1314jklm\",\n"
                + "      \"name\": \"name\"\n"
                + "    },\n"
                + "    \"runningStatusDataInput\": {\n"
                + "      \"id\": \"12345\"\n"
                + "    },\n"
                + "    \"tags\": [\n"
                + "      {\n"
                + "        \"id\": \"3914\",\n"
                + "        \"name\": \"East Coast\",\n"
                + "        \"parentTagId\": \"4815\"\n"
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
    public void testPatchAssetDataOutputs() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"errorMessage\":\"Failed to write to Device: GFRV-43N-VGX\",\"id\":\"8a9371af-82d1-4158-bf91-4ecc8d3a114c\",\"statusCode\":200}]}"));
        AssetDataOutputsPatchAssetDataOutputsResponseBody response = client.industrial()
                .patchAssetDataOutputs(
                        "id",
                        AssetDataOutputsPatchAssetDataOutputsRequestBody.builder()
                                .values(new HashMap<String, Object>() {
                                    {
                                        put("key", "value");
                                    }
                                })
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"values\": {\n" + "    \"key\": \"value\"\n" + "  }\n" + "}";
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
                + "  \"data\": [\n"
                + "    {\n"
                + "      \"errorMessage\": \"Failed to write to Device: GFRV-43N-VGX\",\n"
                + "      \"id\": \"8a9371af-82d1-4158-bf91-4ecc8d3a114c\",\n"
                + "      \"statusCode\": 200\n"
                + "    }\n"
                + "  ]\n"
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
    public void testGetDataInputs() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"assetId\":\"74771078-5edb-4733-88f2-7242f520d1f1\",\"dataGroup\":\"Flow\",\"id\":\"id\",\"name\":\"Pump Flow\",\"units\":\"Gallons Per Minute\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DataInputsTinyResponse response =
                client.industrial().getDataInputs(GetDataInputsRequest.builder().build());
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
                + "      \"assetId\": \"74771078-5edb-4733-88f2-7242f520d1f1\",\n"
                + "      \"dataGroup\": \"Flow\",\n"
                + "      \"id\": \"id\",\n"
                + "      \"name\": \"Pump Flow\",\n"
                + "      \"units\": \"Gallons Per Minute\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"MjkY\",\n"
                + "    \"hasNextPage\": true\n"
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
    public void testGetDataInputDataSnapshot() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"fftSpectraPoint\":{\"time\":\"2020-01-27T07:06:25Z\"},\"j1939D1StatusPoint\":{\"time\":\"2020-01-27T07:06:25Z\"},\"locationPoint\":{\"time\":\"2020-01-27T07:06:25Z\"},\"numberPoint\":{\"time\":\"2020-01-27T07:06:25Z\",\"value\":1992.0506},\"stringPoint\":{\"time\":\"2020-01-27T07:06:25Z\",\"value\":\"On\"},\"assetId\":\"74771078-5edb-4733-88f2-7242f520d1f1\",\"dataGroup\":\"Flow\",\"id\":\"id\",\"name\":\"Pump Flow\",\"units\":\"Gallons Per Minute\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DataInputSnapshotResponse response = client.industrial()
                .getDataInputDataSnapshot(
                        GetDataInputDataSnapshotRequest.builder().build());
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
                + "      \"fftSpectraPoint\": {\n"
                + "        \"time\": \"2020-01-27T07:06:25Z\"\n"
                + "      },\n"
                + "      \"j1939D1StatusPoint\": {\n"
                + "        \"time\": \"2020-01-27T07:06:25Z\"\n"
                + "      },\n"
                + "      \"locationPoint\": {\n"
                + "        \"time\": \"2020-01-27T07:06:25Z\"\n"
                + "      },\n"
                + "      \"numberPoint\": {\n"
                + "        \"time\": \"2020-01-27T07:06:25Z\",\n"
                + "        \"value\": 1992.0506\n"
                + "      },\n"
                + "      \"stringPoint\": {\n"
                + "        \"time\": \"2020-01-27T07:06:25Z\",\n"
                + "        \"value\": \"On\"\n"
                + "      },\n"
                + "      \"assetId\": \"74771078-5edb-4733-88f2-7242f520d1f1\",\n"
                + "      \"dataGroup\": \"Flow\",\n"
                + "      \"id\": \"id\",\n"
                + "      \"name\": \"Pump Flow\",\n"
                + "      \"units\": \"Gallons Per Minute\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"MjkY\",\n"
                + "    \"hasNextPage\": true\n"
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
    public void testGetDataInputDataFeed() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"fftSpectraPoints\":[{\"time\":\"2020-01-27T07:06:25Z\"}],\"j1939D1StatusPoints\":[{\"time\":\"2020-01-27T07:06:25Z\"}],\"locationPoints\":[{\"time\":\"2020-01-27T07:06:25Z\"}],\"numberPoints\":[{\"time\":\"2020-01-27T07:06:25Z\",\"value\":1992.0506}],\"stringPoints\":[{\"time\":\"2020-01-27T07:06:25Z\",\"value\":\"On\"}],\"assetId\":\"74771078-5edb-4733-88f2-7242f520d1f1\",\"dataGroup\":\"Flow\",\"id\":\"id\",\"name\":\"Pump Flow\",\"units\":\"Gallons Per Minute\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DataInputListResponse response = client.industrial()
                .getDataInputDataFeed(GetDataInputDataFeedRequest.builder().build());
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
                + "      \"fftSpectraPoints\": [\n"
                + "        {\n"
                + "          \"time\": \"2020-01-27T07:06:25Z\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"j1939D1StatusPoints\": [\n"
                + "        {\n"
                + "          \"time\": \"2020-01-27T07:06:25Z\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"locationPoints\": [\n"
                + "        {\n"
                + "          \"time\": \"2020-01-27T07:06:25Z\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"numberPoints\": [\n"
                + "        {\n"
                + "          \"time\": \"2020-01-27T07:06:25Z\",\n"
                + "          \"value\": 1992.0506\n"
                + "        }\n"
                + "      ],\n"
                + "      \"stringPoints\": [\n"
                + "        {\n"
                + "          \"time\": \"2020-01-27T07:06:25Z\",\n"
                + "          \"value\": \"On\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"assetId\": \"74771078-5edb-4733-88f2-7242f520d1f1\",\n"
                + "      \"dataGroup\": \"Flow\",\n"
                + "      \"id\": \"id\",\n"
                + "      \"name\": \"Pump Flow\",\n"
                + "      \"units\": \"Gallons Per Minute\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"MjkY\",\n"
                + "    \"hasNextPage\": true\n"
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
    public void testGetDataInputDataHistory() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"fftSpectraPoints\":[{\"time\":\"2020-01-27T07:06:25Z\"}],\"j1939D1StatusPoints\":[{\"time\":\"2020-01-27T07:06:25Z\"}],\"locationPoints\":[{\"time\":\"2020-01-27T07:06:25Z\"}],\"numberPoints\":[{\"time\":\"2020-01-27T07:06:25Z\",\"value\":1992.0506}],\"stringPoints\":[{\"time\":\"2020-01-27T07:06:25Z\",\"value\":\"On\"}],\"assetId\":\"74771078-5edb-4733-88f2-7242f520d1f1\",\"dataGroup\":\"Flow\",\"id\":\"id\",\"name\":\"Pump Flow\",\"units\":\"Gallons Per Minute\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DataInputListResponse response = client.industrial()
                .getDataInputDataHistory(GetDataInputDataHistoryRequest.builder()
                        .startTime("startTime")
                        .endTime("endTime")
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
                + "      \"fftSpectraPoints\": [\n"
                + "        {\n"
                + "          \"time\": \"2020-01-27T07:06:25Z\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"j1939D1StatusPoints\": [\n"
                + "        {\n"
                + "          \"time\": \"2020-01-27T07:06:25Z\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"locationPoints\": [\n"
                + "        {\n"
                + "          \"time\": \"2020-01-27T07:06:25Z\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"numberPoints\": [\n"
                + "        {\n"
                + "          \"time\": \"2020-01-27T07:06:25Z\",\n"
                + "          \"value\": 1992.0506\n"
                + "        }\n"
                + "      ],\n"
                + "      \"stringPoints\": [\n"
                + "        {\n"
                + "          \"time\": \"2020-01-27T07:06:25Z\",\n"
                + "          \"value\": \"On\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"assetId\": \"74771078-5edb-4733-88f2-7242f520d1f1\",\n"
                + "      \"dataGroup\": \"Flow\",\n"
                + "      \"id\": \"id\",\n"
                + "      \"name\": \"Pump Flow\",\n"
                + "      \"units\": \"Gallons Per Minute\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"MjkY\",\n"
                + "    \"hasNextPage\": true\n"
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
    public void testV1GetCameras() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"cameraId\":1234512345999,\"cameraName\":\"Line 32\",\"ethernetIp\":\"10.1.2.34\",\"wifiIp\":\"10.1.2.35\"}]"));
        List<V1VisionCamerasResponseItem> response = client.industrial().v1GetCameras();
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "[\n"
                + "  {\n"
                + "    \"cameraId\": 1234512345999,\n"
                + "    \"cameraName\": \"Line 32\",\n"
                + "    \"ethernetIp\": \"10.1.2.34\",\n"
                + "    \"wifiIp\": \"10.1.2.35\"\n"
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
    public void testV1GetVisionProgramsByCamera() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("[{\"programId\":1,\"programName\":\"Barcode verification program\"}]"));
        List<V1ProgramsForTheCameraResponseItem> response = client.industrial().v1GetVisionProgramsByCamera(1000000L);
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "[\n"
                + "  {\n"
                + "    \"programId\": 1,\n"
                + "    \"programName\": \"Barcode verification program\"\n"
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
    public void testV1GetVisionLatestRunCamera() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"cameraId\":1234512345123,\"endedAtMs\":0,\"inspectionResults\":[{\"captureAtMs\":1553811994730,\"result\":\"PASS\",\"stepResults\":[{\"name\":\"Chicken Caesar Label\",\"result\":\"PASS\"}]}],\"isOngoing\":true,\"program\":{\"id\":1,\"name\":\"Barcode verification program\"},\"runSummary\":{\"itemsPerMinute\":0.1,\"noReadCount\":0,\"rejectCount\":0,\"successCount\":181},\"startedAtMs\":1553808606097}"));
        V1VisionRunByCameraResponse response = client.industrial()
                .v1GetVisionLatestRunCamera(
                        1000000L, V1GetVisionLatestRunCameraRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"cameraId\": 1234512345123,\n"
                + "  \"endedAtMs\": 0,\n"
                + "  \"inspectionResults\": [\n"
                + "    {\n"
                + "      \"captureAtMs\": 1553811994730,\n"
                + "      \"result\": \"PASS\",\n"
                + "      \"stepResults\": [\n"
                + "        {\n"
                + "          \"name\": \"Chicken Caesar Label\",\n"
                + "          \"result\": \"PASS\"\n"
                + "        }\n"
                + "      ]\n"
                + "    }\n"
                + "  ],\n"
                + "  \"isOngoing\": true,\n"
                + "  \"program\": {\n"
                + "    \"id\": 1,\n"
                + "    \"name\": \"Barcode verification program\"\n"
                + "  },\n"
                + "  \"runSummary\": {\n"
                + "    \"itemsPerMinute\": 0.1,\n"
                + "    \"noReadCount\": 0,\n"
                + "    \"rejectCount\": 0,\n"
                + "    \"successCount\": 181\n"
                + "  },\n"
                + "  \"startedAtMs\": 1553808606097\n"
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
    public void testV1GetVisionRuns() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"visionRuns\":[{\"deviceId\":1234512345123,\"endedAtMs\":0,\"programId\":1,\"reportMetadata\":{\"itemsPerMinute\":0.1,\"noReadCount\":181,\"rejectCount\":0,\"successCount\":181},\"startedAtMs\":1553808606097}]}"));
        V1VisionRunsResponse response = client.industrial()
                .v1GetVisionRuns(
                        V1GetVisionRunsRequest.builder().durationMs(1000000L).build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"visionRuns\": [\n"
                + "    {\n"
                + "      \"deviceId\": 1234512345123,\n"
                + "      \"endedAtMs\": 0,\n"
                + "      \"programId\": 1,\n"
                + "      \"reportMetadata\": {\n"
                + "        \"itemsPerMinute\": 0.1,\n"
                + "        \"noReadCount\": 181,\n"
                + "        \"rejectCount\": 0,\n"
                + "        \"successCount\": 181\n"
                + "      },\n"
                + "      \"startedAtMs\": 1553808606097\n"
                + "    }\n"
                + "  ]\n"
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
    public void testGetVisionRunsByCamera() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "[{\"deviceId\":1234512345123,\"endedAtMs\":0,\"program\":{\"id\":1,\"name\":\"Barcode verification program\"},\"reportMetadata\":{\"itemsPerMinute\":0.1,\"noReadCount\":0,\"rejectCount\":0,\"successCount\":181},\"startedAtMs\":1553808606097}]"));
        List<V1VisionRunsByCameraResponseItem> response = client.industrial()
                .getVisionRunsByCamera(
                        1000000L,
                        GetVisionRunsByCameraRequest.builder()
                                .durationMs(1000000L)
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
                + "    \"deviceId\": 1234512345123,\n"
                + "    \"endedAtMs\": 0,\n"
                + "    \"program\": {\n"
                + "      \"id\": 1,\n"
                + "      \"name\": \"Barcode verification program\"\n"
                + "    },\n"
                + "    \"reportMetadata\": {\n"
                + "      \"itemsPerMinute\": 0.1,\n"
                + "      \"noReadCount\": 0,\n"
                + "      \"rejectCount\": 0,\n"
                + "      \"successCount\": 181\n"
                + "    },\n"
                + "    \"startedAtMs\": 1553808606097\n"
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
    public void testV1GetVisionRunsByCameraAndProgram() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"deviceId\":1234512345123,\"endedAtMs\":0,\"programId\":1,\"reportMetadata\":{\"itemsPerMinute\":0.1,\"noReadCount\":0,\"rejectCount\":0,\"successCount\":181},\"results\":[{\"captureAtMs\":1553811994730,\"result\":\"PASS\",\"stepResults\":[{\"name\":\"Chicken Caesar Label\",\"result\":\"PASS\"}]}],\"startedAtMs\":1553808606097}"));
        V1VisionRunsByCameraAndProgramResponse response = client.industrial()
                .v1GetVisionRunsByCameraAndProgram(
                        1000000L,
                        1000000L,
                        1000000L,
                        V1GetVisionRunsByCameraAndProgramRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"deviceId\": 1234512345123,\n"
                + "  \"endedAtMs\": 0,\n"
                + "  \"programId\": 1,\n"
                + "  \"reportMetadata\": {\n"
                + "    \"itemsPerMinute\": 0.1,\n"
                + "    \"noReadCount\": 0,\n"
                + "    \"rejectCount\": 0,\n"
                + "    \"successCount\": 181\n"
                + "  },\n"
                + "  \"results\": [\n"
                + "    {\n"
                + "      \"captureAtMs\": 1553811994730,\n"
                + "      \"result\": \"PASS\",\n"
                + "      \"stepResults\": [\n"
                + "        {\n"
                + "          \"name\": \"Chicken Caesar Label\",\n"
                + "          \"result\": \"PASS\"\n"
                + "        }\n"
                + "      ]\n"
                + "    }\n"
                + "  ],\n"
                + "  \"startedAtMs\": 1553808606097\n"
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
    public void testV1GetMachinesHistory() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"machines\":[{\"id\":1,\"name\":\"1/3 HP Motor\",\"vibrations\":[{\"X\":0.01,\"Y\":1.23,\"Z\":2.55,\"time\":1453449599999}]}]}"));
        V1MachineHistoryResponse response = client.industrial()
                .v1GetMachinesHistory(InlineObject3.builder()
                        .endMs(1462881998034L)
                        .startMs(1462878398034L)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody =
                "" + "{\n" + "  \"endMs\": 1462881998034,\n" + "  \"startMs\": 1462878398034\n" + "}";
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
                + "  \"machines\": [\n"
                + "    {\n"
                + "      \"id\": 1,\n"
                + "      \"name\": \"1/3 HP Motor\",\n"
                + "      \"vibrations\": [\n"
                + "        {\n"
                + "          \"X\": 0.01,\n"
                + "          \"Y\": 1.23,\n"
                + "          \"Z\": 2.55,\n"
                + "          \"time\": 1453449599999\n"
                + "        }\n"
                + "      ]\n"
                + "    }\n"
                + "  ]\n"
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
    public void testV1GetMachines() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"machines\":[{\"id\":123,\"name\":\"Freezer ABC\",\"notes\":\"This is in the left hallway behind the conveyor belt\"}]}"));
        InlineResponse2008 response = client.industrial().v1GetMachines();
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"machines\": [\n"
                + "    {\n"
                + "      \"id\": 123,\n"
                + "      \"name\": \"Freezer ABC\",\n"
                + "      \"notes\": \"This is in the left hallway behind the conveyor belt\"\n"
                + "    }\n"
                + "  ]\n"
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
