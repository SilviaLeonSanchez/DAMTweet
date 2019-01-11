/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.List;
import logica.ConexionTwitter;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.User;

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
        final String API_KEY =  "";
        final String API_KEY_SECRET = "";
        
        final String ACCESS_TOKEN =  "";
        final String ACCESS_TOKEN_SECRET =  "";

        
        // Abrir la conexion con la API de Twitter
        ConexionTwitter conexion = new ConexionTwitter(API_KEY, API_KEY_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET);
        
        
        // Pedir los datos del usuario (que seria nuestra cuenta de momento)
        User usuario = conexion.getUsuario();
        System.out.println("DATOS DEL USUARIO: ");
        conexion.verInfoUsuario(usuario);
        
        
        // Pedir el timeline del usuario (tweets enviados)
        List<Status> tweetsUsuario = conexion.getTweetsUsuario();
        
        System.out.println("TWEETS:");
        tweetsUsuario.forEach((tweet) -> {
            System.out.println(tweet.getText()+ "\n");
        });
        
        
        //  Enviar tweet
        String mensaje = "Hola mundo";
        //conexion.enviarTweet(mensaje);
        
        
    }
    
}
