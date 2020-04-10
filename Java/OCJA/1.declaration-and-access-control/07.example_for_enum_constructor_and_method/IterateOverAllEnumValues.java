/**
 * This example demonstrates how we can iterate over all the values allowed in a enum
 */
public class IterateOverAllEnumValues {

	public static void main( String ... args ) {

		for( CoffeeSize size: CoffeeSize.values() ) {
			System.out.println( "Size of a " + size + " cup of coffeee is " + size.getOunces() + " in ounces." );
		}
	
	}
}
