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
public class saveTest {

    public saveTest() {
    }

    @Test
    public void save() throws Exception {
        System.out.println("save");
        rentDAO instance = new rentDAO();
        clientEntitys cpfClient = new clientEntitys();
        carEntitys placaCar = new carEntitys();
        userEntitys nameUser = new userEntitys();

        try {
            rentEntitys rent = new rentEntitys();
            rent.setUid(3);
            rent.setDateRented("2020-10-21");
            rent.setDateDelivery("2020-10-24");
            rent.setStatus(false);
            rent.setDescription("Veiculo entregue com uma otima condição, em otimo estado, com o tanque cheio");
            rent.setValuePaid(430.00);
            cpfClient.setCpf("999.999.999-99");
            rent.setClientFK(cpfClient);
            placaCar.setPlaca("bcd-8965");
            rent.setCarFK(placaCar);
            nameUser.setName("Evandro");
            rent.setUserFK(nameUser);
            instance.save(rent);
            if (rent == null) {
                fail("result null !");
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
