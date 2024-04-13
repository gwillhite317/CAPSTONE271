import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kass Serek
 * @version 2 (April 2024)
 */

//represents a registry of people and students
public class Registry {
    private List<Person> people;

    //constructor for a registry object
    public Registry() {
        this.people = new LinkedList<>();
    }

    //record a person with family name, given name, and date of birth
    public void recordPerson(String familyName, String givenName, int day, int month, int year) {
        Person newPerson = new Person(givenName, familyName, LocalDate.of(year, month, day));
        people.add(newPerson);
    }

    //record a student with family name, given name, student ID and date of birth
    public void recordStudent(String familyName, String givenName, int studentID, int day, int month, int year) {
        Student newStudent = new Student(studentID, givenName, familyName);
        people.add(newStudent);
    }
}
