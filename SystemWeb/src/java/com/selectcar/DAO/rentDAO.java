/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.DAO;

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
        if (!checkVehicle(rent)) {
            if (checkClient(rent)) {
                if (checkCar(rent)) {
                    try {
                        connect = com.selectcar.database.connection.getConnection(); // obtem a conexão com o BD
                        base.setSomeAttributesRents(rent);
                        // se é uma inserção
                        ps = connect.prepareStatement("INSERT INTO rent(uid, active, deleted, createAt, updateAt, dateRent, dateDelivery, status, description, valuePay, cpf, placa, user) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

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
                        ps.setString(11, rent.getCpf());
                        ps.setString(12, rent.getPlaca());
                        ps.setString(13, rent.getUser());
                        ps.execute();

                    } catch (SQLException e) {
                        throw new Exception("Erro na preparação do SQL", e);
                    }
                } else {
                    throw new Exception("Este veiculo não existe no nosso catálogo!");
                }
            } else {
                throw new Exception("Este cliente não está cadastrado, por favor, cadastre ele antes para prosseguir!");
            }
        } else {
            if (checksIfDelivered(rent)) {
                throw new Exception("Este veiculo já foi alugado e não entregue!");
            } else {
                throw new Exception("Este veiculo já foi alugado!");
            }
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
                rent.setCpf(resultSet.getString("cpf"));
                rent.setPlaca(resultSet.getString("placa"));
                rent.setUser(resultSet.getString("user"));
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
    * Method that checks the car 
    * checks whether a car is registered.
     */
    public boolean checkCar(rentEntitys rent) throws Exception {
        boolean result = false;
        ResultSet rs = null;
        connect = com.selectcar.database.connection.getConnection();
        ps = connect.prepareStatement("SELECT * FROM car WHERE placa = '" + rent.getPlaca() + "'");
        rs = ps.executeQuery();
        if (rs.next()) {
            result = true;
        }
        return result;
    }

    /*
    * Method that checks the client 
    * checks whether a client is registered.
     */
    public boolean checkClient(rentEntitys rent) throws Exception {
        boolean result = false;
        ResultSet rs = null;
        connect = com.selectcar.database.connection.getConnection();
        ps = connect.prepareStatement("SELECT * FROM client WHERE cpf = '" + rent.getCpf() + "'");
        rs = ps.executeQuery();
        if (rs.next()) {
            result = true;
        }
        return result;
    }

    /*
    * Method that checks the vehicle 
    * A business rule that checks whether a vehicle is registered.
     */
    public boolean checkVehicle(rentEntitys rent) throws Exception {
        boolean result = false;
        ResultSet rs = null;
        connect = com.selectcar.database.connection.getConnection();
        ps = connect.prepareStatement("SELECT * FROM rent WHERE placa = '" + rent.getPlaca() + "'");
        rs = ps.executeQuery();
        if (rs.next()) {
            result = true;
        }
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

        String SQLV = "SELECT * FROM rent WHERE status = '" + rent.getStatus() + "' AND placa = '" + rent.getPlaca() + "'";

        ps = connect.prepareStatement(SQLV);
        rs = ps.executeQuery();
        if (rs.next()) {
            result = true;
        }
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
                rent.setCpf(resultSet.getString("cpf"));
                rent.setPlaca(resultSet.getString("placa"));
                rent.setUser(resultSet.getString("user"));
                listRent.add(rent);
            }
            return listRent;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        }
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
}
