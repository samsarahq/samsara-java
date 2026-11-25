package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.speedingintervals.requests.GetSpeedingIntervalsRequest;
import com.samsara.api.types.SpeedingIntervalsGetSpeedingIntervalsResponseBody;
import java.util.Arrays;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpeedingIntervalsWireTest {
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
    public void testGetSpeedingIntervals() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"asset\":{\"id\":\"12345\",\"name\":\"MyAsset-1234\",\"vin\":\"1GBJ6P1B2HV112765\"},\"createdAtTime\":\"2023-01-27T07:06:25Z\",\"driverId\":\"12345\",\"intervals\":[{\"endTime\":\"2023-01-27T07:06:25Z\",\"isDismissed\":true,\"location\":{\"accuracyMeters\":5.801,\"address\":{\"city\":\"New York\",\"country\":\"USA\",\"neighborhood\":\"Mission District\",\"pointOfInterest\":\"The Eiffel Tower\",\"postalCode\":\"10010\",\"state\":\"New York\",\"street\":\"Main Street\",\"streetNumber\":\"16\"},\"headingDegrees\":120,\"latitude\":37.7749,\"longitude\":137.2719},\"maxSpeedKilometersPerHour\":65,\"postedSpeedLimitKilometersPerHour\":75,\"severityLevel\":\"light\",\"startTime\":\"2023-01-27T07:06:25Z\"}],\"tripStartTime\":\"2023-01-27T07:06:25Z\",\"updatedAtTime\":\"2023-01-27T10:04:20Z\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        SpeedingIntervalsGetSpeedingIntervalsResponseBody response = client.speedingIntervals()
                .getSpeedingIntervals(GetSpeedingIntervalsRequest.builder()
                        .startTime("startTime")
                        .assetIds(Arrays.asList("assetIds"))
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
                + "        \"id\": \"12345\",\n"
                + "        \"name\": \"MyAsset-1234\",\n"
                + "        \"vin\": \"1GBJ6P1B2HV112765\"\n"
                + "      },\n"
                + "      \"createdAtTime\": \"2023-01-27T07:06:25Z\",\n"
                + "      \"driverId\": \"12345\",\n"
                + "      \"intervals\": [\n"
                + "        {\n"
                + "          \"endTime\": \"2023-01-27T07:06:25Z\",\n"
                + "          \"isDismissed\": true,\n"
                + "          \"location\": {\n"
                + "            \"accuracyMeters\": 5.801,\n"
                + "            \"address\": {\n"
                + "              \"city\": \"New York\",\n"
                + "              \"country\": \"USA\",\n"
                + "              \"neighborhood\": \"Mission District\",\n"
                + "              \"pointOfInterest\": \"The Eiffel Tower\",\n"
                + "              \"postalCode\": \"10010\",\n"
                + "              \"state\": \"New York\",\n"
                + "              \"street\": \"Main Street\",\n"
                + "              \"streetNumber\": \"16\"\n"
                + "            },\n"
                + "            \"headingDegrees\": 120,\n"
                + "            \"latitude\": 37.7749,\n"
                + "            \"longitude\": 137.2719\n"
                + "          },\n"
                + "          \"maxSpeedKilometersPerHour\": 65,\n"
                + "          \"postedSpeedLimitKilometersPerHour\": 75,\n"
                + "          \"severityLevel\": \"light\",\n"
                + "          \"startTime\": \"2023-01-27T07:06:25Z\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"tripStartTime\": \"2023-01-27T07:06:25Z\",\n"
                + "      \"updatedAtTime\": \"2023-01-27T10:04:20Z\"\n"
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
