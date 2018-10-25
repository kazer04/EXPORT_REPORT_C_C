package config_editor.ui.dtt;


import config_editor.security.User.*;
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
 * 
 * config_editor.ui.ConfigProduct.GridConfigProjectVO
 */
public class DttVO extends GridDttVO {

 private String nameFile = "";
    private String DATE_PRECEDENTE_RAZ = "";
    private String DATE_RAZ = "";
    private String REF_RAZ = "";
    private String RAZ_DATA_REF_LONG = "";
    

    public DttVO() {
    }

    /**
     * @return the nameFile
     */
    public String getNameFile() {
        return nameFile;
    }

    /**
     * @param nameFile the nameFile to set
     */
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    /**
     * @return the DATE_PRECEDENTE_RAZ
     */
    public String getDATE_PRECEDENTE_RAZ() {
        return DATE_PRECEDENTE_RAZ;
    }

    /**
     * @param DATE_PRECEDENTE_RAZ the DATE_PRECEDENTE_RAZ to set
     */
    public void setDATE_PRECEDENTE_RAZ(String DATE_PRECEDENTE_RAZ) {
        this.DATE_PRECEDENTE_RAZ = DATE_PRECEDENTE_RAZ;
    }

    /**
     * @return the DATE_RAZ
     */
    public String getDATE_RAZ() {
        return DATE_RAZ;
    }

    /**
     * @param DATE_RAZ the DATE_RAZ to set
     */
    public void setDATE_RAZ(String DATE_RAZ) {
        this.DATE_RAZ = DATE_RAZ;
    }

    /**
     * @return the REF_RAZ
     */
    public String getREF_RAZ() {
        return REF_RAZ;
    }

    /**
     * @param REF_RAZ the REF_RAZ to set
     */
    public void setREF_RAZ(String REF_RAZ) {
        this.REF_RAZ = REF_RAZ;
    }

    /**
     * @return the RAZ_DATA_REF_LONG
     */
    public String getRAZ_DATA_REF_LONG() {
        return RAZ_DATA_REF_LONG;
    }

    /**
     * @param RAZ_DATA_REF_LONG the RAZ_DATA_REF_LONG to set
     */
    public void setRAZ_DATA_REF_LONG(String RAZ_DATA_REF_LONG) {
        this.RAZ_DATA_REF_LONG = RAZ_DATA_REF_LONG;
    }

    

    

}
