package config_editor.ui.ligneMaritimes;


import config_editor.security.File.ConfigItemVO;
import config_editor.security.User.*;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.util.java.Consts;
import java.sql.*;
import org.openswing.swing.message.receive.java.*;
import org.openswing.swing.mdi.client.MDIFrame;
import toolkits.filesmanagers.FilesType.CsvFiles;
import toolkits.parameters.commonparameter;
import toolkits.security.Cryptages;
import toolkits.utils.date;
import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 * <p>
 * Title: OpenSwing Framework</p>
 * <p>
 * Description: Detail frame controller for the employee</p>
 * <p>
 * Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p>
 * </p> @author Mauro Carniel
 *
 * @version 1.0
 */
public class LigneMaritimesUpdateFrameControllerM1 extends FormController {

    private LigneMaritimesGridFramesM1 frame = null;
    private String pk = null;
    Cryptages ocryptage = new Cryptages();

    public LigneMaritimesUpdateFrameControllerM1(String pk) {
        this.pk = pk;
        frame = new LigneMaritimesGridFramesM1(this);
        MDIFrame.add(frame);

        if (pk != null) {
            frame.getMainPanel().setMode(Consts.READONLY);
            frame.getMainPanel().reload();
        } else {
            frame.getMainPanel().setMode(Consts.INSERT);
        }

    }

    /**
     * This method must be overridden by the subclass to retrieve data and
     * return the valorized value object.
     *
     * @param valueObjectClass value object class
     * @return a VOResponse object if data loading is successfully completed, or
     * an ErrorResponse object if an error occours
     */
    public Response loadData(Class valueObjectClass) {

        try {
            jdom.InitRessource();
            jdom.LoadRessource();

            ConfigItemVO vo = new ConfigItemVO();

            vo.setAPP_NAME(jdom.APP_NAME);
            vo.setAPP_RELOAD_ALL(jdom.APP_RELOAD_ALL);
            vo.setAPP_VERSION(jdom.APP_VERSION);

            //MYSQL DATA BASE
            vo.setArs_database_host(ocryptage.decryptage(jdom.ars_database_host));
            vo.setArs_database_name(ocryptage.decryptage(jdom.ars_database_name));
            vo.setArs_database_user_name(ocryptage.decryptage(jdom.ars_database_user_name));
            vo.setArs_database_user_password(ocryptage.decryptage(jdom.ars_database_user_password));
            vo.setArs_database_port(ocryptage.decryptage(jdom.ars_database_port + "").toString());

            //KANNEL
            vo.setKannel_ip(ocryptage.decryptage(jdom.clickatell_IP));
            //vo.setKannel_default_port(ocryptage.decryptage(jdom.kannel_default_port));
            vo.setKannel_user(ocryptage.decryptage(jdom.clickatell_User));
            vo.setKannel_pwd(ocryptage.decryptage(jdom.clickatell_Password));
            vo.setKannel_port(ocryptage.decryptage(new Integer(jdom.clickatell_phone_number).toString()));

            //PARIS SMS SERVEUR
            vo.setNb_Max_in_Pool(ocryptage.decryptage(new Integer(jdom.nb_Max_in_Pool).toString()));
            vo.setBREAKER_HOST(ocryptage.decryptage(jdom.BREAKER_HOST));
            vo.setBREAKER_PORT(ocryptage.decryptage(new Integer(jdom.BREAKER_PORT).toString()));
            vo.setBREAKER_SEPARATOR(ocryptage.decryptage(jdom.BREAKER_SEPARATOR));

            //AUTRES
            vo.setParis_portal_link(ocryptage.decryptage(jdom.APP_NAME));

            vo.setScr_report_file(ocryptage.decryptage(jdom.scr_report_file));
            vo.setScr_report_file_logo(ocryptage.decryptage(jdom.path_file_generate_absolute_imported));
            vo.setLog_file(ocryptage.decryptage(jdom.log_file));

            return new VOResponse(new GridLigneMaritimesVOM1());

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        }

    }

    /**
     * Callback method called when the data loading is completed.
     *
     * @param error <code>true</code> if an error occours during data loading,
     * <code>false</code> if data loading is successfully completed
     */
    public void loadDataCompleted(boolean error) {
        //   frame.getControlCurrency().setCurrencySymbol("$");
        //  frame.getControlCurrency().setDecimals(2);
        //  frame.getControlCurrency().setDecimalSymbol('.');
        //  frame.getControlCurrency().setGroupingSymbol(',');
    }

