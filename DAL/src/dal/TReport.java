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
import javax.persistence.Lob;
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
@Table(name = "t_report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TReport.findAll", query = "SELECT t FROM TReport t"),
    @NamedQuery(name = "TReport.findByLgREPORTID", query = "SELECT t FROM TReport t WHERE t.lgREPORTID = :lgREPORTID"),
    @NamedQuery(name = "TReport.findByStrPATH", query = "SELECT t FROM TReport t WHERE t.strPATH = :strPATH"),
    @NamedQuery(name = "TReport.findByStrSTATUT", query = "SELECT t FROM TReport t WHERE t.strSTATUT = :strSTATUT"),
    @NamedQuery(name = "TReport.findByStrTYPE", query = "SELECT t FROM TReport t WHERE t.strTYPE = :strTYPE"),
    @NamedQuery(name = "TReport.findByStrDATA", query = "SELECT t FROM TReport t WHERE t.strDATA = :strDATA"),
    @NamedQuery(name = "TReport.findByStrRETURNDATA", query = "SELECT t FROM TReport t WHERE t.strRETURNDATA = :strRETURNDATA"),
    @NamedQuery(name = "TReport.findByStrPARAMDATA", query = "SELECT t FROM TReport t WHERE t.strPARAMDATA = :strPARAMDATA"),
    @NamedQuery(name = "TReport.findByStrSQLDATA", query = "SELECT t FROM TReport t WHERE t.strSQLDATA = :strSQLDATA"),
    @NamedQuery(name = "TReport.findByStrREF", query = "SELECT t FROM TReport t WHERE t.strREF = :strREF"),
    @NamedQuery(name = "TReport.findByDtCREATED", query = "SELECT t FROM TReport t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TReport.findByLgCREATEDBY", query = "SELECT t FROM TReport t WHERE t.lgCREATEDBY = :lgCREATEDBY"),
    @NamedQuery(name = "TReport.findByDtUPDATED", query = "SELECT t FROM TReport t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TReport.findByLgUPDATEDBY", query = "SELECT t FROM TReport t WHERE t.lgUPDATEDBY = :lgUPDATEDBY"),
    @NamedQuery(name = "TReport.findByIntNBELEMENTS", query = "SELECT t FROM TReport t WHERE t.intNBELEMENTS = :intNBELEMENTS")})
public class TReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_REPORT_ID", nullable = false, length = 50)
    private String lgREPORTID;
    @Lob
    @Column(name = "str_NAME", length = 65535)
    private String strNAME;
    @Column(name = "str_PATH", length = 200)
    private String strPATH;
    @Column(name = "str_STATUT", length = 20)
    private String strSTATUT;
    @Column(name = "str_TYPE", length = 200)
    private String strTYPE;
    @Column(name = "str_DATA", length = 200)
    private String strDATA;
    @Column(name = "str_RETURN_DATA", length = 200)
    private String strRETURNDATA;
    @Column(name = "str_PARAM_DATA", length = 200)
    private String strPARAMDATA;
    @Column(name = "str_SQL_DATA", length = 200)
    private String strSQLDATA;
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
    @Column(name = "int_NB_ELEMENTS")
    private Integer intNBELEMENTS;

    public TReport() {
    }

    public TReport(String lgREPORTID) {
        this.lgREPORTID = lgREPORTID;
    }

    public String getLgREPORTID() {
        return lgREPORTID;
    }

    public void setLgREPORTID(String lgREPORTID) {
        this.lgREPORTID = lgREPORTID;
    }

    public String getStrNAME() {
        return strNAME;
    }

    public void setStrNAME(String strNAME) {
        this.strNAME = strNAME;
    }

    public String getStrPATH() {
        return strPATH;
    }

    public void setStrPATH(String strPATH) {
        this.strPATH = strPATH;
    }

    public String getStrSTATUT() {
        return strSTATUT;
    }

    public void setStrSTATUT(String strSTATUT) {
        this.strSTATUT = strSTATUT;
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

    public String getStrPARAMDATA() {
        return strPARAMDATA;
    }

    public void setStrPARAMDATA(String strPARAMDATA) {
        this.strPARAMDATA = strPARAMDATA;
    }

    public String getStrSQLDATA() {
        return strSQLDATA;
    }

    public void setStrSQLDATA(String strSQLDATA) {
        this.strSQLDATA = strSQLDATA;
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

    public Integer getIntNBELEMENTS() {
        return intNBELEMENTS;
    }

    public void setIntNBELEMENTS(Integer intNBELEMENTS) {
        this.intNBELEMENTS = intNBELEMENTS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgREPORTID != null ? lgREPORTID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TReport)) {
            return false;
        }
        TReport other = (TReport) object;
        if ((this.lgREPORTID == null && other.lgREPORTID != null) || (this.lgREPORTID != null && !this.lgREPORTID.equals(other.lgREPORTID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TReport[ lgREPORTID=" + lgREPORTID + " ]";
    }
    
}
