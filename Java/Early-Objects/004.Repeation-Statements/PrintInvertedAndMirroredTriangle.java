/**
 * PrintInvertedAndMirroredTriangle prints an inverted and mirrored right triangle.
 *
 * Example:
 * *******
 *  ******
 *   *****
 *    ****
 *     ***
 *      **
 *       *
 */
import java.util.Scanner;

public class PrintInvertedAndMirroredTriangle {

    public static void main( String ... args ) {

        Scanner scanner = new Scanner( System.in );
        System.out.print( "Please enter length of base row : " );
        int baseRow = scanner.nextInt();

        drawInvertedAndMirroredTriangle( baseRow );

    }

    private static void drawInvertedAndMirroredTriangle( int baseRow ) {

        for( int row = 1; row <= baseRow; row++ ) {
            for( int column = 1; column <= baseRow; column++ ) {

                if( column >= row ) {
                    System.out.print( "*" );
                } else {
                    System.out.print( " " );
                }
            }

            System.out.println();
        }
    }
}

