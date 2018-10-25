/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkits;

import java.util.Date;
import java.util.List;
import toolkits.filesmanagers.FilesType.XlsFiles;
import toolkits.filesmanagers.FilesType.model.IxlsModel;
import toolkits.parameters.commonparameter;
import toolkits.utils.StringUtils;
import toolkits.utils.date;
import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 *
 * @author Administrator
 *
 */
public class Main {

    public static void main(String[] args) {

        jdom.InitRessource();
        jdom.LoadRessource();
        String testStr = "";
        Double db = new Double("1.0");

        new logger().OCategory.info("db :  "+db);
        date key = new date();

        new logger().OCategory.info(jdom.APP_NAME);

        XlsFiles OXlsFiles = new XlsFiles();
        OXlsFiles.setPath_input("D:\\JAVA\\PROJECTS\\EXPORT_REPORT_C_C\\DOC\\F01_2017-2018_09-07-2018.xlsx");

       OXlsFiles.InitSplitter(1000);
        
        
        OXlsFiles.setModel(new testModel("", 1));
        OXlsFiles.OIxlsModel.IxlsModelToString();
        List<String> lst = OXlsFiles.LoadDataToFiles();

        for (int i = 1; i < lst.size(); i++) {
            new logger().OCategory.info(lst.get(i));
        }

    }

    public static class testModel implements IxlsModel {

        private String[] oheaderTab;
        private int omainSheet;

        public testModel(String oheaderTab, int omainSheet) {
            this.oheaderTab = StringUtils.split(oheaderTab, commonparameter.SEPARATEUR_POINT_VIRGULE);
            this.omainSheet = omainSheet;
        }

        @Override
        public void IxlsModelToString() {

            new logger().OCategory.info(this.omainSheet + " " + this.oheaderTab.toString());
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int mainSheet() {
            return this.omainSheet;
        }

        @Override
        public String[] header() {
            return this.oheaderTab;
            // String data = "1;2;3;4;5;6;7;8;9";
            // return StringUtils.split(data, commonparameter.SEPARATEUR_POINT_VIRGULE);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
