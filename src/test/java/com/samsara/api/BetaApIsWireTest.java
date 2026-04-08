package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.betaapis.requests.DeleteFunctionRequest;
import com.samsara.api.resources.betaapis.requests.DeleteJobRequest;
import com.samsara.api.resources.betaapis.requests.DeleteRidershipAccountRequest;
import com.samsara.api.resources.betaapis.requests.DeleteRidershipPassengerRequest;
import com.samsara.api.resources.betaapis.requests.DeleteRidershipRouteSetupRequest;
import com.samsara.api.resources.betaapis.requests.DeployFunctionRequest;
import com.samsara.api.resources.betaapis.requests.DeviceRecoveryMarkAssetMissingRequestBody;
import com.samsara.api.resources.betaapis.requests.DeviceRecoveryRecoverAssetRequestBody;
import com.samsara.api.resources.betaapis.requests.DriverWorkflowAssignmentsPostDriverWorkflowAssignmentRequestBody;
import com.samsara.api.resources.betaapis.requests.EngineImmobilizerUpdateEngineImmobilizerStateRequestBody;
import com.samsara.api.resources.betaapis.requests.EquipmentPatchEquipmentRequestBody;
import com.samsara.api.resources.betaapis.requests.FunctionsCreateFunctionRequestBody;
import com.samsara.api.resources.betaapis.requests.FunctionsPatchFunctionRequestBody;
import com.samsara.api.resources.betaapis.requests.FunctionsStartFunctionRunRequestBody;
import com.samsara.api.resources.betaapis.requests.GetAempEquipmentListRequest;
import com.samsara.api.resources.betaapis.requests.GetAssetsInputsRequest;
import com.samsara.api.resources.betaapis.requests.GetDatasetsRequest;
import com.samsara.api.resources.betaapis.requests.GetDepreciationTransactionsRequest;
import com.samsara.api.resources.betaapis.requests.GetDetectionsRequest;
import com.samsara.api.resources.betaapis.requests.GetDevicesRequest;
import com.samsara.api.resources.betaapis.requests.GetDriverEfficiencyRequest;
import com.samsara.api.resources.betaapis.requests.GetEngineImmobilizerStatesRequest;
import com.samsara.api.resources.betaapis.requests.GetFunctionRequest;
import com.samsara.api.resources.betaapis.requests.GetFunctionRunRequest;
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
import com.samsara.api.resources.betaapis.requests.GetRidershipAccountRequest;
import com.samsara.api.resources.betaapis.requests.GetRidershipPassengerRequest;
import com.samsara.api.resources.betaapis.requests.GetRidershipRouteSetupRequest;
import com.samsara.api.resources.betaapis.requests.HosDailyLogsUpdateShippingDocsRequestBody;
import com.samsara.api.resources.betaapis.requests.JobsCreateJobRequestBody;
import com.samsara.api.resources.betaapis.requests.JobsPatchJobRequestBody;
import com.samsara.api.resources.betaapis.requests.ListAssociationsRequest;
import com.samsara.api.resources.betaapis.requests.ListDeviceRecoveryMissingAssetsRequest;
import com.samsara.api.resources.betaapis.requests.ListHubCustomPropertiesRequest;
import com.samsara.api.resources.betaapis.requests.ListMaintenanceVendorsRequest;
import com.samsara.api.resources.betaapis.requests.ListReadingsDefinitionsRequest;
import com.samsara.api.resources.betaapis.requests.ListRidershipAccountsRequest;
import com.samsara.api.resources.betaapis.requests.ListRidershipPassengersRequest;
import com.samsara.api.resources.betaapis.requests.ListRidershipRouteSetupsRequest;
import com.samsara.api.resources.betaapis.requests.ListTachographLiveDataRequest;
import com.samsara.api.resources.betaapis.requests.ListVendorCategoriesRequest;
import com.samsara.api.resources.betaapis.requests.PlanOrdersCreatePlanOrdersRequestBody;
import com.samsara.api.resources.betaapis.requests.QualificationsArchiveQualificationRecordRequestBody;
import com.samsara.api.resources.betaapis.requests.QualificationsDeleteQualificationRecordRequestBody;
import com.samsara.api.resources.betaapis.requests.QualificationsPatchQualificationRecordRequestBody;
import com.samsara.api.resources.betaapis.requests.QualificationsPostQualificationRecordRequestBody;
import com.samsara.api.resources.betaapis.requests.QualificationsUnarchiveQualificationRecordRequestBody;
import com.samsara.api.resources.betaapis.requests.ReadingsPostReadingsRequestBody;
import com.samsara.api.resources.betaapis.requests.ReportsCreateReportRunRequestBody;
import com.samsara.api.resources.betaapis.requests.ResolveAssignmentByDetailsResolveAssignmentByDetailsRequestBody;
import com.samsara.api.resources.betaapis.requests.RidershipAccountsCreateRidershipAccountRequestBody;
import com.samsara.api.resources.betaapis.requests.RidershipAccountsUpdateRidershipAccountRequestBody;
import com.samsara.api.resources.betaapis.requests.RidershipPassengersCreateRidershipPassengerRequestBody;
import com.samsara.api.resources.betaapis.requests.RidershipPassengersUpdateRidershipPassengerRequestBody;
import com.samsara.api.resources.betaapis.requests.RidershipRouteSetupsCreateRidershipRouteSetupRequestBody;
import com.samsara.api.resources.betaapis.requests.RidershipRouteSetupsUpdateRidershipRouteSetupRequestBody;
import com.samsara.api.resources.betaapis.types.DeviceRecoveryRecoverAssetRequestBodyMissingReason;
import com.samsara.api.resources.betaapis.types.DeviceRecoveryRecoverAssetRequestBodyRecoveryStatus;
import com.samsara.api.resources.betaapis.types.DeviceRecoveryRecoverAssetRequestBodyStatus;
import com.samsara.api.resources.betaapis.types.FunctionsStartFunctionRunRequestBodyParamsOverride;
import com.samsara.api.resources.betaapis.types.GetAssetsInputsRequestType;
import com.samsara.api.resources.betaapis.types.GetQualificationRecordsStreamRequestEntityType;
import com.samsara.api.resources.betaapis.types.GetQualificationTypesRequestEntityType;
import com.samsara.api.types.AempEquipmentGetAempEquipmentListResponseBody;
import com.samsara.api.types.AssetsInputsGetAssetsInputsResponseBody;
import com.samsara.api.types.AssociationsListAssociationsResponseBody;
import com.samsara.api.types.CreateFunctionRequestConfigRequestBody;
import com.samsara.api.types.CreateReportConfigObjectRequestBody;
import com.samsara.api.types.DepreciationGetDepreciationTransactionsResponseBody;
import com.samsara.api.types.DetectionLogGetDetectionsResponseBody;
import com.samsara.api.types.DeviceRecoveryListDeviceRecoveryMissingAssetsResponseBody;
import com.samsara.api.types.DeviceRecoveryMarkAssetMissingResponseBody;
import com.samsara.api.types.DeviceRecoveryRecoverAssetResponseBody;
import com.samsara.api.types.DevicesGetDevicesResponseBody;
import com.samsara.api.types.DriverEfficienciesResponse;
import com.samsara.api.types.DriverWorkflowAssignmentsPostDriverWorkflowAssignmentResponseBody;
import com.samsara.api.types.EngineImmobilizerGetEngineImmobilizerStatesResponseBody;
import com.samsara.api.types.EntityTachographLiveDataRecordsServiceListTachographLiveDataResponseBody;
import com.samsara.api.types.EquipmentPatchEquipmentResponseBody;
import com.samsara.api.types.FunctionsCreateFunctionResponseBody;
import com.samsara.api.types.FunctionsDeployFunctionResponseBody;
import com.samsara.api.types.FunctionsGetFunctionResponseBody;
import com.samsara.api.types.FunctionsGetFunctionRunResponseBody;
import com.samsara.api.types.FunctionsPatchFunctionResponseBody;
import com.samsara.api.types.FunctionsStartFunctionRunResponseBody;
import com.samsara.api.types.HosDailyLogsUpdateShippingDocsResponseBody;
import com.samsara.api.types.HosEldEventsGetHosEldEventsResponseBody;
import com.samsara.api.types.HubCustomPropertiesListHubCustomPropertiesResponseBody;
import com.samsara.api.types.JobsCreateJobResponseBody;
import com.samsara.api.types.JobsDeleteJobResponseBody;
import com.samsara.api.types.JobsGetJobsResponseBody;
import com.samsara.api.types.JobsPatchJobResponseBody;
import com.samsara.api.types.MaintenanceVendorsListMaintenanceVendorsResponseBody;
import com.samsara.api.types.MaintenanceVendorsListVendorCategoriesResponseBody;
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
import com.samsara.api.types.ReadingDatapointRequestBodyEntityType;
import com.samsara.api.types.ReadingsGetReadingsHistoryResponseBody;
import com.samsara.api.types.ReadingsGetReadingsSnapshotResponseBody;
import com.samsara.api.types.ReadingsListReadingsDefinitionsResponseBody;
import com.samsara.api.types.ReportsCreateReportRunResponseBody;
import com.samsara.api.types.ReportsGetDatasetsResponseBody;
import com.samsara.api.types.ReportsGetReportConfigsResponseBody;
import com.samsara.api.types.ReportsGetReportRunDataResponseBody;
import com.samsara.api.types.ReportsGetReportRunsResponseBody;
import com.samsara.api.types.ResolveAssignmentByDetailsResolveAssignmentByDetailsResponseBody;
import com.samsara.api.types.RidershipAccountsCreateRidershipAccountResponseBody;
import com.samsara.api.types.RidershipAccountsGetRidershipAccountResponseBody;
import com.samsara.api.types.RidershipAccountsListRidershipAccountsResponseBody;
import com.samsara.api.types.RidershipAccountsUpdateRidershipAccountResponseBody;
import com.samsara.api.types.RidershipPassengersCreateRidershipPassengerResponseBody;
import com.samsara.api.types.RidershipPassengersGetRidershipPassengerResponseBody;
import com.samsara.api.types.RidershipPassengersListRidershipPassengersResponseBody;
import com.samsara.api.types.RidershipPassengersUpdateRidershipPassengerResponseBody;
import com.samsara.api.types.RidershipRouteSetupPassengerInputRequestBody;
import com.samsara.api.types.RidershipRouteSetupsCreateRidershipRouteSetupResponseBody;
import com.samsara.api.types.RidershipRouteSetupsGetRidershipRouteSetupResponseBody;
import com.samsara.api.types.RidershipRouteSetupsListRidershipRouteSetupsResponseBody;
import com.samsara.api.types.RidershipRouteSetupsUpdateRidershipRouteSetupResponseBody;
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

