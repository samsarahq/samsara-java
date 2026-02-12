package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.drivertrailerassignments.requests.GetDriverTrailerAssignmentsRequest;
import com.samsara.api.resources.drivertrailerassignments.requests.TrailerAssignmentsCreateDriverTrailerAssignmentRequestBody;
import com.samsara.api.resources.drivertrailerassignments.requests.TrailerAssignmentsUpdateDriverTrailerAssignmentRequestBody;
import com.samsara.api.types.TrailerAssignmentsCreateDriverTrailerAssignmentResponseBody;
import com.samsara.api.types.TrailerAssignmentsGetDriverTrailerAssignmentsResponseBody;
import com.samsara.api.types.TrailerAssignmentsUpdateDriverTrailerAssignmentResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DriverTrailerAssignmentsWireTest {
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
    public void testGetDriverTrailerAssignments() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"createdAtTime\":\"createdAtTime\",\"driver\":{\"driverId\":\"driverId\",\"externalIds\":{\"externalIds\":\"externalIds\"}},\"endTime\":\"endTime\",\"id\":\"id\",\"startTime\":\"startTime\",\"trailer\":{\"trailerId\":\"trailerId\"},\"updatedAtTime\":\"updatedAtTime\"},{\"createdAtTime\":\"createdAtTime\",\"driver\":{\"driverId\":\"driverId\",\"externalIds\":{\"externalIds\":\"externalIds\"}},\"endTime\":\"endTime\",\"id\":\"id\",\"startTime\":\"startTime\",\"trailer\":{\"trailerId\":\"trailerId\"},\"updatedAtTime\":\"updatedAtTime\"}],\"pagination\":{\"endCursor\":\"endCursor\",\"hasNextPage\":true}}"));
        TrailerAssignmentsGetDriverTrailerAssignmentsResponseBody response = client.driverTrailerAssignments()
                .getDriverTrailerAssignments(
                        GetDriverTrailerAssignmentsRequest.builder().build());
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
                + "      \"createdAtTime\": \"createdAtTime\",\n"
                + "      \"driver\": {\n"
                + "        \"driverId\": \"driverId\",\n"
                + "        \"externalIds\": {\n"
                + "          \"externalIds\": \"externalIds\"\n"
                + "        }\n"
                + "      },\n"
                + "      \"endTime\": \"endTime\",\n"
                + "      \"id\": \"id\",\n"
                + "      \"startTime\": \"startTime\",\n"
                + "      \"trailer\": {\n"
                + "        \"trailerId\": \"trailerId\"\n"
                + "      },\n"
                + "      \"updatedAtTime\": \"updatedAtTime\"\n"
                + "    },\n"
                + "    {\n"
                + "      \"createdAtTime\": \"createdAtTime\",\n"
                + "      \"driver\": {\n"
                + "        \"driverId\": \"driverId\",\n"
                + "        \"externalIds\": {\n"
                + "          \"externalIds\": \"externalIds\"\n"
                + "        }\n"
                + "      },\n"
                + "      \"endTime\": \"endTime\",\n"
                + "      \"id\": \"id\",\n"
                + "      \"startTime\": \"startTime\",\n"
                + "      \"trailer\": {\n"
                + "        \"trailerId\": \"trailerId\"\n"
                + "      },\n"
                + "      \"updatedAtTime\": \"updatedAtTime\"\n"
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
    public void testCreateDriverTrailerAssignment() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"driverId\":\"0987\",\"id\":\"08b3aeada5f4ab3010c0b4efa28d2d1890dbf8d48d2d6\",\"startTime\":\"2019-06-13T19:08:25Z\",\"trailerId\":\"494123\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}}"));
        TrailerAssignmentsCreateDriverTrailerAssignmentResponseBody response = client.driverTrailerAssignments()
                .createDriverTrailerAssignment(TrailerAssignmentsCreateDriverTrailerAssignmentRequestBody.builder()
                        .driverId("494123")
                        .trailerId("12345")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody =
                "" + "{\n" + "  \"driverId\": \"494123\",\n" + "  \"trailerId\": \"12345\"\n" + "}";
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
                + "    \"driverId\": \"0987\",\n"
                + "    \"id\": \"08b3aeada5f4ab3010c0b4efa28d2d1890dbf8d48d2d6\",\n"
                + "    \"startTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"trailerId\": \"494123\",\n"
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
    public void testUpdateDriverTrailerAssignment() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"driverId\":\"0987\",\"endTime\":\"2019-06-13T19:08:25Z\",\"id\":\"08b3aeada5f4ab3010c0b4efa28d2d1890dbf8d48d2d6\",\"startTime\":\"2019-06-13T19:08:25Z\",\"trailerId\":\"494123\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}}"));
        TrailerAssignmentsUpdateDriverTrailerAssignmentResponseBody response = client.driverTrailerAssignments()
                .updateDriverTrailerAssignment(TrailerAssignmentsUpdateDriverTrailerAssignmentRequestBody.builder()
                        .id("id")
                        .endTime("2019-06-13T19:08:25Z")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"endTime\": \"2019-06-13T19:08:25Z\"\n" + "}";
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
                + "    \"driverId\": \"0987\",\n"
                + "    \"endTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"id\": \"08b3aeada5f4ab3010c0b4efa28d2d1890dbf8d48d2d6\",\n"
                + "    \"startTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"trailerId\": \"494123\",\n"
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
