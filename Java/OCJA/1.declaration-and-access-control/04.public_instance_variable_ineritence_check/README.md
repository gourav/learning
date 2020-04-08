Question
--------
Demonstrate behavior of public member ( method & variable ) inheritance.

Answer
------
```
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

```

Output of the above snippet is:
```
10
20
```

This is because at any point in execution, method will always refer to the last overridden method of object's inheritance tree.
While, variables are not overridden, if you create a new copy, you are effectively shadowing the copy of parent, but it is still available to be referenced and it will be referenced by parent method when they are referring to variable's value.
