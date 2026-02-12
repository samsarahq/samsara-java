package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.media.requests.GetMediaRetrievalRequest;
import com.samsara.api.resources.media.requests.ListUploadedMediaRequest;
import com.samsara.api.resources.media.requests.MediaRetrievalPostMediaRetrievalRequestBody;
import com.samsara.api.resources.media.types.MediaRetrievalPostMediaRetrievalRequestBodyInputsItem;
import com.samsara.api.resources.media.types.MediaRetrievalPostMediaRetrievalRequestBodyMediaType;
import com.samsara.api.types.MediaRetrievalGetMediaRetrievalResponseBody;
import com.samsara.api.types.MediaRetrievalListUploadedMediaResponseBody;
import com.samsara.api.types.MediaRetrievalPostMediaRetrievalResponseBody;
import java.util.Arrays;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MediaWireTest {
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
    public void testListUploadedMedia() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"media\":[{\"availableAtTime\":\"2019-11-11T14:00:12-04:00\",\"endTime\":\"2019-06-13T19:08:25Z\",\"input\":\"dashcamForwardFacing\",\"mediaType\":\"image\",\"startTime\":\"2019-06-13T19:08:25Z\",\"triggerReason\":\"api\",\"urlInfo\":{\"url\":\"https://sample.s3.url.com/image.jpeg\",\"urlExpiryTime\":\"2019-11-11T14:00:12-04:00\"},\"vehicleId\":\"1234\"}]},\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        MediaRetrievalListUploadedMediaResponseBody response = client.media()
                .listUploadedMedia(ListUploadedMediaRequest.builder()
                        .vehicleIds("vehicleIds")
                        .startTime("startTime")
                        .endTime("endTime")
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
                + "    \"media\": [\n"
                + "      {\n"
                + "        \"availableAtTime\": \"2019-11-11T14:00:12-04:00\",\n"
                + "        \"endTime\": \"2019-06-13T19:08:25Z\",\n"
                + "        \"input\": \"dashcamForwardFacing\",\n"
                + "        \"mediaType\": \"image\",\n"
                + "        \"startTime\": \"2019-06-13T19:08:25Z\",\n"
                + "        \"triggerReason\": \"api\",\n"
                + "        \"urlInfo\": {\n"
                + "          \"url\": \"https://sample.s3.url.com/image.jpeg\",\n"
                + "          \"urlExpiryTime\": \"2019-11-11T14:00:12-04:00\"\n"
                + "        },\n"
                + "        \"vehicleId\": \"1234\"\n"
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
    public void testGetMediaRetrieval() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"media\":[{\"availableAtTime\":\"2019-11-11T14:00:12-04:00\",\"endTime\":\"2019-06-13T19:08:25Z\",\"input\":\"dashcamDriverFacing\",\"mediaType\":\"image\",\"startTime\":\"2019-06-13T19:08:25Z\",\"status\":\"available\",\"urlInfo\":{\"url\":\"https://sample.s3.url.com/image.jpeg\",\"urlExpiryTime\":\"2019-11-11T14:00:12-04:00\"},\"vehicleId\":\"1234\"}]}}"));
        MediaRetrievalGetMediaRetrievalResponseBody response = client.media()
                .getMediaRetrieval(GetMediaRetrievalRequest.builder()
                        .retrievalId("retrievalId")
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
                + "    \"media\": [\n"
                + "      {\n"
                + "        \"availableAtTime\": \"2019-11-11T14:00:12-04:00\",\n"
                + "        \"endTime\": \"2019-06-13T19:08:25Z\",\n"
                + "        \"input\": \"dashcamDriverFacing\",\n"
                + "        \"mediaType\": \"image\",\n"
                + "        \"startTime\": \"2019-06-13T19:08:25Z\",\n"
                + "        \"status\": \"available\",\n"
                + "        \"urlInfo\": {\n"
                + "          \"url\": \"https://sample.s3.url.com/image.jpeg\",\n"
                + "          \"urlExpiryTime\": \"2019-11-11T14:00:12-04:00\"\n"
                + "        },\n"
                + "        \"vehicleId\": \"1234\"\n"
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
    public void testPostMediaRetrieval() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"quotaStatus\":\"Current monthly usage is 80000.4 seconds of high-res video out of 900000.0 available.\",\"retrievalId\":\"2308cec4-82e0-46f1-8b3c-a3592e5cc21e\"}}"));
        MediaRetrievalPostMediaRetrievalResponseBody response = client.media()
                .postMediaRetrieval(MediaRetrievalPostMediaRetrievalRequestBody.builder()
                        .endTime("2019-06-13T19:08:55Z")
                        .mediaType(MediaRetrievalPostMediaRetrievalRequestBodyMediaType.IMAGE)
                        .startTime("2019-06-13T19:08:25Z")
                        .vehicleId("1234")
                        .inputs(Arrays.asList(
                                MediaRetrievalPostMediaRetrievalRequestBodyInputsItem.DASHCAM_ROAD_FACING,
                                MediaRetrievalPostMediaRetrievalRequestBodyInputsItem.DASHCAM_ROAD_FACING,
                                MediaRetrievalPostMediaRetrievalRequestBodyInputsItem.DASHCAM_ROAD_FACING))
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = ""
                + "{\n"
                + "  \"endTime\": \"2019-06-13T19:08:55Z\",\n"
                + "  \"inputs\": [\n"
                + "    \"dashcamRoadFacing\",\n"
                + "    \"dashcamRoadFacing\",\n"
                + "    \"dashcamRoadFacing\"\n"
                + "  ],\n"
                + "  \"mediaType\": \"image\",\n"
                + "  \"startTime\": \"2019-06-13T19:08:25Z\",\n"
                + "  \"vehicleId\": \"1234\"\n"
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
                + "    \"quotaStatus\": \"Current monthly usage is 80000.4 seconds of high-res video out of 900000.0 available.\",\n"
                + "    \"retrievalId\": \"2308cec4-82e0-46f1-8b3c-a3592e5cc21e\"\n"
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
