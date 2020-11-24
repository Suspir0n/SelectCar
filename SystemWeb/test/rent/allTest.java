/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rent;

import com.selectcar.DAO.rentDAO;
import com.selectcar.entitys.carEntitys;
import com.selectcar.entitys.clientEntitys;
import com.selectcar.entitys.rentEntitys;
import com.selectcar.entitys.userEntitys;
import static junit.framework.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Suspir0n
 */
public class allTest {
    
    public allTest() {
    }

    @Test
    public void all() throws Exception {
        System.out.println("save");
        rentDAO instance = new rentDAO();
        clientEntitys cpfClient = new clientEntitys();
        carEntitys placaCar = new carEntitys();
        userEntitys nameUser = new userEntitys();

        try {
            rentEntitys rent = new rentEntitys();
            System.out.println(instance.all().get(0).getCpf());
     
            if (rent == null) {
                fail("result null !");
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
