package config_editor.ui.ligneMaritimes;

import config_editor.security.User.*;
import org.openswing.swing.message.receive.java.ValueObjectImpl;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * Title: OpenSwing Framework</p>
 * <p>
 * Description: Value Object used to store employee info.</p>
 * <p>
 * Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p>
 * </p> @author Mauro Carniel
 * @version 1.0
 */
public class LigneMaritimesVO extends GridUserVO {

    private String acl = "";
    private String ajc = "";
    private String anl = "";
    private String apl = "";
    private String azd = "";

    public LigneMaritimesVO() {
    }

    /**
     * @return the acl
     */
    public String getAcl() {
        return acl;
    }

    /**
     * @param acl the acl to set
     */
    public void setAcl(String acl) {
        this.acl = acl;
    }

    /**
     * @return the ajc
     */
    public String getAjc() {
        return ajc;
    }

    /**
     * @param ajc the ajc to set
     */
    public void setAjc(String ajc) {
        this.ajc = ajc;
    }

    /**
     * @return the anl
     */
    public String getAnl() {
        return anl;
    }

    /**
     * @param anl the anl to set
     */
    public void setAnl(String anl) {
        this.anl = anl;
    }

    /**
     * @return the apl
     */
    public String getApl() {
        return apl;
    }

    /**
     * @param apl the apl to set
     */
    public void setApl(String apl) {
        this.apl = apl;
    }

    /**
     * @return the azd
     */
    public String getAzd() {
        return azd;
    }

    /**
     * @param azd the azd to set
     */
    public void setAzd(String azd) {
        this.azd = azd;
    }

}
