/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

import edu.centralenantes.monopoly.ei2.Case.AllerEnPrison;
import edu.centralenantes.monopoly.ei2.Case.Case;
import edu.centralenantes.monopoly.ei2.Case.Compagnie;
import edu.centralenantes.monopoly.ei2.Case.Constructible;
import edu.centralenantes.monopoly.ei2.Case.Gare;
import edu.centralenantes.monopoly.ei2.Case.Inutile;
import edu.centralenantes.monopoly.ei2.Case.Prison;
import edu.centralenantes.monopoly.ei2.Case.Taxe;
import edu.centralenantes.monopoly.ei2.Case.Pioche.Chance;
import edu.centralenantes.monopoly.ei2.Case.Pioche.Communautaire;

import java.util.Scanner;


/**
 *
 * @author inky19, littlewuuu, Bryan
 */
public class Plateau {
    private List<Case> cases;
    private List<Joueur> joueurs;
    public int tourDeJeu;

    public Plateau() {
        this("/plateau/plateau.txt");
    }

    public Plateau(String path) {
        cases = new LinkedList<>();
        joueurs = new LinkedList<>();
        initPlateau(path);
        initJoueur();
    }

    private void initPlateau(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = br.readLine();
            String values[] = line.split("_");
            int nbCases = Integer.parseInt(values[0]);

            String libelle = null;
            int prix;
            String typeCase = null;

            for (int i = 0; i < nbCases; i++) {
                Case c = null;
                line = br.readLine();
                values = line.split("_");
                libelle = values[0];
                prix = Integer.parseInt(values[1])*1000;
                typeCase = values[2];
                switch (typeCase) {
                    case "0":
                        c = new Constructible(i,libelle,prix);
                        break;
                    case "1":
                        c = new Gare(i,libelle,prix, null);
                        break;
                    case "2":
                        c = new Taxe(i,libelle,prix);
                        break;
                    case "3":
                        c = new Communautaire(i,libelle);
                        break;
                    case "4":
                        c = new Chance(i,libelle);
                        break;
                    case "5":
                        c = new Inutile(i,libelle);
                        break;
                    case "6":
                        c = new Prison(i,libelle);
                        break;
                    case "7":
                        c = new Compagnie(i, libelle, prix, null);
                        break;
                    case "8":
                        c = new AllerEnPrison(i,libelle);
                        break;
                    default:
                        System.out.println("Problèmem : " + typeCase + " ne correspond à rien.");
                }
                cases.add(c);
            }

        } catch (NumberFormatException e) {
            System.out.println("Problème avec la convertion d'un string en int");
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void affiche() {
        for (Case c : cases) {
            System.out.println(c);
        }
    }
    
    private void initJoueur(){
        int nbJoueur;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre de Joueur");
        System.out.println("Bonjour, bienvenue dans le jeu de Monopoly réalisé par les EI2 !");
        System.out.println("---------Initialisation des joueurs------------");
        System.out.print("Nombre de Joueur : ");
        nbJoueur = scanner.nextInt();
        for (int i=0;i<nbJoueur;i++){
            joueurs.add(new Joueur());
            System.out.println("-------Création du joueur : " + i  + "--------------");
            System.out.print("Nom du joueur : ");
            String nomJoueur = scanner.nextLine();
            joueurs.add(new Joueur(nomJoueur, this));
            System.out.println("Le joueur a bien été crée !");
        }
        scanner.close();
    }
    
    /**
     * Fait jouer tous les joueurs du jeu et les supprime en cas de faillite
     */
    public void tourDeJeu(){
        System.out.println("--------Tour de jeu n°" + tourDeJeu + "---------");
        Iterator<Joueur> it = joueurs.iterator();
        while (it.hasNext()){
            Joueur joueur = (Joueur) it.next();
            try{
                System.out.println("Au tour de " + joueur.getNom() + " de jouer.");
                joueur.tourDuJoueur(this);
            } catch(NoMoreMoney ex){
                it.remove();
                System.out.println(joueur.getNom() + " a fait faillite !");
            }
        }
        System.out.println("Fin du tour !");
        tourDeJeu++;
        tourDeJeu();
    }

    /**
     * Renvoie un booléen si la partie est finie (true) ou non (false)
     * @return
     */
    public boolean finDePartie(){
        return (joueurs.size()<2);
    }

    public List<Case> getCases() {
        return this.cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public List<Joueur> getJoueurs() {
        return this.joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}
