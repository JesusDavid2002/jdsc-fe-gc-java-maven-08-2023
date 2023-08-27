package com.ejerciciosTA29.ejercicio6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class InterfazIMC extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DecimalFormat df;

	/**
	 * Create the frame.
	 */
	public InterfazIMC() {
		setTitle("Indice de Masa Corporal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAltura = new JLabel("Altura (metros):");
		lblAltura.setBounds(26, 30, 102, 14);
		contentPane.add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso(kg):");
		lblPeso.setBounds(270, 30, 102, 14);
		contentPane.add(lblPeso);
		
		textField = new JTextField();
		textField.setBounds(138, 27, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(340, 27, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(273, 91, 113, 20);
		contentPane.add(textField_2);
		
		JButton btnCalcular = new JButton("Calcular IMC");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				df = new DecimalFormat ("0.00");
				double altura = Double.parseDouble(textField.getText());
				double peso = Double.parseDouble(textField_1.getText());
				
				double resultado = peso / (Math.pow(altura, 2));
				textField_2.setText(df.format(resultado));
				
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnCalcular.setBounds(76, 90, 135, 23);
		contentPane.add(btnCalcular);
		
		JLabel lblNewLabel = new JLabel("IMC");
		lblNewLabel.setBounds(243, 94, 24, 14);
		contentPane.add(lblNewLabel);
	}
}
