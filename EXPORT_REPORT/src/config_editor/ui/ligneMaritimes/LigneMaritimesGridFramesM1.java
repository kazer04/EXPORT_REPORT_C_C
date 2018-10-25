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
import javax.swing.*;
import java.awt.*;
import java.io.File;
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
import toolkits.utils.date;
import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 *
 * @author Admin
 */
public class LigneMaritimesGridFramesM1 extends org.openswing.swing.mdi.client.InternalFrame {

    DefaultTableModel dtm = null;

    /**
     * Creates new form UserDetailFrames
     */
    public LigneMaritimesGridFramesM1() {
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

    public LigneMaritimesGridFramesM1(FormController dataController) {
        try {
            initComponents();
            mainPanel.setFormController(dataController);
            mainPanel.setSaveButton(saveButton);
            mainPanel.setEditButton(editButton);
            mainPanel.setReloadButton(reloadButton);

            this.setTitle(this.title + " - " + "FORMULAIRE DE SAISIE DU VGM CCI SOLAS M1");

            Domain oDomainMethodePeseVGM = new Domain("MethodePeseVGM");
            oDomainMethodePeseVGM.addDomainPair("M1", "M1");
            // oDomainMethodePeseVGM.addDomainPair("M2", "M2");
            comboBoxControl1.setDomain(oDomainMethodePeseVGM);

            numericControl4.setEnabled(false);
            numericControl4.setEnabledOnEdit(false);

            //  this.loadDataToCombo(comboBoxControl2, "PRODUIT");
            //  this.loadDataToCombo(comboBoxControl3, "TRANSITAIRE");
            this.loadDataToCombo(comboBoxControl4, "COMPAGNIE_MARITIME");
            //  this.loadDataToCombo(comboBoxControl5, "PORT_DEBARQ");

            dtm = new DefaultTableModel(0, 0);
            String header[] = new String[]{
                "Nom.Fichier",
                "Chemin",
                "Statut",
                "Date"
            };

            dtm.setColumnIdentifiers(header);
            //set model into the table object
            jTable1.setModel(dtm);
            jScrollPane1.setViewportView(jTable1);

            TxtFiles OTxtFiles = new TxtFiles();
            //java.util.List<File> lst = OTxtFiles.loadDirectoryAll(jdom.temp_folder + "\\OUT\\NOT_SENT");
            java.util.List<File> lst = OTxtFiles.loadDirectoryAll(jdom.temp_folder + "");
/*
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

            }
*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadDataToCombo(ComboBoxControl ocomboBoxControl, String KEY) {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textControl6 = new org.openswing.swing.client.TextControl();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
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
        numericControl1 = new org.openswing.swing.client.NumericControl();
        numericControl2 = new org.openswing.swing.client.NumericControl();
        numericControl3 = new org.openswing.swing.client.NumericControl();
        numericControl4 = new org.openswing.swing.client.NumericControl();
        comboBoxControl4 = new org.openswing.swing.client.ComboBoxControl();
        jLabel34 = new javax.swing.JLabel();
        numericControl5 = new org.openswing.swing.client.NumericControl();
        numericControl6 = new org.openswing.swing.client.NumericControl();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        textControl1 = new org.openswing.swing.client.TextControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setTitle("Formulaire Ligne Maritimes");

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

        mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        mainPanel.setVOClassName("config_editor.ui.ligneMaritimes.GridLigneMaritimesVOM1");
        mainPanel.setName("mainPanel"); // NOI18N

        jLabel1.setText("Num.Ticket.Pesee");

        jLabel2.setText("Chargeur");

        jLabel3.setText("Poids 1");

        jLabel4.setText("Poids 2");

        jLabel5.setText("N° Booking");

        textControl6.setAttributeName("num_booking");
        textControl6.setMaxCharacters(30);

        jLabel21.setText("Heur 2e Pesse");

        jLabel22.setText("Produit");

        jLabel23.setText("N° Plomb");

        textControl204.setAttributeName("date_2_pessee");

        textControl21.setAttributeName("num_conteneur");
        textControl21.setMaxCharacters(30);

        jLabel24.setText("N° Conteneur");

        jLabel25.setText("Date 2e Pesee");

        jLabel26.setText("Transitaire");

        textControl24.setAttributeName("navire");
        textControl24.setMaxCharacters(30);

        jLabel27.setText("Navire");

        textControl25.setAttributeName("num_voyage");
        textControl25.setMaxCharacters(30);

        jLabel28.setText("N° Voyage");

        textControl26.setAttributeName("pesseur");
        textControl26.setMaxCharacters(30);

        jLabel29.setText("Peseur");

        jLabel30.setText("Poids VGM");

        jLabel31.setText("Compagnie Maritime");

        jLabel32.setText("Methode de Pesee VGM");

        textControl30.setAttributeName("agent_ci");
        textControl30.setMaxCharacters(30);

        jLabel33.setText("Agent CI");

        textControl7.setAttributeName("chargeur");
        textControl7.setMaxCharacters(30);

        textControl8.setAttributeName("num_plomb");
        textControl8.setMaxCharacters(30);

        comboBoxControl1.setAttributeName("methode_pesee_vgm");
        comboBoxControl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxControl1ActionPerformed(evt);
            }
        });

        numericControl1.setAttributeName("num_ticket_pesee");

        numericControl2.setAttributeName("poids_pesee_1");

        numericControl3.setAttributeName("poids_pesee_2");

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

        textControl1.setAttributeName("produit");
        textControl1.setMaxCharacters(30);

        textControl2.setAttributeName("port_debarq");
        textControl2.setMaxCharacters(30);

        textControl3.setAttributeName("num_transitaire");
        textControl3.setMaxCharacters(30);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textControl21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textControl204, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textControl7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textControl8, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(numericControl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numericControl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numericControl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(numericControl5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelControl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numericControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textControl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(174, 174, 174)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel26)
                            .addComponent(jLabel31)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel33)
                            .addComponent(jLabel30)
                            .addComponent(jLabel29))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textControl6, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(textControl24, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(textControl25, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(textControl26, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(numericControl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textControl30, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(comboBoxControl4, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(textControl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(textControl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(184, 184, 184))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(numericControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textControl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel2)
                    .addComponent(textControl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numericControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxControl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textControl24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numericControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textControl25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(textControl204, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(textControl26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel29)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textControl30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(numericControl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(textControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(64, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel22))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(numericControl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(numericControl6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelControl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(textControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textControl21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textControl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Saisie du VGM", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1063, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Fichier", jPanel1);

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

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    //    pdfManager OpdfManager = new pdfManager();
     //   OpdfManager.BuilderPdf("dfddffd");

     //   new logger().OCategory.info("Impression ok ..");


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

    private void comboBoxControl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxControl1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxControl1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl1;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl4;
    private org.openswing.swing.client.EditButton editButton;
    private org.openswing.swing.client.ExportButton exportButton1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private org.openswing.swing.client.LabelControl labelControl1;
    private org.openswing.swing.form.client.Form mainPanel;
    private org.openswing.swing.client.NumericControl numericControl1;
    private org.openswing.swing.client.NumericControl numericControl2;
    private org.openswing.swing.client.NumericControl numericControl3;
    private org.openswing.swing.client.NumericControl numericControl4;
    private org.openswing.swing.client.NumericControl numericControl5;
    private org.openswing.swing.client.NumericControl numericControl6;
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
    private org.openswing.swing.client.TextControl textControl6;
    private org.openswing.swing.client.TextControl textControl7;
    private org.openswing.swing.client.TextControl textControl8;
    // End of variables declaration//GEN-END:variables
}
