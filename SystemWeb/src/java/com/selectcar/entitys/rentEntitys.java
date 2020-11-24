/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.entitys;

/**
 *
 * @author Suspir0n
 */
public class rentEntitys extends baseEntitys{
    // Attributes \\
    private String dateRented;
    private String dateDelivery;
    private boolean status;
    private String description;
    private double valuePaid;
    private String placa;
    private String cpf;
    private String user;
    private int total;

    // Getters and Setters
    public String getDateRented() {
        return dateRented;
    }
    public void setDateRented(String dateRented) {
        this.dateRented = dateRented;
    }
    public String getDateDelivery() {
        return dateDelivery;
    }
    public void setDateDelivery(String dateDelivery) {
        this.dateDelivery = dateDelivery;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getValuePaid() {
        return valuePaid;
    }
    public void setValuePaid(double valuePaid) {
        this.valuePaid = valuePaid;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}
