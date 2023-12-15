/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfazGrafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author dgc06
 */
public class Thr extends Thread{

 
    public Thr(String str){
        super(str);
    }
    @Override
    public void run() {
       imagen l = new imagen();
       l.setContentPane(new JLabel(new ImageIcon("C:\\Users\\dgc06\\Documents\\NetBeansProjects\\validacionJava\\src\\main\\java\\images\\log.png")));
       l.setVisible(true);
      
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
