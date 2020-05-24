/**
 * This test tests whether default case position take precedence over the matched case.
 */
public class DefaultCaseExampleTest { 

    public static void main( String ... args ) {

        int x = 0;

        switch( x ) {

            case 2:
                System.out.println( "Number is 2" );
                break;

            default:
                System.out.println( "Number is something else. " );

            case 5:
                System.out.println( "Number is 5 " );

        }
    }
}

