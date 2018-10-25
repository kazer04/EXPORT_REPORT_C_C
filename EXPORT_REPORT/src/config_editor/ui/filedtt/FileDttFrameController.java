package config_editor.ui.filedtt;

import bll.export_report_cc.ExportReportManager;
import config_editor.ui.dtt.*;
import dal.TFile;
import java.awt.Cursor;
import java.io.File;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.util.java.Consts;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.openswing.swing.message.receive.java.*;
import org.openswing.swing.mdi.client.MDIFrame;
import toolkits.filesmanagers.FilesType.TxtFiles;
import toolkits.filesmanagers.FilesType.XmlFiles;
import toolkits.security.Cryptages;
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
public class FileDttFrameController extends FormController {

    private FileDttGridFrames frame = null;
    public static String str_dtt_curent_path = "";
    private String pk = null;
    Cryptages ocryptage = new Cryptages();
    public static String str_project_path_of_config;

    public FileDttFrameController(String pk) {
        this.pk = pk;
        frame = new FileDttGridFrames(this);
        MDIFrame.add(frame);

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

            this.frame.odttManager = new ExportReportManager();
            //  odttManager.loadFile();
            //java.util.List<TFile> lst = this.frame.odttManager.getTFile();
            this.frame.lstDtt = this.frame.odttManager.getTFile();
            this.frame.getJProgressBarLoadDtt().setMinimum(0);
            this.frame.getJProgressBarLoadDtt().setMaximum(this.frame.lstDtt.size());
            this.frame.getJProgressBarLoadDtt().setValue(0);
            this.frame.getJProgressBarLoadDtt().setStringPainted(true);

            // jButton1.setEnabled(false);
            // setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            //Instances of javax.swing.SwingWorker are not reusuable, so
            //we create new instances as needed.
            //this.frame.loadDttToTask();

            config_editor.ui.dtt.DttVO vo = new config_editor.ui.dtt.DttVO();
            vo.setDATE_PRECEDENTE_RAZ("00");
            vo.setDATE_RAZ("00");
            vo.setREF_RAZ("00");
            vo.setNameFile("00");
            this.frame.populateMainGrid();
            //this.frame.loadDataTocomboBoxControl1(this.frame.lstDtt.get(0));
            //   this.frame.populateTicketGrid(this.frame.lstDtt.get(0));
            //   this.frame.loadDataTocomboBoxControl1(this.frame.lstDtt.get(0));
            return new VOResponse(vo);

            //this.frame.task = new FileDttGridFrames.Task();  
            /* this.frame.task  = new FileDttGridFrames.Task();
             task.addPropertyChangeListener(this);
             task.execute();
             */
            /*
             jdom.InitRessource();
             jdom.LoadRessource();
             TxtFiles OTxtFiles = new TxtFiles();

             dttManager odttManager = new dttManager("DTT");
             //  odttManager.loadFile();
             List<File> lst = odttManager.getUiDttFileList();
             this.frame.setTitle("DTT  - Repertoire Dtt en cours " + ocryptage.decryptage(jdom.APP_FOLDER_APP) + "  " + (0) + "/" + lst.size());
             odttManager.LstDtt = new ArrayList<Dtt>();
             for (int i = 0; i < lst.size(); i++) {
             odttManager.loadFile(lst.get(i));
             new logger().OCategory.info(lst.get(i).getAbsolutePath());
             this.frame.setTitle("DTT  - Repertoire Dtt en cours " + ocryptage.decryptage(jdom.APP_FOLDER_APP) + "  " + (i + 1) + "/" + lst.size());

             }*/
            /*          this.frame.lstDtt = odttManager.LstDtt;
             if (this.frame.lstDtt.size() > 0) {
             new logger().OCategory.info(this.frame.lstDtt.get(0).DATE_PRECEDENTE_RAZ);
             config_editor.ui.dtt.DttVO vo = new config_editor.ui.dtt.DttVO();
             vo.setDATE_PRECEDENTE_RAZ(this.frame.lstDtt.get(0).DATE_PRECEDENTE_RAZ);
             vo.setDATE_RAZ(this.frame.lstDtt.get(0).DATE_RAZ);
             vo.setREF_RAZ(this.frame.lstDtt.get(0).REF_RAZ);
             vo.setNameFile(this.frame.lstDtt.get(0).nameFile);
             this.frame.populateMainGrid();
             //   this.frame.populateTicketGrid(this.frame.lstDtt.get(0));
             //   this.frame.loadDataTocomboBoxControl1(this.frame.lstDtt.get(0));
             return new VOResponse(vo);
             }
             */
            // return null;
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
            DttVO vo = (DttVO) newPersistentObject;
            if (vo.getAPP_FOLDER_APP().equals("")) {
                new logger().OCategory.info("le pass est  est vide");
                return new ErrorResponse("le pass est  est vide");
            }
            //  Ouser.createUser(Ouser.getKey().getSimpletimeid(), vo.getStrLOGIN(), vo.getStrPASSWORD(), vo.getStrFIRSTNAME(), vo.getStrLASTNAME(), vo.getLgROLEID());

            pk = vo.getAPP_FOLDER_APP();
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
            GridDttVO vo = (GridDttVO) persistentObject;
            /*
             if (vo.getAPP_NAME().equals("")) {
             new logger().OCategory.info("le pass est  est vide");
             return new ErrorResponse("le pass est  est vide");
             }
             */
            // XmlFiles OXmlFiles = new XmlFiles("users", "users.xml");
            XmlFiles OXmlFiles = new XmlFiles("config", str_project_path_of_config);
            /*   OXmlFiles.updateFiled("APP_FOLDER_APP", ocryptage.cryptage(vo.getAPP_FOLDER_APP()));
             OXmlFiles.updateFiled("APP_NAME", ocryptage.cryptage(vo.getAPP_NAME()));
             OXmlFiles.updateFiled("host", ocryptage.cryptage(vo.getHost_db()));
             OXmlFiles.updateFiled("name", ocryptage.cryptage(vo.getName_db()));
             OXmlFiles.updateFiled("Ostr_projectweb", ocryptage.cryptage(vo.getOstr_projectweb()));
             OXmlFiles.updateFiled("password", ocryptage.cryptage(vo.getPassword_db()));
             OXmlFiles.updateFiled("port", ocryptage.cryptage(vo.getPort_db()));
             OXmlFiles.updateFiled("scr_report_file", ocryptage.cryptage(vo.getScr_report_file()));
             OXmlFiles.updateFiled("user", ocryptage.cryptage(vo.getUser_db()));
             */
            OXmlFiles.commit();

            jdom.InitRessource();
            jdom.LoadRessource();
            /*
             vo.setAPP_FOLDER_APP(ocryptage.decryptage(OXmlFiles.FindField("APP_FOLDER_APP")));
             vo.setAPP_NAME(ocryptage.decryptage(OXmlFiles.FindField("APP_NAME")));
             vo.setHost_db(ocryptage.decryptage(OXmlFiles.FindField("host")));
             vo.setName_db(ocryptage.decryptage(OXmlFiles.FindField("name")));
             vo.setOstr_projectweb(ocryptage.decryptage(OXmlFiles.FindField("Ostr_projectweb")));
             vo.setPassword_db(ocryptage.decryptage(OXmlFiles.FindField("password")));
             vo.setPort_db(ocryptage.decryptage(OXmlFiles.FindField("port")));
             vo.setUser_db(ocryptage.decryptage(OXmlFiles.FindField("user")));
             vo.setScr_report_file(ocryptage.decryptage(OXmlFiles.FindField("scr_report_file")));

             new logger().OCategory.info("APP_FOLDER_APP : " + ocryptage.decryptage(OXmlFiles.FindField("APP_FOLDER_APP")));
             */
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
            DttVO vo = (DttVO) persistentObject;
            //stmt.setString(1,vo.getEmpCode());
            stmt.execute();
            return new VOResponse(vo);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());

        }
    }
}
