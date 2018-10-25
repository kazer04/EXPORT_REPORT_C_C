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
@Table(name = "t_event_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TEventLog.findAll", query = "SELECT t FROM TEventLog t"),
    @NamedQuery(name = "TEventLog.findByLgEVENTLOGID", query = "SELECT t FROM TEventLog t WHERE t.lgEVENTLOGID = :lgEVENTLOGID"),
    @NamedQuery(name = "TEventLog.findByMatriculeEleve", query = "SELECT t FROM TEventLog t WHERE t.matriculeEleve = :matriculeEleve"),
    @NamedQuery(name = "TEventLog.findByDtCREATED", query = "SELECT t FROM TEventLog t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TEventLog.findByDtUPDATED", query = "SELECT t FROM TEventLog t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TEventLog.findByStrDESCRIPTION", query = "SELECT t FROM TEventLog t WHERE t.strDESCRIPTION = :strDESCRIPTION"),
    @NamedQuery(name = "TEventLog.findByStrCREATEDBY", query = "SELECT t FROM TEventLog t WHERE t.strCREATEDBY = :strCREATEDBY"),
    @NamedQuery(name = "TEventLog.findByStrUPDATEDBY", query = "SELECT t FROM TEventLog t WHERE t.strUPDATEDBY = :strUPDATEDBY"),
    @NamedQuery(name = "TEventLog.findByStrSTATUT", query = "SELECT t FROM TEventLog t WHERE t.strSTATUT = :strSTATUT"),
    @NamedQuery(name = "TEventLog.findByStrTABLECONCERN", query = "SELECT t FROM TEventLog t WHERE t.strTABLECONCERN = :strTABLECONCERN"),
    @NamedQuery(name = "TEventLog.findByStrMODULECONCERN", query = "SELECT t FROM TEventLog t WHERE t.strMODULECONCERN = :strMODULECONCERN")})
public class TEventLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_EVENT_LOG_ID", nullable = false, length = 30)
    private String lgEVENTLOGID;
    @Column(name = "MATRICULE_ELEVE", length = 20)
    private String matriculeEleve;
    @Column(name = "dt_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCREATED;
    @Column(name = "dt_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUPDATED;
    @Column(name = "str_DESCRIPTION", length = 2000)
    private String strDESCRIPTION;
    @Column(name = "str_CREATED_BY", length = 100)
    private String strCREATEDBY;
    @Column(name = "str_UPDATED_BY", length = 20)
    private String strUPDATEDBY;
    @Column(name = "str_STATUT", length = 20)
    private String strSTATUT;
    @Column(name = "str_TABLE_CONCERN", length = 40)
    private String strTABLECONCERN;
    @Column(name = "str_MODULE_CONCERN", length = 40)
    private String strMODULECONCERN;

    public TEventLog() {
    }

    public TEventLog(String lgEVENTLOGID) {
        this.lgEVENTLOGID = lgEVENTLOGID;
    }

    public String getLgEVENTLOGID() {
        return lgEVENTLOGID;
    }

    public void setLgEVENTLOGID(String lgEVENTLOGID) {
        this.lgEVENTLOGID = lgEVENTLOGID;
    }

    public String getMatriculeEleve() {
        return matriculeEleve;
    }

    public void setMatriculeEleve(String matriculeEleve) {
        this.matriculeEleve = matriculeEleve;
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

    public String getStrDESCRIPTION() {
        return strDESCRIPTION;
    }

    public void setStrDESCRIPTION(String strDESCRIPTION) {
        this.strDESCRIPTION = strDESCRIPTION;
    }

    public String getStrCREATEDBY() {
        return strCREATEDBY;
    }

    public void setStrCREATEDBY(String strCREATEDBY) {
        this.strCREATEDBY = strCREATEDBY;
    }

    public String getStrUPDATEDBY() {
        return strUPDATEDBY;
    }

    public void setStrUPDATEDBY(String strUPDATEDBY) {
        this.strUPDATEDBY = strUPDATEDBY;
    }

    public String getStrSTATUT() {
        return strSTATUT;
    }

    public void setStrSTATUT(String strSTATUT) {
        this.strSTATUT = strSTATUT;
    }

    public String getStrTABLECONCERN() {
        return strTABLECONCERN;
    }

    public void setStrTABLECONCERN(String strTABLECONCERN) {
        this.strTABLECONCERN = strTABLECONCERN;
    }

    public String getStrMODULECONCERN() {
        return strMODULECONCERN;
    }

    public void setStrMODULECONCERN(String strMODULECONCERN) {
        this.strMODULECONCERN = strMODULECONCERN;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgEVENTLOGID != null ? lgEVENTLOGID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEventLog)) {
            return false;
        }
        TEventLog other = (TEventLog) object;
        if ((this.lgEVENTLOGID == null && other.lgEVENTLOGID != null) || (this.lgEVENTLOGID != null && !this.lgEVENTLOGID.equals(other.lgEVENTLOGID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TEventLog[ lgEVENTLOGID=" + lgEVENTLOGID + " ]";
    }
    
}
