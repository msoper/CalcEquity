/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiComp;

import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author Michael
 */
public class FButton extends JButton {
    public FButton(String str) {
        super(str);
        setPreferredSize(new Dimension(70,30));
        setMaximumSize(new Dimension(70,30));
        setMinimumSize(new Dimension(70,30));
    } 
    
}
