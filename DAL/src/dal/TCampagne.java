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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "t_campagne", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"str_NAME"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCampagne.findAll", query = "SELECT t FROM TCampagne t"),
    @NamedQuery(name = "TCampagne.findByLgCAMPAGNEID", query = "SELECT t FROM TCampagne t WHERE t.lgCAMPAGNEID = :lgCAMPAGNEID"),
    @NamedQuery(name = "TCampagne.findByDtCREATED", query = "SELECT t FROM TCampagne t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TCampagne.findByLgCREATEDBY", query = "SELECT t FROM TCampagne t WHERE t.lgCREATEDBY = :lgCREATEDBY"),
    @NamedQuery(name = "TCampagne.findByDtUPDATED", query = "SELECT t FROM TCampagne t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TCampagne.findByLgUPDATEDBY", query = "SELECT t FROM TCampagne t WHERE t.lgUPDATEDBY = :lgUPDATEDBY"),
    @NamedQuery(name = "TCampagne.findByStrSTATUT", query = "SELECT t FROM TCampagne t WHERE t.strSTATUT = :strSTATUT"),
    @NamedQuery(name = "TCampagne.findByStrNAME", query = "SELECT t FROM TCampagne t WHERE t.strNAME = :strNAME"),
    @NamedQuery(name = "TCampagne.findByStrDEBUTMOIS", query = "SELECT t FROM TCampagne t WHERE t.strDEBUTMOIS = :strDEBUTMOIS"),
    @NamedQuery(name = "TCampagne.findByStrFINMOIS", query = "SELECT t FROM TCampagne t WHERE t.strFINMOIS = :strFINMOIS"),
    @NamedQuery(name = "TCampagne.findByIntID", query = "SELECT t FROM TCampagne t WHERE t.intID = :intID")})
public class TCampagne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_CAMPAGNE_ID", nullable = false, length = 50)
    private String lgCAMPAGNEID;
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
    @Column(name = "str_STATUT", length = 20)
    private String strSTATUT;
    @Column(name = "str_NAME", length = 50)
    private String strNAME;
    @Column(name = "str_DEBUT_MOIS", length = 50)
    private String strDEBUTMOIS;
    @Column(name = "str_FIN_MOIS", length = 50)
    private String strFINMOIS;
    @Column(name = "int_ID")
    private Integer intID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgCAMPAGNEID")
    private Collection<TCampagneMontant> tCampagneMontantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgCAMPAGNEID")
    private Collection<TCampagnePoids> tCampagnePoidsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgCAMPAGNEID")
    private Collection<TCampagneMois> tCampagneMoisCollection;
    @OneToMany(mappedBy = "lgCAMPAGNEID")
    private Collection<TFile> tFileCollection;

    public TCampagne() {
    }

    public TCampagne(String lgCAMPAGNEID) {
        this.lgCAMPAGNEID = lgCAMPAGNEID;
    }

    public String getLgCAMPAGNEID() {
        return lgCAMPAGNEID;
    }

    public void setLgCAMPAGNEID(String lgCAMPAGNEID) {
        this.lgCAMPAGNEID = lgCAMPAGNEID;
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

    public String getStrSTATUT() {
        return strSTATUT;
    }

    public void setStrSTATUT(String strSTATUT) {
        this.strSTATUT = strSTATUT;
    }

    public String getStrNAME() {
        return strNAME;
    }

    public void setStrNAME(String strNAME) {
        this.strNAME = strNAME;
    }

    public String getStrDEBUTMOIS() {
        return strDEBUTMOIS;
    }

    public void setStrDEBUTMOIS(String strDEBUTMOIS) {
        this.strDEBUTMOIS = strDEBUTMOIS;
    }

    public String getStrFINMOIS() {
        return strFINMOIS;
    }

    public void setStrFINMOIS(String strFINMOIS) {
        this.strFINMOIS = strFINMOIS;
    }

    public Integer getIntID() {
        return intID;
    }

    public void setIntID(Integer intID) {
        this.intID = intID;
    }

    @XmlTransient
    public Collection<TCampagneMontant> getTCampagneMontantCollection() {
        return tCampagneMontantCollection;
    }

    public void setTCampagneMontantCollection(Collection<TCampagneMontant> tCampagneMontantCollection) {
        this.tCampagneMontantCollection = tCampagneMontantCollection;
    }

    @XmlTransient
    public Collection<TCampagnePoids> getTCampagnePoidsCollection() {
        return tCampagnePoidsCollection;
    }

    public void setTCampagnePoidsCollection(Collection<TCampagnePoids> tCampagnePoidsCollection) {
        this.tCampagnePoidsCollection = tCampagnePoidsCollection;
    }

    @XmlTransient
    public Collection<TCampagneMois> getTCampagneMoisCollection() {
        return tCampagneMoisCollection;
    }

    public void setTCampagneMoisCollection(Collection<TCampagneMois> tCampagneMoisCollection) {
        this.tCampagneMoisCollection = tCampagneMoisCollection;
    }

    @XmlTransient
    public Collection<TFile> getTFileCollection() {
        return tFileCollection;
    }

    public void setTFileCollection(Collection<TFile> tFileCollection) {
        this.tFileCollection = tFileCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgCAMPAGNEID != null ? lgCAMPAGNEID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCampagne)) {
            return false;
        }
        TCampagne other = (TCampagne) object;
        if ((this.lgCAMPAGNEID == null && other.lgCAMPAGNEID != null) || (this.lgCAMPAGNEID != null && !this.lgCAMPAGNEID.equals(other.lgCAMPAGNEID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TCampagne[ lgCAMPAGNEID=" + lgCAMPAGNEID + " ]";
    }
    
}
