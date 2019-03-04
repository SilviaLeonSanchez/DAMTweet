/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dto.Tweet;
import dto.UsuarioTwitter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.PagableResponseList;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

/**
 *
 * @author silvia
 */
public class GestionTwitter {

    private Twitter twitter;

    public Twitter getTwitter() {
        return twitter;
    }

    public GestionTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    public User getUsuario() {
        try {
            return this.twitter.showUser(twitter.getScreenName());
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void verInfoUsuario(User usuario) {
        System.out.println("Nombre: " + usuario.getName());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("Descripcion: " + usuario.getDescription());
        System.out.println("Fecha de creacion: " + new SimpleDateFormat("dd-MM-yyyy").format(usuario.getCreatedAt()) + "\n");
    }

    public List<Status> getTweetsUsuario() {
        try {
            return this.twitter.getUserTimeline();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Status> getTweetsUsuario(User usuario) {
        try {
            return this.twitter.getUserTimeline(usuario.getId());
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Status> getUltimosTweetsUsuariosSeguidos() {
        try {
            return this.twitter.getHomeTimeline();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void enviarTweet(String textoTweet) {
        try {
            Status tweet = twitter.updateStatus(textoTweet);
        } catch (TwitterException ex) {
            Logger.getLogger(ConexionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void retwitearTweet(Status tweet) {
        try {
            Status retwittedTweet = twitter.retweetStatus(tweet.getId());
        } catch (TwitterException ex) {
            Logger.getLogger(ConexionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> getSeguidores(long idUsuario) {
        PagableResponseList<User> seguidores = null;

        try {
            seguidores = twitter.getFollowersList(idUsuario, -1);
        } catch (TwitterException ex) {
            Logger.getLogger(ConexionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return seguidores;
    }

    public List<User> getSeguidos(long idUsuario) {
        PagableResponseList<User> seguidos = null;

        try {
            seguidos = twitter.getFriendsList(idUsuario, -1);
        } catch (TwitterException ex) {
            Logger.getLogger(ConexionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return seguidos;
    }

    /**
     * Realiza una busqueda standar tanto de texto como de hastags
     *
     * @param stringQuery
     * @return lista de tweets List<Status>
     */
    public List<Status> buscarTweets(String stringQuery) {
        try {
            Query busqueda = new Query(stringQuery);
            QueryResult result = twitter.search(busqueda);
            return result.getTweets();
        } catch (TwitterException te) {
            System.out.println("Fallo al buscar tweets: " + te.getMessage());
            System.exit(-1);
        }
        return null;
    }

    /**
     * Realiza una busqueda de usuarios simple.
     *
     * @param username el nombre del usuario a busca
     * @param numPaginas el numero de paginas de usuarios a recoger(minimo 1
     * pagina)
     * @return List<User> lista con los usuarios que coinciden con la busquedas
     */
    public List<User> buscarUsuarios(String username, int numPaginas) {
        ResponseList<User> usuarios = null;
        int page = 1;
        try {
            do {
                usuarios = twitter.searchUsers(username, 1);
                page++;
            } while (usuarios.size() != 0 && page < numPaginas);

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Error al buscar usuario: " + te.getMessage());
            System.exit(-1);
        }
        return usuarios;
    }

    public List<User> buscarUsuariosPublicos(String username) {
        List<User> usuarios = new ArrayList<>();
        try {

            for (User usuario : twitter.searchUsers(username, 1)) {
                // Solo añade los usuarios cuyos tweets estan accesibles
                if (usuario != null) {
                    if (usuario.getStatus() != null) {
                        usuarios.add(usuario);
                    }
                }
            }
        } catch (TwitterException te) {
            System.out.println("Error al buscar usuario: " + te.getMessage());
            System.exit(-1);
        }
        return usuarios;
    }

    public User buscarUsuarioPublico(String username) {
        try {

            for (User usuario : twitter.searchUsers(username, 1)) {
                if (usuario != null) {
                    if (usuario.getStatus() != null) {
                        return usuario;
                    }
                }
            }
        } catch (TwitterException te) {
            System.out.println("Error al buscar usuario: " + te.getMessage());
            System.exit(-1);
        }
        return null;
    }

    public Trend[] getTrendingTopics(int woeid) {
        Trend[] tt = null;
        try {
            tt = twitter.getPlaceTrends(woeid).getTrends();
        } catch (TwitterException ex) {
            Logger.getLogger(GestionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tt;
    }

    public String getLugarTrendingTopic(int woeid) {
        String lugar = null;
        try {
            lugar = twitter.getPlaceTrends(woeid).getLocation().getName();
        } catch (TwitterException ex) {
            Logger.getLogger(GestionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lugar;
    }

    public int getTotalRetweetTT(Trend t) {
        return t.getTweetVolume();
    }

    public String getTrendingTopic(Trend t) {
        return t.getName();
    }

    public ArrayList<UsuarioTwitter> getSeguidosInforme() {
        ArrayList<UsuarioTwitter> seguidos = new ArrayList<>();
        for (User seguido : getSeguidos(getUsuario().getId())) {
            seguidos.add(new UsuarioTwitter(seguido));
        }
        return seguidos;
    }

    public ArrayList<UsuarioTwitter> getSeguidoresInforme() {
        ArrayList<UsuarioTwitter> seguidores = new ArrayList<>();
        for (User seguidor : getSeguidores(getUsuario().getId())) {
            seguidores.add(new UsuarioTwitter(seguidor));
        }
        return seguidores;
    }

    public ArrayList<Tweet> getTweetsInforme(User usuario) {
        ArrayList<Tweet> tweets = new ArrayList<>();
        for (Status tweet : getTweetsUsuario(usuario)) {
            tweets.add(new Tweet(tweet));
        }
        return tweets;
    }
    

    public void darFavorito(long idTweet) {
        try {
            this.twitter.favorites().createFavorite(idTweet);
        } catch (TwitterException ex) {
            System.out.println("Error al dar like");
        }
    }
    
    public void quitarFavorito(long idTweet) {
        try {
            this.twitter.favorites().destroyFavorite(idTweet);
        } catch (TwitterException ex) {
            System.out.println("Error al quitar like");
        }
    }
    
}
