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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "t_file")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TFile.findAll", query = "SELECT t FROM TFile t"),
    @NamedQuery(name = "TFile.findByLgFILEID", query = "SELECT t FROM TFile t WHERE t.lgFILEID = :lgFILEID"),
    @NamedQuery(name = "TFile.findByStrPATH", query = "SELECT t FROM TFile t WHERE t.strPATH = :strPATH"),
    @NamedQuery(name = "TFile.findByStrTYPE", query = "SELECT t FROM TFile t WHERE t.strTYPE = :strTYPE"),
    @NamedQuery(name = "TFile.findByStrDATA", query = "SELECT t FROM TFile t WHERE t.strDATA = :strDATA"),
    @NamedQuery(name = "TFile.findByStrRETURNDATA", query = "SELECT t FROM TFile t WHERE t.strRETURNDATA = :strRETURNDATA"),
    @NamedQuery(name = "TFile.findByStrREF", query = "SELECT t FROM TFile t WHERE t.strREF = :strREF"),
    @NamedQuery(name = "TFile.findByDtCREATED", query = "SELECT t FROM TFile t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TFile.findByLgCREATEDBY", query = "SELECT t FROM TFile t WHERE t.lgCREATEDBY = :lgCREATEDBY"),
    @NamedQuery(name = "TFile.findByDtUPDATED", query = "SELECT t FROM TFile t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TFile.findByLgUPDATEDBY", query = "SELECT t FROM TFile t WHERE t.lgUPDATEDBY = :lgUPDATEDBY"),
    @NamedQuery(name = "TFile.findByStrSTATUT", query = "SELECT t FROM TFile t WHERE t.strSTATUT = :strSTATUT"),
    @NamedQuery(name = "TFile.findByStrNAME", query = "SELECT t FROM TFile t WHERE t.strNAME = :strNAME"),
    @NamedQuery(name = "TFile.findByIntNBELEMENTS", query = "SELECT t FROM TFile t WHERE t.intNBELEMENTS = :intNBELEMENTS")})
public class TFile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_FILE_ID", nullable = false, length = 50)
    private String lgFILEID;
    @Column(name = "str_PATH", length = 200)
    private String strPATH;
    @Column(name = "str_TYPE", length = 200)
    private String strTYPE;
    @Column(name = "str_DATA", length = 200)
    private String strDATA;
    @Column(name = "str_RETURN_DATA", length = 200)
    private String strRETURNDATA;
    @Column(name = "str_REF", length = 200)
    private String strREF;
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
    @Column(name = "int_NB_ELEMENTS")
    private Integer intNBELEMENTS;
    @OneToMany(mappedBy = "lgFILEID")
    private Collection<TExportCcPoids> tExportCcPoidsCollection;
    @JoinColumn(name = "lg_CAMPAGNE_ID", referencedColumnName = "lg_CAMPAGNE_ID")
    @ManyToOne
    private TCampagne lgCAMPAGNEID;
    @OneToMany(mappedBy = "lgFILEID")
    private Collection<TExportCcMontant> tExportCcMontantCollection;

    public TFile() {
    }

    public TFile(String lgFILEID) {
        this.lgFILEID = lgFILEID;
    }

    public String getLgFILEID() {
        return lgFILEID;
    }

    public void setLgFILEID(String lgFILEID) {
        this.lgFILEID = lgFILEID;
    }

    public String getStrPATH() {
        return strPATH;
    }

    public void setStrPATH(String strPATH) {
        this.strPATH = strPATH;
    }

    public String getStrTYPE() {
        return strTYPE;
    }

    public void setStrTYPE(String strTYPE) {
        this.strTYPE = strTYPE;
    }

    public String getStrDATA() {
        return strDATA;
    }

    public void setStrDATA(String strDATA) {
        this.strDATA = strDATA;
    }

    public String getStrRETURNDATA() {
        return strRETURNDATA;
    }

    public void setStrRETURNDATA(String strRETURNDATA) {
        this.strRETURNDATA = strRETURNDATA;
    }

    public String getStrREF() {
        return strREF;
    }

    public void setStrREF(String strREF) {
        this.strREF = strREF;
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

    public Integer getIntNBELEMENTS() {
        return intNBELEMENTS;
    }

    public void setIntNBELEMENTS(Integer intNBELEMENTS) {
        this.intNBELEMENTS = intNBELEMENTS;
    }

    @XmlTransient
    public Collection<TExportCcPoids> getTExportCcPoidsCollection() {
        return tExportCcPoidsCollection;
    }

    public void setTExportCcPoidsCollection(Collection<TExportCcPoids> tExportCcPoidsCollection) {
        this.tExportCcPoidsCollection = tExportCcPoidsCollection;
    }

    public TCampagne getLgCAMPAGNEID() {
        return lgCAMPAGNEID;
    }

    public void setLgCAMPAGNEID(TCampagne lgCAMPAGNEID) {
        this.lgCAMPAGNEID = lgCAMPAGNEID;
    }

    @XmlTransient
    public Collection<TExportCcMontant> getTExportCcMontantCollection() {
        return tExportCcMontantCollection;
    }

    public void setTExportCcMontantCollection(Collection<TExportCcMontant> tExportCcMontantCollection) {
        this.tExportCcMontantCollection = tExportCcMontantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgFILEID != null ? lgFILEID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TFile)) {
            return false;
        }
        TFile other = (TFile) object;
        if ((this.lgFILEID == null && other.lgFILEID != null) || (this.lgFILEID != null && !this.lgFILEID.equals(other.lgFILEID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TFile[ lgFILEID=" + lgFILEID + " ]";
    }
    
}
