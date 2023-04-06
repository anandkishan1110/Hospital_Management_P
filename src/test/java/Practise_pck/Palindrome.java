package Practise_pck;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENter the number");
		int n=sc.nextInt();
		boolean rs=isPalindrome(n);
		if(rs==true)
			System.out.println("Palindrome");
		else
			System.out.println("Not palindrome");

	}
	public  static boolean isPalindrome(int x) {
		int rev=0,temp=x;
		do {
			int r=x%10;
			rev=rev*10+r;
			x=x/10;
		}while(x!=0);
		return temp==rev;
		
	}

}
