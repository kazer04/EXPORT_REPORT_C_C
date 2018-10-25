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
import javax.persistence.Lob;
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
@Table(name = "t_sms_not_send")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSmsNotSend.findAll", query = "SELECT t FROM TSmsNotSend t"),
    @NamedQuery(name = "TSmsNotSend.findByIdSms", query = "SELECT t FROM TSmsNotSend t WHERE t.idSms = :idSms"),
    @NamedQuery(name = "TSmsNotSend.findByExpediteur", query = "SELECT t FROM TSmsNotSend t WHERE t.expediteur = :expediteur"),
    @NamedQuery(name = "TSmsNotSend.findByDestinateur", query = "SELECT t FROM TSmsNotSend t WHERE t.destinateur = :destinateur"),
    @NamedQuery(name = "TSmsNotSend.findByStatut", query = "SELECT t FROM TSmsNotSend t WHERE t.statut = :statut"),
    @NamedQuery(name = "TSmsNotSend.findByCredit", query = "SELECT t FROM TSmsNotSend t WHERE t.credit = :credit"),
    @NamedQuery(name = "TSmsNotSend.findByDtCREATED", query = "SELECT t FROM TSmsNotSend t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TSmsNotSend.findByLgCREATEDBY", query = "SELECT t FROM TSmsNotSend t WHERE t.lgCREATEDBY = :lgCREATEDBY"),
    @NamedQuery(name = "TSmsNotSend.findByDtUPDATED", query = "SELECT t FROM TSmsNotSend t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TSmsNotSend.findByLgUPDATEDBY", query = "SELECT t FROM TSmsNotSend t WHERE t.lgUPDATEDBY = :lgUPDATEDBY")})
public class TSmsNotSend implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SMS", nullable = false, length = 50)
    private String idSms;
    @Column(length = 40)
    private String expediteur;
    @Column(length = 40)
    private String destinateur;
    @Lob
    @Column(length = 65535)
    private String messages;
    @Column(length = 20)
    private String statut;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 15, scale = 3)
    private Double credit;
    @Column(name = "dt_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCREATED;
    @Column(name = "lg_CREATED_BY", length = 50)
    private String lgCREATEDBY;
    @Column(name = "dt_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUPDATED;
    @Column(name = "lg_UPDATED_BY", length = 20)
    private String lgUPDATEDBY;
    @JoinColumn(name = "ID_SMS_MASTER", referencedColumnName = "ID_SMS")
    @ManyToOne
    private TSms idSmsMaster;

    public TSmsNotSend() {
    }

    public TSmsNotSend(String idSms) {
        this.idSms = idSms;
    }

    public String getIdSms() {
        return idSms;
    }

    public void setIdSms(String idSms) {
        this.idSms = idSms;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public String getDestinateur() {
        return destinateur;
    }

    public void setDestinateur(String destinateur) {
        this.destinateur = destinateur;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
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

    public TSms getIdSmsMaster() {
        return idSmsMaster;
    }

    public void setIdSmsMaster(TSms idSmsMaster) {
        this.idSmsMaster = idSmsMaster;
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
        if (!(object instanceof TSmsNotSend)) {
            return false;
        }
        TSmsNotSend other = (TSmsNotSend) object;
        if ((this.idSms == null && other.idSms != null) || (this.idSms != null && !this.idSms.equals(other.idSms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TSmsNotSend[ idSms=" + idSms + " ]";
    }
    
}
