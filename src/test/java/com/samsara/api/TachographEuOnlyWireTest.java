package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.tachographeuonly.requests.GetDriverTachographActivityRequest;
import com.samsara.api.resources.tachographeuonly.requests.GetDriverTachographFilesRequest;
import com.samsara.api.resources.tachographeuonly.requests.GetVehicleTachographFilesRequest;
import com.samsara.api.types.DriverTachographActivityResponse;
import com.samsara.api.types.TachographDriverFilesResponse;
import com.samsara.api.types.TachographVehicleFilesResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TachographEuOnlyWireTest {
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
    public void testGetDriverTachographActivity() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"activity\":[{\"endTime\":\"2020-01-03T16:04:05Z07:00\",\"isManualEntry\":false,\"startTime\":\"2020-01-02T15:04:05Z07:00\"}],\"driver\":{\"id\":\"88668\",\"name\":\"Susan Bob\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DriverTachographActivityResponse response = client.tachographEuOnly()
                .getDriverTachographActivity(GetDriverTachographActivityRequest.builder()
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
                + "      \"activity\": [\n"
                + "        {\n"
                + "          \"endTime\": \"2020-01-03T16:04:05Z07:00\",\n"
                + "          \"isManualEntry\": false,\n"
                + "          \"startTime\": \"2020-01-02T15:04:05Z07:00\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"driver\": {\n"
                + "        \"id\": \"88668\",\n"
                + "        \"name\": \"Susan Bob\"\n"
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
    public void testGetDriverTachographFiles() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"driver\":{\"id\":\"88668\",\"name\":\"Susan Bob\"},\"files\":[{\"cardNumber\":\"1000000492436002\",\"createdAtTime\":\"2020-01-02T15:04:05Z07:00\",\"id\":\"4aff772c-a7bb-45e6-8e41-6a53e34feb83\",\"url\":\"https://samsara-tachograph-files.s3.us-west-2.amazonaws.com/123/456/789/4aff772c-a7bb-45e6-8e41-6a53e34feb83.ddd\"}]}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        TachographDriverFilesResponse response = client.tachographEuOnly()
                .getDriverTachographFiles(GetDriverTachographFilesRequest.builder()
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
                + "      \"driver\": {\n"
                + "        \"id\": \"88668\",\n"
                + "        \"name\": \"Susan Bob\"\n"
                + "      },\n"
                + "      \"files\": [\n"
                + "        {\n"
                + "          \"cardNumber\": \"1000000492436002\",\n"
                + "          \"createdAtTime\": \"2020-01-02T15:04:05Z07:00\",\n"
                + "          \"id\": \"4aff772c-a7bb-45e6-8e41-6a53e34feb83\",\n"
                + "          \"url\": \"https://samsara-tachograph-files.s3.us-west-2.amazonaws.com/123/456/789/4aff772c-a7bb-45e6-8e41-6a53e34feb83.ddd\"\n"
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
    public void testGetVehicleTachographFiles() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"files\":[{\"createdAtTime\":\"2020-01-02T15:04:05Z07:00\",\"id\":\"4aff772c-a7bb-45e6-8e41-6a53e34feb83\",\"url\":\"https://samsara-tachograph-files.s3.us-west-2.amazonaws.com/123/456/789/4aff772c-a7bb-45e6-8e41-6a53e34feb83.ddd\",\"vehicleIdentificationNumber\":\"1000000492436002\"}],\"vehicle\":{\"ExternalIds\":{\"maintenanceId\":\"250020\",\"payrollId\":\"ABFS18600\"},\"id\":\"123456789\",\"name\":\"Midwest Truck #4\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        TachographVehicleFilesResponse response = client.tachographEuOnly()
                .getVehicleTachographFiles(GetVehicleTachographFilesRequest.builder()
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
                + "      \"files\": [\n"
                + "        {\n"
                + "          \"createdAtTime\": \"2020-01-02T15:04:05Z07:00\",\n"
                + "          \"id\": \"4aff772c-a7bb-45e6-8e41-6a53e34feb83\",\n"
                + "          \"url\": \"https://samsara-tachograph-files.s3.us-west-2.amazonaws.com/123/456/789/4aff772c-a7bb-45e6-8e41-6a53e34feb83.ddd\",\n"
                + "          \"vehicleIdentificationNumber\": \"1000000492436002\"\n"
                + "        }\n"
                + "      ],\n"
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
