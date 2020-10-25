#include <stdio.h>

/**
 * This program intends to demostrate command line arguments in C.
 * Each of the main function receives two arguments
 * a. number of arguments
 * b. pointer array containing passed command line arguments.
 *
 * NOTE: number of arguments will be always be at least one as current
 * executing program file name is passed itself as an argument.
 */
int main( int argc, char* argv[] ) {

    char* programName = argv[0];
    char* yourName = NULL;

    if( argc == 1 ) {

        printf( "Hello.\nYou have given me %d argument.\n", argc );
        printf( "Currently executing program name is %s.\n", programName );

    } else if( argc > 1 ) {

        printf( "Hello.\nYou have given me %d arguments.\n", argc );
        yourName = argv[1];
        printf( "Your name is %s and you just executed %s.\n", yourName, programName );
    }
    
    return 0;

}
