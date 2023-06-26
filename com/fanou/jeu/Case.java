package com.fanou.jeu;

import javax.swing.JLabel;

import com.fanou.pieces.Piece;

public class Case extends JLabel{
    private Piece piece;
    private int[] position;
    private String color;

    public Case(String color, int x, int y){
        this.color = color;
        position = new int[]{x,y};
        piece = null;
    }   

    public Case(String color, int x, int y, Piece piece){
        this.color = color;
        position = new int[]{x,y};
        this.piece = piece;
    } 

    public void affiche(){
        if(piece != null) this.setIcon(piece.getIcon());
        else setIcon(null);
    }
    
    public void setPiece(Piece piece){
        this.piece = piece;
    }

    public Piece getPiece(){
        return piece;
    }

    public int[] getPosition(){
        return this.position;
    }

    public void setPosition(int x,int y){
        this.position[0] = x;
        this.position[1] = y;
    }

    public String getColor(){
        return color;
    }

    /**
     * 
     * @return la position de la case par rapport à l'echequier, les lignes sont indexées par des lettres allant de A à H, tandis que les colonnes sont indexées par des chiffres allant de 1 à 8
     */
    public String getStringIndex(){
        return String.format("%c%d",(char) 'A'+position[0],position[1]+1);
    }

    public void setColor(String color){
        this.color = color;
    }

    @Override
    public String toString(){
        return (piece != null) ? piece.toString() : String.format("case %s vide (%d,%d)",color,position[0],position[1]);
    }
}
