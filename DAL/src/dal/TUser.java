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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "t_user", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"str_LOGIN"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUser.findAll", query = "SELECT t FROM TUser t"),
    @NamedQuery(name = "TUser.findByLgUSERID", query = "SELECT t FROM TUser t WHERE t.lgUSERID = :lgUSERID"),
    @NamedQuery(name = "TUser.findByStrLOGIN", query = "SELECT t FROM TUser t WHERE t.strLOGIN = :strLOGIN"),
    @NamedQuery(name = "TUser.findByStrPASSWORD", query = "SELECT t FROM TUser t WHERE t.strPASSWORD = :strPASSWORD"),
    @NamedQuery(name = "TUser.findByDtCREATED", query = "SELECT t FROM TUser t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TUser.findByDtUPDATED", query = "SELECT t FROM TUser t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TUser.findByStrCREATEDBY", query = "SELECT t FROM TUser t WHERE t.strCREATEDBY = :strCREATEDBY"),
    @NamedQuery(name = "TUser.findByStrUPDATEDBY", query = "SELECT t FROM TUser t WHERE t.strUPDATEDBY = :strUPDATEDBY"),
    @NamedQuery(name = "TUser.findByStrFIRSTNAME", query = "SELECT t FROM TUser t WHERE t.strFIRSTNAME = :strFIRSTNAME"),
    @NamedQuery(name = "TUser.findByStrLASTNAME", query = "SELECT t FROM TUser t WHERE t.strLASTNAME = :strLASTNAME"),
    @NamedQuery(name = "TUser.findByStrLASTCONNECTIONDATE", query = "SELECT t FROM TUser t WHERE t.strLASTCONNECTIONDATE = :strLASTCONNECTIONDATE"),
    @NamedQuery(name = "TUser.findByStrSTATUT", query = "SELECT t FROM TUser t WHERE t.strSTATUT = :strSTATUT"),
    @NamedQuery(name = "TUser.findByDtLASTACTIVITY", query = "SELECT t FROM TUser t WHERE t.dtLASTACTIVITY = :dtLASTACTIVITY"),
    @NamedQuery(name = "TUser.findByFunction", query = "SELECT t FROM TUser t WHERE t.function = :function"),
    @NamedQuery(name = "TUser.findByStrPHONE", query = "SELECT t FROM TUser t WHERE t.strPHONE = :strPHONE"),
    @NamedQuery(name = "TUser.findByStrMAIL", query = "SELECT t FROM TUser t WHERE t.strMAIL = :strMAIL"),
    @NamedQuery(name = "TUser.findByStrIDS", query = "SELECT t FROM TUser t WHERE t.strIDS = :strIDS"),
    @NamedQuery(name = "TUser.findByBCHANGEPASSWORD", query = "SELECT t FROM TUser t WHERE t.bCHANGEPASSWORD = :bCHANGEPASSWORD"),
    @NamedQuery(name = "TUser.findByIntCONNEXION", query = "SELECT t FROM TUser t WHERE t.intCONNEXION = :intCONNEXION"),
    @NamedQuery(name = "TUser.findByStrFUNCTION", query = "SELECT t FROM TUser t WHERE t.strFUNCTION = :strFUNCTION"),
    @NamedQuery(name = "TUser.findByLgEMPLACEMENTID", query = "SELECT t FROM TUser t WHERE t.lgEMPLACEMENTID = :lgEMPLACEMENTID"),
    @NamedQuery(name = "TUser.findByBIsConnected", query = "SELECT t FROM TUser t WHERE t.bIsConnected = :bIsConnected")})
