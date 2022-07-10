package com.greatlearninglab2.paymoney;

import java.util.Scanner;

public class PayMoney {
	
	//declare class variables
	private int[] transactionsArr;//an integer array to store transactions
	private int transactionsSize;//an integer to store number of transactions
	private int target;//an integer value to store the target
	
	//Method name: readTransactions
	//Arguments: a Scanner object to read input from user
	//Returns: nothing
	//Description: reads transaction size from user
	public void readTransactionsSize(Scanner scanObj)	{
		
		//ask user to enter size of transactions array
		System.out.println("Enter the size of transaction array");
		
		//read the entered value
		this.transactionsSize = scanObj.nextInt();
		
		//dynamically sets the size of transactionsArr according to entered size
		this.transactionsArr=new int[this.transactionsSize];
		
	}
	
	//Method name: readTransactions
	//Arguments: a Scanner object to read input from user
	//Returns: nothing
	//Description: populates transactions array
	public void readTransactions(Scanner scanObj) {
		
		//ask user to enter values of array
		System.out.println("Enter the values of array");
		
		//traverse through transactionsArr and populate values at each index
		for(int i=0;i<this.transactionsSize;i++) {
			this.transactionsArr[i]=scanObj.nextInt();
		}
	}
	
	//Method name: readTarget
	//Arguments: a Scanner object to read input from user
	//Returns: nothing
	//Description: read the transaction target from user
	public void readTarget(Scanner scanObj) {
		
		//ask user to enter the value of target
		System.out.println("Enter the value of target");
		
		//read the value entered and store in target variable
		this.target=scanObj.nextInt();
	}
	
	//Method name: checkTargetAchieved
	//Arguments: a Scanner object to read needed input
	//Returns: nothing
	//Description: checks from transactions array if target is achieved and prints the message accordingly
	public void checkTargetAchieved(Scanner scanObj) {
	
		char checkNewTarget;//a char variable to repeat the target check
		int sumTransactions=0;//integer to sum up the transactions
		boolean status=false;//a flag to check status
		int transCount=0;//integer to count the transactions after which target is achieved
	
		do {
			
			//loop through transactionsArr
			for(int i=0;i<this.transactionsSize;i++) {
				
				//add up each transaction
				sumTransactions+=this.transactionsArr[i];
				
				if(sumTransactions>=this.target)//check if current sum is greater than or equal to target if so
				{
					transCount=i+1;//increment transaction count
					status=true;//set status to true and break from for loop
					break;
				}
			}
			
			if(status) {//check if status is true if so print the target achieved message
				System.out.println("Target achieved after "+transCount+" transactions");
			}
			else {//otherwise print failure message
				System.out.println("Given target is not achieved");
			}
			
			//ask user if he wants to check another target
			System.out.println("Do you want to check another target? (y/n): ");
			
			//reads the entered y or n value from user
			checkNewTarget=scanObj.next().charAt(0);
			
			//convert the entered character to upper case
			checkNewTarget=Character.toUpperCase(checkNewTarget);
			
			if(checkNewTarget=='Y') {//check if Y is entered if so
				readTarget(scanObj);//repeat reading the target and rest
			}
			else {//otherwise print goodbye message
				System.out.println("Goodbye!");
			}
		}while(checkNewTarget=='Y');//repeat if user entered Y
		
		
	}
}
