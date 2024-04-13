import java.util.HashSet;
import java.util.Set;

/**
 * @author Kass Serek
 * @version 2 (April 2024)
 */

//represents a collection of courses and operations related to courses and students
class Locus {
    private Set<Course> courses = new HashSet<>();

    //represents a course with a department name, course number, given name, and maximum capacity
    static class Course {
        private String departmentName;
        private int courseNumber;
        private String givenName;
        private int maxCapacity;
        private Set<String> registeredStudents = new HashSet<>();
        private Set<String> waitlistedStudents = new HashSet<>();

        //constructor for a course object with the given parameters
        public Course(String departmentName, int courseNumber, String givenName, int maxCapacity) {
            this.departmentName = departmentName;
            this.courseNumber = courseNumber;
            this.givenName = givenName;
            this.maxCapacity = maxCapacity;
        }

        //add a student to the course or wait list
        public void addStudent(String studentName) {
            if (registeredStudents.size() < maxCapacity) {
                registeredStudents.add(studentName);
            } else {
                waitlistedStudents.add(studentName);
            }
        }

        //remove a student from the course or wait list
        public boolean removeStudent(String studentName) {
            if (registeredStudents.remove(studentName)) {
                if (!waitlistedStudents.isEmpty()) {
                    String firstWaitlisted = waitlistedStudents.iterator().next();
                    registeredStudents.add(firstWaitlisted);
                    waitlistedStudents.remove(firstWaitlisted);
                }
                return true;
            } else if (waitlistedStudents.remove(studentName)) {
                return true;
            }
            return false;
        }

        //string representation of a course
        public String toString() {
            return "[" + departmentName + " " + courseNumber + " (" + givenName + ") " + registeredStudents + "]";
        }

        //getter for wait listed students
        public Set<String> getWaitlistedStudents() {
            return waitlistedStudents;
        }
    }

    //record a course with a given department name, course number, title, and maximum capacity
    public void recordCourse(String departmentName, int courseNumber, String title, int maxCapacity) {
        Course newCourse = new Course(departmentName, courseNumber, title, maxCapacity);
        courses.add(newCourse);
    }

    //enroll a student in a course
    public void enrollStudent(String familyName, String givenName, String departmentName, int courseNumber) {
        for (Course course : courses) {
            if (course.departmentName.equals(departmentName) && course.courseNumber == courseNumber) {
                course.addStudent(givenName);
                return;
            }
        }
    }

    //remove a student from a course
    public boolean removeStudent(String familyName, String givenName, String departmentName, int courseNumber) {
        for (Course course : courses) {
            if (course.departmentName.equals(departmentName) && course.courseNumber == courseNumber) {
                return course.removeStudent(givenName);
            }
        }
        return false;
    }

    //generate a report of registered students in each course
    public String reportRegistrations() {
        String result = "";
        for (Course course : courses) {
            result += "[" + course.departmentName + " " + course.courseNumber + " " + course.givenName + " " + course.registeredStudents + "],\n";
        }
        return result;
    }

    //generate a report of wait listed students in each course
    public String reportWaitListed() {
        String result = "";
        for (Course course : courses) {
            result += "[" + course.departmentName + " " + course.courseNumber + " " + course.waitlistedStudents + "],\n";
        }
        return result;
    }

    //string representation of courses
    public String toString() {
        return "Registered after some drop:\n" + courses.toString();
    }
}

