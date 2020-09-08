package com.epam.test.ht12.services;

import com.epam.test.ht12.models.requests.createpet.CreatePetRequest;
import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import com.epam.test.ht12.models.responses.createpet.PetModel;
import com.epam.test.ht12.models.responses.getpetbyid.GetPetByIdResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

public class PetService extends BaseService {
    private static final String PATH = "pet/";

    private static String URL = BASE_URL + PATH;

    public ConfirmationModel uploadImageToPet(String path, String format, int id){
        return RestAssured.given()
                .header("Content-Type", ContentType.JSON)
                .header("Content-Type", "multipart/form-data")
                .multiPart("file", new File(path), format)
                .log().all()
                .when().post(URL + id + "/uploadImage")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ConfirmationModel.class);
    }

    public GetPetByIdResponse getPetById(int id){
        return (GetPetByIdResponse) doGet(URL + id, GetPetByIdResponse.class);
    }

    public PetModel createPet(CreatePetRequest createPetRequest){
        return (PetModel) doPost(createPetRequest, URL, PetModel.class);
    }

    public PetModel updatePet(CreatePetRequest createPetRequest){
        return (PetModel) doPut(createPetRequest, URL, PetModel.class);
    }

    public ConfirmationModel deletePetById(int id) {
        return doDelete(URL + id);
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

    public GetPetByIdResponse[] getPetsByStatus(String status) {
        Response response = RestAssured.given()
                .header("Content-Type", ContentType.JSON)
                .queryParam("status", status)
                .log().all()
                .when().get(URL + "findByStatus")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        return response.as(GetPetByIdResponse[].class);
    }
}
