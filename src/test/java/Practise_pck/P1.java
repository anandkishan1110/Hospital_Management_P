package Practise_pck;

import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			for(int j=i;j>=1;j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
