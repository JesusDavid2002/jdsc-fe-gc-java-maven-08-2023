package com.ejerciciosTA29.ejercicio1;

import java.util.Scanner;

//import com.google.gson.Gson;

public class MainApp 
{
    public static void main( String[] args )
    {
	    Scanner scn = new Scanner (System.in);
		System.out.println("Introduce el ancho de la interfaz: ");
		int ancho = scn.nextInt();
		System.out.println("Introduce el alto de la interfaz: ");
		int alto = scn.nextInt();
		
        InterfazBasica interfaz = new InterfazBasica(alto, ancho);
        interfaz.setVisible(true);
    }
}
