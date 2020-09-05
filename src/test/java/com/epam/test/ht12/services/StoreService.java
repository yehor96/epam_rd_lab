package com.epam.test.ht12.services;

import com.epam.test.ht12.models.requests.createorder.OrderModel;
import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import com.epam.test.ht12.models.responses.getinventory.GetInventoryResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class StoreService {
    private static String URL;
    private static final String CONTROLLER = "store/";

    public StoreService(String baseUrl){
        URL = baseUrl + CONTROLLER;
    }

    public OrderModel createOrder(OrderModel createOrderRequest) {
        return RestAssured.given().header("Content-Type", ContentType.JSON).body(createOrderRequest).log().all()
                .when().post(URL + "order/")
                .then().log().all().statusCode(200).extract().as(OrderModel.class);
    }

    public OrderModel getOrderById(int id) {
        return RestAssured.given().header("Content-Type", ContentType.JSON).log().all()
                .when().get(URL + "order/" + id)
                .then().log().all().statusCode(200).extract().as(OrderModel.class);
    }

    public ConfirmationModel deleteOrderById(int id) {
        return RestAssured.given().header("Content-Type", ContentType.JSON).log().all()
                .when().delete(URL + "order/" + id)
                .then().log().all().statusCode(200).extract().as(ConfirmationModel.class);
    }

    public GetInventoryResponse getInventory() {
        return RestAssured.given().header("Content-Type", ContentType.JSON).log().all()
                .when().get(URL + "inventory/")
                .then().log().all().statusCode(200).extract().as(GetInventoryResponse.class);
    }
}
