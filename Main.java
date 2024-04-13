import java.util.Scanner;
import java.util.Map;

/**
 * @author Kass Serek
 * @version 1 (April 2024)
 */

//responsible for managing grocery list creation as the result of interaction
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Grocery List Creator");

        System.out.print("Are you a student? (yes/no): ");
        String isStudent = scanner.nextLine().toLowerCase();

        Person person;

        //person object based on user input
        if (isStudent.equals("yes")) {
            System.out.print("Enter your first name: ");
            String givenNames = scanner.nextLine();
            System.out.print("Enter your last name: ");
            String familyName = scanner.nextLine();
            System.out.print("Enter your student ID: ");
            int studentID = scanner.nextInt();

            person = new Student(studentID, givenNames, familyName);
        } else {
            System.out.print("Enter your first name: ");
            String givenNames = scanner.nextLine();
            System.out.print("Enter your last name: ");
            String familyName = scanner.nextLine();

            person = new Person(givenNames, familyName);
        }

        //create grocery items
        GroceryItem apples = new GroceryItem("Apples", 2.0, "Produce");
        GroceryItem bread = new GroceryItem("Bread", 1.5, "Bakery");
        GroceryItem milk = new GroceryItem("Milk", 3.0, "Dairy");
        GroceryItem eggs = new GroceryItem("Eggs", 2.5, "Dairy");
        GroceryItem pasta = new GroceryItem("Pasta", 1.0, "Pasta");
        GroceryItem rice = new GroceryItem("Rice", 2.0, "Grains");
        GroceryItem chicken = new GroceryItem("Chicken", 5.0, "Meat");

        //create grocery stores
        GroceryStore aldi = new GroceryStore("Aldi");
        aldi.addGroceryItem(apples, 2.0,"Aisle 1");
        aldi.addGroceryItem(bread, 1.5, "Aisle 2");
        aldi.addGroceryItem(milk, 3.0, "Aisle 3");
        aldi.addGroceryItem(eggs, 2.5, "Aisle 3");

        GroceryStore target = new GroceryStore("Target");
        target.addGroceryItem(eggs, 2.7, "Aisle 1"); //different price at target
        target.addGroceryItem(pasta, 1.0, "Aisle 2");
        target.addGroceryItem(rice, 2.0, "Aisle 3");
        target.addGroceryItem(chicken, 5.0, "Aisle 4");
        target.addGroceryItem(bread, 3.0, "Aisle 5"); //different price at target

        //create grocery list
        GroceryList groceryList = new GroceryList();

        System.out.println("\nAvailable Grocery Stores:");
        System.out.println("1. Aldi");
        System.out.println("2. Target");

        int storeChoice = 0;
        while (storeChoice != 1 && storeChoice != 2) {
            System.out.print("Enter the number of the store you want to shop at: ");
            if (scanner.hasNextInt()) {
                storeChoice = scanner.nextInt();
                if (storeChoice == 1) {
                    addItemsFromStore(aldi, groceryList, scanner);
                } else if (storeChoice == 2) {
                    addItemsFromStore(target, groceryList, scanner);
                } else {
                    System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        groceryList.setPerson(person);
        System.out.println("\nYour Grocery List:");
        System.out.println(groceryList.finalList());

        scanner.close();
    }

    //add items from grocery store to the grocery list
    private static void addItemsFromStore(GroceryStore store, GroceryList groceryList, Scanner scanner) {
        String itemName;
        int quantity;

        System.out.println("\nAvailable Items:");
        Map<String, GroceryItem> stock = store.getStock();
        int count = 1;
        for (String item : stock.keySet()) {
            System.out.println(count + ". " + item + " - $" + store.getPrice(item));
            count++;
        }

        boolean done = false;
        while (!done) {
            System.out.print("Enter the number of the item you want to add (or 0 to finish): ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 0) {
                    done = true;
                    continue;
                }
                if (choice < 1 || choice > stock.size()) {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
                itemName = (String) stock.keySet().toArray()[choice - 1];

                System.out.print("Enter quantity: ");
                if (scanner.hasNextInt()) {
                    quantity = scanner.nextInt();
                    scanner.nextLine();

                    double price = store.getPrice(itemName);
                    GroceryItemOrder itemOrder = new GroceryItemOrder(itemName, quantity, price);
                    groceryList.add(itemOrder);
                } else {
                    System.out.println("Invalid input for quantity. Please enter a number.");
                    scanner.next();
                }
            } else {
                System.out.println("Invalid input for item number. Please enter a number.");
                scanner.next();
            }
        }
    }
}