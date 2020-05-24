/**
* Let's verify if we can put a char in switch statement and int in case.
 */
public class CanWeUseCharsExpressionAndIntConstantsTest {

	public static void main( String ... args ) {

		char a = 'a';

		switch( a ) {

			case 65:
				System.out.println( "Its an a" );
				break;

			default:
				System.out.println( "It's not an a" );
				break;

		}
	}
}
