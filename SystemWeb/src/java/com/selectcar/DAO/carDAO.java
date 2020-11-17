/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.DAO;

import com.selectcar.entitys.carEntitys;
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
public class carDAO {
    
    // Attributes \\
    Connection connect;
    PreparedStatement ps;
    
    // Instances \\
    baseDAO base = new baseDAO();

    // Constructor \\
    public carDAO() {
        
    }

    // Methods \\
    /*
    * Method of save
    * register the data at database.
    */
    public void save(carEntitys car) throws Exception {
        try {
            connect = com.selectcar.database.connection.getConnection(); // obtem a conexão com o BD
            base.setSomeAttributesCars(car);
            // se é uma inserção
            ps = connect.prepareStatement("INSERT INTO car(uid, active, deleted, createAt, updateAt, numberChassi, placa, mark, model, ports, accessories, yearModel, motor, horses, color, photo) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, car.getUid());
            ps.setBoolean(2, car.getActive());
            ps.setBoolean(3, car.getDeleted());
            ps.setString(4, car.getCreateAt());
            ps.setString(5, car.getUpdateAt());
            ps.setString(6, car.getNumberChassi());
            ps.setString(7, car.getPlaca());
            ps.setString(8, car.getMark());
            ps.setString(9, car.getModel());
            ps.setInt(10, car.getPorts());
            ps.setString(11, car.getAccessories());
            ps.setInt(12, car.getYearModel());
            ps.setString(13, car.getMotor());
            ps.setInt(14, car.getHorses());
            ps.setString(15, car.getColor());
            ps.setString(16, car.getPhoto());
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
    public carEntitys search(Integer id) throws Exception
    {
        connect = com.selectcar.database.connection.getConnection();
        try{
            ps = connect.prepareStatement("select * from car where uid=?"); // obtem apena uma única informação
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                carEntitys car = new carEntitys();
                car.setUid(resultSet.getInt("uid"));
                car.setActive(resultSet.getBoolean("active"));
                car.setDeleted(resultSet.getBoolean("deleted"));
                car.setCreateAt(resultSet.getString("createAt"));
                car.setUpdateAt(resultSet.getString("updateAt"));
                car.setNumberChassi(resultSet.getString("numberChassi"));
                car.setPlaca(resultSet.getString("placa"));
                car.setMark(resultSet.getString("mark"));
                car.setModel(resultSet.getString("model"));
                car.setPorts(resultSet.getInt("ports"));
                car.setAccessories(resultSet.getString("accessories"));
                car.setYearModel(resultSet.getInt("yearModel"));
                car.setMotor(resultSet.getString("motor"));
                car.setHorses(resultSet.getInt("horses"));
                car.setColor(resultSet.getString("color"));
                car.setPhoto(resultSet.getString("photo"));               
                return car;
            }
        }catch(SQLException ex){
            throw new Exception("Erro na execução do SQL - busca de veiculos",ex);
        }
        return null;
    }
    /*
    * Method Delete
    * delete some cars register.
    */
    public void delete(carEntitys car) throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        try {
            ps = connect.prepareStatement("delete from car where uid=?");
            ps.setInt(1, car.getUid());
            ps.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o veiculo",e);
        }
        com.selectcar.database.connection.closeConnection(connect);
    }
    /*
    * Method Count
    * Counts how many cars are registered.
    */
    public carEntitys CountsHowManyCars() throws Exception {
        connect = com.selectcar.database.connection.getConnection();
        try {
            ps = connect.prepareStatement("select count(*) as Veiculos from car"); // obtem apena uma única informação
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                carEntitys car = new carEntitys();
                car.setTotal(resultSet.getInt("Veiculos"));
                return car;
            }
        } catch (SQLException ex) {
            throw new Exception("Erro na execução do SQL - contador de veiculos", ex);
        }
        return null;
    }
    /*
    * Method of bring all the cars
    * brings all the cars and put in a table.
    */
    public List<carEntitys> all() throws Exception {
        connect = com.selectcar.database.connection.getConnection();

        List<carEntitys> listCar = new ArrayList<>();
        try {
            ps = connect.prepareStatement("select * from car");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                carEntitys car = new carEntitys();
                car.setUid(resultSet.getInt("uid"));
                car.setActive(resultSet.getBoolean("active"));
                car.setDeleted(resultSet.getBoolean("deleted"));
                car.setCreateAt(resultSet.getString("createAt"));
                car.setUpdateAt(resultSet.getString("updateAt"));
                car.setNumberChassi(resultSet.getString("numberChassi"));
                car.setPlaca(resultSet.getString("placa"));
                car.setMark(resultSet.getString("mark"));
                car.setModel(resultSet.getString("model"));
                car.setPorts(resultSet.getInt("ports"));
                car.setAccessories(resultSet.getString("accessories"));
                car.setYearModel(resultSet.getInt("yearModel"));
                car.setMotor(resultSet.getString("motor"));
                car.setHorses(resultSet.getInt("horses"));
                car.setColor(resultSet.getString("color"));
                car.setPhoto(resultSet.getString("photo"));  
                listCar.add(car);
            }
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        }
        return listCar;
    }
}
