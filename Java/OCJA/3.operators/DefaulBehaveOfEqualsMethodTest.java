/**
 * We are going to test if equals method returns true only if references 
 * are pointing to same object otherwise false even if the two objects 
 * have same value.
 */
class Animal {}
public class DefaulBehaveOfEqualsMethodTest {

	public static void main( String ... args ) {

		Animal animalOne = new Animal();
		Animal animalTwo = new Animal();
		Animal animalThree = animalOne;

		String first = "Hey";
		String second = "There";
		String third = new String( "Hey" );

		System.out.println( animalOne.equals( animalTwo ));
		System.out.println( animalOne.equals( animalThree ));

		System.out.println( first.equals( second ));
		System.out.println( first.equals( third ));

	}
}
