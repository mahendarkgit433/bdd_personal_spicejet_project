package practice;

import java.util.Scanner;

public class StringRev
{
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string value");
		String s = sc.next();
		int len = s.length();
		String rev="";
		sc.close();
		for(int i=0;i<len;i++)
		{
			rev=s.charAt(i)+rev;
		}
		System.out.println(rev);
	}
}
