/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.logging.Level;
import java.util.logging.Logger;
import logica.ConexionTwitter;
import twitter4j.Location;
import twitter4j.Trend;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author silvia
 */
public class PruebasTwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            ConexionTwitter conexion = new ConexionTwitter(true);

            Twitter twitter = conexion.getTwitter();

            int[] codigosWoeid = {753692, 754542, 764814, 766273, 766356, 768026, 769293, 774508, 776688, 779063};

            for (int i : codigosWoeid) {

                Location lugar = twitter.getPlaceTrends(i).getLocation();
                System.out.println("\nTRENDS: WOEID: "+lugar.getWoeid()+ " LUGAR: " + lugar.getName() );
                
                Trend[] trends = twitter.getPlaceTrends(i).getTrends();
                for (int j = 0; j < 10; j++) {
                    System.out.println("\t" + trends[j].getName() + ": " + trends[j].getTweetVolume() + " retweets");
                    
                }
                System.out.println();

            }

        } catch (TwitterException ex) {
            Logger.getLogger(PruebasTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
