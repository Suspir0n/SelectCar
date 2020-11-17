/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selectcar.DAO;

import com.selectcar.entitys.carEntitys;
import com.selectcar.entitys.clientEntitys;
import com.selectcar.entitys.rentEntitys;
import com.selectcar.entitys.userEntitys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Suspir0n
 */
public class baseDAO {
    // Instance \\
    Date dataAtual = new Date();
    SimpleDateFormat amd = new SimpleDateFormat("yyyy-MM-dd");
    
    public void setSomeAttributesUsers(userEntitys user) throws Exception {
            user.setActive(true);
            user.setDeleted(false);
            user.setCreateAt(amd.format(dataAtual));
            user.setUpdateAt(amd.format(dataAtual));
    }
    public void setSomeAttributesCars(carEntitys car) throws Exception {
            car.setActive(true);
            car.setDeleted(false);
            car.setCreateAt(amd.format(dataAtual));
            car.setUpdateAt(amd.format(dataAtual));
    }
    public void setSomeAttributesClients(clientEntitys client) throws Exception {
            client.setActive(true);
            client.setDeleted(false);
            client.setCreateAt(amd.format(dataAtual));
            client.setUpdateAt(amd.format(dataAtual));
    }
    public void setSomeAttributesRents(rentEntitys rent) throws Exception {
            rent.setActive(true);
            rent.setDeleted(false);
            rent.setCreateAt(amd.format(dataAtual));
            rent.setUpdateAt(amd.format(dataAtual));
    }
}