    /**
     * Method called by the Form panel to insert new data.
     *
     * @param newValueObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            UserVO vo = (UserVO) newPersistentObject;
            if (vo.getPassword().equals("")) {
                new logger().OCategory.info("le pass est  est vide");
                return new ErrorResponse("le pass est  est vide");
            }
            //  Ouser.createUser(Ouser.getKey().getSimpletimeid(), vo.getStrLOGIN(), vo.getStrPASSWORD(), vo.getStrFIRSTNAME(), vo.getStrLASTNAME(), vo.getLgROLEID());

            pk = vo.getFirstname();
            return new VOResponse(vo);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
        }

    }

    /**
     * Method called by the Form panel to update existing data.
     *
     * @param oldPersistentObject original value object, previous to the changes
     * @param persistentObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {

            Cryptages ocryptage = new Cryptages();
            GridLigneMaritimesVOM1 vo = (GridLigneMaritimesVOM1) persistentObject;

            String Odata = this.getModelDataFile();
            String tabData[] = Odata.split(commonparameter.SEPARATEUR_POINT_VIRGULE);
            new logger().OCategory.info("Au debut Odata " + Odata);
            new logger().OCategory.info("Au debut tabData.length " + tabData.length);
            vo.setPoids_vgm(vo.getPoids_pesee_2() - vo.getPoids_pesee_1());

            int intVal = vo.getPoids_pesee_1() - vo.getPoids_pesee_2();
            if (intVal < 0) {
                intVal = vo.getPoids_pesee_2() - vo.getPoids_pesee_1();
            }

            vo.setPoids_vgm(intVal);
            /*
             if (vo.getPoids_pesee_1() >= vo.getPoids_pesee_2()) {

             new logger().OCategory.info("Le poids P1 ne peut etre supperieur ou egale a P2");
             return new ErrorResponse(("Le poids P1 ne peut etre supperieur a P2"));

             }
             */
            vo.setHeur_2_pessee(vo.getHeur().toString() + ":" + vo.getMin().toString());

            if (vo.getCompagnie_maritime() == null) {
                vo.setCompagnie_maritime("");
            }

            if (vo.getMethode_pesee_vgm() == null) {
                vo.setMethode_pesee_vgm("");
            }
            Odata = Odata.replace("[" + vo.KEY_agent_ci + "]", vo.getAgent_ci());
            Odata = Odata.replace("[" + vo.KEY_chargeur + "]", vo.getChargeur());
            Odata = Odata.replace("[" + vo.KEY_compagnie_maritime + "]", vo.getCompagnie_maritime());
            Odata = Odata.replace("[" + vo.KEY_heur_2_pessee + "]", vo.getHeur_2_pessee());
            Odata = Odata.replace("[" + vo.KEY_methode_pesee_vgm + "]", vo.getMethode_pesee_vgm());
            Odata = Odata.replace("[" + vo.KEY_navire + "]", vo.getNavire());
            Odata = Odata.replace("[" + vo.KEY_num_booking + "]", vo.getNum_booking());
            Odata = Odata.replace("[" + vo.KEY_num_conteneur + "]", vo.getNum_conteneur());
            Odata = Odata.replace("[" + vo.KEY_num_plomb + "]", vo.getNum_plomb());
            Odata = Odata.replace("[" + vo.KEY_num_transitaire + "]", vo.getNum_transitaire());
            Odata = Odata.replace("[" + vo.KEY_num_voyage + "]", vo.getNum_voyage());
            Odata = Odata.replace("[" + vo.KEY_pesseur + "]", vo.getPesseur());
            Odata = Odata.replace("[" + vo.KEY_port_debarq + "]", vo.getPort_debarq());
            Odata = Odata.replace("[" + vo.KEY_produit + "]", vo.getProduit());
            Odata = Odata.replace("[" + vo.KEY_poids_pesee_1 + "]", vo.getPoids_pesee_1() + "");
            Odata = Odata.replace("[" + vo.KEY_poids_pesee_2 + "]", vo.getPoids_pesee_2() + "");
            Odata = Odata.replace("[" + vo.KEY_poids_vgm + "]", vo.getPoids_vgm() + "");
            Odata = Odata.replace("[" + vo.KEY_date_2_pessee + "]", new date().DateToString(vo.getDate_2_pessee(), date.formatterMysqlShort));
            Odata = Odata.replace("[" + vo.KEY_num_ticket_pesee + "]", vo.getNum_ticket_pesee().toString());
            // Odata = Odata.replace("[" + vo.KEY_agent_ci + "]", vo.getAgent_ci());
            // Odata = Odata.replace("[" + vo.KEY_agent_ci + "]", vo.getAgent_ci());
            tabData = Odata.split(commonparameter.SEPARATEUR_POINT_VIRGULE);
            new logger().OCategory.info("SPPET 1  Odata " + Odata);
            new logger().OCategory.info("SPPET 1 tabData.length " + tabData.length);
            for (int i = 0; i < Odata.length(); i++) {
                Odata = Odata.replace("[" + i + "]", " ");

            }
            tabData = Odata.split(commonparameter.SEPARATEUR_POINT_VIRGULE);
            new logger().OCategory.info("FIN 1  Odata " + Odata);
            new logger().OCategory.info("FIN 1 tabData.length " + tabData.length);
            //  new logger().OCategory.info("Savegarde " + vo.getNum_ticket_pesee());

