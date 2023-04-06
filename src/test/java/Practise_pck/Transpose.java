package Practise_pck;

import java.util.Scanner;

public class Transpose {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the row size");
		int r=sc.nextInt();
		System.out.println("Enter the coolumn size");
		int c=sc.nextInt();
		int [][]a=new int[r][c];
		System.out.println("Enter the "+r*c+" values ");
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("user entered the array");
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
        int [][]b=isTranpose(a);
        for(int i=0;i<b.length;i++)
        {
        	for(int j=0;j<b[i].length;j++)
        	{
        		System.out.print(b[i][j]+" ");
        	}
        	System.out.println();
        }
	}
	public static int[][] isTranpose(int [][]c)
	{
		int [][]d=new int[c.length][c[0].length];
		for(int i=0;i<d.length;i++)
		{
			for(int j=0;j<d[i].length;j++)
			{
				d[i][j]=c[j][i];
			}
		}
		return d;
	}

}
