package com.epam.test.ht12.tests;

import com.epam.test.ht12.models.requests.createpet.CreatePetRequest;
import com.epam.test.ht12.models.responses.createpet.PetModel;
import com.epam.test.ht12.models.responses.commonconfirmation.ConfirmationModel;
import com.epam.test.ht12.models.responses.getpetbyid.GetPetByIdResponse;
import com.epam.test.ht12.services.PetService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class PetTests {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";

    private PetService petService = new PetService(BASE_URL);

    @Test
    void testGetPetById(){
        //GIVEN
        String name = "yeh_test_01";
        int id = 10001;

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(id);
        createPetRequest.setName(name);
        petService.createPet(createPetRequest);

        //WHEN
        GetPetByIdResponse getPetByIdResponse = petService.getPetById(id);

        //THEN
        assertThat(getPetByIdResponse.getId()).isEqualTo(id);
        assertThat(getPetByIdResponse.getName()).isEqualTo(name);

        petService.deletePetById(id);
    }

    @Test
    void testUpdatePet(){
        //GIVEN
        int id = 10004;
        String nameBeforeUpd = "yeh_test_04";
        String nameAfterUpd = "yeh_test_04_upd";

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(id);
        createPetRequest.setName(nameBeforeUpd);
        petService.createPet(createPetRequest);

        //WHEN
        createPetRequest.setName(nameAfterUpd);
        PetModel updatePetResponse = petService.updatePet(createPetRequest);

        //THEN
        assertThat(updatePetResponse.getId()).isEqualTo(id);
        assertThat(updatePetResponse.getName()).isEqualTo(nameAfterUpd);

        petService.deletePetById(id);
    }

    @Test
    void testCreatePet(){
        //GIVEN
        String name = "yeh_test_02";
        int id = 10002;

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(id);
        createPetRequest.setName(name);

        //WHEN
        PetModel petModel = petService.createPet(createPetRequest);

        //THEN
        assertThat(petModel.getId()).isEqualTo(id);
        assertThat(petModel.getName()).isEqualTo(name);

        petService.deletePetById(id);
    }

    @Test
    void testDeletePetById(){
        //GIVEN
        String name = "yeh_test_03";
        int id = 10003;

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(id);
        createPetRequest.setName(name);
        petService.createPet(createPetRequest);

        //WHEN
        ConfirmationModel deletePetByIdResponse = petService.deletePetById(id);

        //THEN
        assertThat(deletePetByIdResponse.getCode()).isEqualTo(200);
    }

    @Test
    void testUpdatePetWithFormData(){
        //GIVEN
        int id = 10004;
        String nameBeforeUpd = "yeh_test_04";
        String nameAfterUpd = "yeh_test_04_upd";
        String statusBeforeUpd = "testBeforeUpdate";
        String statusAfterUpd = "testAfterUpdate";

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(id);
        createPetRequest.setName(nameBeforeUpd);
        createPetRequest.setStatus(statusBeforeUpd);
        petService.createPet(createPetRequest);

        //WHEN
        ConfirmationModel updatePetWithFormDataResponse =
                petService.updatePetWithFormData(id, nameAfterUpd, statusAfterUpd);

        GetPetByIdResponse getPetByIdResponse = petService.getPetById(id);

        //THEN
        assertThat(updatePetWithFormDataResponse.getCode()).isEqualTo(200);
        assertThat(getPetByIdResponse.getName()).isEqualTo(nameAfterUpd);
        assertThat(getPetByIdResponse.getStatus()).isEqualTo(statusAfterUpd);

        petService.deletePetById(id);
    }

    /**
     * This test does not work
     * Because I was not able to figure out how to map array of objects in json
     * on array of GetPetByIdResponse objects
     */
    @Test
    void testGetPetByStatus() throws IOException {
        //GIVEN
        String name = "yeh_test_01";
        int id = 10001;
        String status = "sold";

        CreatePetRequest createPetRequest = new CreatePetRequest();
        createPetRequest.setId(id);
        createPetRequest.setName(name);
        createPetRequest.setStatus(status);
        petService.createPet(createPetRequest);

        //WHEN
        GetPetByIdResponse getPetsByStatusResponse = null;
        GetPetByIdResponse[] responses = petService.getPetsByStatus(status);
        for(var each : responses){
            if(each.getId() == id){
                getPetsByStatusResponse = each;
                break;
            }
        }

        //THEN
        assertThat(getPetsByStatusResponse.getName()).isEqualTo(name);
        assertThat(getPetsByStatusResponse.getStatus()).isEqualTo(status);

        petService.deletePetById(id);
    }
}
