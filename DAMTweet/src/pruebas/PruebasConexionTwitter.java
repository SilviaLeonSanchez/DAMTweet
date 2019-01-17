/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.List;
import java.util.Scanner;
import logica.ConexionTwitter;
import twitter4j.*;

/**
 *
 * @author silvia
 */
public class PruebasConexionTwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // PRUEBAS DE FUNCIONAMIENTO DE LA LIBRERIA TWITTER4J PARA CONECTAR CON LA API DE TWITTER
        
         // PRUEBAS DE FUNCIONAMIENTO DE LA LIBRERIA TWITTER4J PARA CONECTAR CON LA API DE TWITTER
        
        Boolean logearseConCuentaDeveloeper = false;
             
        
        
        // CONECTAR CON LA CUENTA DE TWITTER
        ConexionTwitter conexion = null;
        
        conexion = new ConexionTwitter(false);
        
        
        // ACCIONES DE TWITTER
        
        // Pedir los datos del usuario (que seria nuestra cuenta de momento)
         // conexion.autenticacionUsuario();
        
        
        
        
        User usuario = conexion.getUsuario();
        System.out.println("DATOS DEL USUARIO:");
        conexion.verInfoUsuario(usuario);
        
        
        // Pedir el timeline del usuario (tweets enviados)
        List<Status> tweetsUsuario = conexion.getTweetsUsuario();
        
        System.out.println("TWEETS:");
        tweetsUsuario.forEach((tweet) -> {
            System.out.println(tweet.getText()+ "\n");
        });
        
        
        //  Enviar tweet
        String mensaje = "Hola mundo";
        // conexion.enviarTweet(mensaje);
        
        
        // Pedir los ultimos tweets
        List<Status> tweetsUsuariosSeguidos = conexion.getUltimosTweetsUsuariosSeguidos();
        Status retwittedTweet = null;
        
        System.out.println("TWEETS USUARIOS SEGUIDOS:");
        for (Status tweet : tweetsUsuariosSeguidos) {
             System.out.println(tweet.getUser().getName()+ ": "+tweet.getText());
             retwittedTweet = tweet;
        }
        System.out.println();
        
        
        // Retwitear
        // conexion.retwitearTweet(retwittedTweet);
        
        
        // Ver seguidores
        List<User> seguidores = conexion.getSeguidores();
        System.out.println("SEGUIDORES:");
        for (User seguidor : seguidores) {
            System.out.println("Nombre: "+ seguidor.getName());
        }
        
        
        
        
        
        
    }
    
}
