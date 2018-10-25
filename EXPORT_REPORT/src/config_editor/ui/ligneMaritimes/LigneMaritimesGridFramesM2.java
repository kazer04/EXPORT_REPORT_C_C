/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserDetailFrames.java
 *
 * Created on 16 déc. 2010, 15:43:37
 */
package config_editor.ui.ligneMaritimes;

import config_editor.security.File.*;
import config_editor.ui.ligneMaritimes.entty.Habillage;
import config_editor.ui.ligneMaritimes.entty.IEntity;
import config_editor.ui.ligneMaritimes.entty.Produit;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.openswing.swing.client.*;
import java.util.*;
import org.openswing.swing.util.client.ClientSettings;
import org.openswing.swing.internationalization.java.EnglishOnlyResourceFactory;
import org.openswing.swing.form.model.client.VOModel;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.util.java.Consts;
import java.sql.*;
import org.openswing.swing.message.receive.java.*;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.lookup.client.LookupDataLocator;
import org.openswing.swing.internationalization.java.Resources;
import org.openswing.swing.mdi.client.InternalFrame;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import org.openswing.swing.domains.java.Domain;
import org.openswing.swing.domains.java.DomainPair;
import toolkits.filesmanagers.FilesType.CsvFiles;
import toolkits.filesmanagers.FilesType.TxtFiles;
import toolkits.parameters.commonparameter;
import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 *
 * @author Admin
 */
public class LigneMaritimesGridFramesM2 extends org.openswing.swing.mdi.client.InternalFrame {

    static int int_check = 0;
    Produit OProduit = new Produit();
    Habillage OHabillage = new Habillage();
    DefaultTableModel dtm = null;
    DefaultTableModel dtmHabillage = null;

