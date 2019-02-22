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
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Annie
 */
public class Listeners extends JButton {

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

    public void cambiarColorJPanelAlPasarPorEncima(final JPanel panel, final Color colorOriginal, final Color colorCambiado) {

        panel.addMouseListener(new MouseListener() {
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
                panel.setBorder(new LineBorder(colorCambiado));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBorder(new LineBorder(colorOriginal));
            }

        });
    }
    
    
    
}
