import java.util.ArrayList;
import java.util.Comparator;

public class ShopManager {
    private ArrayList<Component> inventory;

    // Constructor initializes the empty list
    public ShopManager() {
        this.inventory = new ArrayList<>();
        // Optional: Pre-populate with some starter items for testing
        addDefaultItems();
    }

    // 1. Add a component
    public void addComponent(Component item) {
        inventory.add(item);
        System.out.println("✔️ Item added successfully!");
    }

    // 2. View all components
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("⚠️ The inventory is completely empty.");
            return;
        }
        System.out.println("\n--- CURRENT INVENTORY ---");
        for (Component item : inventory) {
            System.out.println(item);
        }
    }

    // 3. Find a component by ID (Helper method used for updates/deletes)
    public Component findById(String id) {
        for (Component item : inventory) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    // 4. Delete a component
    public boolean deleteComponent(String id) {
        Component item = findById(id);
        if (item != null) {
            inventory.remove(item);
            return true;
        }
        return false;
    }

    // 5. Rearrange: Sort by Price (Lowest to Highest)
    public void sortByPrice() {
        if (inventory.isEmpty()) return;
        
        // Sorting using a built-in Java Double comparator
        inventory.sort(Comparator.comparingDouble(Component::getPrice));
        System.out.println("🔄 Inventory sorted by price (Ascending).");
        displayInventory();
    }

    // 6. Filter: Show items matching a specific category
    public void filterByCategory(String category) {
        boolean found = false;
        System.out.println("\n--- FILTER RESULTS FOR: " + category.toUpperCase() + " ---");
        for (Component item : inventory) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found in this category.");
        }
    }

    // Mock data so you don't have to type items every time you start the app
    private void addDefaultItems() {
        inventory.add(new Component("P001", "RTX 4070 Super", "GPU", 650.00, 5));
        inventory.add(new Component("P002", "Ryzen 7 7800X3D", "CPU", 390.00, 3));
        inventory.add(new Component("P003", "32GB DDR5 Corsair", "RAM", 120.00, 8));
        inventory.add(new Component("P004", "1TB NVMe Samsung", "Storage", 95.00, 12));
    }
}
