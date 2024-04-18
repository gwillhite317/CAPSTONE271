import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    private String department;
    private String name;
    private int number;
    private int creditHours;
    public String title;
    private int credits;
    private ProfessorE instructor;
    private Semester semester;  // Reference to the Semester

    private List<Student> enrolled;
    private List<Student> waitListed;

    private List<ProfessorE> profEnrolled;

    public Course(String department, String name, int number, int creditHours) {
        this.department = department;
        this.name = name;
        this.number = number;
        this.creditHours = creditHours;
        this.enrolled = new ArrayList<>();
        this.waitListed = new ArrayList<>();
    }

    public Course(String title, int credits) {
        this.title = title;
        this.credits = credits;
        this.enrolled = new ArrayList<>();
        this.waitListed = new ArrayList<>();
    }
    public ProfessorE getInstructor() {
        return instructor;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Semester getSemester() {
        return semester;
    }

    public void enrollStudent(Student student) {
        if (!enrolled.contains(student)) {
            enrolled.add(student);
        }
    }

    public void unenrollStudent(Student student) {
        enrolled.remove(student);
    }

    public void addInstructor(ProfessorE professor) {
        if (instructor == null) {
            instructor = professor;
            professor.addCourse(this);
        }
    }


    public void removeInstructor(ProfessorE professor) {
        if (instructor == professor) {
            instructor = null;
        }
    }

    @Override
    public String toString() {
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