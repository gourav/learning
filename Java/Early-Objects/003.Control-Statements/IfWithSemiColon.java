/**
 * Let's test if a semi colon after if (single-entry, single-exit UML) statements is a valid one.
 *
 * RESULT :- Yes. It is valid one. But it is not valid for if-else-ladder.
 */
public class IfWithSemiColon {

    public static void main( String [] args ) {

        int number = 40;
        if( number <40 );
            System.out.println( "Number is less than 40." );

    }
}
