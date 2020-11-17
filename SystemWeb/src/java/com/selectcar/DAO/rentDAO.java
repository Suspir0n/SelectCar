/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.DAO;

import com.selectcar.bean.clientBean;
import com.selectcar.bean.rentBean;
import com.selectcar.entitys.carEntitys;
import com.selectcar.entitys.clientEntitys;
import com.selectcar.entitys.rentEntitys;
import com.selectcar.entitys.userEntitys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Suspir0n
 */
public class rentDAO {

    // Attributes \\
    Connection connect;
    PreparedStatement ps;

    // Instances \\
    baseDAO base = new baseDAO();

    // Constructor \\
    public rentDAO() {

    }
    
    // Methods \\
    /*
    * Method of save
    * register the data at database.
    */
    public void save(rentEntitys rent) throws Exception {
        try {
            connect = com.selectcar.database.connection.getConnection(); // obtem a conexão com o BD
            base.setSomeAttributesRents(rent);
            // se é uma inserção
            ps = connect.prepareStatement("INSERT INTO rent(uid, active, deleted, createAt, updateAt, dateRent, dateDelivery, status, description, valuePay, clientFK, carFK, userFK) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            if (!checkVehicle(rent)) {
                ps.setInt(1, rent.getUid());
                ps.setBoolean(2, rent.getActive());
                ps.setBoolean(3, rent.getDeleted());
                ps.setString(4, rent.getCreateAt());
                ps.setString(5, rent.getUpdateAt());
                ps.setString(6, rent.getDateRented());
                ps.setString(7, rent.getDateDelivery());
                ps.setBoolean(8, rent.getStatus());
                ps.setString(9, rent.getDescription());
                ps.setDouble(10, rent.getValuePaid());
                ps.setString(11, rent.getClientFK().getCpf());
                ps.setString(12, rent.getCarFK().getPlaca());
                ps.setString(13, rent.getUserFK().getName());
                ps.executeUpdate();
                throw new Exception("Operação Concluída com Sucesso");
            } else {
                if (checksIfDelivered(rent)) {
                    throw new Exception("Este veiculo já foi alugado e não entregue!");
                } else {
                    throw new Exception("Este veiculo já foi alugado!");
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro na preparação do SQL", e);
        }
    }
    /*
    * Method search
    * search a data at database.
    */
    public rentEntitys search(Integer id) throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        try {
            ps = connect.prepareStatement("select * from rent where uid=?"); // obtem apena uma única informação
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                rentEntitys rent = new rentEntitys();
                clientEntitys client = new clientEntitys();
                carEntitys car = new carEntitys();
                userEntitys user = new userEntitys();
                rent.setUid(resultSet.getInt("uid"));
                rent.setActive(resultSet.getBoolean("active"));
                rent.setDeleted(resultSet.getBoolean("deleted"));
                rent.setCreateAt(resultSet.getString("createAt"));
                rent.setUpdateAt(resultSet.getString("updateAt"));
                rent.setDateRented(resultSet.getString("dateRent"));
                rent.setDateDelivery(resultSet.getString("dateDelivery"));
                rent.setStatus(resultSet.getBoolean("status"));
                rent.setDescription(resultSet.getString("description"));
                rent.setValuePaid(resultSet.getDouble("valuePay"));
                client.setCpf(resultSet.getString("clientFK"));
                rent.setClientFK(client);
                car.setPlaca(resultSet.getString("carFK"));
                rent.setCarFK(car);
                user.setName(resultSet.getString("userFK"));
                rent.setUserFK(user);
                return rent;
            }
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - busca de aluguel", ex);
        }
        return null;
    }
    /*
    * Method Delete
    * delete some rents register.
    */
    public void delete(rentEntitys rent) throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        try {
            ps = connect.prepareStatement("delete from rent where id=?");
            ps.setInt(1, rent.getUid());
            ps.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o aluguel", e);
        }
        com.selectcar.database.connection.closeConnection(connect);
    }
    /*
    * Method Count
    * Counts how many rents are registered.
    */
    public rentEntitys CountsHowManyRents() throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        rentEntitys rent = new rentEntitys();
        try {
            ps = connect.prepareStatement("select count(*) as Alugueis from rent"); // obtem apena uma única informação
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                rent.setTotal(resultSet.getInt("Alugueis"));
            }
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - contador de Alugueis", ex);
        }
        return rent;
    }
    /*
    * Method that checks the vehicle 
    * A business rule that checks whether a vehicle is registered.
    */
    public boolean checkVehicle(rentEntitys rent) throws Exception {
        boolean result = false;
        ResultSet rs = null;
        connect = com.selectcar.database.connection.getConnection();

        String SQLV = "SELECT * FROM rent WHERE carFK = '" + rent.getCarFK().getPlaca() + "'";

        ps = connect.prepareStatement(SQLV);
        rs = ps.executeQuery();
        if (rs.next()) {
            result = true;
        }
        ps.close();
        return result;
    }
    /*
    * Method that checks if the vehicle was delivered 
    * A business rule that checks whether the vehicle has already been delivered.
    */
    public boolean checksIfDelivered(rentEntitys rent) throws Exception {
        boolean result = false;
        ResultSet rs = null;
        connect = com.selectcar.database.connection.getConnection();

        String SQLV = "SELECT * FROM rent WHERE status = '" + rent.getStatus() + "' AND carFK = '" + rent.getCarFK().getPlaca() + "'";

        ps = connect.prepareStatement(SQLV);
        rs = ps.executeQuery();
        if (rs.next()) {
            result = true;
        }
        ps.close();
        return result;
    }
    /*
    * Method of bring all the rents
    * brings all the rents and put in a table.
    */
    public List<rentEntitys> all() throws Exception {
        try {
            connect = com.selectcar.database.connection.getConnection();
            ps = connect.prepareStatement("select * from rent");
            ResultSet resultSet = ps.executeQuery();
            
            List<rentEntitys> listRent = new ArrayList<rentEntitys>();
            while (resultSet.next()) {
                rentEntitys rent = new rentEntitys();
                clientEntitys client = new clientEntitys();
                carEntitys car = new carEntitys();
                userEntitys user = new userEntitys();
                rent.setUid(resultSet.getInt("uid"));
                rent.setActive(resultSet.getBoolean("active"));
                rent.setDeleted(resultSet.getBoolean("deleted"));
                rent.setCreateAt(resultSet.getString("createAt"));
                rent.setUpdateAt(resultSet.getString("updateAt"));
                rent.setDateRented(resultSet.getString("dateRent"));
                rent.setDateDelivery(resultSet.getString("dateDelivery"));
                rent.setStatus(resultSet.getBoolean("status"));
                rent.setDescription(resultSet.getString("description"));
                rent.setValuePaid(resultSet.getDouble("valuePay"));
                client.setCpf(resultSet.getString("clientFK"));
                rent.setClientFK(client);
                car.setPlaca(resultSet.getString("carFK"));
                rent.setCarFK(car);
                user.setName(resultSet.getString("userFK"));
                rent.setUserFK(user);
                listRent.add(rent);
            }
            return listRent;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        }
    }
    /*
    * Method search
    * search a data at database.
    */
    public clientEntitys searchClient(String cpf) throws Exception
    {
        connect = com.selectcar.database.connection.getConnection();
        try{
            ps = connect.prepareStatement("select * from client where cpf=?"); // obtem apena uma única informação
            ps.setString(1, cpf);
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
    * Method of calculating sales over a certain period
    * brings the total billing in a specific data.
    */
    public rentEntitys revenuesTotal() throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        rentEntitys rent = new rentEntitys();
        
        try {
            String clientDateHome = "2020-07-01";
            String clientDateFinaly = "2020-12-31";

            ps = connect.prepareStatement("SELECT sum(valuePay) as Total FROM rent WHERE dateRent BETWEEN ('" + clientDateHome + "') AND ('" + clientDateFinaly + "')");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                rent.setValuePaid(resultSet.getFloat(1));
            }
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        }
        return rent;
    }
     /*
    * Method of calculating sales over a certain period
    * brings the total billing in a specific data.
    */
    public Double revenues() throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        rentEntitys rent = new rentEntitys();
        clientEntitys client = new clientEntitys();
        carEntitys car = new carEntitys();
        userEntitys user = new userEntitys();
        
        try {
            String clientDateHome = "2020-10-20";
            String clientDateFinaly = "2020-10-21";

            ps = connect.prepareStatement("SELECT dateRent, clientFK, carFK, userFK FROM rent WHERE dateRent BETWEEN ('" + clientDateHome + "') AND ('" + clientDateFinaly + "')");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                rent.setDateRented(resultSet.getString(1));
                client.setCpf(resultSet.getString(2));
                rent.setClientFK(client);
                car.setPlaca(resultSet.getString(3));
                rent.setCarFK(car);
                user.setName(resultSet.getString(4));
                rent.setUserFK(user);
            }
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        }
        return rent.getValuePaid();
    }
}
