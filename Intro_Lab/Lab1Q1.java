import java.util.*;
class Lab1Q1
{
	public static void main(String arr[])
	{
		Scanner sc=new Scanner(System.in);
		int i,n,s=0;
		while(true)
		{
    		System.out.print("Enter an integer (0 to quit):");
    		n=sc.nextInt();
    		if(n == 0)
    		{
    		    System.out.println("Good Bye!");
    		    break;
    		}
    		else
    		{
        		for(i=1;i<n;i++)
        		{
        			if(n%i==0)
        			s+=i;
        		}
        		if(s==n)
        			System.out.println("Perfect Number");
        		else if(s>n)
        			System.out.println("Abundant Number");
        		else
        			System.out.println("Deficient Number");	
    		}
		}
	}
}
