package com.epam.test.ht12.services;

import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseService<T> {
    protected static final String BASE_URL = "https://petstore.swagger.io/v2/";

    protected T doGet(String path, Class<T> tClass){
        return RestAssured.given(requestSpecification())
                .when().get(path)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(tClass);
    }

    protected <K> T doPost(K body, String path, Class<T> tClass){
        return RestAssured.given(requestSpecification())
                .body(body)
                .when().post(path)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(tClass);
    }

    protected <K> T doPut (K body, String path, Class<T> tClass){
        return RestAssured.given(requestSpecification())
                .body(body)
                .when().put(path)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(tClass);
    }

    protected ConfirmationModel doDelete(String path){
        return RestAssured.given(requestSpecification())
                .when().delete(path)
                .then()
                .log().all()
                .statusCode(200).extract()
                .as(ConfirmationModel.class);
    }

    protected RequestSpecification requestSpecification(){
        return RestAssured.given()
                .header("Content-Type", ContentType.JSON)
                .header("api_key", "special-key")
                .log().all();
    }
}