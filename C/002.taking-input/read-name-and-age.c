#include <stdio.h>

/*
 * scanf actually has a problem.
 * It reads your input until it encounters newline character.
 * That means it leaves that last enter key press in input stream which
 * will cause any other read to read that newline immediately which sort
 * of gives impression that your second read didn't work.
 *
 * It actually did work. It is just that it read that trailing newline char
 * which scanf left out last time while reading the input.
 */
int main() {

    char name[100];
    int age;

    printf( "Please enter your name and age : " );
    scanf( "%s %d", name, &age );

    printf( "Hello %s. Your age is %d.\n", name, age );

    return 0;

}
