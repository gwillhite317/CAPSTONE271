import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentEnrollSemTester {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Registry registry = new Registry();
        Registry registry2 = new Registry();

        // Professors
        ProfessorE prof1 = new ProfessorE("Prof.", "Alice Smith", LocalDate.parse("03/27/1989", formatter));
        ProfessorE prof2 = new ProfessorE("Dr.", "Bob Johnson", LocalDate.parse("05/18/1980", formatter));
        ProfessorE prof3 = new ProfessorE("Prof.", "Carol White", LocalDate.parse("02/11/1979", formatter));

        // Students
        registry.recordStudent("John", "Doe", 1225, 15, 6, 2001);
        registry.recordStudent("Jane", "Smith", 1103, 22, 3, 2002);
        registry.recordStudent("Alex", "Christopherson", 1034, 3, 5, 2000);
        registry.recordStudent("Jane", "Smith", 1998, 12, 8, 2001);
        // Courses

        Course chem103 = new Course("Chemistry", "CHEM103", 8998, 4);
        Course phys102 = new Course("Physics", "PHYS102", 4457, 4);
        Course comp141 = new Course("Computer Science", "COMP141", 8224, 4);
        Course comp170 = new Course("Computer Science", "COMP170", 8567, 4);
        Course comp271 = new Course("Computer Sciences", "COMP271", 8778, 4);
        Course math101 = new Course("Mathematics", "MATH101", 101, 4);
        Course math131 = new Course("Mathematics", "Math131", 4465, 4);
        Course phys101 = new Course("Physics", "PHYS101", 102, 4);
        chem103.addInstructor(prof3);
        phys102.addInstructor(prof3);
        phys101.addInstructor(prof3);
        comp141.addInstructor(prof1);
        comp170.addInstructor(prof1);
        comp271.addInstructor(prof1);
        math131.addInstructor(prof2);
        math101.addInstructor(prof2);

        // Semesters
        Semester fall2023 = new Semester("Fall 2023", registry);
        fall2023.addCourse(math101);
        fall2023.addCourse(phys101);
        fall2023.addCourse(chem103);
        fall2023.addCourse(phys102);
        fall2023.addCourse(phys101);
        fall2023.addCourse(comp141);
        fall2023.addCourse(comp170);
        fall2023.addCourse(comp271);
        fall2023.addCourse(math131);


        // Enroll students in courses
        registry.enrollStudentInCourse(1225, math101);
        registry.enrollStudentInCourse(1103, math101);
        registry.enrollStudentInCourse(1125, math101);
        registry.enrollStudentInCourse(1034, math101);
        registry.enrollStudentInCourse(1998, phys101);
        registry.enrollStudentInCourse(1034, comp141);
        registry.enrollStudentInCourse(1103, comp170);
        registry.enrollStudentInCourse(1998, comp271);
        registry.enrollStudentInCourse(1034, math131);
        registry.enrollStudentInCourse(1103, chem103);




        ProfessorE prof4 = new ProfessorE("Prof. ", "Elena Morris", LocalDate.parse("06/11/1958", formatter));
        ProfessorE prof5 = new ProfessorE("Dr. ", "Fiona Gale", LocalDate.parse("08/17/1977", formatter));
        ProfessorE prof6 = new ProfessorE("Prof. ", "George Hill", LocalDate.parse("01/11/1992", formatter));


        Course art101 = new Course("Art History", "ART101", 2287, 3);
        Course econ101 = new Course("Economics", "ECON101", 3994, 4);
        Course lit101 = new Course("English Literature", "LIT101", 3002, 3);
        Course art102 = new Course("Art History", "ART102", 2294, 3);
        Course econ102 = new Course("Economics", "ECON102", 2244, 4);
        Course lit102 = new Course("English Literature", "Lit102", 3056, 4);

        registry2.recordStudent("John", "Doe", 1225, 15, 6, 2001);
        registry2.recordStudent("Jane", "Smith", 1103, 22, 3, 2002);
        registry2.recordStudent("Alex", "Christopherson", 1034, 3, 5, 2000);
        registry2.recordStudent("Jane", "Smith", 1998, 12, 8, 2001);

        Semester spring2023 = new Semester("Spring 2023" , registry2);
        spring2023.addCourse(art101);
        spring2023.addCourse(art102);
        spring2023.addCourse(lit102);
        spring2023.addCourse(lit101);
        spring2023.addCourse(econ102);
        spring2023.addCourse(econ101);

        art101.addInstructor(prof4);
        art102.addInstructor(prof4);
        econ101.addInstructor(prof5);
        econ102.addInstructor(prof5);
        lit101.addInstructor(prof6);
        lit102.addInstructor(prof6);

        registry2.enrollStudentInCourse(1225, art102);
        registry2.enrollStudentInCourse(1103, art102);
        registry2.enrollStudentInCourse(1034, art102);
        registry2.enrollStudentInCourse(1034, art101);
        registry2.enrollStudentInCourse(1998, econ102);
        registry2.enrollStudentInCourse(1034, econ102);
        registry2.enrollStudentInCourse(1225, econ101);
        registry2.enrollStudentInCourse(1225, lit101);
        registry2.enrollStudentInCourse(1998, lit102);
        registry2.enrollStudentInCourse(1225, lit102);


        System.out.println("Fall 2023 Course Rosters:");
        printCourseRoster(math101);
        printCourseRoster(phys101);
        printCourseRoster(math131);
        printCourseRoster(phys102);
        printCourseRoster(chem103);
        printCourseRoster(comp141);
        printCourseRoster(comp170);
        printCourseRoster(comp271);

        // Simulate unenrollment
        registry.unenrollStudentFromCourse(1225, math101);

        // Print updated rosters for Fall 2023
        System.out.println("\nUpdated math101 roster for Fall 2023 after drops:");

        printCourseRoster(math101);

        // Print roster for Fall 2024 (assuming same course setup)
        System.out.println("\nFall 2024 Course Rosters:");
        printCourseRoster(math101);
        printCourseRoster(phys101);

        System.out.println("\nSpring 2024 Course Rosters:");
        printCourseRoster(art101);
        printCourseRoster(art102);
        printCourseRoster(econ101);
        printCourseRoster(econ102);
        printCourseRoster(lit101);
        printCourseRoster(lit102);
    }

    private static void printCourseRoster(Course course) {
        System.out.println("Enrolled students in " + course.getName() + " (" + course.getNumber() + ") taught by " + course.getInstructor().getName() + ":");
        List<Student> enrolled = course.getEnrolled();
        if (enrolled.isEmpty()) {
            System.out.println("No students currently enrolled.");
        } else {
            for (Student student : enrolled) {
                System.out.println(student.getName() + " (ID: " + student.getId() + ")");
            }
        }
    }
}
