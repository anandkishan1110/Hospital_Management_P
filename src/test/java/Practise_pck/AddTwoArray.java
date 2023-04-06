package Practise_pck;

import java.util.Scanner;

public class AddTwoArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("For first matrix");
		System.out.println("Enter the row size");
		int r1=sc.nextInt();
		System.out.println("Enter the coloumn size");
		int c1=sc.nextInt();
		int [][]a=new int[r1][c1];
		System.out.println("Enter the "+r1*c1+" values for first matrix");
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("user entered values");
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();	
		}
		
	System.out.println("For second matrix");
	System.out.println("Enter the row size");
	int r2=sc.nextInt();
	System.out.println("Enter the coloumn size");
	int c2=sc.nextInt();
	int [][]b=new int [r2][c2];
	System.out.println("Enter the "+r2*c2+" values for second matrix");
	for(int i=0;i<b.length;i++) {
		for(int j=0;j<b[i].length;j++) {
			b[i][j]=sc.nextInt();
		}
	}
	System.out.println("User entered vlaue");
	for(int i=0;i<b.length;i++) {
		for(int j=0;j<b[i].length;j++) {
			System.out.print(b[i][j]+" ");
		}
		System.out.println();
	}
	if(a.length==b.length && a[0].length==b[0].length) {
		System.out.println("Pattern matched");
		sumOfMatrix(a,b);
	}
		else
		{
			System.out.println("Pattern mismatched");
		}
	}
	public static void sumOfMatrix(int[][] a,int[][] b) {
		int [][]c=new int[a.length][a[0].length];
		for(int i=0;i<c.length;i++)
		{
			for(int j=0;j<c[i].length;j++) {
				c[i][j]=a[i][j]+b[i][j];
			}
			
		}
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[i].length;j++) {
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}

}
