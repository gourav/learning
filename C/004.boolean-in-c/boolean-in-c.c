#include <stdio.h>
#include <stdbool.h>
/*
 * This program tries to demonstrate usage of boolean in C.
 */
int main() {

    /*
     * Its important that header file stdbool is included otherwise 
     * this program will not compile.
     */
    bool is_this_sunday = true;
    if( is_this_sunday ) {
        printf( "It's Sunday today. " );
    } else {
        printf( "It's not Sunday today. " );
    }

    return 0;
}
