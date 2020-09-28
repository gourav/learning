/**
 * PrintHorizontalBarChart prints a horizontal bar chart.
 */
import java.util.Scanner;

public class PrintHorizontalBarChart {

    public static void main( String ... args ) {

        Scanner scanner = new Scanner( System.in );
        System.out.print( "Please enter number of items in bar chart : " );
        int items = scanner.nextInt();
        int[] values = new int[ items ];

        /*
         * Let's take n numbers from user. Here n is items.
         */
        int currentItem = 0;
        while( currentItem < items ) {
            System.out.printf( "Please enter value at %d place : ", currentItem + 1 );
            values[ currentItem++ ] = scanner.nextInt();

        }

        drawHorizontalBarChart( values );

    }

    private static void drawHorizontalBarChart( int[] values ) {

        int rows = values.length;

        for( int row = 0; row < rows; row++ ) {
            for( int column = 0; column < values[ row ]; column++ ) {
                System.out.print( "*" );
            }

            System.out.println();

        }

    }
}
