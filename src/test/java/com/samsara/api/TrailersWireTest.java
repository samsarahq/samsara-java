package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.trailers.requests.ListTrailersRequest;
import com.samsara.api.resources.trailers.requests.TrailersCreateTrailerRequestBody;
import com.samsara.api.resources.trailers.requests.TrailersUpdateTrailerRequestBody;
import com.samsara.api.types.TrailersCreateTrailerResponseBody;
import com.samsara.api.types.TrailersGetTrailerResponseBody;
import com.samsara.api.types.TrailersListTrailersResponseBody;
import com.samsara.api.types.TrailersUpdateTrailerResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrailersWireTest {
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
    public void testListTrailers() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"enabledForMobile\":true,\"externalIds\":{\"key\":\"value\"},\"id\":\"494123\",\"installedGateway\":{\"model\":\"AG15\",\"serial\":\"GFRV-43N-VGX\"},\"licensePlate\":\"7TYP290\",\"name\":\"Trailer-123\",\"notes\":\"These are my trailer notes\",\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}],\"trailerSerialNumber\":\"8V8WD530FLN016251\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        TrailersListTrailersResponseBody response =
                client.trailers().listTrailers(ListTrailersRequest.builder().build());
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
                + "      \"enabledForMobile\": true,\n"
                + "      \"externalIds\": {\n"
                + "        \"key\": \"value\"\n"
                + "      },\n"
                + "      \"id\": \"494123\",\n"
                + "      \"installedGateway\": {\n"
                + "        \"model\": \"AG15\",\n"
                + "        \"serial\": \"GFRV-43N-VGX\"\n"
                + "      },\n"
                + "      \"licensePlate\": \"7TYP290\",\n"
                + "      \"name\": \"Trailer-123\",\n"
                + "      \"notes\": \"These are my trailer notes\",\n"
                + "      \"tags\": [\n"
                + "        {\n"
                + "          \"id\": \"3914\",\n"
                + "          \"name\": \"East Coast\",\n"
                + "          \"parentTagId\": \"4815\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"trailerSerialNumber\": \"8V8WD530FLN016251\"\n"
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
    public void testCreateTrailer() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"attributes\":[{\"dateValues\":[\"2024-01-15\",\"2024-12-31\"],\"id\":\"494123\",\"name\":\"Compliance/ELD\",\"numberValues\":[867,5309],\"stringValues\":[\"HQ\",\"Leased\"]}],\"enabledForMobile\":true,\"externalIds\":{\"key\":\"value\"},\"id\":\"494123\",\"installedGateway\":{\"model\":\"AG15\",\"serial\":\"GFRV-43N-VGX\"},\"licensePlate\":\"7TYP290\",\"name\":\"Trailer-123\",\"notes\":\"These are my trailer notes\",\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}],\"trailerSerialNumber\":\"8V8WD530FLN016251\"}}"));
        TrailersCreateTrailerResponseBody response = client.trailers()
                .createTrailer(TrailersCreateTrailerRequestBody.builder()
                        .name("Trailer-123")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"name\": \"Trailer-123\"\n" + "}";
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
                + "    \"attributes\": [\n"
                + "      {\n"
                + "        \"dateValues\": [\n"
                + "          \"2024-01-15\",\n"
                + "          \"2024-12-31\"\n"
                + "        ],\n"
                + "        \"id\": \"494123\",\n"
                + "        \"name\": \"Compliance/ELD\",\n"
                + "        \"numberValues\": [\n"
                + "          867,\n"
                + "          5309\n"
                + "        ],\n"
                + "        \"stringValues\": [\n"
                + "          \"HQ\",\n"
                + "          \"Leased\"\n"
                + "        ]\n"
                + "      }\n"
                + "    ],\n"
                + "    \"enabledForMobile\": true,\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"id\": \"494123\",\n"
                + "    \"installedGateway\": {\n"
                + "      \"model\": \"AG15\",\n"
                + "      \"serial\": \"GFRV-43N-VGX\"\n"
                + "    },\n"
                + "    \"licensePlate\": \"7TYP290\",\n"
                + "    \"name\": \"Trailer-123\",\n"
                + "    \"notes\": \"These are my trailer notes\",\n"
                + "    \"tags\": [\n"
                + "      {\n"
                + "        \"id\": \"3914\",\n"
                + "        \"name\": \"East Coast\",\n"
                + "        \"parentTagId\": \"4815\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"trailerSerialNumber\": \"8V8WD530FLN016251\"\n"
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
    public void testGetTrailer() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"attributes\":[{\"dateValues\":[\"2024-01-15\",\"2024-12-31\"],\"id\":\"494123\",\"name\":\"Compliance/ELD\",\"numberValues\":[867,5309],\"stringValues\":[\"HQ\",\"Leased\"]}],\"enabledForMobile\":true,\"externalIds\":{\"key\":\"value\"},\"id\":\"494123\",\"installedGateway\":{\"model\":\"AG15\",\"serial\":\"GFRV-43N-VGX\"},\"licensePlate\":\"7TYP290\",\"name\":\"Trailer-123\",\"notes\":\"These are my trailer notes\",\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}],\"trailerSerialNumber\":\"8V8WD530FLN016251\"}}"));
        TrailersGetTrailerResponseBody response = client.trailers().getTrailer("id");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"attributes\": [\n"
                + "      {\n"
                + "        \"dateValues\": [\n"
                + "          \"2024-01-15\",\n"
                + "          \"2024-12-31\"\n"
                + "        ],\n"
                + "        \"id\": \"494123\",\n"
                + "        \"name\": \"Compliance/ELD\",\n"
                + "        \"numberValues\": [\n"
                + "          867,\n"
                + "          5309\n"
                + "        ],\n"
                + "        \"stringValues\": [\n"
                + "          \"HQ\",\n"
                + "          \"Leased\"\n"
                + "        ]\n"
                + "      }\n"
                + "    ],\n"
                + "    \"enabledForMobile\": true,\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"id\": \"494123\",\n"
                + "    \"installedGateway\": {\n"
                + "      \"model\": \"AG15\",\n"
                + "      \"serial\": \"GFRV-43N-VGX\"\n"
                + "    },\n"
                + "    \"licensePlate\": \"7TYP290\",\n"
                + "    \"name\": \"Trailer-123\",\n"
                + "    \"notes\": \"These are my trailer notes\",\n"
                + "    \"tags\": [\n"
                + "      {\n"
                + "        \"id\": \"3914\",\n"
                + "        \"name\": \"East Coast\",\n"
                + "        \"parentTagId\": \"4815\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"trailerSerialNumber\": \"8V8WD530FLN016251\"\n"
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
    public void testDeleteTrailer() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.trailers().deleteTrailer("id");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testUpdateTrailer() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"attributes\":[{\"dateValues\":[\"2024-01-15\",\"2024-12-31\"],\"id\":\"494123\",\"name\":\"Compliance/ELD\",\"numberValues\":[867,5309],\"stringValues\":[\"HQ\",\"Leased\"]}],\"enabledForMobile\":true,\"externalIds\":{\"key\":\"value\"},\"id\":\"494123\",\"installedGateway\":{\"model\":\"AG15\",\"serial\":\"GFRV-43N-VGX\"},\"licensePlate\":\"7TYP290\",\"name\":\"Trailer-123\",\"notes\":\"These are my trailer notes\",\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}],\"trailerSerialNumber\":\"8V8WD530FLN016251\"}}"));
        TrailersUpdateTrailerResponseBody response = client.trailers()
                .updateTrailer("id", TrailersUpdateTrailerRequestBody.builder().build());
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
                + "    \"attributes\": [\n"
                + "      {\n"
                + "        \"dateValues\": [\n"
                + "          \"2024-01-15\",\n"
                + "          \"2024-12-31\"\n"
                + "        ],\n"
                + "        \"id\": \"494123\",\n"
                + "        \"name\": \"Compliance/ELD\",\n"
                + "        \"numberValues\": [\n"
                + "          867,\n"
                + "          5309\n"
                + "        ],\n"
                + "        \"stringValues\": [\n"
                + "          \"HQ\",\n"
                + "          \"Leased\"\n"
                + "        ]\n"
                + "      }\n"
                + "    ],\n"
                + "    \"enabledForMobile\": true,\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"id\": \"494123\",\n"
                + "    \"installedGateway\": {\n"
                + "      \"model\": \"AG15\",\n"
                + "      \"serial\": \"GFRV-43N-VGX\"\n"
                + "    },\n"
                + "    \"licensePlate\": \"7TYP290\",\n"
                + "    \"name\": \"Trailer-123\",\n"
                + "    \"notes\": \"These are my trailer notes\",\n"
                + "    \"tags\": [\n"
                + "      {\n"
                + "        \"id\": \"3914\",\n"
                + "        \"name\": \"East Coast\",\n"
                + "        \"parentTagId\": \"4815\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"trailerSerialNumber\": \"8V8WD530FLN016251\"\n"
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
