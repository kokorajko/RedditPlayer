/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Michu
 */
public class Stars {

    private int[] arrayIsClicked = {0, 0, 0, 0, 0, 0};

    public void mouseExited(JLabel[] arrayOfLabels) {
        for (int i = 0; i < arrayIsClicked.length - 1; i++) {
            if (arrayIsClicked[i] == 0) {
                arrayOfLabels[i].setIcon(emptyStar());
            }
        }
    }

    public void mousePressed(JLabel[] arrayOfLabels, int starID) {
        for (int i = 0; i < arrayOfLabels.length; i++) {
            if (i <= starID) {
                arrayOfLabels[i].setIcon(filledStar());
                arrayIsClicked[i] = 1;
            } else {
                arrayOfLabels[i].setIcon(emptyStar());
                arrayIsClicked[i] = 0;
            }
        }
    }

    public void mouseEntered(JLabel[] arrayOfLabels, int starID) {
        for (int i = 0; i < starID + 1; i++) {
            if (arrayIsClicked[i] == 0) {
                arrayOfLabels[i].setIcon(filledStar());
            }
        }
    }

    public ImageIcon emptyStar() {
        return new javax.swing.ImageIcon(getClass().getResource("/images/empty_star.png"));
    }

    public ImageIcon filledStar() {
        return new javax.swing.ImageIcon(getClass().getResource("/images/filled_star.png"));
    }

}
