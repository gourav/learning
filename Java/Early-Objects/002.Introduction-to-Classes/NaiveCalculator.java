/**
 * NaiveCalculator is an attempt to create GUI app to let users adds two numbrs.
 */
import javax.swing.JOptionPane;

public class NaiveCalculator {

    public static void main( String ... args ) {

        String firstNumber = JOptionPane.showInputDialog( "Please enter first number to add" );
        int parsedFirstNumber = Integer.parseInt( firstNumber );

        String secondNumber = JOptionPane.showInputDialog( "Please enter second number to add" );
        int secondParsedNumber = Integer.parseInt( secondNumber );

        int sum = parsedFirstNumber + secondParsedNumber;

        String message = String.format( "Sun of %d and %d is %d.", parsedFirstNumber, secondParsedNumber, sum );
        JOptionPane.showMessageDialog( null, message );

    }
}
