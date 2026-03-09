package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.previewapis.requests.DeviceRecoveryMarkAssetMissingRequestBody;
import com.samsara.api.resources.previewapis.requests.DeviceRecoveryRecoverAssetRequestBody;
import com.samsara.api.resources.previewapis.requests.DriversAuthTokenCreateDriverAuthTokenRequestBody;
import com.samsara.api.resources.previewapis.requests.ListDeviceRecoveryMissingAssetsRequest;
import com.samsara.api.resources.previewapis.requests.LockVehicleRequest;
import com.samsara.api.resources.previewapis.requests.UnlockVehicleRequest;
import com.samsara.api.resources.previewapis.types.DeviceRecoveryRecoverAssetRequestBodyMissingReason;
import com.samsara.api.resources.previewapis.types.DeviceRecoveryRecoverAssetRequestBodyRecoveryStatus;
import com.samsara.api.resources.previewapis.types.DeviceRecoveryRecoverAssetRequestBodyStatus;
import com.samsara.api.types.DeviceRecoveryListDeviceRecoveryMissingAssetsResponseBody;
import com.samsara.api.types.DeviceRecoveryMarkAssetMissingResponseBody;
import com.samsara.api.types.DeviceRecoveryRecoverAssetResponseBody;
import com.samsara.api.types.DriversAuthTokenCreateDriverAuthTokenResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PreviewApIsWireTest {
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
    public void testListDeviceRecoveryMissingAssets() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"id\":\"12345\",\"name\":\"Trailer-A1234\",\"note\":\"Asset was last seen at warehouse A\",\"notification_recipients\":[{\"notification_types\":[\"email\"],\"user_id\":1234}],\"updated_at_ms\":1609459200000,\"updated_by_user_id\":1234,\"uuid\":\"550e8400-e29b-41d4-a716-446655440000\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        DeviceRecoveryListDeviceRecoveryMissingAssetsResponseBody response = client.previewApIs()
                .listDeviceRecoveryMissingAssets(
                        ListDeviceRecoveryMissingAssetsRequest.builder().build());
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
                + "      \"id\": \"12345\",\n"
                + "      \"name\": \"Trailer-A1234\",\n"
                + "      \"note\": \"Asset was last seen at warehouse A\",\n"
                + "      \"notification_recipients\": [\n"
                + "        {\n"
                + "          \"notification_types\": [\n"
                + "            \"email\"\n"
                + "          ],\n"
                + "          \"user_id\": 1234\n"
                + "        }\n"
                + "      ],\n"
                + "      \"updated_at_ms\": 1609459200000,\n"
                + "      \"updated_by_user_id\": 1234,\n"
                + "      \"uuid\": \"550e8400-e29b-41d4-a716-446655440000\"\n"
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
    public void testMarkAssetMissing() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"id\":\"12345\",\"name\":\"Trailer-A1234\",\"note\":\"Asset was last seen at warehouse A\",\"notification_recipients\":[{\"notification_types\":[\"email\"],\"user_id\":1234}],\"updated_at_ms\":1609459200000,\"updated_by_user_id\":1234,\"uuid\":\"550e8400-e29b-41d4-a716-446655440000\"}}"));
        DeviceRecoveryMarkAssetMissingResponseBody response = client.previewApIs()
                .markAssetMissing(
                        "id",
                        DeviceRecoveryMarkAssetMissingRequestBody.builder().build());
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
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"id\": \"12345\",\n"
                + "    \"name\": \"Trailer-A1234\",\n"
                + "    \"note\": \"Asset was last seen at warehouse A\",\n"
                + "    \"notification_recipients\": [\n"
                + "      {\n"
                + "        \"notification_types\": [\n"
                + "          \"email\"\n"
                + "        ],\n"
                + "        \"user_id\": 1234\n"
                + "      }\n"
                + "    ],\n"
                + "    \"updated_at_ms\": 1609459200000,\n"
                + "    \"updated_by_user_id\": 1234,\n"
                + "    \"uuid\": \"550e8400-e29b-41d4-a716-446655440000\"\n"
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
    public void testRecoverAsset() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"id\":\"12345\",\"name\":\"Trailer-A1234\",\"note\":\"Asset was last seen at warehouse A\",\"notification_recipients\":[{\"notification_types\":[\"email\"],\"user_id\":1234}],\"recovery_photos\":[{\"start_ms\":1609459200000,\"status\":\"EXISTS\",\"url\":\"https://s3.amazonaws.com/samsara-recovery-photos/example.jpg\",\"url_expires_at_ms\":1609462800000}],\"updated_at_ms\":1609459200000,\"updated_by_user_id\":1234,\"uuid\":\"550e8400-e29b-41d4-a716-446655440000\"}}"));
        DeviceRecoveryRecoverAssetResponseBody response = client.previewApIs()
                .recoverAsset(
                        "id",
                        DeviceRecoveryRecoverAssetRequestBody.builder()
                                .missingReason(DeviceRecoveryRecoverAssetRequestBodyMissingReason.MISPLACED)
                                .recoveryStatus(DeviceRecoveryRecoverAssetRequestBodyRecoveryStatus.YES)
                                .status(DeviceRecoveryRecoverAssetRequestBodyStatus.RECOVERED)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"missing_reason\": \"MISPLACED\",\n"
                + "  \"recovery_status\": \"YES\",\n"
                + "  \"status\": \"RECOVERED\"\n"
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
                + "    \"id\": \"12345\",\n"
                + "    \"name\": \"Trailer-A1234\",\n"
                + "    \"note\": \"Asset was last seen at warehouse A\",\n"
                + "    \"notification_recipients\": [\n"
                + "      {\n"
                + "        \"notification_types\": [\n"
                + "          \"email\"\n"
                + "        ],\n"
                + "        \"user_id\": 1234\n"
                + "      }\n"
                + "    ],\n"
                + "    \"recovery_photos\": [\n"
                + "      {\n"
                + "        \"start_ms\": 1609459200000,\n"
                + "        \"status\": \"EXISTS\",\n"
                + "        \"url\": \"https://s3.amazonaws.com/samsara-recovery-photos/example.jpg\",\n"
                + "        \"url_expires_at_ms\": 1609462800000\n"
                + "      }\n"
                + "    ],\n"
                + "    \"updated_at_ms\": 1609459200000,\n"
                + "    \"updated_by_user_id\": 1234,\n"
                + "    \"uuid\": \"550e8400-e29b-41d4-a716-446655440000\"\n"
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
    public void testCreateDriverAuthToken() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"expirationTime\":1710000000000,\"token\":\"ZmFrZVRva2VuXzMyQnl0ZXNMb25nRm9yVGVzdA\"}}"));
        DriversAuthTokenCreateDriverAuthTokenResponseBody response = client.previewApIs()
                .createDriverAuthToken(DriversAuthTokenCreateDriverAuthTokenRequestBody.builder()
                        .code("dp[gZc1wAigz4uGa0Hh")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"code\": \"dp[gZc1wAigz4uGa0Hh\"\n" + "}";
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
                + "    \"expirationTime\": 1710000000000,\n"
                + "    \"token\": \"ZmFrZVRva2VuXzMyQnl0ZXNMb25nRm9yVGVzdA\"\n"
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
    public void testLockVehicle() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.previewApIs().lockVehicle("id", LockVehicleRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PUT", request.getMethod());
    }

    @Test
    public void testUnlockVehicle() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.previewApIs().unlockVehicle("id", UnlockVehicleRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
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
