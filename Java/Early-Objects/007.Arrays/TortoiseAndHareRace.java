/**
 * TortoiseAndHareRace is an attempt to simulate legendary story.
 *
 * Here are the rules.
 * -------------------
 *  - Race begins at square 1 and ends at square 70.
 *  - Race path is built on a moutain so occasionally contestents do slip.
 *  - Rule Table
 *    ---------------------------------------------------------------
 *    Animal    |   Move Type   |   Percentage  | Actual Move
 *    ---------------------------------------------------------------
 *    Tortoise  |   Fast Plod   |   50%         | 3 squares to right
 *              |   Slip        |   20%         | 6 squares to left
 *              |   Slow Plod   |   30%         | 1 square to right
 *    Hare      |   Sleep       |   20%         | No movement.
 *              |   Big Hop     |   20%         | 9 squarese to right
 *              |   Big Slip    |   10%         | 12 squares to left
 *              |   Small Hop   |   30%         | 1 square to right
 *              |   Small slip  |   20%         | 2 square to left
 *   ------------------------------------------------------------------i
 *  - Begin the race by displaying
 *    BANG !!!
 *    AND THEY'RE OFF !!!!!
 *  - For each iteration, display 70 position line showing letter T
 *    in the position of tortoise and letter H in position of hare.
 *  - If contenders land on same page, tortoise bites the hare, and 
 *    application should display OUCH !!!
 *  - All output positions other than T or H should be black or underscore.
 *  - If Tortoise wins, print TORTOISE WINS !!! YAY !!!
 *  - If hare wins, print Hare wins. Yuch.
 *  - If they tie, please its a tie.
 */
import java.security.SecureRandom;

public class TortoiseAndHareRace {

    private SecureRandom generator = new SecureRandom();

    public static void main( String ... args ) {

        TortoiseAndHareRace race = new TortoiseAndHareRace();

        System.out.println( "BANG !!!" );
        System.out.println( "AND THEY'RE OFF !!!!!" );

        race.doRace();

    }

    public void doRace() {

        final int STEPS = 70;
        boolean inProgress = true;

        int hareAt = 0, tortoiseAt = 0;

        while( inProgress ) {

            int randomMoveForHare = getRandomMoveForHare();
            hareAt += randomMoveForHare;
            hareAt = Math.max( hareAt, 0 );

            int randomMoveForTortoise = getRandomMoveForTortoise();
            tortoiseAt += randomMoveForTortoise;
            tortoiseAt = Math.max( tortoiseAt, 0 );

            if( hareAt > STEPS && tortoiseAt > STEPS ) {

                System.out.println( "Its a tie." );
                inProgress = false;

            } else if( hareAt > STEPS && tortoiseAt <= STEPS ) {

                System.out.println( "Hare wins. Yuch." );
                inProgress = false;

            } else if( hareAt <= STEPS && tortoiseAt > STEPS ) {

                System.out.println( "TORTOISE WINS !!! YAY!!!" );
                inProgress = false;

            } else {

                for( int i = 1; i <= STEPS; i++ ) {
                    if( i == hareAt && i == tortoiseAt ) {
                        System.out.print( "OUCH !!!" );
                    } else if( i == hareAt ) {
                        System.out.print( "H" );
                    } else if( i == tortoiseAt ) {
                        System.out.print( "T" );
                    } else {
                        System.out.print( "_" );
                    }
                }

                System.out.println();
            }
        }
    }

    private int getRandomMoveForTortoise() {
        int moveType = 1 + generator.nextInt( 10 );
        int move = 0;

        if( moveType <= 5 ) {
            move = 3;
        } else if( moveType > 5 && moveType <= 7 ) {
            move = -6;
        } else if( moveType >= 8 ) {
            move = 1;
        }

        return move;
    }

    private int getRandomMoveForHare() {
        int moveType = 1 + generator.nextInt( 10 );
        int move = 0;

        if( moveType <= 2 ) {
            move = 0;
        } else if( moveType > 2 && moveType <= 4 ) {
            move = 9;
        } else if( moveType > 4 && moveType <= 5 ) {
            move = -12;
        } else if( moveType > 5 && moveType <= 8 ) {
            move = 1;
        } else {
            move = -2;
        }

        return move;
    }

}
