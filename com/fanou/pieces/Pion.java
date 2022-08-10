package com.fanou.pieces;

import javax.swing.ImageIcon;

public class Pion extends Piece{
	 public Pion(String couleur,int x,int y){
	        super("pion",couleur,x,y);
	        if(couleur == "noir") {
	        	this.setImage(new ImageIcon(getClass().getResource("/assets/images/Pion Noir.png")));
	        }
	        else this.setImage(new ImageIcon(getClass().getResource("/assets/images/Pion Blanc.png")));
            this.setIcon(this.getImage());
	    }
	    @Override
	    public void deplacement() {}
}
