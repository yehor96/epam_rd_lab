package com.epam.test.ht12.tests;

import com.epam.test.ht12.models.requests.createorder.OrderModel;
import com.epam.test.ht12.models.requests.createpet.CreatePetRequest;
import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import com.epam.test.ht12.models.responses.getinventory.GetInventoryResponse;
import com.epam.test.ht12.services.StoreService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreTests {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";

    private StoreService storeService = new StoreService(BASE_URL);

    @Test
    void testCreateOrder(){
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
    void testGetOrderById(){
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
    void testDeleteOrderById(){
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

    @Test
    void testGetInventory(){
        //GIVEN
        int petId = 10001;
        int orderId = 5;
        String petName = "yeh_test_01";
        String status = "sold";

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(petId);
        createPetRequest.setName(petName);
        createPetRequest.setStatus("complete");

        OrderModel createOrderRequest = new OrderModel();
        createOrderRequest.setStatus(status);
        createOrderRequest.setPetId(createPetRequest.getId());
        createOrderRequest.setId(orderId);
        storeService.createOrder(createOrderRequest);

        //WHEN
        GetInventoryResponse getInventoryResponse = storeService.getInventory();

        //THEN
        assertThat(getInventoryResponse.getSold()).isGreaterThan(0);
    }
}
