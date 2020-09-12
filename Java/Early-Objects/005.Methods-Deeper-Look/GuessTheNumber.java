/**
 * GuessTheNumber is a game where computer takes a number randomly and asks the user to guess it.
 * */
import java.security.SecureRandom;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main( String ... args ) {

        int number = new SecureRandom().nextInt( 1000 );
        Scanner scanner = new Scanner( System.in );

        boolean guessed = false;
        while( !guessed ) {

            System.out.printf( "Guess number: " );
            int guessedNumber = scanner.nextInt();

            if( guessedNumber > number ) {
                System.out.println( "Too High. Try again. ");
            } else if( guessedNumber < number ) {
                System.out.println( "Too Low. Try again. ");
            } else {
                System.out.println( "Congratulations. You WON !!!" );
                guessed = true;

            }
        }
    }
}
