package com.greatlearninglab2.currency;

import java.util.Scanner;

public class CurrencyDriver {
	public static void main(String[] args) {
		//Declare a scanner object to read needed input
		Scanner sc=new Scanner(System.in);
		
		//Create an object to class CurrencyDenom
		CurrencyDenom currObj=new CurrencyDenom();
		
		//call the method readDenominations to read in the denominations available
		currObj.readDenominations(sc);
		
		//call the method readAmountPaid to read the amount paid by user
		currObj.readAmountPaid(sc);
		
		//call the method getMinNotes to get minimum possible notes to give
		currObj.getMinNotes();
		
		//close the scanner object
		sc.close();
	}
}
