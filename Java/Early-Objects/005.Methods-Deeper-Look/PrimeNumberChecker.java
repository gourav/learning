/**
 * Prime Number Checker checks if a number is prime.
 */
import java.util.Scanner;

public class PrimeNumberChecker {

    public static void main( String ... args ) {

        Scanner scanner = new Scanner( System.in );
        System.out.print( "Enter a number to check if it is prime : " );
        int number = scanner.nextInt();

        if( isPrimeNumber( number )) {
            System.out.printf( "%d is prime.%n", number );
        } else {
            System.out.printf( "%d is not prime.%n", number );
        }

    }

    public static boolean isPrimeNumber( int number ) {

        int limit = (int) Math.abs( Math.sqrt( number ));
        for( int factor = 2; factor <= limit; factor++ ) {
            if( number % factor == 0 ) {
                return false;
            }
        }

        return true;
    }
}
