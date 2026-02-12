package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.maintenance.requests.CreateDvirRequest;
import com.samsara.api.resources.maintenance.requests.DefectPatch;
import com.samsara.api.resources.maintenance.requests.GetDefectRequest;
import com.samsara.api.resources.maintenance.requests.GetDefectTypesRequest;
import com.samsara.api.resources.maintenance.requests.GetDvirRequest;
import com.samsara.api.resources.maintenance.requests.GetDvirsRequest;
import com.samsara.api.resources.maintenance.requests.StreamDefectsRequest;
import com.samsara.api.resources.maintenance.requests.UpdateDvirRequest;
import com.samsara.api.resources.maintenance.types.CreateDvirRequestSafetyStatus;
import com.samsara.api.types.DefectResponse;
import com.samsara.api.types.DvirDefectGetDefectResponseBody;
import com.samsara.api.types.DvirDefectStreamDefectsResponseBody;
import com.samsara.api.types.DvirDefectTypeGetDefectTypesResponseBody;
import com.samsara.api.types.DvirGetDvirResponseBody;
import com.samsara.api.types.DvirGetDvirsResponseBody;
import com.samsara.api.types.DvirResponse;
import com.samsara.api.types.InlineResponse2004;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaintenanceWireTest {
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
    public void testGetDefectTypes() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"id\":\"25d6151e-29b5-453e-875a-7c5425332e09\",\"label\":\"Air Compressor\",\"sectionType\":\"exteriorFront\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DvirDefectTypeGetDefectTypesResponseBody response = client.maintenance()
                .getDefectTypes(GetDefectTypesRequest.builder().build());
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
                + "      \"createdAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "      \"id\": \"25d6151e-29b5-453e-875a-7c5425332e09\",\n"
                + "      \"label\": \"Air Compressor\",\n"
                + "      \"sectionType\": \"exteriorFront\"\n"
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
    public void testStreamDefects() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"comment\":\"Engine failure.\",\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"defectPhotos\":[{\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"url\":\"https://s3.samsara.com/samsara-driver-media-upload/defect-photo-path\"}],\"defectTypeId\":\"25d6151e-29b5-453e-875a-7c5425332e09\",\"dvirId\":\"292371177\",\"id\":\"9700544\",\"isResolved\":true,\"mechanicNotes\":\"Broken passenger side window.\",\"resolvedAtTime\":\"2020-01-27T07:06:25Z\",\"resolvedBy\":{\"id\":\"8172\",\"name\":\"Jane Mechanic\",\"type\":\"driver\"},\"trailer\":{\"id\":\"494123\"},\"updatedAtTime\":\"2020-01-27T07:06:25Z\",\"vehicle\":{\"id\":\"494125\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DvirDefectStreamDefectsResponseBody response = client.maintenance()
                .streamDefects(
                        StreamDefectsRequest.builder().startTime("startTime").build());
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
                + "      \"comment\": \"Engine failure.\",\n"
                + "      \"createdAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "      \"defectPhotos\": [\n"
                + "        {\n"
                + "          \"createdAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "          \"url\": \"https://s3.samsara.com/samsara-driver-media-upload/defect-photo-path\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"defectTypeId\": \"25d6151e-29b5-453e-875a-7c5425332e09\",\n"
                + "      \"dvirId\": \"292371177\",\n"
                + "      \"id\": \"9700544\",\n"
                + "      \"isResolved\": true,\n"
                + "      \"mechanicNotes\": \"Broken passenger side window.\",\n"
                + "      \"resolvedAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "      \"resolvedBy\": {\n"
                + "        \"id\": \"8172\",\n"
                + "        \"name\": \"Jane Mechanic\",\n"
                + "        \"type\": \"driver\"\n"
                + "      },\n"
                + "      \"trailer\": {\n"
                + "        \"id\": \"494123\"\n"
                + "      },\n"
                + "      \"updatedAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "      \"vehicle\": {\n"
                + "        \"id\": \"494125\"\n"
                + "      }\n"
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
    public void testGetDefect() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"comment\":\"Engine failure.\",\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"defectPhotos\":[{\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"url\":\"https://s3.samsara.com/samsara-driver-media-upload/defect-photo-path\"}],\"defectTypeId\":\"25d6151e-29b5-453e-875a-7c5425332e09\",\"dvirId\":\"292371177\",\"id\":\"9700544\",\"isResolved\":true,\"mechanicNotes\":\"Broken passenger side window.\",\"resolvedAtTime\":\"2020-01-27T07:06:25Z\",\"resolvedBy\":{\"id\":\"8172\",\"name\":\"Jane Mechanic\",\"type\":\"driver\"},\"trailer\":{\"externalIds\":{\"key\":\"value\"},\"id\":\"494123\"},\"updatedAtTime\":\"2020-01-27T07:06:25Z\",\"vehicle\":{\"externalIds\":{\"key\":\"value\"},\"id\":\"494125\"}}"));
        DvirDefectGetDefectResponseBody response =
                client.maintenance().getDefect("id", GetDefectRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"comment\": \"Engine failure.\",\n"
                + "  \"createdAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "  \"defectPhotos\": [\n"
                + "    {\n"
                + "      \"createdAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "      \"url\": \"https://s3.samsara.com/samsara-driver-media-upload/defect-photo-path\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"defectTypeId\": \"25d6151e-29b5-453e-875a-7c5425332e09\",\n"
                + "  \"dvirId\": \"292371177\",\n"
                + "  \"id\": \"9700544\",\n"
                + "  \"isResolved\": true,\n"
                + "  \"mechanicNotes\": \"Broken passenger side window.\",\n"
                + "  \"resolvedAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "  \"resolvedBy\": {\n"
                + "    \"id\": \"8172\",\n"
                + "    \"name\": \"Jane Mechanic\",\n"
                + "    \"type\": \"driver\"\n"
                + "  },\n"
                + "  \"trailer\": {\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"id\": \"494123\"\n"
                + "  },\n"
                + "  \"updatedAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "  \"vehicle\": {\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"id\": \"494125\"\n"
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
    public void testGetDvirs() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource("/wire-tests/MaintenanceWireTest_testGetDvirs_response.json")));
        DvirGetDvirsResponseBody response = client.maintenance()
                .getDvirs(GetDvirsRequest.builder().startTime("startTime").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/MaintenanceWireTest_testGetDvirs_response.json");
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
    public void testGetDvir() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource("/wire-tests/MaintenanceWireTest_testGetDvir_response.json")));
        DvirGetDvirResponseBody response =
                client.maintenance().getDvir("id", GetDvirRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/MaintenanceWireTest_testGetDvir_response.json");
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
    public void testUpdateDvirDefect() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"comment\":\"Air Compressor not working\",\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"defectType\":\"Air Compressor\",\"id\":\"18\",\"isResolved\":true,\"mechanicNotes\":\"Extremely large oddly shaped hole in passenger side window.\",\"mechanicNotesUpdatedAtTime\":\"2020-01-27T07:06:25Z\",\"resolvedAtTime\":\"2020-01-27T07:06:25Z\",\"resolvedBy\":{\"id\":\"11\",\"name\":\"Christopher 'The Handyman' Zhen\",\"type\":\"driver\"},\"trailer\":{\"id\":\"123456789\",\"name\":\"Midwest Trailer #5\"},\"vehicle\":{\"ExternalIds\":{\"maintenanceId\":\"250020\",\"payrollId\":\"ABFS18600\"},\"id\":\"123456789\",\"name\":\"Midwest Truck #4\"}}}"));
        DefectResponse response = client.maintenance()
                .updateDvirDefect("id", DefectPatch.builder().build());
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
                + "    \"comment\": \"Air Compressor not working\",\n"
                + "    \"createdAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "    \"defectType\": \"Air Compressor\",\n"
                + "    \"id\": \"18\",\n"
                + "    \"isResolved\": true,\n"
                + "    \"mechanicNotes\": \"Extremely large oddly shaped hole in passenger side window.\",\n"
                + "    \"mechanicNotesUpdatedAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "    \"resolvedAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "    \"resolvedBy\": {\n"
                + "      \"id\": \"11\",\n"
                + "      \"name\": \"Christopher 'The Handyman' Zhen\",\n"
                + "      \"type\": \"driver\"\n"
                + "    },\n"
                + "    \"trailer\": {\n"
                + "      \"id\": \"123456789\",\n"
                + "      \"name\": \"Midwest Trailer #5\"\n"
                + "    },\n"
                + "    \"vehicle\": {\n"
                + "      \"ExternalIds\": {\n"
                + "        \"maintenanceId\": \"250020\",\n"
                + "        \"payrollId\": \"ABFS18600\"\n"
                + "      },\n"
                + "      \"id\": \"123456789\",\n"
                + "      \"name\": \"Midwest Truck #4\"\n"
                + "    }\n"
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
    public void testCreateDvir() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource("/wire-tests/MaintenanceWireTest_testCreateDvir_response.json")));
        DvirResponse response = client.maintenance()
                .createDvir(CreateDvirRequest.builder()
                        .authorId("11")
                        .safetyStatus(CreateDvirRequestSafetyStatus.SAFE)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"authorId\": \"11\",\n"
                + "  \"safetyStatus\": \"safe\",\n"
                + "  \"type\": \"mechanic\"\n"
                + "}";
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
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/MaintenanceWireTest_testCreateDvir_response.json");
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
    public void testUpdateDvir() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource("/wire-tests/MaintenanceWireTest_testUpdateDvir_response.json")));
        DvirResponse response = client.maintenance()
                .updateDvir(
                        "id",
                        UpdateDvirRequest.builder()
                                .authorId("11")
                                .isResolved(true)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"authorId\": \"11\",\n" + "  \"isResolved\": true\n" + "}";
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
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/MaintenanceWireTest_testUpdateDvir_response.json");
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
    public void testV1GetFleetMaintenanceList() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{\"vehicles\":[{\"id\":112}]}"));
        InlineResponse2004 response = client.maintenance().v1GetFleetMaintenanceList();
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                "" + "{\n" + "  \"vehicles\": [\n" + "    {\n" + "      \"id\": 112\n" + "    }\n" + "  ]\n" + "}";
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
