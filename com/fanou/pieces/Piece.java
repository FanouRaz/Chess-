package com.fanou.pieces;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Piece extends JLabel {
    private String nom; 
    private String couleur;
    private ImageIcon iconPiece;
    private int[] position;
    

    public Piece(String nom,String couleur,int x,int y){
        this.nom = nom;
        this.couleur = couleur;
        this.position = new int[2];
        this.position[0] = x;
        this.position[1] = y;
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
    }

    public int[] getPosition(){
        return this.position;
    }

    public void setPosition(int x,int y){
        this.position[0] = x;
        this.position[1] = y;
    }
    public String getNom(){
        return this.nom;
    }

    public String getColor(){
        return this.couleur;
    }
    
    public ImageIcon getImage() {
    	return this.iconPiece;
    }
    
    public void setImage(ImageIcon img) {
    	this.iconPiece = img;
    }
    public abstract void deplacement();

}
