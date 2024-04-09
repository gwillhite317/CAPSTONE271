import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int id;
    private List<Course> courses;

    public Student(int id, String familyName, String givenNames, LocalDate DOB) {
        super(familyName, givenNames, DOB);
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this);
        }
    }

    public void dropCourse(Course course) {
        if (courses.remove(course)) {
            course.unenrollStudent(this);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " ID: " + id;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.9;
    }
}
