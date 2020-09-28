/**
 * GradeBookTest demonstrates functioning of TwoDimensionalGradeBook
 */
public class GradeBookTest {

    public static void main( String ... args ) {

        int[][] gradesArray = {{87, 96, 70},
            				   {68, 87, 90},
            				   {94, 100, 90},
            				   {100, 81, 82},
            				   {83, 65, 85},
            				   {78, 87, 65},
            				   {85, 75, 83},
            				   {91, 94, 100},
            				   {76, 72, 84},
            				   {87, 93, 73}};

        TwoDimensionalGradeBook gradeBook = new TwoDimensionalGradeBook( "CS 101 Introduction to Java Programming", gradesArray );
        
        System.out.printf( "Welcome to grade book for %n%s%n%n%n", gradeBook.getCourseName() );
        gradeBook.processGrades();

    }
}
