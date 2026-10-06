package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.preventivemaintenance.requests.EntityUpcomingPreventativeMaintenancesServiceUpdateUpcomingPreventiveMaintenanceRequestBody;
import com.samsara.api.resources.preventivemaintenance.requests.ListPreventiveMaintenanceSchedulesRequest;
import com.samsara.api.resources.preventivemaintenance.requests.ListUpcomingPreventiveMaintenanceRequest;
import com.samsara.api.resources.preventivemaintenance.requests.ResolvePreventiveMaintenanceActionServiceResolvePreventiveMaintenanceRequestBody;
import com.samsara.api.types.EntityPreventativeMaintenanceSchedulesServiceListPreventiveMaintenanceSchedulesResponseBody;
import com.samsara.api.types.EntityUpcomingPreventativeMaintenancesServiceListUpcomingPreventiveMaintenanceResponseBody;
import com.samsara.api.types.EntityUpcomingPreventativeMaintenancesServiceUpdateUpcomingPreventiveMaintenanceResponseBody;
import com.samsara.api.types.ResolvePreventiveMaintenanceActionServiceResolvePreventiveMaintenanceResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PreventiveMaintenanceWireTest {
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
    public void testResolvePreventiveMaintenance() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{\"data\":{\"key\":\"value\"}}"));
        ResolvePreventiveMaintenanceActionServiceResolvePreventiveMaintenanceResponseBody response =
                client.preventiveMaintenance()
                        .resolvePreventiveMaintenance(
                                ResolvePreventiveMaintenanceActionServiceResolvePreventiveMaintenanceRequestBody
                                        .builder()
                                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{}";
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
        String expectedResponseBody = "" + "{\n" + "  \"data\": {\n" + "    \"key\": \"value\"\n" + "  }\n" + "}";
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
    public void testListPreventiveMaintenanceSchedules() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"dateIntervalMs\":7776000000,\"description\":\"Replace engine oil and oil filter, then inspect belts and hoses.\",\"distanceInterval\":8046720,\"engineHourInterval\":250,\"id\":\"281474976710656\",\"linkedSchedules\":[{\"id\":\"281474976710656\"}],\"title\":\"Engine oil and filter change\",\"workOrderTemplateId\":\"281474976710656\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        EntityPreventativeMaintenanceSchedulesServiceListPreventiveMaintenanceSchedulesResponseBody response =
                client.preventiveMaintenance()
                        .listPreventiveMaintenanceSchedules(ListPreventiveMaintenanceSchedulesRequest.builder()
                                .ids("281474976710656")
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
                + "      \"dateIntervalMs\": 7776000000,\n"
                + "      \"description\": \"Replace engine oil and oil filter, then inspect belts and hoses.\",\n"
                + "      \"distanceInterval\": 8046720,\n"
                + "      \"engineHourInterval\": 250,\n"
                + "      \"id\": \"281474976710656\",\n"
                + "      \"linkedSchedules\": [\n"
                + "        {\n"
                + "          \"id\": \"281474976710656\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"title\": \"Engine oil and filter change\",\n"
                + "      \"workOrderTemplateId\": \"281474976710656\"\n"
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
    public void testListUpcomingPreventiveMaintenance() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"asset\":{\"id\":\"281474976710656\"},\"currentEngineHours\":4120,\"currentOdometer\":120700800,\"dueInDays\":45,\"dueInEngineHours\":130,\"dueInOdometer\":4828032,\"lastResolvedAt\":\"2026-05-14T09:30:00Z\",\"lastResolvedAtEngineHours\":4000,\"lastResolvedAtOdometer\":117482112,\"nextEngineHours\":4250,\"nextOdometer\":125528832,\"nextTime\":\"2026-10-11T09:30:00Z\",\"schedule\":{\"id\":\"281474976710656\"},\"status\":\"unknown\",\"workOrder\":{\"id\":\"281474976710656\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        EntityUpcomingPreventativeMaintenancesServiceListUpcomingPreventiveMaintenanceResponseBody response =
                client.preventiveMaintenance()
                        .listUpcomingPreventiveMaintenance(ListUpcomingPreventiveMaintenanceRequest.builder()
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
                + "        \"id\": \"281474976710656\"\n"
                + "      },\n"
                + "      \"currentEngineHours\": 4120,\n"
                + "      \"currentOdometer\": 120700800,\n"
                + "      \"dueInDays\": 45,\n"
                + "      \"dueInEngineHours\": 130,\n"
                + "      \"dueInOdometer\": 4828032,\n"
                + "      \"lastResolvedAt\": \"2026-05-14T09:30:00Z\",\n"
                + "      \"lastResolvedAtEngineHours\": 4000,\n"
                + "      \"lastResolvedAtOdometer\": 117482112,\n"
                + "      \"nextEngineHours\": 4250,\n"
                + "      \"nextOdometer\": 125528832,\n"
                + "      \"nextTime\": \"2026-10-11T09:30:00Z\",\n"
                + "      \"schedule\": {\n"
                + "        \"id\": \"281474976710656\"\n"
                + "      },\n"
                + "      \"status\": \"unknown\",\n"
                + "      \"workOrder\": {\n"
                + "        \"id\": \"281474976710656\"\n"
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
    public void testUpdateUpcomingPreventiveMaintenance() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"asset\":{\"id\":\"281474976710656\"},\"currentEngineHours\":4120,\"currentOdometer\":120700800,\"currentOdometerMiles\":75000,\"dueInDays\":45,\"dueInEngineHours\":130,\"dueInOdometer\":4828032,\"dueInOdometerMiles\":3000,\"lastResolvedAt\":\"2026-05-14T09:30:00Z\",\"lastResolvedAtEngineHours\":4000,\"lastResolvedAtOdometer\":117482112,\"nextEngineHours\":4250,\"nextOdometer\":125528832,\"nextOdometerMiles\":78000,\"nextTime\":\"2026-10-11T09:30:00Z\",\"priority\":45,\"schedule\":{\"id\":\"281474976710656\"},\"status\":\"unknown\",\"workOrder\":{\"id\":\"281474976710656\"}}}"));
        EntityUpcomingPreventativeMaintenancesServiceUpdateUpcomingPreventiveMaintenanceResponseBody response =
                client.preventiveMaintenance()
                        .updateUpcomingPreventiveMaintenance(
                                EntityUpcomingPreventativeMaintenancesServiceUpdateUpcomingPreventiveMaintenanceRequestBody
                                        .builder()
                                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{}";
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
                + "    \"asset\": {\n"
                + "      \"id\": \"281474976710656\"\n"
                + "    },\n"
                + "    \"currentEngineHours\": 4120,\n"
                + "    \"currentOdometer\": 120700800,\n"
                + "    \"currentOdometerMiles\": 75000,\n"
                + "    \"dueInDays\": 45,\n"
                + "    \"dueInEngineHours\": 130,\n"
                + "    \"dueInOdometer\": 4828032,\n"
                + "    \"dueInOdometerMiles\": 3000,\n"
                + "    \"lastResolvedAt\": \"2026-05-14T09:30:00Z\",\n"
                + "    \"lastResolvedAtEngineHours\": 4000,\n"
                + "    \"lastResolvedAtOdometer\": 117482112,\n"
                + "    \"nextEngineHours\": 4250,\n"
                + "    \"nextOdometer\": 125528832,\n"
                + "    \"nextOdometerMiles\": 78000,\n"
                + "    \"nextTime\": \"2026-10-11T09:30:00Z\",\n"
                + "    \"priority\": 45,\n"
                + "    \"schedule\": {\n"
                + "      \"id\": \"281474976710656\"\n"
                + "    },\n"
                + "    \"status\": \"unknown\",\n"
                + "    \"workOrder\": {\n"
                + "      \"id\": \"281474976710656\"\n"
                + "    }\n"
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
