/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserDetailFrames.java
 *
 * Created on 16 déc. 2010, 15:43:37
 */
package config_editor.ui.filedtt;

import bll.export_report_cc.ExportReportManager;
import config_editor.ui.dtt.*;
import config_editor.ui.ligneMaritimes.*;
import config_editor.security.File.*;
import static config_editor.ui.filedtt.FileDttFrameController.str_project_path_of_config;
import dal.TExportCcMontant;
import dal.TExportCcPoids;
import dal.TFile;
import dal.jconnexion;
import javax.swing.*;
import java.awt.*;
import static java.awt.image.ImageObserver.WIDTH;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.Serializable;
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
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
import toolkits.Main;
import toolkits.filesmanagers.FilesType.CsvFiles;
import toolkits.filesmanagers.FilesType.TxtFiles;
import toolkits.filesmanagers.FilesType.XlsFiles;
import toolkits.filesmanagers.FilesType.XmlFiles;
import toolkits.parameters.commonparameter;
import toolkits.security.Cryptages;
import toolkits.utils.StringUtils;
import toolkits.utils.conversion;
import toolkits.utils.date;
import toolkits.utils.jdom;
import toolkits.utils.logger;

/**
 *
 * @author Admin
 */
public class FileDttGridFrames extends org.openswing.swing.mdi.client.InternalFrame implements PropertyChangeListener {

    DefaultTableModel dtmMain = null;
    DefaultTableModel dtmjouranlVente = null;
    DefaultTableModel dtmcompteClient = null;
    DefaultTableModel dtmVendeur = null;
    DefaultTableModel dtmTicket = null;
    DefaultTableModel dtmTicketProduct = null;
    public java.util.List<TFile> lstDtt;
    Cryptages ocryptage = new Cryptages();
    int intSelect = -1;
    public TaskImportFile task;
    int nb_DTT;
    String str_REF;

