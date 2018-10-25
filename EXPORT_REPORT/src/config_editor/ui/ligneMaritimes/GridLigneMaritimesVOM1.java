package config_editor.ui.ligneMaritimes;

import config_editor.security.User.*;
import java.util.Date;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 * <p>
 * Title: OpenSwing Framework</p>
 * <p>
 * Description: Value Object used to store employee summary info.</p>
 * <p>
 * Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p>
 * </p> @author Mauro Carniel
 *
 * @version 1.0
 */
public class GridLigneMaritimesVOM1 extends ValueObjectImpl {

    private Integer num_ticket_pesee = new Integer(0);
    private String chargeur = "";
    private Integer poids_pesee_1 = new Integer(0);
    ;
    private Integer poids_pesee_2 = new Integer(0);
    ;
    private Date date_2_pessee = new Date();
    private String heur_2_pessee = "";
    private String produit = "";
    private String num_conteneur = "";
    private String num_plomb = "";
    private String num_booking = "";
    private String num_transitaire = "";
    private String compagnie_maritime = "";
    private String navire = "";
    private String port_debarq = "";
    private String pesseur = "";
    private String agent_ci = "";
    private Integer poids_vgm = new Integer(0);
    private Integer heur = new Integer(0);
    private Integer min = new Integer(0);
    private String methode_pesee_vgm = "";
    private String num_voyage = "";

    public int KEY_num_ticket_pesee = 7 -1;
    public int KEY_chargeur = 1 -1;
    public int KEY_poids_pesee_1 = 4 -1;
    public int KEY_poids_pesee_2 = 8 -1;
    public int KEY_date_2_pessee = 9 -1;
    public int KEY_heur_2_pessee = 10 -1;
    public int KEY_produit = 21 -1;
    public int KEY_num_conteneur = 31 -1;
    public int KEY_num_plomb = 33 -1;
    public int KEY_num_booking = 39 -1;
    public int KEY_num_transitaire = 40 -1;
    public int KEY_compagnie_maritime = 41 -1;
    public int KEY_navire = 42 -1;
    public int KEY_port_debarq = 56 -1;
    public int KEY_pesseur = 44 -1;
    public int KEY_agent_ci = 45 -1;
    public int KEY_poids_vgm = 46 -1;
    public int KEY_methode_pesee_vgm = 47 -1;
    public int KEY_num_voyage = 48 -1;

    public GridLigneMaritimesVOM1() {
    }

    /**
     * @return the num_ticket_pesee
     */
    public Integer getNum_ticket_pesee() {
        return num_ticket_pesee;
    }

    /**
     * @param num_ticket_pesee the num_ticket_pesee to set
     */
    public void setNum_ticket_pesee(Integer num_ticket_pesee) {
        this.num_ticket_pesee = num_ticket_pesee;
    }

    /**
     * @return the chargeur
     */
    public String getChargeur() {
        return chargeur;
    }

    /**
     * @param chargeur the chargeur to set
     */
    public void setChargeur(String chargeur) {
        this.chargeur = chargeur;
    }

    /**
     * @return the poids_pesee_1
     */
    public Integer getPoids_pesee_1() {
        return poids_pesee_1;
    }

    /**
     * @param poids_pesee_1 the poids_pesee_1 to set
     */
    public void setPoids_pesee_1(Integer poids_pesee_1) {
        this.poids_pesee_1 = poids_pesee_1;
    }

    /**
     * @return the poids_pesee_2
     */
    public Integer getPoids_pesee_2() {
        return poids_pesee_2;
    }

    /**
     * @param poids_pesee_2 the poids_pesee_2 to set
     */
    public void setPoids_pesee_2(Integer poids_pesee_2) {
        this.poids_pesee_2 = poids_pesee_2;
    }

    /**
     * @return the date_2_pessee
     */
    public Date getDate_2_pessee() {
        return date_2_pessee;
    }

    /**
     * @param date_2_pessee the date_2_pessee to set
     */
    public void setDate_2_pessee(Date date_2_pessee) {
        this.date_2_pessee = date_2_pessee;
    }

    /**
     * @return the heur_2_pessee
     */
    public String getHeur_2_pessee() {
        return heur_2_pessee;
    }

