import java.util.Scanner;
import java.lang.ProcessBuilder;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.io.*;

public class tempconvtr
{
	/**
	
	*/
	static void pressAnyKeyToContinue()
	{ 
		System.out.print("\nPress Enter key to continue...");
		try { System.in.read(); }  
		catch(Exception e) {}
		System.out.print("\n");
	}
	/**

	*/
	static void clrscr()
	{
		//Clears Screen in java
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else {
				//Runtime.getRuntime().exec("clear");
				System.out.print("\033[H\033[2J");  
				System.out.flush();  
				}
		} catch (IOException | InterruptedException ex) {}
	}
	/**

	*/
	public static void main (String [] args)
	{
		
		Scanner keyboard = new Scanner (System.in);
		DecimalFormat df = new DecimalFormat("###,###,###,###,###.00");
		
		double C, F, K;
		double fromTempVal, toTempVal = 0.0;
		char fromTempTyp, toTempTyp;
		
		String fromTemp = "";
		String toTemp = "";
		
		clrscr();
		
		System.out.print("\n\n\n\n");
		System.out.print("********************** Temperature ");
		System.out.println("Converter ***********************");
		System.out.print("** Conversion between celsius (C), ");
		System.out.println("Fahrenheit (F), and Kelvin (K) **\n\n");
		
		System.out.println("  Convert");
		System.out.print("     from (C, F, or K): ");
		fromTempTyp = ((keyboard.next()).toUpperCase()).charAt(0);
		System.out.print("     to (C, F, or K): ");
		toTempTyp = ((keyboard.next()).toUpperCase()).charAt(0);
		System.out.print("  Enter Temperature: ");
		fromTempVal = Double.parseDouble(keyboard.next());
		
		if (((fromTempTyp == 'C') && (toTempTyp == 'C')) ||
			((fromTempTyp == 'F') && (toTempTyp == 'F')) ||
			((fromTempTyp == 'K') && (toTempTyp == 'K')))
			toTempVal = fromTempVal;
		else if ((fromTempTyp == 'C') && (toTempTyp == 'F'))
		{
			// Celsius to Fahrenheit
			C = fromTempVal;
			F = 1.80*C + 32;
			toTempVal = F;
		}
		else if ((fromTempTyp == 'C') && (toTempTyp == 'K'))
		{
			// Celsius to Kelvin: 
			C = fromTempVal;
			K = C + 271.15;
			toTempVal = K;
		}
		else if ((fromTempTyp == 'F') && (toTempTyp == 'C'))
		{
			// Fahrenheit to Celsius
			F = fromTempVal;
			C = (F - 32.0)/1.80;
			toTempVal = C;
		}
		else if ((fromTempTyp == 'F') && (toTempTyp == 'K'))
		{
			// Fahrenheit to Kelvin
			F = fromTempVal;
			K = 5.0/9.0*(F - 32.0) + 273.15;
			toTempVal = K;
		}
		else if ((fromTempTyp == 'K') && (toTempTyp == 'C'))
		{
			// Kelvin to Celsius
			K = fromTempVal;
			C = K - 273.15;
			toTempVal = C;
		}
		else if ((fromTempTyp == 'K') && (toTempTyp == 'F'))
		{
			// Kelvin to Fahrenheit
			K = fromTempVal;
			F = 1.8*(K - 273.0) + 32.0;
			toTempVal = F;
		}
		else
		{
			System.out.println("Invalid temperature type, terminating..");
			System.exit(0);
		}

		String msg = "\n  " + Double.toString(fromTempVal) + " degrees";
		switch (fromTempTyp)
		{
			case 'C': fromTemp = " Celsius";
					  msg += fromTemp;
					  break;
			case 'F': fromTemp = " Fahrenheit";
					  msg += fromTemp;
					  break;
			case 'K': fromTemp = " Kelvin";
					  msg += fromTemp;
					  break;
			default: 
				{
				System.exit(0);
				System.out.println("Invalid temperature type, terminating..");
				}
				break;
		}

		msg +=  " is equal to " + Double.toString(toTempVal) + " degrees";
		
		switch (toTempTyp)
		{
			case 'C': toTemp = " Celsius.";
					  msg += toTemp;
					  break;
			case 'F': toTemp = " Fahrenheit.";
					  msg += toTemp;
					  break;
			case 'K': toTemp = " Kelvin.";
					  msg += toTemp;
					  break;
			default: 
				{
				System.exit(0);
				System.out.println("Invalid temperature type, terminating..");
				}
				break;
		}
		
		//System.out.println(msg+"\n");
		
		System.out.print("\n");
		
		String txt = "  %.2f degrees %s is equal to %.2f degrees %s";
		
		System.out.printf("  %.2f degrees%s is equal to %.2f degrees%s", fromTempVal, fromTemp, toTempVal, toTemp);
		System.out.print("\n");
				
		pressAnyKeyToContinue();
	}
}
