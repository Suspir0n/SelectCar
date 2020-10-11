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
public class userEntitys extends baseEntitys{
    // Attributes \\
    private String name;
    private String office;
    private String login;
    private String email;
    private String password;
    private String photo;

    // Getters and Setters \\
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOffice() {
        return office;
    }
    public void setOffice(String office) {
        this.office = office;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
