package com.fanou.pieces;

import com.fanou.jeu.Case;

import java.util.ArrayList;

public class Pion extends Piece{
	private boolean firstMove;

	public Pion(String couleur,int x,int y){
		super("Pion",couleur,x,y);
		firstMove = true;
	}

	
	@Override
	public ArrayList<int[]> getMovablePositions(Case[][] grille){
		ArrayList<int[]> movable = new ArrayList<int[]>();
		int[] currentPos = getPosition();

		//Une Case devant
		if(currentPos[0]+((getColor() == "blanc") ? -1 : +1) <8 && 0<= currentPos[0]+((getColor() == "blanc") ? -1 : +1)  && currentPos[1] < 8 && 0 <= currentPos[1]){
			if((((grille[currentPos[0] +((getColor() == "blanc") ? -1 : +1)][currentPos[1]]).getPiece())) == null){
				movable.add(new int[]{( getColor() == "blanc" ? currentPos[0]-1 : currentPos[0] + 1) ,currentPos[1]});
				if(firstMove && ((grille[currentPos[0]+ ((getColor() == "blanc") ? -2 : 2)][currentPos[1]]).getPiece()) == null) movable.add(new int[]{( getColor() == "blanc" ? currentPos[0] - 2 : currentPos[0] + 2) ,currentPos[1]});
			}
		}

		//Pièces mangeable  en diagonale
		if(currentPos[0]+((getColor() == "blanc") ? -1 : +1) <8 && 0<= currentPos[0]+((getColor() == "blanc") ? -1 : +1)  && 0 <= currentPos[1]-1){
			if((((grille[currentPos[0] +((getColor() == "blanc") ? -1 : +1)][currentPos[1]-1]).getPiece())) != null){
				Piece diag = (grille[currentPos[0] +((getColor() == "blanc") ? -1 : +1)][currentPos[1]-1]).getPiece();
				if(!(diag.getColor() == getColor())) movable.add(new int[]{( getColor() == "blanc" ? currentPos[0] - 1: currentPos[0] + 1) ,currentPos[1]-1});
			}
		}
		
		if(currentPos[0]+((getColor() == "blanc") ? -1 : +1) <8 && 0<= currentPos[0]+((getColor() == "blanc") ? -1 : +1)  && currentPos[1]+1 < 8){
			if((((grille[currentPos[0] +((getColor() == "blanc") ? -1 : +1)][currentPos[1]+1]).getPiece())) != null){
				Piece diag = (grille[currentPos[0] +((getColor() == "blanc") ? -1 : +1)][currentPos[1]+1]).getPiece();
				if(!(diag.getColor() == getColor())) movable.add(new int[]{( getColor() == "blanc" ? currentPos[0] - 1: currentPos[0] + 1) ,currentPos[1]+1});
			}
		}

		return movable;
	}

	public void makeFirstMove(){
		firstMove = false;
	}
}
