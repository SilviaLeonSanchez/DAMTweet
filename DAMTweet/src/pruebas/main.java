/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.List;
import logica.ConexionTwitter;
import twitter4j.*;

/**
 *
 * @author silvia
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // PRUEBAS DE FUNCIONAMIENTO DE LA LIBRERIA TWITTER4J PARA CONECTAR CON LA API DE TWITTER
        
        // No subir al repositorio los token de acceso a la API, pueden banearnos la cuenta!!
        
        // TOKEN DE CLIENTE (Será el que pidamos al usuario final)
        final String API_KEY =  "krMk9AbjMVeQTcIJ4rVukgLih";
        final String API_KEY_SECRET = "Bp86NiJ2ZMPOYz3lG2FuOzEx4OHv8i0xB7XLBk0rajtHW5PRIb";
        
        final String ACCESS_TOKEN =  "1083755027276197889-R2RzgsJGLaMpmcN4aHb3Pih1GXZZGX";
        final String ACCESS_TOKEN_SECRET =  "2n36KLIFqovONusbX0vtU6pw8U3gdLWlDR09EQlTkzB12";


        
        // Abrir la conexion con la API de Twitter
        ConexionTwitter conexion = new ConexionTwitter(API_KEY, API_KEY_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET);
        
        
        // Pedir los datos del usuario (que seria nuestra cuenta de momento)
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
