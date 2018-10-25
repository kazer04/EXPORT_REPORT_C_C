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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP PC
 */
@Entity
@Table(name = "t_message", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"lg_MESSAGE_ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMessage.findAll", query = "SELECT t FROM TMessage t"),
    @NamedQuery(name = "TMessage.findByLgMESSAGEID", query = "SELECT t FROM TMessage t WHERE t.lgMESSAGEID = :lgMESSAGEID"),
    @NamedQuery(name = "TMessage.findByDtCREATED", query = "SELECT t FROM TMessage t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TMessage.findByDtUPDATED", query = "SELECT t FROM TMessage t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TMessage.findByStrSTATUT", query = "SELECT t FROM TMessage t WHERE t.strSTATUT = :strSTATUT")})
public class TMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_MESSAGE_ID", nullable = false, length = 50)
    private String lgMESSAGEID;
    @Lob
    @Column(name = "str_MESSAGE", length = 65535)
    private String strMESSAGE;
    @Column(name = "dt_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCREATED;
    @Column(name = "dt_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUPDATED;
    @Column(name = "str_STATUT", length = 20)
    private String strSTATUT;

    public TMessage() {
    }

    public TMessage(String lgMESSAGEID) {
        this.lgMESSAGEID = lgMESSAGEID;
    }

    public String getLgMESSAGEID() {
        return lgMESSAGEID;
    }

    public void setLgMESSAGEID(String lgMESSAGEID) {
        this.lgMESSAGEID = lgMESSAGEID;
    }

    public String getStrMESSAGE() {
        return strMESSAGE;
    }

    public void setStrMESSAGE(String strMESSAGE) {
        this.strMESSAGE = strMESSAGE;
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

    public String getStrSTATUT() {
        return strSTATUT;
    }

    public void setStrSTATUT(String strSTATUT) {
        this.strSTATUT = strSTATUT;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgMESSAGEID != null ? lgMESSAGEID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TMessage)) {
            return false;
        }
        TMessage other = (TMessage) object;
        if ((this.lgMESSAGEID == null && other.lgMESSAGEID != null) || (this.lgMESSAGEID != null && !this.lgMESSAGEID.equals(other.lgMESSAGEID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TMessage[ lgMESSAGEID=" + lgMESSAGEID + " ]";
    }
    
}
