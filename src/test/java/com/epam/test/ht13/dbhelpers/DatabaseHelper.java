package com.epam.test.ht13.dbhelpers;

import static com.epam.test.ht8.task1.InputOutputHelper.print;

public class DatabaseHelper {
        public static void databaseSetUp() {
            print("Starting setup...\n");

            ClientService clientService = new ClientService();
            clientService.createClient("John", "Johnson", "johnson@gmail.com");
            clientService.createClient("Sarah", "Bohn", "sbohn@gmail.com");

            AccountService accountService = new AccountService();
            accountService.createAccount("USD", 100, 1);
            accountService.createAccount("EUR", 0, 1);
            accountService.createAccount("USD", 500, 2);

            print("Setup has ended.\n==========\n");
        }
}