    /**
     * @param heur_2_pessee the heur_2_pessee to set
     */
    public void setHeur_2_pessee(String heur_2_pessee) {
        this.heur_2_pessee = heur_2_pessee;
    }

    /**
     * @return the num_conteneur
     */
    public String getNum_conteneur() {
        return num_conteneur;
    }

    /**
     * @param num_conteneur the num_conteneur to set
     */
    public void setNum_conteneur(String num_conteneur) {
        this.num_conteneur = num_conteneur;
    }

    /**
     * @return the num_plomb
     */
    public String getNum_plomb() {
        return num_plomb;
    }

    /**
     * @param num_plomb the num_plomb to set
     */
    public void setNum_plomb(String num_plomb) {
        this.num_plomb = num_plomb;
    }

    /**
     * @return the num_booking
     */
    public String getNum_booking() {
        return num_booking;
    }

    /**
     * @param num_booking the num_booking to set
     */
    public void setNum_booking(String num_booking) {
        this.num_booking = num_booking;
    }

    /**
     * @return the num_transitaire
     */
    public String getNum_transitaire() {
        return num_transitaire;
    }

    /**
     * @param num_transitaire the num_transitaire to set
     */
    public void setNum_transitaire(String num_transitaire) {
        this.num_transitaire = num_transitaire;
    }

    /**
     * @return the compagnie_maritime
     */
    public String getCompagnie_maritime() {
        return compagnie_maritime;
    }

    /**
     * @param compagnie_maritime the compagnie_maritime to set
     */
    public void setCompagnie_maritime(String compagnie_maritime) {
        this.compagnie_maritime = compagnie_maritime;
    }

    /**
     * @return the navire
     */
    public String getNavire() {
        return navire;
    }

    /**
     * @param navire the navire to set
     */
    public void setNavire(String navire) {
        this.navire = navire;
    }

    /**
     * @return the port_debarq
     */
    public String getPort_debarq() {
        return port_debarq;
    }

    /**
     * @param port_debarq the port_debarq to set
     */
    public void setPort_debarq(String port_debarq) {
        this.port_debarq = port_debarq;
    }

    /**
     * @return the pesseur
     */
    public String getPesseur() {
        return pesseur;
    }

    /**
     * @param pesseur the pesseur to set
     */
    public void setPesseur(String pesseur) {
        this.pesseur = pesseur;
    }

    /**
     * @return the agent_ci
     */
    public String getAgent_ci() {
        return agent_ci;
    }

    /**
     * @param agent_ci the agent_ci to set
     */
    public void setAgent_ci(String agent_ci) {
        this.agent_ci = agent_ci;
    }

    /**
     * @return the methode_pesee_vgm
     */
    public String getMethode_pesee_vgm() {
        return methode_pesee_vgm;
    }

    /**
     * @param methode_pesee_vgm the methode_pesee_vgm to set
     */
    public void setMethode_pesee_vgm(String methode_pesee_vgm) {
        this.methode_pesee_vgm = methode_pesee_vgm;
    }

    /**
     * @return the num_voyage
     */
    public String getNum_voyage() {
        return num_voyage;
    }

    /**
     * @param num_voyage the num_voyage to set
     */
    public void setNum_voyage(String num_voyage) {
        this.num_voyage = num_voyage;
    }

    /**
     * @return the poids_vgm
     */
    public Integer getPoids_vgm() {
        return poids_vgm;
    }

    /**
     * @param poids_vgm the poids_vgm to set
     */
    public void setPoids_vgm(Integer poids_vgm) {
        this.poids_vgm = poids_vgm;
    }

    /**
     * @return the produit
     */
    public String getProduit() {
        return produit;
    }

    /**
     * @param produit the produit to set
     */
    public void setProduit(String produit) {
        this.produit = produit;
    }

    /**
     * @return the heur
     */
    public Integer getHeur() {
        return heur;
    }

    /**
     * @param heur the heur to set
     */
    public void setHeur(Integer heur) {
        this.heur = heur;
    }

    /**
     * @return the min
     */
    public Integer getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(Integer min) {
        this.min = min;
    }

}
