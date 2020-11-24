/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.bean;

import com.selectcar.DAO.carDAO;
import com.selectcar.entitys.carEntitys;
import static com.sun.javafx.logging.PulseLogger.addMessage;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Suspir0n
 */
@ManagedBean(name = "carBean")
@RequestScoped
public class carBean implements Serializable{
    
    // Attributes \\
    carDAO carDAO;
    List<carEntitys> cars;
    carEntitys carEntitys;
    int id;

    // Constructor \\
    public carBean() {
       
    }
    
    // Second Constructor \\
    @PostConstruct
    public void init(){
        carDAO = new carDAO();
        carEntitys = new carEntitys();
        CountsHowManyCars();
        all();
    }
    
    // Methods \\
    /*
    * Method of bring all the cars
    * brings all the cars and put in a table.
    */
    public void all(){
        try {
            cars = carDAO.all();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /*
    * Method of search
    * search a data at database.
    */
    public void search(){
        try {
            carDAO.search(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /*
    * Method of save
    * registre the data at database.
    */
    public void save(){
        try {
            carDAO.save(carEntitys);
        } catch (Exception ex) {
            addMessage(ex.getMessage());
        }
        
        addMessage("Veiculo adicionado com sucesso!");
        
        all();
        updateComponent("form");
        carEntitys = new carEntitys();
    }
    /*
    * Method of Count
    * Counts how many cars are registered.
    */
    public void CountsHowManyCars(){
        try {
            carEntitys = carDAO.CountsHowManyCars();
        } catch (Exception ex) {
            addMessage(ex.getMessage());
        }
    }
    /*
    * Method of Delete
    * delete some cars register.
    */
    public void delete(carEntitys carEntitys){
        try {
            carDAO.delete(carEntitys);
        } catch (Exception e) {
            addMessage(e.getMessage());
            return;
        }
        addMessage("veiculo removido com sucesso!");
        
        all();
        updateComponent("form"); // atualizo o form, para dar um refresh no datatable
    }
    public void updateComponent(String id){
         RequestContext.getCurrentInstance().update(id);
    }
    
    public void addMessage(String msg){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        updateComponent("msg"); // atualiza o componente de mensagens 
    }
    
    // Getters and Setters \\
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
