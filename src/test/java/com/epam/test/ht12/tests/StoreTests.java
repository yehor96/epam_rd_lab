package com.epam.test.ht12.tests;

import com.epam.test.ht12.models.requests.createorder.OrderModel;
import com.epam.test.ht12.models.requests.createpet.CreatePetRequest;
import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import com.epam.test.ht12.models.responses.getinventory.GetInventoryResponse;
import com.epam.test.ht12.services.StoreService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreTests {
    private StoreService storeService = new StoreService();

    @Test
    void testCreateOrder() throws IOException {
        //GIVEN
        int petId = 10001;
        String petName = "yeh_test_01";
        String status = "placed";

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(petId);
        createPetRequest.setName(petName);

        OrderModel createOrderRequest = new OrderModel();
        createOrderRequest.setStatus(status);
        createOrderRequest.setPetId(createPetRequest.getId());

        //WHEN
        OrderModel createOrderResponse = storeService.createOrder(createOrderRequest);

        //THEN
        assertThat(createOrderResponse.getPetId()).isEqualTo(petId);
        assertThat(createOrderResponse.getStatus()).isEqualTo(status);

        storeService.deleteOrderById(createOrderResponse.getId());
    }

    @Test
    void testGetOrderById() throws IOException {
        //GIVEN
        int petId = 10001;
        int orderId = 5;
        String petName = "yeh_test_01";
        String status = "placed";

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(petId);
        createPetRequest.setName(petName);

        OrderModel createOrderRequest = new OrderModel();
        createOrderRequest.setStatus(status);
        createOrderRequest.setPetId(createPetRequest.getId());
        createOrderRequest.setId(orderId);
        storeService.createOrder(createOrderRequest);

        //WHEN
        OrderModel getOrderByIdResponse = storeService.getOrderById(orderId);

        //THEN
        assertThat(getOrderByIdResponse.getPetId()).isEqualTo(petId);
        assertThat(getOrderByIdResponse.getStatus()).isEqualTo(status);
        assertThat(getOrderByIdResponse.getId()).isEqualTo(createOrderRequest.getId());

        storeService.deleteOrderById(createOrderRequest.getId());
    }

    @Test
    void testDeleteOrderById() throws IOException {
        //GIVEN
        int petId = 10001;
        int orderId = 5;
        String petName = "yeh_test_01";
        String status = "placed";

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(petId);
        createPetRequest.setName(petName);

        OrderModel createOrderRequest = new OrderModel();
        createOrderRequest.setStatus(status);
        createOrderRequest.setPetId(createPetRequest.getId());
        createOrderRequest.setId(orderId);
        storeService.createOrder(createOrderRequest);

        //WHEN
        ConfirmationModel deleteOrderByIdResponse = storeService.deleteOrderById(createOrderRequest.getId());

        //THEN
        assertThat(deleteOrderByIdResponse.getCode()).isEqualTo(200);
    }

    /**
     * This test fails once someone adds new 'status'.
     * Once it happens, it is necessary to update response model.
     */
    @Test
    void testGetInventory() throws IOException {
        //GIVEN
        int petId = 10001;
        int orderId = 5;
        String petName = "yeh_test_01";
        String status = "available";

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(petId);
        createPetRequest.setName(petName);
        createPetRequest.setStatus(status);

        OrderModel createOrderRequest = new OrderModel();
        createOrderRequest.setStatus(status);
        createOrderRequest.setPetId(createPetRequest.getId());
        createOrderRequest.setId(orderId);
        storeService.createOrder(createOrderRequest);

        //WHEN
        GetInventoryResponse getInventoryResponse = storeService.getInventory();

        //THEN
        assertThat(getInventoryResponse.getAvailable()).isGreaterThan(0);
    }
}
