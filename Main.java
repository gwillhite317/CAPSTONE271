
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you a professor? (yes/no)");
        String response = scanner.nextLine();
        if (!response.equalsIgnoreCase("yes")) {
            System.out.println("This system is only accessible to professors.");
            return;
        }

        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        // Assuming we have a method to get professor by name
        ProfessorE professor = new ProfessorE(name);

        // Assuming we have some pre-defined semesters and courses
        Semester fall2023 = new Semester("Fall 2023", new Registry());
        // You would populate courses here

        System.out.println("Here are the courses you're teaching:");
        List<Course> courses = fall2023.findCoursesByProfessor(professor);
        courses.forEach(course -> System.out.println(course.getName()));

        // Further interaction to manage courses, enrollments etc.
    }
}
