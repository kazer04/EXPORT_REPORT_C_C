/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package multilangue;

import toolkits.utils.logger;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Translate oTranslate = new Translate();
       // oTranslate.setLocal_Cty("GB");
       // oTranslate.setLocal_Lg("en");

        new logger().OCategory.info(oTranslate.getValue("CONTACT_US"));
    }

}
