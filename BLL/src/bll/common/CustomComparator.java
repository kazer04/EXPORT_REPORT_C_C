/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.common;

import java.util.Comparator;
import org.apache.bcel.generic.DALOAD;

/**
 *
 * @author HP PC
 */
public class CustomComparator implements Comparator<Object> {

    public CustomComparator() {
    }

    @Override
    public int compare(Object o1, Object o2) {
        Integer i1 = 0;
        try {
          //  i1 = new Double(o1.intAmount * 100).intValue() / new Double(o1.intQuantity * 1).intValue();

        } catch (Exception e) {

        }

        Integer i2 = 0;
        try {
            //i2 = new Double(o2.intAmount * 100).intValue() / new Double(o2.intQuantity * 1).intValue();
        } catch (Exception e) {

        }

        return (i1).compareTo(i2);

    }

}
