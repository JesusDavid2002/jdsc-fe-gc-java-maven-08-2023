package com.ejerciciosTA29.ejercicio5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class InterfazEventosRaton extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public InterfazEventosRaton() {
		setTitle("Eventos del ratón");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		textArea = new JTextArea();
		textArea.setBounds(10, 41, 414, 209);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Limpiar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnNewButton.setBounds(181, 11, 89, 23);
		contentPane.add(btnNewButton);
	
		addMouseListener(this);
	}

	public void actualizarTextArea(String texto) {
		// TODO Auto-generated method stub
		textArea.append(texto + "\n");
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		actualizarTextArea("el ratón a hecho click");
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		actualizarTextArea("el ratón a entrado en el componente");
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		actualizarTextArea("el ratón a salido del componente");
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		actualizarTextArea("el ratón a pulsado en el componente");
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		actualizarTextArea("el ratón se a salido");
	}

}
