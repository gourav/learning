/**
 * PrintRightTriangle prints a right-angled tringle as per the length of base entered by user.
 */
import java.util.Scanner;

public class PrintRightTriangle {

    public static void main( String ... args ) {

        System.out.print( "Please enter base length of right-angled tringle to print : ");
        Scanner scanner = new Scanner( System.in );
        int base = scanner.nextInt();

        drawTriangle( base );

    }

    private static void drawTriangle( int base ) {

        for( int row = 1; row <= base; row++ ) {
            for( int column = 1; column <= row; column++ ) {
                System.out.print( "*" );
            }

            System.out.println();

        }
    }
}
