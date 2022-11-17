/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.UI;

import edu.centralenantes.monopoly.ei2.Plateau;

/**
 *
 * @author inky19
 */
public class testUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Boot test = new Boot();
        Plateau plateau = new Plateau();
        test.createAndShowGui(plateau);
    }
}
