/**
 * TurtleGraphics is an attempt of emulate the concept of turtle graphics as used in Logo.
 */
import java.util.Scanner;

enum TurtleDirection {
    LEFT,
    RIGHT,
    TOP,
    BOTTOM
}

public class TurtleGraphics {

    /**
     * Our canvas.
     * Our dear playground.
     */
    private static final boolean canvas[][] = new boolean[20][20];

    /**
     * Current Position in X direction.
     */
    private static int currentX = 0;

    /**
     * Current Position in Y direction.
     */
    private static int currentY = 0;

    /**
     * Is pen down ?
     */
    private static boolean pendown = false;

    public static void main( String ... args ) {

        System.out.printf( "Welcome to Turtle Graphics%n" );
        System.out.printf( ":========================:%n" );
        System.out.printf( "Your commands are%n %-8d%s%n %-8d%s%n %-8d%s%n %-8d%s%n %-8s%s%n %-8d%s%n %-8d%s%n%n", 1, "Pen Up", 2, "Pen Down", 3, "Turn Right", 4, "Turn Left", "5, 10", "Move forward 10 spaces ( replace 10 for differnt number of spaces )", 6, "Display 20-by-20 array", 9, "End of data (sentinel )" );

        System.out.println( "Let's play !" );

        Scanner scanner = new Scanner( System.in );

        boolean shouldContinue = true;
        TurtleDirection direction = TurtleDirection.RIGHT;

        while( shouldContinue ) {

            System.out.printf( "Please enter your command : " );
            String command = scanner.next();

            switch( command ) {

                case "1":
                    pendown = false;
                    break;

                case "2":
                    pendown = true;
                    break;

                case "3":

                    /*
                     * Let's have an inner switch to determine the next direction.
                     */
                    switch( direction ) {

                        case LEFT:
                                             direction = TurtleDirection.TOP;
                                             break;

                        case TOP:
                                             direction = TurtleDirection.RIGHT;
                                             break;

                        case RIGHT:
                                             direction = TurtleDirection.BOTTOM;
                                             break;

                        case BOTTOM:
                                             direction = TurtleDirection.LEFT;
                                             break;
                    }
                    break;

                case "4":

                    switch( direction ) {
                        case LEFT:
                            direction = TurtleDirection.BOTTOM;
                            break;

                        case TOP:
                            direction = TurtleDirection.LEFT;
                            break;

                        case RIGHT:
                            direction = TurtleDirection.TOP;
                            break;

                        case BOTTOM:
                            direction = TurtleDirection.RIGHT;
                            break;

                    }

                    break;

                case "6":
                    displayCanvas();
                    break;

                case "9":
                    shouldContinue = false;
                    break;

                default:
                    /**
                     * We are in forwards case.
                     */
                    if( command.startsWith( "5" )) {

                        int steps = Integer.parseInt( command.replace( "5,", "" ));
                        switch( direction ) {
                            case LEFT:
                                moveToLeft( steps );
                                break;

                            case RIGHT:
                                moveToRight( steps );
                                break;

                            case TOP:
                                moveToTop( steps );
                                break;

                            case BOTTOM:
                                moveToBottom( steps );
                                break;
                        }

                    }

            }
        }
    }

    private static void moveToLeft( int steps ) {

        int end = currentX - steps;
        while( currentX > end ) {
            if( pendown ) {
                canvas[ currentX ][ currentY ] = true;
            }

            currentX--;
        }
    }

    private static void moveToRight( int steps ) {

        int end = currentX + steps;
        while( currentX < end ) {
            if( pendown ) {
                canvas[ currentX ][ currentY ] = true;
            }

            currentX++;
        }

    }

    private static void moveToTop( int steps ) {

        int end = currentY - steps;
        while( currentY > end ) {
            if( pendown ) {
                canvas[ currentX ][ currentY ] = true;
            }

            currentY--;
        }
    }

    private static void moveToBottom( int steps ) {

        int end = currentY + steps;
        while( currentY < end ) {
            if( pendown ) {
                canvas[ currentX ][ currentY ] = true;
            }

            currentY++;
        }
    }

    /**
     * Render our canvas to the user.
     */
    private static void displayCanvas() {

        for( boolean[] rows: canvas ) {
            for( boolean column: rows ) {
                if( column ) {
                    System.out.print( "* " );
                } else {
                    System.out.print( "  " );
                }
            }

            System.out.println();
        }

    }
}
