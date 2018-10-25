/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientservice;

import toolkits.utils.jdom;
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
        webservice Owebservice = new webservice();
        jdom.InitRessource();
        jdom.LoadRessource();


      String Ref=   Owebservice.getData("http://192.168.1.84:8080/gatewayrelevebi/webservices/ws_get_colors_fill.jsp?Reflocalite=dal.TCountries");

      new logger().OCategory.info(Ref);

    }
}
