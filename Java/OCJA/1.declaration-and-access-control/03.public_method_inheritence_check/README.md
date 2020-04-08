Question
--------
If we create superclass A with method a, and a subclass B with method a, so, at any point of time at any inheritence level, a call to this.a() invokes subclass method ?

Answer
------
In case of methods, a this pointing would always be resolved using object that is executing. So, in any inheritence tree, if a method `a()` has been overridden anwhere, it will refer to the last overridden instance of the method provided instance we are referring is of that class.

```
class A { public void a() {} }
class B extends A { public void a() {} }
class C extends B { public void a() {} }

A a = new A();
a.a();	// This will call A->a();

A ab = new B();
ab.a();	// This will call B ->a(); 

A ac = new C();
ac.a();	// This will call C ->a();
```
