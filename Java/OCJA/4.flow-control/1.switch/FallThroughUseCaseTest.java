/**
 * This example demonstrates a proper use case where switch fall through is useful.
 */
enum Months {
	JANUARY,
	FEBRUARY,
	MARCH,

	APRIL,
	MAY,
	JUNE,
	
	JULY,
	AUGUST,
	SEPTEMBER,

	OCTOBER,
	NOVEMBER,
	DECEMBER
}

public class FallThroughUseCaseTest {

	public static void main( String ... args ) {

		Months month = Months.APRIL;
		boolean is30DayMonth = false;

		switch ( month ) {

			case JUNE:
			case NOVEMBER:
			case APRIL:
			case SEPTEMBER:
				is30DayMonth = true;
				break;

		}

		if( is30DayMonth ) {
			System.out.println( "Month " + month + " is a 30 days month. " );
		} else {
			System.out.println( "Month " + month + " is not a 30 day month. " );
		}
	}
}
		
