/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserDetailFrames.java
 *
 * Created on 16 déc. 2010, 15:43:37
 */
package config_editor.ui.dtt;

import bll.common.CustomComparator;
import bll.entity.Tproduit;
import bll.export_report_cc.ExportReportManager;
import static config_editor.ui.filedtt.FileDttFrameController.str_project_path_of_config;
import config_editor.ui.filedtt.FileDttGridFrames;
import dal.TAlertEvent;
import dal.TExportCcMontant;
import dal.TExportCcPoids;
import dal.TFile;
import dal.TParameters;
import dal.TPrivilege;
import dal.TReport;
import dal.TUser;
import dal.jconnexion;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.openswing.swing.client.*;
import java.util.*;
import org.openswing.swing.util.client.ClientSettings;
import org.openswing.swing.internationalization.java.EnglishOnlyResourceFactory;
import org.openswing.swing.form.model.client.VOModel;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.util.java.Consts;
import java.sql.*;
import java.util.prefs.Preferences;
import org.openswing.swing.message.receive.java.*;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.lookup.client.LookupDataLocator;
import org.openswing.swing.internationalization.java.Resources;
import org.openswing.swing.mdi.client.InternalFrame;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.openswing.swing.domains.java.Domain;
import org.openswing.swing.domains.java.DomainPair;
import report.reportManager;
import toolkits.Main;
import toolkits.filesmanagers.FilesType.CsvFiles;
import toolkits.filesmanagers.FilesType.TxtFiles;
import toolkits.filesmanagers.FilesType.XlsFiles;
import toolkits.filesmanagers.FilesType.XmlFiles;
import toolkits.parameters.commonparameter;
import toolkits.parameters.enumExtentionFiles;
import toolkits.utils.StringUtils;
import toolkits.utils.conversion;
import toolkits.utils.date;
import toolkits.utils.jdom;
import static toolkits.utils.jdom.path_of_config;
import toolkits.utils.logger;

/**
 *
 * @author Admin
 */
public class DttGridFrames extends org.openswing.swing.mdi.client.InternalFrame {

    DefaultTableModel dtmMain = null;
    DefaultTableModel dtmjouranlVente = null;
    DefaultTableModel dtmcompteClient = null;
    DefaultTableModel dtmVendeur = null;
    DefaultTableModel dtmTicket = null;
    DefaultTableModel dtmTicketProduct = null;
    public java.util.List<TFile> lstDtt;
    ExportReportManager odttManager;
    java.util.List<TExportCcPoids> lstTExportCcPoids;
    java.util.List<TExportCcMontant> lstTExportCcMontant;
    java.util.List<TReport> lstTReport;
    java.util.List<Tproduit> lstTproduit;
    java.util.List<TParameters> Lstparameters = new ArrayList<TParameters>();

    /**
     * Creates new form UserDetailFrames
     */
    public DttGridFrames() {
        initComponents();
        // numericControl1.setText("0");
        // numericControl2.setText("0");
        // numericControl3.setText("0");
        odttManager = new ExportReportManager();
        lstTproduit = new ArrayList<Tproduit>();
        // lstTproduit.clear();
        lstTproduit.add(new Tproduit("1", "CACAO"));
        lstTproduit.add(new Tproduit("2", "CAFE"));
    }

    public String getDdata() {
        String Odata = commonparameter.statut_Non_Defini;
        try {
            for (int i = 0; i < Lstparameters.size(); i++) {
                Odata = Odata.replace(Lstparameters.get(i).getStrKEY(), Lstparameters.get(i).getStrVALUE());
            }
            new logger().OCategory.info(Odata);

        } catch (Exception ex) {
            new logger().OCategory.fatal(ex.getMessage());
        }
        Lstparameters.clear();
        return Odata;
    }

    public Form getMainPanel() {
        return mainPanel;
    }

    public SaveButton getSaveButton() {
        return saveButton;
    }

    public EditButton getEditButton() {
        return editButton;
    }

