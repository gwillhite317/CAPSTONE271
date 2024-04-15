
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person {
    private int id;
    private List<Course> courses; // List to maintain courses regardless of semester
    private Map<Semester, List<Course>> semesterCourses; // Map semesters to courses

    public Student(int id, String familyName, String givenNames, LocalDate DOB) {
        super(familyName, givenNames, DOB);
        this.id = id;
        this.courses = new ArrayList<>();
        this.semesterCourses = new HashMap<>();
    }
    public int getId() {
        return id;
    }

    // Add course with semester consideration
    public void addCourse(Course course, Semester semester) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this);
            semesterCourses.computeIfAbsent(semester, k -> new ArrayList<>()).add(course);
        }
    }

    // Drop course with semester consideration
    public void dropCourse(Course course, Semester semester) {
        if (courses.remove(course)) {
            course.unenrollStudent(this);
            List<Course> semesterCoursesList = semesterCourses.get(semester);
            if (semesterCoursesList != null) {
                semesterCoursesList.remove(course);
            }
        }
    }

    // Get courses for a specific semester
    public List<Course> getCoursesForSemester(Semester semester) {
        return semesterCourses.getOrDefault(semester, new ArrayList<>());
    }

    @Override
    public String toString() {
        return super.toString() + " ID: " + id;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.9; // Apply a discount of 10%, assuming for fees or services
    }
}
