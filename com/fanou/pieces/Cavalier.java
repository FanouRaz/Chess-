package com.fanou.pieces;

import javax.swing.ImageIcon;

public class Cavalier extends Piece{

    public Cavalier(String couleur,int x,int y){
        super("cavalier",couleur,x,y);
        if(couleur == "noir") {
        	this.setImage(new ImageIcon(getClass().getResource("/assets/images/Cavalier Noir.png")));
        }
        else this.setImage(new ImageIcon(getClass().getResource("/assets/images/Cavalier Blanc.png")));
        this.setIcon(this.getImage());
    }
    @Override
    public void deplacement(){

    }

}


