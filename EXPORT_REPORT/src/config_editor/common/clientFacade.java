package config_editor.common;

import config_editor.ui.dtt.DttFrameController;
import config_editor.security.File.FileEditorUpdateFrameController;
import config_editor.security.User.UserUpdateFrameController;
import config_editor.ui.filedtt.FileDttFrameController;
import config_editor.ui.ligneMaritimes.LigneMaritimesUpdateFrameControllerM1;
import config_editor.ui.ligneMaritimes.LigneMaritimesUpdateFrameControllerM2;
import config_editor.ui.ligneMaritimes.LigneMaritimesUpdateFrames;
import org.openswing.swing.mdi.client.*;
import java.sql.Connection;

/**
 * <p>
 * Title: OpenSwing Framework</p>
 * <p>
 * Description: Client Facade, called by the MDI Tree.</p>
 * <p>
 * Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p>
 * </p> @author Mauro Carniel
 *
 * @version 1.0
 */
public class clientFacade implements ClientFacade {

    public clientFacade() {
    }

    public void getF1() {
        // new GridFrameController(conn);
    }

    public void getF2() {
        InternalFrame f = new InternalFrame();
        f.setSize(300, 200);
        f.setTitle("Function2");
        MDIFrame.add(f);
    }

    public void getF3() {
        InternalFrame f = new InternalFrame();
        f.setSize(300, 200);
        f.setTitle("Function3");
        MDIFrame.add(f);
    }

    public void getF4() {
        InternalFrame f = new InternalFrame();
        f.setSize(300, 200);
        f.setTitle("Function4");
        MDIFrame.add(f);
    }

    public void getF5() {
        InternalFrame f = new InternalFrame();
        f.setSize(300, 200);
        f.setTitle("Function5");
        MDIFrame.add(f);
    }

    public void getF6() {
        InternalFrame f = new InternalFrame();
        f.setSize(300, 200);
        f.setTitle("Function6");
        MDIFrame.add(f);
    }

    public void getConfigFileFrame() {
        new FileEditorUpdateFrameController("1");
    }

    public void getUserFrame() {
        new UserUpdateFrameController("1");
    }

     

    public void getFormPeseElectroniqueM1() {
        new LigneMaritimesUpdateFrameControllerM1("1");
    }

    public void getFormPeseElectroniqueM2() {
        new LigneMaritimesUpdateFrameControllerM2("1");
    }
    
    public void getDttFrameController() {
        new DttFrameController("1");
    }
    
      public void getFileDttFrameController() {
        new FileDttFrameController("1");
    }

}
