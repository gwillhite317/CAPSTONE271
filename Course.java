import java.util.ArrayList;
import java.util.List;

/**
 * @author Kass Serek
 * @version 3 (April 2024)
 */

//represents a course with a department name, title, course number, credits, and enrolled plus wait listed students
public class Course {
    private String departmentName;
    private String title;
    private int courseNumber;
    private int credits;
    private List<Student> enrolledStudents;
    private ArrayList<Student> waitListedStudents;

    //constructor for a course object with the given parameters
    public Course(String title, int credits) {
        this.title = title;
        this.credits = credits;
        this.enrolledStudents = new ArrayList<>();
        this.departmentName = departmentName;
        this.courseNumber = courseNumber;
        this.waitListedStudents = new ArrayList<>();
    }

    //add a student to the enrolled students list
    public void addStudent(Student student) {
        boolean alreadyEnrolled = false;
        for (Student enrolledStudent : enrolledStudents) {
            if (enrolledStudent.equals(student)) {

                alreadyEnrolled = true;
            }
        }
        if (!alreadyEnrolled) {
            enrolledStudents.add(student);
        }
    }

    //remove a student from the enrolled students list
    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    //string representation of a course
    public String toString() {
        String result = "Course Title: '" + title + "', Credits: " + credits + "\n";
        result += "Enrolled Students:\n";
        for (Student student : enrolledStudents) {
            result += student.toString() + "\n";
        }
        return result;
    }
}
