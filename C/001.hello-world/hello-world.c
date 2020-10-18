#include <stdio.h>

/**
 * Compilation process has four different steps.
 * 1. Preprocessing
 * 2. Compiling
 * 3. Assembling
 * 4. Linking
 *
 * Whenever we issue gcc file-name.c, gcc performs all of these steps.
 * Let's see what happens in each of the phases.
 *
 * Preprocessing
 * =============
 *  - gets rid of all coments in source file(s)
 *  - includes code of header files
 *  - replaces all macros with their values
 *
 * Compiling
 * =========
 *  - reads preprocessed file and generates Intermediate representation
 *
 *  Assembling
 *  ==========
 *  - reads compiled (IR) code and transforms into object code, code
 *     in machine language.
 *
 * Linker
 * ======
 *  - links all source files together
 *  - links function call with their definitions
 *
 * Let's see different options that we can pass to gcc to generate its
 * output for each of these four phases.
 *
 * - gcc -E hello-world.c --> generates preprocessed code
 * - gcc -S hello-world.c --> generates IR code
 * - gcc -c hello-world.c --> generates machine code
 * - gcc hello-world.c --> generates final executable with file called 
 *   a.out
 * - gcc hello-world.c -o hello --> generates hello executable
 *
 */
int main() {

    printf( "Hi. I am Gaurav." );
    return 0;

}
