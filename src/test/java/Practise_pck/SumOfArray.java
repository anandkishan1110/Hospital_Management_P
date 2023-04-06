package Practise_pck;

import java.util.Scanner;

public class SumOfArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the array size");
		int n=sc.nextInt();
		int []ar=new int[n];
		System.out.println("Enter the "+n+" value of array");
		for(int i=0;i<ar.length;i++) {
			ar[i]=sc.nextInt();
		}
		System.out.println("User enter the array");
		for(int i=0;i<ar.length;i++) {
			System.out.print(ar[i]+" ");
		}
		int sum=sumOfArray(ar);
		System.out.println("Sum of array "+sum);
	}
	public static int sumOfArray(int []x) {
		int s=0;
		for(int i=0;i<x.length;i++) {
			s=s+x[i];
		}
		return s;
	}

}
