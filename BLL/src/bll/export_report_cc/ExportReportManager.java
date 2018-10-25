/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.export_report_cc;

import dal.TCampagne;
import dal.TCampagneMois;
import dal.TCampagneMontant;
import dal.TCampagnePoids;
import dal.TExportCcMontant;
import dal.TExportCcMontant_;
import dal.TExportCcPoids;
import dal.TFile;
import dal.TReport;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import toolkits.Main;
import toolkits.filesmanagers.FilesType.XlsFiles;
import toolkits.parameters.commonparameter;
import toolkits.utils.StringUtils;
import toolkits.utils.date;
import toolkits.utils.logger;

/**
 *
 * @author HP PC
 */
public class ExportReportManager extends bll.bllBase {

    public List<TFile> LstTFile;

    public ExportReportManager() {
        super();
    }

    public void importFile(File OFile) {

        TFile OTFile = new TFile();
        OTFile.setLgFILEID(this.getKey().getComplexId());
        OTFile.setStrNAME(OFile.getName());
        OTFile.setStrPATH(OFile.getAbsolutePath());
        OTFile.setStrSTATUT(commonparameter.statut_enable);
        this.persiste(OTFile);

        this.loadAndStoreDataTExportCcPoids(OTFile);

    }

    public TFile importFileNotProcess(File OFile) {

        TFile OTFile = new TFile();
        OTFile.setLgFILEID(this.getKey().getComplexId());
        OTFile.setStrNAME(OFile.getName());
        OTFile.setStrPATH(OFile.getAbsolutePath());
        OTFile.setStrSTATUT(commonparameter.statut_enable);
        this.persiste(OTFile);

        // this.loadAndStoreDataTExportCcPoids(OTFile);
        return OTFile;

    }

    public void ProcessFile(TFile OTFile) {
        this.loadAndStoreDataTExportCcPoids(OTFile);
    }

    public List<TExportCcPoids> loadAndStoreDataTExportCcPoids(TFile OTFile) {

        //  str_path = "D:\\JAVA\\PROJECTS\\EXPORT_REPORT_C_C\\DOC\\Extraction Excel.xlsx";
        new logger().OCategory.info(OTFile.getStrPATH());
        int int_sheet = 0;
        XlsFiles OXlsFiles = new XlsFiles();
        OXlsFiles.setPath_input(OTFile.getStrPATH());
        OXlsFiles.setModel(new Main.testModel("", int_sheet));
        OXlsFiles.OIxlsModel.IxlsModelToString();
        List<String> lst = OXlsFiles.LoadDataToFiles();
        List<TExportCcPoids> lstTExportCcPoids = new ArrayList<TExportCcPoids>();

        for (int i = 1; i < lst.size(); i++) {
            // new logger().OCategory.info(lst.get(i));
            TExportCcPoids OTExportCcPoids = this.getTExportCcPoidsToString(lst.get(i), OTFile);
            if (OTExportCcPoids != null) {
                this.store(OTExportCcPoids);
                lstTExportCcPoids.add(OTExportCcPoids);
            } else {
                this.buildErrorTraceMessage(lst.get(i));
            }

        }
        return lstTExportCcPoids;
    }

