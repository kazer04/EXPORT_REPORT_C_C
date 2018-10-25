/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkits.exec;

import java.io.IOException;
import toolkits.filesmanagers.FilesType.ExecutableFiles;
import toolkits.utils.logger;

/**
 *
 * @author Administrator
 */
public class executableManager {

    public executableManager() {
      
    }

    public void run(ExecutableFiles OExecutableFiles) {
        try {
            Process proc = Runtime.getRuntime().exec("C:/BACKUP.BAT");
          //  Runtime.getRuntime().getRuntime().

             //proc.
            // proc.destroy();
            //exitValue();
        } catch (IOException e) {
            new logger().OCategory.error(e.getMessage());
        }

    }
}
