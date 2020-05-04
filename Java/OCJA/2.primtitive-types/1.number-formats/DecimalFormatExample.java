/**
 * This example demonstrates usage of Decimal Format.
 */
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class DecimalFormatExample {

	public static void main( String ... args ) {

		DecimalFormat decimalFormat = new DecimalFormat( "₹###,##,###.00" );
		double doubleValue = 10_000_000.56;

		System.out.println( decimalFormat.format( doubleValue ));
	}
}
