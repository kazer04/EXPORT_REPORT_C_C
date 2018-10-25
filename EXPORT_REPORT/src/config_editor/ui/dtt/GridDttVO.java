package config_editor.ui.dtt;


import config_editor.security.User.*;
import java.util.Date;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 * <p>
 * Title: OpenSwing Framework</p>
 * <p>
 * Description: Value Object used to store employee summary info.</p>
 * <p>
 * Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p>
 * </p> @author Mauro Carniel
 * @version 1.0
 */
public class GridDttVO extends ValueObjectImpl {

private String APP_NAME = "";
    private String APP_FOLDER_APP = "";
    private String scr_report_file = "";
    private String name_db = "";
    private String user_db = "";
    private String password_db = "";
    private String host_db = "";
    private String port_db = "";
    private String Ostr_projectweb = "";

    public GridDttVO() {
    }

     /**
     * @return the APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * @param APP_NAME the APP_NAME to set
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME;
    }

    /**
     * @return the APP_FOLDER_APP
     */
    public String getAPP_FOLDER_APP() {
        return APP_FOLDER_APP;
    }

    /**
     * @param APP_FOLDER_APP the APP_FOLDER_APP to set
     */
    public void setAPP_FOLDER_APP(String APP_FOLDER_APP) {
        this.APP_FOLDER_APP = APP_FOLDER_APP;
    }

    /**
     * @return the scr_report_file
     */
    public String getScr_report_file() {
        return scr_report_file;
    }

    /**
     * @param scr_report_file the scr_report_file to set
     */
    public void setScr_report_file(String scr_report_file) {
        this.scr_report_file = scr_report_file;
    }

    /**
     * @return the name_db
     */
    public String getName_db() {
        return name_db;
    }

    /**
     * @param name_db the name_db to set
     */
    public void setName_db(String name_db) {
        this.name_db = name_db;
    }

    /**
     * @return the user_db
     */
    public String getUser_db() {
        return user_db;
    }

    /**
     * @param user_db the user_db to set
     */
    public void setUser_db(String user_db) {
        this.user_db = user_db;
    }

    /**
     * @return the password_db
     */
    public String getPassword_db() {
        return password_db;
    }

    /**
     * @param password_db the password_db to set
     */
    public void setPassword_db(String password_db) {
        this.password_db = password_db;
    }

    /**
     * @return the host_db
     */
    public String getHost_db() {
        return host_db;
    }

    /**
     * @param host_db the host_db to set
     */
    public void setHost_db(String host_db) {
        this.host_db = host_db;
    }

    /**
     * @return the port_db
     */
    public String getPort_db() {
        return port_db;
    }

    /**
     * @param port_db the port_db to set
     */
    public void setPort_db(String port_db) {
        this.port_db = port_db;
    }

    /**
     * @return the Ostr_projectweb
     */
    public String getOstr_projectweb() {
        return Ostr_projectweb;
    }

    /**
     * @param Ostr_projectweb the Ostr_projectweb to set
     */
    public void setOstr_projectweb(String Ostr_projectweb) {
        this.Ostr_projectweb = Ostr_projectweb;
    }

    

}
