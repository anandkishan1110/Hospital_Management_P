package Practise_pck;

public class PrintingWithOutLoop {

	public static void main(String[] args) {
		int x=1;
		printNum(x);

	}
	public static void printNum(int y)
	{
		if(y<=100)
		{
			System.out.print(y+" ");
			printNum(y+1);
		}
		
	}

}
