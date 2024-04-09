import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    private String department;
    private String name;
    private int number;
    private int creditHours;
    private List<Student> enrolled;
    private List<Student> waitListed;

    public Course(String department, String name, int number, int creditHours) {
        this.department = department;
        this.name = name;
        this.number = number;
        this.creditHours = creditHours;
        this.enrolled = new ArrayList<>();
        this.waitListed = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        if (!enrolled.contains(student)) {
            enrolled.add(student);
        }
    }

    public void unenrollStudent(Student student) {
        enrolled.remove(student);
    }

    @Override
    public String toString() {
        String enrolledStudents = enrolled.stream()
                .map(Student::toString)
                .collect(Collectors.joining("\n"));
        return String.format("Course Name: '%s', Credit Hours: %d\nEnrolled Students:\n%s",
                name, creditHours, enrolledStudents.isEmpty() ? "None" : enrolledStudents);
    }
}
