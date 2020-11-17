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
public class allTest {

    public allTest() {
    }
    
    @Test
    public void search() throws Exception {
        System.out.println("all");
        userDAO instance = new userDAO();
        userEntitys user = new userEntitys();
        
        try {
            instance.all();
            if (user == null) {
                fail("result null !");
            }
            System.out.println("uid: " + user.getUid());
            System.out.println("active: " + user.getActive());
            System.out.println("deleted: " + user.getDeleted());
            System.out.println("createAt: " + user.getCreateAt());
            System.out.println("updateAt: " + user.getUpdateAt());
            System.out.println("name: " + user.getName());
            System.out.println("office: " + user.getOffice());
            System.out.println("login: " + user.getLogin());
            System.out.println("email: " + user.getLogin());
            System.out.println("password: " + user.getPassword());
            System.out.println("photo: " + user.getPhoto());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
