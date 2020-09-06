package com.epam.test.ht13;

import com.epam.test.ht13.dao.AccountDao;
import com.epam.test.ht13.dao.ClientDao;
import com.epam.test.ht13.dbmodels.Account;
import com.epam.test.ht13.dbmodels.Client;

import java.util.List;
import java.util.Optional;

public class DatabaseHelper {
    /**
     * Initial Database SetUp
     */
    public DatabaseHelper(){

        System.out.println("Starting setup...");
        createClient("John", "Johnson", "johnson@gmail.com");
        createClient("Sarah", "Bohn", "sbohn@gmail.com");

        createAccount("USD", 100, 1);
        createAccount("EUR", 0, 1);
        createAccount("USD", 500, 2);

        System.out.println("Setup has ended.\n==========");
    }

    /**
     *Clients
     */
    public void getInfoAboutClient(int id){
        Optional<Client> client = new ClientDao().get(id);

        if(client != null){
            System.out.println("Client with id " + client.get().getId() + " is "
                    + client.get().getName() + " " + client.get().getSurname());
            System.out.println("Client's email is " + client.get().getEmail());
        }
        else{
            System.out.println("There is no client with id " + id);
        }
        System.out.println();
    }

    public void getInfoAboutAllClients(){
        List<Client> clients =  new ClientDao().getAll();

        if(clients.isEmpty()){
            System.out.println("There are no clients.");
        }

        for(var each : clients){
            System.out.println("Client with id " + each.getId() + "." +
                    " Client's name: " + each.getName() + " " + each.getSurname() +
                    " Client's email: " + each.getEmail());
        }
    }

    public void createClient(String name, String surname, String email) {
        Client client = new Client();

        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);

        new ClientDao().save(client);
    }

    public void updateClient(int id, String name, String surname, String email) {
        Client client = new Client();
        client.setId(id);

        String[] args = new String[3];
        args[0] = name;
        args[1] = surname;
        args[2] = email;

        new ClientDao().update(client, args);
    }

    public void deleteClient(int id) {
        Client client = new Client();
        client.setId(id);

        new ClientDao().delete(client);
    }

    /**
     *Accounts
     */
    public void getInfoAboutAccount(int id ){
        Optional<Account> account = new AccountDao().get(id);

        if(account != null){
            System.out.println("Sum on account with id "
                    + account.get().getId() + " is " + account.get().getSum());
            System.out.println("Currency of this account is " + account.get().getCurrency());
        }
        else{
            System.out.println("There is no account with id " + id);
        }
        System.out.println();
    }

    public void getInfoAboutAllAccounts(){
        List<Account> accounts =  new AccountDao().getAll();

        if(accounts.isEmpty()){
            System.out.println("There are no accounts.");
        }

        for(var each : accounts){
            System.out.println("Sum on account with id "
                    + each.getId() + " is " + each.getSum());
            System.out.println("Currency of this account is " + each.getCurrency());
            System.out.println("Client id of this account is " + each.getClientId());
            System.out.println();
        }
    }

    public void createAccount(String currency, int sum, int clientId){
        Account account = new Account();

        account.setCurrency(currency);
        account.setSum(sum);
        account.setClientId(clientId);

        new AccountDao().save(account);
    }

    public void deleteAccount(int id){
        Account account = new Account();
        account.setId(id);

        new AccountDao().delete(account);
    }

    public void updateAccount(int id, String currency, int sum, int clientId) {
        Account account = new Account();
        account.setId(id);

        String[] args = new String[3];
        args[0] = currency;
        args[1] = String.valueOf(sum);
        args[2] = String.valueOf(clientId);

        new AccountDao().update(account, args);
    }
}
