package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.idling.requests.GetIdlingEventsRequest;
import com.samsara.api.types.AdvancedIdlingGetIdlingEventsResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IdlingWireTest {
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
    public void testGetIdlingEvents() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"address\":{\"addressTypes\":[\"yard\",\"industrialSite\"],\"id\":\"1234567890\"},\"airTemperatureMillicelsius\":25000,\"asset\":{\"id\":1234567890},\"durationMilliseconds\":860000,\"eventUuid\":\"1234567890\",\"fuelConsumedMilliliters\":2500,\"fuelCost\":{\"amount\":\"640.2\",\"currency\":\"usd\"},\"gaseousFuelConsumedGrams\":2500,\"gaseousFuelCost\":{\"amount\":\"640.2\",\"currency\":\"usd\"},\"latitude\":37.7749,\"longitude\":-122.4194,\"operator\":{\"id\":1234567890},\"ptoState\":\"active, inactive\",\"startTime\":\"2019-06-13T17:08:25Z\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        AdvancedIdlingGetIdlingEventsResponseBody response = client.idling()
                .getIdlingEvents(GetIdlingEventsRequest.builder()
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
                + "        \"addressTypes\": [\n"
                + "          \"yard\",\n"
                + "          \"industrialSite\"\n"
                + "        ],\n"
                + "        \"id\": \"1234567890\"\n"
                + "      },\n"
                + "      \"airTemperatureMillicelsius\": 25000,\n"
                + "      \"asset\": {\n"
                + "        \"id\": 1234567890\n"
                + "      },\n"
                + "      \"durationMilliseconds\": 860000,\n"
                + "      \"eventUuid\": \"1234567890\",\n"
                + "      \"fuelConsumedMilliliters\": 2500,\n"
                + "      \"fuelCost\": {\n"
                + "        \"amount\": \"640.2\",\n"
                + "        \"currency\": \"usd\"\n"
                + "      },\n"
                + "      \"gaseousFuelConsumedGrams\": 2500,\n"
                + "      \"gaseousFuelCost\": {\n"
                + "        \"amount\": \"640.2\",\n"
                + "        \"currency\": \"usd\"\n"
                + "      },\n"
                + "      \"latitude\": 37.7749,\n"
                + "      \"longitude\": -122.4194,\n"
                + "      \"operator\": {\n"
                + "        \"id\": 1234567890\n"
                + "      },\n"
                + "      \"ptoState\": \"active, inactive\",\n"
                + "      \"startTime\": \"2019-06-13T17:08:25Z\"\n"
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
