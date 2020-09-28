/**
 * PrintInvertedRightTriangle prints a inverted right-angled tringle as per the length of base entered by user.
 */
import java.util.Scanner;

public class PrintInvertedRightTriangle {

    public static void main( String ... args ) {

        System.out.print( "Please enter base length of inverted right-angled tringle to print : ");
        Scanner scanner = new Scanner( System.in );
        int base = scanner.nextInt();

        drawTriangle( base );

    }

    private static void drawTriangle( int base ) {

        for( int row = 0; row < base; row++ ) {
            for( int column = 1; column <= ( base - row ); column++ ) {
                System.out.print( "*" );
            }

            System.out.println();

        }
    }
}
