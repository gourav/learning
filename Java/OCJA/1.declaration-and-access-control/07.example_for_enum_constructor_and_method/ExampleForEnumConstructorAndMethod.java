/**
 * This is an example where a enum constructor is implicity called.
 */
public class ExampleForEnumConstructorAndMethod {

	public static void main( String ... args ) {

		CoffeeSize size = CoffeeSize.HUGE;
		System.out.println( "Size of HUGE coff is " + size.getOunces() + " in weight" );
	
	}
}
