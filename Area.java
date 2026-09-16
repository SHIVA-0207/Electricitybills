import java.util.Scanner;
public class Area
{
	public static void main(String[]args)
	{
		double a,b,c;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Rectangle Length:");
		a=s.nextDouble();
		System.out.println("Enter Rectangle Breath:");
		b=s.nextDouble();
		c=a*b;
		System.out.println("The Area of the Rectangle:"+c);
	}
}