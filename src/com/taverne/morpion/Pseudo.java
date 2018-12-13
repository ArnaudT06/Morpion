package com.taverne.morpion;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Pseudo {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private Morpion windowsJeu;
	private String J1;
	private String J2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pseudo window = new Pseudo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pseudo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {//Initialisation de la page des pseudo
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[225,grow][225,grow]", "[][][150][][150]"));
		
		JLabel lblPlayer = new JLabel("Player 1");
		frame.getContentPane().add(lblPlayer, "cell 0 1,alignx center");
		
		JLabel lblPlayer_1 = new JLabel("Player 2");
		frame.getContentPane().add(lblPlayer_1, "cell 1 1,alignx center");
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "cell 0 2,growx");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);
		
		JButton btnYes = new JButton("YES"); // On peut commencer à jouer
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J1=textField.getText();
				J2=textField_1.getText();
				Pseudo.this.frame.setVisible(false);
				windowsJeu = new Morpion(J1,J2);
			}
		});
		frame.getContentPane().add(btnYes, "cell 0 4,alignx center");//Fermeture de l'application
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnCancel, "cell 1 4,alignx center");
		
	}

}
