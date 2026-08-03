package com.samsara.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsara.api.core.ObjectMappers;
import com.samsara.api.resources.previewapis.requests.DeleteOrderRequest;
import com.samsara.api.resources.previewapis.requests.DeletePurchaseOrderRequest;
import com.samsara.api.resources.previewapis.requests.DriversAuthTokenCreateDriverAuthTokenRequestBody;
import com.samsara.api.resources.previewapis.requests.EntityPurchaseOrdersServiceCreatePurchaseOrderRequestBody;
import com.samsara.api.resources.previewapis.requests.EntityPurchaseOrdersServiceUpdatePurchaseOrderRequestBody;
import com.samsara.api.resources.previewapis.requests.GetOrderDeletionsRequest;
import com.samsara.api.resources.previewapis.requests.GetOrdersRequest;
import com.samsara.api.resources.previewapis.requests.GetOrdersStreamRequest;
import com.samsara.api.resources.previewapis.requests.ListPartTransactionsRequest;
import com.samsara.api.resources.previewapis.requests.ListPurchaseOrdersRequest;
import com.samsara.api.resources.previewapis.requests.LockVehicleRequest;
import com.samsara.api.resources.previewapis.requests.OrdersPostOrdersBatchRequestBody;
import com.samsara.api.resources.previewapis.requests.UnlockVehicleRequest;
import com.samsara.api.types.DriversAuthTokenCreateDriverAuthTokenResponseBody;
import com.samsara.api.types.EntityInventoryTransactionsServiceListPartTransactionsResponseBody;
import com.samsara.api.types.EntityPurchaseOrdersServiceCreatePurchaseOrderResponseBody;
import com.samsara.api.types.EntityPurchaseOrdersServiceListPurchaseOrdersResponseBody;
import com.samsara.api.types.EntityPurchaseOrdersServiceUpdatePurchaseOrderResponseBody;
import com.samsara.api.types.FleetOrderBatchUpsertInputRequestBody;
import com.samsara.api.types.OrdersGetOrderDeletionsResponseBody;
import com.samsara.api.types.OrdersGetOrdersResponseBody;
import com.samsara.api.types.OrdersGetOrdersStreamResponseBody;
import com.samsara.api.types.OrdersPostOrdersBatchResponseBody;
import java.time.OffsetDateTime;
import java.util.Arrays;
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
    public void testGetOrders() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource("/wire-tests/PreviewApIsWireTest_testGetOrders_response.json")));
        OrdersGetOrdersResponseBody response =
                client.previewApIs().getOrders(GetOrdersRequest.builder().build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/PreviewApIsWireTest_testGetOrders_response.json");
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
    public void testDeleteOrder() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.previewApIs()
                .deleteOrder(DeleteOrderRequest.builder().orderId("orderId").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testPostOrdersBatch() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/PreviewApIsWireTest_testPostOrdersBatch_response.json")));
        OrdersPostOrdersBatchResponseBody response = client.previewApIs()
                .postOrdersBatch(OrdersPostOrdersBatchRequestBody.builder()
                        .data(Arrays.asList(
                                FleetOrderBatchUpsertInputRequestBody.builder().build()))
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody = "" + "{\n" + "  \"data\": [\n" + "    {}\n" + "  ]\n" + "}";
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
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/PreviewApIsWireTest_testPostOrdersBatch_response.json");
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
    public void testGetOrderDeletions() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"deletedAtTime\":\"1996-12-03T23:18:35Z\",\"id\":\"018f7b62-7d55-7b9e-a92f-2a6b7ff10392\"}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        OrdersGetOrderDeletionsResponseBody response = client.previewApIs()
                .getOrderDeletions(GetOrderDeletionsRequest.builder().build());
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
                + "      \"deletedAtTime\": \"1996-12-03T23:18:35Z\",\n"
                + "      \"id\": \"018f7b62-7d55-7b9e-a92f-2a6b7ff10392\"\n"
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
    public void testGetOrdersStream() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/PreviewApIsWireTest_testGetOrdersStream_response.json")));
        OrdersGetOrdersStreamResponseBody response = client.previewApIs()
                .getOrdersStream(GetOrdersStreamRequest.builder()
                        .startTime(OffsetDateTime.parse("2024-01-15T09:30:00Z"))
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/PreviewApIsWireTest_testGetOrdersStream_response.json");
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
    public void testListPartTransactions() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":[{\"batch\":\"12345\",\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"createdByUserId\":\"12345\",\"fromPlaceId\":\"12345\",\"happenedAtTime\":\"2019-06-13T19:08:25Z\",\"id\":\"12345\",\"notes\":\"12345\",\"part\":{\"id\":\"281474976710656\"},\"placeId\":\"12345\",\"purchaseOrder\":\"12345\",\"quantity\":123.45,\"resultingQuantity\":123.45,\"toPlaceId\":\"12345\",\"transactionType\":\"12345\",\"unitCost\":123.45,\"vendorId\":\"12345\",\"workOrder\":{\"id\":\"281474976710656\"}}],\"pagination\":{\"endCursor\":\"MjkY\",\"hasNextPage\":true}}"));
        EntityInventoryTransactionsServiceListPartTransactionsResponseBody response = client.previewApIs()
                .listPartTransactions(ListPartTransactionsRequest.builder()
                        .happenedAtTimeStart("happenedAtTimeStart")
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
                + "      \"batch\": \"12345\",\n"
                + "      \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"createdByUserId\": \"12345\",\n"
                + "      \"fromPlaceId\": \"12345\",\n"
                + "      \"happenedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "      \"id\": \"12345\",\n"
                + "      \"notes\": \"12345\",\n"
                + "      \"part\": {\n"
                + "        \"id\": \"281474976710656\"\n"
                + "      },\n"
                + "      \"placeId\": \"12345\",\n"
                + "      \"purchaseOrder\": \"12345\",\n"
                + "      \"quantity\": 123.45,\n"
                + "      \"resultingQuantity\": 123.45,\n"
                + "      \"toPlaceId\": \"12345\",\n"
                + "      \"transactionType\": \"12345\",\n"
                + "      \"unitCost\": 123.45,\n"
                + "      \"vendorId\": \"12345\",\n"
                + "      \"workOrder\": {\n"
                + "        \"id\": \"281474976710656\"\n"
                + "      }\n"
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
    public void testListPurchaseOrders() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestResources.loadResource(
                        "/wire-tests/PreviewApIsWireTest_testListPurchaseOrders_response.json")));
        EntityPurchaseOrdersServiceListPurchaseOrdersResponseBody response = client.previewApIs()
                .listPurchaseOrders(ListPurchaseOrdersRequest.builder()
                        .startTime("startTime")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("GET", request.getMethod());

        // Validate response body
        Assertions.assertNotNull(response, "Response should not be null");
        String actualResponseJson = objectMapper.writeValueAsString(response);
        String expectedResponseBody =
                TestResources.loadResource("/wire-tests/PreviewApIsWireTest_testListPurchaseOrders_response.json");
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
    public void testCreatePurchaseOrder() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"creationSource\":\"12345\",\"deliveryAtTime\":\"2019-06-13T19:08:25Z\",\"firstReceivedAtTime\":\"2019-06-13T19:08:25Z\",\"fullyReceivedAtTime\":\"2019-06-13T19:08:25Z\",\"glCode\":\"12345\",\"id\":\"12345\",\"invoiceNumber\":\"12345\",\"mediaItemIds\":[\"12345\",\"12345\",\"12345\",\"12345\"],\"notes\":\"12345\",\"orderStatus\":\"12345\",\"otherCost\":{\"amount\":\"12345\",\"currency\":\"12345\"},\"parts\":[{\"batchNumber\":\"12345\",\"description\":\"12345\",\"lineItemId\":\"12345\",\"partSamsara\":{\"id\":\"281474976710656\"},\"place\":{\"id\":\"281474976710656\"},\"quantityOrdered\":123.45,\"quantityReceived\":123.45,\"unitOfMeasureType\":\"12345\"}],\"poNumber\":\"12345\",\"poNumberPrefix\":\"12345\",\"poNumberSuffix\":\"12345\",\"sentAtTime\":\"2019-06-13T19:08:25Z\",\"trackingNumber\":\"12345\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\",\"vendor\":{\"id\":\"281474976710656\"}}}"));
        EntityPurchaseOrdersServiceCreatePurchaseOrderResponseBody response = client.previewApIs()
                .createPurchaseOrder(EntityPurchaseOrdersServiceCreatePurchaseOrderRequestBody.builder()
                        .orderStatus("12345")
                        .vendorId("281474976710656")
                        .build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("POST", request.getMethod());
        // Validate request body
        String actualRequestBody = request.getBody().readUtf8();
        String expectedRequestBody =
                "" + "{\n" + "  \"orderStatus\": \"12345\",\n" + "  \"vendorId\": \"281474976710656\"\n" + "}";
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
                + "    \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"creationSource\": \"12345\",\n"
                + "    \"deliveryAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"firstReceivedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"fullyReceivedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"glCode\": \"12345\",\n"
                + "    \"id\": \"12345\",\n"
                + "    \"invoiceNumber\": \"12345\",\n"
                + "    \"mediaItemIds\": [\n"
                + "      \"12345\",\n"
                + "      \"12345\",\n"
                + "      \"12345\",\n"
                + "      \"12345\"\n"
                + "    ],\n"
                + "    \"notes\": \"12345\",\n"
                + "    \"orderStatus\": \"12345\",\n"
                + "    \"otherCost\": {\n"
                + "      \"amount\": \"12345\",\n"
                + "      \"currency\": \"12345\"\n"
                + "    },\n"
                + "    \"parts\": [\n"
                + "      {\n"
                + "        \"batchNumber\": \"12345\",\n"
                + "        \"description\": \"12345\",\n"
                + "        \"lineItemId\": \"12345\",\n"
                + "        \"partSamsara\": {\n"
                + "          \"id\": \"281474976710656\"\n"
                + "        },\n"
                + "        \"place\": {\n"
                + "          \"id\": \"281474976710656\"\n"
                + "        },\n"
                + "        \"quantityOrdered\": 123.45,\n"
                + "        \"quantityReceived\": 123.45,\n"
                + "        \"unitOfMeasureType\": \"12345\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"poNumber\": \"12345\",\n"
                + "    \"poNumberPrefix\": \"12345\",\n"
                + "    \"poNumberSuffix\": \"12345\",\n"
                + "    \"sentAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"trackingNumber\": \"12345\",\n"
                + "    \"updatedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"vendor\": {\n"
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

    @Test
    public void testDeletePurchaseOrder() throws Exception {
        server.enqueue(new MockResponse().setResponseCode(200).setBody("{}"));
        client.previewApIs()
                .deletePurchaseOrder(
                        DeletePurchaseOrderRequest.builder().id("id").build());
        RecordedRequest request = server.takeRequest();
        Assertions.assertNotNull(request);
        Assertions.assertEquals("DELETE", request.getMethod());
    }

    @Test
    public void testUpdatePurchaseOrder() throws Exception {
        server.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(
                                "{\"data\":{\"createdAtTime\":\"2019-06-13T19:08:25Z\",\"creationSource\":\"12345\",\"deliveryAtTime\":\"2019-06-13T19:08:25Z\",\"firstReceivedAtTime\":\"2019-06-13T19:08:25Z\",\"fullyReceivedAtTime\":\"2019-06-13T19:08:25Z\",\"glCode\":\"12345\",\"id\":\"12345\",\"invoiceNumber\":\"12345\",\"mediaItemIds\":[\"12345\",\"12345\",\"12345\"],\"notes\":\"12345\",\"orderStatus\":\"12345\",\"otherCost\":{\"amount\":\"12345\",\"currency\":\"12345\"},\"parts\":[{\"batchNumber\":\"12345\",\"description\":\"12345\",\"lineItemId\":\"12345\",\"partSamsara\":{\"id\":\"281474976710656\"},\"place\":{\"id\":\"281474976710656\"},\"quantityOrdered\":123.45,\"quantityReceived\":123.45,\"unitOfMeasureType\":\"12345\"}],\"poNumber\":\"12345\",\"poNumberPrefix\":\"12345\",\"poNumberSuffix\":\"12345\",\"sentAtTime\":\"2019-06-13T19:08:25Z\",\"trackingNumber\":\"12345\",\"updatedAtTime\":\"2019-06-13T19:08:25Z\",\"vendor\":{\"id\":\"281474976710656\"}}}"));
        EntityPurchaseOrdersServiceUpdatePurchaseOrderResponseBody response = client.previewApIs()
                .updatePurchaseOrder(EntityPurchaseOrdersServiceUpdatePurchaseOrderRequestBody.builder()
                        .id("id")
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
                + "    \"createdAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"creationSource\": \"12345\",\n"
                + "    \"deliveryAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"firstReceivedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"fullyReceivedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"glCode\": \"12345\",\n"
                + "    \"id\": \"12345\",\n"
                + "    \"invoiceNumber\": \"12345\",\n"
                + "    \"mediaItemIds\": [\n"
                + "      \"12345\",\n"
                + "      \"12345\",\n"
                + "      \"12345\"\n"
                + "    ],\n"
                + "    \"notes\": \"12345\",\n"
                + "    \"orderStatus\": \"12345\",\n"
                + "    \"otherCost\": {\n"
                + "      \"amount\": \"12345\",\n"
                + "      \"currency\": \"12345\"\n"
                + "    },\n"
                + "    \"parts\": [\n"
                + "      {\n"
                + "        \"batchNumber\": \"12345\",\n"
                + "        \"description\": \"12345\",\n"
                + "        \"lineItemId\": \"12345\",\n"
                + "        \"partSamsara\": {\n"
                + "          \"id\": \"281474976710656\"\n"
                + "        },\n"
                + "        \"place\": {\n"
                + "          \"id\": \"281474976710656\"\n"
                + "        },\n"
                + "        \"quantityOrdered\": 123.45,\n"
                + "        \"quantityReceived\": 123.45,\n"
                + "        \"unitOfMeasureType\": \"12345\"\n"
                + "      }\n"
                + "    ],\n"
                + "    \"poNumber\": \"12345\",\n"
                + "    \"poNumberPrefix\": \"12345\",\n"
                + "    \"poNumberSuffix\": \"12345\",\n"
                + "    \"sentAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"trackingNumber\": \"12345\",\n"
                + "    \"updatedAtTime\": \"2019-06-13T19:08:25Z\",\n"
                + "    \"vendor\": {\n"
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
