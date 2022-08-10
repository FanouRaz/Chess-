package com.fanou.pieces;

import javax.swing.ImageIcon;

public class Reine extends Piece {
	 public Reine(String couleur,int x,int y){
	        super("reine",couleur, x, y);
	        if(couleur == "noir") {
	        	this.setImage(new ImageIcon(getClass().getResource("/assets/images/Reine Noire.png")));
	        }
	        else this.setImage(new ImageIcon(getClass().getResource("/assets/images/Reine Blanche.png")));
			this.setIcon(this.getImage());
	    }
	    @Override
	    public void deplacement() {}
}
