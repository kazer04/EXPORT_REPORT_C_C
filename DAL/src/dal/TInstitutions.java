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
@Table(name = "t_institutions", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"lg_INSTITUTION_ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TInstitutions.findAll", query = "SELECT t FROM TInstitutions t"),
    @NamedQuery(name = "TInstitutions.findByLgINSTITUTIONID", query = "SELECT t FROM TInstitutions t WHERE t.lgINSTITUTIONID = :lgINSTITUTIONID"),
    @NamedQuery(name = "TInstitutions.findByStrNAME", query = "SELECT t FROM TInstitutions t WHERE t.strNAME = :strNAME"),
    @NamedQuery(name = "TInstitutions.findByDtCREATED", query = "SELECT t FROM TInstitutions t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TInstitutions.findByDtUPDATED", query = "SELECT t FROM TInstitutions t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TInstitutions.findByStrSTATUT", query = "SELECT t FROM TInstitutions t WHERE t.strSTATUT = :strSTATUT"),
    @NamedQuery(name = "TInstitutions.findByStrADRESSE", query = "SELECT t FROM TInstitutions t WHERE t.strADRESSE = :strADRESSE"),
    @NamedQuery(name = "TInstitutions.findByStrEMAIL", query = "SELECT t FROM TInstitutions t WHERE t.strEMAIL = :strEMAIL"),
    @NamedQuery(name = "TInstitutions.findByStrLOGOLARGE", query = "SELECT t FROM TInstitutions t WHERE t.strLOGOLARGE = :strLOGOLARGE"),
    @NamedQuery(name = "TInstitutions.findByStrLOGOMIDDLE", query = "SELECT t FROM TInstitutions t WHERE t.strLOGOMIDDLE = :strLOGOMIDDLE"),
    @NamedQuery(name = "TInstitutions.findByStrLOGOSMALL", query = "SELECT t FROM TInstitutions t WHERE t.strLOGOSMALL = :strLOGOSMALL"),
    @NamedQuery(name = "TInstitutions.findByStrNUMCONTRIBUABLE", query = "SELECT t FROM TInstitutions t WHERE t.strNUMCONTRIBUABLE = :strNUMCONTRIBUABLE"),
    @NamedQuery(name = "TInstitutions.findByStrPARAM1", query = "SELECT t FROM TInstitutions t WHERE t.strPARAM1 = :strPARAM1"),
    @NamedQuery(name = "TInstitutions.findByStrPARAM2", query = "SELECT t FROM TInstitutions t WHERE t.strPARAM2 = :strPARAM2"),
    @NamedQuery(name = "TInstitutions.findByStrPARAM3", query = "SELECT t FROM TInstitutions t WHERE t.strPARAM3 = :strPARAM3"),
    @NamedQuery(name = "TInstitutions.findByStrPHONE", query = "SELECT t FROM TInstitutions t WHERE t.strPHONE = :strPHONE")})
public class TInstitutions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_INSTITUTION_ID", nullable = false, length = 50)
    private String lgINSTITUTIONID;
    @Basic(optional = false)
    @Column(name = "str_NAME", nullable = false, length = 50)
    private String strNAME;
    @Column(name = "dt_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCREATED;
    @Column(name = "dt_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUPDATED;
    @Column(name = "str_STATUT", length = 20)
    private String strSTATUT;
    @Column(name = "str_ADRESSE", length = 20)
    private String strADRESSE;
    @Column(name = "str_EMAIL", length = 20)
    private String strEMAIL;
    @Column(name = "str_LOGO_LARGE", length = 20)
    private String strLOGOLARGE;
    @Column(name = "str_LOGO_MIDDLE", length = 20)
    private String strLOGOMIDDLE;
    @Column(name = "str_LOGO_SMALL", length = 20)
    private String strLOGOSMALL;
    @Column(name = "str_NUM_CONTRIBUABLE", length = 20)
    private String strNUMCONTRIBUABLE;
    @Column(name = "str_PARAM_1", length = 20)
    private String strPARAM1;
    @Column(name = "str_PARAM_2", length = 20)
    private String strPARAM2;
    @Column(name = "str_PARAM_3", length = 20)
    private String strPARAM3;
    @Column(name = "str_PHONE", length = 20)
    private String strPHONE;

    public TInstitutions() {
    }

    public TInstitutions(String lgINSTITUTIONID) {
        this.lgINSTITUTIONID = lgINSTITUTIONID;
    }

    public TInstitutions(String lgINSTITUTIONID, String strNAME) {
        this.lgINSTITUTIONID = lgINSTITUTIONID;
        this.strNAME = strNAME;
    }

    public String getLgINSTITUTIONID() {
        return lgINSTITUTIONID;
    }

    public void setLgINSTITUTIONID(String lgINSTITUTIONID) {
        this.lgINSTITUTIONID = lgINSTITUTIONID;
    }

    public String getStrNAME() {
        return strNAME;
    }

    public void setStrNAME(String strNAME) {
        this.strNAME = strNAME;
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

    public String getStrADRESSE() {
        return strADRESSE;
    }

    public void setStrADRESSE(String strADRESSE) {
        this.strADRESSE = strADRESSE;
    }

    public String getStrEMAIL() {
        return strEMAIL;
    }

    public void setStrEMAIL(String strEMAIL) {
        this.strEMAIL = strEMAIL;
    }

    public String getStrLOGOLARGE() {
        return strLOGOLARGE;
    }

    public void setStrLOGOLARGE(String strLOGOLARGE) {
        this.strLOGOLARGE = strLOGOLARGE;
    }

    public String getStrLOGOMIDDLE() {
        return strLOGOMIDDLE;
    }

    public void setStrLOGOMIDDLE(String strLOGOMIDDLE) {
        this.strLOGOMIDDLE = strLOGOMIDDLE;
    }

    public String getStrLOGOSMALL() {
        return strLOGOSMALL;
    }

    public void setStrLOGOSMALL(String strLOGOSMALL) {
        this.strLOGOSMALL = strLOGOSMALL;
    }

    public String getStrNUMCONTRIBUABLE() {
        return strNUMCONTRIBUABLE;
    }

    public void setStrNUMCONTRIBUABLE(String strNUMCONTRIBUABLE) {
        this.strNUMCONTRIBUABLE = strNUMCONTRIBUABLE;
    }

    public String getStrPARAM1() {
        return strPARAM1;
    }

    public void setStrPARAM1(String strPARAM1) {
        this.strPARAM1 = strPARAM1;
    }

    public String getStrPARAM2() {
        return strPARAM2;
    }

    public void setStrPARAM2(String strPARAM2) {
        this.strPARAM2 = strPARAM2;
    }

    public String getStrPARAM3() {
        return strPARAM3;
    }

    public void setStrPARAM3(String strPARAM3) {
        this.strPARAM3 = strPARAM3;
    }

    public String getStrPHONE() {
        return strPHONE;
    }

    public void setStrPHONE(String strPHONE) {
        this.strPHONE = strPHONE;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgINSTITUTIONID != null ? lgINSTITUTIONID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TInstitutions)) {
            return false;
        }
        TInstitutions other = (TInstitutions) object;
        if ((this.lgINSTITUTIONID == null && other.lgINSTITUTIONID != null) || (this.lgINSTITUTIONID != null && !this.lgINSTITUTIONID.equals(other.lgINSTITUTIONID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TInstitutions[ lgINSTITUTIONID=" + lgINSTITUTIONID + " ]";
    }
    
}
