package Practise_pck;

import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		boolean rs=isPerfect(n);
		if(rs==true)
			System.out.println("perfect number");
		else
			System.out.println("Not perfect number");
	}
	public static boolean isPerfect(int x)
	{
		int sum=0;
		for(int i=1;i<=x/2;i++) {
			if(x%i==0)
				sum=sum+i;
			if(sum==x)
				return true;
		}
		return false;
	}

}
