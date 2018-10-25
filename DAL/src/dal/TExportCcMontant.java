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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP PC
 */
@Entity
@Table(name = "t_export_cc_montant", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"dt_CGFCC", "str_CAMPAGNE", "str_NO_FORMULE", "str_EXPORTATEUR", "str_CATEGORIE", "int_MOIS", "int_ANNEE", "str_PRODUIT", "str_NATURE_PRODUIT", "str_TYPE_PRODUIT", "str_PORT_EMBARQUEMENT", "int_POIDS_REEL", "str_VALEUR_TAXE", "int_MONTANT_REELE", "str_NO_CHEQUE", "dt_DATE"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TExportCcMontant.findAll", query = "SELECT t FROM TExportCcMontant t"),
    @NamedQuery(name = "TExportCcMontant.findByLgID", query = "SELECT t FROM TExportCcMontant t WHERE t.lgID = :lgID"),
    @NamedQuery(name = "TExportCcMontant.findByStrREFRESSOURCE", query = "SELECT t FROM TExportCcMontant t WHERE t.strREFRESSOURCE = :strREFRESSOURCE"),
    @NamedQuery(name = "TExportCcMontant.findByDtCGFCC", query = "SELECT t FROM TExportCcMontant t WHERE t.dtCGFCC = :dtCGFCC"),
    @NamedQuery(name = "TExportCcMontant.findByStrCAMPAGNE", query = "SELECT t FROM TExportCcMontant t WHERE t.strCAMPAGNE = :strCAMPAGNE"),
    @NamedQuery(name = "TExportCcMontant.findByStrNOFORMULE", query = "SELECT t FROM TExportCcMontant t WHERE t.strNOFORMULE = :strNOFORMULE"),
    @NamedQuery(name = "TExportCcMontant.findByStrEXPORTATEUR", query = "SELECT t FROM TExportCcMontant t WHERE t.strEXPORTATEUR = :strEXPORTATEUR"),
    @NamedQuery(name = "TExportCcMontant.findByStrTYPEEXPORTATEUR", query = "SELECT t FROM TExportCcMontant t WHERE t.strTYPEEXPORTATEUR = :strTYPEEXPORTATEUR"),
    @NamedQuery(name = "TExportCcMontant.findByStrCATEGORIE", query = "SELECT t FROM TExportCcMontant t WHERE t.strCATEGORIE = :strCATEGORIE"),
    @NamedQuery(name = "TExportCcMontant.findByIntMOIS", query = "SELECT t FROM TExportCcMontant t WHERE t.intMOIS = :intMOIS"),
    @NamedQuery(name = "TExportCcMontant.findByIntANNEE", query = "SELECT t FROM TExportCcMontant t WHERE t.intANNEE = :intANNEE"),
    @NamedQuery(name = "TExportCcMontant.findByStrPRODUIT", query = "SELECT t FROM TExportCcMontant t WHERE t.strPRODUIT = :strPRODUIT"),
    @NamedQuery(name = "TExportCcMontant.findByStrNATUREPRODUIT", query = "SELECT t FROM TExportCcMontant t WHERE t.strNATUREPRODUIT = :strNATUREPRODUIT"),
    @NamedQuery(name = "TExportCcMontant.findByStrTYPEPRODUIT", query = "SELECT t FROM TExportCcMontant t WHERE t.strTYPEPRODUIT = :strTYPEPRODUIT"),
    @NamedQuery(name = "TExportCcMontant.findByStrPORTEMBARQUEMENT", query = "SELECT t FROM TExportCcMontant t WHERE t.strPORTEMBARQUEMENT = :strPORTEMBARQUEMENT"),
    @NamedQuery(name = "TExportCcMontant.findByIntPOIDSFEVE", query = "SELECT t FROM TExportCcMontant t WHERE t.intPOIDSFEVE = :intPOIDSFEVE"),
    @NamedQuery(name = "TExportCcMontant.findByIntPOIDSREEL", query = "SELECT t FROM TExportCcMontant t WHERE t.intPOIDSREEL = :intPOIDSREEL"),
    @NamedQuery(name = "TExportCcMontant.findByStrTAXEREDEVANCE", query = "SELECT t FROM TExportCcMontant t WHERE t.strTAXEREDEVANCE = :strTAXEREDEVANCE"),
    @NamedQuery(name = "TExportCcMontant.findByStrVALEURTAXE", query = "SELECT t FROM TExportCcMontant t WHERE t.strVALEURTAXE = :strVALEURTAXE"),
    @NamedQuery(name = "TExportCcMontant.findByIntMONTANTPRELEVE", query = "SELECT t FROM TExportCcMontant t WHERE t.intMONTANTPRELEVE = :intMONTANTPRELEVE"),
    @NamedQuery(name = "TExportCcMontant.findByIntMONTANTCALCULE", query = "SELECT t FROM TExportCcMontant t WHERE t.intMONTANTCALCULE = :intMONTANTCALCULE"),
    @NamedQuery(name = "TExportCcMontant.findByIntMONTANTREELE", query = "SELECT t FROM TExportCcMontant t WHERE t.intMONTANTREELE = :intMONTANTREELE"),
    @NamedQuery(name = "TExportCcMontant.findByIntREAJUSTEMENT", query = "SELECT t FROM TExportCcMontant t WHERE t.intREAJUSTEMENT = :intREAJUSTEMENT"),
    @NamedQuery(name = "TExportCcMontant.findByStrNOCHEQUE", query = "SELECT t FROM TExportCcMontant t WHERE t.strNOCHEQUE = :strNOCHEQUE"),
    @NamedQuery(name = "TExportCcMontant.findByDtDATE", query = "SELECT t FROM TExportCcMontant t WHERE t.dtDATE = :dtDATE"),
    @NamedQuery(name = "TExportCcMontant.findByStrBANQUE", query = "SELECT t FROM TExportCcMontant t WHERE t.strBANQUE = :strBANQUE"),
    @NamedQuery(name = "TExportCcMontant.findByStrSTATUTFORMULE", query = "SELECT t FROM TExportCcMontant t WHERE t.strSTATUTFORMULE = :strSTATUTFORMULE"),
    @NamedQuery(name = "TExportCcMontant.findByDtCREATED", query = "SELECT t FROM TExportCcMontant t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TExportCcMontant.findByLgCREATEDBY", query = "SELECT t FROM TExportCcMontant t WHERE t.lgCREATEDBY = :lgCREATEDBY"),
    @NamedQuery(name = "TExportCcMontant.findByDtUPDATED", query = "SELECT t FROM TExportCcMontant t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TExportCcMontant.findByLgUPDATEDBY", query = "SELECT t FROM TExportCcMontant t WHERE t.lgUPDATEDBY = :lgUPDATEDBY"),
    @NamedQuery(name = "TExportCcMontant.findByStrSTATUT", query = "SELECT t FROM TExportCcMontant t WHERE t.strSTATUT = :strSTATUT")})
