/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.userManagement;

import bll.bllBase;
import bll.entity.EntityData;


import dal.TPrivilege;
import dal.TRole;

import dal.TRolePrivelege;
import dal.TRoleUser;

import dal.TUser;
import dal.dataManager;

import dal.jconnexion;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import toolkits.parameters.commonparameter;
import toolkits.utils.date;
import toolkits.utils.logger;

/**
 *
 * @author Administrator
 */
public class privilege extends bllBase {

    private TUser oTUser;

    public privilege() {
    }

    public privilege(dataManager odataManager, TUser oTUser) {
        this.setOTUser(oTUser);
        this.setOdataManager(odataManager);
        this.checkDatamanager();
    }
    
    public void loadUser(TUser oTUser) {
        this.setOTUser(oTUser);
    }

    public boolean isAvalaible(String str_Privilege_name) {
        boolean result = false;
        try {
            this.setMessage("pas d'acces au privilege");
            TPrivilege OTPrivilege = (TPrivilege) this.getOdataManager().getEm().createQuery("SELECT t FROM TPrivilege t WHERE t.strNAME = ?1 AND t.strSTATUT LIKE ?2 ")
                    .setParameter(1, str_Privilege_name)
                    .setParameter(2, commonparameter.statut_enable)
                    .getSingleResult();
            this.refresh(OTPrivilege);
            //Liste des role de l'utilisateur
            Collection<TRoleUser> CollTRoleUser = this.getOTUser().getTRoleUserCollection();
            Iterator iteraror = CollTRoleUser.iterator();
            while (iteraror.hasNext()) {
                Object el = iteraror.next();
                TRoleUser OTRoleUser = (TRoleUser) el;

                this.refresh(OTRoleUser);
                //Get List of privilege role
                Collection<TRolePrivelege> CollTRolePrivelege = OTRoleUser.getLgROLEID().getTRolePrivelegeCollection();
                Iterator iterarorTRolePrivelege = CollTRolePrivelege.iterator();
                while (iterarorTRolePrivelege.hasNext()) {
                    Object elTRolePrivelege = iterarorTRolePrivelege.next();
                    TRolePrivelege OTRolePrivelege = (TRolePrivelege) elTRolePrivelege;

                    this.refresh(OTRolePrivelege);
                    if (OTRolePrivelege.getLgPRIVILEGEID().equals(OTPrivilege)) {
                        result = true;
                        this.setMessage("Le privilege accorde");
                    }
                }
            }
        } catch (Exception e) {
            new logger().oCategory.error(date.GetDateNow() + " " + e.getMessage());
            result = false;
        }
        return result;
    }

    public List<TPrivilege> GetAllPrivilege(TUser oTUser, String KEY_TYPE) {

        Collection<TRoleUser> CollTRoleUser = oTUser.getTRoleUserCollection();
        String lg_ROLE_ID = CollTRoleUser.iterator().next().getLgROLEID().getLgROLEID();

        List<TPrivilege> LstTPrivilege = new ArrayList<TPrivilege>();
        try {
            jconnexion Ojconnexion = new jconnexion();
            Ojconnexion.initConnexion();
            Ojconnexion.OpenConnexion();
            String qry = "SELECT lg_PRIVELEGE_ID,str_DESCRIPTION,str_NAME FROM t_privilege WHERE t_privilege.lg_PRIVELEGE_ID IN (SELECT t_role_privelege.lg_PRIVILEGE_ID FROM t_role_privelege WHERE t_role_privelege.lg_ROLE_ID LIKE '" + lg_ROLE_ID + "')  AND str_NAME  LIKE '" + KEY_TYPE + "%' AND str_STATUT  LIKE '" + commonparameter.statut_enable + "%'  ORDER BY str_DESCRIPTION";
            new logger().OCategory.info(qry);
            Ojconnexion.set_Request(qry);
            ResultSetMetaData rsmddatas = Ojconnexion.get_resultat().getMetaData();
            while (Ojconnexion.get_resultat().next()) {
                TPrivilege OTPrivilege = new TPrivilege();
                OTPrivilege.setLgPRIVELEGEID(Ojconnexion.get_resultat().getString("lg_PRIVELEGE_ID"));
                OTPrivilege.setStrNAME(Ojconnexion.get_resultat().getString("str_NAME"));
                OTPrivilege.setStrDESCRIPTION(Ojconnexion.get_resultat().getString("str_DESCRIPTION"));
                LstTPrivilege.add(OTPrivilege);
            }
            Ojconnexion.CloseConnexion();
        } catch (Exception ex) {
            new logger().OCategory.fatal(ex.getMessage());
        }

        return LstTPrivilege;
    }

