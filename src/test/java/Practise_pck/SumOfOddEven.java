package Practise_pck;

import java.util.Scanner;

public class SumOfOddEven {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		int evenSum=isEven(n);
		int oddSum=isOdd(n);
		System.out.println("Even sum of "+n+" digit is "+evenSum);
		System.out.println("Odd sum of "+n+" digit is "+oddSum);

	}
	public static int isEven(int x)
	{
		int evsum=0;
		do {
			int r=x%10;
			if(r%2==0)
				evsum=evsum+r;
			x=x/10;
		}while(x!=0);
		return evsum;
		
	}
	public static int isOdd(int y)
	{
		int odsum=0;
		do {
			int r=y%10;
			if(r%2==1)
				odsum=odsum+r;
			y=y/10;
		}while(y!=0);
		return odsum;
	}

}
