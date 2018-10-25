/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.userManagement;

import bll.bllBase;
import bll.licence.LicenceManager;
import dal.TInstitutions;
import dal.TUser;
import dal.dataManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import toolkits.parameters.commonparameter;
import toolkits.security.Md5;
import toolkits.utils.logger;

/**
 *
 * @author Administrator
 */
public class authentification extends LicenceManager {

    public authentification() {
        checkDatamanager();
    }

    public authentification(dataManager OdataManager) {
        this.setOdataManager(OdataManager);
        checkDatamanager();
    }

    @SuppressWarnings("static-access")
    public boolean loginUser(String Str_login, String Str_Password) {

        LicenceManager oLicenceManager = new LicenceManager(this.getOdataManager());
        /*
         if (!oLicenceManager.isAvalaible()) {

         this.buildErrorTraceMessage(oLicenceManager.getDetailmessage());
         return false;
         }
         */
        //this.buildErrorTraceMessage("Licence valide");
  
        String Str_Password_MD5 = Md5.encode(Str_Password);
        boolean result = false;
        // Str_Password_MD5 = "%%";
        try {
            this.getOdataManager().BeginTransaction();
            TUser OTUser = (TUser) this.getOdataManager().getEm().createQuery("SELECT t FROM TUser t WHERE t.strLOGIN = ?1 AND t.strPASSWORD LIKE ?2 AND t.strSTATUT =?3 ").setParameter(1, Str_login).setParameter(2, Str_Password_MD5).setParameter(3, commonparameter.statut_enable).getSingleResult();
            // this.setMessage(this.getOTranslate().getValue("VALID_USER_DATA"));
            //   new logger().OCategory.info("Connexion de " + OTUser.getStrLOGIN());
            OTUser.setStrLASTCONNECTIONDATE(new Date());
            this.buildSuccesTraceMessage("Connexion de " + OTUser.getStrLOGIN() + "  -- " + OTUser.getStrLASTCONNECTIONDATE());

            this.getOdataManager().getEm().persist(OTUser);
            this.getOdataManager().CloseTransaction();
            result = true;
            this.setOTUser(OTUser);
            this.getOdataManager().getEm().refresh(OTUser);
            this.getOdataManager().getEm().refresh(OTUser.getLgSKINID());
        } catch (Exception ex) {
            this.setMessage(this.getOTranslate().getValue("INVALID_USER_DATA"));

            this.buildErrorTraceMessage(this.getOTranslate().getValue("INVALID_USER_DATA"), ex.getMessage());

        }
        return result;
    }

    private List<TInstitutions> getLstTInstitutions() {
        this.lstTInstitutions = new ArrayList<TInstitutions>();
        List<TInstitutions> lstTInstitutionsTemp = new ArrayList<TInstitutions>();

        /*
         for (int i = 0; i < lstTCustomerInstitutions.size(); i++) {
         this.refresh(lstTCustomerInstitutions.get(i));
         this.refresh(lstTCustomerInstitutions.get(i).getLgINSTITUTIONID());
         lstTInstitutionsTemp.add(lstTCustomerInstitutions.get(i).getLgINSTITUTIONID());
         }
         */
        this.buildSuccesTraceMessage(lstTInstitutionsTemp.size() + " Institution trouvee");

        return lstTInstitutionsTemp;

    }

}
