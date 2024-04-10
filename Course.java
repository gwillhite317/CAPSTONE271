import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    private String department;
    private String name;
    private int number;
    private int creditHours;
    public String title;
    private int credits;
    private ProfessorE instructor;

    private List<Student> enrolled;
    private List<Student> waitListed;

    private List<ProfessorE> profEnrolled;


    public Course(String department, String name, int number, int creditHours) {

        this.department = department;
        this.name = name;
        this.number = number;
        this.creditHours = creditHours;
        this.enrolled = new ArrayList<>();
        this.waitListed = new ArrayList<>();


    }

    public Course(String title, int credits) {
        this.title = title;
        this.credits = credits;
        this.enrolled = new ArrayList<>(); // Initialize enrolled list
        this.waitListed = new ArrayList<>(); // Initialize waitListed list
    }

    public void enrollStudent(Student student) {
        if (!enrolled.contains(student)) {
            enrolled.add(student);
        }
    }

    public void unenrollStudent(Student student) {
        enrolled.remove(student);
    }
    // Constructor for creating a new CourseE object.


    // Assigns a professor to teach the course.

    public void addInstructor(ProfessorE professor) {

        if (instructor == null) {

            instructor = professor;
// Assigns the professor to teach the course.

            professor.addCourse(this);
// Adds the course to the professor's teaching schedule.

        }

    }


    // Removes the instructor from teaching the course.

    public void removeInstructor(ProfessorE professor) {

        if (instructor == professor) {

            instructor = null;
// Removes the instructor from teaching the course.

        }

    }


    @Override   ///toString for StudentCourseTester
    public String toString() {
        StringBuilder roster = new StringBuilder(title + " (" + credits + " credits): ");
        if (enrolled.isEmpty()) {
            roster.append("\nNo students enrolled in the course");
        } else {
            for (Student student : enrolled) {
                roster.append("\nStudent Name: ").append(student.toString());
            }
        }
        return roster.toString();
    }
}
/// ToString for ProfersorEcourseE tester
///      public String toString() {
//        return title + " (Credits: " + credits + ")";
//
//    }

/// Tostring for Main/ recent assignment including groceryList:
///     public String toString() {
//        String enrolledStudents = enrolled.stream()
//                .map(Student::toString)
//                .collect(Collectors.joining("\n"));
//        return String.format("Course Name: '%s', Credit Hours: %d\nEnrolled Students:\n%s",
//                name, creditHours, enrolledStudents.isEmpty() ? "None" : enrolledStudents);
//    }
//}