    public DttGridFrames(FormController dataController) {
        try {
            initComponents();
            mainPanel.setFormController(dataController);
            mainPanel.setSaveButton(saveButton);
            mainPanel.setEditButton(editButton);
            mainPanel.setReloadButton(reloadButton);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addParameter(String key, String Value) {
        TParameters OTParameters = new TParameters();
        OTParameters.setStrKEY(key);
        OTParameters.setStrVALUE(Value);
        Lstparameters.add(OTParameters);
    }

    public void loadDataTocomboBoxControlReportPoids(TFile ODtt) {
        // Collections.sort(ODtt.lstProduct, new CustomComparator());
        Domain oDomain = new Domain(ODtt.getStrDATA());
        // new logger().OCategory.info(ODtt.lstProduct.size());
        oDomain.addDomainPair("0", "Selectionnez un Rapport");

        for (int i = 0; i < lstTReport.size(); i++) {
            //  lstTReport.get(i).setStrDATA(lstTReport.get(i).getStrNAME().replace("[str_PRODUIT]", "@@@@@@"));
            lstTReport.get(i).setStrDATA(lstTReport.get(i).getStrNAME().replace("[str_PRODUIT]", "@@@@@@"));
        }

        //O
        for (int i = 0; i < lstTReport.size(); i++) {
            oDomain.addDomainPair(lstTReport.get(i).getLgREPORTID(), lstTReport.get(i).getStrNAME());

        }
        /*for (int i = 0; i < ODtt.lstProduct.size(); i++) {
         String strAmountUnit = "0";
         try {
         strAmountUnit = conversion.AmountFormat(new Double(ODtt.lstProduct.get(i).intAmount * 100).intValue() / new Double(ODtt.lstProduct.get(i).intQuantity * 1).intValue());

         } catch (Exception e) {

         }
         oDomain.addDomainPair(ODtt.lstProduct.get(i).StrRef, ODtt.lstProduct.get(i).strlibele + "   ( " + strAmountUnit + " )");

         }*/
        comboBoxControl2.setDomain(oDomain);
    }

    public void loadDataTocomboBoxControlReportMontant(TFile ODtt) {
        // Collections.sort(ODtt.lstProduct, new CustomComparator());
        Domain oDomain = new Domain(ODtt.getStrDATA());
        // new logger().OCategory.info(ODtt.lstProduct.size());
        oDomain.addDomainPair("0", "Selectionnez un Rapport");

        //O
        for (int i = 0; i < lstTReport.size(); i++) {
            lstTReport.get(i).setStrDATA(lstTReport.get(i).getStrNAME().replace("[str_PRODUIT]", "@@@@@@"));

        }

        for (int i = 0; i < lstTReport.size(); i++) {
            oDomain.addDomainPair(lstTReport.get(i).getLgREPORTID(), lstTReport.get(i).getStrDATA());

        }
        /*for (int i = 0; i < ODtt.lstProduct.size(); i++) {
         String strAmountUnit = "0";
         try {
         strAmountUnit = conversion.AmountFormat(new Double(ODtt.lstProduct.get(i).intAmount * 100).intValue() / new Double(ODtt.lstProduct.get(i).intQuantity * 1).intValue());

         } catch (Exception e) {

         }
         oDomain.addDomainPair(ODtt.lstProduct.get(i).StrRef, ODtt.lstProduct.get(i).strlibele + "   ( " + strAmountUnit + " )");

         }*/
        comboBoxControl3.setDomain(oDomain);
    }

    public void loadDataToCombo(ComboBoxControl ocomboBoxControl, TFile ODtt) {

        Domain oDomain = new Domain(ODtt.getLgFILEID());
        /*
         new logger().OCategory.info(ODtt.lstProduct.size());
         for (int i = 0; i < ODtt.lstProduct.size(); i++) {
         //  String[] tabData = ODtt.lstProduct.get(i).split(commonparameter.SEPARATEUR_POINT_VIRGULE);
         oDomain.addDomainPair(ODtt.lstProduct.get(i).StrRef, ODtt.lstProduct.get(i).strlibele + "   ( " + conversion.AmountFormat(new Double(ODtt.lstProduct.get(i).intAmount * 100).intValue() / new Double(ODtt.lstProduct.get(i).intQuantity * 1).intValue()) + " )");
         }*/
        ocomboBoxControl.setDomain(oDomain);
    }

    public void loadDataToComboProduit(TFile ODtt) {
        Domain oDomain = new Domain(ODtt.getStrDATA());
        // lstTproduit.clear();
        oDomain.addDomainPair("0", "Selectionnez un Produit");
        lstTproduit = new ArrayList<>();
        lstTproduit.add(new Tproduit("1", "CACAO"));
        lstTproduit.add(new Tproduit("2", "CAFE"));
        for (int i = 0; i < lstTproduit.size(); i++) {
            oDomain.addDomainPair(lstTproduit.get(i).getRef(), lstTproduit.get(i).getName());
        }
        comboBoxControl4.setDomain(oDomain);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonsPanel = new javax.swing.JPanel();
        editButton = new org.openswing.swing.client.EditButton();
        saveButton = new org.openswing.swing.client.SaveButton();
        reloadButton = new org.openswing.swing.client.ReloadButton();
        exportButton1 = new org.openswing.swing.client.ExportButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        mainPanel = new org.openswing.swing.form.client.Form();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        comboBoxControl2 = new org.openswing.swing.client.ComboBoxControl();
        jButton5 = new javax.swing.JButton();
        comboBoxControl4 = new org.openswing.swing.client.ComboBoxControl();
        dateControl1 = new org.openswing.swing.client.DateControl();
        dateControl2 = new org.openswing.swing.client.DateControl();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        comboBoxControl3 = new org.openswing.swing.client.ComboBoxControl();
        jButton6 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();

        setTitle("dddd");

        buttonsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        buttonsPanel.add(editButton);
        buttonsPanel.add(saveButton);

        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(reloadButton);

        exportButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButton1ActionPerformed(evt);
            }
        });
        buttonsPanel.add(exportButton1);

