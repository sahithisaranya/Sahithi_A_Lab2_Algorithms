package com.greatlearninglab2.paymoney;

import java.util.Scanner;

public class PayMoneyDriver {

	public static void main(String[] args) {
		
		//declare a Scanner class object
		Scanner scanObj=new Scanner(System.in);
		
		//create an object to class PayMoney
		PayMoney payObj=new PayMoney();
		
		//call method readTransactionsSize to read the size of transactions array
		payObj.readTransactionsSize(scanObj);
		
		//call method readTransactions to read all the entered transactions
		payObj.readTransactions(scanObj);
		
		//call method readTarget to read the target value
		payObj.readTarget(scanObj);
		
		//call method checkTargetAchieved to check if target is achieved or not
		payObj.checkTargetAchieved(scanObj);
		scanObj.close();
	}

}
