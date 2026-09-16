import java.util.Scanner;
public class EBReading
{
public static void main(String[]args)
{
	int CNumber,pr,cr;
	String name,type;
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the Customer number");
	CNumber=s.nextInt();
	System.out.println("Enter the Name");
	name=s.next();
	System.out.println("Enter the previous meter reading");
	pr=s.nextInt();
	System.out.println("Enter the current meter reading");
	cr=s.nextInt();
	System.out.println("Enter the connection type");
	type=s.next();
}
}
