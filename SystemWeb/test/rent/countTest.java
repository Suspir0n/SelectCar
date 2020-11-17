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
public class countTest {
    rentEntitys rent;
    
    public countTest() {
    }
    
    @Test
    public void count() throws Exception {
        System.out.println("count");
        rentDAO instance = new rentDAO();

        try {
            rent = instance.CountsHowManyRents();
            System.out.println("Total: " + rent.getTotal());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
