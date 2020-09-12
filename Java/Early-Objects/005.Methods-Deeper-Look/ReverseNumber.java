/**
 * ReverseNumber reverses a number.
 */
import java.util.Scanner;

public class ReverseNumber {

    public static void main( String ... args ) {

        Scanner scanner = new Scanner( System.in );
        
        System.out.print( "Please enter number to reverse " );
        int numberToReverse = scanner.nextInt();

        int reversed = doReverse( numberToReverse );
        System.out.println( "Reversed number is " + reversed );

    }

    public static int doReverse( int number ) {

        int reversed = 0;

        while( number > 0 ) {
            
            reversed = ( reversed * 10 ) + ( number % 10 );
            number /= 10;

        }

        return reversed;

    }

}
