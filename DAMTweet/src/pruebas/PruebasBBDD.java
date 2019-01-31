/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import utils.bbdd.GestorBBDD_SQLite;
import static ventanas.PantallaLogin.RUTA_BBDD;

/**
 *
 * @author silvia
 */
public class PruebasBBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File paquete_bbdd = new File("bbdd" + File.separator + "twitter.sqlite3");
        
        RUTA_BBDD = paquete_bbdd.getAbsolutePath();
        if (!paquete_bbdd.exists()) {
            new File(File.separator + "bbdd").mkdir();
        }

        GestorBBDD_SQLite bbdd = new GestorBBDD_SQLite(RUTA_BBDD);

        HashMap<String, Integer> woeidTrendingTopic = bbdd.getWoeidTrendingTopic();

        for (Map.Entry<String, Integer> entry : woeidTrendingTopic.entrySet()) {
            System.out.println(entry.getValue() + "\t" + entry.getKey());
        }
        

    }

}
