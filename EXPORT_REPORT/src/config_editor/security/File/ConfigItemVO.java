package config_editor.security.File;

import org.openswing.swing.message.receive.java.ValueObjectImpl;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Title: OpenSwing Framework</p>
 * <p>Description: Value Object used to store employee info.</p>
 * <p>Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p> </p>
 * @author Mauro Carniel
 * @version 1.0
 */
public class ConfigItemVO extends GridConfigItemVO {

   

  

    private String config_target = "";
    private String ars_database_name = "";
    private String ars_database_user_name = "";
    private String ars_database_user_password = "";
    private String ars_database_host = "";
    private String name_sql_server = "";
    private String user_sql_server = "";
    private String password_sql_server = "";
    private String host_sql_server = "";
    private String url_Pretups_request = "";
    private String url_topup = "";
    private String AuthenticationService_ressource_wsdl = "";
    private String SessionService_ressource_wsdl = "";
    private String TransactionService_ressource_wsdl = "";
    private String ars_database_port = "0";
    private String topup_ressource_wsdl = "";
    private String scr_report_file = "";
    private String scr_report_pdf = "";
    private String scr_report_xls = "";
    private String path_file_generate_relatif = "";
    private String path_file_generate_absolute = "";
    private String path_file_generate_relatif_imported = "";
    private String path_file_generate_absolute_imported = "";
    private int int_size_pagination = 10;
    private String ORANGE_FILE_SEPERATOR = ",";
    private String log_file = "";
    private String APP_RELOAD_ALL = "0";
    private String username_mail = "";
    private String password_mail = "";
    private String CUSTOMER = "";
    private String database_type = "";
    private String SID = "";
    private String clickatell_IP = "3055579";
    private String clickatell_phone_number = "99900125";
    private String clickatell_User = "Soft-Tech";
    private String clickatell_Password = "softtech1";
    private String APP_NAME = "softtech1";
    private String APP_VERSION = "softtech1";
    private int sms_size = 160;
    private String j2me_dest_port = "";
    private String test_phone_number = "";
    private String modem_phone_number = "";
    private String modem_port = "";
    private String kannel_ip = "";
    private String kannel_port = "";
    private String kannel_user = "";
    private String kannel_pwd = "";
    private String path_pari_file = "";
    private String pmuc_account_number = "+23776043537";
    private String paris_sms_service_number = "";
    private int kannel_default_port = 0;
    private String Parisservices_WSDL = "";
    private String DEFAULT_SEPARATEUR = "-";
    private String PAYTUS_SEPARATEUR = "@";
    private String paytus_ressource_wsdl = "-";
    private String paris_portal_link = "";
    private String ce_files_folder = "";
    private String nb_Max_in_Pool = "25";
    private String BREAKER_SEPARATOR = "#";
    private String BREAKER_PORT = "9632";
    private String BREAKER_HOST = "localhost";
    private String cp_files_folder = "";
    private String scr_report_file_logo = "";
    private String mail_account = "";
    private String mail_password = "";
    private String smtp_server = "";
    private String paris_portal_backend_link = "";
    

    public ConfigItemVO() {
    }

  

    /**
     * @return the config_target
     */
    public String getConfig_target() {
        return config_target;
    }

    /**
     * @param config_target the config_target to set
     */
    public void setConfig_target(String config_target) {
        this.config_target = config_target;
    }

    /**
     * @return the ars_database_name
     */
    public String getArs_database_name() {
        return ars_database_name;
    }

    /**
     * @param ars_database_name the ars_database_name to set
     */
    public void setArs_database_name(String ars_database_name) {
        this.ars_database_name = ars_database_name;
    }

    /**
     * @return the ars_database_user_name
     */
    public String getArs_database_user_name() {
        return ars_database_user_name;
    }

    /**
     * @param ars_database_user_name the ars_database_user_name to set
     */
    public void setArs_database_user_name(String ars_database_user_name) {
        this.ars_database_user_name = ars_database_user_name;
    }

    /**
     * @return the ars_database_user_password
     */
    public String getArs_database_user_password() {
        return ars_database_user_password;
    }

