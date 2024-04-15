

import java.time.LocalDate;
import java.util.Objects;


public class Person implements Comparable<Person>, Shopper {

    // Constant to represent the age of majority
    private static final int YEAR_OF_MAJORITY = 18;

    // Instance variables for the Person class
    private String familyName;  // The family name of the person
    private String givenNames;  // The given name(s) of the person
    final LocalDate DOB;  // The date of birth of the person

    // Constructor without birthdate
    public Person(String fName, String lName) {
        familyName = lName;
        givenNames = fName;
        DOB = null; // No birthdate provided
    }

    // Constructor with birthdate
    public Person(String fName, String lName, int day, int month, int year) {
        familyName = lName;
        givenNames = fName;
        DOB = LocalDate.of(year, month, day); // Set the date of birth
    }

    // Constructor with birthdate as LocalDate
    public Person(String fName, String lName, LocalDate date){
        familyName = lName;
        givenNames = fName;
        DOB = date; // Set the date of birth
    }

    // Default constructor
    public Person () {
        familyName = "";
        givenNames = "";
        DOB = null;
    }

    /**
     * Method to check if the person has reached the age of majority
     *
     * @return true if 18 or older
     */
    public boolean isEighteen() {
        return DOB != null && !DOB.plusYears(YEAR_OF_MAJORITY).isAfter(LocalDate.now());
    }

    /**
     * Method to check if two Person objects are the same
     *
     * @param that other Person
     */
    public boolean equals(Object that) {
        if (!(that instanceof Person)) {
            return false;
        }
        Person otherPerson = (Person) that;
        return this.familyName.equals(otherPerson.familyName) &&
                this.givenNames.equals(otherPerson.givenNames) &&
                this.DOB.equals(otherPerson.DOB);
    }
    @Override
    public int hashCode() {
        return Objects.hash(familyName, givenNames, DOB);
    }

    public int compareTo(Person o){
        int result;
        result = familyName.compareTo(o.familyName);
        if (result == 0) {
            result = givenNames.compareTo(o.givenNames);
            if (result == 0)
                result = DOB.compareTo(o.DOB);
        }
        return result;
    }


    @Override
    public String toString() {
        return givenNames + " " + familyName + (DOB != null ? " (" + DOB + ")" : "");
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }

}
