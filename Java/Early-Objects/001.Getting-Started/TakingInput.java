/**
 * This example is going to demonstrate how to take input in Java.
 */
import java.util.Scanner;

public class TakingInput {

    public static void main( String ... args ) {

        Scanner scanner = new Scanner( System.in );

        System.out.print( "Please enter first number: " );
        int firstNumber = scanner.nextInt();

        System.out.print( "Please enter second number: " );
        int secondNumber = scanner.nextInt();

        int sum = firstNumber + secondNumber;
        System.out.println( "Their sum is " + sum );

    }
}
