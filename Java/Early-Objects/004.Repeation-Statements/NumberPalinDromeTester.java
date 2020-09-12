/**
 * NumberPlainDromeTester checks if a number is palindrome in nature.
 *
 * If you reverse a palindrome number, you will get same number.
 * For example: 141, 121, 1331
 */
import java.util.Scanner;

public class NumberPalinDromeTester {

    public static void main( String ... args ) {

        Scanner scanner = new Scanner( System.in );
        System.out.println( "Please enter a number to check for palindrome : " );
        int number = scanner.nextInt();

        if( isPalindrome( number )) {
            System.out.printf( "%d is palindrome.%n", number ); 
        } else {
            System.out.printf( "%d is not a palindrome number.%n", number );
        }
    }

    private static boolean isPalindrome( int number ) {

        int reverse = doReverse( number );
        return reverse == number;

    }

    private static int doReverse( int number ) {

        int reversed = 0;
        while( number > 0 ) {

            int remaindar = number % 10;
            reversed = reversed * 10 + remaindar;
            number /= 10;

        }

        return reversed;

    }
}
