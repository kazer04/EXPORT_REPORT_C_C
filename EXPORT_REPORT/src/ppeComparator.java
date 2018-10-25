
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
public class ppeComparator implements Comparator<String> {

    //We must override the compare method with our own logic here.
    public int compare(String o1, String o2) {

        if (o1.equals("A_POIDS_THEORIQUE")) {
            o1 = "POIDS THEORIQUE";
        } else if (o1.equals("B_POIDS_REEL")) {
            o1 = "POIDS REEL";
        }
        if (o1.equals("C_ECART")) {
            o1 = "ECART";
        }

        if (o1.equals("A_POIDS_THEORIQUE")) {
            o1 = "POIDS THEORIQUE";
        } else if (o1.equals("B_POIDS_REEL")) {
            o1 = "POIDS REEL";
        }
        if (o1.equals("C_ECART")) {
            o1 = "ECART";
        }

        //This will return -1,0 or 1 for less than, equal to, or greater than, meaning obj1 is either less than, equal to, or greater then obj2
        return o1.compareTo(o2);
    }
//We can run a quick test using the main method here

    public static void main(String args[]) {

        //Collections.sort(dates.getDates(), new DateComparator());
        String date1 = "septembre 2019";
        String date2 = "décembre 2018";
        new logger().OCategory.info(date.DateToString(new Date(), new SimpleDateFormat("MMMM yyyy", Locale.FRENCH)));
        DateComparator letsCompare = new DateComparator();
        System.out.println(letsCompare.compare(date1, date2));
    }

}
