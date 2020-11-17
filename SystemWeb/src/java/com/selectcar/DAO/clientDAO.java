/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.DAO;

import com.selectcar.entitys.clientEntitys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Suspir0n
 */
public class clientDAO {
    
    // Attributes \\
    Connection connect;
    PreparedStatement ps;
    
    // Instances \\
    baseDAO base = new baseDAO();

    // Constructor \\
    public clientDAO() {
        
    }

    // Methods \\
    /*
    * Method of save
    * register the data at database.
    */
    public void save(clientEntitys client) throws Exception {
        try {
            connect = com.selectcar.database.connection.getConnection(); // obtem a conexão com o BD
            base.setSomeAttributesClients(client);
            // se é uma inserção
            ps = connect.prepareStatement("INSERT INTO client(uid, active, deleted, createAt, updateAt, name, address, complementationAddress, state, city, zipCode, phone, cpf, email, photo) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, client.getUid());
            ps.setBoolean(2, client.getActive());
            ps.setBoolean(3, client.getDeleted());
            ps.setString(4, client.getCreateAt());
            ps.setString(5, client.getUpdateAt());
            ps.setString(6, client.getName());
            ps.setString(7, client.getAddress());
            ps.setString(8, client.getAddressComplementation());
            ps.setString(9, client.getState());
            ps.setString(10, client.getCity());
            ps.setString(11, client.getZipCode());
            ps.setString(12, client.getPhone());
            ps.setString(13, client.getCpf());
            ps.setString(14, client.getEmail());
            ps.setString(15, client.getPhoto());
        } catch (SQLException e) {
            throw new Exception("Erro na preparação do SQL", e);
        }
        try {
            ps.execute();
        } catch (SQLException e) {
            throw new Exception("Erro na execução do SQL", e);
        }
    }
    /*
    * Method search
    * search a data at database.
    */
    public clientEntitys search(Integer id) throws Exception
    {
        connect = com.selectcar.database.connection.getConnection();
        try{
            ps = connect.prepareStatement("select * from client where uid=?"); // obtem apena uma única informação
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                clientEntitys client = new clientEntitys();
                client.setUid(resultSet.getInt("uid"));
                client.setActive(resultSet.getBoolean("active"));
                client.setDeleted(resultSet.getBoolean("deleted"));
                client.setCreateAt(resultSet.getString("createAt"));
                client.setUpdateAt(resultSet.getString("updateAt"));
                client.setName(resultSet.getString("name"));
                client.setAddress(resultSet.getString("address"));
                client.setAddressComplementation(resultSet.getString("complementationAddress"));
                client.setState(resultSet.getString("state"));
                client.setCity(resultSet.getString("city"));
                client.setZipCode(resultSet.getString("zipCode"));
                client.setPhone(resultSet.getString("phone"));
                client.setCpf(resultSet.getString("cpf"));
                client.setEmail(resultSet.getString("email"));
                client.setPhoto(resultSet.getString("photo"));               
                return client;
            }
        }catch(SQLException ex){
            throw new Exception("Erro na execução do SQL - busca de cliente",ex);
        }
        return null;
    }
    /*
    * Method Delete
    * delete some clients register.
    */
    public void delete(clientEntitys client) throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        try {
            ps = connect.prepareStatement("delete from client where uid=?");
            ps.setInt(1, client.getUid());
            ps.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o cliente",e);
        }
        com.selectcar.database.connection.closeConnection(connect);
    }
    /*
    * Method Count
    * Counts how many clients are registered.
    */
    public clientEntitys CountsHowManyClients() throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        try {
            ps = connect.prepareStatement("select count(*) as Clientes from client"); // obtem apena uma única informação
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                clientEntitys client = new clientEntitys();
                client.setTotal(resultSet.getInt("Clientes"));
                return client;
            }
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - contador de clientes", ex);
        }
        return null;
    }
    /*
    * Method of bring all the clients
    * brings all the clients and put in a table.
    */
    public List<clientEntitys> all() throws Exception {
        connect = com.selectcar.database.connection.getConnection();

        List<clientEntitys> listClient = new ArrayList<>();
        try {
            ps = connect.prepareStatement("select * from client");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                clientEntitys client = new clientEntitys();
                client.setUid(resultSet.getInt("uid"));
                client.setActive(resultSet.getBoolean("active"));
                client.setDeleted(resultSet.getBoolean("deleted"));
                client.setCreateAt(resultSet.getString("createAt"));
                client.setUpdateAt(resultSet.getString("updateAt"));
                client.setName(resultSet.getString("name"));
                client.setAddress(resultSet.getString("address"));
                client.setAddressComplementation(resultSet.getString("complementationAddress"));
                client.setState(resultSet.getString("state"));
                client.setCity(resultSet.getString("city"));
                client.setZipCode(resultSet.getString("zipCode"));
                client.setPhone(resultSet.getString("phone"));
                client.setCpf(resultSet.getString("cpf"));
                client.setEmail(resultSet.getString("email"));
                client.setPhoto(resultSet.getString("photo")); 
                listClient.add(client);
            }
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        }
        return listClient;
    }
}
