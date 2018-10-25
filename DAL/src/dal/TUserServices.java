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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "t_user_services")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUserServices.findAll", query = "SELECT t FROM TUserServices t"),
    @NamedQuery(name = "TUserServices.findByLgUSERSERVICESID", query = "SELECT t FROM TUserServices t WHERE t.lgUSERSERVICESID = :lgUSERSERVICESID"),
    @NamedQuery(name = "TUserServices.findByDtUPDATED", query = "SELECT t FROM TUserServices t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TUserServices.findByStrSTATUT", query = "SELECT t FROM TUserServices t WHERE t.strSTATUT = :strSTATUT"),
    @NamedQuery(name = "TUserServices.findByDtCREATED", query = "SELECT t FROM TUserServices t WHERE t.dtCREATED = :dtCREATED")})
public class TUserServices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_USER_SERVICES_ID", nullable = false, length = 30)
    private String lgUSERSERVICESID;
    @Column(name = "dt_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUPDATED;
    @Column(name = "str_STATUT", length = 20)
    private String strSTATUT;
    @Column(name = "dt_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCREATED;
    @JoinColumn(name = "lg_USER_ID", referencedColumnName = "lg_USER_ID", nullable = false)
    @ManyToOne(optional = false)
    private TUser lgUSERID;
    @JoinColumn(name = "lg_SERVICES_ID", referencedColumnName = "lg_SERVICES_ID")
    @ManyToOne
    private TServices lgSERVICESID;

    public TUserServices() {
    }

    public TUserServices(String lgUSERSERVICESID) {
        this.lgUSERSERVICESID = lgUSERSERVICESID;
    }

    public String getLgUSERSERVICESID() {
        return lgUSERSERVICESID;
    }

    public void setLgUSERSERVICESID(String lgUSERSERVICESID) {
        this.lgUSERSERVICESID = lgUSERSERVICESID;
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

    public Date getDtCREATED() {
        return dtCREATED;
    }

    public void setDtCREATED(Date dtCREATED) {
        this.dtCREATED = dtCREATED;
    }

    public TUser getLgUSERID() {
        return lgUSERID;
    }

    public void setLgUSERID(TUser lgUSERID) {
        this.lgUSERID = lgUSERID;
    }

    public TServices getLgSERVICESID() {
        return lgSERVICESID;
    }

    public void setLgSERVICESID(TServices lgSERVICESID) {
        this.lgSERVICESID = lgSERVICESID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgUSERSERVICESID != null ? lgUSERSERVICESID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUserServices)) {
            return false;
        }
        TUserServices other = (TUserServices) object;
        if ((this.lgUSERSERVICESID == null && other.lgUSERSERVICESID != null) || (this.lgUSERSERVICESID != null && !this.lgUSERSERVICESID.equals(other.lgUSERSERVICESID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TUserServices[ lgUSERSERVICESID=" + lgUSERSERVICESID + " ]";
    }
    
}
