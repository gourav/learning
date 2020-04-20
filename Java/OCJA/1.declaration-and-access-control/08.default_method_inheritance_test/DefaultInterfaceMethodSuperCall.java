interface Doable {

	default void doSomething() {
		System.out.println( "Default do." );
	}

}

public class DefaultInterfaceMethodSuperCall implements Doable {

	public void doSomething() {
		System.out.println( "Specialized do." );

		/**
		 * Super call doesn't works.
		 */
		// super.doSomething();
		Doable.super.doSomething();
	}

	public static void main( String[] args ) {

		DefaultInterfaceMethodSuperCall call = new DefaultInterfaceMethodSuperCall();
		call.doSomething();
	}
}
