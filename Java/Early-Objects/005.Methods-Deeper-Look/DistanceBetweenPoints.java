/**
 * DistanceBetweenPoints computes distance between two co-ordinates.
 */
import java.util.Scanner;

public class DistanceBetweenPoints {

    public static void main( String ... args ) {

        Scanner scanner = new Scanner( System.in );

        System.out.print( "Enter x1: " );
        int x1 = scanner.nextInt();

        System.out.print( "Enter y1: " );
        int y1 = scanner.nextInt();

        System.out.println();

        System.out.print( "Enter x2: " );
        int x2 = scanner.nextInt();

        System.out.print( "Enter y2: " );
        int y2 = scanner.nextInt();

        double distance = Math.sqrt( Math.pow(( x2 - x1 ), 2 ) + Math.pow(( y2 - y1 ), 2 ));

        System.out.println( "Distance between points is " + distance );

    }
}
