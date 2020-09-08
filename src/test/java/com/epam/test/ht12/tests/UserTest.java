package com.epam.test.ht12.tests;

import com.epam.test.ht12.models.requests.createuser.UserModel;
import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import com.epam.test.ht12.services.UserService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    private final UserService userService = new UserService();

    @Test
    void testCreateUser() {
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
    void testDeleteUserByUsername() {
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

    @Test
    void testCreateUserWithArray() {
        //GIVEN
        String username = "user_test";
        String email = "test@test.com";
        String password = "pass";
        String username2 = "user_test2";
        String email2 = "test@test.com2";
        String password2 = "pass2";


        UserModel[] createUserWithArrayRequest = new UserModel[2];

        createUserWithArrayRequest[0] = new UserModel();
        createUserWithArrayRequest[0].setUsername(username);
        createUserWithArrayRequest[0].setEmail(email);
        createUserWithArrayRequest[0].setPassword(password);

        createUserWithArrayRequest[1] = new UserModel();
        createUserWithArrayRequest[1].setUsername(username2);
        createUserWithArrayRequest[1].setEmail(email2);
        createUserWithArrayRequest[1].setPassword(password2);

        //WHEN
        ConfirmationModel createUserWithArrayResponse = userService.createUserWithArray(createUserWithArrayRequest);

        //THEN
        assertThat(createUserWithArrayResponse.getCode()).isEqualTo(200);

        for(var each : createUserWithArrayRequest){
            userService.deleteUserByUsername(each.getUsername());
        }
    }

    @Test
    void testCreateUserWithList() {
        //GIVEN
        String username = "user_test";
        String email = "test@test.com";
        String password = "pass";
        String username2 = "user_test2";
        String email2 = "test@test.com2";
        String password2 = "pass2";


        ArrayList<UserModel> createUserWithListRequest = new ArrayList<>();

        UserModel user = new UserModel();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        createUserWithListRequest.add(user);

        UserModel user2 = new UserModel();
        user2.setUsername(username2);
        user2.setEmail(email2);
        user2.setPassword(password2);
        createUserWithListRequest.add(user2);

        //WHEN
        ConfirmationModel createUserWithListResponse = userService.createUserWithList(createUserWithListRequest);

        //THEN
        assertThat(createUserWithListResponse.getCode()).isEqualTo(200);

        for(var each : createUserWithListRequest){
            userService.deleteUserByUsername(each.getUsername());
        }
    }
}
