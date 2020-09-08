package com.epam.test.ht12.services;

import com.epam.test.ht12.models.requests.createorder.OrderModel;
import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import com.epam.test.ht12.models.responses.getinventory.GetInventoryResponse;

public class StoreService extends BaseService {
    private static final String PATH = "store/";

    private static String URL = BASE_URL + PATH;

    public OrderModel createOrder(OrderModel createOrderRequest) {
        return (OrderModel) doPost(createOrderRequest, URL + "order/", OrderModel.class);
    }

    public OrderModel getOrderById(int id) {
        return (OrderModel) doGet(URL + "order/" + id, OrderModel.class);
    }

    public ConfirmationModel deleteOrderById(long id) {
        return doDelete(URL + "order/" + id);
    }

    public GetInventoryResponse getInventory() {
        return (GetInventoryResponse) doGet(URL + "inventory/", GetInventoryResponse.class);
    }
}
