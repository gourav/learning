/**
 * PerfectNumberSeries prints all perfect numbers upto 1000.
 */
public class PerfectNumberSeries {

    public static void main( String ... args ) {

        for( int number = 2; number <= 1000; number++ ) {

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
