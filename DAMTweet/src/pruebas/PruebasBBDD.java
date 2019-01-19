/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.bbdd.DAO;
import utils.bbdd.GestorBBDD_SQLite;

/**
 *
 * @author silvia
 */
public class PruebasBBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String ruta = "turuta"; // Ya hay una bbdd en el paquete bbdd, poner la ruta 
        String nombrebbdd = "twitter.sqlite3";

        GestorBBDD_SQLite bbdd = new GestorBBDD_SQLite(ruta, nombrebbdd);

        //  CREAR TABLA PARA TRENDING TOPICS
        String tabla = "lugaresTT";
        String woeid = "woeid";
        String ciudad = "ciudad";

        /*
        String sqlTablaTT = "CREATE TABLE IF NOT EXISTS " + tabla + " (\n"
        + "	" + woeid + " integer PRIMARY KEY,\n"
        + "	" + ciudad + " text NOT NULL\n"
        + ");";
        bbdd.ejecutar(sqlTablaTT);
        */

        // GESITIONAR INFORMACION BBDD
        DAO daoBBDD = new DAO(bbdd);

        // CONSULTAR TABLA
        ResultSet resultado = daoBBDD.ejecutarSELECT(tabla);
        try {
            while (resultado.next()) {
                System.out.println(resultado.getInt(woeid) + "\t"
                        + resultado.getString(ciudad));
            }
        } catch (SQLException ex) {
            bbdd.desconectarBBDD();
            Logger.getLogger(PruebasBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
