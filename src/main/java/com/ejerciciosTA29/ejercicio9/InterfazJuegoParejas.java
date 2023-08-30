package com.ejerciciosTA29.ejercicio9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JToggleButton;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;

public class InterfazJuegoParejas extends JFrame {
	private static final int NUM_CARDS = 16;
    private List<Color> colorCards;
    private List<JToggleButton> botones;
    private JToggleButton botonSeleccionado1;
    private JToggleButton botonSeleccionado2;

    public InterfazJuegoParejas() {
        setTitle("Memory Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 4));

        colorCards = new ArrayList<>();
        botones = new ArrayList<>();

        initializeCardColors();
        initializeCardButtons();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeCardColors() {
        for (int i = 0; i < NUM_CARDS / 2; i++) {
        	colorCards.add(Color.RED);
        	colorCards.add(Color.BLUE);
        	colorCards.add(Color.YELLOW);
        	colorCards.add(Color.GREEN);
        	colorCards.add(Color.PINK);
        	colorCards.add(Color.CYAN);
        }
        Collections.shuffle(colorCards);
    }

    private void initializeCardButtons() {
        for (int i = 0; i < NUM_CARDS; i++) {
            JToggleButton toggleButton = new JToggleButton();
            toggleButton.addActionListener(new CardButtonListener());
            toggleButton.setPreferredSize(new Dimension(100,100));
            toggleButton.setSelected(true);
            
            Color cardColor = colorCards.get(i);
            toggleButton.putClientProperty("cardColor", cardColor);
            botones.add(toggleButton);
            add(toggleButton);
        }
    }

    private class CardButtonListener implements ActionListener {
    	
        @Override
        public void actionPerformed(ActionEvent e) {
            JToggleButton clickedButton = (JToggleButton) e.getSource();
            Color buttonColor = (Color) clickedButton.getClientProperty("cardColor");  
            
            if (botonSeleccionado1 == null) {
            	botonSeleccionado1 = clickedButton;
            	botonSeleccionado1.setBackground(buttonColor);
            } else if (botonSeleccionado2 == null && botonSeleccionado1 != clickedButton) {
            	botonSeleccionado2 = clickedButton;
                botonSeleccionado2.setBackground(buttonColor);
                System.out.println(botonSeleccionado1.getBackground());
                System.out.println(botonSeleccionado2.getBackground().toString());

                if (colorCards.get(botones.indexOf(botonSeleccionado1)).equals(colorCards.get(botones.indexOf(botonSeleccionado2)))) {
                	botones.remove(botonSeleccionado1);
                    botones.remove(botonSeleccionado2);
                    getContentPane().remove(botonSeleccionado1);
                    getContentPane().remove(botonSeleccionado2);
                    revalidate();
                    repaint();
                    botonSeleccionado1 = null;
                    botonSeleccionado2 = null;

                    if (botones.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "¡Felicidades! ¡Has ganado!");
                        dispose();
                    }
                } else {
                    Timer timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	botonSeleccionado1.setSelected(false);
                        	botonSeleccionado2.setSelected(false);
                        	botonSeleccionado1.setSelected(true);
                        	botonSeleccionado2.setSelected(true);
                        	botonSeleccionado1.setBackground(null);
                        	botonSeleccionado2.setBackground(null);
                        	botonSeleccionado1 = null;
                        	botonSeleccionado2 = null;
                            ((Timer) e.getSource()).stop();
                            revalidate();
                            repaint();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        }
    }
}