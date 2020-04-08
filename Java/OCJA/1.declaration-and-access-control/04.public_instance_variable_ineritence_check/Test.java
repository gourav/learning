class A {
	public int a = 10;
	
	void printA() {
		System.out.println( a );
	}
}

class B extends A {
	public int a = 20;
	
	void printA() {
		System.out.println( a );
	}
}

class C extends B {
	public int a = 30;

	void printA() {
		super.printA();
	}
}

public class Test {

	public static void main( String ... args ) {

		A a = new A();
		System.out.println( a.a );

		A ac = new C();
		ac.printA();
	}
}
