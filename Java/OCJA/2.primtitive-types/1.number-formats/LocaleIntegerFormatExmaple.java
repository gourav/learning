/**
 * This example is going to demonstrate how to use locale to format a number.
 */
import java.text.NumberFormat;
import java.util.Locale;

public class LocaleIntegerFormatExmaple {

	public static void main( String ... args ) {

		double doubleValue = 10_000_000.65;

		Locale indianLocale = new Locale( "en", "IN" );
		NumberFormat indianLocaleNumberFormatter = NumberFormat.getInstance( indianLocale );

		System.out.println( "Number in Indian Locale " + indianLocaleNumberFormatter.format( doubleValue ));

	}
}
