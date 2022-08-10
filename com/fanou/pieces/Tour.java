package com.fanou.pieces;

import javax.swing.ImageIcon;

public class Tour extends Piece {
	 public Tour(String couleur,int x, int y){
	        super("tour",couleur,x,y);
	        if(couleur == "noir") {
	        	this.setImage(new ImageIcon(getClass().getResource("/assets/images/Tour Noire.png")));
	        }
	        else this.setImage(new ImageIcon(getClass().getResource("/assets/images/Tour Blanche.png")));
			this.setIcon(this.getImage());
	    }
	    @Override
	    public void deplacement() {}
}
