package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.betaapis.requests.DeleteJobRequest;
import com.samsara.api.resources.betaapis.requests.EngineImmobilizerUpdateEngineImmobilizerStateRequestBody;
import com.samsara.api.resources.betaapis.requests.EquipmentPatchEquipmentRequestBody;
import com.samsara.api.resources.betaapis.requests.FunctionsStartFunctionRunRequestBody;
import com.samsara.api.resources.betaapis.requests.GetAssetsInputsRequest;
import com.samsara.api.resources.betaapis.requests.GetDatasetsRequest;
import com.samsara.api.resources.betaapis.requests.GetDepreciationTransactionsRequest;
import com.samsara.api.resources.betaapis.requests.GetDetectionsRequest;
import com.samsara.api.resources.betaapis.requests.GetDevicesRequest;
import com.samsara.api.resources.betaapis.requests.GetDriverEfficiencyRequest;
import com.samsara.api.resources.betaapis.requests.GetDriverSafetyScoreTripsRequest;
import com.samsara.api.resources.betaapis.requests.GetDriverSafetyScoresRequest;
import com.samsara.api.resources.betaapis.requests.GetEngineImmobilizerStatesRequest;
import com.samsara.api.resources.betaapis.requests.GetHosEldEventsRequest;
import com.samsara.api.resources.betaapis.requests.GetJobsRequest;
import com.samsara.api.resources.betaapis.requests.GetQualificationRecordsRequest;
import com.samsara.api.resources.betaapis.requests.GetQualificationRecordsStreamRequest;
import com.samsara.api.resources.betaapis.requests.GetQualificationTypesRequest;
import com.samsara.api.resources.betaapis.requests.GetReadingsHistoryRequest;
import com.samsara.api.resources.betaapis.requests.GetReadingsSnapshotRequest;
import com.samsara.api.resources.betaapis.requests.GetReportConfigsRequest;
import com.samsara.api.resources.betaapis.requests.GetReportRunDataRequest;
import com.samsara.api.resources.betaapis.requests.GetReportRunsRequest;
import com.samsara.api.resources.betaapis.requests.GetTagGroupSafetyScoresRequest;
import com.samsara.api.resources.betaapis.requests.GetTagSafetyScoresRequest;
import com.samsara.api.resources.betaapis.requests.GetTrailerStatsFeedRequest;
import com.samsara.api.resources.betaapis.requests.GetTrailerStatsHistoryRequest;
import com.samsara.api.resources.betaapis.requests.GetTrailerStatsSnapshotRequest;
import com.samsara.api.resources.betaapis.requests.GetVehicleSafetyScoreTripsRequest;
import com.samsara.api.resources.betaapis.requests.GetVehicleSafetyScoresRequest;
import com.samsara.api.resources.betaapis.requests.HosDailyLogsUpdateShippingDocsRequestBody;
import com.samsara.api.resources.betaapis.requests.JobsCreateJobRequestBody;
import com.samsara.api.resources.betaapis.requests.JobsPatchJobRequestBody;
import com.samsara.api.resources.betaapis.requests.ListHubCustomPropertiesRequest;
import com.samsara.api.resources.betaapis.requests.ListReadingsDefinitionsRequest;
import com.samsara.api.resources.betaapis.requests.PlanOrdersCreatePlanOrdersRequestBody;
import com.samsara.api.resources.betaapis.requests.QualificationsArchiveQualificationRecordRequestBody;
import com.samsara.api.resources.betaapis.requests.QualificationsDeleteQualificationRecordRequestBody;
import com.samsara.api.resources.betaapis.requests.QualificationsPatchQualificationRecordRequestBody;
import com.samsara.api.resources.betaapis.requests.QualificationsPostQualificationRecordRequestBody;
import com.samsara.api.resources.betaapis.requests.QualificationsUnarchiveQualificationRecordRequestBody;
import com.samsara.api.resources.betaapis.requests.ReadingsPostReadingsRequestBody;
import com.samsara.api.resources.betaapis.requests.ReportsCreateReportRunRequestBody;
import com.samsara.api.resources.betaapis.types.FunctionsStartFunctionRunRequestBodyParamsOverride;
import com.samsara.api.resources.betaapis.types.GetAssetsInputsRequestType;
import com.samsara.api.resources.betaapis.types.GetQualificationRecordsStreamRequestEntityType;
import com.samsara.api.resources.betaapis.types.GetQualificationTypesRequestEntityType;
import com.samsara.api.resources.betaapis.types.GetTagGroupSafetyScoresRequestScoreType;
import com.samsara.api.resources.betaapis.types.GetTagSafetyScoresRequestScoreType;
import com.samsara.api.types.AempEquipmentGetAempEquipmentListResponseBody;
import com.samsara.api.types.AssetsInputsGetAssetsInputsResponseBody;
import com.samsara.api.types.CreateReportConfigObjectRequestBody;
import com.samsara.api.types.DepreciationGetDepreciationTransactionsResponseBody;
import com.samsara.api.types.DetectionLogGetDetectionsResponseBody;
import com.samsara.api.types.DevicesGetDevicesResponseBody;
import com.samsara.api.types.DriverEfficienciesResponse;
import com.samsara.api.types.EngineImmobilizerGetEngineImmobilizerStatesResponseBody;
import com.samsara.api.types.EquipmentPatchEquipmentResponseBody;
import com.samsara.api.types.FunctionsStartFunctionRunResponseBody;
import com.samsara.api.types.HosDailyLogsUpdateShippingDocsResponseBody;
import com.samsara.api.types.HosEldEventsGetHosEldEventsResponseBody;
import com.samsara.api.types.HubCustomPropertiesListHubCustomPropertiesResponseBody;
import com.samsara.api.types.JobsCreateJobResponseBody;
import com.samsara.api.types.JobsDeleteJobResponseBody;
import com.samsara.api.types.JobsGetJobsResponseBody;
import com.samsara.api.types.JobsPatchJobResponseBody;
import com.samsara.api.types.OrderInputObjectRequestBody;
import com.samsara.api.types.PatchJobObjectRequestBody;
import com.samsara.api.types.PlanOrdersCreatePlanOrdersResponseBody;
import com.samsara.api.types.PostJobObjectRequestBody;
import com.samsara.api.types.QualificationOwnerRequestObjectRequestBody;
import com.samsara.api.types.QualificationOwnerRequestObjectRequestBodyEntityType;
import com.samsara.api.types.QualificationRecordRequestFieldInputObjectRequestBody;
import com.samsara.api.types.QualificationRecordRequestFieldInputObjectRequestBodyType;
import com.samsara.api.types.QualificationTypeRequestObjectRequestBody;
import com.samsara.api.types.QualificationsGetQualificationRecordsResponseBody;
import com.samsara.api.types.QualificationsGetQualificationRecordsStreamResponseBody;
import com.samsara.api.types.QualificationsGetQualificationTypesResponseBody;
import com.samsara.api.types.QualificationsPatchQualificationRecordResponseBody;
import com.samsara.api.types.QualificationsPostQualificationRecordResponseBody;
import com.samsara.api.types.ReadingDatapointRequestBody;
import com.samsara.api.types.ReadingsGetReadingsHistoryResponseBody;
import com.samsara.api.types.ReadingsGetReadingsSnapshotResponseBody;
import com.samsara.api.types.ReadingsListReadingsDefinitionsResponseBody;
import com.samsara.api.types.ReportsCreateReportRunResponseBody;
import com.samsara.api.types.ReportsGetDatasetsResponseBody;
import com.samsara.api.types.ReportsGetReportConfigsResponseBody;
import com.samsara.api.types.ReportsGetReportRunDataResponseBody;
import com.samsara.api.types.ReportsGetReportRunsResponseBody;
import com.samsara.api.types.SafetyScoresGetDriverSafetyScoreTripsResponseBody;
import com.samsara.api.types.SafetyScoresGetDriverSafetyScoresResponseBody;
import com.samsara.api.types.SafetyScoresGetTagGroupSafetyScoresResponseBody;
import com.samsara.api.types.SafetyScoresGetTagSafetyScoresResponseBody;
import com.samsara.api.types.SafetyScoresGetVehicleSafetyScoreTripsResponseBody;
import com.samsara.api.types.SafetyScoresGetVehicleSafetyScoresResponseBody;
import com.samsara.api.types.TrailerStatsGetTrailerStatsFeedResponseBody;
import com.samsara.api.types.TrailerStatsGetTrailerStatsHistoryResponseBody;
import com.samsara.api.types.TrailerStatsGetTrailerStatsSnapshotResponseBody;
import com.samsara.api.types.UpdateEngineImmobilizerRelayStateRequestBodyRequestBody;
import com.samsara.api.types.UpdateEngineImmobilizerRelayStateRequestBodyRequestBodyId;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BetaApisWireTest {
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
    public void testGetDepreciationTransactions() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"amount\":{\"amount\":\"640.2\",\"currency\":\"usd\"},\"assetId\":\"281474993384538\",\"costCenterId\":\"5523a39f-42ef-4820-83d0-dfe73dbe7853\",\"createdAt\":\"2024-12-05T10:30:00Z\",\"eventTime\":\"2024-11-30T23:59:59Z\",\"id\":\"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\"note\":\"November 2024 monthly depreciation\",\"transactionType\":\"depreciation\",\"updatedAt\":\"2024-12-05T10:30:00Z\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DepreciationGetDepreciationTransactionsResponseBody response = client.betaApis()
                .getDepreciationTransactions(
                        GetDepreciationTransactionsRequest.builder().build());
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
                + "      \"amount\": {\n"
                + "        \"amount\": \"640.2\",\n"
                + "        \"currency\": \"usd\"\n"
                + "      },\n"
                + "      \"assetId\": \"281474993384538\",\n"
                + "      \"costCenterId\": \"5523a39f-42ef-4820-83d0-dfe73dbe7853\",\n"
                + "      \"createdAt\": \"2024-12-05T10:30:00Z\",\n"
                + "      \"eventTime\": \"2024-11-30T23:59:59Z\",\n"
                + "      \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\n"
                + "      \"note\": \"November 2024 monthly depreciation\",\n"
                + "      \"transactionType\": \"depreciation\",\n"
                + "      \"updatedAt\": \"2024-12-05T10:30:00Z\"\n"
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
    public void testGetAssetsInputs() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource("/wire-tests/BetaApisWireTest_testGetAssetsInputs_response.json")));
        AssetsInputsGetAssetsInputsResponseBody response = client.betaApis()
                .getAssetsInputs(GetAssetsInputsRequest.builder()
                        .type(GetAssetsInputsRequestType.AUX_INPUT1)
                        .startTime("startTime")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/BetaApisWireTest_testGetAssetsInputs_response.json");
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
    public void testGetAempEquipmentList() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"Fleet\":{\"Equipment\":[{\"EquipmentHeader\":{\"EquipmentID\":\"494123\",\"Model\":\"S630 T4\",\"OEMName\":\"Bobcat\",\"PIN\":\"8V8WD530FLN016251\",\"SerialNumber\":\"8V8WD530FLN016251\",\"UnitInstallDateTime\":\"2019-06-13T19:08:25Z\"},\"Location\":{\"Latitude\":12.34,\"Longitude\":12.34,\"datetime\":\"2019-06-13T19:08:25Z\"}}],\"Links\":[{\"href\":\"https://api.samsara.com/aemp/Fleet/1\",\"rel\":\"self\"}],\"snapshotTime\":\"2019-06-13T19:08:25Z\",\"version\":\"1\"}}"));
        AempEquipmentGetAempEquipmentListResponseBody response =
                client.betaApis().getAempEquipmentList("pageNumber");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"Fleet\": {\n"
                + "    \"Equipment\": [\n"
                + "      {\n"
                + "        \"EquipmentHeader\": {\n"
                + "          \"EquipmentID\": \"494123\",\n"
                + "          \"Model\": \"S630 T4\",\n"
                + "          \"OEMName\": \"Bobcat\",\n"
                + "          \"PIN\": \"8V8WD530FLN016251\",\n"
                + "          \"SerialNumber\": \"8V8WD530FLN016251\",\n"
                + "          \"UnitInstallDateTime\": \"2019-06-13T19:08:25Z\"\n"
                + "        },\n"
                + "        \"Location\": {\n"
                + "          \"Latitude\": 12.34,\n"
                + "          \"Longitude\": 12.34,\n"
                + "          \"datetime\": \"2019-06-13T19:08:25Z\"\n"
                + "        }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"Links\": [\n"
                + "      {\n"
                + "        \"href\": \"https://api.samsara.com/aemp/Fleet/1\",\n"
                + "        \"rel\": \"self\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"snapshotTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"version\": \"1\"\n"
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
    public void testGetDriverEfficiency() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"driverSummaries\":[{}],\"summaryEndTime\":\"2020-03-16T16:00:00Z\",\"summaryStartTime\":\"2020-03-15T16:00:00Z\"},\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DriverEfficienciesResponse response = client.betaApis()
                .getDriverEfficiency(GetDriverEfficiencyRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"driverSummaries\": [\n"
                + "      {}\n"
                + "    ],\n"
                + "    \"summaryEndTime\": \"2020-03-16T16:00:00Z\",\n"
                + "    \"summaryStartTime\": \"2020-03-15T16:00:00Z\"\n"
                + "  },\n"
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
    public void testPatchEquipment() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"attributes\":[{\"dateValues\":[\"2024-01-15\",\"2024-12-31\"],\"id\":\"494123\",\"name\":\"Compliance/ELD\",\"numberValues\":[867,5309],\"stringValues\":[\"HQ\",\"Leased\"]}],\"equipmentSerialNumber\":\"8V8WD530FLN016251\",\"externalIds\":{\"key\":\"value\"},\"id\":\"494123\",\"installedGateway\":{\"model\":\"AG15\",\"serial\":\"GFRV-43N-VGX\"},\"name\":\"Equipment-123\",\"notes\":\"These are my equipment notes\",\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}]}}"));
        EquipmentPatchEquipmentResponseBody response = client.betaApis()
                .patchEquipment(
                        "id", EquipmentPatchEquipmentRequestBody.builder().build());
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
                + "    \"attributes\": [\n"
                + "      {\n"
                + "        \"dateValues\": [\n"
                + "          \"2024-01-15\",\n"
                + "          \"2024-12-31\"\n"
                + "        ],\n"
                + "        \"id\": \"494123\",\n"
                + "        \"name\": \"Compliance/ELD\",\n"
                + "        \"numberValues\": [\n"
                + "          867,\n"
                + "          5309\n"
                + "        ],\n"
                + "        \"stringValues\": [\n"
                + "          \"HQ\",\n"
                + "          \"Leased\"\n"
                + "        ]\n"
                + "      }\n"
                + "    ],\n"
                + "    \"equipmentSerialNumber\": \"8V8WD530FLN016251\",\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"id\": \"494123\",\n"
                + "    \"installedGateway\": {\n"
                + "      \"model\": \"AG15\",\n"
                + "      \"serial\": \"GFRV-43N-VGX\"\n"
                + "    },\n"
                + "    \"name\": \"Equipment-123\",\n"
                + "    \"notes\": \"These are my equipment notes\",\n"
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
    public void testGetHosEldEvents() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"driverActivationStatus\":\"active\",\"eldEvents\":[{\"accumulatedVehicleMeters\":106,\"elapsedEngineHours\":284.1,\"eldEventCode\":3,\"eldEventRecordOrigin\":2,\"eldEventRecordStatus\":2,\"eldEventType\":6,\"remark\":{\"comment\":\"Pre-Trip Inspection\",\"locationDescription\":\"Near San Francisco\",\"time\":\"2019-06-13T19:08:25Z\"},\"time\":\"2019-06-13T19:08:25Z\",\"totalEngineHours\":2894.1,\"totalVehicleMeters\":1004566}],\"externalIds\":{\"key\":\"value\"},\"id\":\"494123\",\"name\":\"Joe Driver\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        HosEldEventsGetHosEldEventsResponseBody response = client.betaApis()
                .getHosEldEvents(GetHosEldEventsRequest.builder()
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
                + "      \"driverActivationStatus\": \"active\",\n"
                + "      \"eldEvents\": [\n"
                + "        {\n"
                + "          \"accumulatedVehicleMeters\": 106,\n"
                + "          \"elapsedEngineHours\": 284.1,\n"
                + "          \"eldEventCode\": 3,\n"
                + "          \"eldEventRecordOrigin\": 2,\n"
                + "          \"eldEventRecordStatus\": 2,\n"
                + "          \"eldEventType\": 6,\n"
                + "          \"remark\": {\n"
                + "            \"comment\": \"Pre-Trip Inspection\",\n"
                + "            \"locationDescription\": \"Near San Francisco\",\n"
                + "            \"time\": \"2019-06-13T19:08:25Z\"\n"
                + "          },\n"
                + "          \"time\": \"2019-06-13T19:08:25Z\",\n"
                + "          \"totalEngineHours\": 2894.1,\n"
                + "          \"totalVehicleMeters\": 1004566\n"
                + "        }\n"
                + "      ],\n"
                + "      \"externalIds\": {\n"
                + "        \"key\": \"value\"\n"
                + "      },\n"
                + "      \"id\": \"494123\",\n"
                + "      \"name\": \"Joe Driver\"\n"
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
    public void testGetTrailerStatsSnapshot() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/BetaApisWireTest_testGetTrailerStatsSnapshot_response.json")));
        TrailerStatsGetTrailerStatsSnapshotResponseBody response = client.betaApis()
                .getTrailerStatsSnapshot(
                        GetTrailerStatsSnapshotRequest.builder().types("types").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/BetaApisWireTest_testGetTrailerStatsSnapshot_response.json");
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
    public void testGetTrailerStatsFeed() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/BetaApisWireTest_testGetTrailerStatsFeed_response.json")));
        TrailerStatsGetTrailerStatsFeedResponseBody response = client.betaApis()
                .getTrailerStatsFeed(
                        GetTrailerStatsFeedRequest.builder().types("types").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/BetaApisWireTest_testGetTrailerStatsFeed_response.json");
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
    public void testGetTrailerStatsHistory() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/BetaApisWireTest_testGetTrailerStatsHistory_response.json")));
        TrailerStatsGetTrailerStatsHistoryResponseBody response = client.betaApis()
                .getTrailerStatsHistory(GetTrailerStatsHistoryRequest.builder()
                        .startTime("startTime")
                        .endTime("endTime")
                        .types("types")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/BetaApisWireTest_testGetTrailerStatsHistory_response.json");
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
    public void testUpdateEngineImmobilizerState() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.betaApis()
                .updateEngineImmobilizerState(
                        1000000L,
                        EngineImmobilizerUpdateEngineImmobilizerStateRequestBody.builder()
                                .relayStates(
                                        Arrays.asList(UpdateEngineImmobilizerRelayStateRequestBodyRequestBody.builder()
                                                .id(UpdateEngineImmobilizerRelayStateRequestBodyRequestBodyId.RELAY1)
                                                .isOpen(true)
                                                .build()))
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"relayStates\": [\n"
                + "    {\n"
                + "      \"id\": \"relay1\",\n"
                + "      \"isOpen\": true\n"
                + "    }\n"
                + "  ]\n"
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
    }

    @Test
    public void testGetJobs() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"address\":{\"address\":\"1990 Alameda st, San Francisco, Ca 94103\",\"latitude\":37.456345,\"longitude\":34.5633749,\"name\":\"Worksite #1\"},\"createdAt\":\"2019-06-13T19:08:25Z\",\"customerName\":\"Samsara\",\"endDate\":\"2019-06-13T19:08:25Z\",\"fleetDevices\":[{\"id\":123456,\"name\":\"My Device\"}],\"id\":\"1553\",\"industrialAssets\":[{\"id\":\"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\",\"name\":\"My asset\"}],\"modifiedAt\":\"2019-06-13T19:08:25Z\",\"name\":\"My Job Name\",\"notes\":\"These are my notes\",\"ontimeWindowAfterArrivalMs\":300000,\"ontimeWindowBeforeArrivalMs\":300000,\"startDate\":\"2019-06-13T19:08:25Z\",\"status\":\"active\",\"uuid\":\"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"}],\"id\":\"1553\",\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true},\"uuid\":\"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"}"));
        JobsGetJobsResponseBody response =
                client.betaApis().getJobs(GetJobsRequest.builder().build());
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
                + "      \"address\": {\n"
                + "        \"address\": \"1990 Alameda st, San Francisco, Ca 94103\",\n"
                + "        \"latitude\": 37.456345,\n"
                + "        \"longitude\": 34.5633749,\n"
                + "        \"name\": \"Worksite #1\"\n"
                + "      },\n"
                + "      \"createdAt\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"customerName\": \"Samsara\",\n"
                + "      \"endDate\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"fleetDevices\": [\n"
                + "        {\n"
                + "          \"id\": 123456,\n"
                + "          \"name\": \"My Device\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"id\": \"1553\",\n"
                + "      \"industrialAssets\": [\n"
                + "        {\n"
                + "          \"id\": \"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\",\n"
                + "          \"name\": \"My asset\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"modifiedAt\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"name\": \"My Job Name\",\n"
                + "      \"notes\": \"These are my notes\",\n"
                + "      \"ontimeWindowAfterArrivalMs\": 300000,\n"
                + "      \"ontimeWindowBeforeArrivalMs\": 300000,\n"
                + "      \"startDate\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"status\": \"active\",\n"
                + "      \"uuid\": \"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"id\": \"1553\",\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"MjkY\",\n"
                + "    \"hasNextPage\": true\n"
                + "  },\n"
                + "  \"uuid\": \"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"\n"
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
    public void testCreateJob() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"address\":{\"address\":\"1990 Alameda st, San Francisco, Ca 94103\",\"latitude\":37.456345,\"longitude\":34.5633749,\"name\":\"Worksite #1\"},\"createdAt\":\"2019-06-13T19:08:25Z\",\"customerName\":\"Samsara\",\"endDate\":\"2019-06-13T19:08:25Z\",\"fleetDevices\":[{\"id\":123456,\"name\":\"My Device\"}],\"id\":\"1553\",\"industrialAssets\":[{\"id\":\"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\",\"name\":\"My asset\"}],\"modifiedAt\":\"2019-06-13T19:08:25Z\",\"name\":\"My Job Name\",\"notes\":\"These are my notes\",\"ontimeWindowAfterArrivalMs\":300000,\"ontimeWindowBeforeArrivalMs\":300000,\"startDate\":\"2019-06-13T19:08:25Z\",\"status\":\"active\",\"uuid\":\"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"},\"id\":\"1553\",\"uuid\":\"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"}"));
        JobsCreateJobResponseBody response = client.betaApis()
                .createJob(JobsCreateJobRequestBody.builder()
                        .job(PostJobObjectRequestBody.builder()
                                .endDate("2019-06-13T19:08:25Z")
                                .id("8d218e6c-7a16-4f9f-90f7-cc1d93b9e596")
                                .name("My Job Name")
                                .startDate("2019-06-13T19:08:25Z")
                                .build())
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"job\": {\n"
                + "    \"endDate\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"id\": \"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\",\n"
                + "    \"name\": \"My Job Name\",\n"
                + "    \"startDate\": \"2019-06-13T19:08:25Z\"\n"
                + "  }\n"
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
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"address\": {\n"
                + "      \"address\": \"1990 Alameda st, San Francisco, Ca 94103\",\n"
                + "      \"latitude\": 37.456345,\n"
                + "      \"longitude\": 34.5633749,\n"
                + "      \"name\": \"Worksite #1\"\n"
                + "    },\n"
                + "    \"createdAt\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"customerName\": \"Samsara\",\n"
                + "    \"endDate\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"fleetDevices\": [\n"
                + "      {\n"
                + "        \"id\": 123456,\n"
                + "        \"name\": \"My Device\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"id\": \"1553\",\n"
                + "    \"industrialAssets\": [\n"
                + "      {\n"
                + "        \"id\": \"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\",\n"
                + "        \"name\": \"My asset\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"modifiedAt\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"name\": \"My Job Name\",\n"
                + "    \"notes\": \"These are my notes\",\n"
                + "    \"ontimeWindowAfterArrivalMs\": 300000,\n"
                + "    \"ontimeWindowBeforeArrivalMs\": 300000,\n"
                + "    \"startDate\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"status\": \"active\",\n"
                + "    \"uuid\": \"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"\n"
                + "  },\n"
                + "  \"id\": \"1553\",\n"
                + "  \"uuid\": \"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"\n"
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
    public void testDeleteJob() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"id\":\"1553\",\"uuid\":\"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"}"));
        JobsDeleteJobResponseBody response =
                client.betaApis().deleteJob(DeleteJobRequest.builder().id("id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                "" + "{\n" + "  \"id\": \"1553\",\n" + "  \"uuid\": \"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"\n" + "}";
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
    public void testPatchJob() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"address\":{\"address\":\"1990 Alameda st, San Francisco, Ca 94103\",\"latitude\":37.456345,\"longitude\":34.5633749,\"name\":\"Worksite #1\"},\"createdAt\":\"2019-06-13T19:08:25Z\",\"customerName\":\"Samsara\",\"endDate\":\"2019-06-13T19:08:25Z\",\"fleetDevices\":[{\"id\":123456,\"name\":\"My Device\"}],\"id\":\"1553\",\"industrialAssets\":[{\"id\":\"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\",\"name\":\"My asset\"}],\"modifiedAt\":\"2019-06-13T19:08:25Z\",\"name\":\"My Job Name\",\"notes\":\"These are my notes\",\"ontimeWindowAfterArrivalMs\":300000,\"ontimeWindowBeforeArrivalMs\":300000,\"startDate\":\"2019-06-13T19:08:25Z\",\"status\":\"active\",\"uuid\":\"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"},\"id\":\"1553\",\"uuid\":\"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"}"));
        JobsPatchJobResponseBody response = client.betaApis()
                .patchJob(JobsPatchJobRequestBody.builder()
                        .id("id")
                        .job(PatchJobObjectRequestBody.builder().build())
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"job\": {}\n" + "}";
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
                + "    \"address\": {\n"
                + "      \"address\": \"1990 Alameda st, San Francisco, Ca 94103\",\n"
                + "      \"latitude\": 37.456345,\n"
                + "      \"longitude\": 34.5633749,\n"
                + "      \"name\": \"Worksite #1\"\n"
                + "    },\n"
                + "    \"createdAt\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"customerName\": \"Samsara\",\n"
                + "    \"endDate\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"fleetDevices\": [\n"
                + "      {\n"
                + "        \"id\": 123456,\n"
                + "        \"name\": \"My Device\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"id\": \"1553\",\n"
                + "    \"industrialAssets\": [\n"
                + "      {\n"
                + "        \"id\": \"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\",\n"
                + "        \"name\": \"My asset\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"modifiedAt\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"name\": \"My Job Name\",\n"
                + "    \"notes\": \"These are my notes\",\n"
                + "    \"ontimeWindowAfterArrivalMs\": 300000,\n"
                + "    \"ontimeWindowBeforeArrivalMs\": 300000,\n"
                + "    \"startDate\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"status\": \"active\",\n"
                + "    \"uuid\": \"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"\n"
                + "  },\n"
                + "  \"id\": \"1553\",\n"
                + "  \"uuid\": \"8d218e6c-7a16-4f9f-90f7-cc1d93b9e596\"\n"
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
    public void testGetDetections() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"asset\":{\"id\":\"asset-23ab7cd1-5f6e-4c9b-8f21-1e3b7a9c4d8f\",\"name\":\"Truck 102 - Volvo VNL\",\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}]},\"createdAtTime\":\"2025-09-20T11:15:30Z\",\"driver\":{\"id\":\"driver-8b12fa3d-3c6e-4e2a-9a76-24c1f7b23d9a\",\"name\":\"Alex Johnson\",\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}]},\"id\":\"9c4f81d2-7a25-4f8c-9b83-1c34a91e34a1\",\"inCabAlertPlayed\":true,\"safetyEvent\":[{\"id\":\"a1b2c3d4-5678-90ab-cdef-1234567890ab\",\"inboxEvent\":false}],\"triggerDetectionLabel\":\"acceleration\",\"updatedAtTime\":\"2025-09-20T11:20:45Z\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DetectionLogGetDetectionsResponseBody response = client.betaApis()
                .getDetections(
                        GetDetectionsRequest.builder().startTime("startTime").build());
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
                + "        \"id\": \"asset-23ab7cd1-5f6e-4c9b-8f21-1e3b7a9c4d8f\",\n"
                + "        \"name\": \"Truck 102 - Volvo VNL\",\n"
                + "        \"tags\": [\n"
                + "          {\n"
                + "            \"id\": \"3914\",\n"
                + "            \"name\": \"East Coast\",\n"
                + "            \"parentTagId\": \"4815\"\n"
                + "          }\n"
                + "        ]\n"
                + "      },\n"
                + "      \"createdAtTime\": \"2025-09-20T11:15:30Z\",\n"
                + "      \"driver\": {\n"
                + "        \"id\": \"driver-8b12fa3d-3c6e-4e2a-9a76-24c1f7b23d9a\",\n"
                + "        \"name\": \"Alex Johnson\",\n"
                + "        \"tags\": [\n"
                + "          {\n"
                + "            \"id\": \"3914\",\n"
                + "            \"name\": \"East Coast\",\n"
                + "            \"parentTagId\": \"4815\"\n"
                + "          }\n"
                + "        ]\n"
                + "      },\n"
                + "      \"id\": \"9c4f81d2-7a25-4f8c-9b83-1c34a91e34a1\",\n"
                + "      \"inCabAlertPlayed\": true,\n"
                + "      \"safetyEvent\": [\n"
                + "        {\n"
                + "          \"id\": \"a1b2c3d4-5678-90ab-cdef-1234567890ab\",\n"
                + "          \"inboxEvent\": false\n"
                + "        }\n"
                + "      ],\n"
                + "      \"triggerDetectionLabel\": \"acceleration\",\n"
                + "      \"updatedAtTime\": \"2025-09-20T11:20:45Z\"\n"
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
    public void testGetDevices() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"asset\":{\"id\":\"281474982859091\",\"name\":\"MyAsset-1234\"},\"health\":{\"primaryHealthReasonStartTime\":\"2019-06-13T19:08:25Z\"},\"lastConnectedTime\":\"2019-06-13T19:08:25Z\",\"lastKnownLocation\":{\"id\":12345,\"latitude\":12333122.3,\"longitude\":1233331.4},\"model\":\"AG24\",\"serial\":\"ABCD-123-EFG\",\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}]}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DevicesGetDevicesResponseBody response =
                client.betaApis().getDevices(GetDevicesRequest.builder().build());
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
                + "        \"id\": \"281474982859091\",\n"
                + "        \"name\": \"MyAsset-1234\"\n"
                + "      },\n"
                + "      \"health\": {\n"
                + "        \"primaryHealthReasonStartTime\": \"2019-06-13T19:08:25Z\"\n"
                + "      },\n"
                + "      \"lastConnectedTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"lastKnownLocation\": {\n"
                + "        \"id\": 12345,\n"
                + "        \"latitude\": 12333122.3,\n"
                + "        \"longitude\": 1233331.4\n"
                + "      },\n"
                + "      \"model\": \"AG24\",\n"
                + "      \"serial\": \"ABCD-123-EFG\",\n"
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
    public void testGetEngineImmobilizerStates() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"happenedAtTime\":\"2019-06-13T19:08:25Z\",\"isConnectedToVehicle\":false,\"relayStates\":[{\"id\":\"relay1\",\"isOpen\":false}],\"vehicleId\":\"1234\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        EngineImmobilizerGetEngineImmobilizerStatesResponseBody response = client.betaApis()
                .getEngineImmobilizerStates(GetEngineImmobilizerStatesRequest.builder()
                        .vehicleIds("vehicleIds")
                        .startTime("startTime")
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
                + "      \"happenedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"isConnectedToVehicle\": false,\n"
                + "      \"relayStates\": [\n"
                + "        {\n"
                + "          \"id\": \"relay1\",\n"
                + "          \"isOpen\": false\n"
                + "        }\n"
                + "      ],\n"
                + "      \"vehicleId\": \"1234\"\n"
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
    public void testStartFunctionRun() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"data\":{\"correlationId\":\"550e8400-e29b-41d4-a716-446655440000\"}}"));
        FunctionsStartFunctionRunResponseBody response = client.betaApis()
                .startFunctionRun(
                        "name",
                        FunctionsStartFunctionRunRequestBody.builder()
                                .paramsOverride(FunctionsStartFunctionRunRequestBodyParamsOverride.builder()
                                        .build())
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"paramsOverride\": {}\n" + "}";
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
                + "    \"correlationId\": \"550e8400-e29b-41d4-a716-446655440000\"\n"
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
    public void testUpdateShippingDocs() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"adverseDrivingClaimed\":false,\"bigDayClaimed\":true,\"carrierFormattedAddress\":\"1990 Alameda Street, San Francisco, CA 94103\",\"carrierName\":\"Carrier Name\",\"carrierUsDotNumber\":1234,\"homeTerminalFormattedAddress\":\"1990 Alameda Street, San Francisco, CA 94103\",\"homeTerminalName\":\"Home Terminal Name\",\"isCertified\":true,\"isUsShortHaulActive\":true,\"trailerNames\":[\"10293\",\"Trailer ID 1\"]}}"));
        HosDailyLogsUpdateShippingDocsResponseBody response = client.betaApis()
                .updateShippingDocs(HosDailyLogsUpdateShippingDocsRequestBody.builder()
                        .hosDate("hosDate")
                        .driverId("driverID")
                        .shippingDocs("ShippingID1, ShippingID2")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"shippingDocs\": \"ShippingID1, ShippingID2\"\n" + "}";
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
                + "    \"adverseDrivingClaimed\": false,\n"
                + "    \"bigDayClaimed\": true,\n"
                + "    \"carrierFormattedAddress\": \"1990 Alameda Street, San Francisco, CA 94103\",\n"
                + "    \"carrierName\": \"Carrier Name\",\n"
                + "    \"carrierUsDotNumber\": 1234,\n"
                + "    \"homeTerminalFormattedAddress\": \"1990 Alameda Street, San Francisco, CA 94103\",\n"
                + "    \"homeTerminalName\": \"Home Terminal Name\",\n"
                + "    \"isCertified\": true,\n"
                + "    \"isUsShortHaulActive\": true,\n"
                + "    \"trailerNames\": [\n"
                + "      \"10293\",\n"
                + "      \"Trailer ID 1\"\n"
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
    public void testListHubCustomProperties() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"createdAt\":\"2024-01-15T10:30:00Z\",\"csvColumns\":\"customer_type,customerType\",\"hubId\":\"650e8400-e29b-41d4-a716-446655440001\",\"id\":\"750e8400-e29b-41d4-a716-446655440004\",\"name\":\"CustomerType\",\"updatedAt\":\"2024-01-15T10:30:00Z\"}],\"pagination\":{\"endCursor\":\"YXJyYXljb25uZWN0aW9uOjEwMA==\",\"hasNextPage\":false}}"));
        HubCustomPropertiesListHubCustomPropertiesResponseBody response = client.betaApis()
                .listHubCustomProperties(
                        ListHubCustomPropertiesRequest.builder().hubId("hubId").build());
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
                + "      \"createdAt\": \"2024-01-15T10:30:00Z\",\n"
                + "      \"csvColumns\": \"customer_type,customerType\",\n"
                + "      \"hubId\": \"650e8400-e29b-41d4-a716-446655440001\",\n"
                + "      \"id\": \"750e8400-e29b-41d4-a716-446655440004\",\n"
                + "      \"name\": \"CustomerType\",\n"
                + "      \"updatedAt\": \"2024-01-15T10:30:00Z\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"YXJyYXljb25uZWN0aW9uOjEwMA==\",\n"
                + "    \"hasNextPage\": false\n"
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
    public void testCreatePlanOrders() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(
                        TestResources.loadResource("/wire-tests/BetaApisWireTest_testCreatePlanOrders_response.json")));
        PlanOrdersCreatePlanOrdersResponseBody response = client.betaApis()
                .createPlanOrders(PlanOrdersCreatePlanOrdersRequestBody.builder()
                        .data(Arrays.asList(OrderInputObjectRequestBody.builder()
                                .customerOrderId("ORDER-2024-001")
                                .hubId("550e8400-e29b-41d4-a716-446655440000")
                                .planId("650e8400-e29b-41d4-a716-446655440023")
                                .build()))
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"data\": [\n"
                + "    {\n"
                + "      \"customerOrderId\": \"ORDER-2024-001\",\n"
                + "      \"hubId\": \"550e8400-e29b-41d4-a716-446655440000\",\n"
                + "      \"planId\": \"650e8400-e29b-41d4-a716-446655440023\"\n"
                + "    }\n"
                + "  ]\n"
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
                TestResources.loadResource("/wire-tests/BetaApisWireTest_testCreatePlanOrders_response.json");
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
    public void testGetQualificationRecords() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/BetaApisWireTest_testGetQualificationRecords_response.json")));
        QualificationsGetQualificationRecordsResponseBody response = client.betaApis()
                .getQualificationRecords(
                        GetQualificationRecordsRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/BetaApisWireTest_testGetQualificationRecords_response.json");
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
    public void testPostQualificationRecord() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/BetaApisWireTest_testPostQualificationRecord_response.json")));
        QualificationsPostQualificationRecordResponseBody response = client.betaApis()
                .postQualificationRecord(QualificationsPostQualificationRecordRequestBody.builder()
                        .issueDate(OffsetDateTime.parse("2025-08-27T10:20:30Z"))
                        .owner(QualificationOwnerRequestObjectRequestBody.builder()
                                .entityType(QualificationOwnerRequestObjectRequestBodyEntityType.WORKER)
                                .id("281474")
                                .build())
                        .qualificationType(QualificationTypeRequestObjectRequestBody.builder()
                                .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
                                .build())
                        .fields(Optional.of(
                                Arrays.asList(QualificationRecordRequestFieldInputObjectRequestBody.builder()
                                        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
                                        .type(QualificationRecordRequestFieldInputObjectRequestBodyType.NUMBER)
                                        .build())))
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"fields\": [\n"
                + "    {\n"
                + "      \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\n"
                + "      \"type\": \"number\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"issueDate\": \"2025-08-27T10:20:30Z\",\n"
                + "  \"owner\": {\n"
                + "    \"entityType\": \"worker\",\n"
                + "    \"id\": \"281474\"\n"
                + "  },\n"
                + "  \"qualificationType\": {\n"
                + "    \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\"\n"
                + "  }\n"
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
                TestResources.loadResource("/wire-tests/BetaApisWireTest_testPostQualificationRecord_response.json");
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
    public void testDeleteQualificationRecord() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.betaApis()
                .deleteQualificationRecord(QualificationsDeleteQualificationRecordRequestBody.builder()
                        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\"\n" + "}";
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
    }

    @Test
    public void testPatchQualificationRecord() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/BetaApisWireTest_testPatchQualificationRecord_response.json")));
        QualificationsPatchQualificationRecordResponseBody response = client.betaApis()
                .patchQualificationRecord(QualificationsPatchQualificationRecordRequestBody.builder()
                        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
                        .issueDate(OffsetDateTime.parse("2025-08-27T10:20:30Z"))
                        .owner(QualificationOwnerRequestObjectRequestBody.builder()
                                .entityType(QualificationOwnerRequestObjectRequestBodyEntityType.WORKER)
                                .id("281474")
                                .build())
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\n"
                + "  \"issueDate\": \"2025-08-27T10:20:30Z\",\n"
                + "  \"owner\": {\n"
                + "    \"entityType\": \"worker\",\n"
                + "    \"id\": \"281474\"\n"
                + "  }\n"
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
                TestResources.loadResource("/wire-tests/BetaApisWireTest_testPatchQualificationRecord_response.json");
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
    public void testArchiveQualificationRecord() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.betaApis()
                .archiveQualificationRecord(QualificationsArchiveQualificationRecordRequestBody.builder()
                        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\"\n" + "}";
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
    }

    @Test
    public void testGetQualificationRecordsStream() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/BetaApisWireTest_testGetQualificationRecordsStream_response.json")));
        QualificationsGetQualificationRecordsStreamResponseBody response = client.betaApis()
                .getQualificationRecordsStream(GetQualificationRecordsStreamRequest.builder()
                        .entityType(GetQualificationRecordsStreamRequestEntityType.WORKER)
                        .startTime(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = TestResources.loadResource(
                "/wire-tests/BetaApisWireTest_testGetQualificationRecordsStream_response.json");
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
    public void testUnarchiveQualificationRecord() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.betaApis()
                .unarchiveQualificationRecord(QualificationsUnarchiveQualificationRecordRequestBody.builder()
                        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\"\n" + "}";
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
    }

    @Test
    public void testGetQualificationTypes() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/BetaApisWireTest_testGetQualificationTypes_response.json")));
        QualificationsGetQualificationTypesResponseBody response = client.betaApis()
                .getQualificationTypes(GetQualificationTypesRequest.builder()
                        .entityType(GetQualificationTypesRequestEntityType.WORKER)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/BetaApisWireTest_testGetQualificationTypes_response.json");
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
    public void testPostReadings() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.betaApis()
                .postReadings(ReadingsPostReadingsRequestBody.builder()
                        .data(Arrays.asList(ReadingDatapointRequestBody.builder()
                                .entityId("123451234512345")
                                .happenedAtTime("2023-10-27T10:00:00Z")
                                .readingId("airInletPressure")
                                .value(new HashMap<String, Object>() {
                                    {
                                        put("key", "value");
                                    }
                                })
                                .build()))
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"data\": [\n"
                + "    {\n"
                + "      \"entityId\": \"123451234512345\",\n"
                + "      \"entityType\": \"asset\",\n"
                + "      \"happenedAtTime\": \"2023-10-27T10:00:00Z\",\n"
                + "      \"readingId\": \"airInletPressure\",\n"
                + "      \"value\": {\n"
                + "        \"key\": \"value\"\n"
                + "      }\n"
                + "    }\n"
                + "  ]\n"
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
    }

    @Test
    public void testListReadingsDefinitions() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"category\":\"smartTrailer\",\"description\":\"Engine Speed\",\"entityType\":\"sensor\",\"enumValues\":[{\"label\":\"Critically High\",\"symbol\":\"criticallyHigh\"}],\"ingestionEnabled\":true,\"label\":\"engineRpm\",\"readingId\":\"12345\",\"type\":{\"key\":\"value\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        ReadingsListReadingsDefinitionsResponseBody response = client.betaApis()
                .listReadingsDefinitions(
                        ListReadingsDefinitionsRequest.builder().build());
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
                + "      \"category\": \"smartTrailer\",\n"
                + "      \"description\": \"Engine Speed\",\n"
                + "      \"entityType\": \"sensor\",\n"
                + "      \"enumValues\": [\n"
                + "        {\n"
                + "          \"label\": \"Critically High\",\n"
                + "          \"symbol\": \"criticallyHigh\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"ingestionEnabled\": true,\n"
                + "      \"label\": \"engineRpm\",\n"
                + "      \"readingId\": \"12345\",\n"
                + "      \"type\": {\n"
                + "        \"key\": \"value\"\n"
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
    public void testGetReadingsHistory() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"entityId\":\"123456\",\"externalIds\":{\"key\":\"value\"},\"happenedAtTime\":\"2020-01-27T07:06:25Z\",\"value\":{\"key\":\"value\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        ReadingsGetReadingsHistoryResponseBody response = client.betaApis()
                .getReadingsHistory(GetReadingsHistoryRequest.builder()
                        .readingId("readingId")
                        .entityType("entityType")
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
                + "      \"entityId\": \"123456\",\n"
                + "      \"externalIds\": {\n"
                + "        \"key\": \"value\"\n"
                + "      },\n"
                + "      \"happenedAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "      \"value\": {\n"
                + "        \"key\": \"value\"\n"
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
    public void testGetReadingsSnapshot() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"entityId\":\"123456\",\"externalIds\":{\"key\":\"value\"},\"happenedAtTime\":\"2020-01-27T07:06:25Z\",\"readingId\":\"engineSpeed\",\"value\":{\"key\":\"value\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        ReadingsGetReadingsSnapshotResponseBody response = client.betaApis()
                .getReadingsSnapshot(GetReadingsSnapshotRequest.builder()
                        .readingIds("readingIds")
                        .entityType("entityType")
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
                + "      \"entityId\": \"123456\",\n"
                + "      \"externalIds\": {\n"
                + "        \"key\": \"value\"\n"
                + "      },\n"
                + "      \"happenedAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "      \"readingId\": \"engineSpeed\",\n"
                + "      \"value\": {\n"
                + "        \"key\": \"value\"\n"
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
    public void testGetReportConfigs() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"columns\":[{\"dataType\":\"string\",\"name\":\"Asset: Id\"}],\"datasetId\":\"Assets\",\"filters\":{\"primaryTimeRange\":{\"endTime\":\"2019-06-13T21:08:25Z\",\"startTime\":\"2019-06-13T19:08:25Z\"}},\"id\":\"4f71fd67-54f0-41de-991c-ee1e031134d1\",\"name\":\"Asset Report\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        ReportsGetReportConfigsResponseBody response = client.betaApis()
                .getReportConfigs(GetReportConfigsRequest.builder().build());
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
                + "      \"columns\": [\n"
                + "        {\n"
                + "          \"dataType\": \"string\",\n"
                + "          \"name\": \"Asset: Id\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"datasetId\": \"Assets\",\n"
                + "      \"filters\": {\n"
                + "        \"primaryTimeRange\": {\n"
                + "          \"endTime\": \"2019-06-13T21:08:25Z\",\n"
                + "          \"startTime\": \"2019-06-13T19:08:25Z\"\n"
                + "        }\n"
                + "      },\n"
                + "      \"id\": \"4f71fd67-54f0-41de-991c-ee1e031134d1\",\n"
                + "      \"name\": \"Asset Report\"\n"
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
    public void testGetDatasets() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"displayName\":\"Assets\",\"fields\":[{\"dataType\":\"string\",\"displayName\":\"Asset: Name\",\"name\":\"Name\"}],\"hasTimeRangeFilter\":true,\"id\":\"Assets\",\"timeRangeLimitDays\":31}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        ReportsGetDatasetsResponseBody response =
                client.betaApis().getDatasets(GetDatasetsRequest.builder().build());
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
                + "      \"displayName\": \"Assets\",\n"
                + "      \"fields\": [\n"
                + "        {\n"
                + "          \"dataType\": \"string\",\n"
                + "          \"displayName\": \"Asset: Name\",\n"
                + "          \"name\": \"Name\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"hasTimeRangeFilter\": true,\n"
                + "      \"id\": \"Assets\",\n"
                + "      \"timeRangeLimitDays\": 31\n"
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
    public void testGetReportRuns() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"id\":\"4f71fd67-54f0-41de-991c-ee1e031134d1\",\"status\":\"complete\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        ReportsGetReportRunsResponseBody response =
                client.betaApis().getReportRuns(GetReportRunsRequest.builder().build());
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
                + "      \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"id\": \"4f71fd67-54f0-41de-991c-ee1e031134d1\",\n"
                + "      \"status\": \"complete\",\n"
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
    public void testCreateReportRun() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"id\":\"4f71fd67-54f0-41de-991c-ee1e031134d1\",\"status\":\"complete\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}}"));
        ReportsCreateReportRunResponseBody response = client.betaApis()
                .createReportRun(ReportsCreateReportRunRequestBody.builder()
                        .reportConfig(
                                CreateReportConfigObjectRequestBody.builder().build())
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"reportConfig\": {}\n" + "}";
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
                + "    \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"id\": \"4f71fd67-54f0-41de-991c-ee1e031134d1\",\n"
                + "    \"status\": \"complete\",\n"
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
    public void testGetReportRunData() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(
                        TestResources.loadResource("/wire-tests/BetaApisWireTest_testGetReportRunData_response.json")));
        ReportsGetReportRunDataResponseBody response = client.betaApis()
                .getReportRunData(GetReportRunDataRequest.builder().id("id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/BetaApisWireTest_testGetReportRunData_response.json");
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
    public void testGetDriverSafetyScores() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"behaviors\":[{\"behaviorType\":\"acceleration\",\"count\":5,\"scoreImpact\":-18.91020325321117}],\"driveDistanceMeters\":2207296,\"driveTimeMilliseconds\":136997730,\"driverId\":\"1234\",\"driverScore\":92,\"speeding\":[{\"durationMilliseconds\":178773,\"scoreImpact\":-0.13049340306587562,\"speedingType\":\"light\"}]}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        SafetyScoresGetDriverSafetyScoresResponseBody response = client.betaApis()
                .getDriverSafetyScores(GetDriverSafetyScoresRequest.builder()
                        .endTime("endTime")
                        .startTime("startTime")
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
                + "      \"behaviors\": [\n"
                + "        {\n"
                + "          \"behaviorType\": \"acceleration\",\n"
                + "          \"count\": 5,\n"
                + "          \"scoreImpact\": -18.91020325321117\n"
                + "        }\n"
                + "      ],\n"
                + "      \"driveDistanceMeters\": 2207296,\n"
                + "      \"driveTimeMilliseconds\": 136997730,\n"
                + "      \"driverId\": \"1234\",\n"
                + "      \"driverScore\": 92,\n"
                + "      \"speeding\": [\n"
                + "        {\n"
                + "          \"durationMilliseconds\": 178773,\n"
                + "          \"scoreImpact\": -0.13049340306587562,\n"
                + "          \"speedingType\": \"light\"\n"
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
    public void testGetDriverSafetyScoreTrips() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/BetaApisWireTest_testGetDriverSafetyScoreTrips_response.json")));
        SafetyScoresGetDriverSafetyScoreTripsResponseBody response = client.betaApis()
                .getDriverSafetyScoreTrips(GetDriverSafetyScoreTripsRequest.builder()
                        .endTime("endTime")
                        .startTime("startTime")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/BetaApisWireTest_testGetDriverSafetyScoreTrips_response.json");
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
    public void testGetTagGroupSafetyScores() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"behaviors\":[{\"behaviorType\":\"acceleration\",\"count\":5,\"scoreImpact\":-18.91020325321117}],\"combinedScore\":92,\"driveDistanceMeters\":2207296,\"driveTimeMilliseconds\":136997730,\"speeding\":[{\"durationMilliseconds\":178773,\"scoreImpact\":-0.13049340306587562,\"speedingType\":\"light\"}]}}"));
        SafetyScoresGetTagGroupSafetyScoresResponseBody response = client.betaApis()
                .getTagGroupSafetyScores(GetTagGroupSafetyScoresRequest.builder()
                        .endTime("endTime")
                        .startTime("startTime")
                        .scoreType(GetTagGroupSafetyScoresRequestScoreType.DRIVER)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"behaviors\": [\n"
                + "      {\n"
                + "        \"behaviorType\": \"acceleration\",\n"
                + "        \"count\": 5,\n"
                + "        \"scoreImpact\": -18.91020325321117\n"
                + "      }\n"
                + "    ],\n"
                + "    \"combinedScore\": 92,\n"
                + "    \"driveDistanceMeters\": 2207296,\n"
                + "    \"driveTimeMilliseconds\": 136997730,\n"
                + "    \"speeding\": [\n"
                + "      {\n"
                + "        \"durationMilliseconds\": 178773,\n"
                + "        \"scoreImpact\": -0.13049340306587562,\n"
                + "        \"speedingType\": \"light\"\n"
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
    public void testGetTagSafetyScores() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"behaviors\":[{\"behaviorType\":\"acceleration\",\"count\":5,\"scoreImpact\":-18.91020325321117}],\"driveDistanceMeters\":2207296,\"driveTimeMilliseconds\":136997730,\"speeding\":[{\"durationMilliseconds\":178773,\"scoreImpact\":-0.13049340306587562,\"speedingType\":\"light\"}],\"tagId\":\"5678\",\"tagScore\":92}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        SafetyScoresGetTagSafetyScoresResponseBody response = client.betaApis()
                .getTagSafetyScores(GetTagSafetyScoresRequest.builder()
                        .endTime("endTime")
                        .startTime("startTime")
                        .scoreType(GetTagSafetyScoresRequestScoreType.DRIVER)
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
                + "      \"behaviors\": [\n"
                + "        {\n"
                + "          \"behaviorType\": \"acceleration\",\n"
                + "          \"count\": 5,\n"
                + "          \"scoreImpact\": -18.91020325321117\n"
                + "        }\n"
                + "      ],\n"
                + "      \"driveDistanceMeters\": 2207296,\n"
                + "      \"driveTimeMilliseconds\": 136997730,\n"
                + "      \"speeding\": [\n"
                + "        {\n"
                + "          \"durationMilliseconds\": 178773,\n"
                + "          \"scoreImpact\": -0.13049340306587562,\n"
                + "          \"speedingType\": \"light\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"tagId\": \"5678\",\n"
                + "      \"tagScore\": 92\n"
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
    public void testGetVehicleSafetyScores() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"behaviors\":[{\"behaviorType\":\"acceleration\",\"count\":5,\"scoreImpact\":-18.91020325321117}],\"driveDistanceMeters\":2207296,\"driveTimeMilliseconds\":136997730,\"speeding\":[{\"durationMilliseconds\":178773,\"scoreImpact\":-0.13049340306587562,\"speedingType\":\"light\"}],\"vehicleId\":\"5678\",\"vehicleScore\":92}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        SafetyScoresGetVehicleSafetyScoresResponseBody response = client.betaApis()
                .getVehicleSafetyScores(GetVehicleSafetyScoresRequest.builder()
                        .endTime("endTime")
                        .startTime("startTime")
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
                + "      \"behaviors\": [\n"
                + "        {\n"
                + "          \"behaviorType\": \"acceleration\",\n"
                + "          \"count\": 5,\n"
                + "          \"scoreImpact\": -18.91020325321117\n"
                + "        }\n"
                + "      ],\n"
                + "      \"driveDistanceMeters\": 2207296,\n"
                + "      \"driveTimeMilliseconds\": 136997730,\n"
                + "      \"speeding\": [\n"
                + "        {\n"
                + "          \"durationMilliseconds\": 178773,\n"
                + "          \"scoreImpact\": -0.13049340306587562,\n"
                + "          \"speedingType\": \"light\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"vehicleId\": \"5678\",\n"
                + "      \"vehicleScore\": 92\n"
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
    public void testGetVehicleSafetyScoreTrips() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/BetaApisWireTest_testGetVehicleSafetyScoreTrips_response.json")));
        SafetyScoresGetVehicleSafetyScoreTripsResponseBody response = client.betaApis()
                .getVehicleSafetyScoreTrips(GetVehicleSafetyScoreTripsRequest.builder()
                        .endTime("endTime")
                        .startTime("startTime")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/BetaApisWireTest_testGetVehicleSafetyScoreTrips_response.json");
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
