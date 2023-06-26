/**
 * @author FanouRaz
 * JChess
 * */
package com.fanou.jeu;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
/**
 * Fenetre du jeu
 */
public class Fenetre extends JFrame{
    private String[] xIndex;
    private String[] yIndex;
    private JPanel horizontal;
    private JPanel vertical;
    private Grille grille;


    public Fenetre(){
        grille = new Grille();
        xIndex = new String[]{"1","2","3","4","5","6","7","8"};
        yIndex = new String[]{"A","B","C","D","E","F","G","H"};
        horizontal = new JPanel();
        vertical = new JPanel();

        this.setTitle("Echecs");
        this.setIconImage(new ImageIcon(getClass().getResource("/assets/images/Cavalier noir.png")).getImage());
        this.setSize(650,650);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        
        this.add(grille,BorderLayout.CENTER);

        horizontal.setLayout(new GridLayout(1,8));
        vertical.setLayout(new GridLayout(8,1));

        for(String x : xIndex) horizontal.add(new JLabel(x));
        for(String y : yIndex) vertical.add(new JLabel(y));

        this.add(horizontal,BorderLayout.NORTH);
        this.add(vertical,BorderLayout.EAST);
        this.setVisible(true);
    }
    public static void main(String... args){
        new Fenetre();
    }
}