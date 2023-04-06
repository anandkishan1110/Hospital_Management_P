package Practise_pck;

import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		boolean rs=isArmStrong(n);
		if(rs==true)
			System.out.println("Armstrong");
		else
			System.out.println("Not Armstrong");
	}
	public static boolean isArmStrong(int x)
	{
		int dc=isDigiCount(x);
		int sum=0,temp=x;
		do {
			int r=x%10;
			sum=sum+fact(r,dc);
			x=x/10;
		}while(x!=0);
		return sum==temp;
	}
	public static int isDigiCount(int y)
	{
		int count=0;
		do {
			y=y/10;
			count++;
		}while(y!=0);
		return count;
	}
	public static int fact(int a,int b) {
		int pro=1;
		do {
			pro=pro*a;
			b--;
		}while(b!=0);
		return pro;
	}

}
