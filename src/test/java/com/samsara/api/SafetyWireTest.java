package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.safety.requests.GetSafetyEventsV2Request;
import com.samsara.api.resources.safety.requests.GetSafetyEventsV2StreamRequest;
import com.samsara.api.resources.safety.requests.V1GetDriverSafetyScoreRequest;
import com.samsara.api.resources.safety.requests.V1GetVehicleSafetyScoreRequest;
import com.samsara.api.types.SafetyEventsV2GetSafetyEventsV2ResponseBody;
import com.samsara.api.types.SafetyEventsV2GetSafetyEventsV2StreamResponseBody;
import com.samsara.api.types.V1DriverSafetyScoreResponse;
import com.samsara.api.types.V1VehicleSafetyScoreResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SafetyWireTest {
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
    public void testGetSafetyEventsV2() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource("/wire-tests/SafetyWireTest_testGetSafetyEventsV2_response.json")));
        SafetyEventsV2GetSafetyEventsV2ResponseBody response = client.safety()
                .getSafetyEventsV2(GetSafetyEventsV2Request.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/SafetyWireTest_testGetSafetyEventsV2_response.json");
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
    public void testGetSafetyEventsV2Stream() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/SafetyWireTest_testGetSafetyEventsV2Stream_response.json")));
        SafetyEventsV2GetSafetyEventsV2StreamResponseBody response = client.safety()
                .getSafetyEventsV2Stream(GetSafetyEventsV2StreamRequest.builder()
                        .startTime("startTime")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/SafetyWireTest_testGetSafetyEventsV2Stream_response.json");
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
    public void testV1GetDriverSafetyScore() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"crashCount\":0,\"driverId\":1234,\"harshAccelCount\":1,\"harshBrakingCount\":2,\"harshEvents\":[{\"harshEventType\":\"Harsh Braking\",\"timestampMs\":1535590776000,\"vehicleId\":212014918086169}],\"harshTurningCount\":0,\"safetyScore\":97,\"safetyScoreRank\":\"26\",\"timeOverSpeedLimitMs\":3769,\"totalDistanceDrivenMeters\":291836,\"totalHarshEventCount\":3,\"totalTimeDrivenMs\":19708293}"));
        V1DriverSafetyScoreResponse response = client.safety()
                .v1GetDriverSafetyScore(
                        1000000L,
                        V1GetDriverSafetyScoreRequest.builder()
                                .startMs(1000000L)
                                .endMs(1000000L)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"crashCount\": 0,\n"
                + "  \"driverId\": 1234,\n"
                + "  \"harshAccelCount\": 1,\n"
                + "  \"harshBrakingCount\": 2,\n"
                + "  \"harshEvents\": [\n"
                + "    {\n"
                + "      \"harshEventType\": \"Harsh Braking\",\n"
                + "      \"timestampMs\": 1535590776000,\n"
                + "      \"vehicleId\": 212014918086169\n"
                + "    }\n"
                + "  ],\n"
                + "  \"harshTurningCount\": 0,\n"
                + "  \"safetyScore\": 97,\n"
                + "  \"safetyScoreRank\": \"26\",\n"
                + "  \"timeOverSpeedLimitMs\": 3769,\n"
                + "  \"totalDistanceDrivenMeters\": 291836,\n"
                + "  \"totalHarshEventCount\": 3,\n"
                + "  \"totalTimeDrivenMs\": 19708293\n"
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
    public void testV1GetVehicleSafetyScore() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"crashCount\":0,\"harshAccelCount\":1,\"harshBrakingCount\":2,\"harshEvents\":[{\"harshEventType\":\"Harsh Braking\",\"timestampMs\":1535590776000,\"vehicleId\":212014918086169}],\"harshTurningCount\":0,\"safetyScore\":97,\"safetyScoreRank\":\"26\",\"timeOverSpeedLimitMs\":3769,\"totalDistanceDrivenMeters\":291836,\"totalHarshEventCount\":3,\"totalTimeDrivenMs\":19708293,\"vehicleId\":4321}"));
        V1VehicleSafetyScoreResponse response = client.safety()
                .v1GetVehicleSafetyScore(
                        1000000L,
                        V1GetVehicleSafetyScoreRequest.builder()
                                .startMs(1000000L)
                                .endMs(1000000L)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"crashCount\": 0,\n"
                + "  \"harshAccelCount\": 1,\n"
                + "  \"harshBrakingCount\": 2,\n"
                + "  \"harshEvents\": [\n"
                + "    {\n"
                + "      \"harshEventType\": \"Harsh Braking\",\n"
                + "      \"timestampMs\": 1535590776000,\n"
                + "      \"vehicleId\": 212014918086169\n"
                + "    }\n"
                + "  ],\n"
                + "  \"harshTurningCount\": 0,\n"
                + "  \"safetyScore\": 97,\n"
                + "  \"safetyScoreRank\": \"26\",\n"
                + "  \"timeOverSpeedLimitMs\": 3769,\n"
                + "  \"totalDistanceDrivenMeters\": 291836,\n"
                + "  \"totalHarshEventCount\": 3,\n"
                + "  \"totalTimeDrivenMs\": 19708293,\n"
                + "  \"vehicleId\": 4321\n"
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
