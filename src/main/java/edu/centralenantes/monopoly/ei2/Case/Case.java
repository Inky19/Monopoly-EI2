/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case;

/**
 *
 * @author Domitille
 */
public abstract class Case {
    
    // ATTRIBUTS

    // numéro de la case entre 0 et 39 compris 
    int numero;
    
    // nom de la case
    String nom;
    
    // CONSTRUCTEUR
    
    /**
     * Permet de créer une case à partir de son nom ainsi que de son numéro
     * @param num = numéro
     * @param name = nom
     */
    
    public Case (int num, String name){
        this.numero = num;
        this.nom = name;
    }
    
    // GETTERS & SETTERS

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Redéfinition de la méthode toString 
     * @return le numéro ainsi que le nom de la case
     */
    
    @Override
    public String toString() {
        return "Case{" + "numero=" + numero + ", nom=" + nom + '}';
    }

}
