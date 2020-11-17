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
public class saveTest {

    public saveTest() {
    }

    @Test
    public void save() throws Exception {
        System.out.println("save");
        clientDAO instance = new clientDAO();

        try {
            clientEntitys client = new clientEntitys();
            client.setUid(2);
            client.setName("William");
            client.setAddress("Rua 1");
            client.setAddressComplementation("Proximo ao metro");
            client.setState("BA");
            client.setCity("Salvador");
            client.setZipCode("40353-200");
            client.setPhone("99 99999-9999");
            client.setCpf("999.999.999-99");
            client.setEmail("william@gmail.com");
            client.setPhoto("sdfdfhgfhjjk");
            instance.save(client);
            if (client == null) {
                fail("result null !");
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
