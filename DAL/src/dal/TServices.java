/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP PC
 */
@Entity
@Table(name = "t_services", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"lg_SERVICES_ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TServices.findAll", query = "SELECT t FROM TServices t"),
    @NamedQuery(name = "TServices.findByLgSERVICESID", query = "SELECT t FROM TServices t WHERE t.lgSERVICESID = :lgSERVICESID"),
    @NamedQuery(name = "TServices.findByStrNAME", query = "SELECT t FROM TServices t WHERE t.strNAME = :strNAME"),
    @NamedQuery(name = "TServices.findByDtCREATED", query = "SELECT t FROM TServices t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TServices.findByDtUPDATED", query = "SELECT t FROM TServices t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TServices.findByStrSTATUT", query = "SELECT t FROM TServices t WHERE t.strSTATUT = :strSTATUT")})
public class TServices implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_SERVICES_ID", nullable = false, length = 30)
    private String lgSERVICESID;
    @Column(name = "str_NAME", length = 20)
    private String strNAME;
    @Lob
    @Column(name = "str_DESCRIPTION", length = 65535)
    private String strDESCRIPTION;
    @Column(name = "dt_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCREATED;
    @Column(name = "dt_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUPDATED;
    @Column(name = "str_STATUT", length = 20)
    private String strSTATUT;
    @OneToMany(mappedBy = "lgSERVICESID")
    private Collection<TUserServices> tUserServicesCollection;

    public TServices() {
    }

    public TServices(String lgSERVICESID) {
        this.lgSERVICESID = lgSERVICESID;
    }

    public String getLgSERVICESID() {
        return lgSERVICESID;
    }

    public void setLgSERVICESID(String lgSERVICESID) {
        this.lgSERVICESID = lgSERVICESID;
    }

    public String getStrNAME() {
        return strNAME;
    }

    public void setStrNAME(String strNAME) {
        this.strNAME = strNAME;
    }

    public String getStrDESCRIPTION() {
        return strDESCRIPTION;
    }

    public void setStrDESCRIPTION(String strDESCRIPTION) {
        this.strDESCRIPTION = strDESCRIPTION;
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

    @XmlTransient
    public Collection<TUserServices> getTUserServicesCollection() {
        return tUserServicesCollection;
    }

    public void setTUserServicesCollection(Collection<TUserServices> tUserServicesCollection) {
        this.tUserServicesCollection = tUserServicesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgSERVICESID != null ? lgSERVICESID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TServices)) {
            return false;
        }
        TServices other = (TServices) object;
        if ((this.lgSERVICESID == null && other.lgSERVICESID != null) || (this.lgSERVICESID != null && !this.lgSERVICESID.equals(other.lgSERVICESID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TServices[ lgSERVICESID=" + lgSERVICESID + " ]";
    }
    
}
