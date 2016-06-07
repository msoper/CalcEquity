/*
 * Main.java
 *
 * Created on May 31, 2007, 6:46 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package calcequity;
import java.awt.BorderLayout;
import sitEquity.EquityServer;
/**
 *
 * @author me
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EquityServer eqS = new EquityServer();
       // eqS.checkES();
    ManagerFrame man = new ManagerFrame();
       
          man.setVisible(true);
        
        
      //  System.out.println("sit  22504 = " + eqS.getScore(22514));
       //  System.out.println("sit  22505 = " + eqS.getScore(22515));
       //   System.out.println("sit  22504 = " + eqS.getDiff(22514,22515));
         
        
        // TODO code application logic here
    }
    
}
