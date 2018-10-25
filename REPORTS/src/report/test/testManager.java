/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report.test;

import dal.dataManager;
import dal.jconnexion;
import java.util.HashMap;
import java.util.Map;
import multilangue.Translate;
import report.reportManager;
import toolkits.utils.date;
import toolkits.utils.jdom;

/**
 *
 * @author Administrator ytftyf
 */
public class testManager {

    public static void main(String[] args) {
        new testManager().reporAgentList();
    }

    public void reporAgentList() {
        String cust = "bf";
        date key = new date();
        jdom Ojdom = new jdom();
        Ojdom.InitRessource();
        Ojdom.LoadRessource();
        Translate oTranslate = new Translate();
        dataManager OdataManager = new dataManager();
        reportManager OreportManager = new reportManager();
        Map parameters = new HashMap();
        //OdataManager.initEntityManager();

        String scr_report_file = "", report_tittle = "";
        report_tittle = key.getDateTime() + "_" + key.GetNumberRandom();
        jconnexion ojconnexion = new jconnexion();
        ojconnexion.initConnexion();
        ojconnexion.OpenConnexion();

        //En tete
        parameters.put("P_H_TITTLE", oTranslate.getValue("%%"));
        /*parameters.put("P_H_LOGO", jdom.scr_report_file_logo);
         parameters.put("ml_CODE_AGENT", oTranslate.getValue("%%"));
         parameters.put("ml_AGENT_NAME", oTranslate.getValue("%%"));
         parameters.put("ml_AGENT_NUMBER", oTranslate.getValue("%%"));
         parameters.put("ml_SIM", oTranslate.getValue("%%"));
         parameters.put("ml_PRINTER", oTranslate.getValue("%%"));
         parameters.put("ml_PHONE", oTranslate.getValue("%%"));
         parameters.put("ml_ZONE", oTranslate.getValue("%%"));
         parameters.put("ml_REGION", oTranslate.getValue("%%"));
         parameters.put("ml_VILLE", oTranslate.getValue("%%"));
         parameters.put("ml_KIOSK", oTranslate.getValue("%%"));

         parameters.put("P_ZONE", oTranslate.getValue("%%"));
         parameters.put("P_REGION", oTranslate.getValue("%%"));
         parameters.put("P_KIOSK", oTranslate.getValue("%%"));
         */
        scr_report_file = "rp_I1";

        report_tittle = report_tittle + ".pdf";
        OreportManager.setPath_report_src(Ojdom.scr_report_file + scr_report_file + ".jrxml");
        OreportManager.setPath_report_pdf("D://" + report_tittle);
        OreportManager.BuildReportPDF(parameters, ojconnexion);

    }