        jButton3.setLabel("Charger Fichier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        buttonsPanel.add(jButton3);

        jButton1.setText("Reinitialiser les donnees");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        buttonsPanel.add(jButton1);

        mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        mainPanel.setVOClassName("config_editor.ui.dtt.DttVO");
        mainPanel.setName("mainPanel"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel18.setText("Produit");

        jLabel19.setText("Poids Reel");

        jLabel20.setText("Poid Feve");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("jLabel21");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("jLabel22");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("jLabel23");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("LISTES DES TRANSACTIONS EXPORT POIDS");

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setText("Raport");

        jButton5.setText("Generer le raport ms word");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        comboBoxControl4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxControl4ActionPerformed(evt);
            }
        });

        jLabel38.setText("Du");

        jLabel39.setText("Au");

        jLabel40.setText("Produit");

        jButton7.setText("Generer le raport pdf");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addComponent(comboBoxControl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jLabel39))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboBoxControl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboBoxControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel28)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38))
                                .addGap(1, 1, 1))
                            .addComponent(jButton5)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(comboBoxControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel40))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel39)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel23))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("POIDS", jPanel3);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel29.setText("Montant Calculer");

        jLabel30.setText("Montant Reel");

        jLabel31.setText("Produit");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("jLabel21");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("jLabel22");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("jLabel23");

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel35.setText("Raport");

        jButton6.setText("Generer le raport");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxControl3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(comboBoxControl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel35)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("LISTES DES TRANSACTIONS EXPORT MONTANT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1087, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30)
                            .addComponent(jLabel29))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel33)))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel34))
                .addGap(50, 50, 50)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(137, 137, 137)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(365, Short.MAX_VALUE)))
        );

        jLabel29.getAccessibleContext().setAccessibleName("jLabel33");
        jLabel32.getAccessibleContext().setAccessibleName("jLabel32");
        jLabel33.getAccessibleContext().setAccessibleName("jLabel33");
        jLabel34.getAccessibleContext().setAccessibleName("jLabel34");

        jTabbedPane1.addTab("MONTANT", jPanel1);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("tab_config");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButton1ActionPerformed
        // TODO add your handling code here:
        Preferences pref = Preferences.userRoot();
        String path = pref.get("DEFAULT_PATH", "");
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setCurrentDirectory(new File(path));
        int returnVal = chooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //  File f = chooser.getSelectedFile();
            File selectedFile = chooser.getSelectedFile();
            chooser.setCurrentDirectory(selectedFile);
            // Save the selected path
            pref.put("DEFAULT_PATH", selectedFile.getAbsolutePath());
            XmlFiles OXmlFiles = new XmlFiles("config", path_of_config);
            OXmlFiles.updateFiled("scr_report_pdf", selectedFile.getAbsolutePath());
            OXmlFiles.commit();
            try {
                jdom.InitRessource();
                jdom.LoadRessource();
            } catch (Exception e) {

                e.printStackTrace();
                new logger().OCategory.info(e.getMessage());
                JOptionPane.showMessageDialog(null, "Le fichier de config est introuvable");

            }
            /*
             dttReportManager OdttReportManager = new dttReportManager();
             OdttReportManager.Build(this.lstDtt);

             if (Desktop.isDesktopSupported()) {
             try {
             File myFile = new File(jdom.scr_report_pdf + "/" + OdttReportManager.tittle);
             Desktop.getDesktop().open(myFile);
             } catch (IOException ex) {
             ex.printStackTrace();
             // no application registered for PDFs
             }
             }*/
            // new logger().OCategory.info(OdttReportManager.tittle);
        }
    }//GEN-LAST:event_exportButton1ActionPerformed

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        // TODO add your handling code here:
/*
         TxtFiles OTxtFiles = new TxtFiles();
         //java.util.List<File> lst = OTxtFiles.loadDirectoryAll(jdom.temp_folder + "\\OUT\\NOT_SENT");
         java.util.List<File> lst = OTxtFiles.loadDirectoryAll(jdom.temp_folder + "");
         dtm.getDataVector().clear();

         for (int i = 0; i < lst.size(); i++) {
         String statut = "Non traité";
         if (lst.get(i).getName().split("_")[0].equals(jdom.App_customer_ID)) {
         new logger().OCategory.info(" Fichier en cour de traitement " + lst.get(i).getName());
         statut = "Encours de traitement";
         }

         dtm.addRow(new Object[]{
         lst.get(i).getName(),
         lst.get(i).getAbsoluteFile(),
         statut,
         new date().getdate()
         }
         );

         }*/
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        Preferences pref = Preferences.userRoot();

// Retrieve the selected path or use
// an empty string if no path has
// previously been selected
        String path = pref.get("DEFAULT_PATH", "");

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        /* 
         JFileChooser fileChooser = new JFileChooser(prefs.get("LAST_USED_FOLDER", new File(".").getAbsolutePath()));
         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
         */
