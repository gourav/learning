/**
 * VerticalBarChart prints a vertical bar chart for the set of values input by user.
 */
import java.util.Scanner;

public class VerticalBarChart {

    public static void main( String ... args ) {

        Scanner scanner = new Scanner( System.in );
        System.out.print( "Please enter number of values to plot bar chart for : " );
        int items = scanner.nextInt();
        int[] values = new int[ items ];

        /*
         * Let's take n numbers from user.
         */
        int currentItem = 0;
        while( currentItem < items ) {
            System.out.printf( "Please enter value at %d place : ", currentItem );
            values[ currentItem++ ] = scanner.nextInt();

        }

        drawVerticalBarChart( values );

    }

    private static void drawVerticalBarChart( int[] values ) {

        int rows = values.length;
        int maxValue = findMaximum( values );
        
        String[] horizontalRow = new String[ maxValue + 1];

        for( int row = 0; row <= maxValue; row++ ) {

            String patternForThisRow = "";
            int barChartUnitAtThisRow = maxValue - row;
            for( int column = 0; column < values.length; column++ ) {

                if( barChartUnitAtThisRow < values[ column ] ) {
                    patternForThisRow += "* ";
                } else {
                    patternForThisRow += "  ";
                }
            }

            horizontalRow[ row ] = patternForThisRow;

        }

        for( String pattern : horizontalRow ) {
            System.out.println( pattern );
        }

        for( int value : values ) 
            System.out.printf( "%d ", value );
    }

    private static int findMaximum( int[] values ) {
        
        int max = 0;
        for( int value : values ) {
            if( max < value ) {
                max = value;
            }
        }

        return max;
    }

}
