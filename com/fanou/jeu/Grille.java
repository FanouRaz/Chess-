package com.fanou.jeu;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.fanou.pieces.Cavalier;
import com.fanou.pieces.Fou;
import com.fanou.pieces.Piece;
import com.fanou.pieces.Pion;
import com.fanou.pieces.Reine;
import com.fanou.pieces.Roi;
import com.fanou.pieces.Tour;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Grille du jeu
 */
public class Grille extends JPanel {
    private Case[][] grille;
    private Piece[] noirs;
    private Piece[] blancs;
    private Case currentClicked;
    private ArrayList<int[]> currentMoves;

    //Initialisation de la grille
    public Grille(){
        this.setOpaque(false);
        this.setLayout(new GridLayout(8,8));
        
        noirs = new Piece[]{
            new Tour("noir", 0, 0),
            new Tour("noir", 0, 7),
            new Cavalier("noir", 0, 1),
            new Cavalier("noir", 0, 6),
            new Fou("noir", 0, 2),
            new Fou("noir", 0, 5),
            new Roi("noir", 0, 4),
            new Reine("noir", 0, 3),
            new Pion("noir", 1, 0),
            new Pion("noir", 1, 1),
            new Pion("noir", 1, 2),
            new Pion("noir", 1, 3),
            new Pion("noir", 1, 4),
            new Pion("noir", 1, 5),
            new Pion("noir", 1, 6),
            new Pion("noir", 1, 7),
        };

        blancs = new Piece[]{
            new Tour("blanc", 7, 0),
            new Tour("blanc", 7, 7),
            new Cavalier("blanc", 7, 1),
            new Cavalier("blanc", 7, 6),
            new Fou("blanc", 7, 2),
            new Fou("blanc", 7, 5),
            new Roi("blanc", 7, 4),
            new Reine("blanc", 7, 3),
            new Pion("blanc", 6, 0),
            new Pion("blanc", 6, 1),
            new Pion("blanc", 6, 2),
            new Pion("blanc", 6, 3),
            new Pion("blanc", 6, 4),
            new Pion("blanc", 6, 5),
            new Pion("blanc", 6, 6),
            new Pion("blanc", 6, 7),
        };

        currentClicked = null;
        currentMoves = new ArrayList<int[]>();
        grille = new Case[8][8];
        boolean isBlack = false;
        
        //Remplissage de la grille initiale
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                grille[i][j] = new Case((isBlack ? "noir" : "blanc"),i,j);
                
                for(Piece noir: this.noirs)
                    if(noir.getPosition()[0] == i && noir.getPosition()[1] ==j) grille[i][j].setPiece(noir);
                    
                for(Piece blanc: this.blancs)
                    if(blanc.getPosition()[0] == i && blanc.getPosition()[1] ==j) grille[i][j].setPiece(blanc);
                
                grille[i][j].setBackground((isBlack) ? Color.GRAY : Color.WHITE);
                grille[i][j].setOpaque(true);

                this.add(grille[i][j]);
                if(j!=7) isBlack = !isBlack;
                
                grille[i][j].affiche();
            }
        }

        //définition de l'évènement au clic
        addEvent();
    }

    /**
     * Affiche les mouvements possibles d'une pièce selectionnée en coloriant en vert les bordures des cases
     *  */
    public void showCurrentMoves(){
        if(currentClicked != null){
            for(int[] move : currentMoves) grille[move[0]][move[1]].setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }    
    }

    public boolean isCurrentlyMovable(int x,int y){
        for(int[] move : currentMoves)
            if(move[0] == x && move[1] == y) return true;
    
        return false;
    } 

    /** 
      * Ajout des eventListener gérant les déplacements des pièces
    */
    public void addEvent(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                grille[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        //Si il n'y a aucune piece selectionnée
                        if(currentClicked == null) {
                            currentClicked = (Case) e.getSource();

                            if(currentClicked.getPiece() != null) currentMoves.addAll((currentClicked.getPiece()).getMovablePositions(grille));
                            

                            else currentClicked = null;
                        }
                        
                        else {
                            Piece current = currentClicked.getPiece();
                            Case choice = (Case) e.getSource();

                            //Déplacement du pion selectionné!
                            if(isCurrentlyMovable(choice.getPosition()[0], choice.getPosition()[1])){
                                current.setPosition(choice.getPosition()[0], choice.getPosition()[1]);
                                choice.setPiece(current);
                                choice.affiche();
                                currentClicked.setPiece(null);
                                currentClicked.affiche();

                                if(choice.getPiece() instanceof Pion) ((Pion)choice.getPiece()).makeFirstMove();

                                System.out.println(String.format("Move %s %s from %s to %s",current.getNom(),current.getColor(),currentClicked.getStringIndex(),choice.getStringIndex()));        
                            }

                            for(int[] move : currentMoves) grille[move[0]][move[1]].setBorder(null);
                        
                            currentClicked = null;
                            currentMoves.clear();
                        }

                        showCurrentMoves();
                    }
                });
            }    
        }
    }
}