    /**
     * @param ars_database_user_password the ars_database_user_password to set
     */
    public void setArs_database_user_password(String ars_database_user_password) {
        this.ars_database_user_password = ars_database_user_password;
    }

    /**
     * @return the ars_database_host
     */
    public String getArs_database_host() {
        return ars_database_host;
    }

    /**
     * @param ars_database_host the ars_database_host to set
     */
    public void setArs_database_host(String ars_database_host) {
        this.ars_database_host = ars_database_host;
    }

    /**
     * @return the name_sql_server
     */
    public String getName_sql_server() {
        return name_sql_server;
    }

    /**
     * @param name_sql_server the name_sql_server to set
     */
    public void setName_sql_server(String name_sql_server) {
        this.name_sql_server = name_sql_server;
    }

    /**
     * @return the user_sql_server
     */
    public String getUser_sql_server() {
        return user_sql_server;
    }

    /**
     * @param user_sql_server the user_sql_server to set
     */
    public void setUser_sql_server(String user_sql_server) {
        this.user_sql_server = user_sql_server;
    }

    /**
     * @return the password_sql_server
     */
    public String getPassword_sql_server() {
        return password_sql_server;
    }

    /**
     * @param password_sql_server the password_sql_server to set
     */
    public void setPassword_sql_server(String password_sql_server) {
        this.password_sql_server = password_sql_server;
    }

    /**
     * @return the host_sql_server
     */
    public String getHost_sql_server() {
        return host_sql_server;
    }

    /**
     * @param host_sql_server the host_sql_server to set
     */
    public void setHost_sql_server(String host_sql_server) {
        this.host_sql_server = host_sql_server;
    }

    /**
     * @return the url_Pretups_request
     */
    public String getUrl_Pretups_request() {
        return url_Pretups_request;
    }

    /**
     * @param url_Pretups_request the url_Pretups_request to set
     */
    public void setUrl_Pretups_request(String url_Pretups_request) {
        this.url_Pretups_request = url_Pretups_request;
    }

    /**
     * @return the url_topup
     */
    public String getUrl_topup() {
        return url_topup;
    }

    /**
     * @param url_topup the url_topup to set
     */
    public void setUrl_topup(String url_topup) {
        this.url_topup = url_topup;
    }

    /**
     * @return the AuthenticationService_ressource_wsdl
     */
    public String getAuthenticationService_ressource_wsdl() {
        return AuthenticationService_ressource_wsdl;
    }

    /**
     * @param AuthenticationService_ressource_wsdl the AuthenticationService_ressource_wsdl to set
     */
    public void setAuthenticationService_ressource_wsdl(String AuthenticationService_ressource_wsdl) {
        this.AuthenticationService_ressource_wsdl = AuthenticationService_ressource_wsdl;
    }

    /**
     * @return the SessionService_ressource_wsdl
     */
    public String getSessionService_ressource_wsdl() {
        return SessionService_ressource_wsdl;
    }

    /**
     * @param SessionService_ressource_wsdl the SessionService_ressource_wsdl to set
     */
    public void setSessionService_ressource_wsdl(String SessionService_ressource_wsdl) {
        this.SessionService_ressource_wsdl = SessionService_ressource_wsdl;
    }

    /**
     * @return the TransactionService_ressource_wsdl
     */
    public String getTransactionService_ressource_wsdl() {
        return TransactionService_ressource_wsdl;
    }

    /**
     * @param TransactionService_ressource_wsdl the TransactionService_ressource_wsdl to set
     */
    public void setTransactionService_ressource_wsdl(String TransactionService_ressource_wsdl) {
        this.TransactionService_ressource_wsdl = TransactionService_ressource_wsdl;
    }

    /**
     * @return the ars_database_port
     */
    public String getArs_database_port() {
        return ars_database_port;
    }

    /**
     * @param ars_database_port the ars_database_port to set
     */
    public void setArs_database_port(String ars_database_port) {
        this.ars_database_port = ars_database_port;
    }

    /**
     * @return the topup_ressource_wsdl
     */
    public String getTopup_ressource_wsdl() {
        return topup_ressource_wsdl;
    }

