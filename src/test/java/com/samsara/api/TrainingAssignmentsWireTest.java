package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.trainingassignments.requests.DeleteTrainingAssignmentsRequest;
import com.samsara.api.resources.trainingassignments.requests.GetTrainingAssignmentsStreamRequest;
import com.samsara.api.resources.trainingassignments.requests.PatchTrainingAssignmentsRequest;
import com.samsara.api.resources.trainingassignments.requests.PostTrainingAssignmentsRequest;
import com.samsara.api.types.TrainingAssignmentsGetTrainingAssignmentsStreamResponseBody;
import com.samsara.api.types.TrainingAssignmentsPatchTrainingAssignmentsResponseBody;
import com.samsara.api.types.TrainingAssignmentsPostTrainingAssignmentsResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrainingAssignmentsWireTest {
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
    public void testPostTrainingAssignments() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"course\":{\"id\":\"id\",\"revisionId\":\"revisionId\"},\"createdAtTime\":\"2024-01-15T09:30:00Z\",\"createdById\":\"createdById\",\"dueAtTime\":\"2024-01-15T09:30:00Z\",\"id\":\"id\",\"isExistingAssignment\":true,\"learner\":{\"id\":\"id\",\"type\":\"driver\"}},{\"course\":{\"id\":\"id\",\"revisionId\":\"revisionId\"},\"createdAtTime\":\"2024-01-15T09:30:00Z\",\"createdById\":\"createdById\",\"dueAtTime\":\"2024-01-15T09:30:00Z\",\"id\":\"id\",\"isExistingAssignment\":true,\"learner\":{\"id\":\"id\",\"type\":\"driver\"}}]}"));
        TrainingAssignmentsPostTrainingAssignmentsResponseBody response = client.trainingAssignments()
                .postTrainingAssignments(PostTrainingAssignmentsRequest.builder()
                        .courseId("courseId")
                        .dueAtTime("dueAtTime")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": [\n"
                + "    {\n"
                + "      \"course\": {\n"
                + "        \"id\": \"id\",\n"
                + "        \"revisionId\": \"revisionId\"\n"
                + "      },\n"
                + "      \"createdAtTime\": \"2024-01-15T09:30:00Z\",\n"
                + "      \"createdById\": \"createdById\",\n"
                + "      \"dueAtTime\": \"2024-01-15T09:30:00Z\",\n"
                + "      \"id\": \"id\",\n"
                + "      \"isExistingAssignment\": true,\n"
                + "      \"learner\": {\n"
                + "        \"id\": \"id\",\n"
                + "        \"type\": \"driver\"\n"
                + "      }\n"
                + "    },\n"
                + "    {\n"
                + "      \"course\": {\n"
                + "        \"id\": \"id\",\n"
                + "        \"revisionId\": \"revisionId\"\n"
                + "      },\n"
                + "      \"createdAtTime\": \"2024-01-15T09:30:00Z\",\n"
                + "      \"createdById\": \"createdById\",\n"
                + "      \"dueAtTime\": \"2024-01-15T09:30:00Z\",\n"
                + "      \"id\": \"id\",\n"
                + "      \"isExistingAssignment\": true,\n"
                + "      \"learner\": {\n"
                + "        \"id\": \"id\",\n"
                + "        \"type\": \"driver\"\n"
                + "      }\n"
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
    public void testDeleteTrainingAssignments() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.trainingAssignments()
                .deleteTrainingAssignments(
                        DeleteTrainingAssignmentsRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testPatchTrainingAssignments() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/TrainingAssignmentsWireTest_testPatchTrainingAssignments_response.json")));
        TrainingAssignmentsPatchTrainingAssignmentsResponseBody response = client.trainingAssignments()
                .patchTrainingAssignments(PatchTrainingAssignmentsRequest.builder()
                        .dueAtTime("dueAtTime")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = TestResources.loadResource(
                "/wire-tests/TrainingAssignmentsWireTest_testPatchTrainingAssignments_response.json");
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
    public void testGetTrainingAssignmentsStream() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"completedAtTime\":\"2019-06-13T19:08:25Z\",\"course\":{\"id\":\"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\"revisionId\":\"1214a1fa-f0c6-408b-bf85-51dc3bc71ac7\"},\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"createdById\":\"user-4392\",\"deletedAtTime\":\"2019-06-13T19:08:25Z\",\"dueAtTime\":\"2019-06-13T19:08:25Z\",\"durationMinutes\":3319834036943304700,\"id\":\"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\"isCompletedLate\":true,\"isOverdue\":true,\"learner\":{\"id\":\"938172\",\"type\":\"driver\"},\"scorePercent\":0.3749615068819778,\"startedAtTime\":\"2019-06-13T19:08:25Z\",\"status\":\"notStarted\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\",\"updatedById\":\"user-3112\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        TrainingAssignmentsGetTrainingAssignmentsStreamResponseBody response = client.trainingAssignments()
                .getTrainingAssignmentsStream(GetTrainingAssignmentsStreamRequest.builder()
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
                + "      \"completedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"course\": {\n"
                + "        \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\n"
                + "        \"revisionId\": \"1214a1fa-f0c6-408b-bf85-51dc3bc71ac7\"\n"
                + "      },\n"
                + "      \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"createdById\": \"user-4392\",\n"
                + "      \"deletedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"dueAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"durationMinutes\": 3319834036943304700,\n"
                + "      \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\n"
                + "      \"isCompletedLate\": true,\n"
                + "      \"isOverdue\": true,\n"
                + "      \"learner\": {\n"
                + "        \"id\": \"938172\",\n"
                + "        \"type\": \"driver\"\n"
                + "      },\n"
                + "      \"scorePercent\": 0.3749615068819778,\n"
                + "      \"startedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"status\": \"notStarted\",\n"
                + "      \"updatedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"updatedById\": \"user-3112\"\n"
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