    public TExportCcPoids getTExportCcPoidsToString(String OdataLine, TFile OTFile) {
        String tab[] = StringUtils.split(OdataLine, commonparameter.SEPARATEUR_AROBASE);
        OdataLine = OdataLine.substring(1);

        tab = OdataLine.split(commonparameter.SEPARATEUR_AROBASE);

        if (tab.length != 36) {
            return null;
        }

        try {
            if (!tab[23].trim().equals("Complète")) {
                new logger().OCategory.info("Mauvais statut formule " + tab[23]);
                return null;
            }
            TExportCcPoids OTExportCcPoids = new TExportCcPoids();
            OTExportCcPoids.setLgID(this.getKey().getComplexId());
            OTExportCcPoids.setLgFILEID(OTFile);
            OTExportCcPoids.setStrCAMPAGNE(tab[0]);
            OTExportCcPoids.setStrNOFORMULE(tab[1]);
            OTExportCcPoids.setDtCGFCC(this.getKey().stringToDate(tab[2], date.formatterMysqlShort));
            OTExportCcPoids.setIntMOIS(new Integer(tab[3].replace(".0", "")));
            OTExportCcPoids.setIntANNEE(new Integer(tab[4].replace(".0", "")));
            OTExportCcPoids.setStrEXPORTATEUR(tab[5]);
            OTExportCcPoids.setStrTYPEEXPORTATEUR(tab[6]);
            OTExportCcPoids.setStrCATEGORIE(tab[7]);
            OTExportCcPoids.setStrTRANSITAIRE(tab[8]);
            OTExportCcPoids.setStrPORTEMBARQUEMENT(tab[9]);
            OTExportCcPoids.setStrCONTINENTDESTINATION(tab[10]);
            OTExportCcPoids.setStrPAYSDESTINATION(tab[11]);
            OTExportCcPoids.setStrPORTDESTINATION(tab[12]);
            OTExportCcPoids.setStrPRODUIT(tab[13]);
            OTExportCcPoids.setStrNATUREPRODUIT(tab[14]);
            OTExportCcPoids.setStrRECOLTE(tab[15]);
            OTExportCcPoids.setStrTYPEPRODUIT(tab[16]);
            OTExportCcPoids.setIntPRIXCAF(new Double(tab[17]));
            OTExportCcPoids.setStrTXTNULL(tab[18]);
            OTExportCcPoids.setStrNUMEROCDC(tab[19]);
            OTExportCcPoids.setIntPOIDSNET(new Double(tab[20]));
            OTExportCcPoids.setIntPOIDSFEVE(new Double(tab[21]));

            OTExportCcPoids.setIntPOIDSREEL(new Double(tab[22]));
            OTExportCcPoids.setStrSTATUTFORMULE(tab[23]);
            OTExportCcPoids.setStrNUMEROCERTIFICAT(tab[24]);
            OTExportCcPoids.setStrTRANSIT(tab[25]);
            OTExportCcPoids.setDtRECULE(this.getKey().stringToDate(tab[26], date.formatterMysqlShort));
            OTExportCcPoids.setStrDEPOT(tab[27]);
            OTExportCcPoids.setDtDEPOSELE(this.getKey().stringToDate(tab[28], date.formatterMysqlShort));
            OTExportCcPoids.setStrSIGNE(tab[29]);
            OTExportCcPoids.setDtSIGNELE(this.getKey().stringToDate(tab[30], date.formatterMysqlShort));
            OTExportCcPoids.setStrRETIRE(tab[31]);
            OTExportCcPoids.setDtRETIRELE(this.getKey().stringToDate(tab[32], date.formatterMysqlShort));
            OTExportCcPoids.setStrRETIRANT(tab[33]);

            //System.out.println(OTExportCcPoids.getStrNOFORMULE() + "  --  " + tab[34]);
            OTExportCcPoids.setStrPERIODE(tab[34]);
            OTExportCcPoids.setStrNOMENCLATURE(tab[35]);
            return OTExportCcPoids;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public void store(TExportCcPoids OTExportCcPoids) {
        TCampagne OTCampagne = this.getTCampagne(OTExportCcPoids.getStrCAMPAGNE());
        this.getTCampagneMois(OTExportCcPoids.getIntMOIS(), OTExportCcPoids.getIntANNEE(), OTCampagne, OTExportCcPoids.getStrPRODUIT());
        OTExportCcPoids.getLgFILEID().setLgCAMPAGNEID(OTCampagne);
        this.persisteNotCommit(OTExportCcPoids);
        this.persisteNotCommit(OTExportCcPoids.getLgFILEID());

        this.getTCampagnePoids(OTCampagne, OTExportCcPoids, "POIDS THEORIQUE", OTExportCcPoids.getStrPRODUIT());
        this.getTCampagnePoids(OTCampagne, OTExportCcPoids, "POIDS REEL", OTExportCcPoids.getStrPRODUIT());
        this.getTCampagnePoids(OTCampagne, OTExportCcPoids, "ECART", OTExportCcPoids.getStrPRODUIT());

    }

    public void store(TExportCcMontant OTExportCcPoids) {
        TCampagne OTCampagne = this.getTCampagne(OTExportCcPoids.getStrCAMPAGNE());
        this.getTCampagneMois(OTExportCcPoids.getIntMOIS(), OTCampagne, OTExportCcPoids.getStrPRODUIT());
        OTExportCcPoids.getLgFILEID().setLgCAMPAGNEID(OTCampagne);
        this.persisteNotCommit(OTExportCcPoids);
        // this.persisteNotCommit(OTExportCcPoids.getLgFILEID());
        this.getTCampagneMontant(OTCampagne, OTExportCcPoids, "POIDS THEORIQUE", OTExportCcPoids.getStrPRODUIT());
        this.getTCampagneMontant(OTCampagne, OTExportCcPoids, "POIDS REEL", OTExportCcPoids.getStrPRODUIT());
        this.getTCampagneMontant(OTCampagne, OTExportCcPoids, "ECART", OTExportCcPoids.getStrPRODUIT());
    }

    public TExportCcMontant getTExportCcMontantToString(String OdataLine, TFile OTFile) {
        String tab[] = StringUtils.split(OdataLine, commonparameter.SEPARATEUR_AROBASE);
        OdataLine = OdataLine.substring(1);
        tab = OdataLine.split(commonparameter.SEPARATEUR_AROBASE);
        if (tab.length != 23) {
            return null;
        }

        try {
            if (!tab[22].trim().equals("Complète")) {
                new logger().OCategory.info("Mauvais statut formule " + tab[22]);
                return null;
            }
            TExportCcMontant OTExportCcPoids = new TExportCcMontant();
            OTExportCcPoids.setLgID(this.getKey().getComplexId());
            OTExportCcPoids.setLgFILEID(OTFile);
            OTExportCcPoids.setDtCGFCC(this.getKey().stringToDate(tab[0], date.formatterMysqlShort));
            OTExportCcPoids.setStrCAMPAGNE(tab[1]);
            OTExportCcPoids.setStrNOFORMULE(tab[2]);

            OTExportCcPoids.setStrEXPORTATEUR(tab[3]);
            OTExportCcPoids.setStrTYPEEXPORTATEUR(tab[4]);
            OTExportCcPoids.setStrCATEGORIE(tab[5]);
            OTExportCcPoids.setIntMOIS(new Integer(tab[6].replace(".0", "")));

            OTExportCcPoids.setStrPRODUIT(tab[7]);
            OTExportCcPoids.setStrNATUREPRODUIT(tab[8]);
            OTExportCcPoids.setStrTYPEPRODUIT(tab[9]);
            //OTExportCcPoids.setStrTRANSITAIRE(tab[8]);
            OTExportCcPoids.setStrPORTEMBARQUEMENT(tab[10]);
            OTExportCcPoids.setIntPOIDSFEVE(new Double(tab[11]));
            OTExportCcPoids.setIntPOIDSREEL(new Double(tab[12]));
            OTExportCcPoids.setStrTAXEREDEVANCE(tab[13]);
            OTExportCcPoids.setStrVALEURTAXE(tab[14]);
            OTExportCcPoids.setIntMONTANTPRELEVE(new Double(tab[15]));
            OTExportCcPoids.setIntMONTANTCALCULE(new Double(tab[16]));
            OTExportCcPoids.setIntMONTANTREELE(new Double(tab[17]));
            OTExportCcPoids.setIntREAJUSTEMENT(new Double(tab[18]));
            OTExportCcPoids.setStrNOCHEQUE(tab[19]);
            OTExportCcPoids.setDtDATE(this.getKey().stringToDate(tab[20], date.formatterMysqlShort));
            OTExportCcPoids.setStrBANQUE(tab[21]);
            OTExportCcPoids.setStrSTATUTFORMULE(tab[22]);
            OTExportCcPoids.setIntANNEE(this.getKey().getIntAnnee(OTExportCcPoids.getDtCGFCC()));

            return OTExportCcPoids;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public TCampagne getTCampagne(String str_CAMPAGNE) {
        TCampagne OTCampagne = null;
        try {
            OTCampagne = (TCampagne) this.getOdataManager().getEm().createQuery("SELECT t FROM TCampagne t WHERE t.strNAME LIKE ?1 ").
                    setParameter(1, str_CAMPAGNE).
                    getSingleResult();
            return OTCampagne;
        } catch (Exception e) {

        }
        OTCampagne = new TCampagne();
        OTCampagne.setLgCAMPAGNEID(this.getKey().getComplexId());
        OTCampagne.setStrNAME(str_CAMPAGNE);
        OTCampagne.setStrSTATUT(commonparameter.statut_enable);
        this.persiste(OTCampagne);
        return OTCampagne;
    }

    public TCampagneMois getTCampagneMois(int int_MOIS, int int_ANNEE, TCampagne O, String str_PRODUIT) {
        TCampagneMois OTCampagne = null;
        try {
            OTCampagne = (TCampagneMois) this.getOdataManager().getEm().createQuery("SELECT t FROM TCampagneMois t WHERE t.intANNEE = ?2 AND t.intMOIS = ?1 AND t.strPRODUIT = ?3 ").
                    setParameter(1, int_MOIS).
                    setParameter(2, int_ANNEE).
                    setParameter(3, str_PRODUIT).
                    getSingleResult();
            return OTCampagne;
        } catch (Exception e) {

        }

        OTCampagne = new TCampagneMois();
        OTCampagne.setLgID(this.getKey().getComplexId());
        OTCampagne.setLgCAMPAGNEID(O);
        OTCampagne.setIntANNEE(int_ANNEE);
        OTCampagne.setIntMOIS(int_MOIS);
        OTCampagne.setStrPRODUIT(str_PRODUIT);
        OTCampagne.setStrSTATUT(commonparameter.statut_enable);
        this.persisteNotCommit(OTCampagne);
        return OTCampagne;
    }

    public TCampagneMois getTCampagneMois(int int_MOIS, TCampagne O, String str_PRODUIT) {
        TCampagneMois OTCampagne = null;
        try {
            OTCampagne = (TCampagneMois) this.getOdataManager().getEm().createQuery("SELECT t FROM TCampagneMois t WHERE  t.intMOIS = ?1 AND  t.strPRODUIT = ?3 ").
                    setParameter(1, int_MOIS).
                    setParameter(3, str_PRODUIT).
                    getSingleResult();
            return OTCampagne;
        } catch (Exception e) {

        }

        OTCampagne = new TCampagneMois();
        OTCampagne.setLgID(this.getKey().getComplexId());
        OTCampagne.setLgCAMPAGNEID(O);
        // OTCampagne.setIntANNEE(int_ANNEE);
        OTCampagne.setIntMOIS(int_MOIS);
        OTCampagne.setStrPRODUIT(str_PRODUIT);
        OTCampagne.setStrSTATUT(commonparameter.statut_enable);
        this.persisteNotCommit(OTCampagne);
        return OTCampagne;
    }

    public TCampagneMontant getTCampagneMontant(int int_MOIS, int int_ANNEE, TCampagne O, String str_PRODUIT) {
        TCampagneMontant OTCampagne = null;
        try {
            OTCampagne = (TCampagneMontant) this.getOdataManager().getEm().createQuery("SELECT t FROM TCampagneMontant t WHERE t.intANNEE = ?2 AND t.intMOIS = ?1  AND t.strPRODUIT = ?3 ").
                    setParameter(1, int_MOIS).
                    setParameter(2, int_ANNEE).
                    setParameter(3, str_PRODUIT).
                    getSingleResult();
            return OTCampagne;
        } catch (Exception e) {

        }

        OTCampagne = new TCampagneMontant();
        OTCampagne.setLgID(this.getKey().getComplexId());
        OTCampagne.setLgCAMPAGNEID(O);
        OTCampagne.setIntANNEE(int_ANNEE);
        OTCampagne.setIntMOIS(int_MOIS);
        OTCampagne.setStrPRODUIT(str_PRODUIT);
        OTCampagne.setStrSTATUT(commonparameter.statut_enable);
        this.persiste(OTCampagne);
        return OTCampagne;
    }

    public TCampagneMontant getTCampagneMontant(TCampagne OTCampagne, TExportCcMontant oTExportCcPoids, String str_NAME, String str_PRODUIT) {
        TCampagneMontant o = null;
        try {
            o = new TCampagneMontant();
            o.setLgID(this.getKey().getComplexId());
            o.setIntANNEE(oTExportCcPoids.getIntANNEE());
            o.setIntMOIS(oTExportCcPoids.getIntMOIS());
            o.setStrPORTEMBARQUEMENT(oTExportCcPoids.getStrPORTEMBARQUEMENT());
            o.setStrSTATUT(commonparameter.statut_enable);
            o.setStrTYPEPRODUIT(oTExportCcPoids.getStrTYPEPRODUIT());
            o.setStrNAME(str_NAME);
            o.setStrPRODUIT(str_PRODUIT);
            o.setLgCAMPAGNEID(OTCampagne);
            o.setStrREFEXPORT(oTExportCcPoids.getLgID());

            if (str_NAME.equals("POIDS THEORIQUE")) {
                o.setIntMONTANT(oTExportCcPoids.getIntMONTANTCALCULE());
                o.setIntID(1);

            } else if (str_NAME.equals("POIDS REEL")) {
                o.setIntMONTANT(oTExportCcPoids.getIntPOIDSREEL());
                o.setIntID(2);
            } else if (str_NAME.equals("ECART")) {
                o.setIntMONTANT(oTExportCcPoids.getIntMONTANTCALCULE() - oTExportCcPoids.getIntMONTANTREELE());
                o.setIntID(3);
            } else {
                o.setIntMOIS(0);
                o.setIntID(0);
            }
            this.persisteNotCommit(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return o;
    }

    public TCampagnePoids getTCampagnePoids(TCampagne OTCampagne, TExportCcPoids oTExportCcPoids, String str_NAME, String str_PRODUIT) {
        TCampagnePoids o = null;
        try {
            o = new TCampagnePoids();
            o.setLgID(this.getKey().getComplexId());
            o.setIntANNEE(oTExportCcPoids.getIntANNEE());
            o.setIntMOIS(oTExportCcPoids.getIntMOIS());
            o.setStrPORTEMBARQUEMENT(oTExportCcPoids.getStrPORTEMBARQUEMENT());
            o.setStrSTATUT(commonparameter.statut_enable);
            o.setStrTYPEPRODUIT(oTExportCcPoids.getStrTYPEPRODUIT());
            o.setStrNAME(str_NAME);
            o.setStrTYPEEXPORTATEUR(oTExportCcPoids.getStrTYPEEXPORTATEUR());
            o.setLgCAMPAGNEID(OTCampagne);
            o.setStrREFEXPORT(oTExportCcPoids.getLgID());
            o.setStrPRODUIT(str_PRODUIT);
            if (str_NAME.equals("POIDS THEORIQUE")) {
                o.setIntPOIDS(oTExportCcPoids.getIntPOIDSFEVE());
                o.setIntID(1);

            } else if (str_NAME.equals("POIDS REEL")) {
                o.setIntPOIDS(oTExportCcPoids.getIntPOIDSREEL());
                o.setIntID(2);
            } else if (str_NAME.equals("ECART")) {
                o.setIntPOIDS(oTExportCcPoids.getIntPOIDSREEL() - oTExportCcPoids.getIntPOIDSFEVE());
                o.setIntID(3);
            } else {
                o.setIntPOIDS(0.0);
                o.setIntID(0);
            }
            this.persisteNotCommit(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return o;
    }

    public List<File> getListExportReportFile() {

        return null;
    }

    public List<TFile> getTFile() {
        List<TFile> lst = new ArrayList<TFile>();
        lst = this.getOdataManager().getEm().createQuery("SELECT t FROM TFile t WHERE t.strSTATUT LIKE ?1 ").
                setParameter(1, "%%").
                getResultList();

        return lst;
    }

    public List<TExportCcPoids> getTExportCcPoids(TFile OTFile) {
        List<TExportCcPoids> lst = new ArrayList<TExportCcPoids>();
        lst = this.getOdataManager().getEm().createQuery("SELECT t FROM TExportCcPoids t WHERE t.lgFILEID.lgFILEID = ?1 ").
                setParameter(1, OTFile.getLgFILEID()).
                getResultList();

        return lst;
    }

    public List<TExportCcMontant> getTExportCcMontant(TFile OTFile) {
        List<TExportCcMontant> lst = new ArrayList<TExportCcMontant>();
        lst = this.getOdataManager().getEm().createQuery("SELECT t FROM TExportCcMontant t WHERE t.lgFILEID.lgFILEID = ?1 ").
                setParameter(1, OTFile.getLgFILEID()).
                getResultList();

        return lst;
    }

    public List<TReport> getTReport() {
        List<TReport> lst = new ArrayList<TReport>();
        lst = this.getOdataManager().getEm().createQuery("SELECT t FROM TReport t WHERE t.strSTATUT LIKE ?1 ORDER BY t.intNBELEMENTS ").
                setParameter(1, "%%").
                getResultList();

        return lst;
    }

}
