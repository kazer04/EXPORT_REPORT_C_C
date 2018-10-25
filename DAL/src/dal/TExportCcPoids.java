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
@Table(name = "t_export_cc_poids", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"str_CAMPAGNE", "str_NO_FORMULE", "dt_CGFCC", "int_MOIS", "int_ANNEE", "str_EXPORTATEUR", "str_TYPE_EXPORTATEUR", "str_CATEGORIE", "str_TRANSITAIRE", "str_PORT_EMBARQUEMENT", "str_PORT_DESTINATION", "str_PRODUIT", "str_NATURE_PRODUIT", "str_RECOLTE", "str_TYPE_PRODUIT", "int_PRIX_CAF"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TExportCcPoids.findAll", query = "SELECT t FROM TExportCcPoids t"),
    @NamedQuery(name = "TExportCcPoids.findByLgID", query = "SELECT t FROM TExportCcPoids t WHERE t.lgID = :lgID"),
    @NamedQuery(name = "TExportCcPoids.findByStrREFRESSOURCE", query = "SELECT t FROM TExportCcPoids t WHERE t.strREFRESSOURCE = :strREFRESSOURCE"),
    @NamedQuery(name = "TExportCcPoids.findByStrCAMPAGNE", query = "SELECT t FROM TExportCcPoids t WHERE t.strCAMPAGNE = :strCAMPAGNE"),
    @NamedQuery(name = "TExportCcPoids.findByStrNOFORMULE", query = "SELECT t FROM TExportCcPoids t WHERE t.strNOFORMULE = :strNOFORMULE"),
    @NamedQuery(name = "TExportCcPoids.findByDtCGFCC", query = "SELECT t FROM TExportCcPoids t WHERE t.dtCGFCC = :dtCGFCC"),
    @NamedQuery(name = "TExportCcPoids.findByIntMOIS", query = "SELECT t FROM TExportCcPoids t WHERE t.intMOIS = :intMOIS"),
    @NamedQuery(name = "TExportCcPoids.findByIntANNEE", query = "SELECT t FROM TExportCcPoids t WHERE t.intANNEE = :intANNEE"),
    @NamedQuery(name = "TExportCcPoids.findByStrEXPORTATEUR", query = "SELECT t FROM TExportCcPoids t WHERE t.strEXPORTATEUR = :strEXPORTATEUR"),
    @NamedQuery(name = "TExportCcPoids.findByStrTYPEEXPORTATEUR", query = "SELECT t FROM TExportCcPoids t WHERE t.strTYPEEXPORTATEUR = :strTYPEEXPORTATEUR"),
    @NamedQuery(name = "TExportCcPoids.findByStrCATEGORIE", query = "SELECT t FROM TExportCcPoids t WHERE t.strCATEGORIE = :strCATEGORIE"),
    @NamedQuery(name = "TExportCcPoids.findByStrTRANSITAIRE", query = "SELECT t FROM TExportCcPoids t WHERE t.strTRANSITAIRE = :strTRANSITAIRE"),
    @NamedQuery(name = "TExportCcPoids.findByStrPORTEMBARQUEMENT", query = "SELECT t FROM TExportCcPoids t WHERE t.strPORTEMBARQUEMENT = :strPORTEMBARQUEMENT"),
    @NamedQuery(name = "TExportCcPoids.findByStrCONTINENTDESTINATION", query = "SELECT t FROM TExportCcPoids t WHERE t.strCONTINENTDESTINATION = :strCONTINENTDESTINATION"),
    @NamedQuery(name = "TExportCcPoids.findByStrPAYSDESTINATION", query = "SELECT t FROM TExportCcPoids t WHERE t.strPAYSDESTINATION = :strPAYSDESTINATION"),
    @NamedQuery(name = "TExportCcPoids.findByStrPORTDESTINATION", query = "SELECT t FROM TExportCcPoids t WHERE t.strPORTDESTINATION = :strPORTDESTINATION"),
    @NamedQuery(name = "TExportCcPoids.findByStrPRODUIT", query = "SELECT t FROM TExportCcPoids t WHERE t.strPRODUIT = :strPRODUIT"),
    @NamedQuery(name = "TExportCcPoids.findByStrNATUREPRODUIT", query = "SELECT t FROM TExportCcPoids t WHERE t.strNATUREPRODUIT = :strNATUREPRODUIT"),
    @NamedQuery(name = "TExportCcPoids.findByStrRECOLTE", query = "SELECT t FROM TExportCcPoids t WHERE t.strRECOLTE = :strRECOLTE"),
    @NamedQuery(name = "TExportCcPoids.findByStrTYPEPRODUIT", query = "SELECT t FROM TExportCcPoids t WHERE t.strTYPEPRODUIT = :strTYPEPRODUIT"),
    @NamedQuery(name = "TExportCcPoids.findByIntPRIXCAF", query = "SELECT t FROM TExportCcPoids t WHERE t.intPRIXCAF = :intPRIXCAF"),
    @NamedQuery(name = "TExportCcPoids.findByStrTXTNULL", query = "SELECT t FROM TExportCcPoids t WHERE t.strTXTNULL = :strTXTNULL"),
    @NamedQuery(name = "TExportCcPoids.findByStrNUMEROCDC", query = "SELECT t FROM TExportCcPoids t WHERE t.strNUMEROCDC = :strNUMEROCDC"),
    @NamedQuery(name = "TExportCcPoids.findByIntPOIDSNET", query = "SELECT t FROM TExportCcPoids t WHERE t.intPOIDSNET = :intPOIDSNET"),
    @NamedQuery(name = "TExportCcPoids.findByIntPOIDSFEVE", query = "SELECT t FROM TExportCcPoids t WHERE t.intPOIDSFEVE = :intPOIDSFEVE"),
    @NamedQuery(name = "TExportCcPoids.findByIntPOIDSREEL", query = "SELECT t FROM TExportCcPoids t WHERE t.intPOIDSREEL = :intPOIDSREEL"),
    @NamedQuery(name = "TExportCcPoids.findByStrSTATUTFORMULE", query = "SELECT t FROM TExportCcPoids t WHERE t.strSTATUTFORMULE = :strSTATUTFORMULE"),
    @NamedQuery(name = "TExportCcPoids.findByStrNUMEROCERTIFICAT", query = "SELECT t FROM TExportCcPoids t WHERE t.strNUMEROCERTIFICAT = :strNUMEROCERTIFICAT"),
    @NamedQuery(name = "TExportCcPoids.findByStrTRANSIT", query = "SELECT t FROM TExportCcPoids t WHERE t.strTRANSIT = :strTRANSIT"),
    @NamedQuery(name = "TExportCcPoids.findByDtRECULE", query = "SELECT t FROM TExportCcPoids t WHERE t.dtRECULE = :dtRECULE"),
    @NamedQuery(name = "TExportCcPoids.findByStrDEPOT", query = "SELECT t FROM TExportCcPoids t WHERE t.strDEPOT = :strDEPOT"),
    @NamedQuery(name = "TExportCcPoids.findByDtDEPOSELE", query = "SELECT t FROM TExportCcPoids t WHERE t.dtDEPOSELE = :dtDEPOSELE"),
    @NamedQuery(name = "TExportCcPoids.findByStrSIGNE", query = "SELECT t FROM TExportCcPoids t WHERE t.strSIGNE = :strSIGNE"),
    @NamedQuery(name = "TExportCcPoids.findByDtSIGNELE", query = "SELECT t FROM TExportCcPoids t WHERE t.dtSIGNELE = :dtSIGNELE"),
    @NamedQuery(name = "TExportCcPoids.findByStrRETIRE", query = "SELECT t FROM TExportCcPoids t WHERE t.strRETIRE = :strRETIRE"),
    @NamedQuery(name = "TExportCcPoids.findByDtRETIRELE", query = "SELECT t FROM TExportCcPoids t WHERE t.dtRETIRELE = :dtRETIRELE"),
    @NamedQuery(name = "TExportCcPoids.findByStrRETIRANT", query = "SELECT t FROM TExportCcPoids t WHERE t.strRETIRANT = :strRETIRANT"),
    @NamedQuery(name = "TExportCcPoids.findByStrPERIODE", query = "SELECT t FROM TExportCcPoids t WHERE t.strPERIODE = :strPERIODE"),
    @NamedQuery(name = "TExportCcPoids.findByStrNOMENCLATURE", query = "SELECT t FROM TExportCcPoids t WHERE t.strNOMENCLATURE = :strNOMENCLATURE"),
    @NamedQuery(name = "TExportCcPoids.findByDtCREATED", query = "SELECT t FROM TExportCcPoids t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TExportCcPoids.findByLgCREATEDBY", query = "SELECT t FROM TExportCcPoids t WHERE t.lgCREATEDBY = :lgCREATEDBY"),
    @NamedQuery(name = "TExportCcPoids.findByDtUPDATED", query = "SELECT t FROM TExportCcPoids t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TExportCcPoids.findByLgUPDATEDBY", query = "SELECT t FROM TExportCcPoids t WHERE t.lgUPDATEDBY = :lgUPDATEDBY"),
    @NamedQuery(name = "TExportCcPoids.findByStrSTATUT", query = "SELECT t FROM TExportCcPoids t WHERE t.strSTATUT = :strSTATUT")})
