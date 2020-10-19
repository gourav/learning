#include <stdio.h>

int main() {

    char name[100];
    int age;

    printf( "Please enter your name and age : " );
    scanf( "%s %d", name, &age );

    printf( "Hello %s. Your age is %d.\n", name, age );

    return 0;

}
