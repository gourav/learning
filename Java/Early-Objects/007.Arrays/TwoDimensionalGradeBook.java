/**
 * TwoDimensionalGradeBook is an old age book meant for professors to keep a track of scores students get in their class.
 *
 * Jokes apart, this program is created for learning experience and for emotional value it delvers.
 */
public class TwoDimensionalGradeBook {

    /**
     * Name of the course we are keeping marks of.
     */
    private String courseName;

    /**
     * Grade of all students.
     */
    private int[][] grades;

    /**
     * Create a new GradeBook
     */
    public TwoDimensionalGradeBook( String courseName, int[][] grades ) {
        this.courseName = courseName;
        this.grades = grades;
    }

    public void setCourseName( String courseName ) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void processGrades() {
        outputGrades();

        System.out.printf("%n%s %d%n%s %d%n%n",
                "Lowest grade in the grade book is ", getMinimum(),
                "Highest grade in the grade book is ", getMaximum() );

        outputBarChart();
    }

    /**
     * Find mimimum grade.
     */
    public int getMinimum() {
        
        int lowestGrade = grades[ 0 ][ 0 ];
        for( int[] aStudentGrades : grades ) {
            for( int grade : aStudentGrades ) {
                if( lowestGrade > grade ) {
                    lowestGrade = grade;
                }
            }
        }

        return lowestGrade;
    }

    /**
     * Find Maximum Grade.
     */
    public int getMaximum() {

        int highestGrade = grades[ 0 ][ 0 ];
        for( int[] aStudentGrades : grades ) {
            for( int grade : aStudentGrades ) {
                if( highestGrade < grade ) {
                    highestGrade = grade;
                }
            }
        }

        return highestGrade;
    }

    /**
     * Compute average marks for the student.
     */
    public double getAverage( int[] grades ) {
        int total = 0;

        for( int grade : grades ) {
            total += grade;
        }

        return ( double ) total / grades.length;
    }

    /**
     * Display a bar chart.
     */
    public void outputBarChart() {
        System.out.println( "Overall grade distribution: " );

        int[] frequency = new int[11];
        for( int[] studentGrades: grades ) {
            for( int grade : studentGrades ) {
                ++frequency[ grade / 10 ];
            }
        }

        for( int count = 0; count < frequency.length; count++ ) {
            if( count == 10 ) {
                System.out.printf( "%5d: ", 100 );
            } else {
                System.out.printf( "%02d-%02d: ", count * 10, count * 10 + 9 );
            }

            for( int stars = 0; stars < frequency[ count ]; stars++ ) {
                System.out.print( "*" );
            }

            System.out.println();
        }
    }

    public void outputGrades() {

        System.out.printf( "The grades are: %n%n" );
        System.out.print( "          " );

        for( int test = 0; test < grades[0].length; test++ ) {
            System.out.printf( "Test %d ", test + 1 );
        }

        System.out.println( "Average " );

        for( int student = 0; student < grades.length; student++ ) {
            System.out.printf( "Student %2d", student + 1 );

            for( int test : grades[ student ]) {
                System.out.printf( "%8d", test );
            }

            double average = getAverage( grades[ student ] );
            System.out.printf( "%9.2f%n", average );

        }
    }
}
