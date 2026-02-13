package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.legacyapis.requests.GetDriversVehicleAssignmentsRequest;
import com.samsara.api.resources.legacyapis.requests.GetDvirDefectsRequest;
import com.samsara.api.resources.legacyapis.requests.GetDvirHistoryRequest;
import com.samsara.api.resources.legacyapis.requests.GetSafetyActivityEventFeedRequest;
import com.samsara.api.resources.legacyapis.requests.GetSafetyEventsRequest;
import com.samsara.api.resources.legacyapis.requests.GetVehicleIdlingReportsRequest;
import com.samsara.api.resources.legacyapis.requests.GetVehiclesDriverAssignmentsRequest;
import com.samsara.api.resources.legacyapis.requests.V1GetVehicleHarshEventRequest;
import com.samsara.api.types.DefectsResponse;
import com.samsara.api.types.DriversVehicleAssignmentsGetDriversVehicleAssignmentsResponseBody;
import com.samsara.api.types.DvirsListResponse;
import com.samsara.api.types.IdlingReportsGetVehicleIdlingReportsResponseBody;
import com.samsara.api.types.SafetyEventsGetSafetyActivityEventFeedResponseBody;
import com.samsara.api.types.SafetyEventsListResponse;
import com.samsara.api.types.V1VehicleHarshEventResponse;
import com.samsara.api.types.VehiclesDriverAssignmentsGetVehiclesDriverAssignmentsResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LegacyApIsWireTest {
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
    public void testGetDvirDefects() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"comment\":\"Air Compressor not working\",\"createdAtTime\":\"2020-01-27T07:06:25Z\",\"defectType\":\"Air Compressor\",\"id\":\"18\",\"isResolved\":true,\"mechanicNotes\":\"Extremely large oddly shaped hole in passenger side window.\",\"mechanicNotesUpdatedAtTime\":\"2020-01-27T07:06:25Z\",\"resolvedAtTime\":\"2020-01-27T07:06:25Z\",\"resolvedBy\":{\"id\":\"11\",\"name\":\"Christopher 'The Handyman' Zhen\"},\"trailer\":{\"id\":\"123456789\",\"name\":\"Midwest Trailer #5\"},\"vehicle\":{\"ExternalIds\":{\"maintenanceId\":\"250020\",\"payrollId\":\"ABFS18600\"},\"id\":\"123456789\",\"name\":\"Midwest Truck #4\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DefectsResponse response = client.legacyApIs()
                .getDvirDefects(GetDvirDefectsRequest.builder()
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
                + "      \"comment\": \"Air Compressor not working\",\n"
                + "      \"createdAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "      \"defectType\": \"Air Compressor\",\n"
                + "      \"id\": \"18\",\n"
                + "      \"isResolved\": true,\n"
                + "      \"mechanicNotes\": \"Extremely large oddly shaped hole in passenger side window.\",\n"
                + "      \"mechanicNotesUpdatedAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "      \"resolvedAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "      \"resolvedBy\": {\n"
                + "        \"id\": \"11\",\n"
                + "        \"name\": \"Christopher 'The Handyman' Zhen\"\n"
                + "      },\n"
                + "      \"trailer\": {\n"
                + "        \"id\": \"123456789\",\n"
                + "        \"name\": \"Midwest Trailer #5\"\n"
                + "      },\n"
                + "      \"vehicle\": {\n"
                + "        \"ExternalIds\": {\n"
                + "          \"maintenanceId\": \"250020\",\n"
                + "          \"payrollId\": \"ABFS18600\"\n"
                + "        },\n"
                + "        \"id\": \"123456789\",\n"
                + "        \"name\": \"Midwest Truck #4\"\n"
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
    public void testGetDriversVehicleAssignments() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"driverActivationStatus\":\"active\",\"externalIds\":{\"key\":\"value\"},\"id\":\"494123\",\"name\":\"Joe Driver\",\"vehicleAssignments\":[{\"assignmentType\":\"driverApp\",\"endTime\":\"2019-06-13T19:08:25Z\",\"isPassenger\":false,\"startTime\":\"2019-06-13T19:08:25Z\",\"vehicle\":{\"id\":\"494123\",\"name\":\"Fleet Truck #1\"}}]}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DriversVehicleAssignmentsGetDriversVehicleAssignmentsResponseBody response = client.legacyApIs()
                .getDriversVehicleAssignments(
                        GetDriversVehicleAssignmentsRequest.builder().build());
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
                + "      \"externalIds\": {\n"
                + "        \"key\": \"value\"\n"
                + "      },\n"
                + "      \"id\": \"494123\",\n"
                + "      \"name\": \"Joe Driver\",\n"
                + "      \"vehicleAssignments\": [\n"
                + "        {\n"
                + "          \"assignmentType\": \"driverApp\",\n"
                + "          \"endTime\": \"2019-06-13T19:08:25Z\",\n"
                + "          \"isPassenger\": false,\n"
                + "          \"startTime\": \"2019-06-13T19:08:25Z\",\n"
                + "          \"vehicle\": {\n"
                + "            \"id\": \"494123\",\n"
                + "            \"name\": \"Fleet Truck #1\"\n"
                + "          }\n"
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
    public void testGetDvirHistory() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(
                        TestResources.loadResource("/wire-tests/LegacyApIsWireTest_testGetDvirHistory_response.json")));
        DvirsListResponse response = client.legacyApIs()
                .getDvirHistory(GetDvirHistoryRequest.builder()
                        .startTime("startTime")
                        .endTime("endTime")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/LegacyApIsWireTest_testGetDvirHistory_response.json");
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
    public void testGetVehicleIdlingReports() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"address\":{\"formatted\":\"123 Main Street Atlanta, GA 30307\",\"latitude\":34.654567,\"longitude\":34.654567},\"durationMs\":860000,\"endTime\":\"2019-06-13T19:08:25Z\",\"fuelConsumptionMl\":2500,\"isPtoActive\":false,\"startTime\":\"2019-06-13T19:08:25Z\",\"vehicle\":{\"id\":\"494123\",\"name\":\"Fleet Truck #1\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true},\"requestEndTime\":\"2019-06-13T19:08:25Z\",\"requestStartTime\":\"2019-06-13T19:08:25Z\"}"));
        IdlingReportsGetVehicleIdlingReportsResponseBody response = client.legacyApIs()
                .getVehicleIdlingReports(GetVehicleIdlingReportsRequest.builder()
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
                + "      \"address\": {\n"
                + "        \"formatted\": \"123 Main Street Atlanta, GA 30307\",\n"
                + "        \"latitude\": 34.654567,\n"
                + "        \"longitude\": 34.654567\n"
                + "      },\n"
                + "      \"durationMs\": 860000,\n"
                + "      \"endTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"fuelConsumptionMl\": 2500,\n"
                + "      \"isPtoActive\": false,\n"
                + "      \"startTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"vehicle\": {\n"
                + "        \"id\": \"494123\",\n"
                + "        \"name\": \"Fleet Truck #1\"\n"
                + "      }\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"MjkY\",\n"
                + "    \"hasNextPage\": true\n"
                + "  },\n"
                + "  \"requestEndTime\": \"2019-06-13T19:08:25Z\",\n"
                + "  \"requestStartTime\": \"2019-06-13T19:08:25Z\"\n"
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
    public void testGetSafetyEvents() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"behaviorLabels\":[{\"label\":\"genericTailgating\",\"name\":\"Tailgating\",\"source\":\"automated\"}],\"coachingState\":\"needsReview\",\"downloadForwardVideoUrl\":\"https://s3.console.aws.amazon.com/s3/buckets/samsara-dashcam-videos/21575/212014918400828/1553060687222/huKA7IhpBV-camera-video-segment-1244214895.mp4\",\"downloadInwardVideoUrl\":\"https://s3.console.aws.amazon.com/s3/buckets/samsara-dashcam-videos/21575/212014918400828/1553060687222/huKA7IhpBV-camera-video-segment-1244214895.mp4\",\"downloadTrackedInwardVideoUrl\":\"https://s3.console.aws.amazon.com/s3/buckets/samsara-dashcam-videos/21575/212014918400828/1553060687222/huKA7IhpBV-camera-video-segment-1244214895.mp4\",\"driver\":{\"id\":\"88668\",\"name\":\"Susan Bob\"},\"id\":\"212014918174029-1550954461759\",\"location\":{\"latitude\":122.142,\"longitude\":-93.343},\"maxAccelerationGForce\":0.123,\"time\":\"2019-06-13T19:08:25.455Z\",\"vehicle\":{\"ExternalIds\":{\"maintenanceId\":\"250020\",\"payrollId\":\"ABFS18600\"},\"id\":\"123456789\",\"name\":\"Midwest Truck #4\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        SafetyEventsListResponse response = client.legacyApIs()
                .getSafetyEvents(GetSafetyEventsRequest.builder()
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
                + "      \"behaviorLabels\": [\n"
                + "        {\n"
                + "          \"label\": \"genericTailgating\",\n"
                + "          \"name\": \"Tailgating\",\n"
                + "          \"source\": \"automated\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"coachingState\": \"needsReview\",\n"
                + "      \"downloadForwardVideoUrl\": \"https://s3.console.aws.amazon.com/s3/buckets/samsara-dashcam-videos/21575/212014918400828/1553060687222/huKA7IhpBV-camera-video-segment-1244214895.mp4\",\n"
                + "      \"downloadInwardVideoUrl\": \"https://s3.console.aws.amazon.com/s3/buckets/samsara-dashcam-videos/21575/212014918400828/1553060687222/huKA7IhpBV-camera-video-segment-1244214895.mp4\",\n"
                + "      \"downloadTrackedInwardVideoUrl\": \"https://s3.console.aws.amazon.com/s3/buckets/samsara-dashcam-videos/21575/212014918400828/1553060687222/huKA7IhpBV-camera-video-segment-1244214895.mp4\",\n"
                + "      \"driver\": {\n"
                + "        \"id\": \"88668\",\n"
                + "        \"name\": \"Susan Bob\"\n"
                + "      },\n"
                + "      \"id\": \"212014918174029-1550954461759\",\n"
                + "      \"location\": {\n"
                + "        \"latitude\": 122.142,\n"
                + "        \"longitude\": -93.343\n"
                + "      },\n"
                + "      \"maxAccelerationGForce\": 0.123,\n"
                + "      \"time\": \"2019-06-13T19:08:25.455Z\",\n"
                + "      \"vehicle\": {\n"
                + "        \"ExternalIds\": {\n"
                + "          \"maintenanceId\": \"250020\",\n"
                + "          \"payrollId\": \"ABFS18600\"\n"
                + "        },\n"
                + "        \"id\": \"123456789\",\n"
                + "        \"name\": \"Midwest Truck #4\"\n"
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
    public void testGetSafetyActivityEventFeed() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"id\":\"1622151765-212014918174029-1550954461759\",\"safetyEvent\":{\"id\":\"212014918174029-1550954461759\",\"time\":\"2019-06-13T19:08:25.455Z\"},\"time\":\"2019-10-12T07:20:50.52Z\",\"type\":\"BehaviorLabelActivityType\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        SafetyEventsGetSafetyActivityEventFeedResponseBody response = client.legacyApIs()
                .getSafetyActivityEventFeed(
                        GetSafetyActivityEventFeedRequest.builder().build());
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
                + "      \"id\": \"1622151765-212014918174029-1550954461759\",\n"
                + "      \"safetyEvent\": {\n"
                + "        \"id\": \"212014918174029-1550954461759\",\n"
                + "        \"time\": \"2019-06-13T19:08:25.455Z\"\n"
                + "      },\n"
                + "      \"time\": \"2019-10-12T07:20:50.52Z\",\n"
                + "      \"type\": \"BehaviorLabelActivityType\"\n"
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
    public void testGetVehiclesDriverAssignments() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"driverAssignments\":[{\"driver\":{\"id\":\"45646\",\"name\":\"Driver Bob\"},\"endTime\":\"2019-06-13T19:08:25Z\",\"isPassenger\":false,\"startTime\":\"2019-06-13T19:08:25Z\"}],\"externalIds\":{\"key\":\"value\"},\"id\":\"494123\",\"name\":\"Bus-123\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        VehiclesDriverAssignmentsGetVehiclesDriverAssignmentsResponseBody response = client.legacyApIs()
                .getVehiclesDriverAssignments(
                        GetVehiclesDriverAssignmentsRequest.builder().build());
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
                + "      \"driverAssignments\": [\n"
                + "        {\n"
                + "          \"driver\": {\n"
                + "            \"id\": \"45646\",\n"
                + "            \"name\": \"Driver Bob\"\n"
                + "          },\n"
                + "          \"endTime\": \"2019-06-13T19:08:25Z\",\n"
                + "          \"isPassenger\": false,\n"
                + "          \"startTime\": \"2019-06-13T19:08:25Z\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"externalIds\": {\n"
                + "        \"key\": \"value\"\n"
                + "      },\n"
                + "      \"id\": \"494123\",\n"
                + "      \"name\": \"Bus-123\"\n"
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
    public void testV1GetVehicleHarshEvent() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"downloadForwardVideoUrl\":\"https://samsara-dashcam-videos.s3.us-west-2.amazonaws.com/123/212123456789012/1539201872984/abC123De4-camera-video-segment-123456789.mp4?...\",\"downloadInwardVideoUrl\":\"https://samsara-dashcam-videos.s3.us-west-2.amazonaws.com/123/212123456789012/1539201872984/abC123De4-camera-video-segment-driver-123456789.mp4?...\",\"downloadTrackedInwardVideoUrl\":\"https://samsara-dashcam-videos.s3.us-west-2.amazonaws.com/123/212123456789012/1539201872984/abC123De4-camera-video-segment-driver-123456789.tracked.mp4?...\",\"harshEventType\":\"Harsh Braking\",\"incidentReportUrl\":\"https://cloud.samsara.com/o/1234/fleet/reports/safety/vehicle/212123456789012/incident/1539201882984\",\"isDistracted\":true,\"location\":{\"address\":\"350 Rhode Island St, San Francisco, CA\",\"latitude\":33.07614328,\"longitude\":-96.14907287}}"));
        V1VehicleHarshEventResponse response = client.legacyApIs()
                .v1GetVehicleHarshEvent(
                        1000000L,
                        V1GetVehicleHarshEventRequest.builder()
                                .timestamp(1000000L)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"downloadForwardVideoUrl\": \"https://samsara-dashcam-videos.s3.us-west-2.amazonaws.com/123/212123456789012/1539201872984/abC123De4-camera-video-segment-123456789.mp4?...\",\n"
                + "  \"downloadInwardVideoUrl\": \"https://samsara-dashcam-videos.s3.us-west-2.amazonaws.com/123/212123456789012/1539201872984/abC123De4-camera-video-segment-driver-123456789.mp4?...\",\n"
                + "  \"downloadTrackedInwardVideoUrl\": \"https://samsara-dashcam-videos.s3.us-west-2.amazonaws.com/123/212123456789012/1539201872984/abC123De4-camera-video-segment-driver-123456789.tracked.mp4?...\",\n"
                + "  \"harshEventType\": \"Harsh Braking\",\n"
                + "  \"incidentReportUrl\": \"https://cloud.samsara.com/o/1234/fleet/reports/safety/vehicle/212123456789012/incident/1539201882984\",\n"
                + "  \"isDistracted\": true,\n"
                + "  \"location\": {\n"
                + "    \"address\": \"350 Rhode Island St, San Francisco, CA\",\n"
                + "    \"latitude\": 33.07614328,\n"
                + "    \"longitude\": -96.14907287\n"
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
