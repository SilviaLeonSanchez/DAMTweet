/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import twitter4j.User;

/**
 *
 * @author silvia
 */
public class UsuarioTwitter {
    
    private long id;
    private String idUsuario;
    private String nombre;
    private Date fechaAlta;
    private String descripcion;
    private String email;
    private String localizacion;
    private String idioma;
    
    private int totalTweetsPublicados;
    private int totalSeguidores;
    private int totalFavoritos;
    private int totalAmigos;
    
    private URL fotoPerfil;
    private URL fotoPortada;
    
    private boolean esSeguidor;
    

    public UsuarioTwitter(User user) {
        inicializar(user);
    }
    
    public UsuarioTwitter(User user, boolean esSeguidor){
        inicializar(user);
        this.esSeguidor = esSeguidor;
    }
    
    public void inicializar(User user){
        this.id = user.getId();
        this.idUsuario = "@" + user.getScreenName();
        this.nombre = user.getName();
        this.fechaAlta = user.getCreatedAt();
        this.descripcion = user.getDescription();
        this.email = user.getEmail();
        this.totalTweetsPublicados = user.getStatusesCount();
        this.totalFavoritos = user.getFavouritesCount();
        this.totalSeguidores = user.getFollowersCount();
        this.totalAmigos = user.getFriendsCount();
        this.localizacion = user.getLocation();
        this.idioma = user.getLang();
        this.fotoPerfil = null;
        try {
            this.fotoPerfil = new URL(user.getProfileImageURL());
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
        this.fotoPortada = null;
        try {
            this.fotoPortada = new URL(user.getProfileBannerURL());
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean isEsSeguidor() {
        return esSeguidor;
    }

    public String getNombre() {
        return nombre;
    }

    public URL getFotoPortada() {
        return fotoPortada;
    }

    public URL getFotoPerfil() {
        return fotoPerfil;
    }

    public long getId() {
        return id;
    }

    public String getIdUsuario() {
        return idUsuario;
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
        return "Usuario{" + "id=" + id + ", nombre=" + idUsuario + ", fechaAlta=" + fechaAlta + ", descripcion=" + descripcion + ", email=" + email + ", localizacion=" + localizacion + ", idioma=" + idioma + ", totalTweetsPublicados=" + totalTweetsPublicados + ", totalSeguidores=" + totalSeguidores + ", totalFavoritos=" + totalFavoritos + ", totalAmigos=" + totalAmigos + '}';
    }
    
    
    
}
