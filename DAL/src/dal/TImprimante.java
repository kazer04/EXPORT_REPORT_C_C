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
import javax.persistence.Lob;
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
@Table(name = "t_imprimante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TImprimante.findAll", query = "SELECT t FROM TImprimante t"),
    @NamedQuery(name = "TImprimante.findByLgIMPRIMANTEID", query = "SELECT t FROM TImprimante t WHERE t.lgIMPRIMANTEID = :lgIMPRIMANTEID"),
    @NamedQuery(name = "TImprimante.findByDtCREATED", query = "SELECT t FROM TImprimante t WHERE t.dtCREATED = :dtCREATED"),
    @NamedQuery(name = "TImprimante.findByDtUPDATED", query = "SELECT t FROM TImprimante t WHERE t.dtUPDATED = :dtUPDATED"),
    @NamedQuery(name = "TImprimante.findByStrSTATUT", query = "SELECT t FROM TImprimante t WHERE t.strSTATUT = :strSTATUT")})
public class TImprimante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lg_IMPRIMANTE_ID", nullable = false, length = 40)
    private String lgIMPRIMANTEID;
    @Lob
    @Column(name = "str_NAME", length = 65535)
    private String strNAME;
    @Lob
    @Column(name = "str_DESCRIPTION", length = 65535)
    private String strDESCRIPTION;
    @Column(name = "dt_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCREATED;
    @Column(name = "dt_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtUPDATED;
    @Column(name = "str_STATUT", length = 40)
    private String strSTATUT;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lgIMPRIMANTEID")
    private Collection<TUserImprimante> tUserImprimanteCollection;

    public TImprimante() {
    }

    public TImprimante(String lgIMPRIMANTEID) {
        this.lgIMPRIMANTEID = lgIMPRIMANTEID;
    }

    public String getLgIMPRIMANTEID() {
        return lgIMPRIMANTEID;
    }

    public void setLgIMPRIMANTEID(String lgIMPRIMANTEID) {
        this.lgIMPRIMANTEID = lgIMPRIMANTEID;
    }

    public String getStrNAME() {
        return strNAME;
    }

    public void setStrNAME(String strNAME) {
        this.strNAME = strNAME;
    }

    public String getStrDESCRIPTION() {
        return strDESCRIPTION;
    }

    public void setStrDESCRIPTION(String strDESCRIPTION) {
        this.strDESCRIPTION = strDESCRIPTION;
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

    @XmlTransient
    public Collection<TUserImprimante> getTUserImprimanteCollection() {
        return tUserImprimanteCollection;
    }

    public void setTUserImprimanteCollection(Collection<TUserImprimante> tUserImprimanteCollection) {
        this.tUserImprimanteCollection = tUserImprimanteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lgIMPRIMANTEID != null ? lgIMPRIMANTEID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TImprimante)) {
            return false;
        }
        TImprimante other = (TImprimante) object;
        if ((this.lgIMPRIMANTEID == null && other.lgIMPRIMANTEID != null) || (this.lgIMPRIMANTEID != null && !this.lgIMPRIMANTEID.equals(other.lgIMPRIMANTEID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dal.TImprimante[ lgIMPRIMANTEID=" + lgIMPRIMANTEID + " ]";
    }
    
}
