/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sitEquity;

import calcequity.Main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


/**
 *
 * @author Michael
 */
public class EquityServer {
      static private HashMap <Integer,Double>sitScores;  
      final String resourcesPath = "/data/sitScores.csv";
    
    
      public EquityServer() {
           

          sitScores = new HashMap<Integer,Double>();
          String eData;
          String [] eqData;
          int sit;
          double score;
          try {
              InputStream fstream = Main.class.getResourceAsStream(resourcesPath);
            // FileInputStream fstream = new FileInputStream(ef);

                // Convert our input stream to a
                // DataInputStream
		BufferedReader in =  new BufferedReader(new InputStreamReader(fstream));
                                       

              // Continue to read lines while 
              // there are still some left to read
                 while (in.ready() )
		{
                    // Print file line to screen
                    eData = in.readLine(); 
                    eqData = eData.split(",");
                    sit = new Integer(eqData[0]);
                    score = new Double(eqData[1]);
                    if (!sitScores.containsKey(sit))
                       sitScores.put(sit,score);
                }
          } catch (Exception e)
      		{
                	System.out.println("File input error  " + e);
		}
      }
      
  
      
      static public double getScore(int sit ) {
          double val = 2.0;
       if (sitScores.containsKey(sit)) {
                 val = (Double)(sitScores.get(sit));
                }
       return val;
}
      static public double getDiff(int sit1, int sit2){
          double val = 2.0;
          if (sitScores.containsKey(sit1) && sitScores.containsKey(sit2)) {
                 val = (Double)(sitScores.get(sit2))- (Double)(sitScores.get(sit1));
                }
       return val;
      }
      
      public void checkES() {
         String adv1File = "checkES.csv";
         FileWriter a1File; //= new FileWriter(adv1File);
         BufferedWriter a1Out; //= new BufferedWriter(a1File);
     
         String walkBFile = "checkESWalk.csv";
         FileWriter wbFile; //= new FileWriter(walkBFile);
         BufferedWriter wbOut; //= new BufferedWriter(wbFile);
         try {
            a1File = new FileWriter(adv1File);
            a1Out = new BufferedWriter(a1File);
     
           // wbFile = new FileWriter(walkBFile);
           // wbOut = new BufferedWriter(wbFile);
            int sit = 0;
            int inn = 0;
            int half = 0;
            for (int i=0; i<9; i++) {
                inn = i+1;
                for (int j=0; j<15;j++) {
                    half = 0;
                    sit = 6000*i+3000*half+ 10*(43+j);
                    a1Out.write(inn+","+half+","+sit+","+(j-7));
                    for (int k=0; k<3;k++) {
                        for (int l= 0; l < 8; l++) {
                        
                           a1Out.write(","+getScore(sit+1000*k+l) );
                        }
                    }
                    a1Out.write('\n');
                    
                    half = 1;
                    sit = 6000*i+3000*half+ 10*(43+j);
                    a1Out.write(inn+","+half+","+sit+","+(j-7));
                    for (int k=0; k<3;k++) {
                        for (int l= 0; l < 8; l++) {
                        
                           a1Out.write(","+getScore(sit+1000*k+l) );
                        }
                    }
                    a1Out.write('\n');
                }
            }
            a1Out.flush();
           // wbOut.flush();
        } catch ( Exception e) 
        {
            System.out.println(e);
        }
    
          
      }
}
