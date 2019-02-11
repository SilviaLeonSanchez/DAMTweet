/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import componentes.TrendingTopic;
import componentes.ComponenteTweet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import twitter4j.Status;
import twitter4j.Trend;
import static ventanas.PantallaLogin.BBDD;
import static ventanas.PantallaLogin.gestionTwitter;



/**
 *
 * @author alumnop
 */
public class PantallaPrincipal extends javax.swing.JDialog {
    
    
    private ArrayList<TrendingTopic> componentesTrendingTopic;
    private ArrayList<ComponenteTweet> componentesTweet;
    
    
    /**
     * Creates new form TwitterMain2
     */
    public PantallaPrincipal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        generarListasComponentes();
        inicializarTweets();
        this.componenteNuevoTweet.inicializarComponente();
        
        // MIENTRAS SE ENLAZA CON AJUSTES LLAMA A UNA LOCALIZACION CUALQUIERA
        HashMap<String, Integer> tt = BBDD.getWoeidTrendingTopic();
        String lugar = tt.keySet().iterator().next();
        inicializarTrendingTopics(lugar);   // Mantener este metodo
    }
    
    private void generarListasComponentes(){
        this.componentesTrendingTopic = new ArrayList<>();
        this.componentesTrendingTopic.add(trendingTopic1);
        this.componentesTrendingTopic.add(trendingTopic2);
        this.componentesTrendingTopic.add(trendingTopic3);
        this.componentesTrendingTopic.add(trendingTopic4);
        this.componentesTrendingTopic.add(trendingTopic5);
        this.componentesTrendingTopic.add(trendingTopic6);
        this.componentesTrendingTopic.add(trendingTopic7);
        this.componentesTrendingTopic.add(trendingTopic8);
        this.componentesTrendingTopic.add(trendingTopic9);
        this.componentesTrendingTopic.add(trendingTopic10);
        
        this.componentesTweet = new ArrayList<>();
        this.componentesTweet.add(tweet1);
        this.componentesTweet.add(tweet2);
        this.componentesTweet.add(tweet10);
        this.componentesTweet.add(tweet4);
        this.componentesTweet.add(tweet5);
        this.componentesTweet.add(tweet6);
        this.componentesTweet.add(tweet7);
        this.componentesTweet.add(tweet8);
        this.componentesTweet.add(tweet9);
        this.componentesTweet.add(tweet10);
    }
    
    private void inicializarTrendingTopics(String lugar) {
        HashMap<String, Integer> tt = BBDD.getWoeidTrendingTopic();
        int woeid = tt.get(lugar);
        
        this.jLabelLugarTrendingTopics.setText(lugar);
        Trend[] trendingTopics = gestionTwitter.getTrendingTopics(woeid);
        int i = 0;
        for (TrendingTopic componente : this.componentesTrendingTopic) {
            componente.inicializarComponente(trendingTopics[i]);
            i++;
        }
    }
    
    private void inicializarTweets(){
        List<Status> tweets = gestionTwitter.getUltimosTweetsUsuariosSeguidos();
        int i = 0;
        for (ComponenteTweet componente : componentesTweet) {
           componente.inicializarComponente(tweets.get(i));
           i++;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUsuario = new javax.swing.JLabel();
        jPanelTrendingTopics = new javax.swing.JPanel();
        trendingTopic1 = new componentes.TrendingTopic();
        trendingTopic2 = new componentes.TrendingTopic();
        trendingTopic3 = new componentes.TrendingTopic();
        trendingTopic4 = new componentes.TrendingTopic();
        trendingTopic5 = new componentes.TrendingTopic();
        trendingTopic6 = new componentes.TrendingTopic();
        trendingTopic7 = new componentes.TrendingTopic();
        trendingTopic8 = new componentes.TrendingTopic();
        trendingTopic9 = new componentes.TrendingTopic();
        trendingTopic10 = new componentes.TrendingTopic();
        jLabelTituloTrendingTopics = new javax.swing.JLabel();
        jLabelLugarTrendingTopics = new javax.swing.JLabel();
        jButtonAjustes = new javax.swing.JButton();
        Buscador = new componentes.Buscar();
        jScrollPaneTweets = new javax.swing.JScrollPane();
        jPanelTweets = new javax.swing.JPanel();
        tweet1 = new componentes.ComponenteTweet();
        tweet2 = new componentes.ComponenteTweet();
        tweet10 = new componentes.ComponenteTweet();
        tweet9 = new componentes.ComponenteTweet();
        tweet8 = new componentes.ComponenteTweet();
        tweet7 = new componentes.ComponenteTweet();
        tweet6 = new componentes.ComponenteTweet();
        tweet5 = new componentes.ComponenteTweet();
        tweet3 = new componentes.ComponenteTweet();
        tweet4 = new componentes.ComponenteTweet();
        componenteNuevoTweet = new componentes.NuevoTweet();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        jLabelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUsuario.setText("USUARIO ( Y SEGUIDORES )");

        jLabelTituloTrendingTopics.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabelTituloTrendingTopics.setText("Trending Topics");

        jLabelLugarTrendingTopics.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanelTrendingTopicsLayout = new javax.swing.GroupLayout(jPanelTrendingTopics);
        jPanelTrendingTopics.setLayout(jPanelTrendingTopicsLayout);
        jPanelTrendingTopicsLayout.setHorizontalGroup(
            jPanelTrendingTopicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrendingTopicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTrendingTopicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trendingTopic2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trendingTopic3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trendingTopic4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trendingTopic5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trendingTopic6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trendingTopic7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trendingTopic8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trendingTopic9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trendingTopic10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelTrendingTopicsLayout.createSequentialGroup()
                        .addComponent(jLabelTituloTrendingTopics, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jLabelLugarTrendingTopics, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(trendingTopic1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelTrendingTopicsLayout.setVerticalGroup(
            jPanelTrendingTopicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrendingTopicsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTrendingTopicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTituloTrendingTopics, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLugarTrendingTopics, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(trendingTopic1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trendingTopic2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trendingTopic3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trendingTopic4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trendingTopic5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trendingTopic6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trendingTopic7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trendingTopic8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trendingTopic9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trendingTopic10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButtonAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ajustes.png"))); // NOI18N

        javax.swing.GroupLayout jPanelTweetsLayout = new javax.swing.GroupLayout(jPanelTweets);
        jPanelTweets.setLayout(jPanelTweetsLayout);
        jPanelTweetsLayout.setHorizontalGroup(
            jPanelTweetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTweetsLayout.createSequentialGroup()
                .addGroup(jPanelTweetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTweetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelTweetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTweetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tweet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tweet2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tweet10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tweet9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tweet8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tweet7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tweet6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tweet5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tweet3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tweet4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelTweetsLayout.setVerticalGroup(
            jPanelTweetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTweetsLayout.createSequentialGroup()
                .addComponent(tweet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tweet2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tweet3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tweet4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tweet5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tweet6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tweet7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tweet8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tweet9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tweet10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPaneTweets.setViewportView(jPanelTweets);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTrendingTopics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAjustes))
                    .addComponent(componenteNuevoTweet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneTweets))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelTrendingTopics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(componenteNuevoTweet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPaneTweets, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.Buscar Buscador;
    private componentes.NuevoTweet componenteNuevoTweet;
    private javax.swing.JButton jButtonAjustes;
    private javax.swing.JLabel jLabelLugarTrendingTopics;
    private javax.swing.JLabel jLabelTituloTrendingTopics;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelTrendingTopics;
    private javax.swing.JPanel jPanelTweets;
    private javax.swing.JScrollPane jScrollPaneTweets;
    private componentes.TrendingTopic trendingTopic1;
    private componentes.TrendingTopic trendingTopic10;
    private componentes.TrendingTopic trendingTopic2;
    private componentes.TrendingTopic trendingTopic3;
    private componentes.TrendingTopic trendingTopic4;
    private componentes.TrendingTopic trendingTopic5;
    private componentes.TrendingTopic trendingTopic6;
    private componentes.TrendingTopic trendingTopic7;
    private componentes.TrendingTopic trendingTopic8;
    private componentes.TrendingTopic trendingTopic9;
    private componentes.ComponenteTweet tweet1;
    private componentes.ComponenteTweet tweet10;
    private componentes.ComponenteTweet tweet2;
    private componentes.ComponenteTweet tweet3;
    private componentes.ComponenteTweet tweet4;
    private componentes.ComponenteTweet tweet5;
    private componentes.ComponenteTweet tweet6;
    private componentes.ComponenteTweet tweet7;
    private componentes.ComponenteTweet tweet8;
    private componentes.ComponenteTweet tweet9;
    // End of variables declaration//GEN-END:variables
}
