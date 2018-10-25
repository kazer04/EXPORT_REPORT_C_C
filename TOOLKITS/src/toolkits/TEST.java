/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkits;

import java.util.List;
import toolkits.utils.StringUtils;
import toolkits.utils.conversion;
import toolkits.utils.date;
import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 *
 * @author Admin
 */
public class TEST {

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws Exception {
        jdom.InitRessource();
        jdom.LoadRessource();


        date Odate = new date();

        conversion Oconversion = new conversion();



        System.out.println(jdom.APP_VERSION);

      

            new logger().OCategory.info(Oconversion.PhoneNumberFormat("237", "99397034"));

       






    }
}
