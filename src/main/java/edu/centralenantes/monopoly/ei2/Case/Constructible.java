/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case;

import edu.centralenantes.monopoly.ei2.NoMoreMoney;
import java.util.InputMismatchException;
import java.util.Scanner;

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
    /**
     * prix d'achat d'une maison sur la case. Un hôtel vaut 5 maisons.
     */
    private int prixMaison;
    

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

    public int getPrixMaison() {
        return prixMaison;
    }

    public void setPrixMaison(int prixMaison) {
        this.prixMaison = prixMaison;
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
     * @param prixM prix d'une maison
     */
    public Constructible(int num, String nom, int prix, int a, int b, int loy, int prixM) {
        super(num, nom, prix, null);
        this.nbMaisons = 0;
        this.nbHotels = 0;
        this.a = a;
        this.b = b;
        this.loyerInit = loy;
        this.prixMaison = prixM;
    }
    
    /**
     * Crée un constructible de départ (pas de propriétaire, pas de maisons, pas
     * d'hôtels). a, b, loyerInit et prixMaison sont calculés en fonction du prix du constructible.
     * @param num
     * @param nom
     * @param prix 
     */
    public Constructible(int num, String nom, int prix) {
        super(num, nom, prix, null);
        this.nbMaisons = 0;
        this.nbHotels = 0;
        this.a = this.getPrix();
        this.b = this.getPrix()*5;
        this.loyerInit = this.getPrix()/6;
        this.prixMaison = this.getPrix()/2;
    }

    //AUTRES METHODES
    /**
     * Calcule le loyer du constructible
     * S'il n'y a pas de propriétaire, le loyer est nul
     * @return loyer total à payer
     */
    @Override
    public int loyer() {
        int loyerTotal = 0;
        if (this.getProprietaire() == null){
            return loyerTotal;
        }else{
            loyerTotal = this.loyerInit+ this.a*this.nbMaisons+this.b*this.nbHotels;
            return loyerTotal;
        }
    }
    
    /**
     * Permet au propriétaire de choisir le nombre de maison à construire
     * @param scan scanner utilisé
     * @return le choix du nombre de maisons à construire.
     */
    public int choixConstruire(Scanner scan){
        boolean valide = false;
        int maisonConst = 0;
        
        while (!valide){
            try{
                int borneMaison = 5 - this.getNbMaisons();
                System.out.println("Tu as actuellement " + this.nbMaisons + " maisons du cette case.");
                System.out.println("Tu peux construire entre 0 et " + borneMaison + ". La cinquième transforme tes maisons en un hôtel.");
                System.out.println("Le prix d'une maison est de "+ this.prixMaison + " €");
                System.out.println("Combien de maison veux-tu construire ?");
                maisonConst = scan.nextInt();
                scan.nextLine();
                if (maisonConst>borneMaison || maisonConst<0){
                    System.out.println("Tu ne peux pas construire "+ maisonConst + " maisons cette fois.");
                    valide = false;
                }else{
                    valide = true;              
                }
            }catch (InputMismatchException err){
                System.out.println("Ce n'est pas un entier, réessaie !");
                valide = false;
            }
        }
        return maisonConst;
    }
    
    /**
     * Construit le nombre de maisons voulu par le propriétaire
     * @param scan scanner utilisé
     */
    public void construire(Scanner scan){
        try {
            int maisonsConstruites = this.choixConstruire(scan);
            int aPayer = maisonsConstruites*this.prixMaison;
            this.getProprietaire().payerBanque(aPayer);
            this.nbMaisons+=maisonsConstruites;
            if (this.nbMaisons==5){
                this.nbMaisons=0;
                this.nbHotels++;
            }
        }catch(NoMoreMoney err){
            System.out.println("Tu n'as pas assez d'argent, dommage...");
        }     
    }
    
    /**
     * Crée un String contenant les caractéristiques du constructible
     * @return un string contenant les caractéristiques du constructible
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
            constructString += "loyer = " + this.loyer()+ " €";
        }
        return constructString;
    }
}
