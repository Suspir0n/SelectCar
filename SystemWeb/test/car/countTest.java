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
public class countTest {
    carEntitys car;
    
    public countTest() {
    }
    
    @Test
    public void count() throws Exception {
        System.out.println("count");
        carDAO instance = new carDAO();

        try {
            car = instance.CountsHowManyCars();
            System.out.println("Total: " + car.getTotal());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
