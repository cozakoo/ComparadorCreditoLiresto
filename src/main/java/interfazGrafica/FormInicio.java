/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfazGrafica;

import com.mycompany.ministerio.comparacion.CsvLiresto;
import com.mycompany.ministerio.comparacion.DataBase;
import com.mycompany.ministerio.comparacion.Excel;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author dgc06
 */
public class FormInicio extends javax.swing.JFrame {

    /**
     * Creates new form FormInicio
     */
    boolean lirestoCargado = false;
    boolean creditoCargado = false;
    DataBase db = null;

    public FormInicio(DataBase db) {
        initComponents();
        this.db = db;
        loadingLiresto.setVisible(false);
        loadingCredito.setVisible(false);
        checkCredito.setVisible(false);
        checkLiresto.setVisible(false);
        cargarImagenes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        importarCredito = new javax.swing.JLabel();
        importarLiresto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        loadingCredito = new javax.swing.JLabel();
        loadingLiresto = new javax.swing.JLabel();
        checkCredito = new javax.swing.JLabel();
        checkLiresto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DE COMPUTOS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 140, 30));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DIRECCION GENERAL ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 200, 30));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel6.setText("BIENVENIDOS");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 90, 190, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\dgc06\\Documents\\nuevo repo\\control_transacciones\\Images\\city.png")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 0, 267, -1));

        importarCredito.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        importarCredito.setText("IMPORTAR CREDITO");
        importarCredito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importarCreditoMouseClicked(evt);
            }
        });
        jPanel1.add(importarCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 225, -1, -1));

        importarLiresto.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        importarLiresto.setText("IMPORTAR LIRESTO");
        importarLiresto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importarLirestoMouseClicked(evt);
            }
        });
        jPanel1.add(importarLiresto, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 225, -1, -1));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INICIAR");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.setBorderPainted(false);
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 100, 40));
        jButton1.getAccessibleContext().setAccessibleParent(jButton1);

        loadingCredito.setName("loadingCredito"); // NOI18N
        jPanel1.add(loadingCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 120, 100));

        loadingLiresto.setText("jLabel3");
        loadingLiresto.setName("loadingLiresto"); // NOI18N
        jPanel1.add(loadingLiresto, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));
        jPanel1.add(checkCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));
        jPanel1.add(checkLiresto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Menu m = new Menu(db);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cargarImagenes() {
        String dirActual = System.getProperty("user.dir");

        //icon CREDITOS 
        importarCredito.setIcon(new javax.swing.ImageIcon(dirActual + "\\images\\importar.png"));
        loadingCredito.setIcon(new javax.swing.ImageIcon(dirActual + "\\images\\loading_boton_1.gif"));
        checkCredito.setIcon(new javax.swing.ImageIcon(dirActual + "\\images\\check.png"));

        //icon LIRESTO
        importarLiresto.setIcon(new javax.swing.ImageIcon(dirActual + "\\images\\importar.png"));
        loadingLiresto.setIcon(new javax.swing.ImageIcon(dirActual + "\\images\\loading_boton_1.gif"));
        checkLiresto.setIcon(new javax.swing.ImageIcon(dirActual + "\\images\\check.png"));

        jLabel1.setIcon(new javax.swing.ImageIcon(dirActual + "\\images\\city.png"));
    }

    private void importarCreditoMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        if (importarCredito.isEnabled()) {
            FormInicio m = this;
            new Thread() {
                @Override
                public void run() {

                    javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                    // Crea un filtro para archivos de Excel
                    FileFilter excelFilter = new FileNameExtensionFilter("Archivos de Excel", "xls", "xlsx");
                    fileChooser.addChoosableFileFilter(excelFilter);

                    // Deshabilita la opción "Todos los archivos"
                    fileChooser.setAcceptAllFileFilterUsed(false);
                    m.setVisible(false);

//        fileChooser.setComponentZOrder(this, 2);
                    // Abre el cuadro de diálogo para seleccionar un archivo
                    int returnValue = fileChooser.showOpenDialog(null);

                    // Verifica si se seleccionó un archivo
                    if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {
                        m.setVisible(true);
                        File selectedFile = fileChooser.getSelectedFile();
                        String ruta = selectedFile.getAbsolutePath();
                        String nombre = selectedFile.getName();
                        Excel credito = new Excel(ruta, nombre);

                        try {
                            importarCredito.setEnabled(false);
                            loadingCredito.setVisible(true);
                            while (db.estaEnUso()) {
                                  this.sleep(10000);
                            }
                            System.out.println("pase soy cred");
                            db.setEstaEnUso(true);

                            db.importarExcelCredito(credito);
                            db.setEstaEnUso(false);
                            importarCredito.setEnabled(false);
                            loadingCredito.setVisible(false);
                            checkCredito.setVisible(true);
                            m.setVisible(true);
                            if (!importarLiresto.isEnabled()) {
                                jButton1.setEnabled(true);
                            }
                            importarCredito.setEnabled(false);
                        } catch (Exception ex) {

                            if (ex instanceof java.io.FileNotFoundException) {
                                new Notificacion("Cierre Excel").setVisible(true);
                            } else {
                                new Notificacion("Excel invalido").setVisible(true);
                            }
                            loadingCredito.setVisible(false);
                            db.setEstaEnUso(false);
                            importarCredito.setEnabled(true);
                            // Logger.getLogger(FormInicio.class.getName()).log(Level.SEVERE, null, ex);

                        }
                    } else {
                        m.setVisible(true);
                        System.out.println("No se seleccionó ningún archivo.");
                    }
                }
            }.start();
        }
    }

    private void importarLirestoMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:

        //hilo
        if (importarLiresto.isEnabled()) {
            FormInicio m = this;
            new Thread() {

                @Override
                public void run() {
                    javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                    // Crea un filtro para archivos de Csv
                    FileFilter csvFilter = new FileNameExtensionFilter("Archivos de CSV", "csv", "csv");
                    fileChooser.addChoosableFileFilter(csvFilter);

                    // Deshabilita la opción "Todos los archivos"
                    fileChooser.setAcceptAllFileFilterUsed(false);
                    m.setVisible(false);

//        fileChooser.setComponentZOrder(this, 2);
                    // Abre el cuadro de diálogo para seleccionar un archivo
                    int returnValue = fileChooser.showOpenDialog(null);

                    // Verifica si se seleccionó un archivo
                    if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {

                        try {
                            importarLiresto.setEnabled(false);
                            m.setVisible(true);
                            File selectedFile = fileChooser.getSelectedFile();
                            String ruta = selectedFile.getAbsolutePath();
                            String nombre = selectedFile.getName();

                            CsvLiresto liresto;
                            liresto = new CsvLiresto(ruta, nombre);
                            loadingLiresto.setVisible(true);
                            while (db.estaEnUso()) {
                                try {
                                    this.sleep(10000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(FormInicio.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            System.out.println("pase");
                            db.setEstaEnUso(true);
                            db.importarLiresto(liresto);
                            db.setEstaEnUso(false);
                            loadingLiresto.setVisible(false);
                            checkLiresto.setVisible(true);
                            importarLiresto.setEnabled(
                                    false);
                            if (!importarCredito.isEnabled()) {
                                jButton1.setEnabled(true);
                            }
                        } catch (IOException | NumberFormatException ex) {

                            new Notificacion("Liresto invalido").setVisible(true);
                            loadingLiresto.setVisible(false);
                            db.setEstaEnUso(false);
                            importarLiresto.setEnabled(true);
                            Logger.getLogger(FormInicio.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (CsvException | SQLException ex) {
                            new Notificacion("Archivo Liresto invalido").setVisible(true);
                            importarLiresto.setEnabled(true);
                            Logger.getLogger(FormInicio.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        m.setVisible(true);
                    }

                }
            }.start();
            //hilo
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel checkCredito;
    javax.swing.JLabel checkLiresto;
    javax.swing.JLabel importarCredito;
    javax.swing.JLabel importarLiresto;
    javax.swing.JButton jButton1;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel loadingCredito;
    javax.swing.JLabel loadingLiresto;
    // End of variables declaration//GEN-END:variables
}
