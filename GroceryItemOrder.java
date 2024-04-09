/**
 * @author Kass Serek
 * @version 2 (April 2024)
 */

//represents a grocery item order
public class GroceryItemOrder {
    String name;
    int quantity;
    double pricePerUnit;

    //constructor for a grocery item order object with the given parameters
    public GroceryItemOrder(String name, int quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    //getter for total cost of the item order
    public double getCost() {
        return this.pricePerUnit * quantity;
    }

    //setter for the quantity of the item order
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    //getter for the quantity of the item order
    public int getAmount() {
        return this.quantity;
    }

    //getter for the name of the item
    public String getItem() {
        return this.name;
    }

    @Override
    public String toString() {
        return "[" + this.name + ", price:" + this.pricePerUnit + ", amount:" + this.quantity + "]";
    }
}