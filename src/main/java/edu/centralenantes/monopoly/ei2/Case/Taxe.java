/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case;

/**
 *Permet de créer/manipuler une case Taxe 
 * @author Samar/ELBETTAL
 */
public class Taxe extends Case{
     // prix de la taxe 
     private int prix ;

    /**
     * Permet de créer une case Taxe à partir de son nom ainsi ,son numéro et son prix 
     * @param num Numero de la case
     * @param nom Nom de la case
     * @param prix prix de la taxe
     */
    public Taxe(int num , String nom ,int prix) {
        super(num , nom) ;
        this.prix = prix;
    }
    // GETTERS & SETTERS
    
    /**
     *
     * @return prix de la taxe
     */
    public int getPrix() {
        return prix;
    }

    /**
     *
     * @param prix prix de la taxe
     */
    public void setPrix(int prix) {
        this.prix = prix;
    }


}
