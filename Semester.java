
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Semester {
    private String semesterName;
    private List<Course> courses;
    private Registry studentRegistry;
    private String name;

    /**
     * Constructor to create a new semester with a specified name and student registry.
     * @param semesterName the name of the semester
     * @param studentRegistry the registry for managing student enrollments
     */
    public Semester(String semesterName, Registry studentRegistry) {
        this.semesterName = semesterName;
        this.courses = new ArrayList<>();
        this.studentRegistry = studentRegistry;
    }
    /**
     * Adds a course to the semester if it is not already present.
     * @param course the course to add
     */
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public List<Course> findCoursesByProfessor(ProfessorE professor) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getInstructor().equals(professor)) {
                result.add(course);
            }
        }
        result.sort((c1, c2) -> {
            int nameCmp = c1.getName().compareTo(c2.getName());
            return nameCmp != 0 ? nameCmp : Integer.compare(c1.getNumber(), c2.getNumber());
        });
        return result;
    }


    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        ProfessorE prof1 = new ProfessorE("Prof.", "Alice Smith", LocalDate.parse("03/27/1989", formatter) );
        ProfessorE prof2 = new ProfessorE("Dr. ", "Bob Johnson", LocalDate.parse("05/18/1980", formatter));
        ProfessorE prof3 = new ProfessorE("Prof. ", "Carol White", LocalDate.parse("02/11/1979", formatter));


        // Define courses
        Course math101 = new Course("Mathematics", "MATH101", 101, 4);
        Course phys101 = new Course("Physics", "CHEM101", 103, 4);
        Course chem101 = new Course("Chemistry", "CHEM101", 103, 4);
        Course math102 = new Course("Mathematics", "MATH102", 104, 4);
        Course phys102 = new Course("Physics", "PHYS102", 105, 4);
        Course chem102 = new Course("Chemistry", "CHEM103", 106, 4);


        // Assign professors to courses
        math101.addInstructor(prof1);
        math102.addInstructor(prof1);
        phys101.addInstructor(prof1);
        math101.addInstructor(prof2);
        phys101.addInstructor(prof2);
        chem101.addInstructor(prof3);
        phys102.addInstructor(prof2);
        chem102.addInstructor(prof3);

        // Create semester
        Registry registry = new Registry();
        Semester fall2023 = new Semester("Fall 2023", registry);
        fall2023.addCourse(math101);
        fall2023.addCourse(phys101);
        fall2023.addCourse(chem101);
        fall2023.addCourse(math102);
        fall2023.addCourse(phys102);
        fall2023.addCourse(chem102);

        ProfessorE prof4 = new ProfessorE("Prof. ", "Elena Morris", LocalDate.parse("06/11/1958", formatter));
        ProfessorE prof5 = new ProfessorE("Dr. ", "Fiona Gale", LocalDate.parse("08/17/1977", formatter));
        ProfessorE prof6 = new ProfessorE("Prof. ", "George Hill", LocalDate.parse("01/11/1992", formatter));

        // New courses for Spring 2023
        Course art101 = new Course("Art History", "ARTH101", 201, 3);
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
        System.out.println("Please enter your title");
        String title = scanner.nextLine().trim();

        System.out.println("Please enter your full name (Firstname Lastname):");
        String name = scanner.nextLine();

        String fullName = title + " " + name;

        // Search for professor using full name
        ProfessorE professor = null;
        List<ProfessorE> professors = List.of(prof1, prof2, prof3); // List of all professors
        for (ProfessorE prof : professors) {
            if ((prof.getTitle() + " " + prof.getName()).equalsIgnoreCase(fullName)) {
                professor = prof;
                break;
            }
        }

        if (professor == null) {
            System.out.println("No professor found with the name " + fullName);
            return;
        }

        System.out.println("Please enter the semester you are interested in (e.g., 'Fall 2023', 'Spring 2023'):");
        String semesterName = scanner.nextLine();

        // Identifying the semester
        Semester selectedSemester = null;
        // Assuming you have a method or a way to get semesters by name, possibly a map or list search
        if (semesterName.equalsIgnoreCase("Fall 2023")) {
            selectedSemester = fall2023;
        } else if (semesterName.equalsIgnoreCase("Spring 2023")) {
            selectedSemester = spring2023;
        }

        if (selectedSemester == null) {
            System.out.println("No data available for the semester: " + semesterName);
            return;
        }

        List<Course> courses = selectedSemester.findCoursesByProfessor(professor);
        System.out.println("Courses taught by " + fullName + " in " + semesterName + ":");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }
}





