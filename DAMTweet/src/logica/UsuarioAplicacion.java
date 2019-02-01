/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author sebas
 */
public class UsuarioAplicacion {
    long id;
    String token;
    String nombre;
    String username;
    byte[] privateToken;

    public UsuarioAplicacion(long id, String nombre, String username, String token, byte[] privateToken) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.token = token;
        this.privateToken = privateToken;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public byte[] getPrivateToken() {
        return privateToken;
    }

    public void setPrivateToken(byte[] privateToken) {
        this.privateToken = privateToken;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }
    
    

}
