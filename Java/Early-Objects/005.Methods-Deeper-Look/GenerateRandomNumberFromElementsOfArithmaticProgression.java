/**
 * This example demostrates how can we select random numbers from sequence
 * 2, 5, 6, 11, 14.
 *
 * What can be observed here is that difference between each of the numbers of 3. So, we can do this like.
 *
 * number = 2 + 3 * randomNumbers.nextInt( 5 );
 *
 * or generically:
 * number = shiftingValue ( starting-number ) + ( difference-between-numbers * generateor.nextInt( scalingFactor / number of terms )
 */
import java.security.SecureRandom;

public class GenerateRandomNumberFromElementsOfArithmaticProgression {

    public static void main( String ... args ) {

        SecureRandom numbers = new SecureRandom();
        int number = 2 + 3 * numbers.nextInt( 5 );

        System.out.print( "A randomly generated number is " + number );

    }
}
