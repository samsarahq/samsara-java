package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.coaching.requests.GetCoachingSessionsRequest;
import com.samsara.api.resources.coaching.requests.GetDriverCoachAssignmentRequest;
import com.samsara.api.resources.coaching.requests.PutDriverCoachAssignmentRequest;
import com.samsara.api.types.CoachingSessionsGetCoachingSessionsResponseBody;
import com.samsara.api.types.DriverCoachAssignmentsGetDriverCoachAssignmentResponseBody;
import com.samsara.api.types.DriverCoachAssignmentsPutDriverCoachAssignmentResponseBody;
import java.time.OffsetDateTime;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoachingWireTest {
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
    public void testGetDriverCoachAssignment() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"coachId\":\"45646\",\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"driver\":{\"driverId\":\"0987\"},\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DriverCoachAssignmentsGetDriverCoachAssignmentResponseBody response = client.coaching()
                .getDriverCoachAssignment(
                        GetDriverCoachAssignmentRequest.builder().build());
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
                + "      \"coachId\": \"45646\",\n"
                + "      \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"driver\": {\n"
                + "        \"driverId\": \"0987\"\n"
                + "      },\n"
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
    public void testPutDriverCoachAssignment() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"coachId\":\"45646\",\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"driverId\":\"45646\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}}"));
        DriverCoachAssignmentsPutDriverCoachAssignmentResponseBody response = client.coaching()
                .putDriverCoachAssignment(PutDriverCoachAssignmentRequest.builder()
                        .driverId("driverId")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PUT", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"coachId\": \"45646\",\n"
                + "    \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"driverId\": \"45646\",\n"
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
    public void testGetCoachingSessions() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"assignedCoachId\":\"45646\",\"behaviors\":[{\"coachableBehaviorType\":\"acceleration\",\"coachableEvents\":[{\"id\":\"f5271458-21f9-4a9f-a290-780c6d8840ff\"}],\"id\":\"f5271458-21f9-4a9f-a290-780c6d8840ff\",\"lastCoachedTime\":\"2019-06-13T19:08:25Z\",\"note\":\"Need to wear seatbelt even for short trips.\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}],\"coachingType\":\"fullySharedWithManager\",\"completedAtTime\":\"2019-06-13T19:08:25Z\",\"completedCoachId\":\"45646\",\"driver\":{\"driverId\":\"0987\"},\"dueAtTime\":\"2019-06-13T19:08:25Z\",\"id\":\"f5271458-21f9-4a9f-a290-780c6d8840ff\",\"sessionNote\":\"Need to wear seatbelt even for short trips.\",\"sessionStatus\":\"unknown\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        CoachingSessionsGetCoachingSessionsResponseBody response = client.coaching()
                .getCoachingSessions(GetCoachingSessionsRequest.builder()
                        .startTime(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
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
                + "      \"assignedCoachId\": \"45646\",\n"
                + "      \"behaviors\": [\n"
                + "        {\n"
                + "          \"coachableBehaviorType\": \"acceleration\",\n"
                + "          \"coachableEvents\": [\n"
                + "            {\n"
                + "              \"id\": \"f5271458-21f9-4a9f-a290-780c6d8840ff\"\n"
                + "            }\n"
                + "          ],\n"
                + "          \"id\": \"f5271458-21f9-4a9f-a290-780c6d8840ff\",\n"
                + "          \"lastCoachedTime\": \"2019-06-13T19:08:25Z\",\n"
                + "          \"note\": \"Need to wear seatbelt even for short trips.\",\n"
                + "          \"updatedAtTime\": \"2019-06-13T19:08:25Z\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"coachingType\": \"fullySharedWithManager\",\n"
                + "      \"completedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"completedCoachId\": \"45646\",\n"
                + "      \"driver\": {\n"
                + "        \"driverId\": \"0987\"\n"
                + "      },\n"
                + "      \"dueAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"id\": \"f5271458-21f9-4a9f-a290-780c6d8840ff\",\n"
                + "      \"sessionNote\": \"Need to wear seatbelt even for short trips.\",\n"
                + "      \"sessionStatus\": \"unknown\",\n"
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
