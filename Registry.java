/**
 * @author Greyson Willhite and Amol Sayala
 * Version 4
 */


import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Registry {
    private List<Person> people;
    private Map<Integer, Map<Semester, List<Course>>> studentCourseMap;  //maps students to courses within a semester

    public Registry() { //Constructor for registry
        this.people = new LinkedList<>();
        this.studentCourseMap = new HashMap<>();
    }

    /**
     * records a student into the map by the following parameters:
     * @param familyName
     * @param givenName
     * @param studentID
     * @param day
     * @param month
     * @param year
     */

    public void recordStudent(String familyName, String givenName, int studentID, int day, int month, int year) {
        Student newStudent = new Student(studentID, givenName, familyName, LocalDate.of(year, month, day));
        people.add(newStudent);
        studentCourseMap.put(studentID, new HashMap<>()); // Initialize an empty map of semesters to courses for the new student
    }

    /**
     * Enrolls a student in a course if they are not already in it
     * @param studentID
     * @param course
     */
    public void enrollStudentInCourse(int studentID, Course course) {
        Student student = getStudentByID(studentID);
        if (student != null) {
            course.enrollStudent(student);
        } else {
            System.out.println("No student found with ID: " + studentID);  // Debug print
        }
    }


    /**
     * Takes a student out of a course if they are enrolled in it
     * @param studentID
     * @param course
     */
    public void unenrollStudentFromCourse(int studentID, Course course){
        Student student = getStudentByID(studentID);
        if (student != null){
            course.unenrollStudent(student);
        }
        else {
            System.out.println("No student found with ID: " + studentID);
        }
    }

    /**
     * If the Person is a student, identify them by their id
     * @param studentID
     * @return
     */
    public Student getStudentByID(int studentID) {
        return people.stream()
                .filter(p -> p instanceof Student && ((Student) p).getId() == studentID)
                .map(p -> (Student) p)
                .findFirst()
                .orElse(null);
    }

}
