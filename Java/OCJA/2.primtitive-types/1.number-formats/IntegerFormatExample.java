/**
 * This example demonstrates how to use IntegerFormat to format integer numbers.
 * This will nuke the decimal part of the number.
 */
import java.text.NumberFormat;

public class IntegerFormatExample {

	public static void main( String ... args ) {

		double doubleValue = 10_000_000.65;
		NumberFormat integerFormat = NumberFormat.getIntegerInstance();

		System.out.println( "Number: " + integerFormat.format( doubleValue ));
		
		/*
		 * We can suppress the groupings produced as well.
		 */
		integerFormat.setGroupingUsed( false );
		System.out.println( "Raw Numbner: " + integerFormat.format( doubleValue ));
	
	}
}
