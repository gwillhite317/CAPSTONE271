import java.util.HashMap;
import java.util.Map;

/**
 * @author Kass Serek
 * @version 2 (April 2024)
 */

//represents a grocery store
public class GroceryStore {
    private String item;
    private Map<String, GroceryItem> stock;
    private Map<String, Double> prices;
    private Map<String, String> locations;

    public GroceryStore(String item) {
        this.item = item;
        this.stock = new HashMap<>();
        this.prices = new HashMap<>();
        this.locations = new HashMap<>();
    }

    //add a grocery item to the store
    public void addGroceryItem(GroceryItem item, double price, String location) {
        stock.put(item.getName(), item);
        prices.put(item.getName(), price);
        locations.put(item.getName(), location);
    }

    //get the price of a grocery item in the store
    public double getPrice(String itemName) {
        return prices.getOrDefault(itemName, 0.0);
    }

    //get the location of a grocery item in the store
    public String getLocation(String itemName) {
        return locations.get(itemName);
    }

    //get the stock of the store
    public Map<String, GroceryItem> getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Grocery Store: " + item + "\nStock: " + stock.keySet();
    }
}
