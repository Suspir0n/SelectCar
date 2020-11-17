/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.entitys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Suspir0n
 */
public class baseEntitys {
   


    // Attributes \\
    private int uid;
    private boolean active;
    private boolean deleted;
    private String createAt;
    private String updateAt;
    

    // Getters and Setters
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public String getCreateAt() {
        return createAt;
    }
    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
    public String getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
