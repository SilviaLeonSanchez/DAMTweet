/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import dto.Tweet;
import informes.TwitterDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author silvia
 */
public class PruebasInformes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            ArrayList<Tweet> tweets = TwitterDataSource.getTweets();
            JRDataSource dataSource = new JRBeanCollectionDataSource(tweets);
            JasperPrint print = JasperFillManager.fillReport("archivos_informes/PruebaInformeTwitter.jasper", new HashMap(), dataSource);
            JasperExportManager.exportReportToPdfFile(print, "archivos_informes/PruebaInformeTwitter.pdf");
            
        } catch (JRException ex) {
            Logger.getLogger(PruebasInformes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
