/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP PC
 */
@Entity
@Table(name = "t_language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TLanguage.findAll", query = "SELECT t FROM TLanguage t"),
    @NamedQuery(name = "TLanguage.findByLgLanguageID", query = "SELECT t FROM TLanguage t WHERE t.lgLanguageID = :lgLanguageID"),
    @NamedQuery(name = "TLanguage.findByStrLocalCty", query = "SELECT t FROM TLanguage t WHERE t.strLocalCty = :strLocalCty"),
    @NamedQuery(name = "TLanguage.findByStrLocalLg", query = "SELECT t FROM TLanguage t WHERE t.strLocalLg = :strLocalLg"),
    @NamedQuery(name = "TLanguage.findByStrCode", query = "SELECT t FROM TLanguage t WHERE t.strCode = :strCode"),
    @NamedQuery(name = "TLanguage.findByStrDescription", query = "SELECT t FROM TLanguage t WHERE t.strDescription = :strDescription")})
public class TLanguage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_Language_ID", nullable = false, length = 20)
    private String lgLanguageID;
    @Column(name = "str_Local_Cty", length = 20)
    private String strLocalCty;
    @Column(name = "str_Local_Lg", length = 20)
    private String strLocalLg;
    @Column(name = "str_Code", length = 50)
    private String strCode;
    @Column(name = "str_Description", length = 100)
    private String strDescription;
    @OneToMany(mappedBy = "lgLanguageID")
    private Collection<TUser> tUserCollection;

    public TLanguage() {
    }

    public TLanguage(String lgLanguageID) {
        this.lgLanguageID = lgLanguageID;
    }

    public String getLgLanguageID() {
        return lgLanguageID;
    }

    public void setLgLanguageID(String lgLanguageID) {
        this.lgLanguageID = lgLanguageID;
    }

    public String getStrLocalCty() {
        return strLocalCty;
    }

    public void setStrLocalCty(String strLocalCty) {
        this.strLocalCty = strLocalCty;
    }

    public String getStrLocalLg() {
        return strLocalLg;
    }

    public void setStrLocalLg(String strLocalLg) {
        this.strLocalLg = strLocalLg;
    }

    public String getStrCode() {
        return strCode;
    }

    public void setStrCode(String strCode) {
        this.strCode = strCode;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    @XmlTransient
    public Collection<TUser> getTUserCollection() {
        return tUserCollection;
    }

    public void setTUserCollection(Collection<TUser> tUserCollection) {
        this.tUserCollection = tUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgLanguageID != null ? lgLanguageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TLanguage)) {
            return false;
        }
        TLanguage other = (TLanguage) object;
        if ((this.lgLanguageID == null && other.lgLanguageID != null) || (this.lgLanguageID != null && !this.lgLanguageID.equals(other.lgLanguageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TLanguage[ lgLanguageID=" + lgLanguageID + " ]";
    }
    
}
