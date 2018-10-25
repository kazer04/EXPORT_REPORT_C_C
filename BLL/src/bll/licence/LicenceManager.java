/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.licence;

import dal.TParameters;
import dal.TUser;
import dal.dataManager;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import toolkits.parameters.commonparameter;
import toolkits.security.Cryptages;
import toolkits.utils.date;
import toolkits.utils.logger;

/**
 *
 * @author user
 */
public class LicenceManager extends bll.bllBase {
    
    public LicenceManager() {
        checkDatamanager();
    }
    
    public LicenceManager(dataManager OdataManager) {
        this.setOdataManager(OdataManager);
        checkDatamanager();
    }
    
    public LicenceManager(dataManager odataManager, TUser oTUser) {
        this.setOTUser(oTUser);
        this.setOdataManager(odataManager);
        this.checkDatamanager();
        
    }
    
    public Boolean isAvalaible() {
        TParameters OTParameters = this.getOdataManager().getEm().find(TParameters.class, "KEY_LICENCE_DATA");
        Cryptages OCryptage = new Cryptages();
        String dataCryp = OTParameters.getStrVALUE();
        //new logger().OCategory.info(OCryptage.decryptage(datacryp));
        String dataDeCrypJsondata = OCryptage.decryptage(dataCryp);
        this.refresh(OTParameters);
        
        new logger().OCategory.info("jsondata =  " + dataDeCrypJsondata);
        try {
            JSONArray jsonArray = new JSONArray(dataDeCrypJsondata);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            
            Boolean is_activate = new Boolean(jsonObject.getString("is_activate"));
            new logger().OCategory.info(is_activate);
            Date str_end_date = date.stringToDate(jsonObject.getString("str_end_date"), date.formatterMysqlShort2);
            new logger().OCategory.info(str_end_date);
            Integer nb_count = new Integer(jsonObject.getString("nb_count"));
            new logger().OCategory.info(nb_count);
            Boolean is_locked = new Boolean(jsonObject.getString("is_locked"));
            new logger().OCategory.info(is_locked);
            
            if (this.isEndDateAvailable(str_end_date)) {
                this.buildErrorTraceMessage("Date Limite passée");
               // return false;
                 return true;
            }
            if (this.isNb_countAvailable(nb_count)) {
                this.buildErrorTraceMessage("Desolée nombre limite de tentative atteint ");
               // return false;
                 return true;
            }
            if (this.is_comptlocked()) {
                this.buildErrorTraceMessage("Desolée compte bloque");
               // return false;
                 return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
        
    }
    
    private Boolean isEndDateAvailable(Date dTdatefin) {
        if (new Date().compareTo(dTdatefin) > 0) {
            return true;
        }
        return false;
    }
    
    private Boolean isNb_countAvailable(int intcount) {
        if (intcount == 3) {
            return true;
        }
        return false;
    }
    
    private Boolean is_comptlocked() {
        Boolean status = true;
        if (status) {
            return false;
        }
        return true;
    }
    
    public String generateLicenceCode() {
        TParameters OTParameters = this.getOdataManager().getEm().find(TParameters.class, "KEY_LICENCE_DATA");
        Cryptages OCryptage = new Cryptages();
        String dataCryp = OTParameters.getStrVALUE();
        new logger().OCategory.info(OCryptage.decryptage(dataCryp));
        String dataDeCrypJsondata = OCryptage.decryptage(dataCryp);
        
        new logger().OCategory.info("jsondata =  " + dataDeCrypJsondata);
        try {
            JSONArray jsonArray = new JSONArray(dataDeCrypJsondata);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            
            String licence_code = new String(jsonObject.getString("licence_code"));
            new logger().OCategory.info(licence_code);
            Boolean is_activate = new Boolean(jsonObject.getString("is_activate"));
            new logger().OCategory.info(is_activate);
            Date str_end_date = date.stringToDate(jsonObject.getString("str_end_date"), date.formatterMysqlShort2);
            new logger().OCategory.info(str_end_date);
            Integer nb_count = new Integer(jsonObject.getString("nb_count"));
            new logger().OCategory.info(nb_count);
            Boolean is_locked = new Boolean(jsonObject.getString("is_locked"));
            new logger().OCategory.info(is_locked);
            
            String str_code = this.generateRandomString(6, commonparameter.MODE_ALPHANUMERIC);
            String str_codeCrypte = OCryptage.cryptage(str_code);
            String is_activatestr_Crypte = OCryptage.cryptage(jsonObject.getString("is_activate"));
            String str_end_dateCrypte = OCryptage.cryptage(jsonObject.getString("str_end_date"));
            String nb_countCrypte = OCryptage.cryptage(jsonObject.getString("nb_count"));
            String is_lockedCrypte = OCryptage.cryptage(jsonObject.getString("is_locked"));
            
            JSONObject json = new JSONObject();
            JSONArray arrayObj = new JSONArray();
            
            json.put("licence_code", str_codeCrypte);
            json.put("is_activate", is_activatestr_Crypte);
            json.put("str_end_date", str_end_dateCrypte);
            json.put("nb_count", nb_countCrypte);
            json.put("is_locked", is_lockedCrypte);
            arrayObj.put(json);
            String jsonData = arrayObj.toString();
            
            OTParameters.setStrVALUE(jsonData);
            this.persiste(OTParameters);
            new logger().OCategory.info(jsonData);
            new logger().OCategory.info("str_code" + "  " + str_code);
            new logger().OCategory.info("str_codeCrypte" + "  " + str_codeCrypte);
            return str_codeCrypte;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "";
    }
    
    public String generateRandomString(int length, String mode) throws Exception {
        
        StringBuffer buffer = new StringBuffer();
        String characters = "";
        
        if (mode.equalsIgnoreCase(commonparameter.MODE_ALPHA)) {
            
            characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            
        }
        
        if (mode.equalsIgnoreCase(commonparameter.MODE_ALPHANUMERIC)) {
            
            characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            
        }
        
        if (mode.equalsIgnoreCase(commonparameter.MODE_NUMERIC)) {
            
            characters = "1234567890";
            
        }
        
        int charactersLength = characters.length();
        
        for (int i = 0; i < length; i++) {
            double index = Math.random() * charactersLength;
            buffer.append(characters.charAt((int) index));
        }
        return buffer.toString();
    }
    
    public String initLicenceCode(int int_day) {
        TParameters OTParameters = this.getOdataManager().getEm().find(TParameters.class, "KEY_LICENCE_DATA");
        Cryptages OCryptage = new Cryptages();
        //String dataCryp = OTParameters.getStrVALUE();

        try {
            
            String licence_code = new String(this.generateRandomString(6, commonparameter.MODE_ALPHANUMERIC));
            new logger().OCategory.info(licence_code);
            Boolean is_activate = new Boolean(true);
            new logger().OCategory.info(is_activate);
            String str_end_date = date.DateToString(date.GetNewDate(int_day), date.formatterMysqlShort2);
            new logger().OCategory.info(str_end_date);
            Integer nb_count = new Integer(0);
            new logger().OCategory.info(nb_count);
            Boolean is_locked = new Boolean(true);
            new logger().OCategory.info(is_locked);
            
            String str_code = this.generateRandomString(6, commonparameter.MODE_ALPHANUMERIC);
            String str_codeCrypte = OCryptage.cryptage(str_code);
            String is_activatestr_Crypte = OCryptage.cryptage(is_activate.toString());
            String str_end_dateCrypte = OCryptage.cryptage(str_end_date);
            String nb_countCrypte = OCryptage.cryptage(nb_count + "");
            String is_lockedCrypte = OCryptage.cryptage(is_locked.toString());
            
            JSONObject json = new JSONObject();
            JSONArray arrayObj = new JSONArray();
            
            json.put("licence_code", str_code);
            json.put("is_activate", is_activate);
            json.put("str_end_date", str_end_date);
            json.put("nb_count", nb_count);
            json.put("is_locked", is_locked);
            arrayObj.put(json);
            String jsonData = arrayObj.toString();
            
            OTParameters.setStrVALUE(OCryptage.cryptage(jsonData));
            this.persiste(OTParameters);
            new logger().OCategory.info(jsonData);
            new logger().OCategory.info("str_code" + "  " + str_code);
            new logger().OCategory.info("str_codeCrypte" + "  " + str_codeCrypte);
            return str_codeCrypte;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
}
