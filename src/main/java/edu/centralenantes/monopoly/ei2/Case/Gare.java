/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case;

/**
 *
 * @author Tristan
 */
public class Gare extends Achetable {

    public Gare(int num, String nom, int prix, Joueur proprietaire) {
        super(num, nom, prix, proprietaire);
    }

    public String toString() {
        return "Gare";
    }

    @Override
    public int loyer(Joueur j) {
        return 2500;
    }

}
