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
public class deleteTest {

    public deleteTest() {
    }
    
    @Test
    public void delete() throws Exception {
        System.out.println("delete");
        userDAO instance = new userDAO();
        userEntitys user = new userEntitys();
        user.setUid(1);
        user.setActive(true);
        user.setDeleted(false);
        user.setCreateAt(null);
        user.setUpdateAt(null);
        user.setName("Gabriel");
        user.setOffice("Estagiario");
        user.setLogin("Gabriel");
        user.setEmail("teste@teste.com");
        user.setPassword("123");
        user.setPhoto("sdfsfsdfafr");
        
        try {
            instance.delete(user);
            System.out.println("Deletado com sucesso");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
