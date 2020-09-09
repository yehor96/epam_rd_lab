package com.epam.test.ht12.services;

import com.epam.test.ht12.models.requests.createuser.UserModel;
import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import io.restassured.RestAssured;

import java.util.ArrayList;

public class UserService extends BaseService {
    private static final String PATH = "user/";

    private static String URL = BASE_URL + PATH;

    public ConfirmationModel createUser(UserModel createUserRequest) {
        return (ConfirmationModel) doPost(createUserRequest, URL, ConfirmationModel.class);
    }

    public ConfirmationModel deleteUserByUsername(String username)  {
        return doDelete(URL + username);
    }

    public UserModel getUserByUsername(String username) {
        return (UserModel) doGet(URL + username, UserModel.class);
    }

    public ConfirmationModel updateUser(String username, UserModel userUpdateRequest) {
        return RestAssured.given(requestSpecification())
                .body(userUpdateRequest)
                .when().put(URL + username)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ConfirmationModel.class);
    }

    public ConfirmationModel login(String username, String password) {
        return RestAssured.given(requestSpecification())
                .queryParam("username", username)
                .queryParam("password", password)
                .when().get(URL + "login/")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ConfirmationModel.class);
    }

    public ConfirmationModel logout() {
        return (ConfirmationModel) doGet(URL + "logout/", ConfirmationModel.class);
    }

    public ConfirmationModel createUserWithArray(UserModel[] createUserRequest) {
        return (ConfirmationModel) doPost
                (createUserRequest, URL + "createWithArray", ConfirmationModel.class);
    }

    public ConfirmationModel createUserWithList(ArrayList<UserModel> createUserWithListRequest) {
        return (ConfirmationModel) doPost
                (createUserWithListRequest, URL + "createWithList", ConfirmationModel.class);
    }
}
