package com.fanou.pieces;

import javax.swing.ImageIcon;

public class Fou extends Piece {
    public Fou(String couleur,int x,int y){
        super("fou",couleur,x,y);
        if(couleur == "noir") {
        	this.setImage(new ImageIcon(getClass().getResource("/assets/images/Fou Noir.png")));
        }
        else this.setImage(new ImageIcon(getClass().getResource("/assets/images/Fou Blanc.png")));
        this.setIcon(this.getImage());
    }
    @Override
    public void deplacement() {}
}
