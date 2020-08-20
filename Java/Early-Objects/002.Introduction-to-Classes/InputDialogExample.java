/**
 * This example demonstrates how to open up an input dialog and take an input.
 */
import javax.swing.JOptionPane;

public class InputDialogExample {

    public static void main( String ... args ) {

        String name = JOptionPane.showInputDialog( "Hey ! What's your name ?" );
        String message = String.format( "Hi %s ! I am Jarvis.", name );
        JOptionPane.showMessageDialog( null, message );

    }
}
