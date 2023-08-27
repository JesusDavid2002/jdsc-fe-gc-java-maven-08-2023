package com.ejerciciosTA29.ejercicio4;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class InterfazEventos extends JFrame implements WindowListener {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public InterfazEventos() {
		setTitle("Ventana oyente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eventos:");
		lblNewLabel.setBounds(10, 110, 46, 14);
		contentPane.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(61, 11, 363, 239);
		contentPane.add(textArea);
		
		addWindowListener(this);
	}

	public void actualizarTextArea(String texto) {
		// TODO Auto-generated method stub
		textArea.append(texto + "\n");
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		actualizarTextArea("Texto inicial");
		actualizarTextArea("Ventana activada");
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		actualizarTextArea("Ventana cerrada");
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		actualizarTextArea("Ventana cerradandose");

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		actualizarTextArea("Ventana desactivada");

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		actualizarTextArea("Ventana de tamaño maximo a normal");

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		actualizarTextArea("Ventana de tamaño normal a maximo");

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		actualizarTextArea("Ventana abierta");

	}

	
	
}
