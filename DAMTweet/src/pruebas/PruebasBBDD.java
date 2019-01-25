/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        String RUTA_BBDD = null;
        File paquete_bbdd = new File(File.separator + "bbdd" + File.separator + "twitter.sqlite3");

        if (paquete_bbdd.exists()){
            RUTA_BBDD = paquete_bbdd.getAbsolutePath();
        }
        
        GestorBBDD_SQLite bbdd = new GestorBBDD_SQLite(RUTA_BBDD);

        // CONSULTAR TABLA
        ResultSet resultado = bbdd.ejecutarSELECT("select * from LUGARES_TT where ciudad = 'Madrid'");
        try {
            while (resultado.next()) {
                System.out.println(resultado.getInt("woeid"));
            }
        } catch (SQLException ex) {
            bbdd.desconectarBBDD();
            Logger.getLogger(PruebasBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
