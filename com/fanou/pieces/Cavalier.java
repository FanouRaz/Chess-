package com.fanou.pieces;

import java.util.ArrayList;

import com.fanou.jeu.Case;

public class Cavalier extends Piece{

    public Cavalier(String couleur,int x,int y){
        super("Cavalier",couleur,x,y);
    }
    
    @Override
	public ArrayList<int[]> getMovablePositions(Case[][] grille){
        ArrayList<int[]> movable = new ArrayList<int[]>();
        int[] currentPos = getPosition();
        
        int[] moves = {-2,-1,1,2};
        //Mouvement en L
        for(int moveX : moves){
            for(int moveY : moves){
                int posX = currentPos[0];
                int posY = currentPos[1];

				if((Math.abs(moveX) == Math.abs(moveY)) || (Math.abs(moveX) != 2 && Math.abs(moveY) !=2) ) continue;
            
                if(posX+moveX < 8 && posY+moveY < 8 && posX+moveX >=0  && posY+moveY >= 0){
                    Piece piece = grille[posX+moveX][posY+moveY].getPiece();
                    if(piece != null){
                        if(!piece.getColor().equals(this.getColor())) 
                            movable.add(new int[]{posX+moveX,posY+moveY});  
                    }
                    
                    else  movable.add(new int[]{posX+moveX,posY+moveY});
                } 
            }                
        }

        return movable;
    }

}


