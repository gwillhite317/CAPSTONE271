/**
 * @author Greyson Willhite
 * @version 3
 */

import java.util.ArrayList;
import java.util.List;
public class Semester {
    private String semesterName;
    private List<Course> courses;
    private Registry studentRegistry;
    private String name;



    /**
     * Constructor to create a new semester with a specified name and student registry.
     *
     * @param semesterName    the name of the semester
     * @param studentRegistry the registry for managing student enrollments
     */
    public Semester(String semesterName, Registry studentRegistry) {
        this.semesterName = semesterName;
        this.courses = new ArrayList<>();
        this.studentRegistry = studentRegistry;
    }
    public String getName(){
        return name;
    }
    /**
     * Adds a course to the semester if it is not already present.
     *
     * @param course the course to add
     */
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    /**
     * Removes course if course is present
     * @param course
     */
    public void removeCourse(Course course) {
        if (courses.contains(course)){
            courses.remove(course);
        }

    }

    /**
     * Finds courses for a certain professor
     * @param professor
     * @return courses professor teaches
     */
    public List<Course> findCoursesByProfessor(ProfessorE professor) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getInstructor() != null && course.getInstructor().equals(professor)) {
                result.add(course);
            }
        }
        return result;
    }
}


