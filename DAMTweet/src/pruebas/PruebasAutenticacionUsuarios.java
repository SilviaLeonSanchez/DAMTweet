/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import logica.ConexionTwitter;
import twitter4j.User;

/**
 *
 * @author silvia
 */
public class PruebasAutenticacionUsuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TOKEN DE CLIENTE (la aplicacion)
        final String API_KEY =  "";
        final String API_KEY_SECRET = "";
        
        // Usamos el constructor que va a autenticar al usuario
        ConexionTwitter conexion = new ConexionTwitter(API_KEY, API_KEY_SECRET);
        
        User usuario = conexion.getUsuario();
        System.out.println("\nDATOS DEL USUARIO:");
        conexion.verInfoUsuario(usuario);
        
    }
    
}