    public List<TPrivilege> GetAllPrivilege(TUser oTUser) {

        List<TPrivilege> LstTPrivilege = new ArrayList<TPrivilege>();
        try {
            //Liste des role de l'utilisateur
            Collection<TRoleUser> CollTRoleUser = oTUser.getTRoleUserCollection();
            Iterator iteraror = CollTRoleUser.iterator();
            while (iteraror.hasNext()) {
                Object el = iteraror.next();
                TRoleUser OTRoleUser = (TRoleUser) el;
                //Get List of privilege role
                Collection<TRolePrivelege> CollTRolePrivelege = OTRoleUser.getLgROLEID().getTRolePrivelegeCollection();
                Iterator iterarorTRolePrivelege = CollTRolePrivelege.iterator();
                int i = 0;
                while (iterarorTRolePrivelege.hasNext()) {
                    i++;
                    Object elTRolePrivelege = iterarorTRolePrivelege.next();
                    TRolePrivelege OTRolePrivelege = (TRolePrivelege) elTRolePrivelege;
                    this.getOdataManager().getEm().refresh(OTRolePrivelege);
                    this.getOdataManager().getEm().refresh(OTRolePrivelege.getLgPRIVILEGEID());
                    LstTPrivilege.add(OTRolePrivelege.getLgPRIVILEGEID());
                    // new logger().OCategory.info("Privilege " + i + "  " + OTRolePrivelege.getLgPRIVILEGEID().getStrNAME());
                }
            }
        } catch (Exception ex) {
            new logger().OCategory.fatal(ex.getMessage());
        }

        return LstTPrivilege;
    }

    public List<TPrivilege> GetAllPrivilegeAuthorize_To_Role(String lg_ROLE_ID) {

        List<TPrivilege> LstTPrivilege = new ArrayList<TPrivilege>();
        try {
            jconnexion Ojconnexion = new jconnexion();
            Ojconnexion.initConnexion();
            Ojconnexion.OpenConnexion();
            String qry = "SELECT lg_PRIVELEGE_ID,str_DESCRIPTION,str_NAME FROM t_privilege WHERE t_privilege.lg_PRIVELEGE_ID IN (SELECT t_role_privelege.lg_PRIVILEGE_ID FROM t_role_privelege WHERE t_role_privelege.lg_ROLE_ID LIKE '" + lg_ROLE_ID + "') AND str_STATUT  LIKE '" + commonparameter.statut_enable + "%' ORDER BY str_DESCRIPTION";
            new logger().OCategory.info(qry);
            Ojconnexion.set_Request(qry);
            ResultSetMetaData rsmddatas = Ojconnexion.get_resultat().getMetaData();
            while (Ojconnexion.get_resultat().next()) {
                TPrivilege OTPrivilege = new TPrivilege();
                OTPrivilege.setLgPRIVELEGEID(Ojconnexion.get_resultat().getString("lg_PRIVELEGE_ID"));
                OTPrivilege.setStrNAME(Ojconnexion.get_resultat().getString("str_NAME"));
                OTPrivilege.setStrDESCRIPTION(Ojconnexion.get_resultat().getString("str_DESCRIPTION"));
                LstTPrivilege.add(OTPrivilege);
            }
            Ojconnexion.CloseConnexion();
        } catch (Exception ex) {
            new logger().OCategory.fatal(ex.getMessage());
        }

        return LstTPrivilege;
    }

