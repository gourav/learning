/**
 * This example demonstrates overloading of enum constructors.
 */
enum Size {
	SMALL( 10 ),
	BIG( 15 ),
	OVERWHELMING( 20, 'b' );

	/**
	 * Numerical value of size.
	 */
	int size;

	/**
	 * Category of size.
	 */
	char category;

	Size( int size ) {
		this.size = size;
		this.category = 'a';
	}

	Size( int size, char category ) {
		this.size = size;
		this.category = category;
	}
}

public class ExampleOfOverloadedEnumConstructor {

	public static void main( String ... args ) {

		for( Size size: Size.values() ) {
			System.out.println( size + "'s numerical value is " + size.size + " and catgory is " + size.category + "." );
		}
	}

}
