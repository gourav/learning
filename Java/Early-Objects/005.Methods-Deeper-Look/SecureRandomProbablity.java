/**
 * This example tries to test if SecureRandom produces truly random numbers
 * For this to happen, over the entire range, each of the possible entry must have equal probablity to occur. 
 */
import java.security.SecureRandom;

public class SecureRandomProbablity {

    public static void main( String ... args ) {

        SecureRandom generator = new SecureRandom();

        int frequencyOne = 0;
        int frequencyTwo = 0;
        int frequencyThree = 0;

        int frequencyFour = 0;
        int frequencyFive = 0;
        int frequencySix = 0;

        for( int roll = 1; roll <= 6000000; roll++ ) {

            int face = 1 + generator.nextInt( 6 );

            switch( face ) {

                case 1:
                    ++frequencyOne;
                    break;

                case 2:
                    ++frequencyTwo;
                    break;

                case 3:
                    ++frequencyThree;
                    break;

                case 4:
                    ++frequencyFour;
                    break;

                case 5:
                    ++frequencyFive;
                    break;

                case 6:
                    ++frequencySix;
                    break;

            }
        }

        System.out.println( "Face\tFrequency" );
        System.out.printf("1\t%d%n2\t%d%n3\t%d%n4\t%d%n5\t%d%n6\t%d%n ", frequencyOne, frequencyTwo, frequencyThree, frequencyFour, frequencyFive, frequencySix );

    }
}
