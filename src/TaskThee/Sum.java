package TaskThee;
import java.math.BigInteger;

public class Sum {	
	public static void main(String[] args)
	{
		// for processing large numbers
	BigInteger fact;
	// factorial of 1! is 1
	fact= new BigInteger("1");
	// Loop to calculate the factorial of 100!
	for (int i = 1; i <= 100; i++)
	{
		fact = fact.multiply(BigInteger.valueOf(i));// multiply all the numbers in order
	}
		System.out.println(fact);
		System.out.println(sumDigits(fact.toString()));
		}	
	// sum of elements in a row
	private static int sumDigits(String s){
		int sum = 0;
		for (int i = 0; i < s.length(); i++)
		{
			int j = Integer.parseInt(s.substring(i,i+1));// Select an element 
			sum=sum+j;// sum the current item (the amount) with the following
		}
		return sum;
		}
	}


