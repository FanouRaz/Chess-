package com.fanou.pieces;

import javax.swing.ImageIcon;

public class Roi extends Piece{
	 public Roi(String couleur,int x,int y){
	        super("roi",couleur,x,y);
	        if(couleur == "noir") {
	        	this.setImage(new ImageIcon(getClass().getResource("/assets/images/Roi Noir.png")));
	        }
	        else this.setImage(new ImageIcon(getClass().getResource("/assets/images/Roi Blanc.png")));
			this.setIcon(this.getImage());
	    }
	    @Override
	    public void deplacement() {}
}
