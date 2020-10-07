
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Suspir0n
 */
public class teste {

    public static void main(String[] args) {
        String s = "ba";
        List<String> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            res.add((String) s.subSequence(0, i));
             System.out.println(res);
        }
    }
}
