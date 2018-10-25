/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package config_editor;

import config_editor.security.ClientApplication;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel;
 
/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                //   UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());
                } catch (Exception e) {
                    System.out.println("Substance Graphite failed to initialize");
                }
                new ClientApplication();
            }
        });


    }
}
