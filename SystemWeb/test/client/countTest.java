/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.selectcar.DAO.clientDAO;
import com.selectcar.entitys.clientEntitys;
import static junit.framework.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Suspir0n
 */
public class countTest {
    clientEntitys client;
    
    public countTest() {
    }
    
    @Test
    public void count() throws Exception {
        System.out.println("count");
        clientDAO instance = new clientDAO();

        try {
            client = instance.CountsHowManyClients();
            System.out.println("Total: " + client.getTotal());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
