/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import com.selectcar.DAO.userDAO;
import com.selectcar.entitys.userEntitys;
import java.util.List;
import static junit.framework.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Suspir0n
 */
public class countTest {
    userEntitys user;
    
    public countTest() {
    }
    
    @Test
    public void count() throws Exception {
        System.out.println("count");
        userDAO instance = new userDAO();

        try {
            user = instance.CountsHowManyUsers();
            System.out.println("Total: " + user.getTotal());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
