interface Bounceable {

	default void bounce() {
		System.out.println( "Default Bounce" );
	}
}

public class DefaultInterfaceMethodTest implements Bounceable {

	@Override
	public void bounce() {
		System.out.println( "Specialized Bounce" );
	}

	public static void main( String[] args ) {
		
		DefaultInterfaceMethodTest test = new DefaultInterfaceMethodTest();
		test.bounce();

	}
}
