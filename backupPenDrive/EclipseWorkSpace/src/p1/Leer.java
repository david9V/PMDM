package p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {
	
	public static String dato() {
		String dato = "";
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader flujoE = new BufferedReader(isr);
			dato = flujoE.readLine();
		} catch(IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return dato;
	}
	
	public static int datoInt() {
		try {
			return Integer.parseInt(dato());
		} catch(NumberFormatException e) {
			return Integer.MIN_VALUE;
		}
	}
	
	public static short datoShort() {
		try {
			return Short.parseShort(dato());
		} catch(NumberFormatException e) {
			return Short.MIN_VALUE;
		}
	}
	
	public static long datoLong() {
		try {
			return Long.parseLong(dato());
		} catch(NumberFormatException e) {
			return Long.MIN_VALUE;
		}
	}
	
	public static Float datoFloat() {
		try {
			return Float.parseFloat(dato());
		} catch(NumberFormatException e) {
			return Float.MIN_VALUE;
		}
	}
	
	public static double datoDouble() {
		try {
			return Double.parseDouble(dato());
		} catch(NumberFormatException e) {
			return Double.MIN_VALUE;
		}
	}
	
	
	

}
