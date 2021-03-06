package com.epam.test.ht12.services;

import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public abstract class BaseService<T> {
    protected static final String BASE_URL = "https://petstore.swagger.io/v2/";

    static final OkHttpClient client = new OkHttpClient();
    static final ObjectMapper objectMapper = new ObjectMapper();

    /** Attempt to use OkHttp with POST/PUT */
    static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    protected T doGet(String path, Class<T> tClass) throws IOException {
        Request request = new Request.Builder()
                .url(path)
                .build();

        return objectMapper.readValue(client.newCall(request)
                .execute()
                .body()
                .string(), tClass);

//        return RestAssured.given(requestSpecification())
//                .when().get(path)
//                .then()
//                .log().all()
//                .statusCode(200)
//                .extract().as(tClass);
    }

    protected <K> T doPost(K body, String path, Class<T> tClass) throws IOException {
        /** Attempt to use OkHttp with POST
        RequestBody formBody = RequestBody.create(JSON, body.toString());

        Request request = new Request.Builder()
                .url(path)
                .post(formBody)
                .build();

        return objectMapper.readValue(client.newCall(request)
                .execute()
                .body()
                .string(), tClass);
         */

        return RestAssured.given(requestSpecification())
                .body(body)
                .when().post(path)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(tClass);
    }

    protected <K> T doPut (K body, String path, Class<T> tClass) throws IOException {
        /** Attempt to use OkHttp with PUT
        RequestBody formBody = RequestBody.create(JSON, body.toString());

        Request request = new Request.Builder()
                .url(path)
                .put(formBody)
                .build();

        return objectMapper.readValue(client.newCall(request)
                .execute()
                .body()
                .string(), tClass);
         */

        return RestAssured.given(requestSpecification())
                .body(body)
                .when().put(path)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(tClass);
    }

    protected ConfirmationModel doDelete(String path) throws IOException {
        Request request = new Request.Builder()
                .url(path)
                .delete()
                .build();

        return objectMapper.readValue(client.newCall(request)
                .execute()
                .body()
                .string(), ConfirmationModel.class);

//        return RestAssured.given(requestSpecification())
//                .when().delete(path)
//                .then()
//                .log().all()
//                .statusCode(200).extract()
//                .as(ConfirmationModel.class);
    }

    protected RequestSpecification requestSpecification(){
        return RestAssured.given()
                .header("Content-Type", ContentType.JSON)
                .header("api_key", "special-key")
                .log().all();
    }
}