package com.epam.test.ht13.dbhelpers;

import com.epam.test.ht13.dao.AccountDao;
import com.epam.test.ht13.dbmodels.Account;

import java.util.List;
import java.util.Optional;

import static com.epam.test.ht8.task1.InputOutputHelper.print;

public class AccountService {
    public AccountService(){
        accountDao = new AccountDao();
    }

    private static AccountDao accountDao;

    public void getInfoAboutAccount(int id ){
        Optional<Account> account = accountDao.get(id);

        if(account.isPresent()){
            System.out.printf("Sum on account with id %d is %d\nCurrency of this account is %s",
                    account.get().getId(), account.get().getSum(), account.get().getCurrency());
        }
        else{
            print("There is no account with id " + id + "\n");
        }
        print("\n");
    }

    public void getInfoAboutAllAccounts(){
        List<Account> accounts =  accountDao.getAll();

        if(accounts.isEmpty()){
            print("There are no accounts.\n");
        }

        for(var each : accounts){
            System.out.printf("Sum on account with id %d is %d\n" +
                            "Currency of this account is %s\n" +
                            "Client id of this account is %d\n",
                    each.getId(), each.getSum(), each.getCurrency(), each.getClientId());
        }
    }

    public void createAccount(String currency, int sum, int clientId){
        Account account = new Account();

        account.setCurrency(currency);
        account.setSum(sum);
        account.setClientId(clientId);

        accountDao.save(account);
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

        accountDao.update(account, args);
    }
}
