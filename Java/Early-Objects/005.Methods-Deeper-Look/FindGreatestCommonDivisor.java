/**
 * Greatest Common Divisor finds GCD of two numbers.
 */
import java.util.Scanner;

public class FindGreatestCommonDivisor {

    public static void main( String ... args ) {

        Scanner scanner = new Scanner( System.in );
        
        System.out.print( "Enter first number : " );
        int first = scanner.nextInt();

        System.out.print( "Enter second number : " );
        int second = scanner.nextInt();

        int gcd = findGcd( Math.min( first, second ), Math.max( first, second ));
        System.out.printf( "GCD of %d and %d is %d.", first, second, gcd );

    }

    public static int findGcd( int first, int second ) {

        int remainder = second % first;
        if( remainder == 0 ) {
            return first;
        } 

        return findGcd( remainder, first );
    }
}
