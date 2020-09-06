package com.epam.test.ht13;

public class Main {
    public static void main(String args[]){
        /**
         * SetUp
         */
        DatabaseHelper helper = new DatabaseHelper();
        int idGet = 1;
        int idCreateClient = 3;
        int idCreatedAccount = 4;

        /**
         * Accounts
         */
        helper.getInfoAboutAccount(idGet);

        helper.getInfoAboutAllAccounts();

        helper.createAccount("USD", 250, 2);

        helper.updateAccount(idCreatedAccount, "EUR", 99, 1);

        helper.deleteAccount(idCreatedAccount);

        /**
        * Accounts
        */
        helper.getInfoAboutClient(idGet);

        helper.getInfoAboutAllClients();

        helper.createClient("Martin", "Kirks", "kirkson00@email.com");

        helper.updateClient(idCreateClient, "Martin", "Kirkson", "kirkson@email.com");

        helper.deleteClient(idCreateClient);
    }
}
