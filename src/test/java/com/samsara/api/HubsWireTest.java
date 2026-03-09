package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.hubs.requests.HubLocationsCreateHubLocationsRequestBody;
import com.samsara.api.resources.hubs.requests.HubLocationsUpdateHubLocationRequestBody;
import com.samsara.api.resources.hubs.requests.ListHubCapacitiesRequest;
import com.samsara.api.resources.hubs.requests.ListHubLocationsRequest;
import com.samsara.api.resources.hubs.requests.ListHubSkillsRequest;
import com.samsara.api.resources.hubs.requests.ListHubsRequest;
import com.samsara.api.types.HubCapacitiesListHubCapacitiesResponseBody;
import com.samsara.api.types.HubLocationInputObjectRequestBody;
import com.samsara.api.types.HubLocationServiceWindowInputRequestBody;
import com.samsara.api.types.HubLocationsCreateHubLocationsResponseBody;
import com.samsara.api.types.HubLocationsListHubLocationsResponseBody;
import com.samsara.api.types.HubLocationsUpdateHubLocationResponseBody;
import com.samsara.api.types.HubSkillsListHubSkillsResponseBody;
import com.samsara.api.types.HubsListHubsResponseBody;
import com.samsara.api.types.UpdateHubLocationRequestBodyRequestBody;
import java.util.Arrays;
import java.util.Optional;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HubsWireTest {
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
    public void testListHubCapacities() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"createdAt\":\"2024-01-15T10:30:00Z\",\"hubId\":\"550e8400-e29b-41d4-a716-446655440000\",\"id\":\"850e8400-e29b-41d4-a716-446655440003\",\"name\":\"Weight\",\"unit\":\"kg\",\"updatedAt\":\"2024-01-15T10:30:00Z\"}],\"pagination\":{\"endCursor\":\"YXJyYXljb25uZWN0aW9uOjEwMA==\",\"hasNextPage\":false}}"));
        HubCapacitiesListHubCapacitiesResponseBody response = client.hubs()
                .listHubCapacities(
                        ListHubCapacitiesRequest.builder().hubId("hubId").build());
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
                + "      \"createdAt\": \"2024-01-15T10:30:00Z\",\n"
                + "      \"hubId\": \"550e8400-e29b-41d4-a716-446655440000\",\n"
                + "      \"id\": \"850e8400-e29b-41d4-a716-446655440003\",\n"
                + "      \"name\": \"Weight\",\n"
                + "      \"unit\": \"kg\",\n"
                + "      \"updatedAt\": \"2024-01-15T10:30:00Z\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"YXJyYXljb25uZWN0aW9uOjEwMA==\",\n"
                + "    \"hasNextPage\": false\n"
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
    public void testUpdateHubLocation() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"address\":\"123 Industrial Blvd, Los Angeles, CA 90210, US\",\"createdAt\":\"2024-01-15T10:30:00Z\",\"customerLocationId\":\"LOC-123\",\"driverInstructions\":\"sample instructions\",\"hubId\":\"550e8400-e29b-41d4-a716-446655440000\",\"id\":\"750e8400-e29b-41d4-a716-446655440002\",\"isDepot\":false,\"latitude\":34.0522,\"longitude\":-118.2437,\"name\":\"Customer ABC Warehouse\",\"plannerNotes\":\"sample note\",\"serviceTimeSeconds\":1800,\"serviceWindows\":[{\"daysOfWeek\":[\"monday\",\"monday\",\"monday\",\"monday\"],\"endTime\":\"17:00:00\",\"startTime\":\"08:00:00\"}],\"skillsRequired\":[{\"id\":\"650e8400-e29b-41d4-a716-446655440001\",\"name\":\"Heavy Lifting\"}],\"updatedAt\":\"2024-01-15T10:30:00Z\"}}"));
        HubLocationsUpdateHubLocationResponseBody response = client.hubs()
                .updateHubLocation(
                        "id",
                        HubLocationsUpdateHubLocationRequestBody.builder()
                                .data(UpdateHubLocationRequestBodyRequestBody.builder()
                                        .address("123 Industrial Blvd, Los Angeles, CA 90210, US")
                                        .customerLocationId("LOC-123")
                                        .driverInstructions("sample instructions")
                                        .isDepot(false)
                                        .latitude(34.0522)
                                        .longitude(-118.2437)
                                        .name("Customer ABC Warehouse")
                                        .plannerNotes("sample note")
                                        .serviceTimeSeconds(1800)
                                        .serviceWindows(Optional.of(
                                                Arrays.asList(HubLocationServiceWindowInputRequestBody.builder()
                                                        .endTime("17:00:00")
                                                        .startTime("08:00:00")
                                                        .daysOfWeek(Arrays.asList(
                                                                "monday", "tuesday", "wednesday", "thursday", "friday"))
                                                        .build())))
                                        .skillsRequired(
                                                Optional.of(Arrays.asList("650e8400-e29b-41d4-a716-446655440001")))
                                        .build())
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"address\": \"123 Industrial Blvd, Los Angeles, CA 90210, US\",\n"
                + "    \"customerLocationId\": \"LOC-123\",\n"
                + "    \"driverInstructions\": \"sample instructions\",\n"
                + "    \"isDepot\": false,\n"
                + "    \"latitude\": 34.0522,\n"
                + "    \"longitude\": -118.2437,\n"
                + "    \"name\": \"Customer ABC Warehouse\",\n"
                + "    \"plannerNotes\": \"sample note\",\n"
                + "    \"serviceTimeSeconds\": 1800,\n"
                + "    \"serviceWindows\": [\n"
                + "      {\n"
                + "        \"daysOfWeek\": [\n"
                + "          \"monday\",\n"
                + "          \"tuesday\",\n"
                + "          \"wednesday\",\n"
                + "          \"thursday\",\n"
                + "          \"friday\"\n"
                + "        ],\n"
                + "        \"endTime\": \"17:00:00\",\n"
                + "        \"startTime\": \"08:00:00\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"skillsRequired\": [\n"
                + "      \"650e8400-e29b-41d4-a716-446655440001\"\n"
                + "    ]\n"
                + "  }\n"
                + "}";
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
                + "    \"address\": \"123 Industrial Blvd, Los Angeles, CA 90210, US\",\n"
                + "    \"createdAt\": \"2024-01-15T10:30:00Z\",\n"
                + "    \"customerLocationId\": \"LOC-123\",\n"
                + "    \"driverInstructions\": \"sample instructions\",\n"
                + "    \"hubId\": \"550e8400-e29b-41d4-a716-446655440000\",\n"
                + "    \"id\": \"750e8400-e29b-41d4-a716-446655440002\",\n"
                + "    \"isDepot\": false,\n"
                + "    \"latitude\": 34.0522,\n"
                + "    \"longitude\": -118.2437,\n"
                + "    \"name\": \"Customer ABC Warehouse\",\n"
                + "    \"plannerNotes\": \"sample note\",\n"
                + "    \"serviceTimeSeconds\": 1800,\n"
                + "    \"serviceWindows\": [\n"
                + "      {\n"
                + "        \"daysOfWeek\": [\n"
                + "          \"monday\",\n"
                + "          \"monday\",\n"
                + "          \"monday\",\n"
                + "          \"monday\"\n"
                + "        ],\n"
                + "        \"endTime\": \"17:00:00\",\n"
                + "        \"startTime\": \"08:00:00\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"skillsRequired\": [\n"
                + "      {\n"
                + "        \"id\": \"650e8400-e29b-41d4-a716-446655440001\",\n"
                + "        \"name\": \"Heavy Lifting\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"updatedAt\": \"2024-01-15T10:30:00Z\"\n"
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
    public void testListHubLocations() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"address\":\"123 Industrial Blvd, Los Angeles, CA 90210, US\",\"createdAt\":\"2024-01-15T10:30:00Z\",\"customerLocationId\":\"LOC-123\",\"driverInstructions\":\"sample instructions\",\"hubId\":\"550e8400-e29b-41d4-a716-446655440000\",\"id\":\"750e8400-e29b-41d4-a716-446655440002\",\"isDepot\":false,\"latitude\":34.0522,\"longitude\":-118.2437,\"name\":\"Customer ABC Warehouse\",\"plannerNotes\":\"sample note\",\"serviceTimeSeconds\":1800,\"serviceWindows\":[{\"daysOfWeek\":[\"monday\",\"monday\",\"monday\",\"monday\"],\"endTime\":\"17:00:00\",\"startTime\":\"08:00:00\"}],\"skillsRequired\":[{\"id\":\"650e8400-e29b-41d4-a716-446655440001\",\"name\":\"Heavy Lifting\"}],\"updatedAt\":\"2024-01-15T10:30:00Z\"}],\"pagination\":{\"endCursor\":\"YXJyYXljb25uZWN0aW9uOjEwMA==\",\"hasNextPage\":false}}"));
        HubLocationsListHubLocationsResponseBody response = client.hubs()
                .listHubLocations(
                        ListHubLocationsRequest.builder().hubId("hubId").build());
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
                + "      \"address\": \"123 Industrial Blvd, Los Angeles, CA 90210, US\",\n"
                + "      \"createdAt\": \"2024-01-15T10:30:00Z\",\n"
                + "      \"customerLocationId\": \"LOC-123\",\n"
                + "      \"driverInstructions\": \"sample instructions\",\n"
                + "      \"hubId\": \"550e8400-e29b-41d4-a716-446655440000\",\n"
                + "      \"id\": \"750e8400-e29b-41d4-a716-446655440002\",\n"
                + "      \"isDepot\": false,\n"
                + "      \"latitude\": 34.0522,\n"
                + "      \"longitude\": -118.2437,\n"
                + "      \"name\": \"Customer ABC Warehouse\",\n"
                + "      \"plannerNotes\": \"sample note\",\n"
                + "      \"serviceTimeSeconds\": 1800,\n"
                + "      \"serviceWindows\": [\n"
                + "        {\n"
                + "          \"daysOfWeek\": [\n"
                + "            \"monday\",\n"
                + "            \"monday\",\n"
                + "            \"monday\",\n"
                + "            \"monday\"\n"
                + "          ],\n"
                + "          \"endTime\": \"17:00:00\",\n"
                + "          \"startTime\": \"08:00:00\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"skillsRequired\": [\n"
                + "        {\n"
                + "          \"id\": \"650e8400-e29b-41d4-a716-446655440001\",\n"
                + "          \"name\": \"Heavy Lifting\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"updatedAt\": \"2024-01-15T10:30:00Z\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"YXJyYXljb25uZWN0aW9uOjEwMA==\",\n"
                + "    \"hasNextPage\": false\n"
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
    public void testCreateHubLocations() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"address\":\"123 Industrial Blvd, Los Angeles, CA 90210, US\",\"createdAt\":\"2024-01-15T10:30:00Z\",\"customerLocationId\":\"LOC-123\",\"driverInstructions\":\"sample instructions\",\"hubId\":\"550e8400-e29b-41d4-a716-446655440000\",\"id\":\"750e8400-e29b-41d4-a716-446655440002\",\"isDepot\":false,\"latitude\":34.0522,\"longitude\":-118.2437,\"name\":\"Customer ABC Warehouse\",\"plannerNotes\":\"sample note\",\"serviceTimeSeconds\":1800,\"serviceWindows\":[{\"daysOfWeek\":[\"monday\",\"monday\",\"monday\",\"monday\"],\"endTime\":\"17:00:00\",\"startTime\":\"08:00:00\"}],\"skillsRequired\":[{\"id\":\"650e8400-e29b-41d4-a716-446655440001\",\"name\":\"Heavy Lifting\"}],\"updatedAt\":\"2024-01-15T10:30:00Z\"}]}"));
        HubLocationsCreateHubLocationsResponseBody response = client.hubs()
                .createHubLocations(HubLocationsCreateHubLocationsRequestBody.builder()
                        .data(Arrays.asList(HubLocationInputObjectRequestBody.builder()
                                .address("123 Industrial Blvd, Los Angeles, CA 90210, US")
                                .customerLocationId("LOC-123")
                                .hubId("550e8400-e29b-41d4-a716-446655440000")
                                .isDepot(false)
                                .name("Customer ABC Warehouse")
                                .driverInstructions("sample instructions")
                                .latitude(34.0522)
                                .longitude(-118.2437)
                                .plannerNotes("sample note")
                                .serviceTimeSeconds(1800)
                                .serviceWindows(
                                        Optional.of(Arrays.asList(HubLocationServiceWindowInputRequestBody.builder()
                                                .endTime("17:00:00")
                                                .startTime("08:00:00")
                                                .daysOfWeek(Arrays.asList(
                                                        "monday", "tuesday", "wednesday", "thursday", "friday"))
                                                .build())))
                                .skillsRequired(Optional.of(Arrays.asList("650e8400-e29b-41d4-a716-446655440001")))
                                .build()))
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"data\": [\n"
                + "    {\n"
                + "      \"address\": \"123 Industrial Blvd, Los Angeles, CA 90210, US\",\n"
                + "      \"customerLocationId\": \"LOC-123\",\n"
                + "      \"driverInstructions\": \"sample instructions\",\n"
                + "      \"hubId\": \"550e8400-e29b-41d4-a716-446655440000\",\n"
                + "      \"isDepot\": false,\n"
                + "      \"latitude\": 34.0522,\n"
                + "      \"longitude\": -118.2437,\n"
                + "      \"name\": \"Customer ABC Warehouse\",\n"
                + "      \"plannerNotes\": \"sample note\",\n"
                + "      \"serviceTimeSeconds\": 1800,\n"
                + "      \"serviceWindows\": [\n"
                + "        {\n"
                + "          \"daysOfWeek\": [\n"
                + "            \"monday\",\n"
                + "            \"tuesday\",\n"
                + "            \"wednesday\",\n"
                + "            \"thursday\",\n"
                + "            \"friday\"\n"
                + "          ],\n"
                + "          \"endTime\": \"17:00:00\",\n"
                + "          \"startTime\": \"08:00:00\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"skillsRequired\": [\n"
                + "        \"650e8400-e29b-41d4-a716-446655440001\"\n"
                + "      ]\n"
                + "    }\n"
                + "  ]\n"
                + "}";
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
                + "  \"data\": [\n"
                + "    {\n"
                + "      \"address\": \"123 Industrial Blvd, Los Angeles, CA 90210, US\",\n"
                + "      \"createdAt\": \"2024-01-15T10:30:00Z\",\n"
                + "      \"customerLocationId\": \"LOC-123\",\n"
                + "      \"driverInstructions\": \"sample instructions\",\n"
                + "      \"hubId\": \"550e8400-e29b-41d4-a716-446655440000\",\n"
                + "      \"id\": \"750e8400-e29b-41d4-a716-446655440002\",\n"
                + "      \"isDepot\": false,\n"
                + "      \"latitude\": 34.0522,\n"
                + "      \"longitude\": -118.2437,\n"
                + "      \"name\": \"Customer ABC Warehouse\",\n"
                + "      \"plannerNotes\": \"sample note\",\n"
                + "      \"serviceTimeSeconds\": 1800,\n"
                + "      \"serviceWindows\": [\n"
                + "        {\n"
                + "          \"daysOfWeek\": [\n"
                + "            \"monday\",\n"
                + "            \"monday\",\n"
                + "            \"monday\",\n"
                + "            \"monday\"\n"
                + "          ],\n"
                + "          \"endTime\": \"17:00:00\",\n"
                + "          \"startTime\": \"08:00:00\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"skillsRequired\": [\n"
                + "        {\n"
                + "          \"id\": \"650e8400-e29b-41d4-a716-446655440001\",\n"
                + "          \"name\": \"Heavy Lifting\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"updatedAt\": \"2024-01-15T10:30:00Z\"\n"
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
    public void testListHubSkills() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"createdAt\":\"2024-01-15T10:30:00Z\",\"hubId\":\"650e8400-e29b-41d4-a716-446655440001\",\"id\":\"750e8400-e29b-41d4-a716-446655440004\",\"name\":\"Hazmat Certified\",\"updatedAt\":\"2024-01-15T10:30:00Z\"}],\"pagination\":{\"endCursor\":\"YXJyYXljb25uZWN0aW9uOjEwMA==\",\"hasNextPage\":false}}"));
        HubSkillsListHubSkillsResponseBody response = client.hubs()
                .listHubSkills(ListHubSkillsRequest.builder().hubId("hubId").build());
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
                + "      \"createdAt\": \"2024-01-15T10:30:00Z\",\n"
                + "      \"hubId\": \"650e8400-e29b-41d4-a716-446655440001\",\n"
                + "      \"id\": \"750e8400-e29b-41d4-a716-446655440004\",\n"
                + "      \"name\": \"Hazmat Certified\",\n"
                + "      \"updatedAt\": \"2024-01-15T10:30:00Z\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"YXJyYXljb25uZWN0aW9uOjEwMA==\",\n"
                + "    \"hasNextPage\": false\n"
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
    public void testListHubs() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"createdAt\":\"2024-01-15T10:30:00Z\",\"id\":\"550e8400-e29b-41d4-a716-446655440000\",\"name\":\"West Coast Distribution Center\",\"timeZone\":\"America/Los_Angeles\",\"updatedAt\":\"2024-01-15T10:30:00Z\"}],\"pagination\":{\"endCursor\":\"YXJyYXljb25uZWN0aW9uOjEwMA==\",\"hasNextPage\":false}}"));
        HubsListHubsResponseBody response =
                client.hubs().listHubs(ListHubsRequest.builder().build());
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
                + "      \"createdAt\": \"2024-01-15T10:30:00Z\",\n"
                + "      \"id\": \"550e8400-e29b-41d4-a716-446655440000\",\n"
                + "      \"name\": \"West Coast Distribution Center\",\n"
                + "      \"timeZone\": \"America/Los_Angeles\",\n"
                + "      \"updatedAt\": \"2024-01-15T10:30:00Z\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"pagination\": {\n"
                + "    \"endCursor\": \"YXJyYXljb25uZWN0aW9uOjEwMA==\",\n"
                + "    \"hasNextPage\": false\n"
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
