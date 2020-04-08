class A {
	public int a = 19;
}

class B extends A {
	public String a = "Hey there.";
}

public class CanWeCreatePublicFieldWithDifferntTypeInSubClassTest {
	public static void main( String ... args ) {

		A a = new B();
		B b = new B();

		System.out.println( a.a );
		System.out.println( b.a );
	}
}
