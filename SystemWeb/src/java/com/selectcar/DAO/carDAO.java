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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suspir0n
 */
public class carDAO {

    // Attributes \\
    private Connection connect;

    // Constructor \\
    public carDAO() {
        verifyIfConnect();
    }

    // Methods \\
    /*
    * Method of Verification
    * Verify if the database is here connected or no.
     */
    public void verifyIfConnect() {
        try {
            this.connect = com.selectcar.database.connection.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(carDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    * Method Count
    * Counts how many cars are registered.
     */
    public List<carEntitys> CountsHowManyCars() throws Exception {
        try{
            connect = com.selectcar.database.connection.getConnection();
            String SQL = "select count(*) as veiculos from car";
            PreparedStatement ps = connect.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            List<carEntitys> cars = new ArrayList<carEntitys>();
    
            while (rs.next()) {
                carEntitys carEntitys = new carEntitys();
                carEntitys.setTotal(rs.getInt("veiculos"));
                cars.add(carEntitys);
            }
            com.selectcar.database.connection.closeConnection(connect);
            return cars;
        } catch (SQLException sqle) {
            throw new Exception("Erro na execução do SQL",sqle);
        }
    }
}
