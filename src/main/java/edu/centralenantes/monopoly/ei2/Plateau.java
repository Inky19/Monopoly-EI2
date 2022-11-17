/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2;

import java.util.Scanner;


/**
 *
 * @author inky19, littlewuuu, Bryan
 */
public class Plateau {

    
    private void initJoueur(){
        int nbJoueur;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre de Joueur");
        nbJoueur = scanner.nextInt();
        for (int i=0;i<nbJoueur;i++){
            Joueurs.add(new Joueur());
        }
    }
    
    public void tourDeJeu(){
        for (Joueur j : Joueurs){
            j.tourDuJoueur(this);
        }
    }
    
    

}
