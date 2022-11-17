/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.Case;

import java.util.Scanner;

import edu.centralenantes.monopoly.ei2.Joueur;
import edu.centralenantes.monopoly.ei2.NoMoreMoney;

/**
 *
 * @author inky19
 */
public abstract class Achetable extends Case {
  private int prix;
  private Joueur proprietaire;

  public Achetable(int num, String nom, int prix, Joueur proprio) {
    super(num, nom);
    this.prix = prix;
    this.proprietaire = proprio;
  }

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

  public void acheter(Joueur j) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Vous possédez :" + j.getFortune() + "€");
    System.out.println("Voulez-vous acheter :" + this.getNom() + " qui vaut " + this.prix + "€");
    System.out.println("oui / non" );
    String reponse = scan.nextLine();

    boolean verif = true;
    while(verif){
      if (reponse.equals("oui")){
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
      }
      else if (reponse.equals("non")){
        verif = false;
      }
      else{
        System.out.println("Erreur de saisie!");
        System.out.println("Vous possédez :" + j.getFortune() + "€");
        System.out.println("Voulez-vous acheter :" + this.getNom() + " qui vaut " + this.prix + "€");
        System.out.println("oui / non" );
        reponse = scan.nextLine();
      }
    }
    scan.close();
  }

  public abstract int loyer();

}
