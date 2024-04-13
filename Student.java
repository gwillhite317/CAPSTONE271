import java.util.ArrayList;
import java.util.List;

/**
 * @author Kass Serek
 * @version 3 (April 2024)
 */

//represents a student, inheriting from Person, with an ID, name, and list of courses
public class Student extends Person {
    private int id;
    private String givenNames;
    private String familyName;
    private List<Course> courses;

    //constructor for a student object with the given parameters
    public Student(int id, String givenNames, String familyName) {
        super();
        this.id = id;
        this.givenNames = givenNames;
        this.familyName = familyName;
        this.courses = new ArrayList<>();
    }

    //add a course to the student's list
    public void addCourse(Course course) {
        if (ifDuplicate(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    //check if the course is already added to the student's list of courses
    private boolean ifDuplicate(Course course) {
        for (Course c : courses) {
            if (c.equals(course)) {
                return false;
            }
        }
        return true;
    }

    //drop a course from the student's list
    public void dropCourse(Course course) {
        Course courseToRemove = null;
        for (Course c : courses) {
            if (c.equals(course)) {
                courseToRemove = c;
            }
        }
        if (courseToRemove != null) {
            courses.remove(courseToRemove);
            courseToRemove.removeStudent(this);
        }
    }

    //string representation of a student
    public String toString() {
        return "Student: " + givenNames + familyName + " ID: " + id;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        // Apply 10% discount for students
        return totalAmount * 0.9;
    }
}