// Set the path that was saved in preferences
        chooser.setCurrentDirectory(new File(path));

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //  File f = chooser.getSelectedFile();
            File selectedFile = chooser.getSelectedFile();
            chooser.setCurrentDirectory(selectedFile);
            // Save the selected path
            pref.put("DEFAULT_PATH", selectedFile.getAbsolutePath());
            DttFrameController.str_dtt_curent_path = selectedFile.getAbsolutePath();
            System.out.println("Selected file: " + DttFrameController.str_dtt_curent_path);
            mainPanel.setSaveButton(saveButton);
            mainPanel.setEditButton(editButton);
            mainPanel.setReloadButton(reloadButton);
            reloadButton.doClick();
            this.setTitle("DTT  - Fichier en cours " + DttFrameController.str_dtt_curent_path);

        }

        /*      

         Preferences prefs = Preferences.userRoot().node(getClass().getName());
         // JFileChooser fileChooser = new JFileChooser();
         JFileChooser fileChooser = new JFileChooser(prefs.get("LAST_USED_FOLDER", new File(".").getAbsolutePath()));
         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

         int result = fileChooser.showOpenDialog(this);
         if (result == JFileChooser.APPROVE_OPTION) {
         File selectedFile = fileChooser.getSelectedFile();
         DttFrameController.str_dtt_curent_path = selectedFile.getAbsolutePath();
         System.out.println("Selected file: " + DttFrameController.str_dtt_curent_path);
         mainPanel.setSaveButton(saveButton);
         mainPanel.setEditButton(editButton);
         mainPanel.setReloadButton(reloadButton);
         reloadButton.doClick();
         this.setTitle("DTT  - Fichier en cours " + DttFrameController.str_dtt_curent_path);

         }
         */
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//lstTReport
        DttFrameController.str_dtt_curent_path = jdom.APP_NAME + lstDtt.get(0).getLgFILEID();
        System.out.println("Selected file: " + DttFrameController.str_dtt_curent_path);
        mainPanel.setSaveButton(saveButton);
        mainPanel.setEditButton(editButton);
        mainPanel.setReloadButton(reloadButton);
        reloadButton.doClick();
        this.setTitle("DTT  - Fichier en cours " + DttFrameController.str_dtt_curent_path);
        jLabel24.setText("LISTES DES ARTICLES DE TOUT LES TICKETS DU DTT ");
        jLabel21.setText("");
        jLabel22.setText("");
        jLabel23.setText("");


    }//GEN-LAST:event_jButton1ActionPerformed

    public void loadInitDttInFrame() {
        DttFrameController.str_dtt_curent_path = jdom.APP_NAME + lstDtt.get(0).getLgFILEID();
        System.out.println("Selected file: " + DttFrameController.str_dtt_curent_path);
        mainPanel.setSaveButton(saveButton);
        mainPanel.setEditButton(editButton);
        mainPanel.setReloadButton(reloadButton);
        reloadButton.doClick();
        this.setTitle("Fichier en cours  " + lstDtt.get(0).getStrNAME());
        jLabel24.setText("LISTES DES TRANSACTIONS PAR POIDS ");
        jLabel21.setText("");
        jLabel22.setText("");
        jLabel23.setText("");

        jLabel32.setText("");
        jLabel33.setText("");
        jLabel34.setText("");

    }


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        // TODO add your handling code here:
        DefaultTableModel md = (DefaultTableModel) jTable1.getModel();
        int intSelect = jTable1.getSelectedRow();
        TExportCcPoids OProduct = lstTExportCcPoids.get(intSelect);
        jLabel21.setText(OProduct.getStrPRODUIT());
        jLabel22.setText(conversion.AmountFormat(new Double(OProduct.getIntPOIDSREEL() * 1).intValue()) + "");
        jLabel23.setText(conversion.AmountFormat(new Double(OProduct.getIntPOIDSFEVE() * 1).intValue()) + "");
        // conversion.AmountFormat(new Double(OProduct.intAmount * 100).intValue());

        // populateProductTicketGrid(lstDtt.get(0).lstTicket.get(intSelect));

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        // TODO add your handling code here:
        DefaultTableModel md = (DefaultTableModel) jTable2.getModel();
        int intSelect = jTable2.getSelectedRow();
        TExportCcMontant OProduct = lstTExportCcMontant.get(intSelect);
        jLabel32.setText(OProduct.getStrPRODUIT());
        jLabel33.setText(conversion.AmountFormat(new Double(OProduct.getIntMONTANTREELE() * 1).intValue()) + "");
        jLabel34.setText(conversion.AmountFormat(new Double(OProduct.getIntMONTANTCALCULE() * 1).intValue()) + "");


    }//GEN-LAST:event_jTable2MouseClicked

    private void comboBoxControl4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxControl4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxControl4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
