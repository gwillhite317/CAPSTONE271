
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Locus {
    private Set<Course> courses = new HashSet<>();

    static class Course {
        private String departmentName;
        private int courseNumber;
        private String givenName;
        private int maxCapacity;
        private Set<String> registeredStudents = new HashSet<>();
        private Set<String> waitlistedStudents = new HashSet<>();
        private Semester semester; // Adding Semester reference

        public Course(String departmentName, int courseNumber, String givenName, int maxCapacity) {
            this.departmentName = departmentName;
            this.courseNumber = courseNumber;
            this.givenName = givenName;
            this.maxCapacity = maxCapacity;
        }

        public void setSemester(Semester semester) {
            this.semester = semester;
        }

        public Semester getSemester() {
            return semester;
        }

        public void addStudent(String studentID) {
            if (registeredStudents.size() < maxCapacity) {
                registeredStudents.add(studentID);
            } else {
                waitlistedStudents.add(studentID);
            }
        }

        public boolean removeStudent(String studentID) {
            if (registeredStudents.remove(studentID)) {
                possiblyPromoteWaitlistedStudent();
                return true;
            }
            return waitlistedStudents.remove(studentID);
        }

        private void possiblyPromoteWaitlistedStudent() {
            if (!waitlistedStudents.isEmpty()) {
                String firstWaitlisted = waitlistedStudents.iterator().next();
                registeredStudents.add(firstWaitlisted);
                waitlistedStudents.remove(firstWaitlisted);
            }
        }

        @Override
        public String toString() {
            return String.format("[%s %d (%s) Registered: %s]", departmentName, courseNumber, givenName, registeredStudents);
        }
    }

    public void recordCourse(String departmentName, int courseNumber, String title, int maxCapacity, Semester semester) {
        Course newCourse = new Course(departmentName, courseNumber, title, maxCapacity);
        newCourse.setSemester(semester); // Link the course with a semester
        courses.add(newCourse);
    }

    public void enrollStudent(String studentID, String departmentName, int courseNumber) {
        Course course = findCourse(departmentName, courseNumber);
        if (course != null) {
            course.addStudent(studentID);
        }
    }

    public boolean removeStudent(String studentID, String departmentName, int courseNumber) {
        Course course = findCourse(departmentName, courseNumber);
        return course != null && course.removeStudent(studentID);
    }

    private Course findCourse(String departmentName, int courseNumber) {
        return courses.stream()
                .filter(c -> c.departmentName.equals(departmentName) && c.courseNumber == courseNumber)
                .findFirst()
                .orElse(null);
    }

    public String reportRegistrations() {
        return courses.stream()
                .map(Course::toString)
                .collect(Collectors.joining(",\n"));
    }

    @Override
    public String toString() {
        return "Courses:\n" + reportRegistrations();
    }
}
