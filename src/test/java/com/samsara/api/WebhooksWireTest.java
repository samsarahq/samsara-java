package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.webhooks.requests.ListWebhooksRequest;
import com.samsara.api.resources.webhooks.requests.WebhooksPatchWebhookRequestBody;
import com.samsara.api.resources.webhooks.requests.WebhooksPostWebhooksRequestBody;
import com.samsara.api.types.WebhooksGetWebhookResponseBody;
import com.samsara.api.types.WebhooksListWebhooksResponseBody;
import com.samsara.api.types.WebhooksPatchWebhookResponseBody;
import com.samsara.api.types.WebhooksPostWebhooksResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WebhooksWireTest {
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
    public void testListWebhooks() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"customHeaders\":[{\"key\":\"format\",\"value\":\"xcmol-532\"}],\"eventTypes\":[\"AddressCreated\",\"AddressCreated\",\"AddressCreated\",\"AddressCreated\"],\"id\":\"23918\",\"name\":\"Webhook-123\",\"secretKey\":\"11121-31231-1231212\",\"url\":\"https://www.webhook-123.com/webhook/listener\",\"version\":\"2018-01-01\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        WebhooksListWebhooksResponseBody response =
                client.webhooks().listWebhooks(ListWebhooksRequest.builder().build());
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
                + "      \"customHeaders\": [\n"
                + "        {\n"
                + "          \"key\": \"format\",\n"
                + "          \"value\": \"xcmol-532\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"eventTypes\": [\n"
                + "        \"AddressCreated\",\n"
                + "        \"AddressCreated\",\n"
                + "        \"AddressCreated\",\n"
                + "        \"AddressCreated\"\n"
                + "      ],\n"
                + "      \"id\": \"23918\",\n"
                + "      \"name\": \"Webhook-123\",\n"
                + "      \"secretKey\": \"11121-31231-1231212\",\n"
                + "      \"url\": \"https://www.webhook-123.com/webhook/listener\",\n"
                + "      \"version\": \"2018-01-01\"\n"
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
    public void testPostWebhooks() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"customHeaders\":[{\"key\":\"format\",\"value\":\"xcmol-532\"}],\"eventTypes\":[\"AddressCreated\",\"AddressCreated\",\"AddressCreated\",\"AddressCreated\"],\"id\":\"23918\",\"name\":\"Webhook-123\",\"secretKey\":\"11121-31231-1231212\",\"url\":\"https://www.webhook-123.com/webhook/listener\",\"version\":\"2018-01-01\"}"));
        WebhooksPostWebhooksResponseBody response = client.webhooks()
                .postWebhooks(WebhooksPostWebhooksRequestBody.builder()
                        .name("Webhook-123")
                        .url("https://www.Webhook-123.com/webhook/listener")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"name\": \"Webhook-123\",\n"
                + "  \"url\": \"https://www.Webhook-123.com/webhook/listener\"\n"
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
                + "  \"customHeaders\": [\n"
                + "    {\n"
                + "      \"key\": \"format\",\n"
                + "      \"value\": \"xcmol-532\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"eventTypes\": [\n"
                + "    \"AddressCreated\",\n"
                + "    \"AddressCreated\",\n"
                + "    \"AddressCreated\",\n"
                + "    \"AddressCreated\"\n"
                + "  ],\n"
                + "  \"id\": \"23918\",\n"
                + "  \"name\": \"Webhook-123\",\n"
                + "  \"secretKey\": \"11121-31231-1231212\",\n"
                + "  \"url\": \"https://www.webhook-123.com/webhook/listener\",\n"
                + "  \"version\": \"2018-01-01\"\n"
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
    public void testGetWebhook() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"customHeaders\":[{\"key\":\"format\",\"value\":\"xcmol-532\"}],\"eventTypes\":[\"AddressCreated\",\"AddressCreated\",\"AddressCreated\",\"AddressCreated\"],\"id\":\"23918\",\"name\":\"Webhook-123\",\"secretKey\":\"11121-31231-1231212\",\"url\":\"https://www.webhook-123.com/webhook/listener\",\"version\":\"2018-01-01\"}"));
        WebhooksGetWebhookResponseBody response = client.webhooks().getWebhook("id");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"customHeaders\": [\n"
                + "    {\n"
                + "      \"key\": \"format\",\n"
                + "      \"value\": \"xcmol-532\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"eventTypes\": [\n"
                + "    \"AddressCreated\",\n"
                + "    \"AddressCreated\",\n"
                + "    \"AddressCreated\",\n"
                + "    \"AddressCreated\"\n"
                + "  ],\n"
                + "  \"id\": \"23918\",\n"
                + "  \"name\": \"Webhook-123\",\n"
                + "  \"secretKey\": \"11121-31231-1231212\",\n"
                + "  \"url\": \"https://www.webhook-123.com/webhook/listener\",\n"
                + "  \"version\": \"2018-01-01\"\n"
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
    public void testDeleteWebhook() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.webhooks().deleteWebhook("id");
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testPatchWebhook() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"customHeaders\":[{\"key\":\"format\",\"value\":\"xcmol-532\"}],\"eventTypes\":[\"AddressCreated\",\"AddressCreated\",\"AddressCreated\"],\"id\":\"23918\",\"name\":\"Webhook-123\",\"secretKey\":\"11121-31231-1231212\",\"url\":\"https://www.webhook-123.com/webhook/listener\",\"version\":\"2018-01-01\"}"));
        WebhooksPatchWebhookResponseBody response = client.webhooks()
                .patchWebhook("id", WebhooksPatchWebhookRequestBody.builder().build());
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
                + "  \"customHeaders\": [\n"
                + "    {\n"
                + "      \"key\": \"format\",\n"
                + "      \"value\": \"xcmol-532\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"eventTypes\": [\n"
                + "    \"AddressCreated\",\n"
                + "    \"AddressCreated\",\n"
                + "    \"AddressCreated\"\n"
                + "  ],\n"
                + "  \"id\": \"23918\",\n"
                + "  \"name\": \"Webhook-123\",\n"
                + "  \"secretKey\": \"11121-31231-1231212\",\n"
                + "  \"url\": \"https://www.webhook-123.com/webhook/listener\",\n"
                + "  \"version\": \"2018-01-01\"\n"
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
