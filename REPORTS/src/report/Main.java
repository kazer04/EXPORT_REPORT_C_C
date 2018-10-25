/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import dal.dataManager;
import dal.jconnexion;
import java.util.HashMap;
import java.util.Map;
import multilangue.Translate;
import toolkits.utils.date;
import toolkits.utils.jdom;

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
        //  TCourse OTCourse = OdataManager.getEm().find(TCourse.class, "20111311316204169469");

        //En tete
        parameters.put("P_H_TITTLE", oTranslate.getValue("P_H_TITTLE_PV_PARIS_GAGNANTS"));
        parameters.put("P_H_LOGO", jdom.scr_report_file_logo);

        /* parameters.put("P_lg_Course_ID", OTCourse.getLgCourseID());
         parameters.put("P_str_Number", OTCourse.getStrNumber().toString());
         parameters.put("P_dt_Course_Date", date.DateToString(OTCourse.getDtCourseDate(), date.formatterShort));

         parameters.put("ml_t_winning_str_Type", oTranslate.getValue("ml_t_winning_str_Type"));
         parameters.put("ml_t_person_str_Mobile_Phone", oTranslate.getValue("ml_t_person_str_Mobile_Phone"));
         parameters.put("ml_t_bet_dt_Creation_Date", oTranslate.getValue("ml_t_bet_dt_Creation_Date"));

         parameters.put("ml_t_bet_str_Formula", oTranslate.getValue("ml_t_bet_str_Formula"));
         parameters.put("ml_t_game_str_Initial_Combination", oTranslate.getValue("ml_t_bet_str_Initial_Combination"));
         parameters.put("ml_t_winning_dec_Value", oTranslate.getValue("ml_t_bet_dec_Amount"));
         parameters.put("ml_t_typejeu_str_Libelle", oTranslate.getValue("ml_t_channel_str_LIBELLE"));
         parameters.put("ml_Total_Gain", oTranslate.getValue("ml_Total_Gain"));
        
         */
        scr_report_file = "rp_ville";

        report_tittle = report_tittle + ".pdf";
        //OreportManager.setPath_report_src(Ojdom.scr_report_file + "SOCCER/" + scr_report_file + ".jrxml");
        //OreportManager.setPath_report_pdf(Ojdom.scr_report_pdf + report_tittle);

        OreportManager.setPath_report_src("ELYX_CONF\\REPORTS/" + scr_report_file + ".jrxml");
        OreportManager.setPath_report_pdf("D://" + report_tittle);
        OreportManager.BuildReportPDF(parameters, ojconnexion);

        // OreportManager.BuildRep
        // OcourseManagement.setMessage(commomparameter.PROCESS_FAILED);
        // OcourseManagement.setDetailmessage(report_tittle);
        // response.sendRedirect("../resources/reports/pdf/" + report_tittle);
    }
}
