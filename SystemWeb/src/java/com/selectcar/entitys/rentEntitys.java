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
    private carEntitys carFK;
    private clientEntitys clientFK;
    private userEntitys userFK;
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
    public carEntitys getCarFK() {
        return carFK;
    }
    public void setCarFK(carEntitys carFK) {
        this.carFK = carFK;
    }
    public clientEntitys getClientFK() {
        return clientFK;
    }
    public void setClientFK(clientEntitys clientFK) {
        this.clientFK = clientFK;
    }
    public userEntitys getUserFK() {
        return userFK;
    }
    public void setUserFK(userEntitys userFK) {
        this.userFK = userFK;
    }  
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
}
