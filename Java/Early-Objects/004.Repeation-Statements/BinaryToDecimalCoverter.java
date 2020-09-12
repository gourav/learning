/**
 * Coverts a binary binary (user-entered) number into decimal.
 */
import java.util.Scanner;

public class BinaryToDecimalCoverter {

    public static void main( String ... args ) {

        Scanner scanner = new Scanner( System.in );
        System.out.print( "Please enter a binary number: ");
        long binaryNumber = scanner.nextInt();

        System.out.printf( "Binary number %d has decimal %d decimal equivalent.%n", binaryNumber, toDecimal( binaryNumber ));

    }

    private static long toDecimal( long binaryNumber ) {

        long decimal = 0;
        int digitsPlace = 0;

        while( binaryNumber > 0 ) {

            long remainder = binaryNumber % 10;
            decimal = decimal + ( remainder * (long) Math.pow( 2, digitsPlace++ ));
            binaryNumber /= 10;

        }

        return decimal;

    }
}