            String ItemData = int_POS_1 + commonparameter.SEPARATEUR_POINT_VIRGULE
                    + int_POS_9 + commonparameter.SEPARATEUR_POINT_VIRGULE
                    + int_POS_31 + commonparameter.SEPARATEUR_POINT_VIRGULE
                    + int_POS_33 + commonparameter.SEPARATEUR_POINT_VIRGULE
                    + int_POS_39 + commonparameter.SEPARATEUR_POINT_VIRGULE
                    + int_POS_41 + commonparameter.SEPARATEUR_POINT_VIRGULE
                    + int_POS_42 + commonparameter.SEPARATEUR_POINT_VIRGULE
                    + int_POS_46 + commonparameter.SEPARATEUR_POINT_VIRGULE
                    + int_POS_47 + commonparameter.SEPARATEUR_POINT_VIRGULE;

            String tabDataPosit[] = ItemData.split(commonparameter.SEPARATEUR_POINT_VIRGULE);
            tabData = Odata.split(commonparameter.SEPARATEUR_POINT_VIRGULE);

            for (int k = 0; k < tabDataPosit.length; k++) {
                new logger().OCategory.info(k + " tabDataPosit.length  : " + tabDataPosit.length + "    tabData : " + tabData.length);
                new logger().OCategory.info("--->" + k + " new Integer(tabDataPosit[k]) :" + new Integer(tabDataPosit[k]));

                if (tabData[new Integer(tabDataPosit[k])].equals("")) {
                    new logger().OCategory.info("Des champ son obligatoire Position :" + tabDataPosit[k]);
                    return new ErrorResponse(this.getError(tabDataPosit[k], vo));
                }

            }

            /*
             String ItemData = vo.getNum_ticket_pesee() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getChargeur() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getPoids_pesee_1() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getPoids_pesee_2() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + new date().DateToString(vo.getDate_2_pessee(), date.formatterMysql) + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getHeur_2_pessee() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getProduit() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getNum_conteneur() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getNum_plomb() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getNum_booking() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getNum_transitaire() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getCompagnie_maritime() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getNavire() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getPort_debarq() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getPesseur() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getAgent_ci() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getPoids_vgm() + "" + commonparameter.SEPARATEUR_POINT_VIRGULE
             + vo.getMethode_pesee_vgm();
            
             */
            String messageData = Odata;
            CsvFiles OTxtFiles = new CsvFiles();
            OTxtFiles.setPath_outut(jdom.temp_folder + "/" + new date().getComplexId());
            OTxtFiles.SaveToFile(messageData);
/*
            pdfManager OpdfManager = new pdfManager();
            OpdfManager.BuilderPdf(messageData);
*/

