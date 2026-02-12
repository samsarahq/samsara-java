package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.livesharinglinks.requests.DeleteLiveSharingLinkRequest;
import com.samsara.api.resources.livesharinglinks.requests.GetLiveSharingLinksRequest;
import com.samsara.api.resources.livesharinglinks.requests.LiveSharingLinksCreateLiveSharingLinkRequestBody;
import com.samsara.api.resources.livesharinglinks.requests.LiveSharingLinksUpdateLiveSharingLinkRequestBody;
import com.samsara.api.resources.livesharinglinks.types.LiveSharingLinksCreateLiveSharingLinkRequestBodyType;
import com.samsara.api.types.LiveSharingLinksCreateLiveSharingLinkResponseBody;
import com.samsara.api.types.LiveSharingLinksGetLiveSharingLinksResponseBody;
import com.samsara.api.types.LiveSharingLinksUpdateLiveSharingLinkResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LiveSharingLinksWireTest {
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
    public void testGetLiveSharingLinks() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"assetsLocationLinkConfig\":{\"assetId\":\"1234\",\"location\":{\"formattedAddress\":\"1990 Alameda Street, San Francisco, CA 94103\",\"latitude\":37.456345,\"longitude\":34.5633749,\"name\":\"Suburbs\"},\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}]},\"assetsNearLocationLinkConfig\":{\"addressId\":\"1234\"},\"assetsOnRouteLinkConfig\":{\"recurringRouteId\":\"1234\"},\"description\":\"Sample description\",\"expiresAtTime\":\"2020-01-27T07:06:25Z\",\"id\":\"leesdwqjx42dkvp86so\",\"liveSharingUrl\":\"https://cloud.samsara.com/o/123456/fleet/viewer/address/7hf4lnu455wep22rtun\",\"name\":\"Example Live Sharing Link name\",\"type\":\"assetsLocation\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        LiveSharingLinksGetLiveSharingLinksResponseBody response = client.liveSharingLinks()
                .getLiveSharingLinks(GetLiveSharingLinksRequest.builder().build());
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
                + "      \"assetsLocationLinkConfig\": {\n"
                + "        \"assetId\": \"1234\",\n"
                + "        \"location\": {\n"
                + "          \"formattedAddress\": \"1990 Alameda Street, San Francisco, CA 94103\",\n"
                + "          \"latitude\": 37.456345,\n"
                + "          \"longitude\": 34.5633749,\n"
                + "          \"name\": \"Suburbs\"\n"
                + "        },\n"
                + "        \"tags\": [\n"
                + "          {\n"
                + "            \"id\": \"3914\",\n"
                + "            \"name\": \"East Coast\",\n"
                + "            \"parentTagId\": \"4815\"\n"
                + "          }\n"
                + "        ]\n"
                + "      },\n"
                + "      \"assetsNearLocationLinkConfig\": {\n"
                + "        \"addressId\": \"1234\"\n"
                + "      },\n"
                + "      \"assetsOnRouteLinkConfig\": {\n"
                + "        \"recurringRouteId\": \"1234\"\n"
                + "      },\n"
                + "      \"description\": \"Sample description\",\n"
                + "      \"expiresAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "      \"id\": \"leesdwqjx42dkvp86so\",\n"
                + "      \"liveSharingUrl\": \"https://cloud.samsara.com/o/123456/fleet/viewer/address/7hf4lnu455wep22rtun\",\n"
                + "      \"name\": \"Example Live Sharing Link name\",\n"
                + "      \"type\": \"assetsLocation\"\n"
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
    public void testCreateLiveSharingLink() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"assetsLocationLinkConfig\":{\"assetId\":\"1234\",\"location\":{\"formattedAddress\":\"1990 Alameda Street, San Francisco, CA 94103\",\"latitude\":37.456345,\"longitude\":34.5633749,\"name\":\"Suburbs\"},\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}]},\"assetsNearLocationLinkConfig\":{\"addressId\":\"1234\"},\"assetsOnRouteLinkConfig\":{\"recurringRouteId\":\"1234\"},\"description\":\"Sample description\",\"expiresAtTime\":\"2020-01-27T07:06:25Z\",\"id\":\"leesdwqjx42dkvp86so\",\"liveSharingUrl\":\"https://cloud.samsara.com/o/123456/fleet/viewer/address/7hf4lnu455wep22rtun\",\"name\":\"Example Live Sharing Link name\",\"type\":\"assetsLocation\"}}"));
        LiveSharingLinksCreateLiveSharingLinkResponseBody response = client.liveSharingLinks()
                .createLiveSharingLink(LiveSharingLinksCreateLiveSharingLinkRequestBody.builder()
                        .name("Example Live Sharing Link name")
                        .type(LiveSharingLinksCreateLiveSharingLinkRequestBodyType.ASSETS_LOCATION)
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"name\": \"Example Live Sharing Link name\",\n"
                + "  \"type\": \"assetsLocation\"\n"
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
                + "    \"assetsLocationLinkConfig\": {\n"
                + "      \"assetId\": \"1234\",\n"
                + "      \"location\": {\n"
                + "        \"formattedAddress\": \"1990 Alameda Street, San Francisco, CA 94103\",\n"
                + "        \"latitude\": 37.456345,\n"
                + "        \"longitude\": 34.5633749,\n"
                + "        \"name\": \"Suburbs\"\n"
                + "      },\n"
                + "      \"tags\": [\n"
                + "        {\n"
                + "          \"id\": \"3914\",\n"
                + "          \"name\": \"East Coast\",\n"
                + "          \"parentTagId\": \"4815\"\n"
                + "        }\n"
                + "      ]\n"
                + "    },\n"
                + "    \"assetsNearLocationLinkConfig\": {\n"
                + "      \"addressId\": \"1234\"\n"
                + "    },\n"
                + "    \"assetsOnRouteLinkConfig\": {\n"
                + "      \"recurringRouteId\": \"1234\"\n"
                + "    },\n"
                + "    \"description\": \"Sample description\",\n"
                + "    \"expiresAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "    \"id\": \"leesdwqjx42dkvp86so\",\n"
                + "    \"liveSharingUrl\": \"https://cloud.samsara.com/o/123456/fleet/viewer/address/7hf4lnu455wep22rtun\",\n"
                + "    \"name\": \"Example Live Sharing Link name\",\n"
                + "    \"type\": \"assetsLocation\"\n"
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
    public void testDeleteLiveSharingLink() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.liveSharingLinks()
                .deleteLiveSharingLink(
                        DeleteLiveSharingLinkRequest.builder().id("id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testUpdateLiveSharingLink() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"assetsLocationLinkConfig\":{\"assetId\":\"1234\",\"location\":{\"formattedAddress\":\"1990 Alameda Street, San Francisco, CA 94103\",\"latitude\":37.456345,\"longitude\":34.5633749,\"name\":\"Suburbs\"},\"tags\":[{\"id\":\"3914\",\"name\":\"East Coast\",\"parentTagId\":\"4815\"}]},\"assetsNearLocationLinkConfig\":{\"addressId\":\"1234\"},\"assetsOnRouteLinkConfig\":{\"recurringRouteId\":\"1234\"},\"description\":\"Sample description\",\"expiresAtTime\":\"2020-01-27T07:06:25Z\",\"id\":\"leesdwqjx42dkvp86so\",\"liveSharingUrl\":\"https://cloud.samsara.com/o/123456/fleet/viewer/address/7hf4lnu455wep22rtun\",\"name\":\"Example Live Sharing Link name\",\"type\":\"assetsLocation\"}}"));
        LiveSharingLinksUpdateLiveSharingLinkResponseBody response = client.liveSharingLinks()
                .updateLiveSharingLink(LiveSharingLinksUpdateLiveSharingLinkRequestBody.builder()
                        .id("id")
                        .name("Example Live Sharing Link name")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"name\": \"Example Live Sharing Link name\"\n" + "}";
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
                + "    \"assetsLocationLinkConfig\": {\n"
                + "      \"assetId\": \"1234\",\n"
                + "      \"location\": {\n"
                + "        \"formattedAddress\": \"1990 Alameda Street, San Francisco, CA 94103\",\n"
                + "        \"latitude\": 37.456345,\n"
                + "        \"longitude\": 34.5633749,\n"
                + "        \"name\": \"Suburbs\"\n"
                + "      },\n"
                + "      \"tags\": [\n"
                + "        {\n"
                + "          \"id\": \"3914\",\n"
                + "          \"name\": \"East Coast\",\n"
                + "          \"parentTagId\": \"4815\"\n"
                + "        }\n"
                + "      ]\n"
                + "    },\n"
                + "    \"assetsNearLocationLinkConfig\": {\n"
                + "      \"addressId\": \"1234\"\n"
                + "    },\n"
                + "    \"assetsOnRouteLinkConfig\": {\n"
                + "      \"recurringRouteId\": \"1234\"\n"
                + "    },\n"
                + "    \"description\": \"Sample description\",\n"
                + "    \"expiresAtTime\": \"2020-01-27T07:06:25Z\",\n"
                + "    \"id\": \"leesdwqjx42dkvp86so\",\n"
                + "    \"liveSharingUrl\": \"https://cloud.samsara.com/o/123456/fleet/viewer/address/7hf4lnu455wep22rtun\",\n"
                + "    \"name\": \"Example Live Sharing Link name\",\n"
                + "    \"type\": \"assetsLocation\"\n"
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
