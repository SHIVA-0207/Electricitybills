public class AddArray 
{
    public static void main(String[]args)
    {
        int sum=0;
        int[]n = {1,2,3,4,5,6,7,8,9};
        for(int i:n)
        {
            sum+=i;
        }
        double avg=(double)sum/n.length;
        System.out.println("Sum: "+sum);
        System.out.println("Avg: "+avg);
    }
    
}
