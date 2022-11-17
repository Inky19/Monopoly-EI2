/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case;

import edu.centralenantes.monopoly.ei2.Joueur;

/**
 *Permet de créer/manipuler une case Compagnie
 * @author ELAYED/ELBETTAL
 */
public class Compagnie extends Achetable{

    /**
     *Permet de créer une case Compagnie à partir de son nom ,son numéro , son prix et son proprietaire 
     * @param num numero de la case
     * @param nom nom de la case 
     * @param prix prix de la case 
     * @param proprio proprietaire de la case
     */
    public  Compagnie(int num, String nom, int prix, Joueur proprio ){
        super(num , nom , prix , proprio);
    }

    /**
     *Permet de calculer le loyer 40 x le nombre aleatoire s'il existe un proprietaire 0 sinon 
     * @return le loyer
     */
    @Override
    public int loyer() {
        int l;
        if (this.getProprietaire()==null){
           l=0 ; 
       }
       else{
           l=Joueur.lanceLeDe()*40 ;
       }
       return l ; 
    }
}
