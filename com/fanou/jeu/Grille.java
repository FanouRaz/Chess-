package com.fanou.jeu;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fanou.pieces.Cavalier;
import com.fanou.pieces.Fou;
import com.fanou.pieces.Piece;
import com.fanou.pieces.Pion;
import com.fanou.pieces.Reine;
import com.fanou.pieces.Roi;
import com.fanou.pieces.Tour;

import java.awt.GridLayout;
import java.awt.Color;

//new Color(254,0,2)
public class Grille extends JPanel {
    private JLabel[][] grille;
    private Piece[] noirs={
        new Tour("noir", 0, 0),
        new Tour("noir", 0, 7),
        new Cavalier("noir", 0, 1),
        new Cavalier("noir", 0, 6),
        new Fou("noir", 0, 2),
        new Fou("noir", 0, 5),
        new Roi("noir", 0, 4),
        new Reine("noir", 0, 3),
        new Pion("noir", 1, 0),
        new Pion("noir", 1, 1),
        new Pion("noir", 1, 2),
        new Pion("noir", 1, 3),
        new Pion("noir", 1, 4),
        new Pion("noir", 1, 5),
        new Pion("noir", 1, 6),
        new Pion("noir", 1, 7),
    };
    private Piece[] blancs={
        new Tour("blanc", 7, 0),
        new Tour("blanc", 7, 7),
        new Cavalier("blanc", 7, 1),
        new Cavalier("blanc", 7, 6),
        new Fou("blanc", 7, 2),
        new Fou("blanc", 7, 5),
        new Roi("blanc", 7, 4),
        new Reine("blanc", 7, 3),
        new Pion("blanc", 6, 0),
        new Pion("blanc", 6, 1),
        new Pion("blanc", 6, 2),
        new Pion("blanc", 6, 3),
        new Pion("blanc", 6, 4),
        new Pion("blanc", 6, 5),
        new Pion("blanc", 6, 6),
        new Pion("blanc", 6, 7),
    };

    public Grille(){
        this.setOpaque(false);
        this.setLayout(new GridLayout(8,8));
        
        System.out.print(noirs);
        grille = new JLabel[8][8];
        boolean isBlack = false;
        
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                grille[i][j] = new JLabel("");
                
                for(Piece noir: this.noirs){
                    if(noir.getPosition()[0] == i && noir.getPosition()[1] ==j){
                        grille[i][j] = noir;
                    }
                }

                for(Piece blanc: this.blancs){
                    if(blanc.getPosition()[0] == i && blanc.getPosition()[1] ==j){
                        grille[i][j] = blanc;
                    }
                }

                if(!isBlack){
                    grille[i][j].setBackground(Color.WHITE);
                    grille[i][j].setOpaque(true);
                    this.add(grille[i][j]);
                    if(j!=7) isBlack = !isBlack;
                }
                else if(isBlack){
                    grille[i][j].setOpaque(true);
                    grille[i][j].setBackground(Color.GRAY);
                    this.add(grille[i][j]);
                    if(j!=7) isBlack = !isBlack;
                }
                
            }
        }
        
        
        
    }
}
