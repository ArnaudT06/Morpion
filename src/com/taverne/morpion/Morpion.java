package com.taverne.morpion;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;


public class Morpion {
	
	static Scanner sc = new Scanner(System.in);
	static String Joueur1; // Objects of String class
	static String Joueur2;
	private int coupx = 0;
	private int coupo = 0;
	private int coupjoué =0;
	private int scorej1 =0;
	private int scorej2 =0;
     

	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { // Appel de la fonction du jeu
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Morpion window = new Morpion(Joueur1, Joueur2);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	        
	}
	
	JButton buttons[] = new JButton[9];  // Déclaration des 9 boutons du morpion
    int alternate = 0;
    private JLabel lblPlayer;
    private JLabel lblPlayer_1;
    private JTextField textField;
    private JTextField textField_1;
    private JButton btnYes;
    private JButton btnNo;

	/**
	 * Create the application.
	 * @return 
	 */

	public Morpion(String S1, String S2) { // Déclaration des variables mettant en lien les pseudos de la classe Pseudo
		Joueur1=S1;
		Joueur2=S2;
	    initialize(); 
	    Morpion.this.frame.setVisible(true); // Rend visible la fenêtre de jeu
	    
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() { // Dimensionnement de la fenêtre de jeu
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(new GridLayout(3,3));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
		 for(int i = 0; i <= 8; i++)
	        {
	            buttons[i] = new JButton();
	            buttons[i].setText("");
	            buttons[i].addActionListener(new buttonListener());
	            frame.getContentPane().add(buttons[i]);        
	        }
	    }
	  public void resetButtons() // Reset de la fenêtre de jeu
	    {
	        for(int i = 0; i <= 8; i++)
	        {
	            buttons[i].setText("");
	        }
	    }
	  public void egalite() // Fonction en cas d'égalité
	    {
	       
	        if(buttons[0] != null &&buttons[1] != null && buttons[2] != null && buttons[3] != null && buttons[4] != null && buttons[5] != null && buttons[6] != null && buttons[7] != null && buttons[8] != null){
	        	JOptionPane.showConfirmDialog(null, " Pas de gagnant vous êtes des nuls");

                resetButtons();
	        }
	    }
	  private class buttonListener implements ActionListener
	    {
	       
	        public void actionPerformed(ActionEvent e) 
	        {

	            
	            JButton buttonClicked = (JButton)e.getSource(); // Fonction pour attribuer les valeurs aux boutons
	            if(alternate%2 == 0)
		            {
	            		if(buttonClicked.getText()!="X" && buttonClicked.getText()!="O" )
	            		{
			                buttonClicked.setText("X");
			                coupjoué++;
			                coupx++;			                
	            		}
	            		else
	            			alternate--;
		            }
	            else
		            {
		            	if(buttonClicked.getText()!="X" && buttonClicked.getText()!="O" )
	            		{
			                buttonClicked.setText("O");
			                coupo++;
			                coupjoué++;
			                
			            }
		            	else
		            	alternate--;
		            }
	            if(RechercheGagnant1() == true) // Si joueur 1 gagnant
	            {
	            	scorej1++;
	            	int retour3 =JOptionPane.showConfirmDialog(null, Joueur1 + " a gagné en "+ coupx + " coups. Le score actuel est de" + scorej1 +" à " + scorej2 + " , voulez vous rejouer?","Be ok!", JOptionPane.YES_NO_OPTION);

	                if( retour3==JOptionPane.YES_OPTION)
	                {
	                coupx = 0;
		        	coupo = 0;
		        	coupjoué = 0;
	                resetButtons();
	                }
	                if( retour3==JOptionPane.NO_OPTION)
	                {
	                	System.exit(0);
	                }
	                
	            }
	            if(RechercheGagnant2() == true) // Si joueur 2 gagnant
	            {
	            	scorej2++;
	            	int retour =JOptionPane.showConfirmDialog(null, Joueur2 + " a gagné en "+ coupo + " coups. Le score actuel est de" + scorej1 + " à " + scorej2 + " , voulez vous rejouer?","be ok", JOptionPane.YES_NO_OPTION);

	                if( retour==JOptionPane.YES_OPTION)
	                {
		                coupx = 0;
			        	coupo = 0;
			        	coupjoué = 0;
		                resetButtons();
	                }
	                if( retour==JOptionPane.NO_OPTION)
	                {
	                	System.exit(0);
	                }
	            }
	            if(coupjoué == 9) // Compteur de coup joué par le gagnant
	            {
	            	int retour2 =JOptionPane.showConfirmDialog(null, "Egalité, vous êtes des nuls", "nul", JOptionPane.YES_NO_OPTION);

	                if( retour2==JOptionPane.YES_OPTION)
	                {
	            	coupx = 0;
		        	coupo = 0;
		        	coupjoué = 0;
		        	resetButtons();
	                }
	                if( retour2==JOptionPane.NO_OPTION)
	                {
						System.exit(0);
	                }
	            }
	                
	            alternate++;
	            
	        }
	        
	        public boolean RechercheGagnant1() // Verifie si le joueur 1 à gagné
	        {

	        	
	        	
	            if( Verification1(0,1) && Verification1(1,2))
	                return true;
	            else if( Verification1(3,4) && Verification1(4,5) )
	                return true;
	            else if ( Verification1(6,7) && Verification1(7,8))
	                return true;
	            

	            else if ( Verification1(0,3) && Verification1(3,6))
	                return true;  
	            else if ( Verification1(1,4) && Verification1(4,7))
	                return true;
	            else if ( Verification1(2,5) && Verification1(5,8))
	                return true;

	            
	            else if ( Verification1(0,4) && Verification1(4,8))
	                return true;  
	            else if ( Verification1(2,4) && Verification1(4,6))
	                return true;
	            
	            if( Verification1(0,1) && Verification1(1,2))
	                return true;
	            else if( Verification1(3,4) && Verification1(4,5) )
	                return true;
	            else if ( Verification1(6,7) && Verification1(7,8))
	                return true;
	            else 
	                return false;
	            
	            
	        }
	        public boolean RechercheGagnant2() // Verifie si le joueur 2 à gagné
	        {
	            if( Verification2(0,1) && Verification2(1,2))
	                return true;
	            else if( Verification2(3,4) && Verification2(4,5) )
	                return true;
	            else if ( Verification2(6,7) && Verification2(7,8))
	                return true;
	            

	            else if ( Verification2(0,3) && Verification2(3,6))
	                return true;  
	            else if ( Verification2(1,4) && Verification2(4,7))
	                return true;
	            else if ( Verification2(2,5) && Verification2(5,8))
	                return true;

	            
	            else if ( Verification2(0,4) && Verification2(4,8))
	                return true;  
	            else if ( Verification2(2,4) && Verification2(4,6))
	                return true;
	            
	            if( Verification2(0,1) && Verification2(1,2))
	                return true;
	            else if( Verification2(3,4) && Verification2(4,5) )
	                return true;
	            else if ( Verification2(6,7) && Verification2(7,8))
	                return true;
	            else 
	                return false;
	        }
	        
	        public boolean Verification1(int a, int b) // Fonction permettant de vérifié si les bouttons on la même valeur
	        {
	        	String x ="X";
	        	
	            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") && buttons[a].getText().equals(x))
	            {
	            	
	                return true;   	 
	            }
	            else
	                return false;
	        }
	        
	        public boolean Verification2(int a, int b)// Fonction permettant de vérifié si les bouttons on la même valeur
	        {
	        	String o ="O";
	        	
	            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") && buttons[a].getText().equals(o))
	            {
		        	return true;
	            }
	            else
	                return false;
	        }
	        
	    }

}


		