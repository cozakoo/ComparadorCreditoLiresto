/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfazGrafica;

import java.io.File;

/**
 *
 * @author dgc06
 */
public class Filter extends javax.swing.filechooser.FileFilter{
    /*    publicFilter() {
    }*/
    private String extension;
    /*    @Override*/
    public Filter(String extension){
        this.extension = extension;
    }
    public boolean accept(File f) {
        return (f.isDirectory() || f.getAbsolutePath().endsWith(extension)); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDescription() {
        return "Text documents (*.txt)"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
