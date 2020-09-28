/**
 * PerfectNumberSeries prints all perfect numbers upto decided input.
 */
import java.util.Scanner;

public class PerfectNumberSeries {

    public static void main( String ... args ) {

        Scanner scanner = new Scanner( System.in );
        System.out.print( "Please enter maximum limit to check perfect numbers under : " );
        int limit = scanner.nextInt();

        for( int number = 2; number <= limit; number++ ) {

            if( isPerfectNumber( number )) {
                System.out.printf( "%d%n", number );

            }

        }
    }

    public static boolean isPerfectNumber( int number ) {

        int sum = 0;
        for( int factor = 1; factor <= ( number / 2 ); factor++ ) {
            if( number % factor == 0 ) {
                sum += factor;
            }
        }

        if( sum == number ) {
            return true;
        }

        return false;
    }
}
