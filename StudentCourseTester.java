import java.time.LocalDate;

public class StudentCourseTester
        /**
         * test code for your implementation of StudentE and CourseE classes
         * DO NOT CHANGE THIS CODE EXCEPT TO REMOVE THE // on the calls to dropCourse if you are doing the extra credit
         */
{
    public static void main(String[] args)
    {
        Student s1 = new Student(1000042, "Washington", "george", LocalDate.of(2003, 9, 11));
        Student s2 = new Student(1000099, "Ross", "Betsy", LocalDate.of(2001, 5, 22));
        Student s3 = new Student(100009, "Burr", "Aaron", LocalDate.of(2000, 8, 15));

        Course c1 = new Course("COMP 170 Intro to OOP", 3);
        Course c2 = new Course("COMP 271 Data Structures I", 3);
        Course c3 = new Course("COMP 272 Data Structures II", 3);

        s1.addCourse(c1);
        s2.addCourse(c3);
        s3.addCourse(c1);
        s3.addCourse(c2);
        s3.addCourse(c3);
        s3.addCourse(c1);   //duplicate so should not be added to course

        //s1.dropCourse(c1);  //you can remove the comment marks if you implement dropCourse
        //s3.dropCourse(c1);

        System.out.println("Course c1:\n" + c1 + "\n");
        System.out.println("Course c2:\n" + c2 + "\n");
        System.out.println("Course c3:\n" + c3 + "\n");
    }
}