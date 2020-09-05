package com.epam.test.ht12.services;

import com.epam.test.ht12.models.requests.createuser.UserModel;
import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UserService {
    private static String URL;
    private static final String CONTROLLER = "user/";

    public UserService(String baseUrl){
        URL = baseUrl + CONTROLLER;
    }

    public ConfirmationModel createUser(UserModel createUserRequest) {
        return RestAssured.given().header("Content-Type", ContentType.JSON).body(createUserRequest).log().all()
                .when().post(URL)
                .then().log().all().statusCode(200).extract().as(ConfirmationModel.class);
    }

    public ConfirmationModel deleteUserByUsername(String username) {
        return RestAssured.given().header("Content-Type", ContentType.JSON).log().all()
                .when().delete(URL + username)
                .then().log().all().statusCode(200).extract().as(ConfirmationModel.class);
    }

    public UserModel getUserByUsername(String username) {
        return RestAssured.given().header("Content-Type", ContentType.JSON).log().all()
                .when().get(URL + username)
                .then().log().all().statusCode(200).extract().as(UserModel.class);
    }

    public ConfirmationModel updateUser(String username, UserModel userUpdateRequest) {
        return RestAssured.given().header("Content-Type", ContentType.JSON).body(userUpdateRequest).log().all()
                .when().put(URL + username)
                .then().log().all().statusCode(200).extract().as(ConfirmationModel.class);
    }

    public ConfirmationModel login(String username, String password) {
        return RestAssured.given().header("Content-Type", ContentType.JSON).log().all()
                .queryParam("username", username)
                .queryParam("password", password)
                .when().get(URL + "login/")
                .then().log().all().statusCode(200).extract().as(ConfirmationModel.class);
    }

    public ConfirmationModel logout() {
        return RestAssured.given().header("Content-Type", ContentType.JSON).log().all()
                .when().get(URL + "logout/")
                .then().log().all().statusCode(200).extract().as(ConfirmationModel.class);
    }
}
