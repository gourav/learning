/**
 * PrintMirroredTriangle prints a mirrored right triangle.
 *
 * Example:
 *       *
 *      ** 
 *     ***
 *    ****
 *   *****
 *  ******
 * *******
 */
import java.util.Scanner;

public class PrintMirroredTriangle {

    public static void main( String ... args ) {

        Scanner scanner = new Scanner( System.in );
        System.out.print( "Please enter length of base row : " );
        int baseRow = scanner.nextInt();

        drawMirroredTriangle( baseRow );

    }

    private static void drawMirroredTriangle( int baseRow ) {

        for( int row = 1; row <= baseRow; row++ ) {
            for( int column = 1; column <= baseRow; column++ ) {

                if( ( row + column ) > baseRow ) {
                    System.out.print( "*" );
                } else {
                    System.out.print( " " );
                }
            }

            System.out.println();
        }
    }
}