public class TExportCcMontant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_ID", nullable = false, length = 50)
    private String lgID;
    @Column(name = "str_REF_RESSOURCE", length = 200)
    private String strREFRESSOURCE;
    @Column(name = "dt_CGFCC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCGFCC;
    @Column(name = "str_CAMPAGNE", length = 200)
    private String strCAMPAGNE;
    @Column(name = "str_NO_FORMULE", length = 200)
    private String strNOFORMULE;
    @Column(name = "str_EXPORTATEUR", length = 200)
    private String strEXPORTATEUR;
    @Column(name = "str_TYPE_EXPORTATEUR", length = 200)
    private String strTYPEEXPORTATEUR;
    @Column(name = "str_CATEGORIE", length = 200)
    private String strCATEGORIE;
    @Column(name = "int_MOIS")
    private Integer intMOIS;
    @Column(name = "int_ANNEE")
    private Integer intANNEE;
    @Column(name = "str_PRODUIT", length = 200)
    private String strPRODUIT;
    @Column(name = "str_NATURE_PRODUIT", length = 200)
    private String strNATUREPRODUIT;
    @Column(name = "str_TYPE_PRODUIT", length = 200)
    private String strTYPEPRODUIT;
    @Column(name = "str_PORT_EMBARQUEMENT", length = 200)
    private String strPORTEMBARQUEMENT;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "int_POIDS_FEVE", precision = 15, scale = 3)
    private Double intPOIDSFEVE;
    @Column(name = "int_POIDS_REEL", precision = 15, scale = 3)
    private Double intPOIDSREEL;
    @Column(name = "str_TAXE_REDEVANCE", length = 20)
    private String strTAXEREDEVANCE;
    @Column(name = "str_VALEUR_TAXE", length = 200)
    private String strVALEURTAXE;
    @Column(name = "int_MONTANT_PRELEVE", precision = 15, scale = 3)
    private Double intMONTANTPRELEVE;
    @Column(name = "int_MONTANT_CALCULE", precision = 15, scale = 3)
    private Double intMONTANTCALCULE;
    @Column(name = "int_MONTANT_REELE", precision = 15, scale = 3)
    private Double intMONTANTREELE;
    @Column(name = "int_REAJUSTEMENT", precision = 15, scale = 3)
    private Double intREAJUSTEMENT;
    @Column(name = "str_NO_CHEQUE", length = 200)
    private String strNOCHEQUE;
    @Column(name = "dt_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDATE;
    @Column(name = "str_BANQUE", length = 200)
    private String strBANQUE;
    @Column(name = "str_STATUT_FORMULE", length = 200)
    private String strSTATUTFORMULE;
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
    @JoinColumn(name = "lg_FILE_ID", referencedColumnName = "lg_FILE_ID")
    @ManyToOne
    private TFile lgFILEID;

    public TExportCcMontant() {
    }

    public TExportCcMontant(String lgID) {
        this.lgID = lgID;
    }

    public String getLgID() {
        return lgID;
    }

    public void setLgID(String lgID) {
        this.lgID = lgID;
    }

    public String getStrREFRESSOURCE() {
        return strREFRESSOURCE;
    }

    public void setStrREFRESSOURCE(String strREFRESSOURCE) {
        this.strREFRESSOURCE = strREFRESSOURCE;
    }

    public Date getDtCGFCC() {
        return dtCGFCC;
    }

    public void setDtCGFCC(Date dtCGFCC) {
        this.dtCGFCC = dtCGFCC;
    }

    public String getStrCAMPAGNE() {
        return strCAMPAGNE;
    }

    public void setStrCAMPAGNE(String strCAMPAGNE) {
        this.strCAMPAGNE = strCAMPAGNE;
    }

    public String getStrNOFORMULE() {
        return strNOFORMULE;
    }

    public void setStrNOFORMULE(String strNOFORMULE) {
        this.strNOFORMULE = strNOFORMULE;
    }

    public String getStrEXPORTATEUR() {
        return strEXPORTATEUR;
    }

    public void setStrEXPORTATEUR(String strEXPORTATEUR) {
        this.strEXPORTATEUR = strEXPORTATEUR;
    }

    public String getStrTYPEEXPORTATEUR() {
        return strTYPEEXPORTATEUR;
    }

    public void setStrTYPEEXPORTATEUR(String strTYPEEXPORTATEUR) {
        this.strTYPEEXPORTATEUR = strTYPEEXPORTATEUR;
    }

    public String getStrCATEGORIE() {
        return strCATEGORIE;
    }

    public void setStrCATEGORIE(String strCATEGORIE) {
        this.strCATEGORIE = strCATEGORIE;
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

    public String getStrNATUREPRODUIT() {
        return strNATUREPRODUIT;
    }

    public void setStrNATUREPRODUIT(String strNATUREPRODUIT) {
        this.strNATUREPRODUIT = strNATUREPRODUIT;
    }

    public String getStrTYPEPRODUIT() {
        return strTYPEPRODUIT;
    }

    public void setStrTYPEPRODUIT(String strTYPEPRODUIT) {
        this.strTYPEPRODUIT = strTYPEPRODUIT;
    }

    public String getStrPORTEMBARQUEMENT() {
        return strPORTEMBARQUEMENT;
    }

    public void setStrPORTEMBARQUEMENT(String strPORTEMBARQUEMENT) {
        this.strPORTEMBARQUEMENT = strPORTEMBARQUEMENT;
    }

    public Double getIntPOIDSFEVE() {
        return intPOIDSFEVE;
    }

    public void setIntPOIDSFEVE(Double intPOIDSFEVE) {
        this.intPOIDSFEVE = intPOIDSFEVE;
    }

    public Double getIntPOIDSREEL() {
        return intPOIDSREEL;
    }

    public void setIntPOIDSREEL(Double intPOIDSREEL) {
        this.intPOIDSREEL = intPOIDSREEL;
    }

    public String getStrTAXEREDEVANCE() {
        return strTAXEREDEVANCE;
    }

    public void setStrTAXEREDEVANCE(String strTAXEREDEVANCE) {
        this.strTAXEREDEVANCE = strTAXEREDEVANCE;
    }

    public String getStrVALEURTAXE() {
        return strVALEURTAXE;
    }

    public void setStrVALEURTAXE(String strVALEURTAXE) {
        this.strVALEURTAXE = strVALEURTAXE;
    }

    public Double getIntMONTANTPRELEVE() {
        return intMONTANTPRELEVE;
    }

    public void setIntMONTANTPRELEVE(Double intMONTANTPRELEVE) {
        this.intMONTANTPRELEVE = intMONTANTPRELEVE;
    }

    public Double getIntMONTANTCALCULE() {
        return intMONTANTCALCULE;
    }

    public void setIntMONTANTCALCULE(Double intMONTANTCALCULE) {
        this.intMONTANTCALCULE = intMONTANTCALCULE;
    }

    public Double getIntMONTANTREELE() {
        return intMONTANTREELE;
    }

    public void setIntMONTANTREELE(Double intMONTANTREELE) {
        this.intMONTANTREELE = intMONTANTREELE;
    }

    public Double getIntREAJUSTEMENT() {
        return intREAJUSTEMENT;
    }

    public void setIntREAJUSTEMENT(Double intREAJUSTEMENT) {
        this.intREAJUSTEMENT = intREAJUSTEMENT;
    }

    public String getStrNOCHEQUE() {
        return strNOCHEQUE;
    }

    public void setStrNOCHEQUE(String strNOCHEQUE) {
        this.strNOCHEQUE = strNOCHEQUE;
    }

    public Date getDtDATE() {
        return dtDATE;
    }

    public void setDtDATE(Date dtDATE) {
        this.dtDATE = dtDATE;
    }

    public String getStrBANQUE() {
        return strBANQUE;
    }

    public void setStrBANQUE(String strBANQUE) {
        this.strBANQUE = strBANQUE;
    }

    public String getStrSTATUTFORMULE() {
        return strSTATUTFORMULE;
    }

    public void setStrSTATUTFORMULE(String strSTATUTFORMULE) {
        this.strSTATUTFORMULE = strSTATUTFORMULE;
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

    public TFile getLgFILEID() {
        return lgFILEID;
    }

    public void setLgFILEID(TFile lgFILEID) {
        this.lgFILEID = lgFILEID;
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
        if (!(object instanceof TExportCcMontant)) {
            return false;
        }
        TExportCcMontant other = (TExportCcMontant) object;
        if ((this.lgID == null && other.lgID != null) || (this.lgID != null && !this.lgID.equals(other.lgID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TExportCcMontant[ lgID=" + lgID + " ]";
    }
    
}
