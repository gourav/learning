/**
 * This is a test to check what is the excess of a protected field 
 * when it has been inherited by a sub class outside of the parent
 * class package. 
 *
 * Whether non sub classes are able to access protected member from
 * subclass after subclass has inherited it.
 */
import cars.Car;

class Maruti extends Car {

	public void sayName() {
		System.out.println( "I am a Maruti Car" );
	}
}

public class WhatIsAccessOfInheritedProtectedFieldOutsidePackageTest {

	public static void main( String ... args ) {
		Maruti maruti = new Maruti();
		maruti.sayName();
		maruti.displayName();
	}
}
