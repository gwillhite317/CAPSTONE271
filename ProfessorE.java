
import java.util.ArrayList;

class ProfessorE {

    private String title;

    private String name;

    private ArrayList<Course> courses;


    public ProfessorE(String title, String name) {
        this.title = title;

        this.name = name;

        this.courses = new ArrayList<>();

    }

    public void addCourse(Course course) {

        if (!courses.contains(course))
        {
            courses.add(course);

            course.addInstructor(this);


        }

    }
    public void removeCourse(Course course) {

        if (courses.contains(course))
        {

            courses.remove(course);
// Removes the course from the list.

            course.removeInstructor(this);
// Unassigns the professor from teaching the course.

        }

    }





    @Override

    public String toString() {
        String result = "Professor: " + title + " " + name + "\n";

        result += "Teaching Courses:\n";

        for (Course course : courses) {

            result += "- " + course.toString() + "\n";

        }

        return result;

    }

}
