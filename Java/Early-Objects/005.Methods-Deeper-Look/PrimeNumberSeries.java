/**
 * PrimeNumberSeries prints list of prime numbers under 10000.
 */
public class PrimeNumberSeries {

    public static void main( String ... args ) {

        for( int number = 1; number <= 10000; number++ ) {

            if( isPrimeNumber( number )) {
                System.out.printf( "%d%n", number );
            }

        }
    }

    public static boolean isPrimeNumber( int number ) {

        for( int factor = 2; factor <= ( number / 2 ); factor++ ) {
            if( number % factor == 0 ) {
                return false;
            }
        }

        return true;
    }
}
