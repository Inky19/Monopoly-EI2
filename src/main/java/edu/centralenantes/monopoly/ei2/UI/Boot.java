/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.monopoly.ei2.UI;

import edu.centralenantes.monopoly.ei2.Case.Case;
import edu.centralenantes.monopoly.ei2.Case.Gare;
import edu.centralenantes.monopoly.ei2.Plateau;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author inky19
 */
public class Boot {

    private JFrame frame;
    private static BufferedImage caseImage;
    private static BufferedImage videImage;
    private static BufferedImage gareImage;
    
    public Boot() {
        
        try {
            caseImage = ImageIO.read(new File("assets/case.png"));
            gareImage = ImageIO.read(new File("assets/gare.png"));
            videImage = ImageIO.read(new File("assets/vide.png"));
        } catch (IOException ex) {
            Logger.getLogger(Boot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void createAndShowGui(Plateau p) {
        frame = new JFrame("Monopoly");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(704, 704);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        List<Case> cases = p.getCases();
        
        GridLayout layout = new GridLayout(11,11);
        JPanel panel = new JPanel(layout);
        int ind = 0;
        int size = 11;
        for(int i=0;i<size;i++){
              for(int j=0;j<size;j++){
                  if ((i==0 || i==size-1)||(j==0||j==size-1)){
                      if (cases.get(ind) instanceof Gare){
                        panel.add(new JLabel(new ImageIcon(gareImage)),i,j);
                      } else {
                        panel.add(new JLabel(new ImageIcon(caseImage)),i,j);
                      }
                  } else {
                      panel.add(new JLabel(new ImageIcon(videImage)),i,j);
                  }
            }
        }
        frame.add(panel);
        
        JButton jouer = new JButton("jouer");
        panel.add(jouer);
        
    }
}
