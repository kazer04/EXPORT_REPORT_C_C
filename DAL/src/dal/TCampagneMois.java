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
@Table(name = "t_campagne_mois")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCampagneMois.findAll", query = "SELECT t FROM TCampagneMois t"),
    @NamedQuery(name = "TCampagneMois.findByLgID", query = "SELECT t FROM TCampagneMois t WHERE t.lgID = :lgID"),
    @NamedQuery(name = "TCampagneMois.findByDtCREATED", query = "SELECT t FROM TCampagneMois t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TCampagneMois.findByLgCREATEDBY", query = "SELECT t FROM TCampagneMois t WHERE t.lgCREATEDBY = :lgCREATEDBY"),
    @NamedQuery(name = "TCampagneMois.findByDtUPDATED", query = "SELECT t FROM TCampagneMois t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TCampagneMois.findByLgUPDATEDBY", query = "SELECT t FROM TCampagneMois t WHERE t.lgUPDATEDBY = :lgUPDATEDBY"),
    @NamedQuery(name = "TCampagneMois.findByStrSTATUT", query = "SELECT t FROM TCampagneMois t WHERE t.strSTATUT = :strSTATUT"),
    @NamedQuery(name = "TCampagneMois.findByStrNAME", query = "SELECT t FROM TCampagneMois t WHERE t.strNAME = :strNAME"),
    @NamedQuery(name = "TCampagneMois.findByIntMOIS", query = "SELECT t FROM TCampagneMois t WHERE t.intMOIS = :intMOIS"),
    @NamedQuery(name = "TCampagneMois.findByIntANNEE", query = "SELECT t FROM TCampagneMois t WHERE t.intANNEE = :intANNEE"),
    @NamedQuery(name = "TCampagneMois.findByStrPRODUIT", query = "SELECT t FROM TCampagneMois t WHERE t.strPRODUIT = :strPRODUIT")})
public class TCampagneMois implements Serializable {
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
    @Column(name = "int_MOIS")
    private Integer intMOIS;
    @Column(name = "int_ANNEE")
    private Integer intANNEE;
    @Column(name = "str_PRODUIT", length = 20)
    private String strPRODUIT;
    @JoinColumn(name = "lg_CAMPAGNE_ID", referencedColumnName = "lg_CAMPAGNE_ID", nullable = false)
    @ManyToOne(optional = false)
    private TCampagne lgCAMPAGNEID;

    public TCampagneMois() {
    }

    public TCampagneMois(String lgID) {
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

    public Integer getIntMOIS() {
        return intMOIS;
    }

    public void setIntMOIS(Integer intMOIS) {
        this.intMOIS = intMOIS;
    }

    public Integer getIntANNEE() {
        return intANNEE;
    }

    public void setIntANNEE(Integer intANNEE) {
        this.intANNEE = intANNEE;
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
        if (!(object instanceof TCampagneMois)) {
            return false;
        }
        TCampagneMois other = (TCampagneMois) object;
        if ((this.lgID == null && other.lgID != null) || (this.lgID != null && !this.lgID.equals(other.lgID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TCampagneMois[ lgID=" + lgID + " ]";
    }
    
}
