import java.text.NumberFormat;

/**
 * NumberFormatExample shows us to how to use NumberFormat.
 */
public class NumberFormatExample {

	public static void main( String ... args ) {
		var doubleValue = 10_000_000.53;
		
		/*
		 * NumberInstance will allow use to format numbers.
		 * We can say that NumberFormat allows us a to format a number in a way most reable in the country we are executing that code in. For example, in India we will use, 1,00,000 instead of 100,000 syntax of the US.
		 */
		var numberFormat = NumberFormat.getNumberInstance();
		System.out.println( "Number: " + numberFormat.format( doubleValue ));

	}
}
