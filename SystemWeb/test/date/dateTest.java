/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;

/**
 *
 * @author Suspir0n
 */
public class dateTest {
    
    @Test
    public void date() throws Exception {
        Date dataAtual = new Date();
        System.out.println("Data sem formatação: " + dataAtual);

        DateFormat dfs = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println(dfs.format(dataAtual)); // 14/03/16

        DateFormat dfm = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println(dfm.format(dataAtual)); // 14/03/2016

        DateFormat dfl = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(dfl.format(dataAtual)); // 14 de Março de 2016

        DateFormat dff = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(dff.format(dataAtual));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(sdf.format(dataAtual)); // 14/03/2016 12:06:56
        
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simple.format(dataAtual)); // 2020-10-19
    }
}
