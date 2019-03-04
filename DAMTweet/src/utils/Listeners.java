/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author Annie
 */
public class Listeners extends JButton {

    public static final Color azulOscuro = new Color(29, 161, 242);
    public static final Color azulClaro = new Color(128, 216, 255);
    public static final Color rojo = new Color(255, 0, 0);
    public static final Color rojoOscuro = new Color(200, 0, 0);

    public void cambiarColorAlPasarPorEncima(final JComponent componente, final Color colorOriginal, final Color colorCambiado) {

        componente.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                componente.setBackground(colorCambiado);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                componente.setBackground(colorOriginal);
            }

        });
    }

}
