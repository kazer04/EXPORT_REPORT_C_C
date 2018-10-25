package config_editor.security.User;

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
public class UserUpdateFrameController extends FormController {

    private UserUpdateFrames frame = null;
    private String pk = null;
    Cryptages ocryptage = new Cryptages();

    public UserUpdateFrameController(String pk) {
        this.pk = pk;
        frame = new UserUpdateFrames(this);
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

            UserVO vo = new UserVO();

            XmlFiles OXmlFiles = new XmlFiles("users", "users.xml");

            vo.setPassword(ocryptage.decryptage(OXmlFiles.FindField("password")));
            vo.setUser_name(ocryptage.decryptage(OXmlFiles.FindField("user_name")));
            vo.setFirstname(ocryptage.decryptage(OXmlFiles.FindField("firstname")));
            vo.setLastname(ocryptage.decryptage(OXmlFiles.FindField("lastname")));

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
     * @param oldPersistentObject original value object, previous to the changes
     * @param persistentObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     */
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        PreparedStatement stmt = null;
        try {



            Cryptages ocryptage = new Cryptages();
            GridUserVO vo = (GridUserVO) persistentObject;

            if (vo.getPassword().equals("")) {
                new logger().OCategory.info("le pass est  est vide");
                return new ErrorResponse("le pass est  est vide");
            }











            XmlFiles OXmlFiles = new XmlFiles("users", "users.xml");



            OXmlFiles.updateFiled("firstname", ocryptage.cryptage(vo.getFirstname()));
            OXmlFiles.updateFiled("lastname", ocryptage.cryptage(vo.getLastname()));
            OXmlFiles.updateFiled("password", ocryptage.cryptage(vo.getPassword()));
            OXmlFiles.updateFiled("user_name", ocryptage.cryptage(vo.getUser_name()));



            OXmlFiles.commit();


            jdom.InitRessource();
            jdom.LoadRessource();





            OXmlFiles = new XmlFiles("users", "users.xml");

            vo.setPassword(ocryptage.decryptage(OXmlFiles.FindField("password")));
            vo.setUser_name(ocryptage.decryptage(OXmlFiles.FindField("user_name")));
            vo.setFirstname(ocryptage.decryptage(OXmlFiles.FindField("firstname")));
            vo.setLastname(ocryptage.decryptage(OXmlFiles.FindField("lastname")));


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
            UserVO vo = (UserVO) persistentObject;
            //stmt.setString(1,vo.getEmpCode());
            stmt.execute();
            return new VOResponse(vo);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new ErrorResponse(ex.getMessage());

        }
    }
}
