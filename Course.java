/**
 * @Author Greyson Willhite
 * @version 4
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    private String department;  //Academic department a course is a part of
    private String name;   // Name of the course
    private int number;   //Course number/ID
    private int creditHours;    //Credit hours for a course
    public String title;   // name of the course
    private int credits;  //  credits for completing the course
    private ProfessorE instructor;  //instructor for course

    private List<ProfessorE> instructors;  //list for multiple instructors
    private Semester semester;  // Reference to the Semester

    private List<Student> enrolled;  //currently enrolled students

    private List<Student> waitListed;  //students waitlisted for a course

    /**
     * Default constructer for a course
     * @param department
     * @param name
     * @param number
     * @param creditHours
     */

    public Course(String department, String name, int number, int creditHours) {
        this.department = department;
        this.name = name;
        this.number = number;
        this.creditHours = creditHours;
        this.enrolled = new ArrayList<>();
        this.waitListed = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getCreditHours(){
        return creditHours;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Semester getSemester() {
        return semester;
    }

    //enrolls student in a course
    public void enrollStudent(Student student) {  //puts student in enrolled list, used by registry
        if (!enrolled.contains(student)) {
            enrolled.add(student);
        }
    }

    //unenroll student in a course
    public void unenrollStudent(Student student) {  //removes student from enrolled list, used in registry
        enrolled.remove(student);
    }

    public List<Student> getEnrolled() {
        return enrolled;  // Return the list of enrolled students
    }


    public void addInstructor(ProfessorE professor) {
        this.instructor = professor;  // Directly set the instructor to a course
        professor.addCourse(this);    // Ensure bidirectional link
    }

    // Method for removing an instructor from a course
    public void removeInstructor(ProfessorE professor) {
        if (this.instructor.equals(professor)) {
            this.instructor = null;
            professor.removeCourse(this);
        }
    }

    // Getter method for instructor
    public ProfessorE getInstructor() {
        return instructor;
    }


    @Override
    public String toString() {  //To string for being enrolled in a course
        StringBuilder roster = new StringBuilder(title + " (" + credits + " credits): ");
        if (enrolled.isEmpty()) {
            roster.append("\nNo students enrolled in the course");
        } else {
            roster.append(enrolled.stream()
                    .map(Student::toString)
                    .collect(Collectors.joining("\n")));
        }
        return roster.toString();
    }
}