/**
 * This is example of enum that has an associated constructor and instance variable.
 */
public enum CoffeeSize {
	BIG( 8 ),
	HUGE( 10 ),
	OVERWHELMING( 16 );

	CoffeeSize( int ounces ) {
		this.ounces = ounces;
	}

	private int ounces;

	public int getOunces() {
		return this.ounces;
	}
}
