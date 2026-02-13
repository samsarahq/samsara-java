package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.issues.requests.GetIssuesRequest;
import com.samsara.api.resources.issues.requests.GetIssuesStreamRequest;
import com.samsara.api.resources.issues.requests.IssuesPatchIssueRequestBody;
import com.samsara.api.types.IssuesGetIssuesResponseBody;
import com.samsara.api.types.IssuesGetIssuesStreamResponseBody;
import com.samsara.api.types.IssuesPatchIssueResponseBody;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IssuesWireTest {
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
    public void testGetIssues() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource("/wire-tests/IssuesWireTest_testGetIssues_response.json")));
        IssuesGetIssuesResponseBody response =
                client.issues().getIssues(GetIssuesRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/IssuesWireTest_testGetIssues_response.json");
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
    public void testPatchIssue() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"asset\":{\"entryType\":\"tracked\",\"externalIds\":{\"key\":\"value\"},\"id\":\"281474982859091\",\"name\":\"trailer 123\"},\"assignedTo\":{\"id\":\"938172\",\"type\":\"driver\"},\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"description\":\"Oil spill in left corner of SF1\",\"dueDate\":\"2019-06-13T19:08:25Z\",\"externalIds\":{\"key\":\"value\"},\"id\":\"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\"issueSource\":{\"id\":\"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\"type\":\"form\"},\"mediaList\":[{\"id\":\"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\"processingStatus\":\"unknown\",\"url\":\"https://samsara-forms-submission-media-uploads.s3.us-west-2.amazonaws.com/123456\",\"urlExpiresAt\":\"2019-06-13T19:08:25Z\"}],\"priority\":\"low\",\"status\":\"open\",\"submittedAtTime\":\"2019-06-13T19:08:25Z\",\"submittedBy\":{\"id\":\"938172\",\"type\":\"driver\"},\"title\":\"Oil spill\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}}"));
        IssuesPatchIssueResponseBody response = client.issues()
                .patchIssue(IssuesPatchIssueRequestBody.builder()
                        .id("9814a1fa-f0c6-408b-bf85-51dc3bc71ac7")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("PATCH", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\"\n" + "}";
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
                + "      \"entryType\": \"tracked\",\n"
                + "      \"externalIds\": {\n"
                + "        \"key\": \"value\"\n"
                + "      },\n"
                + "      \"id\": \"281474982859091\",\n"
                + "      \"name\": \"trailer 123\"\n"
                + "    },\n"
                + "    \"assignedTo\": {\n"
                + "      \"id\": \"938172\",\n"
                + "      \"type\": \"driver\"\n"
                + "    },\n"
                + "    \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"description\": \"Oil spill in left corner of SF1\",\n"
                + "    \"dueDate\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"externalIds\": {\n"
                + "      \"key\": \"value\"\n"
                + "    },\n"
                + "    \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\n"
                + "    \"issueSource\": {\n"
                + "      \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\n"
                + "      \"type\": \"form\"\n"
                + "    },\n"
                + "    \"mediaList\": [\n"
                + "      {\n"
                + "        \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\n"
                + "        \"processingStatus\": \"unknown\",\n"
                + "        \"url\": \"https://samsara-forms-submission-media-uploads.s3.us-west-2.amazonaws.com/123456\",\n"
                + "        \"urlExpiresAt\": \"2019-06-13T19:08:25Z\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"priority\": \"low\",\n"
                + "    \"status\": \"open\",\n"
                + "    \"submittedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"submittedBy\": {\n"
                + "      \"id\": \"938172\",\n"
                + "      \"type\": \"driver\"\n"
                + "    },\n"
                + "    \"title\": \"Oil spill\",\n"
                + "    \"updatedAtTime\": \"2019-06-13T19:08:25Z\"\n"
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
    public void testGetIssuesStream() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"asset\":{\"entryType\":\"tracked\",\"id\":\"281474982859091\",\"name\":\"trailer 123\"},\"assignedTo\":{\"id\":\"938172\",\"type\":\"driver\"},\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"description\":\"Oil spill in left corner of SF1\",\"dueDate\":\"2019-06-13T19:08:25Z\",\"externalIds\":{\"key\":\"value\"},\"id\":\"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\"issueSource\":{\"id\":\"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\"type\":\"form\"},\"mediaList\":[{\"id\":\"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\"processingStatus\":\"unknown\",\"url\":\"https://samsara-forms-submission-media-uploads.s3.us-west-2.amazonaws.com/123456\",\"urlExpiresAt\":\"2019-06-13T19:08:25Z\"}],\"priority\":\"low\",\"status\":\"open\",\"submittedAtTime\":\"2019-06-13T19:08:25Z\",\"submittedBy\":{\"id\":\"938172\",\"type\":\"driver\"},\"title\":\"Oil spill\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        IssuesGetIssuesStreamResponseBody response = client.issues()
                .getIssuesStream(
                        GetIssuesStreamRequest.builder().startTime("startTime").build());
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
                + "      \"asset\": {\n"
                + "        \"entryType\": \"tracked\",\n"
                + "        \"id\": \"281474982859091\",\n"
                + "        \"name\": \"trailer 123\"\n"
                + "      },\n"
                + "      \"assignedTo\": {\n"
                + "        \"id\": \"938172\",\n"
                + "        \"type\": \"driver\"\n"
                + "      },\n"
                + "      \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"description\": \"Oil spill in left corner of SF1\",\n"
                + "      \"dueDate\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"externalIds\": {\n"
                + "        \"key\": \"value\"\n"
                + "      },\n"
                + "      \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\n"
                + "      \"issueSource\": {\n"
                + "        \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\n"
                + "        \"type\": \"form\"\n"
                + "      },\n"
                + "      \"mediaList\": [\n"
                + "        {\n"
                + "          \"id\": \"9814a1fa-f0c6-408b-bf85-51dc3bc71ac7\",\n"
                + "          \"processingStatus\": \"unknown\",\n"
                + "          \"url\": \"https://samsara-forms-submission-media-uploads.s3.us-west-2.amazonaws.com/123456\",\n"
                + "          \"urlExpiresAt\": \"2019-06-13T19:08:25Z\"\n"
                + "        }\n"
                + "      ],\n"
                + "      \"priority\": \"low\",\n"
                + "      \"status\": \"open\",\n"
                + "      \"submittedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"submittedBy\": {\n"
                + "        \"id\": \"938172\",\n"
                + "        \"type\": \"driver\"\n"
                + "      },\n"
                + "      \"title\": \"Oil spill\",\n"
                + "      \"updatedAtTime\": \"2019-06-13T19:08:25Z\"\n"
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
