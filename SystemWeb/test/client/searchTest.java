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
public class searchTest {

    public searchTest() {
    }
    
    @Test
    public void search() throws Exception {
        System.out.println("search");
        Integer id = 1;
        clientDAO instance = new clientDAO();

        try {
            clientEntitys client = instance.search(id);
            if (client == null) {
                fail("result null !");
            }
            System.out.println("uid: " + client.getUid());
            System.out.println("active: " + client.getActive());
            System.out.println("deleted: " + client.getDeleted());
            System.out.println("createAt: " + client.getCreateAt());
            System.out.println("updateAt: " + client.getUpdateAt());
            System.out.println("name: " + client.getName());
            System.out.println("address: " + client.getAddress());
            System.out.println("complementationAddress: " + client.getAddressComplementation());
            System.out.println("state: " + client.getState());
            System.out.println("city: " + client.getCity());
            System.out.println("zipCode: " + client.getZipCode());
            System.out.println("phone: " + client.getPhone());
            System.out.println("cpf: " + client.getCpf());
            System.out.println("email: " + client.getEmail());
            System.out.println("photo: " + client.getPhoto());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