    public List<TPrivilege> GetAllPrivilegeUnAuthorize_To_Role(String lg_ROLE_ID) {

        List<TPrivilege> LstTPrivilege = new ArrayList<TPrivilege>();
        try {
            jconnexion Ojconnexion = new jconnexion();
            Ojconnexion.initConnexion();
            Ojconnexion.OpenConnexion();
            String qry = "SELECT lg_PRIVELEGE_ID,str_DESCRIPTION,str_NAME FROM t_privilege WHERE t_privilege.lg_PRIVELEGE_ID NOT IN (SELECT t_role_privelege.lg_PRIVILEGE_ID FROM t_role_privelege WHERE t_role_privelege.lg_ROLE_ID LIKE '" + lg_ROLE_ID + "') AND str_STATUT  LIKE '" + commonparameter.statut_enable + "%' ORDER BY str_DESCRIPTION";
            Ojconnexion.set_Request(qry);
            new logger().OCategory.info(qry);
            ResultSetMetaData rsmddatas = Ojconnexion.get_resultat().getMetaData();
            while (Ojconnexion.get_resultat().next()) {
                TPrivilege OTPrivilege = new TPrivilege();
                OTPrivilege.setLgPRIVELEGEID(Ojconnexion.get_resultat().getString("lg_PRIVELEGE_ID"));
                OTPrivilege.setStrNAME(Ojconnexion.get_resultat().getString("str_NAME"));
                OTPrivilege.setStrDESCRIPTION(Ojconnexion.get_resultat().getString("str_DESCRIPTION"));
                LstTPrivilege.add(OTPrivilege);
            }
            Ojconnexion.CloseConnexion();
        } catch (Exception ex) {
            new logger().OCategory.fatal(ex.getMessage());
        }

        return LstTPrivilege;
    }


    /**
     * @return the oTUser
     */
    public TUser getOTUser() {
        return oTUser;
    }

