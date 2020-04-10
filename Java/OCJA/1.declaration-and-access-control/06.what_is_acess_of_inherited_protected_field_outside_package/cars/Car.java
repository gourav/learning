package cars;

public class Car {

	protected void displayName() {
		System.out.println( "Only descendents of Car can access this method." );
	}
}
