/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

//import dal.TFamille;
//import dal.TUser;
import dal.TInstitutions;
import dal.TParameters;
import dal.TUser;
import dal.dataManager;
import dal.jconnexion;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import multilangue.Translate;
import org.json.JSONArray;
import org.json.JSONObject;
import toolkits.filesmanagers.FilesType.PicFile;
import toolkits.parameters.commonparameter;
import toolkits.utils.date;
import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 *
 * @author Administrator
 */
/**
 * Classe de cscdicjd dcdccs
 */
public class bllBase {

    private dataManager OdataManager;
    private Translate OTranslate;
    public static String error_def = "";
    protected String message;
    private String Detailmessage;
    public date key = new date();

    public List<TInstitutions> lstTInstitutions;
    protected jconnexion Ojconnexion;
    public java.sql.Connection oConnection;
    private TUser OTUser;
    private TInstitutions OTInstitutions;

    public void checkDatamanager() {
        if (getOTranslate() == null) {
            setOTranslate(new Translate());
        }
        if (OdataManager == null) {
            OdataManager = new dataManager();
            OdataManager.initEntityManager();
            return;
        }

        if (OdataManager.isConected == false) {
            OdataManager.initEntityManager();
            return;
        }

    }

    public void checkDatamanagerPU() {
        if (getOTranslate() == null) {
            setOTranslate(new Translate());
        }
        if (OdataManager == null) {
            OdataManager = new dataManager();

            return;
        }

        if (OdataManager.isConected == false) {
            OdataManager.initEntityManager();
            return;
        }

    }

    public void refresh(Serializable o) {
        try {
            this.getOdataManager().getEm().refresh(o);
        } catch (Exception e) {
        }
    }

