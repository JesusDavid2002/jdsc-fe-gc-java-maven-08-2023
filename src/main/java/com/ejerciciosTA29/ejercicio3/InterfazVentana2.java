package com.ejerciciosTA29.ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazVentana2 extends JFrame {

	private JPanel contentPane;
	private int acumulador1;
	private int acumulador2;

	/**
	 * Create the frame.
	 */
	public InterfazVentana2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Boton 1:");
		lblNewLabel.setBounds(40, 41, 114, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Boton 2: ");
		lblNewLabel_1.setBounds(187, 41, 126, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnBoton1 = new JButton("Boton 1");
		btnBoton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acumulador1 ++;
				lblNewLabel.setText("Boton 1: " + acumulador1 + " veces");
			}
		});
		btnBoton1.setBounds(40, 119, 89, 23);
		contentPane.add(btnBoton1);
		
		JButton btnBoton2 = new JButton("Boton 2");
		btnBoton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acumulador2 ++;
				lblNewLabel_1.setText("Boton 2: " + acumulador2 + " veces");
			}
		});
		btnBoton2.setBounds(187, 119, 89, 23);
		contentPane.add(btnBoton2);
	}

}
