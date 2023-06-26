package com.fanou.pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.fanou.jeu.Case;

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

        setImage(new ImageIcon(getClass().getResource(String.format("/assets/images/%s %s.png",nom, couleur))));
        setIcon(this.getImage());
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
    
    /**
     * @param grille : La grille de jeu actuelle indiquant l'état de toutes les cases
     * @return Liste des positions où la piece peut se déplacer en considérant l'état de la grille de jeu actuelle entrée en paramètre
     */
    public abstract ArrayList<int[]> getMovablePositions(Case[][] grille);
    

    @Override
    public String toString(){
        return String.format("%s %s (%d,%d)",nom,couleur,position[0],position[1]);
    }
}