public class TUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_USER_ID", nullable = false, length = 30)
    private String lgUSERID;
    @Column(name = "str_LOGIN", length = 40)
    private String strLOGIN;
    @Column(name = "str_PASSWORD", length = 40)
    private String strPASSWORD;
    @Column(name = "dt_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCREATED;
    @Column(name = "dt_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUPDATED;
    @Column(name = "str_CREATED_BY", length = 20)
    private String strCREATEDBY;
    @Column(name = "str_UPDATED_BY", length = 20)
    private String strUPDATEDBY;
    @Column(name = "str_FIRST_NAME", length = 20)
    private String strFIRSTNAME;
    @Column(name = "str_LAST_NAME", length = 20)
    private String strLASTNAME;
    @Column(name = "str_LAST_CONNECTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date strLASTCONNECTIONDATE;
    @Column(name = "str_STATUT", length = 20)
    private String strSTATUT;
    @Column(name = "dt_LAST_ACTIVITY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtLASTACTIVITY;
    @Column(length = 20)
    private String function;
    @Column(name = "str_PHONE", length = 20)
    private String strPHONE;
    @Column(name = "str_MAIL", length = 20)
    private String strMAIL;
    @Column(name = "str_IDS")
    private Integer strIDS;
    @Column(name = "b_CHANGE_PASSWORD")
    private Boolean bCHANGEPASSWORD;
    @Column(name = "int_CONNEXION")
    private Integer intCONNEXION;
    @Column(name = "str_FUNCTION", length = 50)
    private String strFUNCTION;
    @Column(name = "lg_EMPLACEMENT_ID", length = 20)
    private String lgEMPLACEMENTID;
    @Column(name = "b_is_connected")
    private Boolean bIsConnected;
    @OneToMany(mappedBy = "lgUSERID")
    private Collection<TRoleUser> tRoleUserCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgUSERID")
    private Collection<TUserImprimante> tUserImprimanteCollection;
    @OneToMany(mappedBy = "lgUSERIDIN")
    private Collection<TNotification> tNotificationCollection;
    @OneToMany(mappedBy = "lgUSERIDOUT")
    private Collection<TNotification> tNotificationCollection1;
    @JoinColumn(name = "lg_SKIN_ID", referencedColumnName = "lg_SKIN_ID")
    @ManyToOne
    private TSkin lgSKINID;
    @JoinColumn(name = "lg_Language_ID", referencedColumnName = "lg_Language_ID")
    @ManyToOne
    private TLanguage lgLanguageID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgUSERID")
    private Collection<TUserFone> tUserFoneCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgUSERID")
    private Collection<TUserServices> tUserServicesCollection;

    public TUser() {
    }

    public TUser(String lgUSERID) {
        this.lgUSERID = lgUSERID;
    }

    public String getLgUSERID() {
        return lgUSERID;
    }

    public void setLgUSERID(String lgUSERID) {
        this.lgUSERID = lgUSERID;
    }

    public String getStrLOGIN() {
        return strLOGIN;
    }

    public void setStrLOGIN(String strLOGIN) {
        this.strLOGIN = strLOGIN;
    }

    public String getStrPASSWORD() {
        return strPASSWORD;
    }

    public void setStrPASSWORD(String strPASSWORD) {
        this.strPASSWORD = strPASSWORD;
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

    public String getStrCREATEDBY() {
        return strCREATEDBY;
    }

    public void setStrCREATEDBY(String strCREATEDBY) {
        this.strCREATEDBY = strCREATEDBY;
    }

    public String getStrUPDATEDBY() {
        return strUPDATEDBY;
    }

    public void setStrUPDATEDBY(String strUPDATEDBY) {
        this.strUPDATEDBY = strUPDATEDBY;
    }

    public String getStrFIRSTNAME() {
        return strFIRSTNAME;
    }

    public void setStrFIRSTNAME(String strFIRSTNAME) {
        this.strFIRSTNAME = strFIRSTNAME;
    }

    public String getStrLASTNAME() {
        return strLASTNAME;
    }

    public void setStrLASTNAME(String strLASTNAME) {
        this.strLASTNAME = strLASTNAME;
    }

    public Date getStrLASTCONNECTIONDATE() {
        return strLASTCONNECTIONDATE;
    }

    public void setStrLASTCONNECTIONDATE(Date strLASTCONNECTIONDATE) {
        this.strLASTCONNECTIONDATE = strLASTCONNECTIONDATE;
    }

    public String getStrSTATUT() {
        return strSTATUT;
    }

    public void setStrSTATUT(String strSTATUT) {
        this.strSTATUT = strSTATUT;
    }

    public Date getDtLASTACTIVITY() {
        return dtLASTACTIVITY;
    }

    public void setDtLASTACTIVITY(Date dtLASTACTIVITY) {
        this.dtLASTACTIVITY = dtLASTACTIVITY;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getStrPHONE() {
        return strPHONE;
    }

    public void setStrPHONE(String strPHONE) {
        this.strPHONE = strPHONE;
    }

    public String getStrMAIL() {
        return strMAIL;
    }

    public void setStrMAIL(String strMAIL) {
        this.strMAIL = strMAIL;
    }

    public Integer getStrIDS() {
        return strIDS;
    }

    public void setStrIDS(Integer strIDS) {
        this.strIDS = strIDS;
    }

    public Boolean getBCHANGEPASSWORD() {
        return bCHANGEPASSWORD;
    }

    public void setBCHANGEPASSWORD(Boolean bCHANGEPASSWORD) {
        this.bCHANGEPASSWORD = bCHANGEPASSWORD;
    }

    public Integer getIntCONNEXION() {
        return intCONNEXION;
    }

    public void setIntCONNEXION(Integer intCONNEXION) {
        this.intCONNEXION = intCONNEXION;
    }

    public String getStrFUNCTION() {
        return strFUNCTION;
    }

    public void setStrFUNCTION(String strFUNCTION) {
        this.strFUNCTION = strFUNCTION;
    }

    public String getLgEMPLACEMENTID() {
        return lgEMPLACEMENTID;
    }

    public void setLgEMPLACEMENTID(String lgEMPLACEMENTID) {
        this.lgEMPLACEMENTID = lgEMPLACEMENTID;
    }

    public Boolean getBIsConnected() {
        return bIsConnected;
    }

    public void setBIsConnected(Boolean bIsConnected) {
        this.bIsConnected = bIsConnected;
    }

    @XmlTransient
    public Collection<TRoleUser> getTRoleUserCollection() {
        return tRoleUserCollection;
    }

    public void setTRoleUserCollection(Collection<TRoleUser> tRoleUserCollection) {
        this.tRoleUserCollection = tRoleUserCollection;
    }

    @XmlTransient
    public Collection<TUserImprimante> getTUserImprimanteCollection() {
        return tUserImprimanteCollection;
    }

    public void setTUserImprimanteCollection(Collection<TUserImprimante> tUserImprimanteCollection) {
        this.tUserImprimanteCollection = tUserImprimanteCollection;
    }

    @XmlTransient
    public Collection<TNotification> getTNotificationCollection() {
        return tNotificationCollection;
    }

    public void setTNotificationCollection(Collection<TNotification> tNotificationCollection) {
        this.tNotificationCollection = tNotificationCollection;
    }

    @XmlTransient
    public Collection<TNotification> getTNotificationCollection1() {
        return tNotificationCollection1;
    }

    public void setTNotificationCollection1(Collection<TNotification> tNotificationCollection1) {
        this.tNotificationCollection1 = tNotificationCollection1;
    }

    public TSkin getLgSKINID() {
        return lgSKINID;
    }

    public void setLgSKINID(TSkin lgSKINID) {
        this.lgSKINID = lgSKINID;
    }

    public TLanguage getLgLanguageID() {
        return lgLanguageID;
    }

    public void setLgLanguageID(TLanguage lgLanguageID) {
        this.lgLanguageID = lgLanguageID;
    }

    @XmlTransient
    public Collection<TUserFone> getTUserFoneCollection() {
        return tUserFoneCollection;
    }

    public void setTUserFoneCollection(Collection<TUserFone> tUserFoneCollection) {
        this.tUserFoneCollection = tUserFoneCollection;
    }

    @XmlTransient
    public Collection<TUserServices> getTUserServicesCollection() {
        return tUserServicesCollection;
    }

    public void setTUserServicesCollection(Collection<TUserServices> tUserServicesCollection) {
        this.tUserServicesCollection = tUserServicesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgUSERID != null ? lgUSERID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUser)) {
            return false;
        }
        TUser other = (TUser) object;
        if ((this.lgUSERID == null && other.lgUSERID != null) || (this.lgUSERID != null && !this.lgUSERID.equals(other.lgUSERID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TUser[ lgUSERID=" + lgUSERID + " ]";
    }
    
}