    /* public void reportListParis() {
     date key = new date();
     jdom Ojdom = new jdom();
     Ojdom.InitRessource();
     Ojdom.LoadRessource();
     Translate oTranslate = new Translate();
     dataManager OdataManager = new dataManager();
     reportManager OreportManager = new reportManager();
     Map parameters = new HashMap();
     //OdataManager.initEntityManager();


     String scr_report_file = "", report_tittle = "";
     report_tittle = key.getDateTime() + "_" + key.GetNumberRandom();
     jconnexion ojconnexion = new jconnexion();
     ojconnexion.initConnexion();;
     ojconnexion.OpenConnexion();

     //En tete
     parameters.put("P_H_TITTLE", oTranslate.getValue("%%"));
     parameters.put("P_H_LOGO", jdom.scr_report_file_logo);
     parameters.put("P_H_COURSE", oTranslate.getValue("%%"));
     parameters.put("P_H_DATE", oTranslate.getValue("%%"));
     parameters.put("ml_REFERENCE", oTranslate.getValue("%%"));
     parameters.put("ml_DATE", oTranslate.getValue("%%"));
     parameters.put("ml_PICK", oTranslate.getValue("%%"));
     parameters.put("ml_AMOUNT", oTranslate.getValue("%%"));
     parameters.put("ml_STATUT", oTranslate.getValue("%%"));
     parameters.put("ml_TYPE_PARI",oTranslate.getValue("%%"));
     parameters.put("ml_POOL_CODE", oTranslate.getValue("%%"));
     parameters.put("ml_POOL_ID", oTranslate.getValue("%%"));

     parameters.put("P_AGENT", oTranslate.getValue("%%"));
     parameters.put("P_BET_TYPE", oTranslate.getValue("%%"));
     parameters.put("P_CHANNEL", oTranslate.getValue("%%"));
     parameters.put("P_PARIEUR", oTranslate.getValue("%%"));
     parameters.put("P_POOL_CODE", oTranslate.getValue("%%"));
     parameters.put("P_STATUT", oTranslate.getValue("%%"));
     parameters.put("P_DATE_DEBUT", oTranslate.getValue("%%"));
     parameters.put("P_DATE_FIN", oTranslate.getValue("%%"));
     scr_report_file = "rp_soccer_bet";


     report_tittle = report_tittle + ".pdf";
     OreportManager.setPath_report_src(Ojdom.scr_report_file + "SOCCER/" + scr_report_file + ".jrxml");
     OreportManager.setPath_report_pdf("D://testresult//" + report_tittle);
     OreportManager.BuildReportPDF(parameters, ojconnexion);



     }*/
    public void reportAgentAccount() {
        date key = new date();
        String cust = "bf";
        jdom Ojdom = new jdom();
        Ojdom.InitRessource();
        Ojdom.LoadRessource();
        Translate oTranslate = new Translate();
        dataManager OdataManager = new dataManager();
        reportManager OreportManager = new reportManager();
        Map parameters = new HashMap();
        //OdataManager.initEntityManager();

        String scr_report_file = "", report_tittle = "";
        report_tittle = key.getDateTime() + "_" + key.GetNumberRandom();
        jconnexion ojconnexion = new jconnexion();
        ojconnexion.initConnexion();;
        ojconnexion.OpenConnexion();

        //En tete
        parameters.put("P_H_TITTLE", oTranslate.getValue("%%"));
        parameters.put("P_H_LOGO", jdom.scr_report_file_logo);
        parameters.put("P_H_COURSE", oTranslate.getValue("%%"));
        parameters.put("ml_AGENT_ID", oTranslate.getValue("%%"));
        parameters.put("ml_AGENT_NAME", oTranslate.getValue("%%"));
        parameters.put("ml_KIOSK_LOCATION", oTranslate.getValue("%%"));
        parameters.put("ml_ZONE_NAME", oTranslate.getValue("%%"));
        parameters.put("ml_BALANCE", oTranslate.getValue("%%"));
        parameters.put("ml_PRODUCT_NAME", oTranslate.getValue("%%"));
        parameters.put("P_AGENT_ID", oTranslate.getValue("%%"));
        parameters.put("P_DEC_BALANCE", oTranslate.getValue("%%"));
        parameters.put("P_ZONE", oTranslate.getValue("%%"));
        parameters.put("P_PRODUCT_NAME", oTranslate.getValue("%%"));

        scr_report_file = "rp_soccer_agent_account";

        report_tittle = report_tittle + ".pdf";
        OreportManager.setPath_report_src(Ojdom.scr_report_file + "SOCCER/" + scr_report_file + ".jrxml");
        OreportManager.setPath_report_pdf("D://testresult//" + report_tittle);
        OreportManager.BuildReportPDF(parameters, ojconnexion);

    }

    public void reportParieur() {
        date key = new date();

        String cust = "bf";
        jdom Ojdom = new jdom();
        Ojdom.InitRessource();
        Ojdom.LoadRessource();
        Translate oTranslate = new Translate();
        dataManager OdataManager = new dataManager();
        reportManager OreportManager = new reportManager();
        Map parameters = new HashMap();
        //OdataManager.initEntityManager();

        String scr_report_file = "", report_tittle = "";
        report_tittle = key.getDateTime() + "_" + key.GetNumberRandom();
        jconnexion ojconnexion = new jconnexion();
        ojconnexion.initConnexion();
        ojconnexion.OpenConnexion();

        //En tete
        parameters.put("P_H_TITTLE", oTranslate.getValue("%%"));
        parameters.put("P_H_LOGO", jdom.scr_report_file_logo);

        parameters.put("ml_PARIEUR_ID", oTranslate.getValue("%%"));
        parameters.put("ml_NAME", oTranslate.getValue("%%"));
        parameters.put("ml_LOGIN", oTranslate.getValue("%%"));
        parameters.put("ml_MOBILE", oTranslate.getValue("%%"));
        parameters.put("ml_STATUT", oTranslate.getValue("%%"));
        parameters.put("ml_LAST_CONNECTION", oTranslate.getValue("%%"));
        parameters.put("ml_CREATION_DATE", oTranslate.getValue("%%"));
        parameters.put("P_NAME", oTranslate.getValue("%%"));
        parameters.put("P_LOGIN", oTranslate.getValue("%%"));
        parameters.put("P_STATUT", oTranslate.getValue("%%"));

        parameters.put("P_CREATION_DATE", oTranslate.getValue("%%"));
        parameters.put("P_PERIODE_DEBUT", oTranslate.getValue("2010-01-15 09:34:07"));
        parameters.put("P_PERIODE_FIN", oTranslate.getValue("2013-01-15 09:34:07"));
        parameters.put("P_LAST_CONNECTION", oTranslate.getValue("%%"));

        scr_report_file = "rp_parieur";

        report_tittle = report_tittle + ".pdf";
        OreportManager.setPath_report_src(Ojdom.scr_report_file + "SOCCER/" + scr_report_file + ".jrxml");
        OreportManager.setPath_report_pdf("D://testresult//" + report_tittle);
        OreportManager.BuildReportPDF(parameters, ojconnexion);

    }

