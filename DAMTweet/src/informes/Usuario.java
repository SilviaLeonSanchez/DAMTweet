/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informes;

import java.util.Date;
import twitter4j.User;

/**
 *
 * @author silvia
 */
public class Usuario {
    
    private final long id;
    private final String nombre;
    private final Date fechaAlta;
    private final String descripcion;
    private final String email;
    private final String localizacion;
    private final String idioma;
    
    private final int totalTweetsPublicados;
    private final int totalSeguidores;
    private final int totalFavoritos;
    private final int totalAmigos;
    

    public Usuario(User user) {
        this.id = user.getId();
        this.nombre = "@" + user.getScreenName();
        this.fechaAlta = user.getCreatedAt();
        this.descripcion = user.getDescription();
        this.email = user.getEmail();
        this.totalTweetsPublicados = user.getStatusesCount();
        this.totalFavoritos = user.getFavouritesCount();
        this.totalSeguidores = user.getFollowersCount();
        this.totalAmigos = user.getFriendsCount();
        this.localizacion = user.getLocation();
        this.idioma = user.getLang();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEmail() {
        return email;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getTotalTweetsPublicados() {
        return totalTweetsPublicados;
    }

    public int getTotalSeguidores() {
        return totalSeguidores;
    }

    public int getTotalFavoritos() {
        return totalFavoritos;
    }

    public int getTotalAmigos() {
        return totalAmigos;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta + ", descripcion=" + descripcion + ", email=" + email + ", localizacion=" + localizacion + ", idioma=" + idioma + ", totalTweetsPublicados=" + totalTweetsPublicados + ", totalSeguidores=" + totalSeguidores + ", totalFavoritos=" + totalFavoritos + ", totalAmigos=" + totalAmigos + '}';
    }
    
    
    
}
