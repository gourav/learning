/**
 * With this test file, we will try to use a final constant in switch case.
 * We will have two final variables,
 * 	a. With immediatey assigned value.
 * 	b. With deferred assginment.
 */
public class FinalUsageInSwitchTest {

	public static void main( String ... args ) {

		final int year = 2019;
		final int month;

		month = 2;
		int x = 0;

		switch( x ) {
		
			case year:
				System.out.println( "x holds value " + year );
				break;

			case month:
				System.out.println( "x holds value " + month );
				break;

		}
	}
}
		
