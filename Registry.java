


import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Registry {
    private List<Person> people;
    private Map<Integer, Map<Semester, List<Course>>> studentCourseMap;

    public Registry() {
        this.people = new LinkedList<>();
        this.studentCourseMap = new HashMap<>();
    }

    public void recordStudent(String familyName, String givenName, int studentID, int day, int month, int year) {
        Student newStudent = new Student(studentID, givenName, familyName, LocalDate.of(year, month, day));
        people.add(newStudent);
        studentCourseMap.put(studentID, new HashMap<>()); // Initialize an empty map of semesters to courses for the new student
    }

    public void enrollStudentInCourse(int studentID, Course course) {
        Student student = getStudentByID(studentID);
        if (student != null) {
            course.enrollStudent(student);
        } else {
            System.out.println("No student found with ID: " + studentID);  // Debug print
        }
    }


    public void unenrollStudentFromCourse(int studentID, Course course){
        Student student = getStudentByID(studentID);
        if (student != null){
            course.unenrollStudent(student);
        }
        else {
            System.out.println("No student found with ID: " + studentID);
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
        List<Course> allCourses = new ArrayList<>();
        Map<Semester, List<Course>> semestersCourses = studentCourseMap.get(studentID);

        if (semestersCourses != null) {
            for (List<Course> courses : semestersCourses.values()) {
                allCourses.addAll(courses);
            }
        }
        return allCourses;
    }
}
