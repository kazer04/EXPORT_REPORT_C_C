package config_editor.security;

import config_editor.common.clientFacade;
import config_editor.common.data;
import org.openswing.swing.tree.java.OpenSwingTreeNode;
import java.util.*;
import org.openswing.swing.mdi.client.*;
import org.openswing.swing.util.client.*;
import org.openswing.swing.permissions.client.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import org.openswing.swing.mdi.java.ApplicationFunction;
import multilangue.Translate;
import org.openswing.swing.domains.java.Domain;
import org.openswing.swing.internationalization.java.*;
import org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel;
import toolkits.utils.date;
import toolkits.utils.jdom;
import static toolkits.utils.jdom.path_of_config;
import toolkits.utils.logger;

/**
 * <p>
 * Title: OpenSwing clientFacade</p>
 * <p>
 * Description: Used to start application from main method: it creates an MDI
 * Frame app.</p>
 * <p>
 * Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p>
 * </p> @author Mauro Carniel
 *
 * @version 1.0
 */
public class ClientApplication implements MDIController, LoginController {

    public String loolenfeel = data.lookend_feel_Substance;
    private clientFacade clientFacade = null;
    private Hashtable domains = new Hashtable();
    private String username = null;
    JDialog j = null;

    public ClientApplication() {
        if (!InitConnection()) {
            stopApplication();
        }
//new SubstanceBusinessLookAndFeel();
        try {
            jdom.InitRessource();
            jdom.LoadRessource();
        } catch (Exception e) {

            // e.printStackTrace();
            new logger().OCategory.info(e.getMessage());
            JOptionPane.showMessageDialog(null, "Le fichier de config est introuvable ! il devrai se trouver a l'emplacement " + jdom.path_of_config);
            stopApplication();
        }
        clientFacade = new clientFacade();

        Hashtable xmlFiles = new Hashtable();
        xmlFiles.put("EN", "xml//Resources_en.xml");
        xmlFiles.put("IT", "xml//Resources_it.xml");
        xmlFiles.put("FR", "xml//Resources_fr.xml");
        ClientSettings clientSettings = new ClientSettings(new XMLResourcesFactory(xmlFiles, true), domains);
        ClientSettings.BACKGROUND = "background4.jpg";
        ClientSettings.TREE_BACK = "treeback2.jpg";
        ClientSettings.VIEW_BACKGROUND_SEL_COLOR = true;
        ClientSettings.VIEW_MANDATORY_SYMBOL = true;
        ClientSettings.ALLOW_OR_OPERATOR = false;
        ClientSettings.INCLUDE_IN_OPERATOR = false;
        ClientSettings.SHOW_SCROLLBARS_IN_MDI = true;
        //ClientSettings.IGNORE_GRID_SELECTION_FOREGROUND = true;
        LoginDialog d = new LoginDialog(null, false, this);
    }

    /**
     * Method called after MDI creation.
     */
    public void afterMDIcreation(MDIFrame frame) {
        GenericStatusPanel userPanel = new GenericStatusPanel();
        userPanel.setColumns(12);
        MDIFrame.addStatusComponent(userPanel);
        userPanel.setText(username);
        MDIFrame.addStatusComponent(new Clock());
    }

    /**
     * @see JFrame getExtendedState method
     */
    public int getExtendedState() {
        return JFrame.MAXIMIZED_BOTH;
    }

    /**
     * @return client facade, invoked by the MDI Frame tree/menu
     */
    public clientFacade getClientFacade() {
        return clientFacade;
    }

    /**
     * Method used to destroy application.
     */
    public void stopApplication() {
        System.exit(0);
    }

    /**
     * Defines if application functions must be viewed inside a tree panel of
     * MDI Frame.
     *
     * @return <code>true</code> if application functions must be viewed inside
     * a tree panel of MDI Frame, <code>false</code> no tree is viewed
     */
    public boolean viewFunctionsInTreePanel() {
        return true;
    }

    /**
     * Defines if application functions must be viewed in the menubar of MDI
     * Frame.
     *
     * @return <code>true</code> if application functions must be viewed in the
     * menubar of MDI Frame, <code>false</code> otherwise
     */
    public boolean viewFunctionsInMenuBar() {
        return true;
    }

    /**
     * @return <code>true</code> if the MDI frame must show a login menu in the
     * menubar, <code>false</code> no login menu item will be added
     */
    public boolean viewLoginInMenuBar() {
        return true;
    }

    /**
     * @return application title
     */
    public String getMDIFrameTitle() {
        return jdom.APP_NAME + " " + jdom.APP_VERSION;
    }

    /**
     * @return text to view in the about dialog window
     */
    public String getAboutText() {
        return "This is an Config Editor for " + jdom.APP_NAME + "\n"
                + "\n"
                + "Version :" + jdom.APP_VERSION + ""
                + "\n"
                + "Copyright: Copyright (C) 2011 " + jdom.CUSTOMER + "\n"
                + "Author: Infotronique";
    }

    /**
     * @return image name to view in the about dialog window
     */
    public String getAboutImage() {
        return "about.jpg";
    }

    /**
     * @param parentFrame parent frame
     * @return a dialog window to logon the application; the method can return
     * null if viewLoginInMenuBar returns false
     */
    public JDialog viewLoginDialog(JFrame parentFrame) {
        j = new LoginDialog(parentFrame, true, this);
        return j;
    }

    /**
     * @return maximum number of failed login
     */
    public int getMaxAttempts() {
        return 3;
    }

