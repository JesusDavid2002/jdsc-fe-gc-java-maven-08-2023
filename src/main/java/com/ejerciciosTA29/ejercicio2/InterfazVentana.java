package com.ejerciciosTA29.ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazVentana extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public InterfazVentana() {
		setTitle("Ventana con interaccion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Has pulsado:");
		lblNewLabel.setBounds(41, 35, 143, 14);
		contentPane.add(lblNewLabel);
		
		JButton btn1 = new JButton("Boton 1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("Has pulsado: Boton 1");
				
				
			}
		});
		btn1.setBounds(212, 31, 89, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("Boton 2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("Has pulsado: Boton 2");
				
			}
		});
		btn2.setBounds(308, 31, 89, 23);
		contentPane.add(btn2);
	}
}