    /**
     * Creates new form UserDetailFrames
     */
    public LigneMaritimesGridFramesM2() {
        initComponents();
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

    public LigneMaritimesGridFramesM2(FormController dataController) {
        try {
            initComponents();
            mainPanel.setFormController(dataController);
            mainPanel.setSaveButton(saveButton);
            mainPanel.setEditButton(editButton);
            mainPanel.setReloadButton(reloadButton);

            this.setTitle(this.title + " - " + "FORMULAIRE DE SAISIE DU VGM CCI SOLAS M2");

            Domain oDomainMethodePeseVGM = new Domain("MethodePeseVGM");
            // oDomainMethodePeseVGM.addDomainPair("M1", "M1");
            oDomainMethodePeseVGM.addDomainPair("M2", "M2");
            comboBoxControl1.setDomain(oDomainMethodePeseVGM);

            numericControl4.setEnabled(false);
            numericControl4.setEnabledOnEdit(false);

            textControl4.setEnabled(false);
            textControl4.setEnabledOnEdit(false);
            textControl4.setText("0");
            textControl1.setEnabled(false);
            textControl1.setEnabledOnEdit(false);
            textControl1.setText("0");
           // numericControl9.setEnabled(false);
          //  numericControl9.setEnabledOnEdit(false);

            textControl5.setEnabled(false);
            textControl5.setEnabledOnEdit(false);
            textControl5.setText("0");
            this.loadDataToCombo(comboBoxControl2, "TYPE_DOC_EMP");
            this.loadDataToCombo(comboBoxControl3, OProduit);
            //  this.loadDataToCombo(comboBoxControl3, "TRANSITAIRE");
            this.loadDataToCombo(comboBoxControl4, "COMPAGNIE_MARITIME");
            //  this.loadDataToCombo(comboBoxControl5, "PORT_DEBARQ");
            this.loadDataToCombo(comboBoxControl5, OHabillage);
            new logger().OCategory.info(OProduit.getAllData());

            dtm = new DefaultTableModel(0, 0);
            String header[] = new String[]{
                "Produit",
                "Nb.Palette",
                "Nb.Carton.Palettiser.",
                "Nb.Carton.Complementaire.",
                "Poids.Net",
                "Poids Tt.Pal",
                "Poids.TT.Cart.Comp",
                "Poids.TTL"
            };

            dtm.setColumnIdentifiers(header);
            jTable1.setModel(dtm);
            jScrollPane1.setViewportView(jTable1);

            dtmHabillage = new DefaultTableModel(0, 0);
            String headerHabillage[] = new String[]{
                "Desigantion",
                "Nb",
                "Poids",
                "Ref.Habillage"
            };

            dtmHabillage.setColumnIdentifiers(headerHabillage);
            jTable2.setModel(dtmHabillage);
            // jScrollPane1.setViewportView(jTable2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadDataToCombo(ComboBoxControl ocomboBoxControl, String KEY) {
        Domain oDomain = new Domain(KEY);
        CsvFiles OCsvFiles = new CsvFiles();
        //"D:\\TEMP\\DATA/" 
        OCsvFiles.setPath_input("DATA/" + KEY + ".csv");
        java.util.List<String> LstDataPRODUIT = OCsvFiles.LoadDataToFiles();
        new logger().OCategory.info(LstDataPRODUIT.size());
        for (int i = 0; i < LstDataPRODUIT.size(); i++) {
            String[] tabData = LstDataPRODUIT.get(i).split(commonparameter.SEPARATEUR_POINT_VIRGULE);
            oDomain.addDomainPair(tabData[0], tabData[1]);
        }
        ocomboBoxControl.setDomain(oDomain);
    }

    public void loadDataToCombo(ComboBoxControl ocomboBoxControl, IEntity O) {

        Domain oDomain = new Domain(O.getTableName());
        CsvFiles OCsvFiles = new CsvFiles();
        //"D:\\TEMP\\DATA/" 
        OCsvFiles.setPath_input("DATA/" + O.getTableName() + ".csv");
        java.util.List<String> LstDataPRODUIT = OCsvFiles.LoadDataToFiles();
        new logger().OCategory.info(LstDataPRODUIT.size());
        for (int i = 0; i < LstDataPRODUIT.size(); i++) {
            String[] tabData = LstDataPRODUIT.get(i).split(commonparameter.SEPARATEUR_POINT_VIRGULE);
            oDomain.addDomainPair(tabData[O.getIDposition()], tabData[O.getLabelposition()]);
        }
        O.setAllData(LstDataPRODUIT);
        ocomboBoxControl.setDomain(oDomain);
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
        mainPanel = new org.openswing.swing.form.client.Form();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        textControl204 = new org.openswing.swing.client.DateControl();
        textControl21 = new org.openswing.swing.client.TextControl();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        textControl24 = new org.openswing.swing.client.TextControl();
        jLabel27 = new javax.swing.JLabel();
        textControl25 = new org.openswing.swing.client.TextControl();
        jLabel28 = new javax.swing.JLabel();
        textControl26 = new org.openswing.swing.client.TextControl();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        textControl30 = new org.openswing.swing.client.TextControl();
        jLabel33 = new javax.swing.JLabel();
        textControl7 = new org.openswing.swing.client.TextControl();
        textControl8 = new org.openswing.swing.client.TextControl();
        comboBoxControl1 = new org.openswing.swing.client.ComboBoxControl();
        numericControl4 = new org.openswing.swing.client.NumericControl();
        comboBoxControl4 = new org.openswing.swing.client.ComboBoxControl();
        jLabel34 = new javax.swing.JLabel();
        numericControl5 = new org.openswing.swing.client.NumericControl();
        numericControl6 = new org.openswing.swing.client.NumericControl();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        comboBoxControl2 = new org.openswing.swing.client.ComboBoxControl();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        labelControl2 = new org.openswing.swing.client.LabelControl();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        comboBoxControl3 = new org.openswing.swing.client.ComboBoxControl();
        numericControl1 = new org.openswing.swing.client.NumericControl();
        numericControl2 = new org.openswing.swing.client.NumericControl();
        jButton1 = new javax.swing.JButton();
        textControl6 = new org.openswing.swing.client.TextControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelControl4 = new org.openswing.swing.client.LabelControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        labelControl6 = new org.openswing.swing.client.LabelControl();
        numericControl9 = new org.openswing.swing.client.NumericControl();
        labelControl7 = new org.openswing.swing.client.LabelControl();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        labelControl8 = new org.openswing.swing.client.LabelControl();
        numericControl3 = new org.openswing.swing.client.NumericControl();
        labelControl10 = new org.openswing.swing.client.LabelControl();
        labelControl9 = new org.openswing.swing.client.LabelControl();
        comboBoxControl5 = new org.openswing.swing.client.ComboBoxControl();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        textControl1 = new org.openswing.swing.client.TextControl();
        textControl4 = new org.openswing.swing.client.TextControl();
        textControl5 = new org.openswing.swing.client.TextControl();
        jPanel1 = new javax.swing.JPanel();

        setTitle("Formulaire Ligne Maritimes");

        buttonsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        buttonsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        buttonsPanel.add(editButton);

        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(saveButton);
        buttonsPanel.add(reloadButton);

        exportButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButton1ActionPerformed(evt);
            }
        });
        buttonsPanel.add(exportButton1);

        mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        mainPanel.setVOClassName("config_editor.ui.ligneMaritimes.GridLigneMaritimesVOM2");
        mainPanel.setName("mainPanel"); // NOI18N

        jLabel1.setText("Type Document Emp");

        jLabel2.setText("Chargeur");

        jLabel5.setText("N° Booking");

        jLabel21.setText("Heur 2e Pesse");

        jLabel23.setText("N° Plomb");

        textControl204.setAttributeName("date_empotage");

        textControl21.setAttributeName("num_conteneur");
        textControl21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textControl21ActionPerformed(evt);
            }
        });

        jLabel24.setText("N° Conteneur");

        jLabel25.setText("Date 2e Pesee");

        jLabel26.setText("Transitaire");

        textControl24.setAttributeName("navire");

        jLabel27.setText("Navire");

        textControl25.setAttributeName("num_voyage");

        jLabel28.setText("N° Voyage");

        textControl26.setAttributeName("pesseur");
        textControl26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textControl26ActionPerformed(evt);
            }
        });

        jLabel29.setText("Peseur");

        jLabel30.setText("Poids VGM");

        jLabel31.setText("Compagnie Maritime");

        jLabel32.setText("Methode de Pesee VGM");

        textControl30.setAttributeName("agent_ci");

        jLabel33.setText("Agent CI");

        textControl7.setAttributeName("chargeur");

        textControl8.setAttributeName("num_plomb");

        comboBoxControl1.setAttributeName("methode_pesee_vgm");

        numericControl4.setAttributeName("poids_vgm");
        numericControl4.setEnabled(false);

        comboBoxControl4.setAttributeName("compagnie_maritime");

        jLabel34.setText("Port Debarquement");

        numericControl5.setAttributeName("heur");
        numericControl5.setMaxCharacters(2);
        numericControl5.setMaxValue(23.0);

        numericControl6.setAttributeName("min");
        numericControl6.setMaxCharacters(2);
        numericControl6.setMaxValue(59.0);

        labelControl1.setLabel(":");
        labelControl1.setTextAlignment(SwingConstants.CENTER);

        textControl2.setAttributeName("port_debarq");

        comboBoxControl2.setAttributeName("type_doc_emp");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1172, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        jLabel22.setText("Produit");

        labelControl2.setLabel("Nombre de palette");

        labelControl3.setLabel("Nbre complementaire");

        comboBoxControl3.setAttributeName("produit");
        comboBoxControl3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxControl3ItemStateChanged(evt);
            }
        });
        comboBoxControl3.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                comboBoxControl3InputMethodTextChanged(evt);
            }
        });

        jButton1.setActionCommand("Ajouter");
        jButton1.setLabel("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textControl6.setAttributeName("num_booking");
        textControl6.setMaxCharacters(30);

        textControl3.setAttributeName("num_transitaire");
        textControl3.setMaxCharacters(30);

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
        jScrollPane1.setViewportView(jTable1);

        labelControl4.setLabel("Poids ttl produits + emballage et pallette");

        labelControl5.setLabel("Pods Habillages");

        labelControl6.setLabel("Tare Concerné");

        numericControl9.setAttributeName("tare_contenaire");
        numericControl9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericControl9ActionPerformed(evt);
            }
        });

        labelControl7.setLabel("VGM");

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
        jScrollPane2.setViewportView(jTable2);

        labelControl8.setLabel("Nombre");

        labelControl10.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        labelControl10.setLabel("HABILLAGE");

        labelControl9.setLabel("Designation");

        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Supprimer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        textControl5.setAttributeName("agent_ci");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel25)
                            .addComponent(jLabel1)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelControl3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(numericControl5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numericControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboBoxControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(textControl7, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(textControl204, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(textControl21, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(textControl8, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(comboBoxControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(numericControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(numericControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel32))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(numericControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textControl30, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textControl26, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textControl3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(comboBoxControl4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textControl24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textControl25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelControl9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelControl8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(numericControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(comboBoxControl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelControl7, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textControl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(labelControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(numericControl9, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(labelControl5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(labelControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textControl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(177, 177, 177))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(textControl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(textControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxControl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textControl24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textControl25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textControl26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textControl30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30)
                            .addComponent(numericControl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(comboBoxControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textControl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textControl204, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(numericControl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelControl1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(numericControl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textControl21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textControl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxControl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numericControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numericControl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelControl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(jButton4))
                    .addComponent(textControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textControl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(textControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numericControl9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(textControl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelControl10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelControl9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxControl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numericControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        labelControl9.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Saisie du VGM", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1192, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Fichier", jPanel1);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("tab_config");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
/*
        pdfManager OpdfManager = new pdfManager();
        OpdfManager.BuilderPdf("dfddffd");

        new logger().OCategory.info("Impression ok ..");

*/
    }//GEN-LAST:event_exportButton1ActionPerformed

    private void textControl21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textControl21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textControl21ActionPerformed

    private void textControl26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textControl26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textControl26ActionPerformed

    private void comboBoxControl3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxControl3ItemStateChanged
        // TODO add your handling code here:
        new logger().OCategory.info(evt.getItem() + "  -  " + evt.getItem() + "   " + evt.getStateChange());
    }//GEN-LAST:event_comboBoxControl3ItemStateChanged

    private void comboBoxControl3InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_comboBoxControl3InputMethodTextChanged
        // TODO add your handling code here:

        new logger().OCategory.info(evt.getText().toString());

    }//GEN-LAST:event_comboBoxControl3InputMethodTextChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
/*
        TProduit OTProduit = (TProduit) OProduit.getObject(comboBoxControl3.getSelectedIndex());
        textControl4.setEnabled(true);
        textControl4.setEnabledOnEdit(true);
        dtm.addRow(new Object[]{
            OTProduit.getStrNAME(),
            numericControl1.getDouble(),
            OTProduit.getIntNBCARTONPALETTE() * numericControl1.getDouble(),
            numericControl2.getDouble(),
            OTProduit.getIntPOIDSNET() * numericControl1.getDouble(),
            OTProduit.getIntPOIDSPALETTEHB() * numericControl1.getDouble(),
            numericControl2.getDouble() * OTProduit.getIntPOIDSCARTON(),
            (OTProduit.getIntPOIDSPALETTEHB() * numericControl1.getDouble() + numericControl2.getDouble() * OTProduit.getIntPOIDSCARTON())
        }
        );

        Double ev = new Double(0);
        for (int i = 0; i < dtm.getRowCount(); i++) {
            ev = new Double(dtm.getValueAt(i, 7).toString()) + (ev);
        }
        textControl4.setValue(ev.toString());
        textControl4.setEnabled(false);
        textControl4.setEnabledOnEdit(false);

        setTotalVgm();
        */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void numericControl9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numericControl9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numericControl9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
/*
        THabillage OTHabillage = (THabillage) OHabillage.getObject(comboBoxControl5.getSelectedIndex());
        //numericControl7.setEnabled(true);
        // numericControl7.setEnabledOnEdit(true);
        dtmHabillage.addRow(new Object[]{
            OTHabillage.getStrNAME(),
            numericControl3.getDouble(),
            numericControl3.getDouble() * OTHabillage.getIntPOIDS(),
            OTHabillage.getLgHABILLAGEID()
        }
        );

        Double ev = new Double(0);
        for (int i = 0; i < dtmHabillage.getRowCount(); i++) {

            String y1 = dtmHabillage.getValueAt(i, 0).toString();
            String y2 = dtmHabillage.getValueAt(i, 1).toString();
            String y3 = dtmHabillage.getValueAt(i, 2).toString();
            String y4 = dtmHabillage.getValueAt(i, 3).toString();

            //evItem = new BigDecimal(dtmHabillage.getValueAt(i, 0).toString());
            THabillage OTHabillageItem = (THabillage) OHabillage.getObject(new Integer(y4) - 1);
            ev = ev + new Double(y3); // new Double(OTHabillageItem.getIntPOIDS() * new Integer(dtmHabillage.getValueAt(i, 1).toString())).add(ev);
        }
        textControl1.setValue(ev.toString());
        textControl1.setEnabled(false);
        textControl1.setEnabledOnEdit(false);
        setTotalVgm();
*/
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        textControl4.setEnabled(true);
        textControl4.setEnabledOnEdit(true);
        int selRow = jTable1.getSelectedRow();
        if (selRow != -1) {
            dtm.removeRow(selRow);
        }

        Double ev = new Double(0);
        for (int i = 0; i < dtm.getRowCount(); i++) {
            ev = new Double(dtm.getValueAt(i, 7).toString()) + (ev);
        }
        textControl4.setValue(ev.toString());
        textControl4.setEnabled(false);
        textControl4.setEnabledOnEdit(false);

        setTotalVgm();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int selRow = jTable2.getSelectedRow();
        if (selRow != -1) {
            dtmHabillage.removeRow(selRow);
        }
        Double ev = new Double(0);
        for (int i = 0; i < dtmHabillage.getRowCount(); i++) {

            String y1 = dtmHabillage.getValueAt(i, 0).toString();
            String y2 = dtmHabillage.getValueAt(i, 1).toString();
            String y3 = dtmHabillage.getValueAt(i, 2).toString();
            String y4 = dtmHabillage.getValueAt(i, 3).toString();

            //evItem = new BigDecimal(dtmHabillage.getValueAt(i, 0).toString());
           // THabillage OTHabillageItem = (THabillage) OHabillage.getObject(new Integer(y4) - 1);
            ev = ev + new Double(y3); // new Double(OTHabillageItem.getIntPOIDS() * new Integer(dtmHabillage.getValueAt(i, 1).toString())).add(ev);
        }
        textControl1.setValue(ev.toString());
        textControl1.setEnabled(false);
        textControl1.setEnabledOnEdit(false);
        setTotalVgm();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    public void setTotalVgm() {

        Double Total = new Double(0);
        Total = numericControl9.getDouble()+  new Double(textControl4.getText()) + new Double(textControl1.getText()) + new Double(numericControl9.getDouble());
        textControl5.setText(Total.toString());

    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl1;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl2;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl3;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl4;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl5;
    private org.openswing.swing.client.EditButton editButton;
    private org.openswing.swing.client.ExportButton exportButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private org.openswing.swing.client.LabelControl labelControl1;
    private org.openswing.swing.client.LabelControl labelControl10;
    private org.openswing.swing.client.LabelControl labelControl2;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.LabelControl labelControl4;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.client.LabelControl labelControl6;
    private org.openswing.swing.client.LabelControl labelControl7;
    private org.openswing.swing.client.LabelControl labelControl8;
    private org.openswing.swing.client.LabelControl labelControl9;
    private org.openswing.swing.form.client.Form mainPanel;
    private org.openswing.swing.client.NumericControl numericControl1;
    private org.openswing.swing.client.NumericControl numericControl2;
    private org.openswing.swing.client.NumericControl numericControl3;
    private org.openswing.swing.client.NumericControl numericControl4;
    private org.openswing.swing.client.NumericControl numericControl5;
    private org.openswing.swing.client.NumericControl numericControl6;
    private org.openswing.swing.client.NumericControl numericControl9;
    private org.openswing.swing.client.ReloadButton reloadButton;
    private org.openswing.swing.client.SaveButton saveButton;
    private org.openswing.swing.client.TextControl textControl1;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.DateControl textControl204;
    private org.openswing.swing.client.TextControl textControl21;
    private org.openswing.swing.client.TextControl textControl24;
    private org.openswing.swing.client.TextControl textControl25;
    private org.openswing.swing.client.TextControl textControl26;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControl30;
    private org.openswing.swing.client.TextControl textControl4;
    private org.openswing.swing.client.TextControl textControl5;
    private org.openswing.swing.client.TextControl textControl6;
    private org.openswing.swing.client.TextControl textControl7;
    private org.openswing.swing.client.TextControl textControl8;
    // End of variables declaration//GEN-END:variables
}
