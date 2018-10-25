/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP PC
 */
@Entity
@Table(name = "t_outboud_message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TOutboudMessage.findAll", query = "SELECT t FROM TOutboudMessage t"),
    @NamedQuery(name = "TOutboudMessage.findByLgOUTBOUNDMESSAGEID", query = "SELECT t FROM TOutboudMessage t WHERE t.lgOUTBOUNDMESSAGEID = :lgOUTBOUNDMESSAGEID"),
    @NamedQuery(name = "TOutboudMessage.findByDtCREATED", query = "SELECT t FROM TOutboudMessage t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TOutboudMessage.findByDtUPDATED", query = "SELECT t FROM TOutboudMessage t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TOutboudMessage.findByStrSTATUT", query = "SELECT t FROM TOutboudMessage t WHERE t.strSTATUT = :strSTATUT"),
    @NamedQuery(name = "TOutboudMessage.findByStrPHONE", query = "SELECT t FROM TOutboudMessage t WHERE t.strPHONE = :strPHONE")})
public class TOutboudMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_OUTBOUND_MESSAGE_ID", nullable = false, length = 30)
    private String lgOUTBOUNDMESSAGEID;
    @Column(name = "dt_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCREATED;
    @Column(name = "dt_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUPDATED;
    @Basic(optional = false)
    @Lob
    @Column(name = "str_MESSAGE", nullable = false, length = 65535)
    private String strMESSAGE;
    @Column(name = "str_STATUT", length = 20)
    private String strSTATUT;
    @Column(name = "str_PHONE", length = 20)
    private String strPHONE;

    public TOutboudMessage() {
    }

    public TOutboudMessage(String lgOUTBOUNDMESSAGEID) {
        this.lgOUTBOUNDMESSAGEID = lgOUTBOUNDMESSAGEID;
    }

    public TOutboudMessage(String lgOUTBOUNDMESSAGEID, String strMESSAGE) {
        this.lgOUTBOUNDMESSAGEID = lgOUTBOUNDMESSAGEID;
        this.strMESSAGE = strMESSAGE;
    }

    public String getLgOUTBOUNDMESSAGEID() {
        return lgOUTBOUNDMESSAGEID;
    }

    public void setLgOUTBOUNDMESSAGEID(String lgOUTBOUNDMESSAGEID) {
        this.lgOUTBOUNDMESSAGEID = lgOUTBOUNDMESSAGEID;
    }

    public Date getDtCREATED() {
        return dtCREATED;
    }

    public void setDtCREATED(Date dtCREATED) {
        this.dtCREATED = dtCREATED;
    }

    public Date getDtUPDATED() {
        return dtUPDATED;
    }

    public void setDtUPDATED(Date dtUPDATED) {
        this.dtUPDATED = dtUPDATED;
    }

    public String getStrMESSAGE() {
        return strMESSAGE;
    }

    public void setStrMESSAGE(String strMESSAGE) {
        this.strMESSAGE = strMESSAGE;
    }

    public String getStrSTATUT() {
        return strSTATUT;
    }

    public void setStrSTATUT(String strSTATUT) {
        this.strSTATUT = strSTATUT;
    }

    public String getStrPHONE() {
        return strPHONE;
    }

    public void setStrPHONE(String strPHONE) {
        this.strPHONE = strPHONE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgOUTBOUNDMESSAGEID != null ? lgOUTBOUNDMESSAGEID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TOutboudMessage)) {
            return false;
        }
        TOutboudMessage other = (TOutboudMessage) object;
        if ((this.lgOUTBOUNDMESSAGEID == null && other.lgOUTBOUNDMESSAGEID != null) || (this.lgOUTBOUNDMESSAGEID != null && !this.lgOUTBOUNDMESSAGEID.equals(other.lgOUTBOUNDMESSAGEID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TOutboudMessage[ lgOUTBOUNDMESSAGEID=" + lgOUTBOUNDMESSAGEID + " ]";
    }
    
}
