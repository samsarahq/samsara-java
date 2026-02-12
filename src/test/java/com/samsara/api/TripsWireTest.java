package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.trips.requests.GetTripsRequest;
import com.samsara.api.resources.trips.requests.V1GetFleetTripsRequest;
import com.samsara.api.types.TripsGetTripsResponseBody;
import com.samsara.api.types.V1TripResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TripsWireTest {
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
    public void testGetTrips() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource("/wire-tests/TripsWireTest_testGetTrips_response.json")));
        TripsGetTripsResponseBody response = client.trips()
                .getTrips(GetTripsRequest.builder().startTime("startTime").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/TripsWireTest_testGetTrips_response.json");
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
    public void testV1GetFleetTrips() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"trips\":[{\"assetIds\":[122],\"codriverIds\":[122],\"distanceMeters\":2500,\"driverId\":719,\"endAddress\":{\"address\":\"123 Main St, Sunnyvale, CA 94089\",\"id\":581,\"name\":\"Ramen Tatsunoya\"},\"endCoordinates\":{\"latitude\":23.413702345,\"longitude\":-91.502888123},\"endLocation\":\"571 S Lake Ave, Pasadena, CA 91101\",\"endMs\":1462881998034,\"endOdometer\":210430500,\"fuelConsumedMl\":75700,\"startAddress\":{\"address\":\"123 Main St, Sunnyvale, CA 94089\",\"id\":581,\"name\":\"Ramen Tatsunoya\"},\"startCoordinates\":{\"latitude\":29.443702345,\"longitude\":-98.502888123},\"startLocation\":\"16 N Fair Oaks Ave, Pasadena, CA 91103\",\"startMs\":1462878398034,\"startOdometer\":210430450,\"tollMeters\":32000}]}"));
        V1TripResponse response = client.trips()
                .v1GetFleetTrips(V1GetFleetTripsRequest.builder()
                        .vehicleId(1000000L)
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
                + "  \"trips\": [\n"
                + "    {\n"
                + "      \"assetIds\": [\n"
                + "        122\n"
                + "      ],\n"
                + "      \"codriverIds\": [\n"
                + "        122\n"
                + "      ],\n"
                + "      \"distanceMeters\": 2500,\n"
                + "      \"driverId\": 719,\n"
                + "      \"endAddress\": {\n"
                + "        \"address\": \"123 Main St, Sunnyvale, CA 94089\",\n"
                + "        \"id\": 581,\n"
                + "        \"name\": \"Ramen Tatsunoya\"\n"
                + "      },\n"
                + "      \"endCoordinates\": {\n"
                + "        \"latitude\": 23.413702345,\n"
                + "        \"longitude\": -91.502888123\n"
                + "      },\n"
                + "      \"endLocation\": \"571 S Lake Ave, Pasadena, CA 91101\",\n"
                + "      \"endMs\": 1462881998034,\n"
                + "      \"endOdometer\": 210430500,\n"
                + "      \"fuelConsumedMl\": 75700,\n"
                + "      \"startAddress\": {\n"
                + "        \"address\": \"123 Main St, Sunnyvale, CA 94089\",\n"
                + "        \"id\": 581,\n"
                + "        \"name\": \"Ramen Tatsunoya\"\n"
                + "      },\n"
                + "      \"startCoordinates\": {\n"
                + "        \"latitude\": 29.443702345,\n"
                + "        \"longitude\": -98.502888123\n"
                + "      },\n"
                + "      \"startLocation\": \"16 N Fair Oaks Ave, Pasadena, CA 91103\",\n"
                + "      \"startMs\": 1462878398034,\n"
                + "      \"startOdometer\": 210430450,\n"
                + "      \"tollMeters\": 32000\n"
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
