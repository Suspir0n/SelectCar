/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.bean;

import com.selectcar.DAO.userDAO;
import com.selectcar.entitys.userEntitys;
import static com.sun.javafx.logging.PulseLogger.addMessage;
import static com.sun.tools.ws.wsdl.parser.Util.fail;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Suspir0n
 */
@ManagedBean(name = "userBean")
@ViewScoped
public class userBean implements Serializable{
    
    // Attributes \\
    userDAO userDAO;
    List<userEntitys> users;
    userEntitys userEntitys;
    int id;

    // Constructor \\
    public userBean() {
       
    }
    
    // Second Constructor \\
    @PostConstruct
    public void init(){
        userDAO = new userDAO();
        userEntitys = new userEntitys();
        CountsHowManyUsers();
        all();
    }
    
    // Methods \\
    /*
    * Method of bring all the users
    * brings all the users and put in a table.
    */
    public void all(){
        try {
            users = userDAO.all();
           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /*
    * Method of authenticate the users
    * authenticate the users to have access the system.
    */
    public void authenticate(){
        boolean login = false;
        
        // conectar com o banco e retornar o resultado da verificação
        try {
            // conectar com o banco e retornar o resultado da verificação
            login = userDAO.authenticate(userEntitys);
        } catch (Exception ex) {
            Logger.getLogger(userBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(login == true){
            addMessage("Dados corretos!");
            FacesContext context = FacesContext.getCurrentInstance();
            
            try {
                context.getExternalContext().redirect("./pages/home.xhtml");
            } catch (IOException ex) {
                addMessage(ex.getMessage());
            }
        }else{
            addMessage("Senha errada!");
        }
    }
    /*
    * Method search
    * search a data at database.
    */
    public void search(){
        try {
            userDAO.search(id);
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
            System.out.println(userEntitys);
            userDAO.save(userEntitys);
        } catch (Exception ex) {
            addMessage(ex.getMessage());
        }
        
        addMessage("Usuario adicionado com sucesso!");
        
        userEntitys = new userEntitys();
    }
    /*
    * Method Count
    * Counts how many users are registered.
    */
    public void CountsHowManyUsers(){
        try {
            userEntitys = userDAO.CountsHowManyUsers();
        } catch (Exception ex) {
            addMessage(ex.getMessage());
        }
    }
    /*
    * Method Delete
    * delete some users register.
    */
    public void delete(userEntitys userEntitys){
        try {
            userDAO.delete(userEntitys);
        } catch (Exception e) {
            addMessage(e.getMessage());
            return;
        }
        addMessage("Usuario removido com sucesso!");
        
        all();
        updateComponent("form"); // atualizo o form, para dar um refresh no datatable
    }
    public void onRowEdit(RowEditEvent event){ // invocado ao editar um registro
        userEntitys registroEditado = (userEntitys) event.getObject();
        try {
            userDAO.save(registroEditado);
        } catch (Exception e) {
            addMessage(e.getMessage());
            return;
        }
        addMessage("Quantidade de compras alterada com sucesso!");
    }
    
    public void onRowCancel(RowEditEvent event){ // invocado ao cancelar a edição de um registro
        addMessage("Edição cancelada!");
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
    public userDAO getUserDAO() {
        return userDAO;
    }
    public void setUserDAO(userDAO userDAO) {
        this.userDAO = userDAO;
    }
    public List<userEntitys> getUsers() {
        return users;
    }
    public void setUsers(List<userEntitys> users) {
        this.users = users;
    }
    public userEntitys getUserEntitys() {
        return userEntitys;
    }
    public void setUserEntitys(userEntitys userEntitys) {
        this.userEntitys = userEntitys;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
