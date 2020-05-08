import java.util.Date;

/**
 * This test tries to check if we can use an unitialized local variable in
 * System.out.print expression.
 */
public class CanWeUseUnitializedLocalVariableForSysOut {

	public static void main( String ... args ) {

		Date date;
		System.out.println( "Date is " + date );

	}
}
