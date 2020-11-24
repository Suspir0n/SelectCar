/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.bean;

import com.selectcar.DAO.clientDAO;
import com.selectcar.entitys.clientEntitys;
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
@ManagedBean(name = "clientBean")
@RequestScoped
public class clientBean implements Serializable{
    
     // Attributes \\
    clientDAO clientDAO;
    List<clientEntitys> clients;
    clientEntitys clientEntitys;
    int id;

    // Constructor \\
    public clientBean() {
        clientDAO = new clientDAO();
    }
    
    // Second Constructor \\
    @PostConstruct
    public void init(){
        clientDAO = new clientDAO();
        clientEntitys = new clientEntitys();  
        CountsHowManyClients();
        all();
    }
    // Methods \\
    /*
    * Method of bring all the clients
    * brings all the clients and put in a table.
    */
    public void all(){
        try {
            clients = clientDAO.all();
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
            clientDAO.search(id);
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
            System.out.println(clientEntitys);
            clientDAO.save(clientEntitys);
        } catch (Exception ex) {
            addMessage(ex.getMessage());
        }
        
        addMessage("Cliente adicionado com sucesso!");
        
        all();
        updateComponent("form");
        clientEntitys = new clientEntitys();
    }
    /*
    * Method of Count
    * Counts how many clients are registered.
    */
    public void CountsHowManyClients(){
        try {
            clientEntitys = clientDAO.CountsHowManyClients();
        } catch (Exception ex) {
            addMessage(ex.getMessage());
        }
    }
    /*
    * Method of Delete
    * delete some clients register.
    */
    public void delete(clientEntitys clientEntitys){
        try {
            clientDAO.delete(clientEntitys);
        } catch (Exception e) {
            addMessage(e.getMessage());
            return;
        }
        addMessage("Cliente removido com sucesso!");
        
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
    public clientDAO getClientDAO() {
        return clientDAO;
    }
    public void setClientDAO(clientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }
    public List<clientEntitys> getClients() {
        return clients;
    }
    public void setClients(List<clientEntitys> clients) {
        this.clients = clients;
    }
    public clientEntitys getClientEntitys() {
        return clientEntitys;
    }
    public void setClientEntitys(clientEntitys clientEntitys) {
        this.clientEntitys = clientEntitys;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
