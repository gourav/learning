/**
 * This program computers compound interest for given prinipal, rate in ten years.
 */
public class CompoundInterest {

    public static void main( String ... args ) {

        double principal = 1000;
        double rate = 0.05;

        System.out.printf( "%4s  %-20s %n", "Year", "Amount in account" );

        for( int year = 1; year <= 10; year++ ) {
            double amount = principal * Math.pow( 1.0 + rate, year );
            System.out.printf( "%4d  %,-18.2f %n", year, amount );

        }

    }
}
