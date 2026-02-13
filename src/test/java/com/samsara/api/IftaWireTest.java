package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.ifta.requests.GetIftaJurisdictionReportsRequest;
import com.samsara.api.resources.ifta.requests.GetIftaVehicleReportsRequest;
import com.samsara.api.resources.ifta.requests.IftaCreateIftaDetailJobRequestBody;
import com.samsara.api.types.IftaCreateIftaDetailJobResponseBody;
import com.samsara.api.types.IftaGetIftaDetailJobResponseBody;
import com.samsara.api.types.IftaGetIftaJurisdictionReportsResponseBody;
import com.samsara.api.types.IftaGetIftaVehicleReportsResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IftaWireTest {
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
    public void testGetIftaJurisdictionReports() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"jurisdictionReports\":[{\"jurisdiction\":\"GA\",\"taxPaidLiters\":25.5,\"taxableMeters\":2350,\"totalMeters\":2350}],\"month\":\"January\",\"quarter\":\"Q4\",\"troubleshooting\":{\"noPurchasesFound\":false,\"unassignedFuelTypePurchases\":200,\"unassignedFuelTypeVehicles\":2500,\"unassignedVehiclePurchases\":2500},\"year\":2021}}"));
        IftaGetIftaJurisdictionReportsResponseBody response = client.ifta()
                .getIftaJurisdictionReports(GetIftaJurisdictionReportsRequest.builder()
                        .year(1000000L)
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
                + "    \"jurisdictionReports\": [\n"
                + "      {\n"
                + "        \"jurisdiction\": \"GA\",\n"
                + "        \"taxPaidLiters\": 25.5,\n"
                + "        \"taxableMeters\": 2350,\n"
                + "        \"totalMeters\": 2350\n"
                + "      }\n"
                + "    ],\n"
                + "    \"month\": \"January\",\n"
                + "    \"quarter\": \"Q4\",\n"
                + "    \"troubleshooting\": {\n"
                + "      \"noPurchasesFound\": false,\n"
                + "      \"unassignedFuelTypePurchases\": 200,\n"
                + "      \"unassignedFuelTypeVehicles\": 2500,\n"
                + "      \"unassignedVehiclePurchases\": 2500\n"
                + "    },\n"
                + "    \"year\": 2021\n"
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
    public void testGetIftaVehicleReports() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"month\":\"January\",\"quarter\":\"Q4\",\"troubleshooting\":{\"noPurchasesFound\":false,\"unassignedFuelTypePurchases\":200,\"unassignedFuelTypeVehicles\":2500,\"unassignedVehiclePurchases\":2500},\"vehicleReports\":[{\"jurisdictions\":[{\"jurisdiction\":\"GA\",\"taxPaidLiters\":25.5,\"taxableMeters\":2350,\"totalMeters\":2350}],\"vehicle\":{\"id\":\"494123\",\"name\":\"Fleet Truck #1\"}}],\"year\":2021},\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        IftaGetIftaVehicleReportsResponseBody response = client.ifta()
                .getIftaVehicleReports(
                        GetIftaVehicleReportsRequest.builder().year(1000000L).build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"month\": \"January\",\n"
                + "    \"quarter\": \"Q4\",\n"
                + "    \"troubleshooting\": {\n"
                + "      \"noPurchasesFound\": false,\n"
                + "      \"unassignedFuelTypePurchases\": 200,\n"
                + "      \"unassignedFuelTypeVehicles\": 2500,\n"
                + "      \"unassignedVehiclePurchases\": 2500\n"
                + "    },\n"
                + "    \"vehicleReports\": [\n"
                + "      {\n"
                + "        \"jurisdictions\": [\n"
                + "          {\n"
                + "            \"jurisdiction\": \"GA\",\n"
                + "            \"taxPaidLiters\": 25.5,\n"
                + "            \"taxableMeters\": 2350,\n"
                + "            \"totalMeters\": 2350\n"
                + "          }\n"
                + "        ],\n"
                + "        \"vehicle\": {\n"
                + "          \"id\": \"494123\",\n"
                + "          \"name\": \"Fleet Truck #1\"\n"
                + "        }\n"
                + "      }\n"
                + "    ],\n"
                + "    \"year\": 2021\n"
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
    public void testCreateIftaDetailJob() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"args\":{\"endHour\":\"2019-06-13T19:00:00Z\",\"startHour\":\"2019-06-13T19:00:00Z\",\"vehicleIds\":[12345678,56789123]},\"completedAtTime\":\"2019-06-13T19:00:00Z\",\"details\":\"Try limiting the number of vehicles requested per job to reduce the processing duration.\",\"failedAtTime\":\"2019-06-13T19:00:00Z\",\"files\":[{\"createdAtTime\":\"2019-06-13T19:00:00Z\",\"downloadUrl\":\"https://s3.download-url.com\",\"downloadUrlExpirationTime\":\"2019-06-13T19:00:00Z\",\"name\":\"output-001.csv.gz\",\"recordCount\":3744166038677327400}],\"jobId\":\"8cabba84-bef4-4951-8cd2-78ce898fd8e6\",\"jobStatus\":\"Requested\",\"requestedAtTime\":\"2019-06-13T19:00:00Z\",\"startedAtTime\":\"2019-06-13T19:00:00Z\"}}"));
        IftaCreateIftaDetailJobResponseBody response = client.ifta()
                .createIftaDetailJob(IftaCreateIftaDetailJobRequestBody.builder()
                        .endHour("2019-06-13T19:00:00Z")
                        .startHour("2019-06-13T19:00:00Z")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"endHour\": \"2019-06-13T19:00:00Z\",\n"
                + "  \"startHour\": \"2019-06-13T19:00:00Z\"\n"
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
                + "    \"args\": {\n"
                + "      \"endHour\": \"2019-06-13T19:00:00Z\",\n"
                + "      \"startHour\": \"2019-06-13T19:00:00Z\",\n"
                + "      \"vehicleIds\": [\n"
                + "        12345678,\n"
                + "        56789123\n"
                + "      ]\n"
                + "    },\n"
                + "    \"completedAtTime\": \"2019-06-13T19:00:00Z\",\n"
                + "    \"details\": \"Try limiting the number of vehicles requested per job to reduce the processing duration.\",\n"
                + "    \"failedAtTime\": \"2019-06-13T19:00:00Z\",\n"
                + "    \"files\": [\n"
                + "      {\n"
                + "        \"createdAtTime\": \"2019-06-13T19:00:00Z\",\n"
                + "        \"downloadUrl\": \"https://s3.download-url.com\",\n"
                + "        \"downloadUrlExpirationTime\": \"2019-06-13T19:00:00Z\",\n"
                + "        \"name\": \"output-001.csv.gz\",\n"
                + "        \"recordCount\": 3744166038677327400\n"
                + "      }\n"
                + "    ],\n"
                + "    \"jobId\": \"8cabba84-bef4-4951-8cd2-78ce898fd8e6\",\n"
                + "    \"jobStatus\": \"Requested\",\n"
                + "    \"requestedAtTime\": \"2019-06-13T19:00:00Z\",\n"
                + "    \"startedAtTime\": \"2019-06-13T19:00:00Z\"\n"
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
    public void testGetIftaDetailJob() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"args\":{\"endHour\":\"2019-06-13T19:00:00Z\",\"startHour\":\"2019-06-13T19:00:00Z\",\"vehicleIds\":[12345678,56789123]},\"completedAtTime\":\"2019-06-13T19:00:00Z\",\"details\":\"Try limiting the number of vehicles requested per job to reduce the processing duration.\",\"failedAtTime\":\"2019-06-13T19:00:00Z\",\"files\":[{\"createdAtTime\":\"2019-06-13T19:00:00Z\",\"downloadUrl\":\"https://s3.download-url.com\",\"downloadUrlExpirationTime\":\"2019-06-13T19:00:00Z\",\"name\":\"output-001.csv.gz\",\"recordCount\":3744166038677327400}],\"jobId\":\"8cabba84-bef4-4951-8cd2-78ce898fd8e6\",\"jobStatus\":\"Requested\",\"requestedAtTime\":\"2019-06-13T19:00:00Z\",\"startedAtTime\":\"2019-06-13T19:00:00Z\"}}"));
        IftaGetIftaDetailJobResponseBody response = client.ifta().getIftaDetailJob("id");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"args\": {\n"
                + "      \"endHour\": \"2019-06-13T19:00:00Z\",\n"
                + "      \"startHour\": \"2019-06-13T19:00:00Z\",\n"
                + "      \"vehicleIds\": [\n"
                + "        12345678,\n"
                + "        56789123\n"
                + "      ]\n"
                + "    },\n"
                + "    \"completedAtTime\": \"2019-06-13T19:00:00Z\",\n"
                + "    \"details\": \"Try limiting the number of vehicles requested per job to reduce the processing duration.\",\n"
                + "    \"failedAtTime\": \"2019-06-13T19:00:00Z\",\n"
                + "    \"files\": [\n"
                + "      {\n"
                + "        \"createdAtTime\": \"2019-06-13T19:00:00Z\",\n"
                + "        \"downloadUrl\": \"https://s3.download-url.com\",\n"
                + "        \"downloadUrlExpirationTime\": \"2019-06-13T19:00:00Z\",\n"
                + "        \"name\": \"output-001.csv.gz\",\n"
                + "        \"recordCount\": 3744166038677327400\n"
                + "      }\n"
                + "    ],\n"
                + "    \"jobId\": \"8cabba84-bef4-4951-8cd2-78ce898fd8e6\",\n"
                + "    \"jobStatus\": \"Requested\",\n"
                + "    \"requestedAtTime\": \"2019-06-13T19:00:00Z\",\n"
                + "    \"startedAtTime\": \"2019-06-13T19:00:00Z\"\n"
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
