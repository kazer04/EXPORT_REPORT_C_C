package config_editor.security.File;

import org.openswing.swing.form.client.FormController;
import org.openswing.swing.util.java.Consts;
import java.sql.*;
import multilangue.Translate;
import org.openswing.swing.message.receive.java.*;
import org.openswing.swing.mdi.client.MDIFrame;
import toolkits.filesmanagers.FilesType.XmlFiles;
import toolkits.security.Cryptages;
import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 * <p>Title: OpenSwing Framework</p>
 * <p>Description: Detail frame controller for the employee</p>
 * <p>Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p> </p>
 * @author Mauro Carniel
 * @version 1.0
 */
public class FileEditorUpdateFrameController extends FormController {

    private FileEditorUpdateFrames frame = null;
    private String pk = null;
    Cryptages ocryptage = new Cryptages();

    public FileEditorUpdateFrameController(String pk) {
        this.pk = pk;
        frame = new FileEditorUpdateFrames(this);
        MDIFrame.add(frame);

        if (pk != null) {
            frame.getMainPanel().setMode(Consts.READONLY);
            frame.getMainPanel().reload();
        } else {
            frame.getMainPanel().setMode(Consts.INSERT);
        }

    }

    /**
     * This method must be overridden by the subclass to retrieve data and return the valorized value object.
     * @param valueObjectClass value object class
     * @return a VOResponse object if data loading is successfully completed, or an ErrorResponse object if an error occours
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
            vo.setArs_database_port(ocryptage.decryptage(jdom.ars_database_port+"").toString());

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


            return new VOResponse(vo);

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        }

    }

    /**
     * Callback method called when the data loading is completed.
     * @param error <code>true</code> if an error occours during data loading, <code>false</code> if data loading is successfully completed
     */
    public void loadDataCompleted(boolean error) {
        //   frame.getControlCurrency().setCurrencySymbol("$");
        //  frame.getControlCurrency().setDecimals(2);
        //  frame.getControlCurrency().setDecimalSymbol('.');
        //  frame.getControlCurrency().setGroupingSymbol(',');
    }

    /**
     * Method called by the Form panel to insert new data.
     * @param newValueObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     */
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            ConfigItemVO vo = (ConfigItemVO) newPersistentObject;
            if (!vo.getArs_database_host().equals(vo.getArs_database_host())) {
                new logger().OCategory.info("Les Mots de passe differents");
                return new ErrorResponse("Les Mots de passe differents");
            }

            //  Ouser.createUser(Ouser.getKey().getSimpletimeid(), vo.getStrLOGIN(), vo.getStrPASSWORD(), vo.getStrFIRSTNAME(), vo.getStrLASTNAME(), vo.getLgROLEID());