    /**
     * @param oTUser the oTUser to set
     */
    public void setOTUser(TUser oTUser) {
        this.oTUser = oTUser;
    }
    
    
    //verifie si un utilisateur a le privilege de visualisation de la colonne du stock machine lors de l'inventaire
    public boolean isColonneStockMachineIsAuthorize(String str_NAME) {
        boolean result = false;
        try {
            TRolePrivelege OTRolePrivelege = (TRolePrivelege) this.getOdataManager().getEm().createQuery("SELECT t FROM TRolePrivelege t, TRoleUser r WHERE t.lgROLEID.lgROLEID = r.lgROLEID.lgROLEID AND r.lgUSERID.lgUSERID = ?1 AND t.lgPRIVILEGEID.strNAME = ?2 AND t.lgPRIVILEGEID.strSTATUT = ?3")
                    .setParameter(1, this.getOTUser().getLgUSERID()).setParameter(2, str_NAME).setParameter(3, commonparameter.statut_enable).getSingleResult();
            new logger().OCategory.info("Privilege "+OTRolePrivelege.getLgPRIVILEGEID().getStrDESCRIPTION());
            if(OTRolePrivelege != null) {
                result = true;
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        new logger().OCategory.info("result "+result);
        return result;
    }
    //fin verifie si un utilisateur a le privilege de visualisation de la colonne du stock machine lors de l'inventaire
    
    //creation de role privilege
    public boolean createRolePrivilege(String lg_ROLE_ID, String lg_PRIVILEGE_ID) {
        boolean result = false;
        try {
            TRole OTRole = this.getOdataManager().getEm().find(TRole.class, lg_ROLE_ID);
            TPrivilege OTPrivilege = this.getOdataManager().getEm().find(TPrivilege.class, lg_PRIVILEGE_ID);
            
            TRolePrivelege OTRolePrivelege = new TRolePrivelege();
            OTRolePrivelege.setLgROLEPRIVILEGE(this.getKey().getComplexId());   
            OTRolePrivelege.setLgROLEID(OTRole);
            OTRolePrivelege.setLgPRIVILEGEID(OTPrivilege);
            OTRolePrivelege.setStrCREATEDBY(this.getOTUser().getLgUSERID());
            this.persiste(OTRolePrivelege);
            result = true;
            this.buildSuccesTraceMessage("Opération effectuée avec succes");
        } catch (Exception e) {
            e.printStackTrace();
            this.buildErrorTraceMessage("Echec d'association du privilege au role selectionné");
        }
        return result;
    }
    //fin creation de role privilige
    
    //suppression role privilege
     
    public boolean deleteRolePrivilege(String lg_ROLE_ID, String lg_PRIVILEGE_ID) {
        boolean result = false;
        try {
              
            TRolePrivelege OTRolePrivelege = (TRolePrivelege) this.getOdataManager().getEm().createQuery("SELECT t FROM TRolePrivelege t WHERE t.lgROLEID.lgROLEID LIKE ?1 AND t.lgPRIVILEGEID.lgPRIVELEGEID LIKE ?2")
                    .setParameter(1, lg_ROLE_ID).setParameter(2, lg_PRIVILEGE_ID).getSingleResult();
            if (this.delete(OTRolePrivelege)) {
                result = true;
                this.buildSuccesTraceMessage(this.getOTranslate().getValue("SUCCES"));
            } else {
                this.buildErrorTraceMessage("Echec de suppression");
            }            
        } catch (Exception e) {
            e.printStackTrace();
            this.buildErrorTraceMessage("Echec de suppression du privilege dans le role");
        }
        return result;
    }
    //fin suppression role privilege
    
    public List<EntityData> showAllOrOnePrivilegeByRole(String search_value, String lg_ROLE_ID, String lg_PRIVILEGE_ID) {
        
        List<EntityData> Lst = new ArrayList<EntityData>();
        List<TPrivilege> lstTPrivilege = new ArrayList<TPrivilege>();
        EntityData OEntityData = null;
        
        try {
            lstTPrivilege = this.getListePrivilege(search_value, lg_PRIVILEGE_ID);
            for (TPrivilege OTPrivilege : lstTPrivilege) {
                OEntityData = new EntityData();
                OEntityData.setStr_value1(OTPrivilege.getLgPRIVELEGEID());
                OEntityData.setStr_value2(OTPrivilege.getStrDESCRIPTION());
                OEntityData.setStr_value3(String.valueOf(this.isExistUserPrivilege(lg_ROLE_ID, OTPrivilege.getLgPRIVELEGEID())));
                
                Lst.add(OEntityData);         
            }
            
        } catch (Exception ex) {
            new logger().OCategory.fatal(ex.getMessage());
        }
        new logger().OCategory.info("Taille liste "+Lst.size());
        return Lst;
    }

     
    public boolean isExistUserPrivilege(String lg_ROLE_ID, String lg_PRIVILEGE_ID) {
        boolean result = false;
        List<TRolePrivelege> lst = new ArrayList<TRolePrivelege>();
        try {
            lst = this.getOdataManager().getEm().createQuery("SELECT t FROM TRolePrivelege t WHERE t.lgROLEID.lgROLEID LIKE ?1 AND t.lgPRIVILEGEID.lgPRIVELEGEID LIKE ?2")
                    .setParameter(1, lg_ROLE_ID).setParameter(2, lg_PRIVILEGE_ID).getResultList();
            if(lst.size() > 0) {
                result = true;
            }
            /*TRolePrivelege OTRolePrivelege = (TRolePrivelege) this.getOdataManager().getEm().createQuery("SELECT t FROM TRolePrivelege t WHERE t.lgROLEID.lgROLEID LIKE ?1 AND t.lgPRIVILEGEID.lgPRIVELEGEID LIKE ?2")
                    .setParameter(1, lg_ROLE_ID).setParameter(2, lg_PRIVILEGE_ID).getSingleResult();
            if (OTRolePrivelege != null) {
                result = true;
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<TPrivilege> getListePrivilege(String search_value, String lg_PRIVILEGE_ID) {
        List<TPrivilege> lstTPrivilege = new ArrayList<TPrivilege>();

        try {
            if (search_value.equalsIgnoreCase("") || search_value == null) {
                search_value = "%%";
            }
            lstTPrivilege = this.getOdataManager().getEm().createQuery("SELECT t FROM TPrivilege t WHERE t.lgPRIVELEGEID LIKE ?1 AND t.strSTATUT = ?2 AND (t.strDESCRIPTION LIKE ?3 OR t.strNAME LIKE ?3) ORDER BY t.strDESCRIPTION ASC")
                    .setParameter(1, lg_PRIVILEGE_ID).setParameter(2, commonparameter.statut_enable).setParameter(3, "%"+search_value+"%").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new logger().OCategory.info("Taille liste " + lstTPrivilege.size());
        return lstTPrivilege;
    }


}
