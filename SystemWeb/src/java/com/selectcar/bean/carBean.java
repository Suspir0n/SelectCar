/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.bean;

import com.selectcar.DAO.carDAO;
import com.selectcar.entitys.carEntitys;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Suspir0n
 */
@Named(value = "carBean")
@SessionScoped
public class carBean implements Serializable{
    carDAO carDAO;
    List<carEntitys> cars;
    carEntitys carEntitys;

    public carBean() {
        carDAO = new carDAO();
    }
    
    @PostConstruct
    public void init(){ // como se fosse u  segundo contrutor
        CountsHowManyCars();
    }
    
    public void CountsHowManyCars(){
       try {
            cars = carDAO.CountsHowManyCars(); // inicializa a fonte de dados com as informações advindas do BD
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public carDAO getCarDAO() {
        return carDAO;
    }
    public void setCarDAO(carDAO carDAO) {
        this.carDAO = carDAO;
    }
    public List<carEntitys> getCars() {
        return cars;
    }
    public void setCars(List<carEntitys> cars) {
        this.cars = cars;
    }
    public carEntitys getCarEntitys() {
        return carEntitys;
    }
    public void setCarEntitys(carEntitys carEntitys) {
        this.carEntitys = carEntitys;
    }
}
