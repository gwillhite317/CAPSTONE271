

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class ProfessorE extends Person {
    private String title;
    private String name;

    final LocalDate dob;
    private List<Course> courses;  // Existing courses taught by the professor
    private List<Semester> semesters; // Semesters the professor is teaching in

    public ProfessorE(String title, String name, LocalDate dob) {
        this.title = title;
        this.dob = dob;
        this.name = name;
        this.courses = new ArrayList<>();
        this.semesters = new ArrayList<>();
    }

    // Adds a course to the professor's list and registers the professor as teaching this course
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addInstructor(this);  // Assume this method properly links the course back to the professor
        }
    }
    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }
    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.removeInstructor(this);  // Assume this method properly unlinks the professor from the course
        }
    }

    // Adds a semester to the professor's teaching schedule
    public void addSemester(Semester semester) {
        if (!semesters.contains(semester)) {
            semesters.add(semester);
        }
    }

    // Removes a semester from the professor's teaching schedule
    public void removeSemester(Semester semester) {
        semesters.remove(semester);
    }

    // Get the list of courses for a specific semester
    public List<Course> getCoursesForSemester(Semester semester) {
        List<Course> semesterCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getSemester().equals(semester)) {
                semesterCourses.add(course);
            }
        }
        return semesterCourses;
    }

    // Returns a string representation of the professor's courses
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Professor: " + title + " " + name + "\nTeaching Courses:\n");
        for (Course course : courses) {
            result.append("- ").append(course.toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.95;
    }
}
