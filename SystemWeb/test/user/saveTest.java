/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import com.selectcar.DAO.userDAO;
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
        userDAO instance = new userDAO();

        try {
            userEntitys user = new userEntitys();
            user.setUid(1);
            user.setName("Evandro");
            user.setOffice("Desenvolvedor");
            user.setLogin("Evandro");
            user.setEmail("evandro@gmail.com");
            user.setPassword("123456");
            user.setPhoto("photo");
            instance.save(user);
            if (user == null) {
                fail("result null !");
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
}
