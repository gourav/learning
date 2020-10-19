#include <stdio.h>

int main() {

    double amount;
    char name[100];

    printf( "Please enter your name and bank balance : " );
    scanf( "%s %lf", name, &amount );

    printf( "Hello %s. You have $%lf in your bank account.\n", name, amount );

    return 0;

}
