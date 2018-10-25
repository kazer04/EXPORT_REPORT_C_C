/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package toolkits;

/**
 *
 * @author Administrator
 */
public class UnThread extends Thread {
public void run() {
    long start = System.currentTimeMillis();
    // boucle tant que la durée de vie du Thread est < à 5 secondes
    while( System.currentTimeMillis() < ( start + (1000 * 5))) {
      // traitement
      System.out.println("Ligne affichée par le thread");
      try {
        // pause
        Thread.sleep(500);
      }
      catch (InterruptedException ex) {}
    }
  }

}
