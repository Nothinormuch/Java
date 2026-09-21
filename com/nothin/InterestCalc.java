package com.nothin;

import java.util.*;
import java.text.*;

public class InterestCalc{
	public static void main(String[] args){
		// Setting the static variables
		final int percent = 100;


		// Making the scanner object
		Scanner stdin = new Scanner(System.in);
		

		// Variables
		long pAmount;
		float rate;
		byte years;



		// Taking the Input from the user
		while (true){
			System.out.print("Enter the Principal Amount ($1K - $1B): ");
			pAmount = stdin.nextLong();
			
			if (pAmount >= 1_000 && pAmount <= 1_000_000_000){
				break;
			}
			System.out.println("Enter an amount between $1k and $1B!");
		}

		while (true){
			System.out.print("Enter the rate of interest: ");
			rate = stdin.nextFloat();
			
			if (rate >= 0 && rate < 100){
				break;
			}
			System.out.println("Enter a non negative rate lower than 100%!");
		}

		while (true){
			System.out.print("Enter the period of loan in years: ");
			years = stdin.nextByte();
			
			if (years >= 0){
				break;
			}
			System.out.println("Enter a positive amount of years!");
		}
		

		// Caculating the Final Interest Amount
		float iAmount = ((pAmount/percent)*rate)*years;

		
		// Printing the result
		System.out.println("\nInterest Amount: "+NumberFormat.getCurrencyInstance().format(iAmount));
		
		System.out.println("Total Amount: "+NumberFormat.getCurrencyInstance().format(iAmount+pAmount));
	}
}
