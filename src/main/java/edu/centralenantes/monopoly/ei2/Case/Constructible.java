/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case;

import edu.centralenantes.monopoly.ei2.Joueur;

/**
 * Classe assurant la gestion des cases constructibles
 * @author Manon Coutier
 */
public class Constructible extends Achetable {

    //ATTRIBUTS
    /**
     * nombre de maison sur la case
     */
    private int nbMaisons;
    /**
     * nombre d'hôtels sur la case
     */
    private int nbHotels;
    /**
     * coefficient loyer des maisons
     */
    private int a;
    /**
     * coefficient loyer des hôtels
     */
    private int b;
    /**
     * loyer initial (auxquels s'ajoutent les éventuelles maisons et hôtels)
     */
    private int loyerInit;

    //GETTERS ET SETTERS

    public int getNbMaisons() {
        return nbMaisons;
    }

    public void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

    public int getNbHotels() {
        return nbHotels;
    }

    public void setNbHotels(int nbHotels) {
        this.nbHotels = nbHotels;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getLoyerInit() {
        return loyerInit;
    }

    public void setLoyerInit(int loyerInit) {
        this.loyerInit = loyerInit;
    }
    
    
    //CONSTRUCTEURS
    /**
     * Crée un constructible de départ (pas de propriétaire, pas de maisons, pas
     * d'hôtels). a, b et loy sont paramétrés spécifiquement.
     *
     * @param num numéro de case
     * @param nom nom de la case
     * @param prix prix de la case
     * @param a coefficient loyer maison
     * @param b coefficient loyer hôtel
     * @param loy loyer de base (terrain vide)
     */
    public Constructible(int num, String nom, int prix, int a, int b, int loy) {
        super(num, nom, prix, null);
        this.nbMaisons = 0;
        this.nbHotels = 0;
        this.a = a;
        this.b = b;
        this.loyerInit = loy;
    }
    
    /**
     * Crée un constructible de départ (pas de propriétaire, pas de maisons, pas
     * d'hôtels). a, b et loy sont calculés en fonction du prix de la case.
     * @param num
     * @param nom
     * @param prix 
     */
    public Constructible(int num, String nom, int prix) {
        super(num, nom, prix, null);
        this.nbMaisons = 0;
        this.nbHotels = 0;
        this.a = this.getPrix()/8;
        this.b = this.getPrix()/6;
        this.loyerInit = this.getPrix()/4;
    }

    //AUTRES METHODES
    /**
     * Calcule le loyer du constructible
     * @param joueur qui tombe sur la case
     * @return loyer total à payer pour le joueur
     */
    public int loyer(Joueur joueur) {
        int loyerTotal = 0;
        if (this.getProprietaire() == null || this.getProprietaire().equals(joueur)){
            return loyerTotal;
        }else{
            loyerTotal = this.loyerInit+ this.a*this.nbMaisons+this.b*this.nbHotels;
            return loyerTotal;
        }
    }
    
    /**
     * Crée un String contenant les caractéristiques de la case
     * @return un string contenant les caractéristiques de la case
     */
    @Override
    public String toString(){
        String constructString = this.getNom() + " (coût : " + this.getPrix() + " €) - ";
        if (this.getProprietaire()==null){
            constructString += "sans propriétaire";
        }else{
            constructString += "propriétaire : " + this.getProprietaire().getNom();
            if (this.nbMaisons>0){
                constructString += ", " + this.getNbMaisons()+ " maisons,";
            }
            if (this.nbHotels>0){
                constructString += ", "+ this.getNbHotels()+ " hôtels";
            }
            constructString += "loyer = " + this.loyer(joueur);
        }
    }

    //PROBLEMES ACHETABLE IMPORTER JOUEUR
    //REVOIR LOYER ET TOUR DE JEU AVEC ARTHUR
    //VOIR GARE ET TRISTAN
}
