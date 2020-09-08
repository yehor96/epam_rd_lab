package com.epam.test.ht13;

import com.epam.test.ht13.dbhelpers.AccountService;
import com.epam.test.ht13.dbhelpers.ClientService;
import com.epam.test.ht13.dbhelpers.DatabaseHelper;

public class Main {
    public static void main(String args[]){
        DatabaseHelper.databaseSetUp();
        AccountService accountService = new AccountService();
        ClientService clientService = new ClientService();
        int idGet = 1;
        int idCreateClient = 3;
        int idCreatedAccount = 4;

        accountService.getInfoAboutAccount(idGet);

        accountService.getInfoAboutAllAccounts();

        accountService.createAccount("USD", 250, 2);

        accountService.updateAccount(idCreatedAccount, "EUR", 99, 1);

        accountService.deleteAccount(idCreatedAccount);


        clientService.getInfoAboutClient(idGet);

        clientService.getInfoAboutAllClients();

        clientService.createClient("Martin", "Kirks", "kirkson00@email.com");

        clientService.updateClient(idCreateClient, "Martin", "Kirkson", "kirkson@email.com");

        clientService.deleteClient(idCreateClient);
    }
}
