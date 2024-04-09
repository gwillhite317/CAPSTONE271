import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Registry {
    private List<Person> people;

    public Registry() {
        this.people = new LinkedList<>();
    }

    public void recordStudent(String familyName, String givenName, int studentID, int day, int month, int year) {

        Student newStudent = new Student(studentID, givenName, familyName, LocalDate.of(year, month, day));
        people.add(newStudent);
    }
}
