#include <stdio.h>

/**
 * This example demonstrates functioning of enum in C.
 */
int main() {

    enum Direction {
        UP,
        DOWN,
        LEFT = 10,
        RIGHT
    };

    /**
     * Let's see how enum is actually stored.
     */
    printf( "UP=%d, DOWN=%d, LEFT=%d, RIGHT=%d\n", UP, DOWN, LEFT, RIGHT );
    
    /*
     * Let's declare a new direction.
     */
    enum Direction forward = RIGHT;

    /*
     * Let's see how does it fares in comparison ?
     */
    if( forward == RIGHT ) {
        printf( "You are going in right direction. " );

    } else {
        printf( "You are going in other direction. " );

    }

    /*
     * Let's see can we assign it any number ?
     */
    forward = 99;

    printf( "%d\n", forward );

    return 0;

}
