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

/**
 *
 * @author Annie
 */
public class ListenerBotones extends JButton {

   /* private Color color;
    private final JButton button;

    public ListenerBotones(Color color, JButton button) {
        this.color = color;
        this.button = button;
    }*/

    public void cambiarColorAlPasarPorEncima(final JButton button, final Color colorOriginal, final Color colorCambiado) {

        button.addMouseListener(new MouseListener() {
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

                button.setBackground(colorCambiado);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(colorOriginal);

            }

        });
    }
}