    /**
     * @param topup_ressource_wsdl the topup_ressource_wsdl to set
     */
    public void setTopup_ressource_wsdl(String topup_ressource_wsdl) {
        this.topup_ressource_wsdl = topup_ressource_wsdl;
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
     * @return the scr_report_pdf
     */
    public String getScr_report_pdf() {
        return scr_report_pdf;
    }

    /**
     * @param scr_report_pdf the scr_report_pdf to set
     */
    public void setScr_report_pdf(String scr_report_pdf) {
        this.scr_report_pdf = scr_report_pdf;
    }

    /**
     * @return the scr_report_xls
     */
    public String getScr_report_xls() {
        return scr_report_xls;
    }

    /**
     * @param scr_report_xls the scr_report_xls to set
     */
    public void setScr_report_xls(String scr_report_xls) {
        this.scr_report_xls = scr_report_xls;
    }

    /**
     * @return the path_file_generate_relatif
     */
    public String getPath_file_generate_relatif() {
        return path_file_generate_relatif;
    }

    /**
     * @param path_file_generate_relatif the path_file_generate_relatif to set
     */
    public void setPath_file_generate_relatif(String path_file_generate_relatif) {
        this.path_file_generate_relatif = path_file_generate_relatif;
    }

    /**
     * @return the path_file_generate_absolute
     */
    public String getPath_file_generate_absolute() {
        return path_file_generate_absolute;
    }

    /**
     * @param path_file_generate_absolute the path_file_generate_absolute to set
     */
    public void setPath_file_generate_absolute(String path_file_generate_absolute) {
        this.path_file_generate_absolute = path_file_generate_absolute;
    }

    /**
     * @return the path_file_generate_relatif_imported
     */
    public String getPath_file_generate_relatif_imported() {
        return path_file_generate_relatif_imported;
    }

    /**
     * @param path_file_generate_relatif_imported the path_file_generate_relatif_imported to set
     */
    public void setPath_file_generate_relatif_imported(String path_file_generate_relatif_imported) {
        this.path_file_generate_relatif_imported = path_file_generate_relatif_imported;
    }

    /**
     * @return the path_file_generate_absolute_imported
     */
    public String getPath_file_generate_absolute_imported() {
        return path_file_generate_absolute_imported;
    }

    /**
     * @param path_file_generate_absolute_imported the path_file_generate_absolute_imported to set
     */
    public void setPath_file_generate_absolute_imported(String path_file_generate_absolute_imported) {
        this.path_file_generate_absolute_imported = path_file_generate_absolute_imported;
    }

    /**
     * @return the int_size_pagination
     */
    public int getInt_size_pagination() {
        return int_size_pagination;
    }

    /**
     * @param int_size_pagination the int_size_pagination to set
     */
    public void setInt_size_pagination(int int_size_pagination) {
        this.int_size_pagination = int_size_pagination;
    }

    /**
     * @return the ORANGE_FILE_SEPERATOR
     */
    public String getORANGE_FILE_SEPERATOR() {
        return ORANGE_FILE_SEPERATOR;
    }

    /**
     * @param ORANGE_FILE_SEPERATOR the ORANGE_FILE_SEPERATOR to set
     */
    public void setORANGE_FILE_SEPERATOR(String ORANGE_FILE_SEPERATOR) {
        this.ORANGE_FILE_SEPERATOR = ORANGE_FILE_SEPERATOR;
    }

    /**
     * @return the log_file
     */
    public String getLog_file() {
        return log_file;
    }

    /**
     * @param log_file the log_file to set
     */
    public void setLog_file(String log_file) {
        this.log_file = log_file;
    }

    /**
     * @return the APP_RELOAD_ALL
     */
    public String getAPP_RELOAD_ALL() {
        return APP_RELOAD_ALL;
    }

    /**
     * @param APP_RELOAD_ALL the APP_RELOAD_ALL to set
     */
    public void setAPP_RELOAD_ALL(String APP_RELOAD_ALL) {
        this.APP_RELOAD_ALL = APP_RELOAD_ALL;
    }

    /**
     * @return the username_mail
     */
    public String getUsername_mail() {
        return username_mail;
    }

    /**
     * @param username_mail the username_mail to set
     */
    public void setUsername_mail(String username_mail) {
        this.username_mail = username_mail;
    }

    /**
     * @return the password_mail
     */
    public String getPassword_mail() {
        return password_mail;
    }

    /**
     * @param password_mail the password_mail to set
     */
    public void setPassword_mail(String password_mail) {
        this.password_mail = password_mail;
    }

    /**
     * @return the CUSTOMER
     */
    public String getCUSTOMER() {
        return CUSTOMER;
    }

    /**
     * @param CUSTOMER the CUSTOMER to set
     */
    public void setCUSTOMER(String CUSTOMER) {
        this.CUSTOMER = CUSTOMER;
    }

    /**
     * @return the database_type
     */
    public String getDatabase_type() {
        return database_type;
    }

    /**
     * @param database_type the database_type to set
     */
    public void setDatabase_type(String database_type) {
        this.database_type = database_type;
    }

    /**
     * @return the SID
     */
    public String getSID() {
        return SID;
    }

    /**
     * @param SID the SID to set
     */
    public void setSID(String SID) {
        this.SID = SID;
    }

    /**
     * @return the clickatell_IP
     */
    public String getClickatell_IP() {
        return clickatell_IP;
    }

    /**
     * @param clickatell_IP the clickatell_IP to set
     */
    public void setClickatell_IP(String clickatell_IP) {
        this.clickatell_IP = clickatell_IP;
    }

    /**
     * @return the clickatell_phone_number
     */
    public String getClickatell_phone_number() {
        return clickatell_phone_number;
    }

    /**
     * @param clickatell_phone_number the clickatell_phone_number to set
     */
    public void setClickatell_phone_number(String clickatell_phone_number) {
        this.clickatell_phone_number = clickatell_phone_number;
    }

    /**
     * @return the clickatell_User
     */
    public String getClickatell_User() {
        return clickatell_User;
    }

    /**
     * @param clickatell_User the clickatell_User to set
     */
    public void setClickatell_User(String clickatell_User) {
        this.clickatell_User = clickatell_User;
    }

    /**
     * @return the clickatell_Password
     */
    public String getClickatell_Password() {
        return clickatell_Password;
    }

    /**
     * @param clickatell_Password the clickatell_Password to set
     */
    public void setClickatell_Password(String clickatell_Password) {
        this.clickatell_Password = clickatell_Password;
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
     * @return the APP_VERSION
     */
    public String getAPP_VERSION() {
        return APP_VERSION;
    }

    /**
     * @param APP_VERSION the APP_VERSION to set
     */
    public void setAPP_VERSION(String APP_VERSION) {
        this.APP_VERSION = APP_VERSION;
    }

    /**
     * @return the sms_size
     */
    public int getSms_size() {
        return sms_size;
    }

    /**
     * @param sms_size the sms_size to set
     */
    public void setSms_size(int sms_size) {
        this.sms_size = sms_size;
    }

    /**
     * @return the j2me_dest_port
     */
    public String getJ2me_dest_port() {
        return j2me_dest_port;
    }

    /**
     * @param j2me_dest_port the j2me_dest_port to set
     */
    public void setJ2me_dest_port(String j2me_dest_port) {
        this.j2me_dest_port = j2me_dest_port;
    }

    /**
     * @return the test_phone_number
     */
    public String getTest_phone_number() {
        return test_phone_number;
    }

    /**
     * @param test_phone_number the test_phone_number to set
     */
    public void setTest_phone_number(String test_phone_number) {
        this.test_phone_number = test_phone_number;
    }

    /**
     * @return the modem_phone_number
     */
    public String getModem_phone_number() {
        return modem_phone_number;
    }

    /**
     * @param modem_phone_number the modem_phone_number to set
     */
    public void setModem_phone_number(String modem_phone_number) {
        this.modem_phone_number = modem_phone_number;
    }

    /**
     * @return the modem_port
     */
    public String getModem_port() {
        return modem_port;
    }

    /**
     * @param modem_port the modem_port to set
     */
    public void setModem_port(String modem_port) {
        this.modem_port = modem_port;
    }

    /**
     * @return the kannel_ip
     */
    public String getKannel_ip() {
        return kannel_ip;
    }

    /**
     * @param kannel_ip the kannel_ip to set
     */
    public void setKannel_ip(String kannel_ip) {
        this.kannel_ip = kannel_ip;
    }

    /**
     * @return the kannel_port
     */
    public String getKannel_port() {
        return kannel_port;
    }

    /**
     * @param kannel_port the kannel_port to set
     */
    public void setKannel_port(String kannel_port) {
        this.kannel_port = kannel_port;
    }

    /**
     * @return the kannel_user
     */
    public String getKannel_user() {
        return kannel_user;
    }

    /**
     * @param kannel_user the kannel_user to set
     */
    public void setKannel_user(String kannel_user) {
        this.kannel_user = kannel_user;
    }

    /**
     * @return the kannel_pwd
     */
    public String getKannel_pwd() {
        return kannel_pwd;
    }

    /**
     * @param kannel_pwd the kannel_pwd to set
     */
    public void setKannel_pwd(String kannel_pwd) {
        this.kannel_pwd = kannel_pwd;
    }

    /**
     * @return the path_pari_file
     */
    public String getPath_pari_file() {
        return path_pari_file;
    }

    /**
     * @param path_pari_file the path_pari_file to set
     */
    public void setPath_pari_file(String path_pari_file) {
        this.path_pari_file = path_pari_file;
    }

    /**
     * @return the pmuc_account_number
     */
    public String getPmuc_account_number() {
        return pmuc_account_number;
    }

    /**
     * @param pmuc_account_number the pmuc_account_number to set
     */
    public void setPmuc_account_number(String pmuc_account_number) {
        this.pmuc_account_number = pmuc_account_number;
    }

    /**
     * @return the paris_sms_service_number
     */
    public String getParis_sms_service_number() {
        return paris_sms_service_number;
    }

    /**
     * @param paris_sms_service_number the paris_sms_service_number to set
     */
    public void setParis_sms_service_number(String paris_sms_service_number) {
        this.paris_sms_service_number = paris_sms_service_number;
    }

    /**
     * @return the kannel_default_port
     */
    public int getKannel_default_port() {
        return kannel_default_port;
    }

    /**
     * @param kannel_default_port the kannel_default_port to set
     */
    public void setKannel_default_port(int kannel_default_port) {
        this.kannel_default_port = kannel_default_port;
    }

    /**
     * @return the Parisservices_WSDL
     */
    public String getParisservices_WSDL() {
        return Parisservices_WSDL;
    }

    /**
     * @param Parisservices_WSDL the Parisservices_WSDL to set
     */
    public void setParisservices_WSDL(String Parisservices_WSDL) {
        this.Parisservices_WSDL = Parisservices_WSDL;
    }

    /**
     * @return the DEFAULT_SEPARATEUR
     */
    public String getDEFAULT_SEPARATEUR() {
        return DEFAULT_SEPARATEUR;
    }

    /**
     * @param DEFAULT_SEPARATEUR the DEFAULT_SEPARATEUR to set
     */
    public void setDEFAULT_SEPARATEUR(String DEFAULT_SEPARATEUR) {
        this.DEFAULT_SEPARATEUR = DEFAULT_SEPARATEUR;
    }

    /**
     * @return the PAYTUS_SEPARATEUR
     */
    public String getPAYTUS_SEPARATEUR() {
        return PAYTUS_SEPARATEUR;
    }

    /**
     * @param PAYTUS_SEPARATEUR the PAYTUS_SEPARATEUR to set
     */
    public void setPAYTUS_SEPARATEUR(String PAYTUS_SEPARATEUR) {
        this.PAYTUS_SEPARATEUR = PAYTUS_SEPARATEUR;
    }

    /**
     * @return the paytus_ressource_wsdl
     */
    public String getPaytus_ressource_wsdl() {
        return paytus_ressource_wsdl;
    }

    /**
     * @param paytus_ressource_wsdl the paytus_ressource_wsdl to set
     */
    public void setPaytus_ressource_wsdl(String paytus_ressource_wsdl) {
        this.paytus_ressource_wsdl = paytus_ressource_wsdl;
    }

    /**
     * @return the paris_portal_link
     */
    public String getParis_portal_link() {
        return paris_portal_link;
    }

    /**
     * @param paris_portal_link the paris_portal_link to set
     */
    public void setParis_portal_link(String paris_portal_link) {
        this.paris_portal_link = paris_portal_link;
    }

    /**
     * @return the ce_files_folder
     */
    public String getCe_files_folder() {
        return ce_files_folder;
    }

    /**
     * @param ce_files_folder the ce_files_folder to set
     */
    public void setCe_files_folder(String ce_files_folder) {
        this.ce_files_folder = ce_files_folder;
    }

    /**
     * @return the nb_Max_in_Pool
     */
    public String getNb_Max_in_Pool() {
        return nb_Max_in_Pool;
    }

    /**
     * @param nb_Max_in_Pool the nb_Max_in_Pool to set
     */
    public void setNb_Max_in_Pool(String nb_Max_in_Pool) {
        this.nb_Max_in_Pool = nb_Max_in_Pool;
    }

    /**
     * @return the BREAKER_SEPARATOR
     */
    public String getBREAKER_SEPARATOR() {
        return BREAKER_SEPARATOR;
    }

    /**
     * @param BREAKER_SEPARATOR the BREAKER_SEPARATOR to set
     */
    public void setBREAKER_SEPARATOR(String BREAKER_SEPARATOR) {
        this.BREAKER_SEPARATOR = BREAKER_SEPARATOR;
    }

    /**
     * @return the BREAKER_PORT
     */
    public String getBREAKER_PORT() {
        return BREAKER_PORT;
    }

    /**
     * @param BREAKER_PORT the BREAKER_PORT to set
     */
    public void setBREAKER_PORT(String BREAKER_PORT) {
        this.BREAKER_PORT = BREAKER_PORT;
    }

    /**
     * @return the BREAKER_HOST
     */
    public String getBREAKER_HOST() {
        return BREAKER_HOST;
    }

    /**
     * @param BREAKER_HOST the BREAKER_HOST to set
     */
    public void setBREAKER_HOST(String BREAKER_HOST) {
        this.BREAKER_HOST = BREAKER_HOST;
    }

    /**
     * @return the cp_files_folder
     */
    public String getCp_files_folder() {
        return cp_files_folder;
    }

    /**
     * @param cp_files_folder the cp_files_folder to set
     */
    public void setCp_files_folder(String cp_files_folder) {
        this.cp_files_folder = cp_files_folder;
    }

    /**
     * @return the scr_report_file_logo
     */
    public String getScr_report_file_logo() {
        return scr_report_file_logo;
    }

    /**
     * @param scr_report_file_logo the scr_report_file_logo to set
     */
    public void setScr_report_file_logo(String scr_report_file_logo) {
        this.scr_report_file_logo = scr_report_file_logo;
    }

    /**
     * @return the mail_account
     */
    public String getMail_account() {
        return mail_account;
    }

    /**
     * @param mail_account the mail_account to set
     */
    public void setMail_account(String mail_account) {
        this.mail_account = mail_account;
    }

    /**
     * @return the mail_password
     */
    public String getMail_password() {
        return mail_password;
    }

    /**
     * @param mail_password the mail_password to set
     */
    public void setMail_password(String mail_password) {
        this.mail_password = mail_password;
    }

    /**
     * @return the smtp_server
     */
    public String getSmtp_server() {
        return smtp_server;
    }

    /**
     * @param smtp_server the smtp_server to set
     */
    public void setSmtp_server(String smtp_server) {
        this.smtp_server = smtp_server;
    }

    /**
     * @return the paris_portal_backend_link
     */
    public String getParis_portal_backend_link() {
        return paris_portal_backend_link;
    }

    /**
     * @param paris_portal_backend_link the paris_portal_backend_link to set
     */
    public void setParis_portal_backend_link(String paris_portal_backend_link) {
        this.paris_portal_backend_link = paris_portal_backend_link;
    }

   

}
