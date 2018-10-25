/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.    uyrtytrygygg8g8
 */
package bll;

import bll.export_report_cc.ExportReportManager;
import bll.userManagement.authentification;
import dal.TExportCcMontant;
import dal.TExportCcPoids;
import dal.TFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import toolkits.filesmanagers.FilesType.XlsFiles;
import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 *
 * @author Thierry Bekola
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            jdom.InitRessource();
        } catch (Exception ex) {
            new logger().OCategory.info(ex.getMessage());// .getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        jdom.LoadRessource();

        //1 connexion user
        authentification Oauthentification = new authentification();
        if (Oauthentification.loginUser("sandra", "0000") == true) {
            new logger().OCategory.info(Oauthentification.getOTUser().getStrFIRSTNAME());

            // ExportReportManager odttManager = new ExportReportManager();
            // odttManager.loadAndStoreDataTExportCcPoids("D:\\JAVA\\PROJECTS\\EXPORT_REPORT_C_C\\DOC\\Extraction Excel.xlsx");
            XlsFiles OXlsFiles = new XlsFiles();
            OXlsFiles.setPath_input("D:\\JAVA\\PROJECTS\\EXPORT_REPORT_C_C\\DOC\\temp.xlsx");
            ExportReportManager odttManager = new ExportReportManager();
            TFile OOTFile = odttManager.importFileNotProcess(new File(OXlsFiles.getPath_input()));

            OXlsFiles.setModel(new toolkits.Main.testModel("", 1));
            OXlsFiles.OIxlsModel.IxlsModelToString();
            List<String> lst = OXlsFiles.LoadDataToFiles();
            java.util.List<TExportCcMontant> lstTExportCcPoids = new ArrayList<TExportCcMontant>();

            odttManager.setOdataManager(Oauthentification.getOdataManager());

            for (int i = 1; i < lst.size(); i++) {
                new logger().OCategory.info("Traitement des donnees du  fichier " + OOTFile.getStrNAME() + "  " + i + "/" + (lst.size() - 1));

                TExportCcMontant OTExportCcPoids = odttManager.getTExportCcMontantToString(lst.get(i), OOTFile);
                if (OTExportCcPoids != null) {
                    odttManager.store(OTExportCcPoids);
                    lstTExportCcPoids.add(OTExportCcPoids);
                } else {
                    // this.buildErrorTraceMessage(lst.get(i));
                }
                new logger().OCategory.info(lst.get(i));
            }

        } else {
            new logger().OCategory.info(Oauthentification.getDetailmessage());
        }

    }
}
