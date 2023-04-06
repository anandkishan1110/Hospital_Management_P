package Practise_pck;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		boolean rs=isPrime(n);
		if(rs==true)
			System.out.println("prime number");
		else
			System.out.println("Not prime number");
	}
	public static boolean isPrime(int x) {
		for(int i=2;i<=x/2;i++) {
			if(x%i==0)
				return false;
		}
		return true;
	}

}