public class BetaApIsWireTest {
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
        DepreciationGetDepreciationTransactionsResponseBody response = client.betaApIs()
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
                .setBody(TestResources.loadResource("/wire-tests/BetaApIsWireTest_testGetAssetsInputs_response.json")));
        AssetsInputsGetAssetsInputsResponseBody response = client.betaApIs()
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
                TestResources.loadResource("/wire-tests/BetaApIsWireTest_testGetAssetsInputs_response.json");
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
        AempEquipmentGetAempEquipmentListResponseBody response = client.betaApIs()
                .getAempEquipmentList(
                        "pageNumber", GetAempEquipmentListRequest.builder().build());
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
        DriverEfficienciesResponse response = client.betaApIs()
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
        EquipmentPatchEquipmentResponseBody response = client.betaApIs()
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
        HosEldEventsGetHosEldEventsResponseBody response = client.betaApIs()
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
    public void testUpdateEngineImmobilizerState() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.betaApIs()
                .updateEngineImmobilizerState(
                        1000000L,
                        EngineImmobilizerUpdateEngineImmobilizerStateRequestBody.builder()
                                .relayStates(
                                        Arrays.asList(UpdateEngineImmobilizerRelayStateRequestBodyRequestBody.builder()
                                                .id(UpdateEngineImmobilizerRelayStateRequestBodyRequestBodyId.RELAY1)
                                                .isOpen(false)
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
                + "      \"isOpen\": false\n"
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
                client.betaApIs().getJobs(GetJobsRequest.builder().build());
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
        JobsCreateJobResponseBody response = client.betaApIs()
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
                client.betaApIs().deleteJob(DeleteJobRequest.builder().id("id").build());
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
        JobsPatchJobResponseBody response = client.betaApIs()
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
        DetectionLogGetDetectionsResponseBody response = client.betaApIs()
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
                client.betaApIs().getDevices(GetDevicesRequest.builder().build());
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
    public void testListAssociations() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"associationEndTime\":\"associationEndTime\",\"associationStartTime\":\"associationStartTime\",\"centralId\":\"centralId\",\"peripheralId\":\"peripheralId\",\"peripheralName\":\"peripheralName\"},{\"associationEndTime\":\"associationEndTime\",\"associationStartTime\":\"associationStartTime\",\"centralId\":\"centralId\",\"peripheralId\":\"peripheralId\",\"peripheralName\":\"peripheralName\"}],\"pagination\":{\"endCursor\":\"endCursor\",\"hasNextPage\":true}}"));
        AssociationsListAssociationsResponseBody response = client.betaApIs()
                .listAssociations(
                        ListAssociationsRequest.builder().startTime("startTime").build());
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
                + "      \"associationEndTime\": \"associationEndTime\",\n"
                + "      \"associationStartTime\": \"associationStartTime\",\n"
                + "      \"centralId\": \"centralId\",\n"
                + "      \"peripheralId\": \"peripheralId\",\n"
                + "      \"peripheralName\": \"peripheralName\"\n"
                + "    },\n"
                + "    {\n"
                + "      \"associationEndTime\": \"associationEndTime\",\n"
                + "      \"associationStartTime\": \"associationStartTime\",\n"
                + "      \"centralId\": \"centralId\",\n"
                + "      \"peripheralId\": \"peripheralId\",\n"
                + "      \"peripheralName\": \"peripheralName\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"endCursor\",\n"
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
    public void testListDeviceRecoveryMissingAssets() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"id\":\"12345\",\"initiated_at_ms\":1609459200000,\"initiated_by_user_id\":1234,\"name\":\"Trailer-A1234\",\"note\":\"Asset was last seen at warehouse A\",\"notification_recipients\":[{\"email\":\"jane.doe@example.com\",\"name\":\"Jane Doe\",\"notification_types\":[\"email\"],\"user_id\":1234}],\"update_source\":\"dashboard\",\"updated_at_ms\":1609459200000,\"updated_by_user_id\":1234}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DeviceRecoveryListDeviceRecoveryMissingAssetsResponseBody response = client.betaApIs()
                .listDeviceRecoveryMissingAssets(
                        ListDeviceRecoveryMissingAssetsRequest.builder().build());
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
                + "      \"id\": \"12345\",\n"
                + "      \"initiated_at_ms\": 1609459200000,\n"
                + "      \"initiated_by_user_id\": 1234,\n"
                + "      \"name\": \"Trailer-A1234\",\n"
                + "      \"note\": \"Asset was last seen at warehouse A\",\n"
                + "      \"notification_recipients\": [\n"
                + "        {\n"
                + "          \"email\": \"jane.doe@example.com\",\n"
                + "          \"name\": \"Jane Doe\",\n"
                + "          \"notification_types\": [\n"
                + "            \"email\"\n"
                + "          ],\n"
                + "          \"user_id\": 1234\n"
                + "        }\n"
                + "      ],\n"
                + "      \"update_source\": \"dashboard\",\n"
                + "      \"updated_at_ms\": 1609459200000,\n"
                + "      \"updated_by_user_id\": 1234\n"
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
    public void testMarkAssetMissing() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"id\":\"12345\",\"initiated_at_ms\":1609459200000,\"initiated_by_user_id\":1234,\"name\":\"Trailer-A1234\",\"note\":\"Asset was last seen at warehouse A\",\"notification_recipients\":[{\"email\":\"jane.doe@example.com\",\"name\":\"Jane Doe\",\"notification_types\":[\"email\"],\"user_id\":1234}],\"update_source\":\"dashboard\",\"updated_at_ms\":1609459200000,\"updated_by_user_id\":1234}}"));
        DeviceRecoveryMarkAssetMissingResponseBody response = client.betaApIs()
                .markAssetMissing(
                        "id",
                        DeviceRecoveryMarkAssetMissingRequestBody.builder().build());
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
                + "    \"id\": \"12345\",\n"
                + "    \"initiated_at_ms\": 1609459200000,\n"
                + "    \"initiated_by_user_id\": 1234,\n"
                + "    \"name\": \"Trailer-A1234\",\n"
                + "    \"note\": \"Asset was last seen at warehouse A\",\n"
                + "    \"notification_recipients\": [\n"
                + "      {\n"
                + "        \"email\": \"jane.doe@example.com\",\n"
                + "        \"name\": \"Jane Doe\",\n"
                + "        \"notification_types\": [\n"
                + "          \"email\"\n"
                + "        ],\n"
                + "        \"user_id\": 1234\n"
                + "      }\n"
                + "    ],\n"
                + "    \"update_source\": \"dashboard\",\n"
                + "    \"updated_at_ms\": 1609459200000,\n"
                + "    \"updated_by_user_id\": 1234\n"
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
    public void testRecoverAsset() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"id\":\"12345\",\"name\":\"Trailer-A1234\",\"note\":\"Asset was last seen at warehouse A\",\"notification_recipients\":[{\"email\":\"jane.doe@example.com\",\"name\":\"Jane Doe\",\"notification_types\":[\"email\"],\"user_id\":1234}],\"recovery_photos\":[{\"start_ms\":1609459200000,\"status\":\"EXISTS\",\"url\":\"https://s3.amazonaws.com/samsara-recovery-photos/example.jpg\",\"url_expires_at_ms\":1609462800000}],\"update_source\":\"dashboard\",\"updated_at_ms\":1609459200000,\"updated_by_user_id\":1234}}"));
        DeviceRecoveryRecoverAssetResponseBody response = client.betaApIs()
                .recoverAsset(
                        "id",
                        DeviceRecoveryRecoverAssetRequestBody.builder()
                                .missingReason(DeviceRecoveryRecoverAssetRequestBodyMissingReason.MISPLACED)
                                .recoveryStatus(DeviceRecoveryRecoverAssetRequestBodyRecoveryStatus.YES)
                                .status(DeviceRecoveryRecoverAssetRequestBodyStatus.RECOVERED)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"missing_reason\": \"MISPLACED\",\n"
                + "  \"recovery_status\": \"YES\",\n"
                + "  \"status\": \"RECOVERED\"\n"
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
                + "    \"id\": \"12345\",\n"
                + "    \"name\": \"Trailer-A1234\",\n"
                + "    \"note\": \"Asset was last seen at warehouse A\",\n"
                + "    \"notification_recipients\": [\n"
                + "      {\n"
                + "        \"email\": \"jane.doe@example.com\",\n"
                + "        \"name\": \"Jane Doe\",\n"
                + "        \"notification_types\": [\n"
                + "          \"email\"\n"
                + "        ],\n"
                + "        \"user_id\": 1234\n"
                + "      }\n"
                + "    ],\n"
                + "    \"recovery_photos\": [\n"
                + "      {\n"
                + "        \"start_ms\": 1609459200000,\n"
                + "        \"status\": \"EXISTS\",\n"
                + "        \"url\": \"https://s3.amazonaws.com/samsara-recovery-photos/example.jpg\",\n"
                + "        \"url_expires_at_ms\": 1609462800000\n"
                + "      }\n"
                + "    ],\n"
                + "    \"update_source\": \"dashboard\",\n"
                + "    \"updated_at_ms\": 1609459200000,\n"
                + "    \"updated_by_user_id\": 1234\n"
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
    public void testResolveAssignmentByDetails() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"data\":{\"driverId\":\"1234567\",\"driverName\":\"Jane Doe\"}}"));
        ResolveAssignmentByDetailsResolveAssignmentByDetailsResponseBody response = client.betaApIs()
                .resolveAssignmentByDetails(ResolveAssignmentByDetailsResolveAssignmentByDetailsRequestBody.builder()
                        .driverName("Jane Doe")
                        .vehicleId("281474978683353")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody =
                "" + "{\n" + "  \"driverName\": \"Jane Doe\",\n" + "  \"vehicleId\": \"281474978683353\"\n" + "}";
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
                + "    \"driverId\": \"1234567\",\n"
                + "    \"driverName\": \"Jane Doe\"\n"
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
    public void testPostDriverWorkflowAssignment() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"data\":{\"workflowId\":\"a4db8702-79d5-4396-a717-e301d52ecc11\"}}"));
        DriverWorkflowAssignmentsPostDriverWorkflowAssignmentResponseBody response = client.betaApIs()
                .postDriverWorkflowAssignment(DriverWorkflowAssignmentsPostDriverWorkflowAssignmentRequestBody.builder()
                        .workflowId("a4db8702-79d5-4396-a717-e301d52ecc11")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"workflowId\": \"a4db8702-79d5-4396-a717-e301d52ecc11\"\n" + "}";
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
                + "    \"workflowId\": \"a4db8702-79d5-4396-a717-e301d52ecc11\"\n"
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
    public void testListVendorCategories() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"id\":\"a1b2c3d4-e5f6-7890-abcd-ef1234567890\",\"name\":\"Tires\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        MaintenanceVendorsListVendorCategoriesResponseBody response = client.betaApIs()
                .listVendorCategories(ListVendorCategoriesRequest.builder().build());
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
                + "      \"id\": \"a1b2c3d4-e5f6-7890-abcd-ef1234567890\",\n"
                + "      \"name\": \"Tires\"\n"
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
    public void testListMaintenanceVendors() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"addressId\":\"281474993384538\",\"categoryIds\":[\"a1b2c3d4-e5f6-7890-abcd-ef1234567890\",\"a1b2c3d4-e5f6-7890-abcd-ef1234567890\"],\"externalIds\":{\"key\":\"value\"},\"id\":\"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\"servicesProvided\":\"Oil changes, tire rotations, brake services\",\"vendorId\":\"0000000772\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        MaintenanceVendorsListMaintenanceVendorsResponseBody response = client.betaApIs()
                .listMaintenanceVendors(ListMaintenanceVendorsRequest.builder().build());
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
                + "      \"addressId\": \"281474993384538\",\n"
                + "      \"categoryIds\": [\n"
                + "        \"a1b2c3d4-e5f6-7890-abcd-ef1234567890\",\n"
                + "        \"a1b2c3d4-e5f6-7890-abcd-ef1234567890\"\n"
                + "      ],\n"
                + "      \"externalIds\": {\n"
                + "        \"key\": \"value\"\n"
                + "      },\n"
                + "      \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\n"
                + "      \"servicesProvided\": \"Oil changes, tire rotations, brake services\",\n"
                + "      \"vendorId\": \"0000000772\"\n"
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
    public void testListTachographLiveData() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"cumulatedDrivingTimePreviousAndCurrentWeekMinute\":12345,\"cumulativeBreakTimeMinute\":12345,\"currentDailyDrivingTimeMinute\":12345,\"currentDurationOfSelectedActivityMinute\":12345,\"currentWeeklyDrivingTimeMinute\":12345,\"driverId\":\"12345\",\"durationOfNextBreakRestMinute\":12345,\"durationOfNextDrivingPeriodMinute\":12345,\"endOfLastDailyRestPeriod\":\"2019-06-13T19:08:25Z\",\"endOfLastWeeklyRestPeriod\":\"2019-06-13T19:08:25Z\",\"happenedAtTime\":\"2019-06-13T19:08:25Z\",\"maximumDailyDrivingTimeMinute\":12345,\"minimumDailyRestMinute\":12345,\"minimumWeeklyRestMinute\":12345,\"numberOfTimes9hDailyDrivingTimesExceeded\":12345,\"numberOfUsedReducedDailyRestPeriods\":12345,\"openCompensationInSecondWeekBeforeLastMinute\":12345,\"openCompensationInTheLastWeekMinute\":12345,\"openCompensationInWeekBeforeLastMinute\":12345,\"remaining2WeeksDrivingTimeMinute\":12345,\"remainingCurrentDrivingTimeMinute\":12345,\"remainingDrivingTimeOfCurrentWeekMinute\":12345,\"remainingDrivingTimeOnCurrentShiftMinute\":12345,\"remainingTimeOfCurrentBreakRestMinute\":12345,\"remainingTimeUntilNextBreakOrRestMinute\":12345,\"tachographCardNumber\":\"12345\",\"timeLeftUntilNewDailyRestPeriodMinute\":12345,\"timeLeftUntilNewWeeklyRestPeriodMinute\":12345,\"timeLeftUntilNextDrivingPeriodMinute\":12345,\"vehicleId\":\"12345\",\"workingState\":\"12345\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        EntityTachographLiveDataRecordsServiceListTachographLiveDataResponseBody response = client.betaApIs()
                .listTachographLiveData(ListTachographLiveDataRequest.builder().build());
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
                + "      \"cumulatedDrivingTimePreviousAndCurrentWeekMinute\": 12345,\n"
                + "      \"cumulativeBreakTimeMinute\": 12345,\n"
                + "      \"currentDailyDrivingTimeMinute\": 12345,\n"
                + "      \"currentDurationOfSelectedActivityMinute\": 12345,\n"
                + "      \"currentWeeklyDrivingTimeMinute\": 12345,\n"
                + "      \"driverId\": \"12345\",\n"
                + "      \"durationOfNextBreakRestMinute\": 12345,\n"
                + "      \"durationOfNextDrivingPeriodMinute\": 12345,\n"
                + "      \"endOfLastDailyRestPeriod\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"endOfLastWeeklyRestPeriod\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"happenedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"maximumDailyDrivingTimeMinute\": 12345,\n"
                + "      \"minimumDailyRestMinute\": 12345,\n"
                + "      \"minimumWeeklyRestMinute\": 12345,\n"
                + "      \"numberOfTimes9hDailyDrivingTimesExceeded\": 12345,\n"
                + "      \"numberOfUsedReducedDailyRestPeriods\": 12345,\n"
                + "      \"openCompensationInSecondWeekBeforeLastMinute\": 12345,\n"
                + "      \"openCompensationInTheLastWeekMinute\": 12345,\n"
                + "      \"openCompensationInWeekBeforeLastMinute\": 12345,\n"
                + "      \"remaining2WeeksDrivingTimeMinute\": 12345,\n"
                + "      \"remainingCurrentDrivingTimeMinute\": 12345,\n"
                + "      \"remainingDrivingTimeOfCurrentWeekMinute\": 12345,\n"
                + "      \"remainingDrivingTimeOnCurrentShiftMinute\": 12345,\n"
                + "      \"remainingTimeOfCurrentBreakRestMinute\": 12345,\n"
                + "      \"remainingTimeUntilNextBreakOrRestMinute\": 12345,\n"
                + "      \"tachographCardNumber\": \"12345\",\n"
                + "      \"timeLeftUntilNewDailyRestPeriodMinute\": 12345,\n"
                + "      \"timeLeftUntilNewWeeklyRestPeriodMinute\": 12345,\n"
                + "      \"timeLeftUntilNextDrivingPeriodMinute\": 12345,\n"
                + "      \"vehicleId\": \"12345\",\n"
                + "      \"workingState\": \"12345\"\n"
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
                                "{\"data\":[{\"happenedAtTime\":\"2019-06-13T19:08:25Z\",\"isConnectedToVehicle\":false,\"relayStates\":[{\"id\":\"relay1\",\"isOpen\":true}],\"vehicleId\":\"1234\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        EngineImmobilizerGetEngineImmobilizerStatesResponseBody response = client.betaApIs()
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
                + "          \"isOpen\": true\n"
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
    public void testCreateFunction() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"codePackage\":{\"downloadGetUrl\":\"https://example.com/download?token=...\",\"status\":\"unknown\"},\"config\":{\"handler\":\"index.handler\",\"isScheduleEnabled\":true,\"params\":{},\"schedule\":{\"entries\":[{\"daysOfWeek\":[false,true,true,true,true,true,false],\"timeSinceMidnightMs\":32400000}],\"timezone\":\"America/Los_Angeles\"},\"secrets\":{}},\"createdAtTime\":\"2021-01-01T00:00:00Z\",\"description\":\"Processes incoming telemetry data.\",\"effects\":{\"nextScheduledAtTime\":\"2021-01-01T00:00:00Z\"},\"lastUpdateTimestampMs\":1609459200000,\"name\":\"my-function\",\"updatedAtTime\":\"2021-01-01T00:00:00Z\",\"uploadPutUrl\":\"https://example.com/upload?token=...\"}}"));
        FunctionsCreateFunctionResponseBody response = client.betaApIs()
                .createFunction(FunctionsCreateFunctionRequestBody.builder()
                        .config(CreateFunctionRequestConfigRequestBody.builder()
                                .handler("index.handler")
                                .build())
                        .name("my-function")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"config\": {\n"
                + "    \"handler\": \"index.handler\"\n"
                + "  },\n"
                + "  \"name\": \"my-function\"\n"
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
                + "    \"codePackage\": {\n"
                + "      \"downloadGetUrl\": \"https://example.com/download?token=...\",\n"
                + "      \"status\": \"unknown\"\n"
                + "    },\n"
                + "    \"config\": {\n"
                + "      \"handler\": \"index.handler\",\n"
                + "      \"isScheduleEnabled\": true,\n"
                + "      \"params\": {},\n"
                + "      \"schedule\": {\n"
                + "        \"entries\": [\n"
                + "          {\n"
                + "            \"daysOfWeek\": [\n"
                + "              false,\n"
                + "              true,\n"
                + "              true,\n"
                + "              true,\n"
                + "              true,\n"
                + "              true,\n"
                + "              false\n"
                + "            ],\n"
                + "            \"timeSinceMidnightMs\": 32400000\n"
                + "          }\n"
                + "        ],\n"
                + "        \"timezone\": \"America/Los_Angeles\"\n"
                + "      },\n"
                + "      \"secrets\": {}\n"
                + "    },\n"
                + "    \"createdAtTime\": \"2021-01-01T00:00:00Z\",\n"
                + "    \"description\": \"Processes incoming telemetry data.\",\n"
                + "    \"effects\": {\n"
                + "      \"nextScheduledAtTime\": \"2021-01-01T00:00:00Z\"\n"
                + "    },\n"
                + "    \"lastUpdateTimestampMs\": 1609459200000,\n"
                + "    \"name\": \"my-function\",\n"
                + "    \"updatedAtTime\": \"2021-01-01T00:00:00Z\",\n"
                + "    \"uploadPutUrl\": \"https://example.com/upload?token=...\"\n"
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
    public void testGetFunction() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"codePackage\":{\"downloadGetUrl\":\"https://example.com/download?token=...\",\"status\":\"unknown\"},\"config\":{\"handler\":\"index.handler\",\"isScheduleEnabled\":true,\"params\":{},\"schedule\":{\"entries\":[{\"daysOfWeek\":[false,true,true,true,true,true,false],\"timeSinceMidnightMs\":32400000}],\"timezone\":\"America/Los_Angeles\"},\"secrets\":{}},\"createdAtTime\":\"2021-01-01T00:00:00Z\",\"description\":\"Processes incoming telemetry data.\",\"effects\":{\"nextScheduledAtTime\":\"2021-01-01T00:00:00Z\"},\"lastUpdateTimestampMs\":1609459200000,\"name\":\"my-function\",\"updatedAtTime\":\"2021-01-01T00:00:00Z\"}}"));
        FunctionsGetFunctionResponseBody response = client.betaApIs()
                .getFunction("name", GetFunctionRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"codePackage\": {\n"
                + "      \"downloadGetUrl\": \"https://example.com/download?token=...\",\n"
                + "      \"status\": \"unknown\"\n"
                + "    },\n"
                + "    \"config\": {\n"
                + "      \"handler\": \"index.handler\",\n"
                + "      \"isScheduleEnabled\": true,\n"
                + "      \"params\": {},\n"
                + "      \"schedule\": {\n"
                + "        \"entries\": [\n"
                + "          {\n"
                + "            \"daysOfWeek\": [\n"
                + "              false,\n"
                + "              true,\n"
                + "              true,\n"
                + "              true,\n"
                + "              true,\n"
                + "              true,\n"
                + "              false\n"
                + "            ],\n"
                + "            \"timeSinceMidnightMs\": 32400000\n"
                + "          }\n"
                + "        ],\n"
                + "        \"timezone\": \"America/Los_Angeles\"\n"
                + "      },\n"
                + "      \"secrets\": {}\n"
                + "    },\n"
                + "    \"createdAtTime\": \"2021-01-01T00:00:00Z\",\n"
                + "    \"description\": \"Processes incoming telemetry data.\",\n"
                + "    \"effects\": {\n"
                + "      \"nextScheduledAtTime\": \"2021-01-01T00:00:00Z\"\n"
                + "    },\n"
                + "    \"lastUpdateTimestampMs\": 1609459200000,\n"
                + "    \"name\": \"my-function\",\n"
                + "    \"updatedAtTime\": \"2021-01-01T00:00:00Z\"\n"
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
    public void testDeleteFunction() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.betaApIs().deleteFunction("name", DeleteFunctionRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testPatchFunction() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"lastUpdateTimestampMs\":1609459200000,\"name\":\"my-function\",\"updatedAtTime\":\"2021-01-01T00:00:00Z\",\"uploadPutUrl\":\"https://example.com/upload?token=...\"}}"));
        FunctionsPatchFunctionResponseBody response = client.betaApIs()
                .patchFunction(
                        "name",
                        FunctionsPatchFunctionRequestBody.builder()
                                .lastUpdateTimestampMs(1609459200000L)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"lastUpdateTimestampMs\": 1609459200000\n" + "}";
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
                + "    \"lastUpdateTimestampMs\": 1609459200000,\n"
                + "    \"name\": \"my-function\",\n"
                + "    \"updatedAtTime\": \"2021-01-01T00:00:00Z\",\n"
                + "    \"uploadPutUrl\": \"https://example.com/upload?token=...\"\n"
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
    public void testDeployFunction() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{\"data\":{\"name\":\"my-function\"}}"));
        FunctionsDeployFunctionResponseBody response = client.betaApIs()
                .deployFunction("name", DeployFunctionRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                "" + "{\n" + "  \"data\": {\n" + "    \"name\": \"my-function\"\n" + "  }\n" + "}";
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
        FunctionsStartFunctionRunResponseBody response = client.betaApIs()
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
    public void testGetFunctionRun() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"completedAtTime\":\"2021-01-01T00:00:30Z\",\"context\":{\"requestId\":\"req-550e8400-e29b-41d4-a716-446655440000\",\"requestPayload\":{\"key\":\"value\"},\"responsePayload\":{\"key\":\"value\"}},\"correlationId\":\"550e8400-e29b-41d4-a716-446655440000\",\"name\":\"my-function\",\"startedAtTime\":\"2021-01-01T00:00:00Z\",\"status\":\"started\"}}"));
        FunctionsGetFunctionRunResponseBody response = client.betaApIs()
                .getFunctionRun(
                        "name", "correlationId", GetFunctionRunRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"completedAtTime\": \"2021-01-01T00:00:30Z\",\n"
                + "    \"context\": {\n"
                + "      \"requestId\": \"req-550e8400-e29b-41d4-a716-446655440000\",\n"
                + "      \"requestPayload\": {\n"
                + "        \"key\": \"value\"\n"
                + "      },\n"
                + "      \"responsePayload\": {\n"
                + "        \"key\": \"value\"\n"
                + "      }\n"
                + "    },\n"
                + "    \"correlationId\": \"550e8400-e29b-41d4-a716-446655440000\",\n"
                + "    \"name\": \"my-function\",\n"
                + "    \"startedAtTime\": \"2021-01-01T00:00:00Z\",\n"
                + "    \"status\": \"started\"\n"
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
                                "{\"data\":{\"adverseDrivingClaimed\":true,\"bigDayClaimed\":true,\"carrierFormattedAddress\":\"1990 Alameda Street, San Francisco, CA 94103\",\"carrierName\":\"Carrier Name\",\"carrierUsDotNumber\":1234,\"homeTerminalFormattedAddress\":\"1990 Alameda Street, San Francisco, CA 94103\",\"homeTerminalName\":\"Home Terminal Name\",\"isCertified\":true,\"isUsShortHaulActive\":false,\"trailerNames\":[\"10293\",\"Trailer ID 1\"]}}"));
        HosDailyLogsUpdateShippingDocsResponseBody response = client.betaApIs()
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
                + "    \"adverseDrivingClaimed\": true,\n"
                + "    \"bigDayClaimed\": true,\n"
                + "    \"carrierFormattedAddress\": \"1990 Alameda Street, San Francisco, CA 94103\",\n"
                + "    \"carrierName\": \"Carrier Name\",\n"
                + "    \"carrierUsDotNumber\": 1234,\n"
                + "    \"homeTerminalFormattedAddress\": \"1990 Alameda Street, San Francisco, CA 94103\",\n"
                + "    \"homeTerminalName\": \"Home Terminal Name\",\n"
                + "    \"isCertified\": true,\n"
                + "    \"isUsShortHaulActive\": false,\n"
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
        HubCustomPropertiesListHubCustomPropertiesResponseBody response = client.betaApIs()
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
                        TestResources.loadResource("/wire-tests/BetaApIsWireTest_testCreatePlanOrders_response.json")));
        PlanOrdersCreatePlanOrdersResponseBody response = client.betaApIs()
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
                TestResources.loadResource("/wire-tests/BetaApIsWireTest_testCreatePlanOrders_response.json");
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
                        "/wire-tests/BetaApIsWireTest_testGetQualificationRecords_response.json")));
        QualificationsGetQualificationRecordsResponseBody response = client.betaApIs()
                .getQualificationRecords(
                        GetQualificationRecordsRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/BetaApIsWireTest_testGetQualificationRecords_response.json");
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
                        "/wire-tests/BetaApIsWireTest_testPostQualificationRecord_response.json")));
        QualificationsPostQualificationRecordResponseBody response = client.betaApIs()
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
                TestResources.loadResource("/wire-tests/BetaApIsWireTest_testPostQualificationRecord_response.json");
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
        client.betaApIs()
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
                        "/wire-tests/BetaApIsWireTest_testPatchQualificationRecord_response.json")));
        QualificationsPatchQualificationRecordResponseBody response = client.betaApIs()
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
                TestResources.loadResource("/wire-tests/BetaApIsWireTest_testPatchQualificationRecord_response.json");
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
        client.betaApIs()
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
                        "/wire-tests/BetaApIsWireTest_testGetQualificationRecordsStream_response.json")));
        QualificationsGetQualificationRecordsStreamResponseBody response = client.betaApIs()
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
                "/wire-tests/BetaApIsWireTest_testGetQualificationRecordsStream_response.json");
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
        client.betaApIs()
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
                        "/wire-tests/BetaApIsWireTest_testGetQualificationTypes_response.json")));
        QualificationsGetQualificationTypesResponseBody response = client.betaApIs()
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
                TestResources.loadResource("/wire-tests/BetaApIsWireTest_testGetQualificationTypes_response.json");
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
        client.betaApIs()
                .postReadings(ReadingsPostReadingsRequestBody.builder()
                        .data(Arrays.asList(ReadingDatapointRequestBody.builder()
                                .entityId("123451234512345")
                                .entityType(ReadingDatapointRequestBodyEntityType.ASSET)
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
        ReadingsListReadingsDefinitionsResponseBody response = client.betaApIs()
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
        ReadingsGetReadingsHistoryResponseBody response = client.betaApIs()
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
        ReadingsGetReadingsSnapshotResponseBody response = client.betaApIs()
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
        ReportsGetReportConfigsResponseBody response = client.betaApIs()
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
                client.betaApIs().getDatasets(GetDatasetsRequest.builder().build());
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
                client.betaApIs().getReportRuns(GetReportRunsRequest.builder().build());
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
        ReportsCreateReportRunResponseBody response = client.betaApIs()
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
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"columns\":[{\"dataType\":\"string\",\"name\":\"Device Name\"}],\"rows\":[[{\"key\":\"value\"},{\"key\":\"value\"}],[{\"key\":\"value\"},{\"key\":\"value\"},{\"key\":\"value\"}],[{\"key\":\"value\"},{\"key\":\"value\"},{\"key\":\"value\"}]],\"status\":\"complete\"},\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        ReportsGetReportRunDataResponseBody response = client.betaApIs()
                .getReportRunData(GetReportRunDataRequest.builder().id("id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"columns\": [\n"
                + "      {\n"
                + "        \"dataType\": \"string\",\n"
                + "        \"name\": \"Device Name\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"rows\": [\n"
                + "      [\n"
                + "        {\n"
                + "          \"key\": \"value\"\n"
                + "        },\n"
                + "        {\n"
                + "          \"key\": \"value\"\n"
                + "        }\n"
                + "      ],\n"
                + "      [\n"
                + "        {\n"
                + "          \"key\": \"value\"\n"
                + "        },\n"
                + "        {\n"
                + "          \"key\": \"value\"\n"
                + "        },\n"
                + "        {\n"
                + "          \"key\": \"value\"\n"
                + "        }\n"
                + "      ],\n"
                + "      [\n"
                + "        {\n"
                + "          \"key\": \"value\"\n"
                + "        },\n"
                + "        {\n"
                + "          \"key\": \"value\"\n"
                + "        },\n"
                + "        {\n"
                + "          \"key\": \"value\"\n"
                + "        }\n"
                + "      ]\n"
                + "    ],\n"
                + "    \"status\": \"complete\"\n"
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
    public void testListRidershipAccounts() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"createdAtTime\":\"2024-11-15T10:00:00Z\",\"externalIds\":{\"key\":\"value\"},\"id\":\"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\"name\":\"Springfield Public Schools\",\"updatedAtTime\":\"2024-11-15T10:30:00Z\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        RidershipAccountsListRidershipAccountsResponseBody response = client.betaApIs()
                .listRidershipAccounts(ListRidershipAccountsRequest.builder().build());
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
                + "      \"createdAtTime\": \"2024-11-15T10:00:00Z\",\n"
                + "      \"externalIds\": {\n"
                + "        \"key\": \"value\"\n"
                + "      },\n"
                + "      \"id\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "      \"name\": \"Springfield Public Schools\",\n"
                + "      \"updatedAtTime\": \"2024-11-15T10:30:00Z\"\n"
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
    public void testCreateRidershipAccount() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"createdAtTime\":\"2024-11-15T10:00:00Z\",\"externalIds\":{\"key\":\"value\"},\"id\":\"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\"name\":\"Springfield Public Schools\",\"updatedAtTime\":\"2024-11-15T10:30:00Z\"}}"));
        RidershipAccountsCreateRidershipAccountResponseBody response = client.betaApIs()
                .createRidershipAccount(RidershipAccountsCreateRidershipAccountRequestBody.builder()
                        .name("Springfield Public Schools")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"name\": \"Springfield Public Schools\"\n" + "}";
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
                + "    \"createdAtTime\": \"2024-11-15T10:00:00Z\",\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"id\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "    \"name\": \"Springfield Public Schools\",\n"
                + "    \"updatedAtTime\": \"2024-11-15T10:30:00Z\"\n"
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
    public void testUpdateRidershipAccount() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"createdAtTime\":\"2024-11-15T10:00:00Z\",\"externalIds\":{\"key\":\"value\"},\"id\":\"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\"name\":\"Springfield Public Schools\",\"updatedAtTime\":\"2024-11-15T10:30:00Z\"}}"));
        RidershipAccountsUpdateRidershipAccountResponseBody response = client.betaApIs()
                .updateRidershipAccount(RidershipAccountsUpdateRidershipAccountRequestBody.builder()
                        .id("id")
                        .name("Springfield Public Schools")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PUT", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"name\": \"Springfield Public Schools\"\n" + "}";
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
                + "    \"createdAtTime\": \"2024-11-15T10:00:00Z\",\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"id\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "    \"name\": \"Springfield Public Schools\",\n"
                + "    \"updatedAtTime\": \"2024-11-15T10:30:00Z\"\n"
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
    public void testDeleteRidershipAccount() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.betaApIs()
                .deleteRidershipAccount(
                        DeleteRidershipAccountRequest.builder().id("id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testGetRidershipAccount() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"createdAtTime\":\"2024-11-15T10:00:00Z\",\"externalIds\":{\"key\":\"value\"},\"id\":\"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\"name\":\"Springfield Public Schools\",\"updatedAtTime\":\"2024-11-15T10:30:00Z\"}}"));
        RidershipAccountsGetRidershipAccountResponseBody response = client.betaApIs()
                .getRidershipAccount("id", GetRidershipAccountRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"createdAtTime\": \"2024-11-15T10:00:00Z\",\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"id\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "    \"name\": \"Springfield Public Schools\",\n"
                + "    \"updatedAtTime\": \"2024-11-15T10:30:00Z\"\n"
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
    public void testListRidershipPassengers() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"accountId\":\"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\"classification\":\"grade5\",\"createdAtTime\":\"2024-11-15T10:00:00Z\",\"externalIds\":{\"key\":\"value\"},\"firstName\":\"John\",\"id\":\"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\"identifiers\":[{\"id\":\"b2c3d4e5-6f7a-8b9c-0d1e-2f3a4b5c6d7e\",\"status\":\"active\",\"type\":\"rfid\",\"value\":\"0418A2BC93\"}],\"isActive\":true,\"lastName\":\"Doe\",\"specialInstructions\":{\"isGuardianRequired\":false,\"isSpecialEducation\":false},\"updatedAtTime\":\"2024-11-15T10:30:00Z\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        RidershipPassengersListRidershipPassengersResponseBody response = client.betaApIs()
                .listRidershipPassengers(ListRidershipPassengersRequest.builder()
                        .accountId("accountId")
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
                + "      \"accountId\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "      \"classification\": \"grade5\",\n"
                + "      \"createdAtTime\": \"2024-11-15T10:00:00Z\",\n"
                + "      \"externalIds\": {\n"
                + "        \"key\": \"value\"\n"
                + "      },\n"
                + "      \"firstName\": \"John\",\n"
                + "      \"id\": \"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\n"
                + "      \"identifiers\": [\n"
                + "        {\n"
                + "          \"id\": \"b2c3d4e5-6f7a-8b9c-0d1e-2f3a4b5c6d7e\",\n"
                + "          \"status\": \"active\",\n"
                + "          \"type\": \"rfid\",\n"
                + "          \"value\": \"0418A2BC93\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"isActive\": true,\n"
                + "      \"lastName\": \"Doe\",\n"
                + "      \"specialInstructions\": {\n"
                + "        \"isGuardianRequired\": false,\n"
                + "        \"isSpecialEducation\": false\n"
                + "      },\n"
                + "      \"updatedAtTime\": \"2024-11-15T10:30:00Z\"\n"
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
    public void testCreateRidershipPassenger() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"accountId\":\"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\"classification\":\"grade5\",\"createdAtTime\":\"2024-11-15T10:00:00Z\",\"externalIds\":{\"key\":\"value\"},\"firstName\":\"John\",\"id\":\"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\"identifiers\":[{\"id\":\"b2c3d4e5-6f7a-8b9c-0d1e-2f3a4b5c6d7e\",\"status\":\"active\",\"type\":\"rfid\",\"value\":\"0418A2BC93\"}],\"isActive\":true,\"lastName\":\"Doe\",\"specialInstructions\":{\"isGuardianRequired\":false,\"isSpecialEducation\":false},\"updatedAtTime\":\"2024-11-15T10:30:00Z\"}}"));
        RidershipPassengersCreateRidershipPassengerResponseBody response = client.betaApIs()
                .createRidershipPassenger(RidershipPassengersCreateRidershipPassengerRequestBody.builder()
                        .accountId("e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b")
                        .firstName("John")
                        .lastName("Doe")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"accountId\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "  \"firstName\": \"John\",\n"
                + "  \"lastName\": \"Doe\"\n"
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
                + "    \"accountId\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "    \"classification\": \"grade5\",\n"
                + "    \"createdAtTime\": \"2024-11-15T10:00:00Z\",\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"firstName\": \"John\",\n"
                + "    \"id\": \"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\n"
                + "    \"identifiers\": [\n"
                + "      {\n"
                + "        \"id\": \"b2c3d4e5-6f7a-8b9c-0d1e-2f3a4b5c6d7e\",\n"
                + "        \"status\": \"active\",\n"
                + "        \"type\": \"rfid\",\n"
                + "        \"value\": \"0418A2BC93\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"isActive\": true,\n"
                + "    \"lastName\": \"Doe\",\n"
                + "    \"specialInstructions\": {\n"
                + "      \"isGuardianRequired\": false,\n"
                + "      \"isSpecialEducation\": false\n"
                + "    },\n"
                + "    \"updatedAtTime\": \"2024-11-15T10:30:00Z\"\n"
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
    public void testUpdateRidershipPassenger() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"accountId\":\"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\"classification\":\"grade5\",\"createdAtTime\":\"2024-11-15T10:00:00Z\",\"externalIds\":{\"key\":\"value\"},\"firstName\":\"John\",\"id\":\"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\"identifiers\":[{\"id\":\"b2c3d4e5-6f7a-8b9c-0d1e-2f3a4b5c6d7e\",\"status\":\"active\",\"type\":\"rfid\",\"value\":\"0418A2BC93\"}],\"isActive\":true,\"lastName\":\"Doe\",\"specialInstructions\":{\"isGuardianRequired\":false,\"isSpecialEducation\":false},\"updatedAtTime\":\"2024-11-15T10:30:00Z\"}}"));
        RidershipPassengersUpdateRidershipPassengerResponseBody response = client.betaApIs()
                .updateRidershipPassenger(RidershipPassengersUpdateRidershipPassengerRequestBody.builder()
                        .id("id")
                        .accountId("e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b")
                        .firstName("John")
                        .lastName("Doe")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PUT", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"accountId\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "  \"firstName\": \"John\",\n"
                + "  \"lastName\": \"Doe\"\n"
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
                + "    \"accountId\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "    \"classification\": \"grade5\",\n"
                + "    \"createdAtTime\": \"2024-11-15T10:00:00Z\",\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"firstName\": \"John\",\n"
                + "    \"id\": \"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\n"
                + "    \"identifiers\": [\n"
                + "      {\n"
                + "        \"id\": \"b2c3d4e5-6f7a-8b9c-0d1e-2f3a4b5c6d7e\",\n"
                + "        \"status\": \"active\",\n"
                + "        \"type\": \"rfid\",\n"
                + "        \"value\": \"0418A2BC93\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"isActive\": true,\n"
                + "    \"lastName\": \"Doe\",\n"
                + "    \"specialInstructions\": {\n"
                + "      \"isGuardianRequired\": false,\n"
                + "      \"isSpecialEducation\": false\n"
                + "    },\n"
                + "    \"updatedAtTime\": \"2024-11-15T10:30:00Z\"\n"
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
    public void testDeleteRidershipPassenger() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.betaApIs()
                .deleteRidershipPassenger(
                        DeleteRidershipPassengerRequest.builder().id("id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testGetRidershipPassenger() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"accountId\":\"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\"classification\":\"grade5\",\"createdAtTime\":\"2024-11-15T10:00:00Z\",\"externalIds\":{\"key\":\"value\"},\"firstName\":\"John\",\"id\":\"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\"identifiers\":[{\"id\":\"b2c3d4e5-6f7a-8b9c-0d1e-2f3a4b5c6d7e\",\"status\":\"active\",\"type\":\"rfid\",\"value\":\"0418A2BC93\"}],\"isActive\":true,\"lastName\":\"Doe\",\"specialInstructions\":{\"isGuardianRequired\":false,\"isSpecialEducation\":false},\"updatedAtTime\":\"2024-11-15T10:30:00Z\"}}"));
        RidershipPassengersGetRidershipPassengerResponseBody response = client.betaApIs()
                .getRidershipPassenger(
                        "id", GetRidershipPassengerRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"accountId\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "    \"classification\": \"grade5\",\n"
                + "    \"createdAtTime\": \"2024-11-15T10:00:00Z\",\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"firstName\": \"John\",\n"
                + "    \"id\": \"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\n"
                + "    \"identifiers\": [\n"
                + "      {\n"
                + "        \"id\": \"b2c3d4e5-6f7a-8b9c-0d1e-2f3a4b5c6d7e\",\n"
                + "        \"status\": \"active\",\n"
                + "        \"type\": \"rfid\",\n"
                + "        \"value\": \"0418A2BC93\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"isActive\": true,\n"
                + "    \"lastName\": \"Doe\",\n"
                + "    \"specialInstructions\": {\n"
                + "      \"isGuardianRequired\": false,\n"
                + "      \"isSpecialEducation\": false\n"
                + "    },\n"
                + "    \"updatedAtTime\": \"2024-11-15T10:30:00Z\"\n"
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
    public void testListRidershipRouteSetups() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"accountId\":\"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\"createdAtTime\":\"2024-11-15T10:00:00Z\",\"passengers\":[{\"dropOffStopId\":\"790\",\"passengerId\":\"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\"pickUpStopId\":\"789\"}],\"routeId\":\"123456\",\"updatedAtTime\":\"2024-11-15T10:30:00Z\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        RidershipRouteSetupsListRidershipRouteSetupsResponseBody response = client.betaApIs()
                .listRidershipRouteSetups(ListRidershipRouteSetupsRequest.builder()
                        .accountId("accountId")
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
                + "      \"accountId\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "      \"createdAtTime\": \"2024-11-15T10:00:00Z\",\n"
                + "      \"passengers\": [\n"
                + "        {\n"
                + "          \"dropOffStopId\": \"790\",\n"
                + "          \"passengerId\": \"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\n"
                + "          \"pickUpStopId\": \"789\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"routeId\": \"123456\",\n"
                + "      \"updatedAtTime\": \"2024-11-15T10:30:00Z\"\n"
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
    public void testCreateRidershipRouteSetup() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"accountId\":\"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\"createdAtTime\":\"2024-11-15T10:00:00Z\",\"passengers\":[{\"dropOffStopId\":\"790\",\"passengerId\":\"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\"pickUpStopId\":\"789\"}],\"routeId\":\"123456\",\"updatedAtTime\":\"2024-11-15T10:30:00Z\"}}"));
        RidershipRouteSetupsCreateRidershipRouteSetupResponseBody response = client.betaApIs()
                .createRidershipRouteSetup(RidershipRouteSetupsCreateRidershipRouteSetupRequestBody.builder()
                        .accountId("e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b")
                        .routeId("123456")
                        .passengers(Arrays.asList(RidershipRouteSetupPassengerInputRequestBody.builder()
                                .passengerId("a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d")
                                .build()))
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"accountId\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "  \"passengers\": [\n"
                + "    {\n"
                + "      \"passengerId\": \"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"routeId\": \"123456\"\n"
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
                + "    \"accountId\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "    \"createdAtTime\": \"2024-11-15T10:00:00Z\",\n"
                + "    \"passengers\": [\n"
                + "      {\n"
                + "        \"dropOffStopId\": \"790\",\n"
                + "        \"passengerId\": \"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\n"
                + "        \"pickUpStopId\": \"789\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"routeId\": \"123456\",\n"
                + "    \"updatedAtTime\": \"2024-11-15T10:30:00Z\"\n"
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
    public void testUpdateRidershipRouteSetup() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"accountId\":\"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\"createdAtTime\":\"2024-11-15T10:00:00Z\",\"passengers\":[{\"dropOffStopId\":\"790\",\"passengerId\":\"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\"pickUpStopId\":\"789\"}],\"routeId\":\"123456\",\"updatedAtTime\":\"2024-11-15T10:30:00Z\"}}"));
        RidershipRouteSetupsUpdateRidershipRouteSetupResponseBody response = client.betaApIs()
                .updateRidershipRouteSetup(RidershipRouteSetupsUpdateRidershipRouteSetupRequestBody.builder()
                        .routeId("routeId")
                        .accountId("e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b")
                        .passengers(Arrays.asList(RidershipRouteSetupPassengerInputRequestBody.builder()
                                .passengerId("a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d")
                                .build()))
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PUT", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"accountId\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "  \"passengers\": [\n"
                + "    {\n"
                + "      \"passengerId\": \"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\"\n"
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
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"accountId\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "    \"createdAtTime\": \"2024-11-15T10:00:00Z\",\n"
                + "    \"passengers\": [\n"
                + "      {\n"
                + "        \"dropOffStopId\": \"790\",\n"
                + "        \"passengerId\": \"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\n"
                + "        \"pickUpStopId\": \"789\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"routeId\": \"123456\",\n"
                + "    \"updatedAtTime\": \"2024-11-15T10:30:00Z\"\n"
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
    public void testDeleteRidershipRouteSetup() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.betaApIs()
                .deleteRidershipRouteSetup(DeleteRidershipRouteSetupRequest.builder()
                        .routeId("routeId")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testGetRidershipRouteSetup() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"accountId\":\"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\"createdAtTime\":\"2024-11-15T10:00:00Z\",\"passengers\":[{\"dropOffStopId\":\"790\",\"passengerId\":\"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\"pickUpStopId\":\"789\"}],\"routeId\":\"123456\",\"updatedAtTime\":\"2024-11-15T10:30:00Z\"}}"));
        RidershipRouteSetupsGetRidershipRouteSetupResponseBody response = client.betaApIs()
                .getRidershipRouteSetup(
                        "routeId", GetRidershipRouteSetupRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"accountId\": \"e4b2c3a5-7d6f-4e8b-9a0c-1b2d3e4f5a6b\",\n"
                + "    \"createdAtTime\": \"2024-11-15T10:00:00Z\",\n"
                + "    \"passengers\": [\n"
                + "      {\n"
                + "        \"dropOffStopId\": \"790\",\n"
                + "        \"passengerId\": \"a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d\",\n"
                + "        \"pickUpStopId\": \"789\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"routeId\": \"123456\",\n"
                + "    \"updatedAtTime\": \"2024-11-15T10:30:00Z\"\n"
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
