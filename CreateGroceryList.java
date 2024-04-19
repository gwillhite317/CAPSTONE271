import java.time.LocalDate;
import java.util.Scanner;
import java.util.Map;

public class CreateGroceryList {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Grocery List Creator");
        Person person = createShopper();
        GroceryStore wholeFoods = createWholeFoodsStore();
        GroceryStore target = createTargetStore();
        GroceryList groceryList = new GroceryList();
        chooseStoreAndItems(wholeFoods, target, groceryList);
        groceryList.setPerson(person);
        System.out.println("\nYour Grocery List:");
        System.out.println(groceryList.finalList());

        scanner.close();
    }

    private static Person createShopper() {
        System.out.print("Enter your first name: ");
        String givenNames = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String familyName = scanner.nextLine();
        System.out.print("Enter birth year: ");
        int year = scanner.nextInt();
        System.out.print("Enter birth month: ");
        int month = scanner.nextInt();
        System.out.print("Enter birth day: ");
        int day = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Are you a student or professor? (yes/no): ");
        String hasDiscount = scanner.nextLine().toLowerCase();

        if (hasDiscount.equals("yes")) {
            System.out.print("Which? (professor/student): ");
            String whichDiscount = scanner.nextLine().toLowerCase();

            if (whichDiscount.equals("student")) {
                System.out.print("Enter your student ID: ");
                int studentID = scanner.nextInt();
                scanner.nextLine();
                return new Student(studentID, familyName, givenNames, LocalDate.of(year, month, day));
            } else if (whichDiscount.equals("professor")) {
                System.out.print("What is your title?: ");
                String title = scanner.nextLine();
                return new ProfessorE(title, familyName, LocalDate.of(year, month, day));
            }
        } else {
            return new Person(familyName, givenNames, LocalDate.of(year, month, day));
        }
        return null;
    }

    private static void chooseStoreAndItems(GroceryStore WholeFoods, GroceryStore target, GroceryList groceryList) {
        System.out.println("\nAvailable Grocery Stores:");
        System.out.println("1. Whole foods");
        System.out.println("2. Target");

        GroceryStore chosenStore = null;
        while (chosenStore == null) {
            System.out.print("Enter the number of the store you want to shop at: ");
            int storeChoice = readInt();
            if (storeChoice == 1) {
                chosenStore = WholeFoods;
            } else if (storeChoice == 2) {
                chosenStore = target;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        addItems(chosenStore, groceryList);
    }

    private static void addItems(GroceryStore store, GroceryList groceryList) {
        System.out.println("\nAvailable Items :");
        Map<String, GroceryItem> stock = store.getStock();
        stock.forEach((name, item) -> System.out.println(name + " - $" + item.getUnitPrice() + " in " + item.getLocation()));

        System.out.println("Enter the name of the item you want to add (or 'done' to finish):");
        String itemName = scanner.nextLine();
        while (!itemName.equalsIgnoreCase("done")) {
            if (stock.containsKey(itemName)) {
                System.out.print("Enter quantity: ");
                int quantity = readInt();
                GroceryItemOrder order = new GroceryItemOrder(itemName, quantity, stock.get(itemName).getUnitPrice());
                groceryList.add(order);
                System.out.println(quantity + " " + itemName + " added to the list.");
            } else {
                System.out.println("Item not found.");
            }
            System.out.println("Enter the name of the next item you want to add (or 'done' to finish):");
            itemName = scanner.nextLine();
        }
    }
    private static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            scanner.nextLine();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    private static GroceryStore createWholeFoodsStore() {
        GroceryStore WholeFoods = new GroceryStore("Whole Foods");
        WholeFoods.addGroceryItem(new GroceryItem("Apples", 0.99, "Aisle 1"), 0.99, "Aisle 1");
        WholeFoods.addGroceryItem(new GroceryItem("Bread", 1.29, "Aisle 2"), 1.29, "Aisle 2");
        WholeFoods.addGroceryItem(new GroceryItem("Milk", 0.89, "Aisle 3"), 0.89, "Aisle 3");
        WholeFoods.addGroceryItem(new GroceryItem("Snapper", 5.99, "Fishmonger counter"), 5.99, "Fishmonger counter");
        WholeFoods.addGroceryItem(new GroceryItem("Steak", 1.29, "Steak"), 9.99, "Butcher Counter");
        WholeFoods.addGroceryItem(new GroceryItem("Cilantro", 0.79, "Aisle 4"),0.79, "Aisle 4");
        WholeFoods.addGroceryItem(new GroceryItem("Parsley", 0.89, "Aisle 4"), .89, "Aisle 4");

        return WholeFoods;
    }

    private static GroceryStore createTargetStore() {
        GroceryStore target = new GroceryStore("Target");
        target.addGroceryItem(new GroceryItem("Eggs", 2.09, "Aisle 1"), 2.09, "Aisle 1");
        target.addGroceryItem(new GroceryItem("Pasta", 0.99, "Aisle 2"), 0.99, "Aisle 2");
        target.addGroceryItem(new GroceryItem("Milk", 1.49, "Aisle 3"), 1.49, "Aisle 3");
        target.addGroceryItem(new GroceryItem("Chicken", 5.49, "Aisle 4"), 5.49, "Aisle 4");
        target.addGroceryItem(new GroceryItem("Flour", 4.99, "Aisle 5"), 4.99, "Aisle 5");
        target.addGroceryItem(new GroceryItem("Olives", 1.99, "Aisle 6"), 1.99, "Aisle 6");
        target.addGroceryItem(new GroceryItem("Apples",.49, "Aisle 7"), .49, "Aisle 7");
        target.addGroceryItem(new GroceryItem("Wild Rice", 3.99, "Aisle 8"), 3.99, "Aisle 8");
        return target;
    }
}

