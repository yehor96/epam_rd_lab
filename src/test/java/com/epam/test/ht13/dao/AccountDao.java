package com.epam.test.ht13.dao;

import com.epam.test.ht13.dbmodels.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.epam.test.ht13.ConnectorDb.getConnection;

public class AccountDao implements Dao<Account> {
    @Override
    public Optional<Account> get(long id) {
        Connection connection = getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM account WHERE id=" + id);
            if (rs.next()) {
                return Optional.of(extractAccount(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Account> getAll() {
        Connection connection = getConnection();
        List<Account> accounts = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM account");
            while (rs.next()) {
                accounts.add(extractAccount(rs));
            }
            return accounts;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(Account account) {
        Connection connection = getConnection();
        int accId = getRowCount() + 1;

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO account VALUES (?, ?, ?, ?)");
            ps.setInt(1, accId);
            ps.setString(2, account.getCurrency());
            ps.setInt(3, account.getSum());
            ps.setInt(4, account.getClientId());
            int i = ps.executeUpdate();
            if (i != 1) {
                System.out.println("Account with id " + accId + " is not created.");
            } else {
                System.out.println("Account with id " + accId + " is created.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Account account, String[] params) {
        Connection connection = getConnection();

        account.setCurrency(Objects.requireNonNull(
                params[0], "Sum cannot be null"));

        account.setSum(Integer.valueOf(Objects.requireNonNull(
                params[1], "Currency cannot be null")));

        account.setClientId(Integer.valueOf(Objects.requireNonNull(
                params[2], "ClientId cannot be null")));

        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE account SET currency=?, sum=?, clientId=? WHERE id=?");
            ps.setString(1, account.getCurrency());
            ps.setInt(2, account.getSum());
            ps.setInt(3, account.getClientId());
            ps.setInt(4, account.getId());
            int i = ps.executeUpdate();
            if (i != 1) {
                System.out.println("Account with id " + account.getId() + " is updated.");
            } else {
                System.out.println("Account with id " + account.getId() + " is updated.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Account account) {
        Connection connection = getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM account WHERE id=" + account.getId());
            if (i != 1) {
                System.out.println("Account with id " + account.getId() + " is not deleted.");
            } else {
                System.out.println("Account with id " + account.getId() + " is deleted.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Account extractAccount(ResultSet rs) throws SQLException {
        Account account = new Account();

        account.setId(rs.getInt("id"));
        account.setCurrency(rs.getString("currency"));
        account.setSum(rs.getInt("sum"));
        account.setClientId(rs.getInt("clientId"));

        return account;
    }

    private int getRowCount() {
        Connection connection = getConnection();
        int i = 0;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Id FROM account");
            while(rs.next()){
                i++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return i;
    }
}