//MS WORD
        
        //comboBoxControl2
        if ((comboBoxControl2.getComboBox().getSelectedIndex() - 1) == - 2) {
            new logger().OCategory.info("Vous devez selectionnez un rapport");
            JOptionPane.showMessageDialog(null, "Vous devez selectionnez un rapport");
            comboBoxControl2.requestFocus();
            return;
        } else if ((comboBoxControl2.getComboBox().getSelectedIndex() - 1) == - 1) {
            new logger().OCategory.info("Vous devez selectionnez un rapport");
            JOptionPane.showMessageDialog(null, "Vous devez selectionnez un rapport");
            comboBoxControl2.requestFocus();
            return;
        } else if ((comboBoxControl4.getComboBox().getSelectedIndex() - 1) == - 1) {
            new logger().OCategory.info("Vous devez selectionnez un produit");
            JOptionPane.showMessageDialog(null, "Vous devez selectionnez un produit");
            comboBoxControl4.requestFocus();
            return;
        } else if ((comboBoxControl4.getComboBox().getSelectedIndex() - 1) == - 2) {
            new logger().OCategory.info("Vous devez selectionnez un produit");
            JOptionPane.showMessageDialog(null, "Vous devez selectionnez un produit");
            comboBoxControl4.requestFocus();
            return;
        } else if (dateControl1.getDate() == null) {
            new logger().OCategory.info("Vous devez selectionnez une date de debut");
            JOptionPane.showMessageDialog(null, "Vous devez selectionnez une date de debut");
            comboBoxControl4.requestFocus();
            return;
        } else if (dateControl2.getDate() == null) {
            new logger().OCategory.info("Vous devez selectionnez une date de fin");
            JOptionPane.showMessageDialog(null, "Vous devez selectionnez une date de fin");
            comboBoxControl4.requestFocus();
            return;
        } else {

            /*   java.util.List<Tproduit> lstTproduitTemp = new ArrayList<Tproduit>();
             lstTproduitTemp.add(new Tproduit("0", "Selectionner un produit"));
             lstTproduitTemp.add(new Tproduit("1", "CACAO"));
             lstTproduitTemp.add(new Tproduit("2", "CAFE"));
             */
            // dateControl1.getDate();
            // JOptionPane.showMessageDialog(null, "Generation du " + lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrNAME() + "  " + dateControl1.getDate() + "  " + dateControl2.getDate() + "  " + lstTproduitTemp.get(comboBoxControl4.getSelectedIndex() - 1).getName());
            //"Generation du " + lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrNAME() + "  " + dateControl1.getDate() + "  " + dateControl2.getDate() + "  " + lstTproduitTemp.get(comboBoxControl4.getSelectedIndex() - 1).getName()
            // TaskDoReport task = new TaskDoReport(lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1));
            //task.addPropertyChangeListener(this);
            // task.execute();
            reportManager OreportManager = new reportManager();
            Map parameters = new HashMap();
            //OdataManager.initEntityManager();

            java.util.Date OdateFin = odttManager.getKey().stringToDate(odttManager.getKey().getAnnee(dateControl2.getDate()) + "-" + odttManager.getKey().getInMois(dateControl2.getDate()) + "-28", odttManager.getKey().formatterMysqlShort);

            new logger().OCategory.info("Generation du " + lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrNAME() + "  [Du " + odttManager.getKey().DateToString(dateControl1.getDate(), odttManager.getKey().formatterMysqlShort) + "  Au " + odttManager.getKey().DateToString(OdateFin, odttManager.getKey().formatterMysqlShort) + "]    [Produit :" + lstTproduit.get(comboBoxControl4.getSelectedIndex() - 1).getName() + "] ....");

            new logger().OCategory.info(OdateFin);
            this.setTitle("Generation du " + lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrNAME() + "  [Du " + odttManager.getKey().DateToString(dateControl1.getDate(), odttManager.getKey().formatterMysqlShort) + "  Au " + odttManager.getKey().DateToString(OdateFin, odttManager.getKey().formatterMysqlShort) + "]    [Produit :" + lstTproduit.get(comboBoxControl4.getSelectedIndex() - 1).getName() + "] ....");

            String scr_report_file = "", report_tittle = "";
            report_tittle = lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrNAME() + " [" + lstTproduit.get(comboBoxControl4.getSelectedIndex() - 1).getName() + "]" + " " + odttManager.key.getDateTime() + "_" + odttManager.key.GetNumberRandom();
            jconnexion ojconnexion = new jconnexion();
            ojconnexion.initConnexion();
            ojconnexion.OpenConnexion();

            //En tete
            parameters.put("P_H_TITTLE", odttManager.getOTranslate().getValue("%%"));
            parameters.put("P_DATE_DEBUT", odttManager.getKey().DateToString(dateControl1.getDate(), odttManager.getKey().formatterMysql));
            parameters.put("P_DATE_FIN", odttManager.getKey().DateToString(OdateFin, odttManager.getKey().formatterMysql));

            parameters.put("P_DATE_DEBUT_ANNEE", odttManager.getKey().getAnnee(dateControl1.getDate()));

            parameters.put("P_DATE_FIN_ANNEE", odttManager.getKey().getAnnee(OdateFin));

            parameters.put("P_DATE_DEBUT_MOIS", odttManager.getKey().getStrMois(dateControl1.getDate())+"-"+odttManager.getKey().getStrMois(OdateFin)+" "+odttManager.getKey().getAnnee(dateControl1.getDate()) );
            parameters.put("P_DATE_FIN_MOIS", odttManager.getKey().getStrMois(OdateFin)+" "+odttManager.getKey().getAnnee(OdateFin));

            parameters.put("P_PRODUIT", lstTproduit.get(comboBoxControl4.getSelectedIndex() - 1).getName());
            parameters.put("P_TITRE", lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrNAME() + " [" + lstTproduit.get(comboBoxControl4.getSelectedIndex() - 1).getName() + "]" + " [Du " + odttManager.getKey().DateToString(dateControl1.getDate(), odttManager.getKey().formatterMysqlShort) + "  Au " + odttManager.getKey().DateToString(OdateFin, odttManager.getKey().formatterMysqlShort) + "]");
            scr_report_file = lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrPATH();
            report_tittle = report_tittle + ".docx";
            OreportManager.setPath_report_src(jdom.scr_report_file + scr_report_file + ".jasper");
            OreportManager.setPath_report_pdf("D://RAPPORTS/" + report_tittle);
            OreportManager.BuildReportMSWORD(parameters, ojconnexion);
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(OreportManager.getPath_report_pdf());
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    // no application registered for PDFs
                }
            }
            // this.setTitle("Fichier en cours  " + lstDtt.get(0).getStrNAME());
        }

        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
        //PDF
        //comboBoxControl2
        if ((comboBoxControl2.getComboBox().getSelectedIndex() - 1) == - 2) {
            new logger().OCategory.info("Vous devez selectionnez un rapport");
            JOptionPane.showMessageDialog(null, "Vous devez selectionnez un rapport");
            comboBoxControl2.requestFocus();
            return;
        } else if ((comboBoxControl2.getComboBox().getSelectedIndex() - 1) == - 1) {
            new logger().OCategory.info("Vous devez selectionnez un rapport");
            JOptionPane.showMessageDialog(null, "Vous devez selectionnez un rapport");
            comboBoxControl2.requestFocus();
            return;
        } else if ((comboBoxControl4.getComboBox().getSelectedIndex() - 1) == - 1) {
            new logger().OCategory.info("Vous devez selectionnez un produit");
            JOptionPane.showMessageDialog(null, "Vous devez selectionnez un produit");
            comboBoxControl4.requestFocus();
            return;
        } else if ((comboBoxControl4.getComboBox().getSelectedIndex() - 1) == - 2) {
            new logger().OCategory.info("Vous devez selectionnez un produit");
            JOptionPane.showMessageDialog(null, "Vous devez selectionnez un produit");
            comboBoxControl4.requestFocus();
            return;
        } else if (dateControl1.getDate() == null) {
            new logger().OCategory.info("Vous devez selectionnez une date de debut");
            JOptionPane.showMessageDialog(null, "Vous devez selectionnez une date de debut");
            comboBoxControl4.requestFocus();
            return;
        } else if (dateControl2.getDate() == null) {
            new logger().OCategory.info("Vous devez selectionnez une date de fin");
            JOptionPane.showMessageDialog(null, "Vous devez selectionnez une date de fin");
            comboBoxControl4.requestFocus();
            return;
        } else {

            /*   java.util.List<Tproduit> lstTproduitTemp = new ArrayList<Tproduit>();
             lstTproduitTemp.add(new Tproduit("0", "Selectionner un produit"));
             lstTproduitTemp.add(new Tproduit("1", "CACAO"));
             lstTproduitTemp.add(new Tproduit("2", "CAFE"));
             */
            // dateControl1.getDate();
            // JOptionPane.showMessageDialog(null, "Generation du " + lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrNAME() + "  " + dateControl1.getDate() + "  " + dateControl2.getDate() + "  " + lstTproduitTemp.get(comboBoxControl4.getSelectedIndex() - 1).getName());
            //"Generation du " + lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrNAME() + "  " + dateControl1.getDate() + "  " + dateControl2.getDate() + "  " + lstTproduitTemp.get(comboBoxControl4.getSelectedIndex() - 1).getName()
            // TaskDoReport task = new TaskDoReport(lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1));
            //task.addPropertyChangeListener(this);
            // task.execute();
            reportManager OreportManager = new reportManager();
            Map parameters = new HashMap();
            //OdataManager.initEntityManager();

            java.util.Date OdateFin = odttManager.getKey().stringToDate(odttManager.getKey().getAnnee(dateControl2.getDate()) + "-" + odttManager.getKey().getInMois(dateControl2.getDate()) + "-28", odttManager.getKey().formatterMysqlShort);

            new logger().OCategory.info("Generation du " + lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrNAME() + "  [Du " + odttManager.getKey().DateToString(dateControl1.getDate(), odttManager.getKey().formatterMysqlShort) + "  Au " + odttManager.getKey().DateToString(OdateFin, odttManager.getKey().formatterMysqlShort) + "]    [Produit :" + lstTproduit.get(comboBoxControl4.getSelectedIndex() - 1).getName() + "] ....");

            new logger().OCategory.info(OdateFin);
            this.setTitle("Generation du " + lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrNAME() + "  [Du " + odttManager.getKey().DateToString(dateControl1.getDate(), odttManager.getKey().formatterMysqlShort) + "  Au " + odttManager.getKey().DateToString(OdateFin, odttManager.getKey().formatterMysqlShort) + "]    [Produit :" + lstTproduit.get(comboBoxControl4.getSelectedIndex() - 1).getName() + "] ....");

            String scr_report_file = "", report_tittle = "";
            report_tittle = lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrNAME() + " [" + lstTproduit.get(comboBoxControl4.getSelectedIndex() - 1).getName() + "]" + " " + odttManager.key.getDateTime() + "_" + odttManager.key.GetNumberRandom();
            jconnexion ojconnexion = new jconnexion();
            ojconnexion.initConnexion();
            ojconnexion.OpenConnexion();

            //En tete
            parameters.put("P_H_TITTLE", odttManager.getOTranslate().getValue("%%"));
            parameters.put("P_DATE_DEBUT", odttManager.getKey().DateToString(dateControl1.getDate(), odttManager.getKey().formatterMysql));
            parameters.put("P_DATE_FIN", odttManager.getKey().DateToString(OdateFin, odttManager.getKey().formatterMysql));

            parameters.put("P_DATE_DEBUT_ANNEE", odttManager.getKey().getAnnee(dateControl1.getDate()));

            parameters.put("P_DATE_FIN_ANNEE", odttManager.getKey().getAnnee(OdateFin));

            parameters.put("P_DATE_DEBUT_MOIS", odttManager.getKey().getStrMois(dateControl1.getDate())+"-"+odttManager.getKey().getStrMois(OdateFin)+" "+odttManager.getKey().getAnnee(dateControl1.getDate()) );
            parameters.put("P_DATE_FIN_MOIS", odttManager.getKey().getStrMois(OdateFin)+" "+odttManager.getKey().getAnnee(OdateFin));

            parameters.put("P_PRODUIT", lstTproduit.get(comboBoxControl4.getSelectedIndex() - 1).getName());
            parameters.put("P_TITRE", lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrNAME() + " [" + lstTproduit.get(comboBoxControl4.getSelectedIndex() - 1).getName() + "]" + " [Du " + odttManager.getKey().DateToString(dateControl1.getDate(), odttManager.getKey().formatterMysqlShort) + "  Au " + odttManager.getKey().DateToString(OdateFin, odttManager.getKey().formatterMysqlShort) + "]");
            scr_report_file = lstTReport.get(comboBoxControl2.getComboBox().getSelectedIndex() - 1).getStrPATH();
            report_tittle = report_tittle + ".pdf";
            OreportManager.setPath_report_src(jdom.scr_report_file + scr_report_file + ".jrxml");
            OreportManager.setPath_report_pdf("D://RAPPORTS/" + report_tittle);
            OreportManager.BuildReportPDF(parameters, ojconnexion);
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(OreportManager.getPath_report_pdf());
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    // no application registered for PDFs
                }
            }
            // this.setTitle("Fichier en cours  " + lstDtt.get(0).getStrNAME());
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void saveToTemp(Object OTicket) {

    }

    public void loadDataToCombo44(ComboBoxControl ocomboBoxControl, String KEY) {
        /* try {
         String current = new java.io.File(".").getCanonicalPath();
         System.out.println("Current dir:" + current);
         String currentDir = System.getProperty("user.dir");
         System.out.println("Current dir using System:" + currentDir);
         } catch (Exception e) {
         e.printStackTrace();
         }
         */
        Domain oDomain = new Domain(KEY);
        CsvFiles OCsvFiles = new CsvFiles();
        //"D:\\TEMP\\DATA/" 
        OCsvFiles.setPath_input("DATA/" + KEY + ".csv");
        java.util.List<String> LstDataPRODUIT = OCsvFiles.LoadDataToFiles();
        new logger().OCategory.info(LstDataPRODUIT.size());
        for (int i = 0; i < LstDataPRODUIT.size(); i++) {
            // new logger().OCategory.info(LstDataPRODUIT.get(i));
            String[] tabData = LstDataPRODUIT.get(i).split(commonparameter.SEPARATEUR_POINT_VIRGULE);
            oDomain.addDomainPair(tabData[0], tabData[1]);
        }
        ocomboBoxControl.setDomain(oDomain);
    }

    public void populateMainPoidsGrid(TFile ODtt) {
        new logger().OCategory.info("Load data populateMainPoidsGrid");

        dtmMain = new DefaultTableModel(0, 0);
        String header[] = new String[]{
            "Campagne",
            "Formule",
            "Produit",
            "Nature Produit",
            "Prix.Caf",
            "Poid.Net",
            "Poid.Feve",
            "Poid.Reel",
            "Num.Certificat",
            "Transit"
        };

        dtmMain.setColumnIdentifiers(header);
        //set model into the table object
        jTable1.setModel(dtmMain);
        jScrollPane1.setViewportView(jTable1);
        odttManager = new ExportReportManager();
        odttManager.checkDatamanager();
        lstTExportCcPoids = odttManager.getTExportCcPoids(ODtt);
        lstTReport = odttManager.getTReport();
        Collections.sort(lstTExportCcPoids, new CustomComparator());
        new logger().OCategory.info(lstTExportCcPoids.size());
        for (int i = 0; i < lstTExportCcPoids.size(); i++) {

            dtmMain.addRow(new Object[]{
                lstTExportCcPoids.get(i).getStrCAMPAGNE(),
                lstTExportCcPoids.get(i).getStrNOFORMULE(),
                lstTExportCcPoids.get(i).getStrPRODUIT(),
                lstTExportCcPoids.get(i).getStrNATUREPRODUIT(),
                conversion.AmountFormat(new Double(lstTExportCcPoids.get(i).getIntPRIXCAF() * 1).intValue()),
                conversion.AmountFormat(new Double(lstTExportCcPoids.get(i).getIntPOIDSNET() * 1).intValue()),
                conversion.AmountFormat(new Double(lstTExportCcPoids.get(i).getIntPOIDSFEVE() * 1).intValue()),
                conversion.AmountFormat(new Double(lstTExportCcPoids.get(i).getIntPOIDSREEL() * 1).intValue()),
                lstTExportCcPoids.get(i).getStrNUMEROCERTIFICAT(),
                lstTExportCcPoids.get(i).getStrTRANSIT()
            }
            );

        }
        jLabel24.setText("LISTES DES TRANSACTIONS PAR POIDS (" + lstTExportCcPoids.size() + ")");
    }

    public void populateMainMontantGrid(TFile ODtt) {
        new logger().OCategory.info("Load data populateMainMontantGrid");

        dtmMain = new DefaultTableModel(0, 0);
        String header[] = new String[]{
            "Campagne",
            "Formule",
            "Produit",
            "Nature Produit",
            "Montant Cal",
            "Montant Reel",
            "Poid.Feve",
            "Poid.Reel",
            "Banque",
            "Exportateur"
        };

        dtmMain.setColumnIdentifiers(header);
        //set model into the table object
        jTable2.setModel(dtmMain);
        jScrollPane2.setViewportView(jTable2);
        odttManager = new ExportReportManager();
        odttManager.checkDatamanager();
        lstTExportCcMontant = odttManager.getTExportCcMontant(ODtt);
        lstTReport = odttManager.getTReport();
        Collections.sort(lstTExportCcMontant, new CustomComparator());
        new logger().OCategory.info(lstTExportCcMontant.size());
        for (int i = 0; i < lstTExportCcMontant.size(); i++) {

            dtmMain.addRow(new Object[]{
                lstTExportCcMontant.get(i).getStrCAMPAGNE(),
                lstTExportCcMontant.get(i).getStrNOFORMULE(),
                lstTExportCcMontant.get(i).getStrPRODUIT(),
                lstTExportCcMontant.get(i).getStrNATUREPRODUIT(),
                conversion.AmountFormat(new Double(lstTExportCcMontant.get(i).getIntMONTANTCALCULE() * 1).intValue()),
                conversion.AmountFormat(new Double(lstTExportCcMontant.get(i).getIntMONTANTREELE() * 1).intValue()),
                conversion.AmountFormat(new Double(lstTExportCcMontant.get(i).getIntPOIDSFEVE() * 1).intValue()),
                conversion.AmountFormat(new Double(lstTExportCcMontant.get(i).getIntPOIDSREEL() * 1).intValue()),
                lstTExportCcMontant.get(i).getStrBANQUE(),
                lstTExportCcMontant.get(i).getStrEXPORTATEUR()
            }
            );

        }
        jLabel36.setText("LISTES DES TRANSACTIONS PAR MONTANT (" + lstTExportCcMontant.size() + ")");
    }

    public class TaskDoReport extends SwingWorker<Void, Void> {

        TReport OTFile;

        public TaskDoReport(TReport oTFile) {
            jButton5.setEnabled(false);
            this.OTFile = oTFile;
        }

        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            setProgress(0);
            setTitle("Generation des report " + OTFile.getStrNAME());

            reportManager OreportManager = new reportManager();
            Map parameters = new HashMap();
            //OdataManager.initEntityManager();

            String scr_report_file = "", report_tittle = "";
            report_tittle = odttManager.key.getDateTime() + "_" + odttManager.key.GetNumberRandom();
            jconnexion ojconnexion = new jconnexion();
            ojconnexion.initConnexion();
            ojconnexion.OpenConnexion();

            //En tete
            parameters.put("P_H_TITTLE", odttManager.getOTranslate().getValue("%%"));
            scr_report_file = OTFile.getStrPATH();
            report_tittle = report_tittle + ".pdf";
            OreportManager.setPath_report_src(jdom.scr_report_file + scr_report_file + ".jrxml");
            OreportManager.setPath_report_pdf("D://" + report_tittle);
            OreportManager.BuildReportPDF(parameters, ojconnexion);
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(OreportManager.getPath_report_pdf());
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    // no application registered for PDFs
                }
            } else {
                new logger().OCategory.info("NOT SUPPRTTED");
            }

            return null;
        }

        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();

            setCursor(null); //turn off the wait cursor
            //jTextArea1.append("Terminé!\n");
            jButton5.setEnabled(true);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl2;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl3;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl4;
    private org.openswing.swing.client.DateControl dateControl1;
    private org.openswing.swing.client.DateControl dateControl2;
    private org.openswing.swing.client.EditButton editButton;
    private org.openswing.swing.client.ExportButton exportButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private org.openswing.swing.form.client.Form mainPanel;
    private org.openswing.swing.client.ReloadButton reloadButton;
    private org.openswing.swing.client.SaveButton saveButton;
    // End of variables declaration//GEN-END:variables
}
