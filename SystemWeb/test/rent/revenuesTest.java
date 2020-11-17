/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rent;

import com.selectcar.DAO.rentDAO;
import com.selectcar.bean.rentBean;
import com.selectcar.entitys.rentEntitys;
import static junit.framework.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Suspir0n
 */
public class revenuesTest {
    
    public revenuesTest() {
    }
    
    @Test
    public void revenues() throws Exception {
        System.out.println("revenues");
        rentEntitys rent = new rentEntitys();
        rentDAO instance = new rentDAO();

        try {
            System.out.println(instance.revenues());
            
            if (rent == null) {
                fail("result null !");
            }
        } catch (Exception e) {
            fail(e.getMessage() + e);
        }
    }
}
