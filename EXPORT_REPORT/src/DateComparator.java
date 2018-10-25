
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
public class DateComparator implements Comparator<String> {

    //We must override the compare method with our own logic here.
    public int compare(String o1, String o2) {

        //Define the 2 date objects that we are going to compare
        Date dateObj1 = null;
        Date dateObj2 = null;

        try {
            //We'll convert our strings to date objects here using SimpleDateFormat. Simply update the "MM-yyyy" to handle whatever format your date string is
            dateObj1 = new SimpleDateFormat("MMMM yyyy", Locale.FRENCH).parse(o1);
            dateObj2 = new SimpleDateFormat("MMMM yyyy", Locale.FRENCH).parse(o2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //This will return -1,0 or 1 for less than, equal to, or greater than, meaning obj1 is either less than, equal to, or greater then obj2
        return dateObj1.compareTo(dateObj2);
    }
//We can run a quick test using the main method here

	public static void main(String args[])
	{
		
        //Collections.sort(dates.getDates(), new DateComparator());
		String date1="septembre 2019";
		String date2="décembre 2018";
		new logger().OCategory.info(date.DateToString(new Date(), new SimpleDateFormat("MMMM yyyy", Locale.FRENCH)));
		DateComparator letsCompare=new DateComparator();
		System.out.println(letsCompare.compare(date1, date2));
	}
	
}
