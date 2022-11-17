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
    public static int lanceLeDe() {
return ((int) Math.floor(Math.random()*6))+1;
}
    @Override
    public int loyer(Object j) {
        int l;
        if (this.proprietaire==null){
           l=0 ; 
       }
       else{
           l=lanceLeDe()*40 ;
       }
       return(l); 
    }
}
