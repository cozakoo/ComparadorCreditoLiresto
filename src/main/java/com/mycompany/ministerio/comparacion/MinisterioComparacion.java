package com.mycompany.ministerio.comparacion;

import interfazGrafica.FormInicio;
import interfazGrafica.SesionUsuario;
import java.sql.SQLException;

public class MinisterioComparacion {

    public static void main(String[] args) throws Exception {
        try {
            DataBase db = new DataBase();
            db.inicializar();
           
            if (!db.existeSesion()) {
                FormInicio f = new FormInicio(db);
                f.setVisible(true);
                db.cleanDataBase();
            } else {
                SesionUsuario sesion = new SesionUsuario(db);
                sesion.setVisible(true);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
