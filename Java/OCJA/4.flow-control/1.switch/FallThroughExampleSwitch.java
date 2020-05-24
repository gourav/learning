/**
 * This example demonstrates fall through behave of the switch statement.
 */
public class FallThroughExampleSwitch {

	public static void main( String ... args ) {

		int num = 0;

		switch( num ) {

			case 0:
				System.out.println( "num is 0 " );
			
			case 1:
				System.out.println( "num is 1 " );
			
			case 2:
				System.out.println( "num is 2 " );

		}
	}
}
