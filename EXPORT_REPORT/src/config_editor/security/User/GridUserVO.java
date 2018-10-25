package config_editor.security.User;

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
public class GridUserVO extends ValueObjectImpl {

    private String firstname = "";
    private String lastname = "";
    private String user_name = "";
    private String password = "";
    private String last_connexion = "";

    public GridUserVO() {
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the last_connexion
     */
    public String getLast_connexion() {
        return last_connexion;
    }

    /**
     * @param last_connexion the last_connexion to set
     */
    public void setLast_connexion(String last_connexion) {
        this.last_connexion = last_connexion;
    }

}
