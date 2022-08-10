package com.fanou.jeu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Fenetre extends JFrame{

    public Fenetre(){
        this.setTitle("Echecs");
        this.setIconImage(new ImageIcon(getClass().getResource("/assets/images/Cavalier Noir.png")).getImage());
        this.setSize(650,650);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(new Grille());
        this.setVisible(true);
    }
    public static void main(String... args){
        new Fenetre();
    }
}