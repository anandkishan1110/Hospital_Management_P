package Practise_pck;

import java.util.Scanner;

public class SumOfNatural {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the range");
		int n=sc.nextInt();
		int nSum=isNatural(n);
		System.out.println(nSum);

	}
	public static int isNatural(int x)
	{
		int sum=0;
		for(int i=1;i<=x;i++) {
			sum=sum+i;
		}
		return sum;
	}

}