    /**
     * Creates new form UserDetailFrames
     */
    public FileDttGridFrames() {
        initComponents();

        jProgressBar1 = new JProgressBar(0, 100);
        //  this.getJProgressBarLoadDtt().setMinimum(0);
        // this.getJProgressBarLoadDtt().setMaximum(20000);
        this.getJProgressBarLoadDtt().setValue(0);
        this.getJProgressBarLoadDtt().setStringPainted(true);
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

    public JProgressBar getJProgressBarLoadDtt() {
        return jProgressBar1;
    }

    ExportReportManager odttManager;

    public FileDttGridFrames(FormController dataController) {
        try {
            initComponents();
            jLabel20.setText("");
            jLabel21.setText("");
            jLabel26.setText("");
            mainPanel.setFormController(dataController);
            mainPanel.setSaveButton(saveButton);
            mainPanel.setEditButton(editButton);
            mainPanel.setReloadButton(reloadButton);
            reloadButton.doClick();
            XmlFiles OXmlFiles = new XmlFiles("config", jdom.path_of_config);
            new logger().OCategory.info(ocryptage.decryptage(OXmlFiles.FindField("APP_FOLDER_APP")));
            this.setTitle("FICHIER EXPORTATION " + ocryptage.decryptage(OXmlFiles.FindField("APP_FOLDER_APP")));
            jLabel20.setText("");
            jLabel21.setText("");
            jLabel26.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadDataTocomboBoxControl1(TFile ODtt) {
        /*   Domain oDomain = new Domain(ODtt.nameFile);
         new logger().OCategory.info(ODtt.lstProduct.size());
         oDomain.addDomainPair("0", "Article Dont le montant egale a 0");
         for (int i = 0; i < ODtt.lstProduct.size(); i++) {
         oDomain.addDomainPair(ODtt.lstProduct.get(i).StrRef, ODtt.lstProduct.get(i).strlibele + "   ( " + conversion.AmountFormat((ODtt.lstProduct.get(i).intAmount.intValue() * 100)) + " )");
         }
         comboBoxControl1.setDomain(oDomain);
         */
    }

    public void loadDataToCombo(ComboBoxControl ocomboBoxControl, TFile ODtt) {

        Domain oDomain = new Domain(ODtt.getStrRETURNDATA());
        /*
         new logger().OCategory.info(ODtt.lstProduct.size());
         for (int i = 0; i < ODtt.lstProduct.size(); i++) {
         //  String[] tabData = ODtt.lstProduct.get(i).split(commonparameter.SEPARATEUR_POINT_VIRGULE);
         oDomain.addDomainPair(ODtt.lstProduct.get(i).StrRef, ODtt.lstProduct.get(i).strlibele + "   ( " + conversion.AmountFormat(ODtt.lstProduct.get(i).intAmount.intValue()) + " )");
         }
         */
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
        jButton3 = new javax.swing.JButton();
        mainPanel = new org.openswing.swing.form.client.Form();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setTitle("Importation  de fichier");

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

        jButton3.setText("Importer un fichier ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        buttonsPanel.add(jButton3);

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

        jButton5.setText("Detail du fichier");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("DATE DTT");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("REF DTT");

        jLabel23.setText("Date du fichier");

        jLabel24.setText("Nom du fichier");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("LISTES DES FICHIERS  IMPORTES");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel25.setText("Nombre d'element");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("C.A DTT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25))
                        .addGap(62, 62, 62)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

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

            new logger().OCategory.info("fichier selecrtt " + selectedFile.getAbsolutePath());

            // Save the selected path
            pref.put("DEFAULT_PATH", selectedFile.getAbsolutePath());
            // DttFrameController.str_dtt_curent_path = selectedFile.getAbsolutePath();
            // System.out.println("Selected file: " + DttFrameController.str_dtt_curent_path);
            mainPanel.setSaveButton(saveButton);
            mainPanel.setEditButton(editButton);
            mainPanel.setReloadButton(reloadButton);

            try {
                jdom.InitRessource();
                jdom.LoadRessource();
            } catch (Exception e) {

                // e.printStackTrace();
                new logger().OCategory.info(e.getMessage());
                JOptionPane.showMessageDialog(null, "Le fichier de config est introuvable");

            }

            odttManager = new ExportReportManager();

            // reloadButton.doClick();
            // java.util.List<File> lst = odttManager.getListExportReportFile();
            this.getJProgressBarLoadDtt().setMinimum(0);
            this.getJProgressBarLoadDtt().setMaximum(0);
            this.getJProgressBarLoadDtt().setValue(0);
            this.getJProgressBarLoadDtt().setStringPainted(true);

            jButton3.setEnabled(false);
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            //Instances of javax.swing.SwingWorker are not reusuable, so
            //we create new instances as needed.
            task = new TaskImportFile(selectedFile);
            task.addPropertyChangeListener(this);
            task.execute();

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
    public void loadDttToTask() {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Instances of javax.swing.SwingWorker are not reusuable, s
        /* task = new Task();
         task.addPropertyChangeListener(this);
         task.execute();
         */
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new logger().OCategory.info(intSelect);
        if (intSelect == -1) {
            new logger().OCategory.info("Aucune ligne selectionner");
            OptionPane.showMessageDialog(
                    FileDttGridFrames.this,
                    "Vous devez selectionnez une ligne !",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        new config_editor.ui.dtt.DttFrameController("1", lstDtt.get(intSelect));


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        DefaultTableModel md = (DefaultTableModel) jTable1.getModel();
        intSelect = jTable1.getSelectedRow();
        populateDetailMainGrid(lstDtt.get(intSelect));


    }//GEN-LAST:event_jTable1MouseClicked

    public class Task extends SwingWorker<Void, Void> {

        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            // Random random = new Random();
            //int progress = 0;
            //Initialize progress property.
            setProgress(0);
            getJProgressBarLoadDtt().setValue(0);
            java.util.List<TFile> lst = odttManager.getTFile();
            setTitle("DTT  - Repertoire Dtt en cours " + ocryptage.decryptage(jdom.APP_NAME) + "  " + (0) + "/" + lst.size());
            odttManager.LstTFile = new ArrayList<TFile>();
            nb_DTT = lst.size();
            for (int i = 0; i < lst.size(); i++) {
                odttManager.loadAndStoreDataTExportCcPoids(lst.get(i));
                getJProgressBarLoadDtt().setValue(Math.min(i + 1, lst.size()));
                /*try {
                 Thread.sleep(1000);
                 } catch (InterruptedException e) {
                 }
                 */
                // num += 95;
                new logger().OCategory.info(lst.get(i).getStrPATH());
                setTitle("DTT  - Repertoire Dtt en cours " + ocryptage.decryptage(jdom.APP_NAME) + "  " + (i + 1) + "/" + lst.size());
                int percent = ((i + 1) / lst.size() * 100);
                new logger().OCategory.info(percent + " %");
                setProgress(Math.min(i + 1, lst.size()));
            }
            lstDtt = odttManager.LstTFile;
            if (lstDtt.size() > 0) {
                /*                new logger().OCategory.info(this.lstDtt.get(0).DATE_PRECEDENTE_RAZ);
                 config_editor.ui.dtt.DttVO vo = new config_editor.ui.dtt.DttVO();

                 vo.setDATE_PRECEDENTE_RAZ(this.lstDtt.get(0).DATE_PRECEDENTE_RAZ);
                 vo.setDATE_RAZ(this.lstDtt.get(0).DATE_RAZ);
                 vo.setREF_RAZ(this.lstDtt.get(0).REF_RAZ);
                 vo.setNameFile(this.lstDtt.get(0).nameFile);
                 this.populateMainGrid();
                 */
            }

            populateMainGrid();

            return null;
        }

        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();

            setCursor(null); //turn off the wait cursor
            jTextArea1.append("Terminé!\n");
            jButton3.setEnabled(true);
        }
    }

    public class TaskImportFile extends SwingWorker<Void, Void> {

        File OTFile;

        public TaskImportFile(File oTFile) {
            this.OTFile = oTFile;
        }

        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            // Random random = new Random();
            //int progress = 0;
            //Initialize progress property.

            setProgress(0);
            getJProgressBarLoadDtt().setValue(0);

            setTitle("Importation du fichier" + OTFile);
            odttManager.LstTFile = new ArrayList<TFile>();
            nb_DTT = 1;

            TFile OOTFile = odttManager.importFileNotProcess(OTFile);

            //int percent = ((i + 20) / lst.size() * 100);
            //setProgress(Math.min(i + 1, 100));
            // getJProgressBarLoadDtt().setValue(10);
            setTitle("Recuperation des donnees  du fichier " + OOTFile.getStrNAME());
            // java.util.List<TExportCcPoids> lst = odttManager.loadAndStoreDataTExportCcPoids(OOTFile);

            new logger().OCategory.info(OOTFile.getStrPATH());
            int int_sheet = 0;
            XlsFiles OXlsFiles = new XlsFiles();
            OXlsFiles.setPath_input(OOTFile.getStrPATH());
            OXlsFiles.setModel(new Main.testModel("", int_sheet));
            OXlsFiles.OIxlsModel.IxlsModelToString();
            java.util.List<String> lst = OXlsFiles.LoadDataToFiles();
            //getJProgressBarLoadDtt().setValue(20);

            getJProgressBarLoadDtt().setMaximum(lst.size());

            // getJProgressBarLoadDtt().setMinimum(0);
            /*getJProgressBarLoadDtt().setMaximum(0);
             getJProgressBarLoadDtt().setValue(0);
             getJProgressBarLoadDtt().setStringPainted(true);

             */
            setProgress(0);
            getJProgressBarLoadDtt().setValue(0);
            setTitle("Traitement des donnees (POIDS)du  fichier " + OOTFile.getStrNAME() + "    0/" + lst.size());
            java.util.List<TExportCcPoids> lstTExportCcPoids = new ArrayList<TExportCcPoids>();
            //  jconnexion Ojconnexion = new jconnexion();
            //  Ojconnexion.initConnexion();
            //  Ojconnexion.OpenConnexion();
            int entityCount = 50;
            int batchSize = lst.size();

            // EntityTransaction entityTransaction = odttManager.getOdataManager().getEm().getTransaction();
            try {
                // odttManager.getOdataManager().BeginTransaction();
                java.util.List<Serializable> LstTEMP = new ArrayList<Serializable>();
                for (int i = 1; i < lst.size(); i++) {
                    // new logger().OCategory.info(lst.get(i));
                    setTitle("1/2 Traitement des donnees (POIDS EXPORT) du  fichier " + OOTFile.getStrNAME() + "  " + i + "/" + (lst.size() - 1));
                    TExportCcPoids OTExportCcPoids = odttManager.getTExportCcPoidsToString(lst.get(i), OOTFile);
                    if (OTExportCcPoids != null) {

                        lstTExportCcPoids.add(OTExportCcPoids);
                        LstTEMP.add(OTExportCcPoids);
                        if (i > 1 && i % batchSize == 0) {
                            // odttManager.getOdataManager().CloseTransaction();
                            //.commit();
                            // entityTransaction.begin();
                            // odttManager.getOdataManager().BeginTransaction();
                            //odttManager.getOdataManager().getEm().clear();
                            new logger().OCategory.info("je vai inser'");
                        }

                        odttManager.store(OTExportCcPoids);
                        //entityManager.persist(OTExportCcPoids);
                    } else {
                        // this.buildErrorTraceMessage(lst.get(i));
                    }

                    //  getJProgressBarLoadDtt().setValue((i/lst.size())*100);
                    //  int percent = (i/lst.size())*100;
                    //  new logger().OCategory.info((i/lst.size())*100 + " %");
                    //  setProgress(Math.min(percent, 100));
                    getJProgressBarLoadDtt().setValue(Math.min(i + 1, lst.size()));
                    int percent = ((i + 1) / lst.size() * 100);
                    new logger().OCategory.info(percent + " %");
                    setProgress(Math.min(i + 1, 100));

                }

                //   odttManager.getOdataManager().CloseTransaction();
                odttManager.persiste(LstTEMP);

                //  entityTransaction.commit();
            } catch (RuntimeException e) {
                e.printStackTrace();
                if (odttManager.getOdataManager().getEm().getTransaction().isActive()) {
                    odttManager.getOdataManager().getEm().getTransaction().rollback();
                }
                throw e;
            } finally {
                odttManager.getOdataManager().getEm().close();
            }
            setProgress(0);
            getJProgressBarLoadDtt().setValue(0);
            int_sheet = 1;
            OXlsFiles = new XlsFiles();
            OXlsFiles.setPath_input(OOTFile.getStrPATH());
            OXlsFiles.setModel(new Main.testModel("", int_sheet));
            OXlsFiles.OIxlsModel.IxlsModelToString();
            lst = OXlsFiles.LoadDataToFiles();
            //getJProgressBarLoadDtt().setValue(20);
            setProgress(0);
            getJProgressBarLoadDtt().setValue(0);
            getJProgressBarLoadDtt().setMaximum(lst.size());

            setTitle("Traitement des donnees (MONTANT)du  fichier " + OOTFile.getStrNAME() + "    0/" + lst.size());
            java.util.List<TExportCcMontant> lstTExportCcMontant = new ArrayList<TExportCcMontant>();
            java.util.List<Serializable> LstTEMP = new ArrayList<Serializable>();
            odttManager.getOdataManager().initEntityManager();
            try {
                for (int i = 1; i < lst.size(); i++) {
                    // new logger().OCategory.info(lst.get(i));
                    setTitle("2/2 Traitement des donnees(MONTANT EXPORT) du  fichier " + OOTFile.getStrNAME() + "  " + i + "/" + (lst.size() - 1));
                    TExportCcMontant OTExportCcPoids = odttManager.getTExportCcMontantToString(lst.get(i), OOTFile);
                    if (OTExportCcPoids != null) {
                        odttManager.store(OTExportCcPoids);
                        lstTExportCcMontant.add(OTExportCcPoids);
                        LstTEMP.add(OTExportCcPoids);
                    } else {
                        // this.buildErrorTraceMessage(lst.get(i));
                    }

                //  getJProgressBarLoadDtt().setValue((i/lst.size())*100);
                    //  int percent = (i/lst.size())*100;
                    //  new logger().OCategory.info((i/lst.size())*100 + " %");
                    //  setProgress(Math.min(percent, 100));
                    getJProgressBarLoadDtt().setValue(Math.min(i + 1, lst.size()));
                    int percent = ((i + 1) / lst.size() * 100);
                    new logger().OCategory.info(percent + " %");
                    setProgress(Math.min(i + 1, 100));

                }
                 odttManager.persiste(LstTEMP);
            } catch (RuntimeException e) {
                e.printStackTrace();
                if (odttManager.getOdataManager().getEm().getTransaction().isActive()) {
                    odttManager.getOdataManager().getEm().getTransaction().rollback();
                }
                throw e;
            } finally {
                odttManager.getOdataManager().getEm().close();
            }

            OOTFile.setIntNBELEMENTS(lstTExportCcPoids.size());
            OOTFile.setStrSTATUT(odttManager.getOTranslate().getValue(commonparameter.statut_valide));

           
          //  odttManager.persiste(OOTFile);
            reloadButton.doClick();
            OptionPane.showMessageDialog(
                    FileDttGridFrames.this,
                    "Fichier " + OOTFile.getStrNAME() + " Traiter avec succes :  (" + (lstTExportCcPoids.size()) + ") Transactions",
                    "Sucess",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // OptionPane.
            populateMainGrid();
            return null;
        }

        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();

            setCursor(null); //turn off the wait cursor
            jTextArea1.append("Terminé!\n");
            jButton3.setEnabled(true);
        }
    }

    /**
     * Invoked when task's progress property changes.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            jProgressBar1.setValue(progress);
            String eee = " Ok  :)";
            // int pourcent =(progress /lstDtt.size())*100;
            jTextArea1.append(String.format(
                    "Ref Transaction " + task.getProgress() + eee + " \n", task.getProgress()));
        }
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

    public java.util.Date getDateOfDttFile(String Odate) {
        try {
            String[] strTabAll = Odate.split("_");
            String[] strTabItem = StringUtils.split(strTabAll[1], ".");
            String YY = strTabItem[0].substring(0, 4);
            String MM = strTabItem[0].substring(4, 6);
            String DD = strTabItem[0].substring(6, 8);
            //  return DD+"-"+MM+"-"+YY;
            return new date().stringToDate(YY + "-" + MM + "-" + DD, date.formatterMysqlShort);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new date().GetDateNow_Date();
    }

    public void populateMainGrid() {
        new logger().OCategory.info("Load data populateMainGrid " + lstDtt.size());

        dtmMain = new DefaultTableModel(0, 0);
        String header[] = new String[]{
            "Date.Importation Fichier",
            "Nom du fichier.Fichier",
            "Nombre.Elements",
            "Statut"
        };

        dtmMain.setColumnIdentifiers(header);
        //set model into the table object
        jTable1.setModel(dtmMain);
        jScrollPane1.setViewportView(jTable1);
        jLabel22.setText("LISTES DES FICHIERS  TROUVES (" + this.lstDtt.size() + ")");

        for (int i = 0; i < lstDtt.size(); i++) {

            dtmMain.addRow(new Object[]{
                date.DateToString(lstDtt.get(i).getDtCREATED(), date.NomadicUiFormat),
                lstDtt.get(i).getStrNAME(),
                lstDtt.get(i).getIntNBELEMENTS(),
                lstDtt.get(i).getStrSTATUT()
            }
            );
            // date.DateToString(lstDtt.get(i).getDtCREATED(), date.NomadicUiFormat) ,
        }

    }

    public void populateTicketGrid(final TFile ODtt) {
        /*     new logger().OCategory.info("Load data populateTicketGrid");
         dtmTicket = null;
         jTable5.clearSelection();

         dtmTicket = new DefaultTableModel(0, 0);
         jLabel2.setText("Liste des Tickets   " + ODtt.lstTicket.size() + " element(s)");
         String header[] = new String[]{
         "Ref.Ticket",
         "Lib.Ticket",
         "Quantite.Produit",
         "Prix.Total"
         };

         dtmTicket.setColumnIdentifiers(header);
         //set model into the table object

         try {
         jTable5.setModel(dtmTicket);
         jScrollPane5.setViewportView(jTable5);
         //   jTable5.setCellSelectionEnabled(true);
         //    ListSelectionModel cellSelectionModel = jTable5.getSelectionModel();
         //    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         } catch (Exception e) {
         e.printStackTrace();
         }*/
        /*
         jTable5.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

         public void valueChanged(ListSelectionEvent event) {
         // do some actions here, for example
         // print first column value from selected row

         Ticket OTicket = ODtt.lstTicket.get(jTable5.getSelectedRow());
         populateProductTicketGrid(OTicket);
         System.out.println(jTable5.getValueAt(jTable5.getSelectedRow(), 0).toString());

         }
         });
         *//*
         for (int i = 0; i < ODtt.lstTicket.size(); i++) {

         dtmTicket.addRow(new Object[]{
         ODtt.lstTicket.get(i).StrRef,
         ODtt.lstTicket.get(i).strlibele,
         (ODtt.lstTicket.get(i).intQuantity * 1),
         (ODtt.lstTicket.get(i).intAmount * 100)
         }
         );

         }
         */

    }

    public void refreshTicketGrid(final TFile ODtt) {
        new logger().OCategory.info("Load data refreshTicketGrid");
        /*      jTable6.clearSelection();
         dtmTicketProduct = (DefaultTableModel) jTable6.getModel();
         dtmTicketProduct.setNumRows(0);
         jLabel2.setText("Liste des Tickets   " + ODtt.lstTicket.size() + " element(s)");
         jTable5.clearSelection();

         dtmTicket = (DefaultTableModel) jTable5.getModel();
         dtmTicket.setNumRows(0);
         for (int i = 0; i < ODtt.lstTicket.size(); i++) {

         dtmTicket.addRow(new Object[]{
         ODtt.lstTicket.get(i).StrRef,
         ODtt.lstTicket.get(i).strlibele,
         (ODtt.lstTicket.get(i).intQuantity * 1),
         (ODtt.lstTicket.get(i).intAmount * 100)
         }
         );

         }
         jTable5.setModel(dtmTicket);
         dtmTicket.fireTableDataChanged();
         */
    }

    final public void populateDetailMainGrid(TFile ODtt) {
        new logger().OCategory.info("Load data populateDetailMainGrid");
        jLabel20.setText(date.DateToString(ODtt.getDtCREATED(), date.formatterMysql));
        jLabel21.setText(ODtt.getStrNAME());
        jLabel26.setText(ODtt.getIntNBELEMENTS() + "");

    }

    final public void populateProductTicketGrid(Object OTicket) {
        new logger().OCategory.info("Load data populateProductTicketGrid");
        /*
         jLabel4.setText(conversion.AmountFormat(OTicket.intAmount.intValue() * 100) + "  CFA");

         if (OTicket.lstRtransaction.size() > 0) {
         jLabel5.setText((OTicket.lstRtransaction.get(0).strlibele));
         jLabel6.setText(conversion.AmountFormat(OTicket.lstRtransaction.get(0).intAmount.intValue() * 100) + "  CFA");
         }
         if (OTicket.lstRtransaction.size() > 1) {
         jLabel8.setText((OTicket.lstRtransaction.get(1).strlibele));
         jLabel7.setText(conversion.AmountFormat(OTicket.lstRtransaction.get(1).intAmount.intValue() * 100) + "  CFA");
         }

         if (OTicket.lstCtransaction.size() > 0) {
         jLabel12.setText((OTicket.lstCtransaction.get(0).strlibele));
         jLabel11.setText(conversion.AmountFormat(OTicket.lstCtransaction.get(0).intAmount.intValue() * 100) + "  CFA");
         }

         if (OTicket.lstCtransaction.size() > 1) {
         jLabel14.setText((OTicket.lstCtransaction.get(1).strlibele));
         jLabel13.setText(conversion.AmountFormat(OTicket.lstCtransaction.get(1).intAmount.intValue() * 100) + "  CFA");
         }
         if (OTicket.lstCtransaction.size() > 2) {
         jLabel16.setText((OTicket.lstCtransaction.get(2).strlibele));
         jLabel15.setText(conversion.AmountFormat(OTicket.lstCtransaction.get(2).intAmount.intValue() * 100) + "  CFA");
         }

         dtmTicketProduct = new DefaultTableModel(0, 0);
         String header[] = new String[]{
         "Ref.Article",
         "Lib.Article",
         "Quantite",
         "Prix.Total"
         };

         dtmTicketProduct.setColumnIdentifiers(header);
         //set model into the table object
         jTable6.setModel(dtmTicketProduct);
         jScrollPane6.setViewportView(jTable6);

         for (int i = 0; i < OTicket.lstProduct.size(); i++) {

         dtmTicketProduct.addRow(new Object[]{
         OTicket.lstProduct.get(i).StrRef,
         OTicket.lstProduct.get(i).strlibele,
         (OTicket.lstProduct.get(i).intQuantity.intValue() * 1),
         (OTicket.lstProduct.get(i).intAmount.intValue() * 100)
         }
         );

         }
         */
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    private org.openswing.swing.client.EditButton editButton;
    private org.openswing.swing.client.ExportButton exportButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private org.openswing.swing.form.client.Form mainPanel;
    private org.openswing.swing.client.ReloadButton reloadButton;
    private org.openswing.swing.client.SaveButton saveButton;
    // End of variables declaration//GEN-END:variables
}
