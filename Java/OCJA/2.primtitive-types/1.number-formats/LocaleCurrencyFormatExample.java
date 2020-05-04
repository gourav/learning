/**
 * This example is going to demonstrate how to use currently formatter.
 */
import java.text.NumberFormat;
import java.util.Locale;

public class LocaleCurrencyFormatExample {

	public static void main( String ... args ) {

		double doubleValue = 10_000_000.56;

		Locale indianLocale = new Locale( "en", "IN" );
		NumberFormat indianCurrencyFormatter = NumberFormat.getCurrencyInstance( indianLocale );

		System.out.println( "Currency " + indianCurrencyFormatter.format( doubleValue ));
	}
} 
