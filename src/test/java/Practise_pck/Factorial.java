package Practise_pck;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		int fact=isFactorial(n);
		System.out.println(fact);
	}
	public static int isFactorial(int x)
	{
		int f=1;
		do {
			f=f*x;
			x--;
		}while(x!=0);
		return f;
	}

}
