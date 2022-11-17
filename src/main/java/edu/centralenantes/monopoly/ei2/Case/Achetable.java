/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case;

import java.util.Scanner;

import edu.centralenantes.monopoly.ei2.Joueur;
import edu.centralenantes.monopoly.ei2.NoMoreMoney;

/**
 * Classe abstraite assurant la gestion des Achetables
 * @author Elouan
 */
public abstract class Achetable extends Case {
    
    //ATTRIBUTS
    /**
     * prix d'achat de la case
     */
    private int prix;
    /**
     * propriétaire de la case
     */
    private Joueur proprietaire;
    
    //CONSTRUCTEURS
    /**
     * Crée un achetable paramétré
     * @param num numéro de la case
     * @param nom nom de la case
     * @param prix prix d'achat de la case
     * @param proprio propriétaire de la case
     */
    public Achetable(int num, String nom, int prix, Joueur proprio) {
        super(num, nom);
        this.prix = prix;
        this.proprietaire = proprio;
    }
    
    //GETTERS ET SETTERS
    public int getPrix() {
        return this.prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Joueur getProprietaire() {
        return this.proprietaire;
    }

    public void setProprietaire(Joueur proprio) {
        this.proprietaire = proprio;
    }
    
    //AUTRES MÉTHODES
    /**
     * Permet à un joueur de devenir propriétaire d'un achetable
     * @param j joueur
     */
    public void acheter(Joueur j) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vous possédez :" + j.getFortune() + "€");
        System.out.println("Voulez-vous acheter :" + this.getNom() + " qui vaut " + this.prix + "€");
        System.out.println("oui / non");
        String reponse = scan.nextLine();

        boolean verif = true;
        while (verif) {
            if (reponse.equals("oui")) {
                try {
                    j.payerBanque(this.prix);
                    this.setProprietaire(j);
                    if (this.getClass().getName().contains("Gare")) {
                        j.setNbGare(j.getNbGare() + 1);
                    }
                } catch (NoMoreMoney exception) {
                    System.out.println("Vous n'avez pas assez d'argent pour acheter la case.");
                    System.out.println(" ");
                }
                verif = false;
            } else if (reponse.equals("non")) {
                verif = false;
            } else {
                System.out.println("Erreur de saisie!");
                System.out.println("Vous possédez :" + j.getFortune() + "€");
                System.out.println("Voulez-vous acheter :" + this.getNom() + " qui vaut " + this.prix + "€");
                System.out.println("oui / non");
                reponse = scan.nextLine();
            }
        }
        scan.close();
    }
    
    /**
     * Calcule le loyer d'un achetable
     * @return le loyer
     */
    public abstract int loyer();

}
