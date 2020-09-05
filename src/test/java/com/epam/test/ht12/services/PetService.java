package com.epam.test.ht12.services;

import com.epam.test.ht12.models.requests.createpet.CreatePetRequest;
import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import com.epam.test.ht12.models.responses.createpet.PetModel;
import com.epam.test.ht12.models.responses.getpetbyid.GetPetByIdResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.io.IOException;

public class PetService {
    private static String URL;
    private static final String CONTROLLER = "pet/";

    public PetService(String baseUrl){
        URL = baseUrl + CONTROLLER;
    }

    public GetPetByIdResponse getPetById(int id){
        return RestAssured.given().header("Content-Type", ContentType.JSON).log().all()
                .when().get(URL + id)
                .then().log().all().statusCode(200).extract().as(GetPetByIdResponse.class);
    }

    public PetModel createPet(CreatePetRequest createPetRequest){
        return RestAssured.given().header("Content-Type", ContentType.JSON).body(createPetRequest).log().all()
                .when().post(URL)
                .then().log().all().statusCode(200).extract().as(PetModel.class);
    }

    public PetModel updatePet(CreatePetRequest createPetRequest){
        return RestAssured.given().header("Content-Type", ContentType.JSON).body(createPetRequest).log().all()
                .when().put(URL)
                .then().log().all().statusCode(200).extract().as(PetModel.class);
    }

    public ConfirmationModel deletePetById(int id){
        return RestAssured.given().header("Content-Type", ContentType.JSON).header("api_key", "special-key")
                .log().all()
                .when().delete(URL + id)
                .then().log().all().statusCode(200).extract().as(ConfirmationModel.class);
    }

    public ConfirmationModel updatePetWithFormData(int id, String nameAfterUpd, String statusAfterUpd) {
        return RestAssured.given()
                .header("Content-Type", ContentType.JSON)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("name", nameAfterUpd)
                .formParam("status", statusAfterUpd)
                .log().all()
                .when().post(URL + id)
                .then().log().all().statusCode(200).extract().as(ConfirmationModel.class);
    }

    public GetPetByIdResponse[] getPetsByStatus(String status) throws IOException {
        String jsonResponse = RestAssured.given()
                .header("Content-Type", ContentType.JSON)
                .queryParam("status", status)
                .log().all()
                .when().get(URL + "findByStatus")
                .then().log().all().statusCode(200).extract().toString();

        return new ObjectMapper().readValue(jsonResponse, GetPetByIdResponse[].class);
    }
}
