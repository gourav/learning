/**
 * HollowSquare prints a hollow square as per the length received as input from the user.
 */
import java.util.Scanner;

public class HollowSquare {

    public static void main( String ... args ) {
        
        Scanner scanner = new Scanner( System.in );

        System.out.print( "Enter side of the square to print hollow square : " );
        int side = scanner.nextInt();

        printHollowSquare( side );

    }

    private static void printHollowSquare( int side ) {

        for( int row = 1; row <= side; row++ ) {

            for( int column = 1; column <= side; column++ ) {

                if( row == 1 || row == side || column == 1 || column == side) {
                    System.out.print( "*" );
                } else {
                    System.out.print( " " );

                }

            }

            System.out.println();
        }
    }
}
