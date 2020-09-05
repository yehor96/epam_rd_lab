package com.epam.test.ht12.tests;

import com.epam.test.ht12.models.requests.createuser.UserModel;
import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import com.epam.test.ht12.services.UserService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";

    private UserService userService = new UserService(BASE_URL);

    @Test
    void testCreateUser(){
        //GIVEN
        String username = "user_test";
        String email = "test@test.com";
        String password = "pass";

        UserModel createUserRequest = new UserModel();
        createUserRequest.setUsername(username);
        createUserRequest.setEmail(email);
        createUserRequest.setPassword(password);

        //WHEN
        ConfirmationModel createUserResponse = userService.createUser(createUserRequest);

        //THEN
        assertThat(createUserResponse.getCode()).isEqualTo(200);
        userService.deleteUserByUsername(createUserRequest.getUsername());
    }

    @Test
    void testDeleteUserByUsername(){
        //GIVEN
        String username = "user_test";
        String email = "test@test.com";
        String password = "pass";

        UserModel createUserRequest = new UserModel();
        createUserRequest.setUsername(username);
        createUserRequest.setEmail(email);
        createUserRequest.setPassword(password);
        userService.createUser(createUserRequest);

        //WHEN
        ConfirmationModel deleteUserByUsernameResponse = userService.deleteUserByUsername(createUserRequest.getUsername());

        //THEN
        assertThat(deleteUserByUsernameResponse.getCode()).isEqualTo(200);
    }

    @Test
    void testGetUserByUsername(){
        //GIVEN
        String username = "user_test";
        String email = "test@test.com";
        String password = "pass";

        UserModel createUserRequest = new UserModel();
        createUserRequest.setUsername(username);
        createUserRequest.setEmail(email);
        createUserRequest.setPassword(password);
        userService.createUser(createUserRequest);

        //WHEN
        UserModel getUserByUsernameResponse = userService.getUserByUsername(createUserRequest.getUsername());

        //THEN
        assertThat(getUserByUsernameResponse.getUsername()).isEqualTo(createUserRequest.getUsername());
        assertThat(getUserByUsernameResponse.getEmail()).isEqualTo(createUserRequest.getEmail());
        assertThat(getUserByUsernameResponse.getPassword()).isEqualTo(createUserRequest.getPassword());
    }

    @Test
    void testUpdateUser(){
        //GIVEN
        String usernameBeforeUpdate = "user_test";
        String emailBeforeUpdate = "test@test.com";
        String passwordBeforeUpdate = "pass";
        String usernameAfterUpdate = "new_user_test";
        String emailAfterUpdate = "new_test@test.com";
        String passwordAfterUpdate = "new_pass";

        UserModel createUserRequest = new UserModel();
        createUserRequest.setUsername(usernameBeforeUpdate);
        createUserRequest.setEmail(emailBeforeUpdate);
        createUserRequest.setPassword(passwordBeforeUpdate);
        userService.createUser(createUserRequest);

        UserModel userUpdateRequest = new UserModel();
        userUpdateRequest.setPassword(passwordAfterUpdate);
        userUpdateRequest.setEmail(emailAfterUpdate);
        userUpdateRequest.setUsername(usernameAfterUpdate);

        //WHEN
        ConfirmationModel updateUserResponse =
                userService.updateUser(createUserRequest.getUsername(), userUpdateRequest);

        //THEN
        assertThat(updateUserResponse.getCode()).isEqualTo(200);

        UserModel getUserByUsernameResponse = userService.getUserByUsername(userUpdateRequest.getUsername());
        assertThat(getUserByUsernameResponse.getEmail()).isEqualTo(userUpdateRequest.getEmail());
        assertThat(getUserByUsernameResponse.getPassword()).isEqualTo(userUpdateRequest.getPassword());
    }

    @Test
    void testLogin(){
        //GIVEN
        String username = "yehUser";
        String password = "pass";

        UserModel createUserRequest = new UserModel();
        createUserRequest.setUsername(username);
        createUserRequest.setPassword(password);
        userService.createUser(createUserRequest);

        //WHEN
        ConfirmationModel loginResponse = userService.login(username, password);

        //THEN
        assertThat(loginResponse.getCode()).isEqualTo(200);
        assertThat(loginResponse.getMessage()).contains("logged in user");
    }

    @Test
    void testLogout(){
        //WHEN
        ConfirmationModel logoutResponse = userService.logout();

        //THEN
        assertThat(logoutResponse.getCode()).isEqualTo(200);
        assertThat(logoutResponse.getMessage()).isEqualTo("ok");
    }
}
