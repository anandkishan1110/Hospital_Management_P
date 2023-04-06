package Practise_pck;

import java.util.Scanner;

public class StrongNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		boolean rs=isStrong(n);
		if(rs==true)
			System.out.println("Strong Number");
		else
			System.out.println("Not Strong Number");
	}
	public static boolean isStrong(int x)
	{
		int sum=0,temp=x;
		do {
			int r=x%10;
			sum=sum+pow(r);
			x=x/10;
		}while(x!=0);
		return sum==temp;
	}
	public static int pow(int a)
	{
		int p=1;
		do {
			p=p*a;
			a--;
		}while(a!=0);
		return p;
	}

}
