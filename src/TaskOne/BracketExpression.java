package TaskOne;
import java.util.Scanner;
public class BracketExpression {	
	public static void main(String[] args) {		
		System.out.println("Enter the number of the calculation : ");
		Scanner scan = new Scanner(System.in);
		int n= Integer.valueOf(scan.nextInt());
		scan.close();
		//Consider that the entered value is greater than or equal to 0.
		if(n>=0){
		long C = factorial((2*n))/(factorial(n)*factorial((n+1)));
		System.out.println("Result="+C);
		System.out.println("Result="+Catalan(n));
		}
		else {System.out.println("Not correct number");}		
	}
	
	//// Recursive function to calculate the number n Catalan
	//C[3] = C[0] * C[2] + C[1] * C[1] + C[2] * C[0] = 1 * 2 + 1 * 1 + 2 * 1 = 2 + 1 + 2 = 5
	static int Catalan( int n ) {		 
		int i, sum;		
		// If n = 0, the zero number Catalana - is 1
		if ( n==0 ) { return 1; }
		else{		
		sum= 0;		// Temporary variable, which will accumulate the sum
		for ( i= 0; i<n; i++ ) {
			// To already accumulated the sum of the product of two numbers add Catalan
		   sum=sum+Catalan( i )*Catalan( (n-1)-i );
		}
		return sum;	
		}
	}
	
	//C(n) = (2n)!/n!(n+1)!
	public static long factorial( int n )
    {
		return (n == 0) ? 1 : n * factorial(n - 1);
    }
}
