

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

    // Constructor with birthdate as LocalDate

    public Person(String familyName, String givenNames, LocalDate date){
        this.familyName = familyName;
        this.givenNames = givenNames;
        DOB = date;
    }

    public String getFamilyName() {
        return familyName;
    }
    public String getGivenName() {
        return givenNames;
    }

    public String getName(){
        return givenNames + "" + familyName;
    }
    // Constructor with birthdate

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
     * @param
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(familyName, person.familyName) &&
                Objects.equals(givenNames, person.givenNames) &&
                Objects.equals(DOB, person.DOB);  // This is null-safe
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
