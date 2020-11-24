/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rent;

import com.selectcar.DAO.rentDAO;
import com.selectcar.entitys.rentEntitys;
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
        rentDAO instance = new rentDAO();

        try {
            rentEntitys rent = new rentEntitys();
            rent.setUid(7);
            rent.setDateRented("2020-11-24");
            rent.setDateDelivery("2020-10-11");
            rent.setStatus(false);
            rent.setDescription("Veiculo entregue com uma otima condição, em otimo estado, com o tanque cheio");
            rent.setValuePaid(1500.00);
            rent.setCpf("999.888.777-68");
            rent.setPlaca("teste");
            rent.setUser("Evandro");
            instance.save(rent);
            if (rent == null) {
                fail("result null !");
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
