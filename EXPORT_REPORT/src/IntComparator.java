
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import toolkits.utils.date;
import toolkits.utils.logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP PC
 */
public class IntComparator implements Comparator<Integer> {

    //We must override the compare method with our own logic here.
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
//We can run a quick test using the main method here

    public static void main(String args[]) {

        //Collections.sort(dates.getDates(), new DateComparator());
        String date1 = "septembre 2019";
        String date2 = "d�cembre 2018";
        new logger().OCategory.info(date.DateToString(new Date(), new SimpleDateFormat("MMMM yyyy", Locale.FRENCH)));
        DateComparator letsCompare = new DateComparator();
        System.out.println(letsCompare.compare(date1, date2));
    }

}
