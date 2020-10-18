/**
 * Sieve of Eratosthenes is a way to to generate prime numbers.
 */
import java.util.Arrays;

public class SieveOfEratosthenes {

    /**
     * Storing fate of all numbers.
     */
    private boolean primes[] = new boolean[ 1000 ];

    public static void main( String ... args ) {

        SieveOfEratosthenes sieve = new SieveOfEratosthenes();
        sieve.generate();

    }

    private void generate() {

        /*
         * Let's hope that initially all of them are prime.
         */
        Arrays.fill( primes, true );

        for( int base = 2; base < 1000; base ++ ) {

            /*
             * We would mark other multiples of this number as non-prime if
             * current number itself is marked to be prime.
             */
            if( primes[ base ] ) {

                for( int neighbour = base + 1; neighbour < 1000; neighbour++ ) {
                    if( neighbour % base == 0 ) {
                        primes[ neighbour ] = false;

                    }

                }

            }

        }

        printAllPrimes();

    }

    private void printAllPrimes() {

        for( int base = 2; base < 1000; base++ ) {

            if( primes[ base ] ) {
                System.out.println( base );
            }
        }
    }
}
                             