public class TExportCcPoids implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_ID", nullable = false, length = 50)
    private String lgID;
    @Column(name = "str_REF_RESSOURCE", length = 200)
    private String strREFRESSOURCE;
    @Column(name = "str_CAMPAGNE", length = 200)
    private String strCAMPAGNE;
    @Column(name = "str_NO_FORMULE", length = 200)
    private String strNOFORMULE;
    @Column(name = "dt_CGFCC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCGFCC;
    @Column(name = "int_MOIS")
    private Integer intMOIS;
    @Column(name = "int_ANNEE")
    private Integer intANNEE;
    @Column(name = "str_EXPORTATEUR", length = 200)
    private String strEXPORTATEUR;
    @Column(name = "str_TYPE_EXPORTATEUR", length = 200)
    private String strTYPEEXPORTATEUR;
    @Column(name = "str_CATEGORIE", length = 200)
    private String strCATEGORIE;
    @Column(name = "str_TRANSITAIRE", length = 200)
    private String strTRANSITAIRE;
    @Column(name = "str_PORT_EMBARQUEMENT", length = 200)
    private String strPORTEMBARQUEMENT;
    @Column(name = "str_CONTINENT_DESTINATION", length = 200)
    private String strCONTINENTDESTINATION;
    @Column(name = "str_PAYS_DESTINATION", length = 200)
    private String strPAYSDESTINATION;
    @Column(name = "str_PORT_DESTINATION", length = 200)
    private String strPORTDESTINATION;
    @Column(name = "str_PRODUIT", length = 200)
    private String strPRODUIT;
    @Column(name = "str_NATURE_PRODUIT", length = 200)
    private String strNATUREPRODUIT;
    @Column(name = "str_RECOLTE", length = 200)
    private String strRECOLTE;
    @Column(name = "str_TYPE_PRODUIT", length = 200)
    private String strTYPEPRODUIT;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "int_PRIX_CAF", precision = 15, scale = 3)
    private Double intPRIXCAF;
    @Column(name = "str_TXT_NULL", length = 200)
    private String strTXTNULL;
    @Column(name = "str_NUMERO_CDC", length = 200)
    private String strNUMEROCDC;
    @Column(name = "int_POIDS_NET", precision = 15, scale = 3)
    private Double intPOIDSNET;
    @Column(name = "int_POIDS_FEVE", precision = 15, scale = 3)
    private Double intPOIDSFEVE;
    @Column(name = "int_POIDS_REEL", precision = 15, scale = 3)
    private Double intPOIDSREEL;
    @Column(name = "str_STATUT_FORMULE", length = 200)
    private String strSTATUTFORMULE;
    @Column(name = "str_NUMERO_CERTIFICAT", length = 200)
    private String strNUMEROCERTIFICAT;
    @Column(name = "str_TRANSIT", length = 200)
    private String strTRANSIT;
    @Column(name = "dt_RECU_LE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtRECULE;
    @Column(name = "str_DEPOT", length = 200)
    private String strDEPOT;
    @Column(name = "dt_DEPOSE_LE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDEPOSELE;
    @Column(name = "str_SIGNE", length = 200)
    private String strSIGNE;
    @Column(name = "dt_SIGNE_LE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtSIGNELE;
    @Column(name = "str_RETIRE", length = 200)
    private String strRETIRE;
    @Column(name = "dt_RETIRE_LE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtRETIRELE;
    @Column(name = "str_RETIRANT", length = 200)
    private String strRETIRANT;
    @Column(name = "str_PERIODE", length = 200)
    private String strPERIODE;
    @Column(name = "str_NOMENCLATURE", length = 200)
    private String strNOMENCLATURE;
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

    public TExportCcPoids() {
    }

    public TExportCcPoids(String lgID) {
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

    public Date getDtCGFCC() {
        return dtCGFCC;
    }

    public void setDtCGFCC(Date dtCGFCC) {
        this.dtCGFCC = dtCGFCC;
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

    public String getStrTRANSITAIRE() {
        return strTRANSITAIRE;
    }

    public void setStrTRANSITAIRE(String strTRANSITAIRE) {
        this.strTRANSITAIRE = strTRANSITAIRE;
    }

    public String getStrPORTEMBARQUEMENT() {
        return strPORTEMBARQUEMENT;
    }

    public void setStrPORTEMBARQUEMENT(String strPORTEMBARQUEMENT) {
        this.strPORTEMBARQUEMENT = strPORTEMBARQUEMENT;
    }

    public String getStrCONTINENTDESTINATION() {
        return strCONTINENTDESTINATION;
    }

    public void setStrCONTINENTDESTINATION(String strCONTINENTDESTINATION) {
        this.strCONTINENTDESTINATION = strCONTINENTDESTINATION;
    }

    public String getStrPAYSDESTINATION() {
        return strPAYSDESTINATION;
    }

    public void setStrPAYSDESTINATION(String strPAYSDESTINATION) {
        this.strPAYSDESTINATION = strPAYSDESTINATION;
    }

    public String getStrPORTDESTINATION() {
        return strPORTDESTINATION;
    }

    public void setStrPORTDESTINATION(String strPORTDESTINATION) {
        this.strPORTDESTINATION = strPORTDESTINATION;
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

    public String getStrRECOLTE() {
        return strRECOLTE;
    }

    public void setStrRECOLTE(String strRECOLTE) {
        this.strRECOLTE = strRECOLTE;
    }

    public String getStrTYPEPRODUIT() {
        return strTYPEPRODUIT;
    }

    public void setStrTYPEPRODUIT(String strTYPEPRODUIT) {
        this.strTYPEPRODUIT = strTYPEPRODUIT;
    }

    public Double getIntPRIXCAF() {
        return intPRIXCAF;
    }

    public void setIntPRIXCAF(Double intPRIXCAF) {
        this.intPRIXCAF = intPRIXCAF;
    }

    public String getStrTXTNULL() {
        return strTXTNULL;
    }

    public void setStrTXTNULL(String strTXTNULL) {
        this.strTXTNULL = strTXTNULL;
    }

    public String getStrNUMEROCDC() {
        return strNUMEROCDC;
    }

    public void setStrNUMEROCDC(String strNUMEROCDC) {
        this.strNUMEROCDC = strNUMEROCDC;
    }

    public Double getIntPOIDSNET() {
        return intPOIDSNET;
    }

    public void setIntPOIDSNET(Double intPOIDSNET) {
        this.intPOIDSNET = intPOIDSNET;
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

    public String getStrSTATUTFORMULE() {
        return strSTATUTFORMULE;
    }

    public void setStrSTATUTFORMULE(String strSTATUTFORMULE) {
        this.strSTATUTFORMULE = strSTATUTFORMULE;
    }

    public String getStrNUMEROCERTIFICAT() {
        return strNUMEROCERTIFICAT;
    }

    public void setStrNUMEROCERTIFICAT(String strNUMEROCERTIFICAT) {
        this.strNUMEROCERTIFICAT = strNUMEROCERTIFICAT;
    }

    public String getStrTRANSIT() {
        return strTRANSIT;
    }

    public void setStrTRANSIT(String strTRANSIT) {
        this.strTRANSIT = strTRANSIT;
    }

    public Date getDtRECULE() {
        return dtRECULE;
    }

    public void setDtRECULE(Date dtRECULE) {
        this.dtRECULE = dtRECULE;
    }

    public String getStrDEPOT() {
        return strDEPOT;
    }

    public void setStrDEPOT(String strDEPOT) {
        this.strDEPOT = strDEPOT;
    }

    public Date getDtDEPOSELE() {
        return dtDEPOSELE;
    }

    public void setDtDEPOSELE(Date dtDEPOSELE) {
        this.dtDEPOSELE = dtDEPOSELE;
    }

    public String getStrSIGNE() {
        return strSIGNE;
    }

    public void setStrSIGNE(String strSIGNE) {
        this.strSIGNE = strSIGNE;
    }

    public Date getDtSIGNELE() {
        return dtSIGNELE;
    }

    public void setDtSIGNELE(Date dtSIGNELE) {
        this.dtSIGNELE = dtSIGNELE;
    }

    public String getStrRETIRE() {
        return strRETIRE;
    }

    public void setStrRETIRE(String strRETIRE) {
        this.strRETIRE = strRETIRE;
    }

    public Date getDtRETIRELE() {
        return dtRETIRELE;
    }

    public void setDtRETIRELE(Date dtRETIRELE) {
        this.dtRETIRELE = dtRETIRELE;
    }

    public String getStrRETIRANT() {
        return strRETIRANT;
    }

    public void setStrRETIRANT(String strRETIRANT) {
        this.strRETIRANT = strRETIRANT;
    }

    public String getStrPERIODE() {
        return strPERIODE;
    }

    public void setStrPERIODE(String strPERIODE) {
        this.strPERIODE = strPERIODE;
    }

    public String getStrNOMENCLATURE() {
        return strNOMENCLATURE;
    }

    public void setStrNOMENCLATURE(String strNOMENCLATURE) {
        this.strNOMENCLATURE = strNOMENCLATURE;
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
        if (!(object instanceof TExportCcPoids)) {
            return false;
        }
        TExportCcPoids other = (TExportCcPoids) object;
        if ((this.lgID == null && other.lgID != null) || (this.lgID != null && !this.lgID.equals(other.lgID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TExportCcPoids[ lgID=" + lgID + " ]";
    }
    
}