    public void reportBet() {
        date key = new date();
        jdom Ojdom = new jdom();
        String cust = "bf";
        Ojdom.InitRessource();
        Ojdom.LoadRessource();
        Translate oTranslate = new Translate();
        dataManager OdataManager = new dataManager();
        reportManager OreportManager = new reportManager();
        Map parameters = new HashMap();
        //OdataManager.initEntityManager();

        String scr_report_file = "", report_tittle = "";
        report_tittle = key.getDateTime() + "_" + key.GetNumberRandom();
        jconnexion ojconnexion = new jconnexion();
        ojconnexion.initConnexion();;
        ojconnexion.OpenConnexion();

        //En tete
        parameters.put("P_H_TITTLE", oTranslate.getValue("%%"));
        parameters.put("P_H_LOGO", jdom.scr_report_file_logo);

        parameters.put("P_H_COURSE", oTranslate.getValue("%%"));
        parameters.put("P_H_DATE", oTranslate.getValue("%%"));
        parameters.put("ml_REFERENCE", oTranslate.getValue("%%"));
        parameters.put("ml_DATE", oTranslate.getValue("%%"));
        parameters.put("ml_PICK", oTranslate.getValue("%%"));
        parameters.put("ml_AMOUNT", oTranslate.getValue("%%"));
        parameters.put("ml_STATUT", oTranslate.getValue("%%"));
        parameters.put("ml_TYPE_PARI", oTranslate.getValue("%%"));
        parameters.put("ml_POOL_CODE", oTranslate.getValue("%%"));
        parameters.put("ml_POOL_ID", oTranslate.getValue("%%"));
        parameters.put("ml_PHONE", oTranslate.getValue("%%"));
        parameters.put("P_AGENT", oTranslate.getValue("%%"));
        parameters.put("P_BET_TYPE", oTranslate.getValue("%%"));
        parameters.put("P_CHANNEL", oTranslate.getValue("%%"));

        parameters.put("P_PARIEUR", oTranslate.getValue("%%"));
        parameters.put("P_POOL_CODE", oTranslate.getValue("%%"));
        parameters.put("P_STATUT", oTranslate.getValue("%%"));
        parameters.put("P_DATE_DEBUT", oTranslate.getValue("2010-01-15 09:34:07"));
        parameters.put("P_DATE_FIN", oTranslate.getValue("2013-01-15 09:34:07"));

        scr_report_file = "rp_soccer_bet";

        report_tittle = report_tittle + ".pdf";
        OreportManager.setPath_report_src(Ojdom.scr_report_file + "SOCCER/" + scr_report_file + ".jrxml");
        OreportManager.setPath_report_pdf("D://testresult//" + report_tittle);
        OreportManager.BuildReportPDF(parameters, ojconnexion);

    }

    public void reportTotalVentes() {
        String cust = "bf";
        date key = new date();
        jdom Ojdom = new jdom();
        Ojdom.InitRessource();
        Ojdom.LoadRessource();
        Translate oTranslate = new Translate();
        dataManager OdataManager = new dataManager();
        reportManager OreportManager = new reportManager();
        Map parameters = new HashMap();
        //OdataManager.initEntityManager();

        String scr_report_file = "", report_tittle = "";
        report_tittle = key.getDateTime() + "_" + key.GetNumberRandom();
        jconnexion ojconnexion = new jconnexion();
        ojconnexion.initConnexion();;
        ojconnexion.OpenConnexion();

        //En tete
        parameters.put("P_H_TITTLE", oTranslate.getValue("%%"));
        parameters.put("P_H_LOGO", jdom.scr_report_file_logo);

        parameters.put("ml_AGENT_ID", oTranslate.getValue("%%"));
        parameters.put("ml_AGENT_NAME", oTranslate.getValue("%%"));
        parameters.put("ml_POOL_TYPE", oTranslate.getValue("%%"));
        parameters.put("ml_ZONE", oTranslate.getValue("%%"));
        parameters.put("ml_VILLE", oTranslate.getValue("%%"));
        parameters.put("ml_REGION", oTranslate.getValue("%%"));
        parameters.put("ml_KIOSK", oTranslate.getValue("%%"));
        parameters.put("ml_MONTANT", oTranslate.getValue("%%"));
        parameters.put("P_PERIODE_DEBUT", oTranslate.getValue("2010-01-15 09:34:07"));
        parameters.put("P_PERIODE_FIN", oTranslate.getValue("2013-01-15 09:34:07"));
        parameters.put("P_AGENT_ID", oTranslate.getValue("%%"));
        parameters.put("P_ZONE", oTranslate.getValue("%%"));
        parameters.put("P_VILLE", oTranslate.getValue("%%"));
        parameters.put("P_REGION", oTranslate.getValue("%%"));

        parameters.put("P_KIOSK", oTranslate.getValue("%%"));
        parameters.put("P_POOL_TYPE", oTranslate.getValue("%%"));

        scr_report_file = "rp_total_ventes";

        report_tittle = report_tittle + ".pdf";
        OreportManager.setPath_report_src(Ojdom.scr_report_file + "SOCCER/" + scr_report_file + ".jrxml");
        OreportManager.setPath_report_pdf("D://testresult//" + report_tittle);
        OreportManager.BuildReportPDF(parameters, ojconnexion);

    }