    /**
     * Method called by MDI Frame to authenticate the user.
     *
     * @param loginInfo login information, like username, password, ...
     * @return <code>true</code> if user is correcly authenticated,
     * <code>false</code> otherwise
     */
    public boolean authenticateUser(Map loginInfo) throws Exception {

        date key = new date();
        authentification Oauthentification = new authentification();

        if (Oauthentification.login((String) loginInfo.get("password"), (String) loginInfo.get("username"))) {
            return true;
        } else {
            JOptionPane.showMessageDialog(new JFrame(), Oauthentification.getDetailmessage(), "Réponse", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    /**
     * Method called by LoginDialog to notify the sucessful login.
     *
     * @param loginInfo login information, like username, password, ...
     */
    public void loginSuccessful(Map loginInfo) {
        username = loginInfo.get("username").toString().toUpperCase();
        ClientSettings.getInstance().setLanguage("FR");
        Domain orderStateDomain = new Domain("ORDERSTATE");
        orderStateDomain.addDomainPair("O", "opened");
        orderStateDomain.addDomainPair("S", "suspended");
        orderStateDomain.addDomainPair("D", "delivered");
        orderStateDomain.addDomainPair("ABC", "closed");
        domains.clear();
        domains.put(
                orderStateDomain.getDomainId(),
                orderStateDomain);

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(new BasicLookAndFeel() {

                        @Override
                        public String getName() {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public String getID() {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public String getDescription() {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public boolean isNativeLookAndFeel() {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public boolean isSupportedLookAndFeel() {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });
                } catch (Exception e) {
                    System.out.println("Substance Graphite failed to initialize");
                }

            }
        });

        MDIFrame mdi = new MDIFrame(ClientApplication.this);
        //  SwingUtilities.updateComponentTreeUI(mdi);

        // SwingUtilities.updateComponentTreeUI(mdi);
        mdi.repaint();

    }

    /**
     * @return <code>true</code> if the MDI frame must show a change language
     * menu in the menubar, <code>false</code> no change language menu item will
     * be added
     */
    public boolean viewChangeLanguageInMenuBar() {
        return true;
    }

    /**
     * @return list of languages supported by the application
     */
    public ArrayList getLanguages() {
        ArrayList list = new ArrayList();
        list.add(new Language("EN", "English"));
        list.add(new Language("IT", "Italiano"));
        list.add(new Language("FR", "Francais"));
        return list;
    }

    /**
     * @return application functions (ApplicationFunction objects), organized as
     * a tree
     */
    public DefaultTreeModel getApplicationFunctions() {
        DefaultMutableTreeNode root = new OpenSwingTreeNode();
        DefaultTreeModel model = new DefaultTreeModel(root);

        ApplicationFunction nGestion = new ApplicationFunction("Gestion", null, "APP");
        ApplicationFunction nFichier = new ApplicationFunction("Gestion des Fichier export", "GEST_FICHIER", null, "getFileDttFrameController");
        
        
        
        ApplicationFunction nConfig = new ApplicationFunction("Configuration", null, "APP");
        //  ApplicationFunction nFileConfigEditor = new ApplicationFunction("Fichier de config", "FILE_CONFIG", null, "getConfigFileFrame");
        ApplicationFunction nUser = new ApplicationFunction("Utilisateur", "UPDATE_USER", null, "getUserFrame");
        ApplicationFunction nConfigProject = new ApplicationFunction("Config Project", "CONFIG_PROJECT", null, "getConfigProjectFrame");
        ApplicationFunction nConfigFileProject = new ApplicationFunction("Config Fichier Project", "CONFIG_FILE_PROJECT", null, "getConfigFileProjectFrame");
        ApplicationFunction nAddNewComponent = new ApplicationFunction("Ajout de composant Project", "ADD_COMPONENT_PROJECT", null, "getAddNewComponentFrame");

        ApplicationFunction nFormulairePeseM1 = new ApplicationFunction("Formulaire de Pesee", "FORM_PESE_ELECTRONIQUE_M1", null, "getFormPeseElectroniqueM1");
        ApplicationFunction nFormulairePeseM2 = new ApplicationFunction("Formulaire de Pesee M2", "FORM_PESE_ELECTRONIQUE_M2", null, "getFormPeseElectroniqueM2");
        ApplicationFunction nFileDTT = new ApplicationFunction("Traitement Dossier DTT", "FORM_FILE_DTT", null, "getFileDttFrameController");

        ApplicationFunction nDTT = new ApplicationFunction("Traitement Fichier DTT", "FORM_DTT", null, "getDttFrameController");

        // nConfig.add(nFileConfigEditor);
        nConfig.add(nFileDTT);
        nConfig.add(nDTT);
        //  nConfig.add(nFormulairePeseM1);
        //  nConfig.add(nConfigProject);
        //  nConfig.add(nConfigFileProject);
        //  nConfig.add(nAddNewComponent);
        
         nGestion.add(nFichier);
        root.add(nGestion);
        
        nConfig.add(nUser);
        root.add(nConfig);
        
        
       
        
        //  root.add(nConcours);
        //  root.add(nDiscipline);
        //  root.add(nNotes);
        //  root.add(nSetting);

        return model;
    }

    /**
     * Create the database connection (using Hypersonic DB - in memory) and
     * initialize tables...
     */
    private boolean InitConnection() {
        try {
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Impossible de se connecter a la base de donnee", "Réponse", JOptionPane.ERROR_MESSAGE);

            return true;
        }
        return true;
    }

    /**
     * @return <code>true</code> if the MDI frame must show a panel in the
     * bottom, containing last opened window icons, <code>false</code> no panel
     * is showed
     */
    public boolean viewOpenedWindowIcons() {
        return true;
    }

    /**
     * @return <code>true</code> if the MDI frame must show the "File" menu in
     * the menubar of the frame, <code>false</code> to hide it
     */
    public boolean viewFileMenu() {
        return true;
    }
}
