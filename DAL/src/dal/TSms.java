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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP PC
 */
@Entity
@Table(name = "t_sms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSms.findAll", query = "SELECT t FROM TSms t"),
    @NamedQuery(name = "TSms.findByIdSms", query = "SELECT t FROM TSms t WHERE t.idSms = :idSms"),
    @NamedQuery(name = "TSms.findByMessage", query = "SELECT t FROM TSms t WHERE t.message = :message"),
    @NamedQuery(name = "TSms.findByDtCREATED", query = "SELECT t FROM TSms t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TSms.findByLgCREATEDBY", query = "SELECT t FROM TSms t WHERE t.lgCREATEDBY = :lgCREATEDBY"),
    @NamedQuery(name = "TSms.findByDtUPDATED", query = "SELECT t FROM TSms t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TSms.findByLgUPDATEDBY", query = "SELECT t FROM TSms t WHERE t.lgUPDATEDBY = :lgUPDATEDBY"),
    @NamedQuery(name = "TSms.findByStatut", query = "SELECT t FROM TSms t WHERE t.statut = :statut")})
public class TSms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SMS", nullable = false, length = 50)
    private String idSms;
    @Column(length = 200)
    private String message;
    @Column(name = "dt_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCREATED;
    @Column(name = "lg_CREATED_BY", length = 20)
    private String lgCREATEDBY;
    @Column(name = "dt_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUPDATED;
    @Column(name = "lg_UPDATED_BY", length = 20)
    private String lgUPDATEDBY;
    @Column(length = 20)
    private String statut;
    @OneToMany(mappedBy = "idSmsMaster")
    private Collection<TSmsNotSend> tSmsNotSendCollection;

    public TSms() {
    }

    public TSms(String idSms) {
        this.idSms = idSms;
    }

    public String getIdSms() {
        return idSms;
    }

    public void setIdSms(String idSms) {
        this.idSms = idSms;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDtCREATED() {
        return dtCREATED;
    }

    public void setDtCREATED(Date dtCREATED) {
        this.dtCREATED = dtCREATED;
    }

    public String getLgCREATEDBY() {
        return lgCREATEDBY;
    }

    public void setLgCREATEDBY(String lgCREATEDBY) {
        this.lgCREATEDBY = lgCREATEDBY;
    }

    public Date getDtUPDATED() {
        return dtUPDATED;
    }

    public void setDtUPDATED(Date dtUPDATED) {
        this.dtUPDATED = dtUPDATED;
    }

    public String getLgUPDATEDBY() {
        return lgUPDATEDBY;
    }

    public void setLgUPDATEDBY(String lgUPDATEDBY) {
        this.lgUPDATEDBY = lgUPDATEDBY;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @XmlTransient
    public Collection<TSmsNotSend> getTSmsNotSendCollection() {
        return tSmsNotSendCollection;
    }

    public void setTSmsNotSendCollection(Collection<TSmsNotSend> tSmsNotSendCollection) {
        this.tSmsNotSendCollection = tSmsNotSendCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSms != null ? idSms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSms)) {
            return false;
        }
        TSms other = (TSms) object;
        if ((this.idSms == null && other.idSms != null) || (this.idSms != null && !this.idSms.equals(other.idSms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TSms[ idSms=" + idSms + " ]";
    }
    
}
