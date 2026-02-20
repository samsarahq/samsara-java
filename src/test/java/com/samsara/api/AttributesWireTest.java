package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.attributes.requests.CreateAttributeRequest;
import com.samsara.api.resources.attributes.requests.DeleteAttributesRequest;
import com.samsara.api.resources.attributes.requests.GetAttributeRequest;
import com.samsara.api.resources.attributes.requests.GetAttributesByEntityTypeRequest;
import com.samsara.api.resources.attributes.requests.UpdateAttributeRequest;
import com.samsara.api.resources.attributes.types.CreateAttributeRequestAttributeType;
import com.samsara.api.resources.attributes.types.CreateAttributeRequestEntityType;
import com.samsara.api.resources.attributes.types.DeleteAttributesRequestEntityType;
import com.samsara.api.resources.attributes.types.GetAttributeRequestEntityType;
import com.samsara.api.resources.attributes.types.GetAttributesByEntityTypeRequestEntityType;
import com.samsara.api.resources.attributes.types.UpdateAttributeRequestEntityType;
import com.samsara.api.types.AttributeExpandedResponse;
import com.samsara.api.types.GetAttributesByEntityTypeResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AttributesWireTest {
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
    public void testGetAttributesByEntityType() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"attributeType\":\"single-select\",\"entityType\":\"driver\",\"id\":\"123e4567-e89b-12d3-a456-426614174000\",\"name\":\"License Certifications\",\"numberValues\":[1.1],\"stringValues\":[\"stringValues\"],\"unit\":\"NO_UNIT\",\"values\":[{\"id\":\"123e4567-e89b-12d3-a456-426614174000\",\"stringValue\":\"CDL\"}]}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        GetAttributesByEntityTypeResponse response = client.attributes()
                .getAttributesByEntityType(GetAttributesByEntityTypeRequest.builder()
                        .entityType(GetAttributesByEntityTypeRequestEntityType.DRIVER)
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
                + "      \"attributeType\": \"single-select\",\n"
                + "      \"entityType\": \"driver\",\n"
                + "      \"id\": \"123e4567-e89b-12d3-a456-426614174000\",\n"
                + "      \"name\": \"License Certifications\",\n"
                + "      \"numberValues\": [\n"
                + "        1.1\n"
                + "      ],\n"
                + "      \"stringValues\": [\n"
                + "        \"stringValues\"\n"
                + "      ],\n"
                + "      \"unit\": \"NO_UNIT\",\n"
                + "      \"values\": [\n"
                + "        {\n"
                + "          \"id\": \"123e4567-e89b-12d3-a456-426614174000\",\n"
                + "          \"stringValue\": \"CDL\"\n"
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
    public void testCreateAttribute() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"entities\":[{}],\"attributeType\":\"single-select\",\"entityType\":\"driver\",\"id\":\"123e4567-e89b-12d3-a456-426614174000\",\"name\":\"License Certifications\",\"numberValues\":[1.1],\"stringValues\":[\"stringValues\"],\"unit\":\"NO_UNIT\",\"values\":[{\"id\":\"123e4567-e89b-12d3-a456-426614174000\",\"stringValue\":\"CDL\"}]}}"));
        AttributeExpandedResponse response = client.attributes()
                .createAttribute(CreateAttributeRequest.builder()
                        .attributeType(CreateAttributeRequestAttributeType.SINGLE_SELECT)
                        .entityType(CreateAttributeRequestEntityType.DRIVER)
                        .name("License Certifications")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"attributeType\": \"single-select\",\n"
                + "  \"entityType\": \"driver\",\n"
                + "  \"name\": \"License Certifications\"\n"
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
                + "    \"entities\": [\n"
                + "      {}\n"
                + "    ],\n"
                + "    \"attributeType\": \"single-select\",\n"
                + "    \"entityType\": \"driver\",\n"
                + "    \"id\": \"123e4567-e89b-12d3-a456-426614174000\",\n"
                + "    \"name\": \"License Certifications\",\n"
                + "    \"numberValues\": [\n"
                + "      1.1\n"
                + "    ],\n"
                + "    \"stringValues\": [\n"
                + "      \"stringValues\"\n"
                + "    ],\n"
                + "    \"unit\": \"NO_UNIT\",\n"
                + "    \"values\": [\n"
                + "      {\n"
                + "        \"id\": \"123e4567-e89b-12d3-a456-426614174000\",\n"
                + "        \"stringValue\": \"CDL\"\n"
                + "      }\n"
                + "    ]\n"
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
    public void testGetAttribute() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"entities\":[{}],\"attributeType\":\"single-select\",\"entityType\":\"driver\",\"id\":\"123e4567-e89b-12d3-a456-426614174000\",\"name\":\"License Certifications\",\"numberValues\":[1.1],\"stringValues\":[\"stringValues\"],\"unit\":\"NO_UNIT\",\"values\":[{\"id\":\"123e4567-e89b-12d3-a456-426614174000\",\"stringValue\":\"CDL\"}]}}"));
        AttributeExpandedResponse response = client.attributes()
                .getAttribute(
                        "id",
                        GetAttributeRequest.builder()
                                .entityType(GetAttributeRequestEntityType.DRIVER)
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
                + "    \"entities\": [\n"
                + "      {}\n"
                + "    ],\n"
                + "    \"attributeType\": \"single-select\",\n"
                + "    \"entityType\": \"driver\",\n"
                + "    \"id\": \"123e4567-e89b-12d3-a456-426614174000\",\n"
                + "    \"name\": \"License Certifications\",\n"
                + "    \"numberValues\": [\n"
                + "      1.1\n"
                + "    ],\n"
                + "    \"stringValues\": [\n"
                + "      \"stringValues\"\n"
                + "    ],\n"
                + "    \"unit\": \"NO_UNIT\",\n"
                + "    \"values\": [\n"
                + "      {\n"
                + "        \"id\": \"123e4567-e89b-12d3-a456-426614174000\",\n"
                + "        \"stringValue\": \"CDL\"\n"
                + "      }\n"
                + "    ]\n"
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
    public void testDelete() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"id\":\"test-id\",\"name\":\"test-name\",\"value\":\"test-value\",\"success\":true,\"data\":{}}"));
        String response = client.attributes()
                .delete(
                        "id",
                        DeleteAttributesRequest.builder()
                                .entityType(DeleteAttributesRequestEntityType.DRIVER)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());

        // Validate response deserialization
        Assertions.assertNotNull(response, "Response should not be null");
        // Verify the response can be serialized back to JSON
        String responseJson = objectMapper.writeValueAsString(response);
        Assertions.assertNotNull(responseJson);
        Assertions.assertFalse(responseJson.isEmpty());
    }

    @Test
    public void testUpdateAttribute() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"entities\":[{}],\"attributeType\":\"single-select\",\"entityType\":\"driver\",\"id\":\"123e4567-e89b-12d3-a456-426614174000\",\"name\":\"License Certifications\",\"numberValues\":[1.1],\"stringValues\":[\"stringValues\"],\"unit\":\"NO_UNIT\",\"values\":[{\"id\":\"123e4567-e89b-12d3-a456-426614174000\",\"stringValue\":\"CDL\"}]}}"));
        AttributeExpandedResponse response = client.attributes()
                .updateAttribute(
                        "id",
                        UpdateAttributeRequest.builder()
                                .entityType(UpdateAttributeRequestEntityType.DRIVER)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"entityType\": \"driver\"\n" + "}";
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
                + "    \"entities\": [\n"
                + "      {}\n"
                + "    ],\n"
                + "    \"attributeType\": \"single-select\",\n"
                + "    \"entityType\": \"driver\",\n"
                + "    \"id\": \"123e4567-e89b-12d3-a456-426614174000\",\n"
                + "    \"name\": \"License Certifications\",\n"
                + "    \"numberValues\": [\n"
                + "      1.1\n"
                + "    ],\n"
                + "    \"stringValues\": [\n"
                + "      \"stringValues\"\n"
                + "    ],\n"
                + "    \"unit\": \"NO_UNIT\",\n"
                + "    \"values\": [\n"
                + "      {\n"
                + "        \"id\": \"123e4567-e89b-12d3-a456-426614174000\",\n"
                + "        \"stringValue\": \"CDL\"\n"
                + "      }\n"
                + "    ]\n"
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
