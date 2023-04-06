package Practise_pck;

import java.util.Scanner;

public class ReverseNum {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		int reverse=isReverse(n);
		System.out.println("Reverse of "+n+" "+reverse);
	
	}
	public static int isReverse(int x) {
		int rev=0;
		do {
			int r=x%10;
			rev=rev*10+r;
			x=x/10;
		}while(x!=0);
		return rev;
	}

}
