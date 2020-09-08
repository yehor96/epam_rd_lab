package com.epam.test.ht13.dbhelpers;

import com.epam.test.ht13.dao.ClientDao;
import com.epam.test.ht13.dbmodels.Client;

import java.util.List;
import java.util.Optional;

import static com.epam.test.ht8.task1.InputOutputHelper.print;

public class ClientService {
    public ClientService(){
        clientDao = new ClientDao();
    }

    private static ClientDao clientDao;

    public void getInfoAboutClient(int id){
        Optional<Client> client = clientDao.get(id);

        if(client.isPresent()){
            System.out.printf("Client with id %d is %s %s\n",
                    client.get().getId(), client.get().getName(), client.get().getSurname());
        }
        else{
            print("There is no client with id " + id + "\n");
        }
        print("\n");
    }

    public void getInfoAboutAllClients(){
        List<Client> clients =  clientDao.getAll();

        if(clients.isEmpty()){
            print("There are no clients.\n");
        }

        for(var each : clients){
            System.out.printf("Client with id %d . Client's name: %s %s Client's email: %s\n",
                    each.getId(), each.getName(), each.getSurname(), each.getEmail());
        }
    }

    public void createClient(String name, String surname, String email) {
        Client client = new Client();

        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);

        clientDao.save(client);
    }

    public void updateClient(int id, String name, String surname, String email) {
        Client client = new Client();
        client.setId(id);

        String[] args = new String[3];
        args[0] = name;
        args[1] = surname;
        args[2] = email;

        clientDao.update(client, args);
    }

    public void deleteClient(int id) {
        Client client = new Client();
        client.setId(id);

        clientDao.delete(client);
    }
}
