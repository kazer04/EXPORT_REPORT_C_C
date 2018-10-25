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
@Table(name = "t_campagne_poids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCampagnePoids.findAll", query = "SELECT t FROM TCampagnePoids t"),
    @NamedQuery(name = "TCampagnePoids.findByLgID", query = "SELECT t FROM TCampagnePoids t WHERE t.lgID = :lgID"),
    @NamedQuery(name = "TCampagnePoids.findByDtCREATED", query = "SELECT t FROM TCampagnePoids t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TCampagnePoids.findByLgCREATEDBY", query = "SELECT t FROM TCampagnePoids t WHERE t.lgCREATEDBY = :lgCREATEDBY"),
    @NamedQuery(name = "TCampagnePoids.findByDtUPDATED", query = "SELECT t FROM TCampagnePoids t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TCampagnePoids.findByLgUPDATEDBY", query = "SELECT t FROM TCampagnePoids t WHERE t.lgUPDATEDBY = :lgUPDATEDBY"),
    @NamedQuery(name = "TCampagnePoids.findByStrSTATUT", query = "SELECT t FROM TCampagnePoids t WHERE t.strSTATUT = :strSTATUT"),
    @NamedQuery(name = "TCampagnePoids.findByStrNAME", query = "SELECT t FROM TCampagnePoids t WHERE t.strNAME = :strNAME"),
    @NamedQuery(name = "TCampagnePoids.findByIntPOIDS", query = "SELECT t FROM TCampagnePoids t WHERE t.intPOIDS = :intPOIDS"),
    @NamedQuery(name = "TCampagnePoids.findByStrTYPEPRODUIT", query = "SELECT t FROM TCampagnePoids t WHERE t.strTYPEPRODUIT = :strTYPEPRODUIT"),
    @NamedQuery(name = "TCampagnePoids.findByIntID", query = "SELECT t FROM TCampagnePoids t WHERE t.intID = :intID"),
    @NamedQuery(name = "TCampagnePoids.findByStrPORTEMBARQUEMENT", query = "SELECT t FROM TCampagnePoids t WHERE t.strPORTEMBARQUEMENT = :strPORTEMBARQUEMENT"),
    @NamedQuery(name = "TCampagnePoids.findByIntANNEE", query = "SELECT t FROM TCampagnePoids t WHERE t.intANNEE = :intANNEE"),
    @NamedQuery(name = "TCampagnePoids.findByIntMOIS", query = "SELECT t FROM TCampagnePoids t WHERE t.intMOIS = :intMOIS"),
    @NamedQuery(name = "TCampagnePoids.findByStrREFEXPORT", query = "SELECT t FROM TCampagnePoids t WHERE t.strREFEXPORT = :strREFEXPORT"),
    @NamedQuery(name = "TCampagnePoids.findByStrTYPEEXPORTATEUR", query = "SELECT t FROM TCampagnePoids t WHERE t.strTYPEEXPORTATEUR = :strTYPEEXPORTATEUR"),
    @NamedQuery(name = "TCampagnePoids.findByStrPRODUIT", query = "SELECT t FROM TCampagnePoids t WHERE t.strPRODUIT = :strPRODUIT")})
public class TCampagnePoids implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_ID", nullable = false, length = 50)
    private String lgID;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "int_POIDS", precision = 15, scale = 3)
    private Double intPOIDS;
    @Column(name = "str_TYPE_PRODUIT", length = 50)
    private String strTYPEPRODUIT;
    @Column(name = "int_ID")
    private Integer intID;
    @Column(name = "str_PORT_EMBARQUEMENT", length = 50)
    private String strPORTEMBARQUEMENT;
    @Column(name = "int_ANNEE")
    private Integer intANNEE;
    @Column(name = "int_MOIS")
    private Integer intMOIS;
    @Column(name = "str_REF_EXPORT", length = 40)
    private String strREFEXPORT;
    @Column(name = "str_TYPE_EXPORTATEUR", length = 40)
    private String strTYPEEXPORTATEUR;
    @Column(name = "str_PRODUIT", length = 20)
    private String strPRODUIT;
    @JoinColumn(name = "lg_CAMPAGNE_ID", referencedColumnName = "lg_CAMPAGNE_ID", nullable = false)
    @ManyToOne(optional = false)
    private TCampagne lgCAMPAGNEID;

    public TCampagnePoids() {
    }

    public TCampagnePoids(String lgID) {
        this.lgID = lgID;
    }

    public String getLgID() {
        return lgID;
    }

    public void setLgID(String lgID) {
        this.lgID = lgID;
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

    public Double getIntPOIDS() {
        return intPOIDS;
    }

    public void setIntPOIDS(Double intPOIDS) {
        this.intPOIDS = intPOIDS;
    }

    public String getStrTYPEPRODUIT() {
        return strTYPEPRODUIT;
    }

    public void setStrTYPEPRODUIT(String strTYPEPRODUIT) {
        this.strTYPEPRODUIT = strTYPEPRODUIT;
    }

    public Integer getIntID() {
        return intID;
    }

    public void setIntID(Integer intID) {
        this.intID = intID;
    }

    public String getStrPORTEMBARQUEMENT() {
        return strPORTEMBARQUEMENT;
    }

    public void setStrPORTEMBARQUEMENT(String strPORTEMBARQUEMENT) {
        this.strPORTEMBARQUEMENT = strPORTEMBARQUEMENT;
    }

    public Integer getIntANNEE() {
        return intANNEE;
    }

    public void setIntANNEE(Integer intANNEE) {
        this.intANNEE = intANNEE;
    }

    public Integer getIntMOIS() {
        return intMOIS;
    }

    public void setIntMOIS(Integer intMOIS) {
        this.intMOIS = intMOIS;
    }

    public String getStrREFEXPORT() {
        return strREFEXPORT;
    }

    public void setStrREFEXPORT(String strREFEXPORT) {
        this.strREFEXPORT = strREFEXPORT;
    }

    public String getStrTYPEEXPORTATEUR() {
        return strTYPEEXPORTATEUR;
    }

    public void setStrTYPEEXPORTATEUR(String strTYPEEXPORTATEUR) {
        this.strTYPEEXPORTATEUR = strTYPEEXPORTATEUR;
    }

    public String getStrPRODUIT() {
        return strPRODUIT;
    }

    public void setStrPRODUIT(String strPRODUIT) {
        this.strPRODUIT = strPRODUIT;
    }

    public TCampagne getLgCAMPAGNEID() {
        return lgCAMPAGNEID;
    }

    public void setLgCAMPAGNEID(TCampagne lgCAMPAGNEID) {
        this.lgCAMPAGNEID = lgCAMPAGNEID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgID != null ? lgID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCampagnePoids)) {
            return false;
        }
        TCampagnePoids other = (TCampagnePoids) object;
        if ((this.lgID == null && other.lgID != null) || (this.lgID != null && !this.lgID.equals(other.lgID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TCampagnePoids[ lgID=" + lgID + " ]";
    }
    
}