    public void reportTransactionAgentDetail() {
        String cust = "bf";
        date key = new date();
        jdom Ojdom = new jdom();
        Ojdom.InitRessource();
        Ojdom.LoadRessource();
        Translate oTranslate = new Translate();
        dataManager OdataManager = new dataManager();
        reportManager OreportManager = new reportManager();
        Map parameters = new HashMap();
        //OdataManager.initEntityManager();

        String scr_report_file = "", report_tittle = "";
        report_tittle = key.getDateTime() + "_" + key.GetNumberRandom();
        jconnexion ojconnexion = new jconnexion();
        ojconnexion.initConnexion();;
        ojconnexion.OpenConnexion();

        //En tete
        parameters.put("P_H_TITTLE", oTranslate.getValue("%%"));
        parameters.put("P_H_LOGO", jdom.scr_report_file_logo);

        parameters.put("P_ZONE", oTranslate.getValue("%%"));
        parameters.put("P_REGION", oTranslate.getValue("%%"));
        parameters.put("P_PERIODE_DEBUT", oTranslate.getValue("%%"));
        parameters.put("P_PERIODE_FIN", oTranslate.getValue("%%"));
        parameters.put("P_AGENT", oTranslate.getValue("%%"));
        parameters.put("P_PRODUCT", oTranslate.getValue("%%"));
        parameters.put("ml_DATE", oTranslate.getValue("%%"));
        parameters.put("ml_AGENT_ID", oTranslate.getValue("%%"));
        parameters.put("ml_AGENT_NAME", oTranslate.getValue("2010-01-15 09:34:07"));
        parameters.put("ml_ZONE", oTranslate.getValue("2013-01-15 09:34:07"));
        parameters.put("ml_REGION", oTranslate.getValue("%%"));
        parameters.put("ml_MONTANT", oTranslate.getValue("%%"));
        parameters.put("ml_PRODUCT", oTranslate.getValue("%%"));
        parameters.put("P_KIOSK", oTranslate.getValue("%%"));

        scr_report_file = "rp_transaction_agent_detail";

        report_tittle = report_tittle + ".pdf";
        OreportManager.setPath_report_src(Ojdom.scr_report_file + "SOCCER/" + scr_report_file + ".jrxml");
        OreportManager.setPath_report_pdf("D://testresult//" + report_tittle);
        OreportManager.BuildReportPDF(parameters, ojconnexion);

    }

    public void reportTransactionAgentTotal() {
        String cust = "bf";
        date key = new date();
        jdom Ojdom = new jdom();
        Ojdom.InitRessource();
        Ojdom.LoadRessource();
        Translate oTranslate = new Translate();
        dataManager OdataManager = new dataManager();
        reportManager OreportManager = new reportManager();
        Map parameters = new HashMap();
        //OdataManager.initEntityManager();

        String scr_report_file = "", report_tittle = "";
        report_tittle = key.getDateTime() + "_" + key.GetNumberRandom();
        jconnexion ojconnexion = new jconnexion();
        ojconnexion.initConnexion();;
        ojconnexion.OpenConnexion();

        //En tete
        parameters.put("P_H_TITTLE", oTranslate.getValue("%%"));
        parameters.put("P_H_LOGO", jdom.scr_report_file_logo);

        parameters.put("P_DATE", oTranslate.getValue("%%"));
        parameters.put("ml_MONTANT", oTranslate.getValue("%%"));
        parameters.put("ml_PRODUCT", oTranslate.getValue("%%"));
        parameters.put("ml_AGENT", oTranslate.getValue("%%"));
        parameters.put("P_ZONE", oTranslate.getValue("%%"));
        parameters.put("P_VILLE", oTranslate.getValue("%%"));
        parameters.put("P_KIOSK", oTranslate.getValue("%%"));

        scr_report_file = "rp_transaction_payment_total";

        report_tittle = report_tittle + ".pdf";
        OreportManager.setPath_report_src(Ojdom.scr_report_file + "SOCCER/" + scr_report_file + ".jrxml");
        OreportManager.setPath_report_pdf("D://testresult//" + report_tittle);
        OreportManager.BuildReportPDF(parameters, ojconnexion);

    }

}
