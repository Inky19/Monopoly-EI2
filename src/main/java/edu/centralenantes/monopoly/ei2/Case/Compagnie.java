/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case;

/**
 *
 * @author Samar/Oussama
 */
public class Compagnie extends Achetable{
    public void Compagnie(Joueur proprietaire){
        super(proprietaire);
    }
    @Override
    public int loyer(Object j) {
        int l;
        if (this.proprietaire==null){
           l=0;
       }
       else{
           l=5;
       }
       return(l);
    }
}
