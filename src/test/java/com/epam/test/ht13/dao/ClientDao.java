package com.epam.test.ht13.dao;

import com.epam.test.ht13.dbmodels.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.epam.test.ht13.ConnectorDb.getConnection;
import static com.epam.test.ht8.task1.InputOutputHelper.print;

public class ClientDao implements Dao<Client> {
    public ClientDao(){
        connection = getConnection();
    }

    private static Connection connection;

    @Override
    public Optional<Client> get(long id) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE id=" + id);
            if (rs.next()) {
                return Optional.of(extractClient(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client");
            while (rs.next()) {
                clients.add(extractClient(rs));
            }
            return clients;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(Client client) {
        int clientId = getRowCount() + 1;

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO client VALUES (?, ?, ?, ?)");
            ps.setInt(1, clientId);
            ps.setString(2, client.getName());
            ps.setString(3, client.getSurname());
            ps.setString(4, client.getEmail());
            int i = ps.executeUpdate();
            if (i != 1) {
                print("Client with id " + clientId + " is not created.\n");
            } else {
                print("Client with id " + clientId + " is created.\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Client client, String[] params) {
        client.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));

        client.setSurname(Objects.requireNonNull(
                params[1], "Surname cannot be null"));

        client.setEmail(Objects.requireNonNull(
                params[2], "Email cannot be null"));

        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE client SET name=?, surname=?, email=? WHERE id=?");
            ps.setString(1, client.getName());
            ps.setString(2, client.getSurname());
            ps.setString(3, client.getEmail());
            ps.setInt(4, client.getId());
            int i = ps.executeUpdate();
            if (i != 1) {
                print("Client with id " + client.getId() + " is updated.\n");
            } else {
                print("Client with id " + client.getId() + " is updated.\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Client client) {
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM client WHERE id=" + client.getId());
            if (i != 1) {
                print("Client with id " + client.getId() + " is not deleted.\n");
            } else {
                print("Client with id " + client.getId() + " is deleted.\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Client extractClient(ResultSet rs) throws SQLException {
        Client client = new Client();

        client.setId(rs.getInt("id"));
        client.setName(rs.getString("name"));
        client.setSurname(rs.getString("surname"));
        client.setEmail(rs.getString("email"));

        return client;
    }

    private int getRowCount() {
        int i = 0;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Id FROM client");
            while(rs.next()){
                i++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return i;
    }
}
