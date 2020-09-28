/**
 * PerfectNumberChecker checks if a input is a perfect number.
 */
import java.util.Scanner;

public class PerfectNumberCheck {

    public static void main( String ... args ) {
        
        Scanner scanner = new Scanner( System.in );
        System.out.print( "Enter a number to check for perfect number : " );
        int toCheck = scanner.nextInt();

        if( checkForPerfectNumber( toCheck )) {
            System.out.printf( "%d is perfect number.%n", toCheck );
        } else {
            System.out.printf( "%d isn't a perfect number.%n", toCheck );
        }

    }

    private static boolean checkForPerfectNumber( int number ) {

        int sum = 0;
        for( int factor = 1; factor <= ( number / 2 ); factor++ ) {
            if( number % factor == 0 ) {
                sum += factor;
            }
        }

        return sum == number;
    }
}
