package com.fanou.pieces;

import java.util.ArrayList;

import com.fanou.jeu.Case;


public class Roi extends Piece{
	public Roi(String couleur,int x,int y){
		super("Roi",couleur,x,y);
	}
	

	@Override
	public ArrayList<int[]> getMovablePositions(Case[][] grille){
        ArrayList<int[]> movable = new ArrayList<int[]>();
		int[] currentPos = getPosition();
        int[] moves = {-1,0,1};

        for(int moveX : moves){
            for(int moveY : moves){
                int posX = currentPos[0];
                int posY = currentPos[1];

				if(moveX == 0 && moveY ==0) continue;

                if(posX+moveX < 8 && posY+moveY < 8 && posX+moveX >=0  && posY+moveY >= 0){
                    posX += moveX;
                    posY += moveY;
                    //Si la case suivante dans cette ne contient pas de pièce, on peut passer
                    if(grille[posX][posY].getPiece() == null) movable.add(new int[]{posX,posY});
        
                    //sinon, il n'y a plus de deplacement dans cette direction
                    else{
                        Piece piece = grille[posX][posY].getPiece();
						if(!(piece.getColor() == getColor())) movable.add(new int[]{posX,posY});
                    }
                } 
            }
        }

        return movable;
    }


}
