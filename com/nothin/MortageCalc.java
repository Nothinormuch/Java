package com.nothin;

import java.util.Scanner;
import java.text.NumberFormat;

public class MortageCalc{
	public static void main(String[] args){
		// Static Variables
		final int months = 12;
		final int percent = 100;
		// Variables
		long principal;
		float anualRate;
		short years;

		// Createing a Scanner Object
		Scanner stdin = new Scanner(System.in);
		
		// Taking the input
		while(true){
			System.out.print("Enter the principal amount ($1k - $1B): ");
			principal = stdin.nextLong();
		
			if (principal >= 1000 && principal <= 1_000_000_000){
				break;
			}

			System.out.println("Enter a principal amount between $1k and $1B!");
		}
		while(true){
			System.out.print("Enter the anual rate of interest: ");
			anualRate = stdin.nextFloat();

			if (anualRate >= 0 && anualRate < 100){
				break;
			}

			System.out.println("Enter a non negative rate lower than 100%!");
		}
		while(true){
			System.out.print("Enter the time period(in years): ");
			years = stdin.nextShort();

			if (years >= 0){
				break;
			}

			System.out.println("Years can not be negative, try a positive number of years!");
		}

		// Calculating Monthly Rate and Number of payments
		float monthlyRate = anualRate/months/percent;
		float payments = years * months;
		
		// Calculating the Mortage
		double mortage = principal * ((Math.pow((1+monthlyRate),payments)*monthlyRate)/(Math.pow((1+monthlyRate),payments)-1));

		
		// Printing the results
		System.out.println("The Mortage is: "+NumberFormat.getCurrencyInstance().format(mortage));
	}
}
