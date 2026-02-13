package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.fuelandenergy.requests.FuelPurchasePostFuelPurchaseRequestBody;
import com.samsara.api.resources.fuelandenergy.requests.GetDriverEfficiencyByDriversRequest;
import com.samsara.api.resources.fuelandenergy.requests.GetDriverEfficiencyByVehiclesRequest;
import com.samsara.api.resources.fuelandenergy.requests.GetFuelEnergyDriverReportsRequest;
import com.samsara.api.resources.fuelandenergy.requests.GetFuelEnergyVehicleReportsRequest;
import com.samsara.api.types.DriverEfficiencyGetDriverEfficiencyByDriversResponseBody;
import com.samsara.api.types.DriverEfficiencyGetDriverEfficiencyByVehiclesResponseBody;
import com.samsara.api.types.FuelEnergyGetFuelEnergyDriverReportsResponseBody;
import com.samsara.api.types.FuelEnergyGetFuelEnergyVehicleReportsResponseBody;
import com.samsara.api.types.FuelPurchasePostFuelPurchaseResponseBody;
import com.samsara.api.types.PostFuelPurchaseRequestBodyPriceRequestBody;
import com.samsara.api.types.PostFuelPurchaseRequestBodyPriceRequestBodyCurrency;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FuelAndEnergyWireTest {
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
    public void testGetDriverEfficiencyByDrivers() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/FuelAndEnergyWireTest_testGetDriverEfficiencyByDrivers_response.json")));
        DriverEfficiencyGetDriverEfficiencyByDriversResponseBody response = client.fuelAndEnergy()
                .getDriverEfficiencyByDrivers(GetDriverEfficiencyByDriversRequest.builder()
                        .startTime("startTime")
                        .endTime("endTime")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = TestResources.loadResource(
                "/wire-tests/FuelAndEnergyWireTest_testGetDriverEfficiencyByDrivers_response.json");
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
    public void testGetDriverEfficiencyByVehicles() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/FuelAndEnergyWireTest_testGetDriverEfficiencyByVehicles_response.json")));
        DriverEfficiencyGetDriverEfficiencyByVehiclesResponseBody response = client.fuelAndEnergy()
                .getDriverEfficiencyByVehicles(GetDriverEfficiencyByVehiclesRequest.builder()
                        .startTime("startTime")
                        .endTime("endTime")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = TestResources.loadResource(
                "/wire-tests/FuelAndEnergyWireTest_testGetDriverEfficiencyByVehicles_response.json");
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
    public void testGetFuelEnergyDriverReports() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"driverReports\":[{\"distanceTraveledMeters\":1384000,\"driver\":{\"id\":\"45646\",\"name\":\"Driver Bob\"},\"efficiencyMpge\":21.4,\"energyUsedKwh\":73.2,\"engineIdleTimeDurationMs\":4320000,\"engineRunTimeDurationMs\":576000,\"estCarbonEmissionsKg\":22.7,\"estFuelEnergyCost\":{\"amount\":94.01,\"currencyCode\":\"USD\"},\"fuelConsumedMl\":162773}]},\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        FuelEnergyGetFuelEnergyDriverReportsResponseBody response = client.fuelAndEnergy()
                .getFuelEnergyDriverReports(GetFuelEnergyDriverReportsRequest.builder()
                        .startDate("startDate")
                        .endDate("endDate")
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
                + "    \"driverReports\": [\n"
                + "      {\n"
                + "        \"distanceTraveledMeters\": 1384000,\n"
                + "        \"driver\": {\n"
                + "          \"id\": \"45646\",\n"
                + "          \"name\": \"Driver Bob\"\n"
                + "        },\n"
                + "        \"efficiencyMpge\": 21.4,\n"
                + "        \"energyUsedKwh\": 73.2,\n"
                + "        \"engineIdleTimeDurationMs\": 4320000,\n"
                + "        \"engineRunTimeDurationMs\": 576000,\n"
                + "        \"estCarbonEmissionsKg\": 22.7,\n"
                + "        \"estFuelEnergyCost\": {\n"
                + "          \"amount\": 94.01,\n"
                + "          \"currencyCode\": \"USD\"\n"
                + "        },\n"
                + "        \"fuelConsumedMl\": 162773\n"
                + "      }\n"
                + "    ]\n"
                + "  },\n"
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
    public void testGetFuelEnergyVehicleReports() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"vehicleReports\":[{\"distanceTraveledMeters\":1384000,\"efficiencyMpge\":21.4,\"energyUsedKwh\":73.2,\"engineIdleTimeDurationMs\":4320000,\"engineRunTimeDurationMs\":576000,\"estCarbonEmissionsKg\":22.7,\"estFuelEnergyCost\":{\"amount\":94.01,\"currencyCode\":\"USD\"},\"fuelConsumedMl\":162773,\"vehicle\":{\"energyType\":\"fuel\",\"id\":\"494123\",\"name\":\"Fleet Truck #1\"}}]},\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        FuelEnergyGetFuelEnergyVehicleReportsResponseBody response = client.fuelAndEnergy()
                .getFuelEnergyVehicleReports(GetFuelEnergyVehicleReportsRequest.builder()
                        .startDate("startDate")
                        .endDate("endDate")
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
                + "    \"vehicleReports\": [\n"
                + "      {\n"
                + "        \"distanceTraveledMeters\": 1384000,\n"
                + "        \"efficiencyMpge\": 21.4,\n"
                + "        \"energyUsedKwh\": 73.2,\n"
                + "        \"engineIdleTimeDurationMs\": 4320000,\n"
                + "        \"engineRunTimeDurationMs\": 576000,\n"
                + "        \"estCarbonEmissionsKg\": 22.7,\n"
                + "        \"estFuelEnergyCost\": {\n"
                + "          \"amount\": 94.01,\n"
                + "          \"currencyCode\": \"USD\"\n"
                + "        },\n"
                + "        \"fuelConsumedMl\": 162773,\n"
                + "        \"vehicle\": {\n"
                + "          \"energyType\": \"fuel\",\n"
                + "          \"id\": \"494123\",\n"
                + "          \"name\": \"Fleet Truck #1\"\n"
                + "        }\n"
                + "      }\n"
                + "    ]\n"
                + "  },\n"
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
    public void testPostFuelPurchase() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\"data\":{\"uuid\":\"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\"}}"));
        FuelPurchasePostFuelPurchaseResponseBody response = client.fuelAndEnergy()
                .postFuelPurchase(FuelPurchasePostFuelPurchaseRequestBody.builder()
                        .fuelQuantityLiters("676.8")
                        .transactionLocation("350 Rhode Island St, San Francisco, CA 94103")
                        .transactionPrice(PostFuelPurchaseRequestBodyPriceRequestBody.builder()
                                .amount("640.2")
                                .currency(PostFuelPurchaseRequestBodyPriceRequestBodyCurrency.USD)
                                .build())
                        .transactionReference("5454534")
                        .transactionTime("2022-07-13T14:20:50.52-07:00")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"fuelQuantityLiters\": \"676.8\",\n"
                + "  \"transactionLocation\": \"350 Rhode Island St, San Francisco, CA 94103\",\n"
                + "  \"transactionPrice\": {\n"
                + "    \"amount\": \"640.2\",\n"
                + "    \"currency\": \"usd\"\n"
                + "  },\n"
                + "  \"transactionReference\": \"5454534\",\n"
                + "  \"transactionTime\": \"2022-07-13T14:20:50.52-07:00\"\n"
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
                + "    \"uuid\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\"\n"
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
