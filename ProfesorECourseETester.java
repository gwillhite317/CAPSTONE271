
public class ProfesorECourseETester {

    /**

     * test code for your implementation of ProfessorE and CourseE classes

     * DO NOT CHANGE THIS CODE EXCEPT TO REMOVE THE // on lines 23 - 25 if you are doing the extra credit

     */

    public static void main(String[] args)

    {

        ProfessorE p1 = new ProfessorE("Instructor", "George Washington");

        ProfessorE p2 = new ProfessorE("Professor", "Betsey Ross");

        ProfessorE p3 = new ProfessorE("Adjunct", "Aaron Burr");




        Course c1 = new Course("COMP 170 Intro to OOP", 3);

        Course c2 = new Course("COMP 271Data Structures " , 3);

        Course c3 = new Course("COMP 272 Data Structures II", 3);

        Course c4 = new Course("COMP 330 Software Engineering", 3);




        c1.addInstructor(p1);

        c2.addInstructor(p1);

        c3.addInstructor(p3);

        c4.addInstructor(p1);

        c1.addInstructor(p2);
        //duplicate so should not be added




        p1.removeCourse(c4);
        //you can remove the comment marks from 3 lines if you implement the EC

        c4.addInstructor(p2);

        p1.removeCourse(c4);
        //no longer teaching so should not be done




        System.out.println("Professor p1:\n" + p1 + "\n");

        System.out.println("Professor p2:\n" + p2 + "\n");

        System.out.println("Professor p3:\n" + p3 + "\n");

    }

}


