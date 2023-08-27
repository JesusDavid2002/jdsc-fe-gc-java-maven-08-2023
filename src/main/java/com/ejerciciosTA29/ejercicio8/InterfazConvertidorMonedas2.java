package com.ejerciciosTA29.ejercicio8;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class InterfazConvertidorMonedas2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Create the frame.
	 */
	public InterfazConvertidorMonedas2() {
		setTitle("Convertidor monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad a convertir");
		lblNewLabel.setBounds(10, 55, 126, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("EUROS A PESETAS");
		lblNewLabel_2.setBounds(180, 11, 201, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(148, 52, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado");
		lblNewLabel_1.setBounds(289, 55, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(363, 52, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCambiarMoneda = new JButton("Ptas a euros (↾)");
		btnCambiarMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoMoneda = btnCambiarMoneda.getText();
				
				if(tipoMoneda.equals("Ptas a euros (↾)")) {
					btnCambiarMoneda.setText("Euros a ptas (↾)");
					lblNewLabel_2.setText("PESETAS A EUROS");
				} else {
					btnCambiarMoneda.setText("Ptas a euros (↾)");
					lblNewLabel_2.setText("EUROS A PESETAS");
				}
				
			}
		});
		btnCambiarMoneda.setBounds(41, 98, 146, 23);
		contentPane.add(btnCambiarMoneda);
		
		JButton btnCambiar = new JButton("Cambiar ( ↼)");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tipoMoneda = btnCambiarMoneda.getText();
					double cantidad = Double.parseDouble(textField.getText()); 
					double resultado = 0;	
					
					if(tipoMoneda.equals("Ptas a euros (↾)")) {
						resultado = cantidad * 166.386;
						textField_1.setText(df.format(resultado));
					} else {
						resultado = cantidad / 166.386;
						textField_1.setText(df.format(resultado));
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
			}
		});
		btnCambiar.setBounds(216, 98, 112, 23);
		contentPane.add(btnCambiar);
		
		
		JButton btnBorrar = new JButton("Borrar ( ⇀)");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnBorrar.setBounds(360, 98, 101, 23);
		contentPane.add(btnBorrar);
		contentPane.setFocusable(true);
		
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            		btnCambiar.doClick();
            	}
            	
                int keyCode = e.getKeyCode();

                // Verificar qué tecla se presionó
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        btnCambiar.doClick();
                        break;
                    case KeyEvent.VK_RIGHT:
                        btnBorrar.doClick();
                        break;
                    case KeyEvent.VK_UP:
                        btnCambiarMoneda.doClick();
                        break;
                }
            }
        });
        textField.requestFocus();
	}

}
