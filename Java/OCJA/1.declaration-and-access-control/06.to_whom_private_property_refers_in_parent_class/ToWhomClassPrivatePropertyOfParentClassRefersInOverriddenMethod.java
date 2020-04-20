class A {

	private int a = 10;
	int b = 20;
	int c = 30;

	public void printA() {
		System.out.println( this.a );
	}

	public void printB() {
		System.out.println( this.b );
	}

	public void printC() {
		System.out.println( this.c );
	}
}

class B extends A {

	B() {
		this.b = 5555520;
	}

	public String c = "Hey There";

}

public class ToWhomClassPrivatePropertyOfParentClassRefersInOverriddenMethod {

	public static void main( String ... args ) {

		B b = new B();

		b.printA();
		b.printB();
		b.printC();
	
	}
}

	
