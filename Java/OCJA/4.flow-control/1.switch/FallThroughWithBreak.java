/**
 * This example demonstrates fall through behave of the switch statement where 
 * a break statement is also put in one of the following case statements.
 */
public class FallThroughWithBreak {

	public static void main( String ... args ) {

		int num = 0;

		switch( num ) {

			case 0:
				System.out.println( "num is 0 " );
			
			case 1:
				System.out.println( "num is 1 " );
				break;
			
			case 2:
				System.out.println( "num is 2 " );

		}
	}
}
