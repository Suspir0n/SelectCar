/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import com.selectcar.DAO.carDAO;
import com.selectcar.entitys.carEntitys;
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
        carDAO instance = new carDAO();

        try {
            carEntitys car = new carEntitys();
            car.setUid(2);
            car.setNumberChassi("26T Asw47N eD Cb6990");
            car.setPlaca("BCW-9461");
            car.setMark("Nissan");
            car.setModel("Altima GXE 2.4 16V");
            car.setPorts(4);
            car.setAccessories("GPS");
            car.setYearModel(2000);
            car.setMotor("V8");
            car.setHorses(200);
            car.setColor("Azul");
            car.setPhoto("photo");
            instance.save(car);
            if (car == null) {
                fail("result null !");
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
