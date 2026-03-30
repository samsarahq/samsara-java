package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.safetyscores.requests.GetDriverSafetyScoresRequest;
import com.samsara.api.resources.safetyscores.requests.GetTagGroupSafetyScoresRequest;
import com.samsara.api.resources.safetyscores.requests.GetTagSafetyScoresRequest;
import com.samsara.api.resources.safetyscores.requests.GetVehicleSafetyScoresRequest;
import com.samsara.api.resources.safetyscores.types.GetTagGroupSafetyScoresRequestScoreType;
import com.samsara.api.resources.safetyscores.types.GetTagSafetyScoresRequestScoreType;
import com.samsara.api.types.SafetyScoresGetDriverSafetyScoresResponseBody;
import com.samsara.api.types.SafetyScoresGetTagGroupSafetyScoresResponseBody;
import com.samsara.api.types.SafetyScoresGetTagSafetyScoresResponseBody;
import com.samsara.api.types.SafetyScoresGetVehicleSafetyScoresResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SafetyScoresWireTest {
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
    public void testGetDriverSafetyScores() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"behaviors\":[{\"behaviorType\":\"acceleration\",\"count\":5,\"scoreImpact\":-18.91020325321117}],\"driveDistanceMeters\":2207296,\"driveTimeMilliseconds\":136997730,\"driverId\":\"1234\",\"driverScore\":92,\"speeding\":[{\"durationMilliseconds\":178773,\"scoreImpact\":-0.13049340306587562,\"speedingType\":\"light\"}]}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        SafetyScoresGetDriverSafetyScoresResponseBody response = client.safetyScores()
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
    public void testGetTagGroupSafetyScores() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"behaviors\":[{\"behaviorType\":\"acceleration\",\"count\":5,\"scoreImpact\":-18.91020325321117}],\"combinedScore\":92,\"driveDistanceMeters\":2207296,\"driveTimeMilliseconds\":136997730,\"speeding\":[{\"durationMilliseconds\":178773,\"scoreImpact\":-0.13049340306587562,\"speedingType\":\"light\"}]}}"));
        SafetyScoresGetTagGroupSafetyScoresResponseBody response = client.safetyScores()
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
        SafetyScoresGetTagSafetyScoresResponseBody response = client.safetyScores()
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
        SafetyScoresGetVehicleSafetyScoresResponseBody response = client.safetyScores()
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
