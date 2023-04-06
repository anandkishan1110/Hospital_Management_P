package Practise_pck;

import java.util.Scanner;

public class BiggAndSmallestArray {

	public static void main(String[] args) {
	Scanner sc=new Scanner("System.in");
	System.out.println("Enter the array size");
	int r=sc.nextInt();
	int []ar=new int[r];
	System.out.println("Enter the "+r+" value of array");
	for(int i=0;i<ar.length;i++)
	{
		ar[i]=sc.nextInt();
	}
	System.out.println("User entered the array values");
	for(int i=0;i<ar.length;i++)
	{
		System.out.print(ar[i]+" ");
	}
	int bigArray=isBiggest(ar);
	int smalllArray=isSmallest(ar);
	System.out.println("Biggest array "+bigArray);
	System.out.println("Smallest array "+smalllArray);
	}
	public static int isBiggest(int []x) {
		int big=x[0];
		for(int i=0;i<x.length;i++) {
			if(x[i]>big)
				big=x[i];
		}
		return big;
	}
	public static int isSmallest(int []y) {
		int small=y[0];
		for(int i=0;i<y.length;i++) {
			if(y[i]<small)
				small=y[i];
		}
		return small;
	}
}
