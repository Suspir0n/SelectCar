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
public class searchTest {

    public searchTest() {
    }
    
    @Test
    public void search() throws Exception {
        System.out.println("search");
        Integer id = 1;
        carDAO instance = new carDAO();

        try {
            carEntitys car = instance.search(id);
            if (car == null) {
                fail("result null !");
            }
            System.out.println("uid: " + car.getUid());
            System.out.println("active: " + car.getActive());
            System.out.println("deleted: " + car.getDeleted());
            System.out.println("createAt: " + car.getCreateAt());
            System.out.println("updateAt: " + car.getUpdateAt());
            System.out.println("numberChassi: " + car.getNumberChassi());
            System.out.println("placa: " + car.getPlaca());
            System.out.println("created: " + car.getMark());
            System.out.println("model: " + car.getModel());
            System.out.println("ports: " + car.getPorts());
            System.out.println("accessories: " + car.getAccessories());
            System.out.println("yearModel: " + car.getYearModel());
            System.out.println("motor: " + car.getMotor());
            System.out.println("horses: " + car.getHorses());
            System.out.println("photo: " + car.getPhoto());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
