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
public class searchTest {
    
    public searchTest() {
    }
    
    @Test
    public void search() throws Exception {
        System.out.println("search");
        Integer id = 1;
        rentDAO instance = new rentDAO();

        try {
            rentEntitys rent = instance.search(id);
            if (rent == null) {
                fail("result null !");
            }
            System.out.println("uid: " + rent.getUid());
            System.out.println("active: " + rent.getActive());
            System.out.println("deleted: " + rent.getDeleted());
            System.out.println("createAt: " + rent.getCreateAt());
            System.out.println("updateAt: " + rent.getUpdateAt());
            System.out.println("dateRent: " + rent.getDateRented());
            System.out.println("dateDelivery: " + rent.getDateDelivery());
            System.out.println("status: " + rent.getStatus());
            System.out.println("description: " + rent.getDescription());
            System.out.println("valuePay: " + rent.getValuePaid());
            System.out.println("clientFK: " + rent.getClientFK().getCpf());
            System.out.println("carFK: " + rent.getCarFK().getPlaca());
            System.out.println("userFK: " + rent.getUserFK().getName());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
