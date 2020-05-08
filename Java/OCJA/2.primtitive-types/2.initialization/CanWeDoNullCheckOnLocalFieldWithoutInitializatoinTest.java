import java.util.Date;

/**
 * This is an test to check if we can put a local field to null usage check to 
 * see if compiler allows it.
 */
public class CanWeDoNullCheckOnLocalFieldWithoutInitializatoinTest {

	public static void main( String ... args ) {

		Date date;
		
		/*
		 * If next line compiles, then Yes, we can use.
		 */
		if( date == null ) {
			System.out.println( "Date is null." );
		}

	}
}
