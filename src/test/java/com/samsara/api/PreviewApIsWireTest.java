package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.previewapis.requests.DriversAuthTokenCreateDriverAuthTokenRequestBody;
import com.samsara.api.resources.previewapis.requests.EntityUpcomingPreventativeMaintenancesServiceUpdateUpcomingPreventiveMaintenanceRequestBody;
import com.samsara.api.resources.previewapis.requests.FleetInstallerPhotoUploadsPostFleetInstallerPhotoUploadRequestBody;
import com.samsara.api.resources.previewapis.requests.LockVehicleRequest;
import com.samsara.api.resources.previewapis.requests.PostFleetInstallerPhotoUploadCompleteRequest;
import com.samsara.api.resources.previewapis.requests.UnlockVehicleRequest;
import com.samsara.api.resources.previewapis.types.FleetInstallerPhotoUploadsPostFleetInstallerPhotoUploadRequestBodyFileFormatType;
import com.samsara.api.resources.previewapis.types.FleetInstallerPhotoUploadsPostFleetInstallerPhotoUploadRequestBodyHardwareType;
import com.samsara.api.resources.previewapis.types.FleetInstallerPhotoUploadsPostFleetInstallerPhotoUploadRequestBodyPhotoType;
import com.samsara.api.types.DriversAuthTokenCreateDriverAuthTokenResponseBody;
import com.samsara.api.types.EntityUpcomingPreventativeMaintenancesServiceUpdateUpcomingPreventiveMaintenanceResponseBody;
import com.samsara.api.types.FleetInstallerPhotoUploadsPostFleetInstallerPhotoUploadCompleteResponseBody;
import com.samsara.api.types.FleetInstallerPhotoUploadsPostFleetInstallerPhotoUploadResponseBody;
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
    public void testPostFleetInstallerPhotoUpload() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"contentMd5\":\"rL0Y20zC+Fzt72VPzMSk2A==\",\"createdAtTime\":\"2026-06-01T18:15:00Z\",\"deviceId\":\"281474977961335\",\"fileFormatType\":\"imageJpeg\",\"fileName\":\"front_camera_install.jpg\",\"hardwareType\":\"vehicleGateway\",\"id\":\"550e8400-e29b-41d4-a716-446655440000\",\"photoType\":\"installPhoto\",\"processingStatus\":\"awaitingUpload\",\"sizeBytes\":482193,\"updatedAtTime\":\"2026-06-01T18:15:00Z\",\"uploadContext\":{\"expiresAtTime\":\"2026-06-01T18:30:00Z\",\"headers\":{\"Content-Length\":\"482193\",\"Content-MD5\":\"rL0Y20zC+Fzt72VPzMSk2A==\",\"Content-Type\":\"image/jpeg\"},\"uploadUrl\":\"https://samsara-media.s3.amazonaws.com/fleet-installer/550e8400-e29b-41d4-a716-446655440000\"}}}"));
        FleetInstallerPhotoUploadsPostFleetInstallerPhotoUploadResponseBody response = client.previewApIs()
                .postFleetInstallerPhotoUpload(
                        FleetInstallerPhotoUploadsPostFleetInstallerPhotoUploadRequestBody.builder()
                                .contentMd5("rL0Y20zC+Fzt72VPzMSk2A==")
                                .deviceId("281474977961335")
                                .fileFormatType(
                                        FleetInstallerPhotoUploadsPostFleetInstallerPhotoUploadRequestBodyFileFormatType
                                                .IMAGE_JPEG)
                                .fileName("front_camera_install.jpg")
                                .hardwareType(
                                        FleetInstallerPhotoUploadsPostFleetInstallerPhotoUploadRequestBodyHardwareType
                                                .VEHICLE_GATEWAY)
                                .photoType(
                                        FleetInstallerPhotoUploadsPostFleetInstallerPhotoUploadRequestBodyPhotoType
                                                .INSTALL_PHOTO)
                                .sizeBytes(482193L)
                                .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"contentMd5\": \"rL0Y20zC+Fzt72VPzMSk2A==\",\n"
                + "  \"deviceId\": \"281474977961335\",\n"
                + "  \"fileFormatType\": \"imageJpeg\",\n"
                + "  \"fileName\": \"front_camera_install.jpg\",\n"
                + "  \"hardwareType\": \"vehicleGateway\",\n"
                + "  \"photoType\": \"installPhoto\",\n"
                + "  \"sizeBytes\": 482193\n"
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
                + "    \"contentMd5\": \"rL0Y20zC+Fzt72VPzMSk2A==\",\n"
                + "    \"createdAtTime\": \"2026-06-01T18:15:00Z\",\n"
                + "    \"deviceId\": \"281474977961335\",\n"
                + "    \"fileFormatType\": \"imageJpeg\",\n"
                + "    \"fileName\": \"front_camera_install.jpg\",\n"
                + "    \"hardwareType\": \"vehicleGateway\",\n"
                + "    \"id\": \"550e8400-e29b-41d4-a716-446655440000\",\n"
                + "    \"photoType\": \"installPhoto\",\n"
                + "    \"processingStatus\": \"awaitingUpload\",\n"
                + "    \"sizeBytes\": 482193,\n"
                + "    \"updatedAtTime\": \"2026-06-01T18:15:00Z\",\n"
                + "    \"uploadContext\": {\n"
                + "      \"expiresAtTime\": \"2026-06-01T18:30:00Z\",\n"
                + "      \"headers\": {\n"
                + "        \"Content-Length\": \"482193\",\n"
                + "        \"Content-MD5\": \"rL0Y20zC+Fzt72VPzMSk2A==\",\n"
                + "        \"Content-Type\": \"image/jpeg\"\n"
                + "      },\n"
                + "      \"uploadUrl\": \"https://samsara-media.s3.amazonaws.com/fleet-installer/550e8400-e29b-41d4-a716-446655440000\"\n"
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

    @Test
    public void testPostFleetInstallerPhotoUploadComplete() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"contentMd5\":\"rL0Y20zC+Fzt72VPzMSk2A==\",\"createdAtTime\":\"2026-06-01T18:15:00Z\",\"deviceId\":\"281474977961335\",\"fileFormatType\":\"imageJpeg\",\"fileName\":\"front_camera_install.jpg\",\"hardwareType\":\"vehicleGateway\",\"id\":\"550e8400-e29b-41d4-a716-446655440000\",\"photoType\":\"installPhoto\",\"processingStatus\":\"awaitingUpload\",\"sizeBytes\":482193,\"updatedAtTime\":\"2026-06-01T18:15:00Z\"}}"));
        FleetInstallerPhotoUploadsPostFleetInstallerPhotoUploadCompleteResponseBody response = client.previewApIs()
                .postFleetInstallerPhotoUploadComplete(PostFleetInstallerPhotoUploadCompleteRequest.builder()
                        .id("id")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody = ""
                + "{\n"
                + "  \"data\": {\n"
                + "    \"contentMd5\": \"rL0Y20zC+Fzt72VPzMSk2A==\",\n"
                + "    \"createdAtTime\": \"2026-06-01T18:15:00Z\",\n"
                + "    \"deviceId\": \"281474977961335\",\n"
                + "    \"fileFormatType\": \"imageJpeg\",\n"
                + "    \"fileName\": \"front_camera_install.jpg\",\n"
                + "    \"hardwareType\": \"vehicleGateway\",\n"
                + "    \"id\": \"550e8400-e29b-41d4-a716-446655440000\",\n"
                + "    \"photoType\": \"installPhoto\",\n"
                + "    \"processingStatus\": \"awaitingUpload\",\n"
                + "    \"sizeBytes\": 482193,\n"
                + "    \"updatedAtTime\": \"2026-06-01T18:15:00Z\"\n"
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

    @Test
    public void testUpdateUpcomingPreventiveMaintenance() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"asset\":{\"id\":\"281474976710656\"},\"currentEngineHours\":12345,\"currentOdometer\":12345,\"currentOdometerMiles\":12345,\"dueInDays\":12345,\"dueInEngineHours\":12345,\"dueInOdometer\":12345,\"dueInOdometerMiles\":12345,\"lastResolvedAt\":\"2019-06-13T19:08:25Z\",\"lastResolvedAtEngineHours\":12345,\"lastResolvedAtOdometer\":12345,\"nextEngineHours\":12345,\"nextOdometer\":12345,\"nextOdometerMiles\":12345,\"nextTime\":\"2019-06-13T19:08:25Z\",\"priority\":12345,\"schedule\":{\"id\":\"281474976710656\"},\"status\":\"12345\",\"workOrder\":{\"id\":\"281474976710656\"}}}"));
        EntityUpcomingPreventativeMaintenancesServiceUpdateUpcomingPreventiveMaintenanceResponseBody response =
                client.previewApIs()
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
                + "    \"currentEngineHours\": 12345,\n"
                + "    \"currentOdometer\": 12345,\n"
                + "    \"currentOdometerMiles\": 12345,\n"
                + "    \"dueInDays\": 12345,\n"
                + "    \"dueInEngineHours\": 12345,\n"
                + "    \"dueInOdometer\": 12345,\n"
                + "    \"dueInOdometerMiles\": 12345,\n"
                + "    \"lastResolvedAt\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"lastResolvedAtEngineHours\": 12345,\n"
                + "    \"lastResolvedAtOdometer\": 12345,\n"
                + "    \"nextEngineHours\": 12345,\n"
                + "    \"nextOdometer\": 12345,\n"
                + "    \"nextOdometerMiles\": 12345,\n"
                + "    \"nextTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"priority\": 12345,\n"
                + "    \"schedule\": {\n"
                + "      \"id\": \"281474976710656\"\n"
                + "    },\n"
                + "    \"status\": \"12345\",\n"
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
