/**
 * Island of isolation is the scenario where a few objects have reference to each other but there is no external reference pointing to either of them.
 */
class Island {

	/**
	 * A local reference to another Island object.
	 */
	Island internal;
}

public class IslandOfIsolationTest {

	public static void main( String ... args ) {

		Island one = new Island();
		Island two = new Island();
		Island three = new Island();

		one.internal = two;
		two.internal = three;
		three.internal = one;

		one = null;
		two = null;
		three = null;

	}
}
