import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SemesterTester {
public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        ProfessorE prof1 = new ProfessorE("Prof.", "Alice Smith", LocalDate.parse("03/27/1989", formatter));
        ProfessorE prof2 = new ProfessorE("Dr.", "Bob Johnson", LocalDate.parse("05/18/1980", formatter));
        ProfessorE prof3 = new ProfessorE("Prof.", "Carol White", LocalDate.parse("02/11/1979", formatter));


        Course math101 = new Course("Mathematics", "MATH101", 10114, 4);
        Course math102 = new Course("Mathematics", "MATH102", 1054, 4);
        Course chem101 = new Course("Chemistry", "CHEM101", 6289, 4);
        Course math101Sec2 = new Course("Mathematics", "MATH101", 7746, 4);
        Course phys102 = new Course("Physics", "PHYS102", 2262, 4);
        Course chem103 = new Course("Chemistry", "CHEM103", 8998, 4);
        Course phys101 = new Course("Physics", "PHYS101", 4457, 4);
        Course comp141 = new Course("Computer Science", "COMP141", 8224, 4);
        Course comp170 = new Course("Computer Science", "COMP170", 8567, 4);
        Course comp271 = new Course("Computer Sciences", "COMP271", 8778, 4);
        // Assign professors to courses
        comp141.addInstructor(prof1);
        comp170.addInstructor(prof1);
        math101Sec2.addInstructor(prof1);
        comp271.addInstructor(prof1);

        phys102.addInstructor(prof2);
        math101.addInstructor(prof2);
        phys101.addInstructor(prof2);

        chem101.addInstructor(prof3);
        math102.addInstructor(prof3);
        chem103.addInstructor(prof3);
        math101.addInstructor(prof3);



        Registry registry = new Registry();
        Semester fall2023 = new Semester("Fall 2023", registry);


        fall2023.addCourse(comp141);
        fall2023.addCourse(comp170);
        fall2023.addCourse(comp271);
        fall2023.removeCourse(comp271);



        fall2023.addCourse(math101);
        fall2023.addCourse(math102);
        fall2023.addCourse(math101Sec2);

        fall2023.addCourse(chem101);
        fall2023.addCourse(chem103);

        fall2023.addCourse(phys102);
        fall2023.addCourse(phys101);


        ProfessorE prof4 = new ProfessorE("Prof. ", "Elena Morris", LocalDate.parse("06/11/1958", formatter));
        ProfessorE prof5 = new ProfessorE("Dr. ", "Fiona Gale", LocalDate.parse("08/17/1977", formatter));
        ProfessorE prof6 = new ProfessorE("Prof. ", "George Hill", LocalDate.parse("01/11/1992", formatter));


        List<ProfessorE> professors = new ArrayList<>();
        professors.add(prof1);
        professors.add(prof2);
        professors.add(prof3);
        professors.add(prof4);
        professors.add(prof5);
        professors.add(prof6);

        // New courses for Spring 2023
        Course art101 = new Course("Art History", "ART101", 201, 3);
        Course econ101 = new Course("Economics", "ECON101", 202, 4);
        Course lit101 = new Course("English Literature", "LIT101", 203, 3);

        // Assign professors to new courses
        art101.addInstructor(prof4);
        econ101.addInstructor(prof5);
        lit101.addInstructor(prof6);

        // Create the Spring 2023 semester and add courses
        Registry registry2 = new Registry();
        Semester spring2023 = new Semester("Spring 2023", registry2);
        spring2023.addCourse(art101);
        spring2023.addCourse(econ101);
        spring2023.addCourse(lit101);


        Scanner scanner = new Scanner(System.in);

        System.out.println("Are you a professor? (yes/no)");
        String isProfessor = scanner.nextLine();

        if (!isProfessor.equalsIgnoreCase("yes")) {
        System.out.println("This program is only accessible to professors.");
        return;
        }

        System.out.println("Please enter your title (e.g., Prof., Dr.):");
        String title = scanner.nextLine().trim();

        System.out.println("Please enter your full name (Firstname Lastname):");
        String name = scanner.nextLine().trim();

        String fullName = title + " " + name;

        ProfessorE professor = professors.stream()
        .filter(p -> (p.getTitle().trim() + " " + p.getName().trim()).equalsIgnoreCase(fullName))
        .findFirst()
        .orElse(null);

        if (professor == null) {
        System.out.println("No professor found with the name " + fullName);
        return;
        }

        System.out.println("Please enter the semester you are interested in (e.g., 'Fall 2023', 'Spring 2023'):");
        String semesterName = scanner.nextLine();


        Semester selectedSemester = (semesterName.equalsIgnoreCase("Fall 2023") ? fall2023 : (semesterName.equalsIgnoreCase("Spring 2023") ? spring2023 : null));

        if (selectedSemester == null) {
        System.out.println("No data available for the semester: " + semesterName);
        return;
        }

        List<Course> courses = selectedSemester.findCoursesByProfessor(professor);
        System.out.println("Courses taught by " + fullName + " in " + semesterName + ":");
        for (Course course : courses) {
        System.out.println(course.getName() + " Course id: " + course.getNumber() + " Credit Hours: " + course.getCreditHours());

        }
        }
}