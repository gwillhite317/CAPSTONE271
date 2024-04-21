

/**
 * @author Kass Serek
 * @version 2 (April 2024)
 */

//represents a grocery item
public class GroceryItem {
    private String name;
    private double unitPrice;
    private String location;

    //constructor for a grocery item object with the given parameters
    public GroceryItem(String name, double unitPrice, String location) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.location = location;
    }

    //getter for the name of the grocery item
    public String getName() {
        return name;
    }

    //getter for the unit price of the item
    public double getUnitPrice() {
        return unitPrice;
    }

    //getter for the location of the item in the store
    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "[" + name + ", price: $" + unitPrice + ", location: " + location + "]";
    }
}
