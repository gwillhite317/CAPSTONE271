/**
 * @author Greyson Willhite
 * @version 4
 */

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
        // Setter and getter methods for the semester
        public void setSemester(Semester semester) {
            this.semester = semester;
        }

        public Semester getSemester() {
            return semester;
        }


        //Ads a student to the course, checking capacity
        public void addStudent(String studentID) {
            if (registeredStudents.size() < maxCapacity) {
                registeredStudents.add(studentID);
            } else {
                waitlistedStudents.add(studentID);
            }
        }
        //Removes a student form the course and tries to promote a waitlisted student
        public boolean removeStudent(String studentID) {
            if (registeredStudents.remove(studentID)) {
                possiblyPromoteWaitlistedStudent();
                return true;
            }
            return waitlistedStudents.remove(studentID);
        }


        //Helper method to promote the first student on the waitlist
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

    //Compiles and returns a report of all courses along with registrations
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
