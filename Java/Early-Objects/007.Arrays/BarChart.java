/**
 * Bar Chart is a utility created for professor to create bar chart to 
 * represent grade distribution in her class.
 */
import java.security.SecureRandom;

public class BarChart {

    public static void main( String ... args ) {

        SecureRandom generator = new SecureRandom();

        int[] grades = new int[11];
        int counter = 0;

        while( counter++ < 11 ) {
            
            int marks = generator.nextInt( 100 );

            if( marks == 100 ) {
                grades[10]++;
            } else if( marks >= 90 && marks < 100 ) {
                grades[9]++;
            } else if( marks >= 80 && marks < 90 ) {
                grades[8]++;
            } else if( marks >= 70 && marks < 80 ) {
                grades[7]++;
            } else if( marks >= 60 && marks < 70 ) {
                grades[6]++;
            } else if( marks >= 50 && marks < 60 ) {
                grades[5]++;
            } else if( marks >= 40 && marks < 50 ) {
                grades[4]++;
            } else if( marks >= 30 && marks < 40 ) {
                grades[3]++;
            } else if( marks >= 20 && marks < 30 ) {
                grades[2]++;
            } else if( marks >= 10 && marks < 20 ) {
                grades[1]++;
            } else {
                grades[0]++;
            }

        }

        System.out.println( "Grade Distribution" );
        for( counter = 0; counter < grades.length; counter++ ) {

            if( counter == 10 ) {
                System.out.printf( "%5d:", 100 );
            } else {

                /**
                 * Format specifier %02 means that digit should be represented as 2 spaced number.
                 */
                System.out.printf( "%02d-%02d: ", counter * 10, counter * 10 + 9 );
            }

            for( int stars = 0; stars < grades[counter]; stars++ ) {
                System.out.print( "*" );
            }

            System.out.println();
        }
    }
}
