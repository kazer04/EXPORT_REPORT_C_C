/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import toolkits.parameters.commonparameter;
import toolkits.utils.jdom;

/**
 *
 * @author Administrator
 */
public class dataManager {

    public boolean isConected = false;
    private EntityManagerFactory emf;
    private EntityManager em;
    private String PERSISTENCE_UNIT_NAME = commonparameter.PERSISTENCE_UNIT_NAME_DAL;
    private EntityTransaction Transaction;
    // début transaction

    public dataManager() {
        jdom.InitRessource();
        jdom.LoadRessource();
    }

    public void initEntityManager() {
        Map parameters = new HashMap();
        parameters.put("toplink.jdbc.user", jdom.ars_database_user_name);
        parameters.put("toplink.jdbc.password", jdom.ars_database_user_password);
        parameters.put("toplink.jdbc.url", "jdbc:mysql://" + jdom.ars_database_host + ":" + jdom.ars_database_port + "/" + jdom.ars_database_name);
        parameters.put("toplink.jdbc.driver", "com.mysql.jdbc.Driver");
        //setEmf(Persistence.createEntityManagerFactory(getPERSISTENCE_UNIT_NAME()));
        //System.out.prinln("jdbc:mysql://" + jdom.ars_database_host + ":" + jdom.ars_database_port + "/" + jdom.ars_database_name);
        setEmf(Persistence.createEntityManagerFactory(getPERSISTENCE_UNIT_NAME(), parameters));
        setEm(getEmf().createEntityManager());
        isConected = true;

    }

    public void BeginTransaction() {
        // début transaction
        Transaction = em.getTransaction();
        if(!Transaction.isActive()){
             Transaction.begin();
        }
        
       
        // affichage personnes
    }

    public void CloseTransaction() {
        // début transaction
        
        Transaction.commit();
        // affichage personnes
    }

    public void closeEntityManager() {
        getEm().close();
        getEmf().close();
        isConected = false;
    }

    /**
     * @return the emf
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @param emf the emf to set
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the PERSISTENCE_UNIT_NAME
     */
    public String getPERSISTENCE_UNIT_NAME() {
        return PERSISTENCE_UNIT_NAME;
    }

    /**
     * @param PERSISTENCE_UNIT_NAME the PERSISTENCE_UNIT_NAME to set
     */
    public void setPERSISTENCE_UNIT_NAME(String PERSISTENCE_UNIT_NAME) {
        this.PERSISTENCE_UNIT_NAME = PERSISTENCE_UNIT_NAME;
    }
}
