/**
 * @author Kass Serek
 * @version 2 (April 2024)
 */

//represents a grocery list
public class GroceryList {
    private GroceryItemOrder[] list; //array for groceries
    int num; //number of items in the list
    private Person person;

    //constructor for a grocery list object with the given parameters
    public GroceryList() {
        //list that can have 10 items
        list = new GroceryItemOrder[10];
        num = 0;
        System.out.println("Creating new list");
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    //add item to the grocery list
    public void add(GroceryItemOrder item) {
        if (num < 10) {
            list[num] = item;
            num += 1;
            System.out.println("Adding " + item.getAmount() + " " + item.getItem() + " to the list");
        } else {
            System.out.println("Cannot add " + item.getAmount() + " " + item.getItem() + " to the list. Max limit of list has been reached");
        }


    }

    public double getTotalCost() {
        double cost = 0.00;
        for (int i = 0; i < num; i++) {
            cost += list[i].getCost();
        }
        return cost;
    }

    //apply discount only if the person is a student
    public double applyDiscountIfStudent(double totalAmount) {
        if (person instanceof Student) {
            return person.applyDiscount(totalAmount);
        } else {
            return totalAmount;
        }
    }

    //print final list with total cost including discount if applicable
    public String finalList() {
        System.out.print("The price of ");
        for (int i = 0; i < num; i++) {
            System.out.print(list[i].getAmount() + " " + list[i].getItem());

            if (i < num - 1) {
                if (num == 2) {
                    System.out.print(" and ");
                } else if (i == num - 2) {
                    System.out.print(", and ");
                } else {
                    System.out.print(", ");
                }
            }
        }

        double totalCost = getTotalCost();
        System.out.print(" is $" + String.format("%.2f", totalCost));

        double discountedTotalCost = applyDiscountIfStudent(totalCost);
        if (person instanceof Student) {
            System.out.print(" (after student discount: $" + String.format("%.2f", discountedTotalCost) + ")");
        }

        return "";
    }
}
