/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package config_editor.security;

import toolkits.filesmanagers.FilesType.XmlFiles;
import toolkits.security.Cryptages;
import toolkits.security.Md5;
import toolkits.utils.date;
import toolkits.utils.logger;

/**
 *
 * @author Administrator
 */
public class authentification {

    private String message;
    private String Detailmessage;

    public boolean login(String password, String user_name) {
        Boolean result = false;

        bll.userManagement.authentification Oauthentification = new bll.userManagement.authentification();
       if (Oauthentification.loginUser(user_name, password) == true) {
            new logger().OCategory.info(Oauthentification.getOTUser().getStrFIRSTNAME());
            return true;
        } else {
            this.setDetailmessage(Oauthentification.getDetailmessage());
            new logger().OCategory.error(this.getDetailmessage());
            return false;

        }
        
        // return true;
/*
        try {
            Cryptages ocryptage = new Cryptages();
            XmlFiles OXmlFiles = new XmlFiles("users", "users.xml");
            if (!ocryptage.decryptage(OXmlFiles.FindField("user_name")).equals(user_name)) {
                this.setDetailmessage("USER NAME INCONNUE");
                new logger().OCategory.error(this.getDetailmessage());
                return false;
            }

            if (!ocryptage.decryptage(OXmlFiles.FindField("password")).equals(password)) {
                this.setDetailmessage("MOT DE PASS INCONNUE");
                new logger().OCategory.error(this.getDetailmessage());
                return false;
            }

            this.setDetailmessage("VALID_USER_DATA");
            new logger().OCategory.error(this.getDetailmessage());

            OXmlFiles.updateFiled("password", ocryptage.cryptage(password));
            OXmlFiles.updateFiled("user_name", ocryptage.cryptage(user_name));
            OXmlFiles.updateFiled("last_connexion", date.GetDateNow(date.formatterMysql));
            OXmlFiles.commit();

            return true;
        } catch (Exception ex) {
            this.setDetailmessage("INVALID_USER_DATA");
            new logger().OCategory.error(this.getDetailmessage());
        }
       return result;
       */
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
}
