package com.greatlearninglab2.currency;
import java.util.Scanner;

public class CurrencyDenom {
	
	//declare member variables for the class
	private int denominationsSize;//an integer to read the denominations size
	private int[] denominations;//an integer array to store the denominations available
	private int amountPaid;//an integer to store the amount paid by the user
	
	//Method name: readDenominations
	//Arguments: a Scanner object to read inputs
	//Returns: Nothing
	//Description: read denominations from user and sort the denominations in descending order
	public void readDenominations(Scanner sc){
		
		//ask user to enter size of currency denominations
		System.out.println("Enter the size of currency denominations");
		
		//read the entered denominations size
		this.denominationsSize=sc.nextInt();
		
		//dynamically set the size of the denominations array
		this.denominations=new int[this.denominationsSize];
		
		//Ask the user to enter the currency denominations values
		System.out.println("Enter the currency denominations value");
		
		//traverse through the denominations array and populate the array
		for(int i=0;i<this.denominationsSize;i++) {
			this.denominations[i]=sc.nextInt();
		}
		
		//call sortDenominations method to quickSort the denominations array in descending order
		sortDenominations(0,this.denominationsSize-1);
		
		//print the sorted array
		/*System.out.println("Sorted denominations: ");
		for(int i=0;i<this.denominationsSize;i++)
			System.out.println(this.denominations[i]);*/
	}
	
	//Method name: readAmountPaid
	//Arguments: a Scanner object to read inputs
	//Returns: nothing
	//Description: reads amount user wants to pay
	public void readAmountPaid(Scanner sc) {
		
		//ask user to enter the amount he/she wants to pay and read the entered value
		System.out.println("Enter the amount you want to pay");
		this.amountPaid=sc.nextInt();
	}
	
	//Method name: sortDenominations
	//Arguments: two integers telling low and high indexes for the array
	//Returns: nothing
	//Description: applies QUICK sort algorithm on denominations array and sorts it in descending order
	private void sortDenominations(int low,int high) {
		//check if low is less than high
		if(low<high) {
			
			//get the pivot value from the partition method by passing array, low and high values as arguments
			int pi=partition(this.denominations,low,high);
			
			//divide the lower half of array according to pivot value and recall sort method
			sortDenominations(low,pi-1);
			
			//divide the upper half of array according to pivot value and recall sort method
			sortDenominations(pi+1,high);
		}
	}
	
	//Method name: swap
	//Arguments: an integer array, and two integers which are indexes of elements
	//Returns: nothing
	//Description: swaps two array elements according to the index values given as arguments
	private void swap(int[] arr, int i, int j)
	{
		//take a temp integer and store arr[i] in it
	    int temp = arr[i];
	    
	    //change arr[i] value by assigning arr[j] to it
	    arr[i] = arr[j];
	    
	    //change arr[j] with temp
	    arr[j] = temp;
	}
	
	//Method name: partition
	//Arguments: the denominations array, two integers which are low index and high index of partition
	//Returns: pivot value to partition the array
	//Description: 	sets the pivot element and moves all elements greater than pivot to left side of pivot index
	//and all the elements less than pivot to right side of pivot as we want descending order
	private int partition(int[] denom, int low, int high) {
		
		//assume last element of array, that is, element at high index as pivot
		int pivot=denom[high];
		
		//get lower index as low-1
		int i=(low-1);
		
		//traverse the denom array from low to high locations
		for(int j=low;j<=high-1;j++) {
			
			//check if denomination value at j is greater than pivot
			if(denom[j]>pivot) {
				//if so increment i and swap i and j elements
				i++;
				swap(denom,i,j);
			}
		}
		
		swap(denom,i+1,high);
		return (i+1);
	}

	//Method name: getMinNotes
	//Arguments: none
	//Returns: nothing
	//Description: calculates and prints the minimum possible notes to give from the denominations available
	public void getMinNotes() {
		
		//checks if amountPaid value is 0. If so skips the rest of the computations
		if(this.amountPaid==0) return;
		
		//declare an integer targetSum and sets its value as 0
		int targetSum=0;
		
		//print the output message for payment approach
		System.out.println("Your payment approach in order to give min no of notes will be");
		
		//loop through denominations array
		for(int i=0;i<this.denominationsSize;i++) {
			int noteCount=0;//declare an integer to calculate note count and set it to 0
			
			//repetitively adds current array value until the time when it is added sum exceeds amountPaid value
			while(targetSum+this.denominations[i]<=this.amountPaid) {
								
				targetSum+=this.denominations[i];//adds current denomination value to targetSum
				
				//check if targetSum subtracted from amountPaid is greater than 0. This means we can re-run while loop again
				if(this.amountPaid-targetSum>=0)
				{
					//subtract targetSum from amountPaid
					this.amountPaid-=targetSum;
				}
				
				noteCount++;//increment note count
				targetSum=0;//and reset targetSum value to 0
			}
			
			if(noteCount>0) {//check if noteCount is greater than 0. if so then we have notes selected for this denomination, print it
				System.out.println(this.denominations[i]+" : "+noteCount);
			}
			
		}
	}
	
}
