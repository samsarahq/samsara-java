package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.maintenance.requests.CreateDvirRequest;
import com.samsara.api.resources.maintenance.requests.CreateStockMovementActionServiceCreateStockMovementRequestBody;
import com.samsara.api.resources.maintenance.requests.DefectPatch;
import com.samsara.api.resources.maintenance.requests.DeletePartRequest;
import com.samsara.api.resources.maintenance.requests.DeleteWarrantyClaimRequest;
import com.samsara.api.resources.maintenance.requests.DeleteWarrantyRequest;
import com.samsara.api.resources.maintenance.requests.EntityPartDefinitionsServiceCreatePartRequestBody;
import com.samsara.api.resources.maintenance.requests.EntityPartDefinitionsServiceUpdatePartRequestBody;
import com.samsara.api.resources.maintenance.requests.EntityPartInventoryLocationsServiceCreatePartInventoryLocationRequestBody;
import com.samsara.api.resources.maintenance.requests.EntityPartInventoryLocationsServiceUpdatePartInventoryLocationRequestBody;
import com.samsara.api.resources.maintenance.requests.EntityWarrantiesServiceCreateWarrantyRequestBody;
import com.samsara.api.resources.maintenance.requests.EntityWarrantiesServiceUpdateWarrantyRequestBody;
import com.samsara.api.resources.maintenance.requests.EntityWarrantyClaimsServiceCreateWarrantyClaimRequestBody;
import com.samsara.api.resources.maintenance.requests.EntityWarrantyClaimsServiceUpdateWarrantyClaimRequestBody;
import com.samsara.api.resources.maintenance.requests.GetDefectRequest;
import com.samsara.api.resources.maintenance.requests.GetDefectTypesRequest;
import com.samsara.api.resources.maintenance.requests.GetDvirRequest;
import com.samsara.api.resources.maintenance.requests.GetDvirsRequest;
import com.samsara.api.resources.maintenance.requests.ListPartInventoryRequest;
import com.samsara.api.resources.maintenance.requests.ListPartTransactionsRequest;
import com.samsara.api.resources.maintenance.requests.ListPartsRequest;
import com.samsara.api.resources.maintenance.requests.ListTimeEntriesRequest;
import com.samsara.api.resources.maintenance.requests.ListWarrantiesRequest;
import com.samsara.api.resources.maintenance.requests.ListWarrantyAssetAssignmentsRequest;
import com.samsara.api.resources.maintenance.requests.ListWarrantyClaimsRequest;
import com.samsara.api.resources.maintenance.requests.ReplaceWarrantyAssetAssignmentsActionServiceReplaceWarrantyAssetAssignmentsRequestBody;
import com.samsara.api.resources.maintenance.requests.StreamDefectsRequest;
import com.samsara.api.resources.maintenance.requests.UpdateDvirRequest;
import com.samsara.api.resources.maintenance.types.CreateDvirRequestSafetyStatus;
import com.samsara.api.resources.maintenance.types.CreateDvirRequestType;
import com.samsara.api.types.CreateStockMovementActionServiceCreateStockMovementResponseBody;
import com.samsara.api.types.DefectResponse;
import com.samsara.api.types.DvirDefectGetDefectResponseBody;
import com.samsara.api.types.DvirDefectStreamDefectsResponseBody;
import com.samsara.api.types.DvirDefectTypeGetDefectTypesResponseBody;
import com.samsara.api.types.DvirGetDvirResponseBody;
import com.samsara.api.types.DvirGetDvirsResponseBody;
import com.samsara.api.types.DvirResponse;
import com.samsara.api.types.EntityInventoryTransactionsServiceListPartTransactionsResponseBody;
import com.samsara.api.types.EntityPartDefinitionsServiceCreatePartResponseBody;
import com.samsara.api.types.EntityPartDefinitionsServiceListPartsResponseBody;
import com.samsara.api.types.EntityPartDefinitionsServiceUpdatePartResponseBody;
import com.samsara.api.types.EntityPartInventoryLocationsServiceCreatePartInventoryLocationResponseBody;
import com.samsara.api.types.EntityPartInventoryLocationsServiceListPartInventoryResponseBody;
import com.samsara.api.types.EntityPartInventoryLocationsServiceUpdatePartInventoryLocationResponseBody;
import com.samsara.api.types.EntityTimeEntriesServiceListTimeEntriesResponseBody;
import com.samsara.api.types.EntityWarrantiesServiceCreateWarrantyResponseBody;
import com.samsara.api.types.EntityWarrantiesServiceListWarrantiesResponseBody;
import com.samsara.api.types.EntityWarrantiesServiceUpdateWarrantyResponseBody;
import com.samsara.api.types.EntityWarrantyAssetAssignmentsServiceListWarrantyAssetAssignmentsResponseBody;
import com.samsara.api.types.EntityWarrantyClaimsServiceCreateWarrantyClaimResponseBody;
import com.samsara.api.types.EntityWarrantyClaimsServiceListWarrantyClaimsResponseBody;
import com.samsara.api.types.EntityWarrantyClaimsServiceUpdateWarrantyClaimResponseBody;
import com.samsara.api.types.InlineResponse2004;
import com.samsara.api.types.ReplaceWarrantyAssetAssignmentsActionServiceReplaceWarrantyAssetAssignmentsResponseBody;
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
                                "{\"data\":[{\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"id\":\"25d6151e-29b5-453e-875a-7c5425332e09\",\"label\":\"Air Compressor\",\"sectionType\":\"exteriorFront\",\"severity\":\"major\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
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
                + "      \"sectionType\": \"exteriorFront\",\n"
                + "      \"severity\": \"major\"\n"
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
                                "{\"data\":[{\"comment\":\"Engine failure.\",\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"defectPhotos\":[{\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"url\":\"https://s3.samsara.com/samsara-driver-media-upload/defect-photo-path\"}],\"defectSafetyStatus\":\"safe\",\"defectTypeId\":\"25d6151e-29b5-453e-875a-7c5425332e09\",\"dvirId\":\"292371177\",\"id\":\"9700544\",\"isResolved\":true,\"mechanicNotes\":\"Broken passenger side window.\",\"resolvedAtTime\":\"2020-01-27T07:06:25Z\",\"resolvedBy\":{\"id\":\"8172\",\"name\":\"Jane Mechanic\",\"type\":\"driver\"},\"trailer\":{\"id\":\"494123\"},\"updatedAtTime\":\"2020-01-27T07:06:25Z\",\"vehicle\":{\"id\":\"494125\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
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
                + "      \"defectSafetyStatus\": \"safe\",\n"
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
                                "{\"comment\":\"Engine failure.\",\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"defectPhotos\":[{\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"url\":\"https://s3.samsara.com/samsara-driver-media-upload/defect-photo-path\"}],\"defectSafetyStatus\":\"safe\",\"defectTypeId\":\"25d6151e-29b5-453e-875a-7c5425332e09\",\"dvirId\":\"292371177\",\"id\":\"9700544\",\"isResolved\":true,\"mechanicNotes\":\"Broken passenger side window.\",\"resolvedAtTime\":\"2020-01-27T07:06:25Z\",\"resolvedBy\":{\"id\":\"8172\",\"name\":\"Jane Mechanic\",\"type\":\"driver\"},\"trailer\":{\"externalIds\":{\"key\":\"value\"},\"id\":\"494123\"},\"updatedAtTime\":\"2020-01-27T07:06:25Z\",\"vehicle\":{\"externalIds\":{\"key\":\"value\"},\"id\":\"494125\"}}"));
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
                + "  \"defectSafetyStatus\": \"safe\",\n"
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
                        .type(CreateDvirRequestType.MECHANIC)
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
    public void testListParts() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"archivedAtTime\":\"2019-06-13T19:08:25Z\",\"barcodeString\":\"12345\",\"barcodeType\":\"12345\",\"category\":\"12345\",\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"deletedAtTime\":\"2019-06-13T19:08:25Z\",\"description\":\"12345\",\"externalId\":\"12345\",\"id\":\"12345\",\"isInventoryTracked\":true,\"manufacturerName\":\"12345\",\"manufacturerPartNumber\":\"12345\",\"name\":\"12345\",\"partNumber\":\"12345\",\"partStatus\":\"Unknown\",\"preferredVendor\":{\"id\":\"281474976710656\"},\"preferredVendorPartNumber\":\"12345\",\"subcategory\":\"12345\",\"unitCost\":{\"amount\":\"12345\",\"currency\":\"12345\"},\"unitOfMeasureType\":\"Unknown\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\",\"vmrsCode\":\"12345\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        EntityPartDefinitionsServiceListPartsResponseBody response =
                client.maintenance().listParts(ListPartsRequest.builder().build());
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
                + "      \"archivedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"barcodeString\": \"12345\",\n"
                + "      \"barcodeType\": \"12345\",\n"
                + "      \"category\": \"12345\",\n"
                + "      \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"deletedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"description\": \"12345\",\n"
                + "      \"externalId\": \"12345\",\n"
                + "      \"id\": \"12345\",\n"
                + "      \"isInventoryTracked\": true,\n"
                + "      \"manufacturerName\": \"12345\",\n"
                + "      \"manufacturerPartNumber\": \"12345\",\n"
                + "      \"name\": \"12345\",\n"
                + "      \"partNumber\": \"12345\",\n"
                + "      \"partStatus\": \"Unknown\",\n"
                + "      \"preferredVendor\": {\n"
                + "        \"id\": \"281474976710656\"\n"
                + "      },\n"
                + "      \"preferredVendorPartNumber\": \"12345\",\n"
                + "      \"subcategory\": \"12345\",\n"
                + "      \"unitCost\": {\n"
                + "        \"amount\": \"12345\",\n"
                + "        \"currency\": \"12345\"\n"
                + "      },\n"
                + "      \"unitOfMeasureType\": \"Unknown\",\n"
                + "      \"updatedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"vmrsCode\": \"12345\"\n"
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
    public void testCreatePart() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"archivedAtTime\":\"2019-06-13T19:08:25Z\",\"barcodeString\":\"12345\",\"barcodeType\":\"12345\",\"category\":\"12345\",\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"deletedAtTime\":\"2019-06-13T19:08:25Z\",\"description\":\"12345\",\"externalId\":\"12345\",\"id\":\"12345\",\"isInventoryTracked\":true,\"manufacturerName\":\"12345\",\"manufacturerPartNumber\":\"12345\",\"name\":\"12345\",\"partNumber\":\"12345\",\"partStatus\":\"Unknown\",\"preferredVendor\":{\"id\":\"281474976710656\"},\"preferredVendorPartNumber\":\"12345\",\"subcategory\":\"12345\",\"unitCost\":{\"amount\":\"12345\",\"currency\":\"12345\"},\"unitOfMeasureType\":\"Unknown\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\",\"vmrsCode\":\"12345\"}}"));
        EntityPartDefinitionsServiceCreatePartResponseBody response = client.maintenance()
                .createPart(EntityPartDefinitionsServiceCreatePartRequestBody.builder()
                        .partNumber("12345")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"partNumber\": \"12345\"\n" + "}";
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
                + "    \"archivedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"barcodeString\": \"12345\",\n"
                + "    \"barcodeType\": \"12345\",\n"
                + "    \"category\": \"12345\",\n"
                + "    \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"deletedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"description\": \"12345\",\n"
                + "    \"externalId\": \"12345\",\n"
                + "    \"id\": \"12345\",\n"
                + "    \"isInventoryTracked\": true,\n"
                + "    \"manufacturerName\": \"12345\",\n"
                + "    \"manufacturerPartNumber\": \"12345\",\n"
                + "    \"name\": \"12345\",\n"
                + "    \"partNumber\": \"12345\",\n"
                + "    \"partStatus\": \"Unknown\",\n"
                + "    \"preferredVendor\": {\n"
                + "      \"id\": \"281474976710656\"\n"
                + "    },\n"
                + "    \"preferredVendorPartNumber\": \"12345\",\n"
                + "    \"subcategory\": \"12345\",\n"
                + "    \"unitCost\": {\n"
                + "      \"amount\": \"12345\",\n"
                + "      \"currency\": \"12345\"\n"
                + "    },\n"
                + "    \"unitOfMeasureType\": \"Unknown\",\n"
                + "    \"updatedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"vmrsCode\": \"12345\"\n"
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
    public void testDeletePart() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.maintenance().deletePart(DeletePartRequest.builder().id("id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testUpdatePart() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"archivedAtTime\":\"2019-06-13T19:08:25Z\",\"barcodeString\":\"12345\",\"barcodeType\":\"12345\",\"category\":\"12345\",\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"deletedAtTime\":\"2019-06-13T19:08:25Z\",\"description\":\"12345\",\"externalId\":\"12345\",\"id\":\"12345\",\"isInventoryTracked\":true,\"manufacturerName\":\"12345\",\"manufacturerPartNumber\":\"12345\",\"name\":\"12345\",\"partNumber\":\"12345\",\"partStatus\":\"Unknown\",\"preferredVendor\":{\"id\":\"281474976710656\"},\"preferredVendorPartNumber\":\"12345\",\"subcategory\":\"12345\",\"unitCost\":{\"amount\":\"12345\",\"currency\":\"12345\"},\"unitOfMeasureType\":\"Unknown\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\",\"vmrsCode\":\"12345\"}}"));
        EntityPartDefinitionsServiceUpdatePartResponseBody response = client.maintenance()
                .updatePart(EntityPartDefinitionsServiceUpdatePartRequestBody.builder()
                        .id("id")
                        .build());
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
                + "    \"archivedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"barcodeString\": \"12345\",\n"
                + "    \"barcodeType\": \"12345\",\n"
                + "    \"category\": \"12345\",\n"
                + "    \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"deletedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"description\": \"12345\",\n"
                + "    \"externalId\": \"12345\",\n"
                + "    \"id\": \"12345\",\n"
                + "    \"isInventoryTracked\": true,\n"
                + "    \"manufacturerName\": \"12345\",\n"
                + "    \"manufacturerPartNumber\": \"12345\",\n"
                + "    \"name\": \"12345\",\n"
                + "    \"partNumber\": \"12345\",\n"
                + "    \"partStatus\": \"Unknown\",\n"
                + "    \"preferredVendor\": {\n"
                + "      \"id\": \"281474976710656\"\n"
                + "    },\n"
                + "    \"preferredVendorPartNumber\": \"12345\",\n"
                + "    \"subcategory\": \"12345\",\n"
                + "    \"unitCost\": {\n"
                + "      \"amount\": \"12345\",\n"
                + "      \"currency\": \"12345\"\n"
                + "    },\n"
                + "    \"unitOfMeasureType\": \"Unknown\",\n"
                + "    \"updatedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"vmrsCode\": \"12345\"\n"
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
    public void testListPartInventory() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"aisle\":\"12345\",\"availableQuantity\":123.45,\"bin\":\"12345\",\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"currentQuantity\":123.45,\"isCostTracked\":true,\"isLowStock\":true,\"isNonStock\":true,\"maxStockLevel\":123.45,\"minStockLevel\":123.45,\"partSamsara\":{\"id\":\"281474976710656\"},\"place\":{\"id\":\"281474976710656\"},\"reorderQuantity\":123.45,\"reorderThreshold\":123.45,\"reservedQuantity\":123.45,\"row\":\"12345\",\"unitCost\":{\"amount\":\"12345\",\"currency\":\"12345\"},\"unitOfMeasureType\":\"Unknown\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        EntityPartInventoryLocationsServiceListPartInventoryResponseBody response = client.maintenance()
                .listPartInventory(ListPartInventoryRequest.builder().build());
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
                + "      \"aisle\": \"12345\",\n"
                + "      \"availableQuantity\": 123.45,\n"
                + "      \"bin\": \"12345\",\n"
                + "      \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"currentQuantity\": 123.45,\n"
                + "      \"isCostTracked\": true,\n"
                + "      \"isLowStock\": true,\n"
                + "      \"isNonStock\": true,\n"
                + "      \"maxStockLevel\": 123.45,\n"
                + "      \"minStockLevel\": 123.45,\n"
                + "      \"partSamsara\": {\n"
                + "        \"id\": \"281474976710656\"\n"
                + "      },\n"
                + "      \"place\": {\n"
                + "        \"id\": \"281474976710656\"\n"
                + "      },\n"
                + "      \"reorderQuantity\": 123.45,\n"
                + "      \"reorderThreshold\": 123.45,\n"
                + "      \"reservedQuantity\": 123.45,\n"
                + "      \"row\": \"12345\",\n"
                + "      \"unitCost\": {\n"
                + "        \"amount\": \"12345\",\n"
                + "        \"currency\": \"12345\"\n"
                + "      },\n"
                + "      \"unitOfMeasureType\": \"Unknown\",\n"
                + "      \"updatedAtTime\": \"2019-06-13T19:08:25Z\"\n"
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
    public void testCreatePartInventoryLocation() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"aisle\":\"12345\",\"availableQuantity\":123.45,\"bin\":\"12345\",\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"currentQuantity\":123.45,\"id\":\"12345\",\"isCostTracked\":true,\"isLowStock\":true,\"isNonStock\":true,\"maxStockLevel\":123.45,\"minStockLevel\":123.45,\"partSamsara\":{\"id\":\"281474976710656\"},\"place\":{\"id\":\"281474976710656\"},\"reorderQuantity\":123.45,\"reorderThreshold\":123.45,\"reservedQuantity\":123.45,\"row\":\"12345\",\"unitCost\":{\"amount\":\"12345\",\"currency\":\"12345\"},\"unitOfMeasureType\":\"Unknown\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}}"));
        EntityPartInventoryLocationsServiceCreatePartInventoryLocationResponseBody response = client.maintenance()
                .createPartInventoryLocation(
                        EntityPartInventoryLocationsServiceCreatePartInventoryLocationRequestBody.builder()
                                .build());
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
                + "    \"aisle\": \"12345\",\n"
                + "    \"availableQuantity\": 123.45,\n"
                + "    \"bin\": \"12345\",\n"
                + "    \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"currentQuantity\": 123.45,\n"
                + "    \"id\": \"12345\",\n"
                + "    \"isCostTracked\": true,\n"
                + "    \"isLowStock\": true,\n"
                + "    \"isNonStock\": true,\n"
                + "    \"maxStockLevel\": 123.45,\n"
                + "    \"minStockLevel\": 123.45,\n"
                + "    \"partSamsara\": {\n"
                + "      \"id\": \"281474976710656\"\n"
                + "    },\n"
                + "    \"place\": {\n"
                + "      \"id\": \"281474976710656\"\n"
                + "    },\n"
                + "    \"reorderQuantity\": 123.45,\n"
                + "    \"reorderThreshold\": 123.45,\n"
                + "    \"reservedQuantity\": 123.45,\n"
                + "    \"row\": \"12345\",\n"
                + "    \"unitCost\": {\n"
                + "      \"amount\": \"12345\",\n"
                + "      \"currency\": \"12345\"\n"
                + "    },\n"
                + "    \"unitOfMeasureType\": \"Unknown\",\n"
                + "    \"updatedAtTime\": \"2019-06-13T19:08:25Z\"\n"
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
    public void testUpdatePartInventoryLocation() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"aisle\":\"12345\",\"availableQuantity\":123.45,\"bin\":\"12345\",\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"currentQuantity\":123.45,\"id\":\"12345\",\"isCostTracked\":true,\"isLowStock\":true,\"isNonStock\":true,\"maxStockLevel\":123.45,\"minStockLevel\":123.45,\"partSamsara\":{\"id\":\"281474976710656\"},\"place\":{\"id\":\"281474976710656\"},\"reorderQuantity\":123.45,\"reorderThreshold\":123.45,\"reservedQuantity\":123.45,\"row\":\"12345\",\"unitCost\":{\"amount\":\"12345\",\"currency\":\"12345\"},\"unitOfMeasureType\":\"Unknown\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}}"));
        EntityPartInventoryLocationsServiceUpdatePartInventoryLocationResponseBody response = client.maintenance()
                .updatePartInventoryLocation(
                        EntityPartInventoryLocationsServiceUpdatePartInventoryLocationRequestBody.builder()
                                .build());
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
                + "    \"aisle\": \"12345\",\n"
                + "    \"availableQuantity\": 123.45,\n"
                + "    \"bin\": \"12345\",\n"
                + "    \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"currentQuantity\": 123.45,\n"
                + "    \"id\": \"12345\",\n"
                + "    \"isCostTracked\": true,\n"
                + "    \"isLowStock\": true,\n"
                + "    \"isNonStock\": true,\n"
                + "    \"maxStockLevel\": 123.45,\n"
                + "    \"minStockLevel\": 123.45,\n"
                + "    \"partSamsara\": {\n"
                + "      \"id\": \"281474976710656\"\n"
                + "    },\n"
                + "    \"place\": {\n"
                + "      \"id\": \"281474976710656\"\n"
                + "    },\n"
                + "    \"reorderQuantity\": 123.45,\n"
                + "    \"reorderThreshold\": 123.45,\n"
                + "    \"reservedQuantity\": 123.45,\n"
                + "    \"row\": \"12345\",\n"
                + "    \"unitCost\": {\n"
                + "      \"amount\": \"12345\",\n"
                + "      \"currency\": \"12345\"\n"
                + "    },\n"
                + "    \"unitOfMeasureType\": \"Unknown\",\n"
                + "    \"updatedAtTime\": \"2019-06-13T19:08:25Z\"\n"
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
    public void testCreateStockMovement() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/MaintenanceWireTest_testCreateStockMovement_response.json")));
        CreateStockMovementActionServiceCreateStockMovementResponseBody response = client.maintenance()
                .createStockMovement(CreateStockMovementActionServiceCreateStockMovementRequestBody.builder()
                        .movementType("12345")
                        .partSamsaraId("12345")
                        .quantity(123.45)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"movementType\": \"12345\",\n"
                + "  \"partSamsaraId\": \"12345\",\n"
                + "  \"quantity\": 123.45\n"
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
                TestResources.loadResource("/wire-tests/MaintenanceWireTest_testCreateStockMovement_response.json");
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
    public void testListPartTransactions() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"batch\":\"12345\",\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"createdByUserId\":\"12345\",\"fromPlaceId\":\"12345\",\"happenedAtTime\":\"2019-06-13T19:08:25Z\",\"id\":\"12345\",\"notes\":\"12345\",\"part\":{\"id\":\"281474976710656\"},\"placeId\":\"12345\",\"purchaseOrder\":\"12345\",\"quantity\":123.45,\"resultingQuantity\":123.45,\"toPlaceId\":\"12345\",\"transactionType\":\"Unknown\",\"unitCost\":123.45,\"vendorId\":\"12345\",\"workOrder\":{\"id\":\"281474976710656\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        EntityInventoryTransactionsServiceListPartTransactionsResponseBody response = client.maintenance()
                .listPartTransactions(ListPartTransactionsRequest.builder()
                        .happenedAtTimeStart("happenedAtTimeStart")
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
                + "      \"batch\": \"12345\",\n"
                + "      \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"createdByUserId\": \"12345\",\n"
                + "      \"fromPlaceId\": \"12345\",\n"
                + "      \"happenedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"id\": \"12345\",\n"
                + "      \"notes\": \"12345\",\n"
                + "      \"part\": {\n"
                + "        \"id\": \"281474976710656\"\n"
                + "      },\n"
                + "      \"placeId\": \"12345\",\n"
                + "      \"purchaseOrder\": \"12345\",\n"
                + "      \"quantity\": 123.45,\n"
                + "      \"resultingQuantity\": 123.45,\n"
                + "      \"toPlaceId\": \"12345\",\n"
                + "      \"transactionType\": \"Unknown\",\n"
                + "      \"unitCost\": 123.45,\n"
                + "      \"vendorId\": \"12345\",\n"
                + "      \"workOrder\": {\n"
                + "        \"id\": \"281474976710656\"\n"
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
    public void testListTimeEntries() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"activityType\":\"unknown\",\"clockInAtTime\":\"2026-07-09T14:10:47.648Z\",\"clockInLocation\":{\"latitude\":42.2364884,\"longitude\":-83.3113959},\"clockInSource\":\"mobile\",\"clockOutAtTime\":\"2026-07-09T14:15:47.296Z\",\"clockOutLocation\":{\"latitude\":42.2365116,\"longitude\":-83.3114372},\"clockOutMethodType\":\"manual\",\"clockOutSource\":\"mobile\",\"createdAtTime\":\"2026-07-09T14:10:48.245Z\",\"deletedAtTime\":\"2019-06-13T19:08:25Z\",\"deletedByUserId\":\"12345\",\"hourlyRate\":{\"amount\":\"24.50\",\"currency\":\"usd\"},\"id\":\"85436931-026c-466a-95ae-419a829e3a26\",\"placeId\":\"5000000795134\",\"serviceTaskId\":\"98e645fa-4b7e-446c-8613-cf2bb0a70727\",\"timeEntryStatus\":\"completed\",\"updatedAtTime\":\"2026-07-09T14:15:47.820Z\",\"userId\":\"590838\",\"workOrderId\":\"34\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        EntityTimeEntriesServiceListTimeEntriesResponseBody response = client.maintenance()
                .listTimeEntries(
                        ListTimeEntriesRequest.builder().startTime("startTime").build());
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
                + "      \"activityType\": \"unknown\",\n"
                + "      \"clockInAtTime\": \"2026-07-09T14:10:47.648Z\",\n"
                + "      \"clockInLocation\": {\n"
                + "        \"latitude\": 42.2364884,\n"
                + "        \"longitude\": -83.3113959\n"
                + "      },\n"
                + "      \"clockInSource\": \"mobile\",\n"
                + "      \"clockOutAtTime\": \"2026-07-09T14:15:47.296Z\",\n"
                + "      \"clockOutLocation\": {\n"
                + "        \"latitude\": 42.2365116,\n"
                + "        \"longitude\": -83.3114372\n"
                + "      },\n"
                + "      \"clockOutMethodType\": \"manual\",\n"
                + "      \"clockOutSource\": \"mobile\",\n"
                + "      \"createdAtTime\": \"2026-07-09T14:10:48.245Z\",\n"
                + "      \"deletedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"deletedByUserId\": \"12345\",\n"
                + "      \"hourlyRate\": {\n"
                + "        \"amount\": \"24.50\",\n"
                + "        \"currency\": \"usd\"\n"
                + "      },\n"
                + "      \"id\": \"85436931-026c-466a-95ae-419a829e3a26\",\n"
                + "      \"placeId\": \"5000000795134\",\n"
                + "      \"serviceTaskId\": \"98e645fa-4b7e-446c-8613-cf2bb0a70727\",\n"
                + "      \"timeEntryStatus\": \"completed\",\n"
                + "      \"updatedAtTime\": \"2026-07-09T14:15:47.820Z\",\n"
                + "      \"userId\": \"590838\",\n"
                + "      \"workOrderId\": \"34\"\n"
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
    public void testListWarranties() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/MaintenanceWireTest_testListWarranties_response.json")));
        EntityWarrantiesServiceListWarrantiesResponseBody response = client.maintenance()
                .listWarranties(ListWarrantiesRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/MaintenanceWireTest_testListWarranties_response.json");
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
    public void testCreateWarranty() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/MaintenanceWireTest_testCreateWarranty_response.json")));
        EntityWarrantiesServiceCreateWarrantyResponseBody response = client.maintenance()
                .createWarranty(EntityWarrantiesServiceCreateWarrantyRequestBody.builder()
                        .name("12345")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"name\": \"12345\"\n" + "}";
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
                TestResources.loadResource("/wire-tests/MaintenanceWireTest_testCreateWarranty_response.json");
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
    public void testDeleteWarranty() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.maintenance()
                .deleteWarranty(DeleteWarrantyRequest.builder().id("id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testUpdateWarranty() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/MaintenanceWireTest_testUpdateWarranty_response.json")));
        EntityWarrantiesServiceUpdateWarrantyResponseBody response = client.maintenance()
                .updateWarranty(EntityWarrantiesServiceUpdateWarrantyRequestBody.builder()
                        .id("id")
                        .build());
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
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/MaintenanceWireTest_testUpdateWarranty_response.json");
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
    public void testListWarrantyAssetAssignments() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"asset\":{\"id\":\"281474976710656\"},\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"id\":\"12345\",\"startEngineHours\":12345,\"startOdometerMeters\":12345,\"startTime\":\"2019-06-13T19:08:25Z\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\",\"warranty\":{\"id\":\"281474976710656\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        EntityWarrantyAssetAssignmentsServiceListWarrantyAssetAssignmentsResponseBody response = client.maintenance()
                .listWarrantyAssetAssignments(ListWarrantyAssetAssignmentsRequest.builder()
                        .warrantyId("warrantyId")
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
                + "      \"asset\": {\n"
                + "        \"id\": \"281474976710656\"\n"
                + "      },\n"
                + "      \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"id\": \"12345\",\n"
                + "      \"startEngineHours\": 12345,\n"
                + "      \"startOdometerMeters\": 12345,\n"
                + "      \"startTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"updatedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"warranty\": {\n"
                + "        \"id\": \"281474976710656\"\n"
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
    public void testReplaceWarrantyAssetAssignments() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"data\":[{\"assetId\":\"12345\",\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"id\":\"12345\",\"startEngineHours\":12345,\"startOdometerMeters\":12345,\"startTime\":\"2019-06-13T19:08:25Z\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\",\"warrantyId\":\"12345\"}]}}"));
        ReplaceWarrantyAssetAssignmentsActionServiceReplaceWarrantyAssetAssignmentsResponseBody response =
                client.maintenance()
                        .replaceWarrantyAssetAssignments(
                                ReplaceWarrantyAssetAssignmentsActionServiceReplaceWarrantyAssetAssignmentsRequestBody
                                        .builder()
                                        .build());
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
                + "    \"data\": [\n"
                + "      {\n"
                + "        \"assetId\": \"12345\",\n"
                + "        \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "        \"id\": \"12345\",\n"
                + "        \"startEngineHours\": 12345,\n"
                + "        \"startOdometerMeters\": 12345,\n"
                + "        \"startTime\": \"2019-06-13T19:08:25Z\",\n"
                + "        \"updatedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "        \"warrantyId\": \"12345\"\n"
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
    public void testListWarrantyClaims() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/MaintenanceWireTest_testListWarrantyClaims_response.json")));
        EntityWarrantyClaimsServiceListWarrantyClaimsResponseBody response = client.maintenance()
                .listWarrantyClaims(ListWarrantyClaimsRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/MaintenanceWireTest_testListWarrantyClaims_response.json");
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
    public void testCreateWarrantyClaim() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/MaintenanceWireTest_testCreateWarrantyClaim_response.json")));
        EntityWarrantyClaimsServiceCreateWarrantyClaimResponseBody response = client.maintenance()
                .createWarrantyClaim(EntityWarrantyClaimsServiceCreateWarrantyClaimRequestBody.builder()
                        .assetId("281474976710656")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"assetId\": \"281474976710656\"\n" + "}";
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
                TestResources.loadResource("/wire-tests/MaintenanceWireTest_testCreateWarrantyClaim_response.json");
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
    public void testDeleteWarrantyClaim() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.maintenance()
                .deleteWarrantyClaim(
                        DeleteWarrantyClaimRequest.builder().id("id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testUpdateWarrantyClaim() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/MaintenanceWireTest_testUpdateWarrantyClaim_response.json")));
        EntityWarrantyClaimsServiceUpdateWarrantyClaimResponseBody response = client.maintenance()
                .updateWarrantyClaim(EntityWarrantyClaimsServiceUpdateWarrantyClaimRequestBody.builder()
                        .id("id")
                        .build());
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
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/MaintenanceWireTest_testUpdateWarrantyClaim_response.json");
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
