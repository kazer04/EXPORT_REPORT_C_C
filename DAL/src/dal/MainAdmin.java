/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 *
 * @author thierry
 */
public class MainAdmin {
/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new MainAdmin();
    }

    public MainAdmin() {

        test();
    }

    private void test() {
        jdom.InitRessource();
        jdom.LoadRessource();
        new logger().OCategory.info(jdom.APP_NAME);
        new logger().OCategory.info(jdom.APP_VERSION);


        //TModule OTModule = new TModule();
        // OTModule.get

        dataManager OdataManager = new dataManager();
        OdataManager.initEntityManager();



        OdataManager.closeEntityManager();
    }
}