    public boolean persiste(Serializable o) {
        try {
            
            this.getOdataManager().BeginTransaction();
            this.getOdataManager().getEm().persist(o);
            this.getOdataManager().CloseTransaction();
            try {
                this.getOdataManager().getEm().refresh(o);
            } catch (Exception e) {
            }
            new logger().OCategory.info("Peristance de l objet  " + o.toString());
            this.setMessage(commonparameter.PROCESS_SUCCESS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            buildErrorTraceMessage(e.getMessage());
            return false;
        }
    }

    public boolean persisteNotCommit(Serializable o) {
        try {
            // this.getOdataManager().BeginTransaction();
            this.getOdataManager().getEm().persist(o);
            // this.getOdataManager().CloseTransaction();
            try {
                //   this.getOdataManager().getEm().refresh(o);
            } catch (Exception e) {
            }
            new logger().OCategory.info("Peristance temps de l objet   " + o.toString());
            this.setMessage(commonparameter.PROCESS_SUCCESS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            buildErrorTraceMessage(e.getMessage());
            return false;
        }
    }

    public boolean persiste(List<Serializable> o) {
        try {
            this.getOdataManager().BeginTransaction();

            for (int i = 0; i < o.size(); i++) {

                this.getOdataManager().getEm().persist(o.get(i));
            }
            this.getOdataManager().CloseTransaction();
            this.setMessage(commonparameter.PROCESS_SUCCESS);
            try {
                this.getOdataManager().getEm().refresh(o);
            } catch (Exception e) {
            }

            //new logger().OCategory.info(o.);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            buildErrorTraceMessage(e.getMessage());
            return false;
        }
    }

    public boolean merge(Serializable o) {
        try {
            this.getOdataManager().BeginTransaction();
            this.getOdataManager().getEm().merge(o);
            this.getOdataManager().CloseTransaction();

            try {
                this.getOdataManager().getEm().refresh(o);
            } catch (Exception e) {
            }
            this.setMessage(commonparameter.PROCESS_SUCCESS);
            new logger().OCategory.info("Merge de l objet  " + o.toString());

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            buildErrorTraceMessage(e.getMessage());
            return false;
        }
    }

    public boolean delete(Object o, Serializable Tclass) {
        try {
            Serializable OSerializable = this.find(o, Tclass);
            this.getOdataManager().BeginTransaction();
            this.getOdataManager().getEm().remove(OSerializable);
            this.getOdataManager().CloseTransaction();
            buildSuccesTraceMessage("Suppresion Ok");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            buildErrorTraceMessage(e.getMessage());
            return false;
        }
    }
// Renvoie l'objet donc la ref et une instance d objet sont passe respectivemment en parametre

    public <T extends Object> T test(Class<T> entityClass) {
        return null;
    }

    public Serializable find(Object o, Serializable Tclass) {
        try {
            Serializable OSerializable = getOdataManager().getEm().find(Tclass.getClass(), o);
            this.refresh(OSerializable);
            return OSerializable;
        } catch (Exception e) {
            e.printStackTrace();
            buildErrorTraceMessage(e.toString());
            new logger().OCategory.info(" ERROR  " + e.toString());
            return null;
        }
    }

    public Serializable findNotRefresh(Object o, Serializable Tclass) {
        try {
            Serializable OSerializable = getOdataManager().getEm().find(Tclass.getClass(), o);
            //  this.refresh(OSerializable);
            return OSerializable;
        } catch (Exception e) {
            e.printStackTrace();
            buildErrorTraceMessage(e.toString());
            new logger().OCategory.info(" ERROR  " + e.toString());
            return null;
        }
    }

    public boolean delete(Serializable o) {
        try {
            this.getOdataManager().BeginTransaction();
            this.getOdataManager().getEm().remove(o);
            this.getOdataManager().CloseTransaction();
            buildSuccesTraceMessage("Suppresion Ok");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            buildErrorTraceMessage(e.getMessage());
            return false;
        }
    }

    public void LoadDataManger(dataManager OdataManager) {
        this.setOdataManager(OdataManager);
    }

    public void LoadMultilange(Translate OTranslate) {
        this.setOTranslate(OTranslate);
    }

    /**
     * @return the OdataManager
     */
    public dataManager getOdataManager() {
        return OdataManager;
    }

    /**
     * @param OdataManager the OdataManager to set
     */
    public void setOdataManager(dataManager OdataManager) {
        this.OdataManager = OdataManager;
    }

    /**
     * @return the OTranslate
     */
    public Translate getOTranslate() {
        return OTranslate;
    }

    /**
     * @param OTranslate the OTranslate to set
     */
    public void setOTranslate(Translate OTranslate) {
        this.OTranslate = OTranslate;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the key
     */
    public date getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(date key) {
        this.key = key;
    }

    public bllBase() {
        if (OdataManager == null) {
            OdataManager = new dataManager();
        }
        this.checkDatamanager();

    }

    public bllBase(TInstitutions OTInstitutions) {

        if (OdataManager == null) {
            OdataManager = new dataManager();
        }

        this.checkDatamanager();
        this.setOTInstitutions(OTInstitutions);

    }

    /**
     * @return the Detailmessage
     */
    public String getDetailmessage() {
        return Detailmessage;
    }

    /**
     * @param Detailmessage the Detailmessage to set
     */
    public void setDetailmessage(String Detailmessage) {
        this.Detailmessage = Detailmessage;
    }

    public static String getAbsPicture(String CUST_REF, String specialDirectory) {
        PicFile oPicFile = new PicFile();
        //oPicFile.setPath_outut(jdom.path_photo_absolute +specialDirectory+ "NO_PIC.jpg");
        oPicFile.setPath_outut("NO_PIC.jpg");
        oPicFile.isExisteAbs(specialDirectory + CUST_REF);
        return oPicFile.getPath_outut();
    }

    public static String getRelaPicture(String CUST_REF, String specialDirectory, String Type_of_pic) {
        PicFile oPicFile = new PicFile();
        oPicFile.setPath_outut(jdom.path_photo_relatif + specialDirectory + Type_of_pic + "NO_PIC.jpg");
        oPicFile.isExiste(specialDirectory + CUST_REF);
        return oPicFile.getPath_outut();
    }

    public void setoConnection(Connection oConnection) {
        this.oConnection = oConnection;
    }

    public void is_activity(String lg_CUSTOMER_ID) {
        try {
            String sProc = "{ CALL proc_do_activity(?) }";
            jconnexion Ojconnexion = new jconnexion();
            Ojconnexion.initConnexion();
            Ojconnexion.OpenConnexion();
            CallableStatement cs = Ojconnexion.get_StringConnexion().prepareCall(sProc);
            cs.setString(1, lg_CUSTOMER_ID);
            cs.execute();
            Ojconnexion.CloseConnexion();
        } catch (Exception e) {
            new logger().OCategory.error(e.getMessage());
        }
    }

    public void is_activity(jconnexion Ojconnexion) {
        try {
            String sProc = "{ CALL proc_do_activity(?) }";
            CallableStatement cs = Ojconnexion.get_StringConnexion().prepareCall(sProc);
            cs.setString(1, this.getOTUser().getLgUSERID());
            cs.execute();
        } catch (Exception e) {
            new logger().OCategory.error(e.getMessage());
        }
    }

    public void is_activity(jconnexion Ojconnexion, String lg_CUSTOMER_ID) {
        try {
            String sProc = "{ CALL proc_do_activity(?) }";
            CallableStatement cs = Ojconnexion.get_StringConnexion().prepareCall(sProc);
            cs.setString(1, lg_CUSTOMER_ID);
            cs.execute();
        } catch (Exception e) {
            new logger().OCategory.error(e.getMessage());
        }
    }

    public void do_event_log(jconnexion Ojconnexion, String ID_INSCRIPTION,
            String str_DESCRIPTION, String str_CREATED_BY,
            String str_STATUT, String str_TABLE_CONCERN,
            String str_MODULE_CONCERN) {
        try {

            String sProc = "{ CALL proc_do_event_log(?,?,?,?,?,?,?,?) }";
            CallableStatement cs = Ojconnexion.get_StringConnexion().prepareCall(sProc);
            cs.setString(1, key.gettimeid());
            cs.setString(2, ID_INSCRIPTION);
            cs.setString(3, str_DESCRIPTION);
            cs.setString(4, str_STATUT);
            cs.setString(5, str_TABLE_CONCERN);
            cs.setString(6, str_CREATED_BY);
            cs.setString(7, str_MODULE_CONCERN);
            cs.setString(8, "");
            cs.execute();
            this.setDetailmessage(str_DESCRIPTION);
            new logger().OCategory.error(str_DESCRIPTION);
        } catch (Exception e) {
            new logger().OCategory.error(e.getMessage());
        }
    }

    public void do_event_log(jconnexion Ojconnexion, String ID_INSCRIPTION,
            String str_DESCRIPTION, String str_CREATED_BY,
            String str_STATUT, String str_TABLE_CONCERN,
            String str_MODULE_CONCERN, String ID_ANNEE_SCOLAIRE) {
        try {

            String sProc = "{ CALL proc_do_event_log(?,?,?,?,?,?,?,?) }";
            CallableStatement cs = Ojconnexion.get_StringConnexion().prepareCall(sProc);
            cs.setString(1, key.gettimeid());
            cs.setString(2, ID_INSCRIPTION);
            cs.setString(3, str_DESCRIPTION);
            cs.setString(4, str_STATUT);
            cs.setString(5, str_TABLE_CONCERN);
            cs.setString(6, str_CREATED_BY);
            cs.setString(7, str_MODULE_CONCERN);
            cs.setString(8, ID_ANNEE_SCOLAIRE);
            cs.execute();

            this.buildSuccesTraceMessage(str_DESCRIPTION);

        } catch (Exception e) {
            new logger().OCategory.error(e.getMessage());
            this.buildErrorTraceMessage(e.getMessage());
        }
    }

    public void do_event_log(String ID_INSCRIPTION,
            String str_DESCRIPTION, String str_CREATED_BY,
            String str_STATUT, String str_TABLE_CONCERN,
            String str_MODULE_CONCERN) {
        try {
            jconnexion Ojconnexion = new jconnexion();
            Ojconnexion.initConnexion();
            Ojconnexion.OpenConnexion();

            String sProc = "{ CALL proc_do_event_log(?,?,?,?,?,?,?,?) }";
            CallableStatement cs = Ojconnexion.get_StringConnexion().prepareCall(sProc);
            cs.setString(1, key.gettimeid());
            cs.setString(2, ID_INSCRIPTION);
            cs.setString(3, str_DESCRIPTION);
            cs.setString(4, str_STATUT);
            cs.setString(5, str_TABLE_CONCERN);
            cs.setString(6, str_CREATED_BY);
            cs.setString(7, str_MODULE_CONCERN);
            cs.setString(8, "");
            cs.execute();
            Ojconnexion.CloseConnexion();
            new logger().OCategory.info(str_DESCRIPTION);
        } catch (Exception e) {
            new logger().OCategory.error(e.getMessage());
        }
    }

    public void do_event_log(String ID_INSCRIPTION,
            String str_DESCRIPTION, String str_CREATED_BY,
            String str_STATUT, String str_TABLE_CONCERN,
            String str_MODULE_CONCERN, String ID_ANNEE_SCOLAIRE) {
        try {
            jconnexion Ojconnexion = new jconnexion();
            Ojconnexion.initConnexion();
            Ojconnexion.OpenConnexion();

            String sProc = "{ CALL proc_do_event_log(?,?,?,?,?,?,?,?) }";
            CallableStatement cs = Ojconnexion.get_StringConnexion().prepareCall(sProc);
            cs.setString(1, key.gettimeid());
            cs.setString(2, ID_INSCRIPTION);
            cs.setString(3, str_DESCRIPTION);
            cs.setString(4, str_STATUT);
            cs.setString(5, str_TABLE_CONCERN);
            cs.setString(6, str_CREATED_BY);
            cs.setString(7, str_MODULE_CONCERN);
            cs.setString(8, ID_ANNEE_SCOLAIRE);
            cs.execute();
            Ojconnexion.CloseConnexion();

        } catch (Exception e) {
            new logger().OCategory.error(e.getMessage());
        }
    }

    public void buildTraceMessage(String Message, String DetailMessage) {
        this.setDetailmessage(this.getOTranslate().getValue(DetailMessage));
        this.setMessage(message);
    }

    public void buildErrorTraceMessage(String DetailMessage) {
        this.setDetailmessage(this.getOTranslate().getValue(DetailMessage));
        this.setMessage(toolkits.parameters.commonparameter.PROCESS_FAILED);

        new logger().OCategory.error(this.Detailmessage);
    }

    public void buildErrorTraceMessage(String DetailMessage, String ErrorSystem) {
        this.setDetailmessage(this.getOTranslate().getValue(DetailMessage) + ".ERREUR  SYS:[ " + ErrorSystem + "]");
        setMessage(toolkits.parameters.commonparameter.PROCESS_FAILED);

        new logger().OCategory.error(this.Detailmessage);
    }

    public void buildSuccesTraceMessage(String DetailMessage) {
        this.setDetailmessage(this.getOTranslate().getValue(DetailMessage));
        setMessage(toolkits.parameters.commonparameter.PROCESS_SUCCESS);

        new logger().OCategory.info(this.Detailmessage);
    }

    /**
     * @return the OTUser
     */
    public TUser getOTUser() {
        return OTUser;
    }

    /**
     * @param OTUser the OTUser to set
     */
    public void setOTUser(TUser OTUser) {
        this.OTUser = OTUser;
    }

    public void prinntTraceInfo(Object message) {

        new logger().OCategory.info(message);

    }

    public void prinntTraceDebug(Object message) {
        new logger().OCategory.debug(message);

    }

    public void prinntTraceError(Object message) {
        new logger().OCategory.error(message);

    }

    public String buildVenteRef(Date ODate, String Key) {
        TParameters OTParameters = this.getOdataManager().getEm().find(TParameters.class, Key);
        TParameters OTParameters_KEY_SIZE_ORDER_NUMBER = this.getOdataManager().getEm().find(TParameters.class, "KEY_SIZE_ORDER_NUMBER");
        this.refresh(OTParameters);

        String jsondata = OTParameters.getStrVALUE();
        int int_last_code = 0;
        int_last_code = int_last_code + 1;

        new logger().OCategory.info("jsondata =  " + jsondata);
        try {
            JSONArray jsonArray = new JSONArray(jsondata);
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            int_last_code = new Integer(jsonObject.getString("int_last_code"));
            Date dt_last_date = date.stringToDate(jsonObject.getString("str_last_date"), date.formatterMysqlShort2);

            String str_lasd = this.getKey().DateToString(dt_last_date, this.getKey().formatterMysqlShort2);
            String str_actd = this.getKey().DateToString(ODate, this.getKey().formatterMysqlShort2);

            if (!str_lasd.equals(str_actd)) {
                int_last_code = 0;
            }

            new logger().OCategory.info(int_last_code + "  " + dt_last_date);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //KEY_SIZE_ORDER_NUMBER
        Calendar now = Calendar.getInstance();
        int hh = now.get(Calendar.HOUR_OF_DAY);
        int mois = now.get(Calendar.MONTH) + 1;
        int jour = now.get(Calendar.DAY_OF_MONTH);

        int intsize = ((int_last_code + 1) + "").length();
        int intsize_tobuild = new Integer(OTParameters_KEY_SIZE_ORDER_NUMBER.getStrVALUE());
        String str_last_code = "";
        for (int i = 0; i < (intsize_tobuild - intsize); i++) {
            str_last_code = str_last_code + "0";
        }

        str_last_code = str_last_code + (int_last_code + 1) + "";

        String str_code = this.getKey().getKeyYear() + "" + mois + "" + jour + "_" + str_last_code;

        JSONObject json = new JSONObject();
        JSONArray arrayObj = new JSONArray();
        json.put("int_last_code", str_last_code);
        json.put("str_last_date", this.getKey().DateToString(ODate, this.getKey().formatterMysqlShort2));
        arrayObj.put(json);
        String jsonData = arrayObj.toString();

        OTParameters.setStrVALUE(jsonData);
        this.persiste(OTParameters);
        new logger().OCategory.info(jsonData);
        new logger().OCategory.info(str_code);
        return str_code;
    }

    public String getData(String O) {

        if (O == null) {
            return "";
        }
        return O.trim().replace("...", "");
    }

    public TInstitutions getTInstitutions(String lg_Id) {
        return (TInstitutions) this.find(lg_Id, new TInstitutions());
    }

    /**
     * @return the OTInstitutions
     */
    public TInstitutions getOTInstitutions() {
        return OTInstitutions;
    }

    /**
     * @param OTInstitutions the OTInstitutions to set
     */
    public void setOTInstitutions(TInstitutions OTInstitutions) {
        this.OTInstitutions = OTInstitutions;
    }

    public void setOTInstitutions(String lg_Id) {
        this.OTInstitutions = this.getTInstitutions(lg_Id);
    }

}
