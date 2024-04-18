
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Registry {
    private List<Person> people; // List to keep track of all people
    private Map<Integer, List<Course>> studentCourseMap; // Map to keep track of student IDs and their courses

    public Registry() {
        this.people = new LinkedList<>();
        this.studentCourseMap = new HashMap<>();
    }

    public void recordStudent(String familyName, String givenName, int studentID, int day, int month, int year) {
        Student newStudent = new Student(studentID, givenName, familyName, LocalDate.of(year, month, day));
        people.add(newStudent);
        studentCourseMap.put(studentID, new LinkedList<>()); // Initialize an empty list of courses for the new student
    }

    public void enrollStudentInCourse(int studentID, Course course) {
        if (studentCourseMap.containsKey(studentID)) {
            studentCourseMap.get(studentID).add(course);
            course.enrollStudent(getStudentByID(studentID)); // Assuming Course class has an enrollStudent method
        }
    }

    public void unenrollStudentFromCourse(int studentID, Course course) {
        if (studentCourseMap.containsKey(studentID) && studentCourseMap.get(studentID).contains(course)) {
            studentCourseMap.get(studentID).remove(course);
            course.unenrollStudent(getStudentByID(studentID)); // Assuming Course class has an unenrollStudent method
        }
    }

    public Student getStudentByID(int studentID) {
        return people.stream()
                .filter(p -> p instanceof Student && ((Student) p).getId() == studentID)
                .map(p -> (Student) p)
                .findFirst()
                .orElse(null);
    }

    public List<Course> getCoursesForStudent(int studentID) {
        return studentCourseMap.getOrDefault(studentID, new LinkedList<>());
    }
}
