/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informes;

import java.util.Date;
import twitter4j.Status;

/**
 *
 * @author silvia
 */
public class Tweet {
    
    private final long id;
    private final Date fecha;
    private final String idioma;
    private final String texto;
    private final String twiteadoPor;
    private final String esFavorito;
    
    private final int totalFavoritos;
    private final int totalRetweets;
    private final String enRespuestaAUsuario;

    public Tweet(Status tweet) {
        this.fecha = tweet.getCreatedAt();
        this.totalFavoritos = tweet.getFavoriteCount();
        this.id = tweet.getId();
        this.enRespuestaAUsuario = tweet.getInReplyToScreenName();
        this.idioma = tweet.getLang();
        this.totalRetweets = tweet.getRetweetCount();
        this.texto = tweet.getText();
        this.twiteadoPor = "@"+tweet.getUser().getScreenName();
        this.esFavorito = (tweet.isFavorited()? "Si":"No");
    }

    public long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getTexto() {
        return texto;
    }

    public String getTwiteadoPor() {
        return twiteadoPor;
    }

    public String getEsFavorito() {
        return esFavorito;
    }

    public int getTotalFavoritos() {
        return totalFavoritos;
    }

    public int getTotalRetweets() {
        return totalRetweets;
    }

    public String getEnRespuestaAUsuario() {
        return enRespuestaAUsuario;
    }
    
    
    
    
}
