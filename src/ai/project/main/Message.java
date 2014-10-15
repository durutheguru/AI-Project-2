/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ai.project.main;


import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Duru Dumebi Julian
 */
public class Message {
    
    public static void show(String msg){
        show(null, msg);
    }
    
    public static void show(Component c, String msg){
        JOptionPane.showMessageDialog(c, msg);
    }
    
    public static String showInput(String msg){
        return showInput(null, msg);
    }
    
    public static String showInput(Component c, String msg){
        return JOptionPane.showInputDialog(c, msg);
    }
    
}
