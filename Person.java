import java.time.LocalDate;

/**
 * @author Kass Serek
 * @version 3 (April 2024)
 */

//represents a person with a family name, given name(s), and a date of birth
public class Person implements Comparable<Person>, Shopper {
    private static final int YEAR_OF_MAJORITY = 18;
    private String familyName;
    private String givenNames;
    final LocalDate dob;

    //constructor for a Person object with the given parameters
    public Person(String fN, String gNs) {
        familyName = fN;
        givenNames = gNs;
        dob = null;
    }

    //constructor for a Person object with the given parameters
    public Person(String fN, String gNs, int day, int month, int year) {
        familyName = gNs;
        givenNames = fN;
        dob = LocalDate.of(year, month, day);
    }

    //constructor for a Person object with the given parameters
    public Person(String fN, String gNs, LocalDate date) {
        familyName = gNs;
        givenNames = fN;
        dob = date;
    }

    //constructor for a Person object
    public Person() {
        familyName = "";
        givenNames = "";
        dob = null;
    }

    //check if the person is 18 or older
    public boolean isEighteen() {
        return !(dob.plusYears(YEAR_OF_MAJORITY).isAfter(LocalDate.now()));
    }

    //checks if two people are the same
    public boolean equals(Object that) {
        if (!(that instanceof Person)) {
            return false;
        }
        return this.familyName.equals(((Person)that).familyName) && this.givenNames.equals(((Person)that).givenNames) && this.dob.equals(((Person)that).dob);
    }

    //compare two people based on their family names, given names, and date of birth
    public int compareTo(Person o) {
        int result;
        result = familyName.compareTo(o.familyName);
        if (result == 0) {
            result = givenNames.compareTo(o.givenNames);
            if (result == 0)
                result = dob.compareTo(o.dob);
        }
        return result;
    }

    //string representation of a person object
    public String toString() {
        return givenNames + "" + familyName;
    }

    //check if the person can marry (is of legal age)
    public boolean canMarry() {
        return isEighteen();
    }

    //getter for family name
    public String getFamilyName() {
        return familyName;
    }

    //getter for given names
    public String getGivenNames() {
        return givenNames;
    }

    //getter for date of birth
    public LocalDate getDob() {
        return dob;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }
}