            /*

             XmlFiles OXmlFiles = new XmlFiles("users", "users.xml");

             OXmlFiles.updateFiled("firstname", ocryptage.cryptage(vo.getFirstname()));
             OXmlFiles.updateFiled("lastname", ocryptage.cryptage(vo.getLastname()));
             OXmlFiles.updateFiled("password", ocryptage.cryptage(vo.getPassword()));
             OXmlFiles.updateFiled("user_name", ocryptage.cryptage(vo.getUser_name()));

             OXmlFiles.commit();

             jdom.InitRessource();
             jdom.LoadRessource();
             */
            /*
             vo.setPassword(ocryptage.decryptage(OXmlFiles.FindField("password")));
             vo.setUser_name(ocryptage.decryptage(OXmlFiles.FindField("user_name")));
             vo.setFirstname(ocryptage.decryptage(OXmlFiles.FindField("firstname")));
             vo.setLastname(ocryptage.decryptage(OXmlFiles.FindField("lastname")));
             */
            //new logger().OCategory.info(Ouser.getMessage());
            return new VOResponse(vo);

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        }
    }

    /**
     * Method called by the Form panel to delete existing data.
     *
     * @param persistentObject value object to delete
     * @return an ErrorResponse value object in case of errors, VOResponse if
     * the operation is successfully completed
     */
    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            // stmt = conn.prepareStatement("delete from EMP where EMP_CODE=?");
            UserVO vo = (UserVO) persistentObject;
            //stmt.setString(1,vo.getEmpCode());
            stmt.execute();
            return new VOResponse(vo);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());

        }
    }

    public String getModelDataFile() {
        String strTat = "TAN IVOIRE SA;;2016:04:23:00:00:00;9820;2016:04:23:00:00:00;;160423128;30900;2016:04:23:00:00:00;;;18597;310;177;;26;;2280;;;Caf‚;;;;;VRIDI 2;;;3116GL01;;MEDU 343259-3;;8446634;;;;;;955827707;;AJC;MSC ROSSELLA;;MARIE;KANGA ROLAND;21080;1;2015 - 2016;2015 - 2016;TAN IVOIRE SA;3011;Vert;B.A.L. VRIDI 3;SAC EXPORT;Abidjan;ALGESIRAS;;;;end";
        String[] tabData = strTat.split(commonparameter.SEPARATEUR_POINT_VIRGULE);
        for (int i = 0; i < tabData.length; i++) {
            tabData[i] = "[" + i + "]";
        }
        strTat = "";
        for (int i = 0; i < tabData.length; i++) {
            if (i == 0) {
                strTat = tabData[i];

            } else {
                strTat = strTat + commonparameter.SEPARATEUR_POINT_VIRGULE + tabData[i];
            }
        }
        // new logger().OCategory.info(strTat);
        return strTat;
    }

    public int int_POS_1 = 1 - 1;
    public int int_POS_9 = 9 - 1;
    public int int_POS_31 = 31 - 1;
    public int int_POS_33 = 33 - 1;
    public int int_POS_39 = 39 - 1;
    public int int_POS_41 = 41 - 1;
    public int int_POS_42 = 42 - 1;
    public int int_POS_46 = 46 - 1;
    public int int_POS_47 = 47 - 1;

    public String getError(String intOval, GridLigneMaritimesVOM1 vo) {
        new logger().oCategory.info("intOval : " + intOval);
        int Oval = new Integer(intOval);

        if (Oval == (vo.KEY_date_2_pessee)) {
            return "Date de Pese";
        }

        if (Oval == (vo.KEY_agent_ci)) {
            return "Agent Ci";
        }

        if (Oval == (vo.KEY_chargeur)) {
            return "Chargeur";
        }

        if (Oval == (vo.KEY_compagnie_maritime)) {
            return "Compagnie maritime";
        }

        if (Oval == (vo.KEY_navire)) {
            return "Navire";
        }

        if (Oval == (vo.KEY_num_booking)) {
            return "N°Booking";
        }

        if (Oval == (vo.KEY_num_conteneur)) {
            return "N° Conteneur";
        }

        if (Oval == (vo.KEY_num_plomb)) {
            return "N°Plomb";
        }

        if (Oval == (vo.KEY_num_ticket_pesee)) {
            return "N° Ticket Pesee";
        }

        if (Oval == (vo.KEY_num_transitaire)) {
            return "N° Transitaire";
        }

        if (Oval == (vo.KEY_num_voyage)) {
            return "N° Voyage";
        }

        if (Oval == (vo.KEY_pesseur)) {
            return "Pesseur";
        }

        if (Oval == (vo.KEY_poids_pesee_1)) {
            return "Poids Pesse 1";
        }

        if (Oval == (vo.KEY_poids_pesee_2)) {
            return "Poids Pesse 2";
        }

        if (Oval == (vo.KEY_poids_vgm)) {
            return "Poids VGM";
        }

        if (Oval == (vo.KEY_produit)) {
            return "Produit";
        }

        if (Oval == (vo.KEY_methode_pesee_vgm)) {
            return "Methode de pesee";
        }

        return "";
    }

}
