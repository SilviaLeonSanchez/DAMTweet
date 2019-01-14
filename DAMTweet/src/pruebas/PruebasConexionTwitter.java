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
public class PruebasConexionTwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // PRUEBAS DE FUNCIONAMIENTO DE LA LIBRERIA TWITTER4J PARA CONECTAR CON LA API DE TWITTER
        
        
        // TOKEN DE CLIENTE (la aplicacion)
        final String API_KEY =  "";
        final String API_KEY_SECRET = "";
        
        // TOKEN DEL USUARIO 
        final String ACCESS_TOKEN =  "";
        final String ACCESS_TOKEN_SECRET =  "";

        
        
        // CONECTAR CON LA CUENTA DE TWITTER
        
        ConexionTwitter conexion = null;
        
        // Conectar con Twitter con la cuenta developer
        // conexion = new ConexionTwitter(API_KEY, API_KEY_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET);
        
        
        // Conectar con cualquier otro usuario (pide autenticacion)
        // conexion = new ConexionTwitter(API_KEY, API_KEY_SECRET);
        
        
        
        // ACCIONES DE TWITTER
        
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