            pk = vo.getAPP_NAME();
            return new VOResponse(vo);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        } finally {
        }

    }

    /**
     * Method called by the Form panel to update existing data.
     * @param oldPersistentObject original value object, previous to the changes
     * @param persistentObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     */
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {

            

            Cryptages ocryptage = new Cryptages();
            GridConfigItemVO vo = (GridConfigItemVO) persistentObject;

            if (vo.getArs_database_name().equals("")) {
                new logger().OCategory.info("le nom de la base de donnee est vide");
                return new ErrorResponse("le nom de la base de donnee est vide");
            }









            //MYSQL DATA BASE

            vo.setArs_database_host(ocryptage.cryptage(vo.getArs_database_host()));
            vo.setArs_database_name(ocryptage.cryptage(vo.getArs_database_name()));
            vo.setArs_database_user_name(ocryptage.cryptage(vo.getArs_database_user_name()));
            vo.setArs_database_user_password(ocryptage.cryptage(vo.getArs_database_user_password()));
            vo.setArs_database_port(ocryptage.cryptage(new Integer(vo.getArs_database_port()).toString()));




            //KANNEL
            vo.setKannel_ip(ocryptage.cryptage(vo.getKannel_ip()));
            //vo.setKannel_default_port(ocryptage.cryptage(jdom.kannel_default_port));
            vo.setKannel_user(ocryptage.cryptage(vo.getKannel_user()));
            vo.setKannel_pwd(ocryptage.cryptage(vo.getKannel_pwd()));
            vo.setKannel_port(ocryptage.cryptage(new Integer(vo.getKannel_port()).toString()));


            //PARIS SMS SERVEUR
            vo.setNb_Max_in_Pool(ocryptage.cryptage(new Integer(vo.getNb_Max_in_Pool()).toString()));
            vo.setBREAKER_HOST(ocryptage.cryptage(vo.getBREAKER_HOST()));
            vo.setBREAKER_PORT(ocryptage.cryptage(new Integer(vo.getBREAKER_PORT()).toString()));
            vo.setBREAKER_SEPARATOR(ocryptage.cryptage(vo.getBREAKER_SEPARATOR()));



            //AUTRES
            vo.setParis_portal_link(ocryptage.cryptage(vo.getParis_portal_link()));
            vo.setParis_portal_backend_link(ocryptage.cryptage(vo.getParis_portal_backend_link()));
            vo.setPaytus_ressource_wsdl(ocryptage.cryptage(vo.getPaytus_ressource_wsdl()));
            vo.setScr_report_file(ocryptage.cryptage(vo.getScr_report_file()));
            vo.setScr_report_file_logo(ocryptage.cryptage(vo.getScr_report_file_logo()));
            vo.setLog_file(ocryptage.cryptage(vo.getLog_file()));




            XmlFiles OXmlFiles = new XmlFiles("airtime_config");

            //MYSQL DATA BASE


            OXmlFiles.updateFiled("name", vo.getArs_database_name());
            OXmlFiles.updateFiled("user", vo.getArs_database_user_name());
            OXmlFiles.updateFiled("host", vo.getArs_database_host());
            OXmlFiles.updateFiled("port", vo.getArs_database_port());
            OXmlFiles.updateFiled("password", vo.getArs_database_user_password());

            

            //KANNEL
            OXmlFiles.updateFiled("kannel_ip", (vo.getKannel_ip()));
            //vo.setKannel_default_port(ocryptage.cryptage(jdom.kannel_default_port));
            OXmlFiles.updateFiled("kannel_user", (vo.getKannel_user()));
            OXmlFiles.updateFiled("kannel_pwd", (vo.getKannel_pwd()));
            OXmlFiles.updateFiled("kannel_port", (vo.getKannel_port()));



            //PARIS SMS SERVEUR
            OXmlFiles.updateFiled("nb_Max_in_Pool", (vo.getNb_Max_in_Pool()));
            OXmlFiles.updateFiled("BREAKER_HOST", (vo.getBREAKER_HOST()));
            OXmlFiles.updateFiled("BREAKER_PORT", (vo.getBREAKER_PORT()));
            OXmlFiles.updateFiled("BREAKER_SEPARATOR", (vo.getBREAKER_SEPARATOR()));





            //AUTRES
            OXmlFiles.updateFiled("paris_portal_link", (vo.getParis_portal_link()));
            OXmlFiles.updateFiled("paris_portal_backend_link", (vo.getParis_portal_backend_link()));
            OXmlFiles.updateFiled("paytus_ressource_wsdl", (vo.getPaytus_ressource_wsdl()));
            OXmlFiles.updateFiled("scr_report_file", (vo.getScr_report_file()));
            OXmlFiles.updateFiled("scr_report_file_logo", (vo.getScr_report_file_logo()));
            OXmlFiles.updateFiled("log_file", (vo.getLog_file()));

             
            OXmlFiles.commit();


            jdom.InitRessource();
            jdom.LoadRessource();


           


            vo.setAPP_NAME(jdom.APP_NAME);
            vo.setAPP_RELOAD_ALL(jdom.APP_RELOAD_ALL);
            vo.setAPP_VERSION(jdom.APP_VERSION);

            //MYSQL DATA BASE
            vo.setArs_database_host(ocryptage.decryptage(jdom.ars_database_host));
            vo.setArs_database_name(ocryptage.decryptage(jdom.ars_database_name));
            vo.setArs_database_user_name(ocryptage.decryptage(jdom.ars_database_user_name));
            vo.setArs_database_user_password(ocryptage.decryptage(jdom.ars_database_user_password));
            vo.setArs_database_port(ocryptage.decryptage(jdom.ars_database_port+"").toString());

            //KANNEL
            vo.setKannel_ip(ocryptage.decryptage(jdom.kannel_ip));  
            //vo.setKannel_default_port(ocryptage.decryptage(jdom.kannel_default_port));
            vo.setKannel_user(ocryptage.decryptage(jdom.kannel_user));
            vo.setKannel_pwd(ocryptage.decryptage(jdom.kannel_pwd));
            vo.setKannel_port(ocryptage.decryptage(new Integer(jdom.kannel_port).toString()));


            //PARIS SMS SERVEUR
            vo.setNb_Max_in_Pool(ocryptage.decryptage(new Integer(jdom.nb_Max_in_Pool).toString()));
            vo.setBREAKER_HOST(ocryptage.decryptage(jdom.BREAKER_HOST));
            vo.setBREAKER_PORT(ocryptage.decryptage(new Integer(jdom.BREAKER_PORT).toString()));
            vo.setBREAKER_SEPARATOR(ocryptage.decryptage(jdom.BREAKER_SEPARATOR));



            //AUTRES
            vo.setParis_portal_link(ocryptage.decryptage(""));
            vo.setParis_portal_backend_link(ocryptage.decryptage(jdom.paris_portal_backend_link));
            vo.setPaytus_ressource_wsdl(ocryptage.decryptage("")); 
            vo.setScr_report_file(ocryptage.decryptage(jdom.scr_report_file));
            vo.setScr_report_file_logo(ocryptage.decryptage(jdom.scr_report_file_logo));
            vo.setLog_file(ocryptage.decryptage(jdom.log_file));




            //new logger().OCategory.info(Ouser.getMessage());
            return new VOResponse(vo);

        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());
        }
    }

    /**
     * Method called by the Form panel to delete existing data.
     * @param persistentObject value object to delete
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     */
    public Response deleteRecord(ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {
            // stmt = conn.prepareStatement("delete from EMP where EMP_CODE=?");
            ConfigItemVO vo = (ConfigItemVO) persistentObject;
            //stmt.setString(1,vo.getEmpCode());
            stmt.execute();
            return new VOResponse(vo);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());

        }
    }
}
