/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.bean;

import com.selectcar.DAO.rentDAO;
import com.selectcar.entitys.carEntitys;
import com.selectcar.entitys.clientEntitys;
import com.selectcar.entitys.rentEntitys;
import com.selectcar.entitys.userEntitys;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Suspir0n
 */
@ManagedBean(name = "rentBean")
@RequestScoped
public class rentBean implements Serializable{
    
     // Attributes \\
    rentDAO rentDAO;
    List<rentEntitys> rents;
    rentEntitys rentEntitys;
    clientEntitys clientEntitys;
    carEntitys carEntitys;
    userEntitys userEntitys;
    int id;
    double totalCost;
    double totalProfit;
    int goals;
    int total;

    // Constructor \\
    public rentBean() {
    }
    
    // Second Constructor \\
    @PostConstruct
    public void init(){
        rentDAO = new rentDAO();
        rentEntitys = new rentEntitys();
        CountsHowManyRents();
        all();
        revenuesTotal();
        costAndProfitGoals();
    }
    // Methods \\
    /*
    * Method of bring all the rents
    * brings all the rents and put in a table.
    */
    public void all(){
        try {
            rents = rentDAO.all();
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
            rentDAO.search(id);
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
            rentDAO.save(rentEntitys);
        } catch (Exception ex) {
            addMessage(ex.getMessage());
        }
        
        addMessage("Aluguel adicionado com sucesso!");
        
        all();
        updateComponent("form");
        rentEntitys = new rentEntitys();
    }
    /*
    * Method of Count
    * Counts how many rents are registered.
    */
    public void CountsHowManyRents(){
        try {
            rentEntitys = rentDAO.CountsHowManyRents();
            setTotal(rentEntitys.getTotal());
        } catch (Exception ex) {
            addMessage(ex.getMessage());
        }
    }
    /*
    * Method of Sum rent value total
    * Sums how many rents are registered.
    */
    public void revenuesTotal(){
        try {
            rentEntitys = rentDAO.revenuesTotal();
        } catch (Exception ex) {
            addMessage(ex.getMessage());
        }
    }
    public void costAndProfitGoals(){
        try {
            carEntitys carEntitys = new carEntitys();
            totalCost = (rentEntitys.getValuePaid()*30)/100;
            totalProfit = rentEntitys.getValuePaid() - ((rentEntitys.getValuePaid()*30)/100);
        } catch (Exception ex) {
            addMessage(ex.getMessage());
        }
    }
    /*
    * Method of Delete
    * delete some rents register.
    */
    public void delete(rentEntitys rentEntitys){
        try {
            rentDAO.delete(rentEntitys);
        } catch (Exception e) {
            addMessage(e.getMessage());
            return;
        }
        addMessage("Aluguel removido com sucesso!");
        
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
    public rentDAO getRentDAO() {
        return rentDAO;
    }
    public void setRentDAO(rentDAO rentDAO) {
        this.rentDAO = rentDAO;
    }
    public List<rentEntitys> getRents() {
        return rents;
    }
    public void setRents(List<rentEntitys> rents) {
        this.rents = rents;
    }
    public rentEntitys getRentEntitys() {
        return rentEntitys;
    }
    public void setRentEntitys(rentEntitys rentEntitys) {
        this.rentEntitys = rentEntitys;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public double getTotalProfit() {
        return totalProfit;
    }
    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }
    public int getGoals() {
        return goals;
    }
    public void setGoals(int goals) {
        this.goals = goals;
    }
    public clientEntitys getClientEntitys() {
        return clientEntitys;
    }
    public void setClientEntitys(clientEntitys clientEntitys) {
        this.clientEntitys = clientEntitys;
    }
    public carEntitys getCarEntitys() {
        return carEntitys;
    }
    public void setCarEntitys(carEntitys carEntitys) {
        this.carEntitys = carEntitys;
    }
    public userEntitys getUserEntitys() {
        return userEntitys;
    }
    public void setUserEntitys(userEntitys userEntitys) {
        this.userEntitys = userEntitys;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}
