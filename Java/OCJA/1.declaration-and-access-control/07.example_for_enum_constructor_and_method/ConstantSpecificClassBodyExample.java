/**
 * This file aims at explaining the use case of a constant specific class body.
 */
enum CoffeeSize {
	BIG, 
	HUGE,
	OVERWHELMING {

		public String getLidType() {
			return "B";
		}
	};

	public String getLidType() {
		return "A";
	}
}

public class ConstantSpecificClassBodyExample {

	public static void main( String ... args ) {

		for( CoffeeSize size: CoffeeSize.values() ) {
			System.out.println( String.format( "Lid type for coffee size %s is %s", size, size.getLidType() ));
		}
	}
}	
