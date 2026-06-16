import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShopManager manager = new ShopManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=================================");
        System.out.println("    WELCOME TO CTRL S SYSTEMS    ");
        System.out.println("=================================");

        // The Application Cycle Loop
        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. View Full Inventory");
            System.out.println("2. Add New Component");
            System.out.println("3. Update Existing Item");
            System.out.println("4. Filter/Rearrange Options");
            System.out.println("5. Remove Item from Stock");
            System.out.println("0. Exit Management Engine");
            System.out.print("Select an option: ");
            
            // Basic scanner safety configuration to prevent crash on text entry
            while (!scanner.hasNextInt()) {
                System.out.print("⚠️ Invalid input. Choose a number from the menu: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer newline trailing trace

            switch (choice) {
                case 1:
                    manager.displayInventory();
                    break;

                case 2:
                    System.out.print("Enter unique ID (e.g., P005): ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Component Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Category (CPU/GPU/RAM etc): ");
                    String cat = scanner.nextLine();
                    System.out.print("Enter Retail Unit Price (€): ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Initial Stock Level: ");
                    int stock = scanner.nextInt();
                    
                    Component newItem = new Component(id, name, cat, price, stock);
                    manager.addComponent(newItem);
                    break;

                case 3:
                    System.out.print("Enter the ID of the item to modify: ");
                    String searchId = scanner.nextLine();
                    Component foundItem = manager.findById(searchId);
                    
                    if (foundItem != null) {
                        System.out.println("Found: " + foundItem.getName());
                        System.out.print("Enter new price (Current: €" + foundItem.getPrice() + "): ");
                        foundItem.setPrice(scanner.nextDouble());
                        System.out.print("Enter new stock level (Current: " + foundItem.getStockQuantity() + "): ");
                        foundItem.setStockQuantity(scanner.nextInt());
                        System.out.println("✔️ Item attributes updated successfully!");
                    } else {
                        System.out.println("❌ Component ID not found.");
                    }
                    break;

                case 4:
                    System.out.println("\n[1] Sort Inventory by Price (Low -> High)");
                    System.out.println("[2] Filter by Component Category");
                    System.out.print("Choose filter action: ");
                    int subChoice = scanner.nextInt();
                    scanner.nextLine(); // clear buffer
                    
                    if (subChoice == 1) {
                        manager.sortByPrice();
                    } else if (subChoice == 2) {
                        System.out.print("Enter category string: ");
                        String targetCat = scanner.nextLine();
                        manager.filterByCategory(targetCat);
                    } else {
                        System.out.println("Returned to top menu.");
                    }
                    break;

                case 5:
                    System.out.print("Enter the ID of the item to remove: ");
                    String deleteId = scanner.nextLine();
                    if (manager.deleteComponent(deleteId)) {
                        System.out.println("🗑️ Item successfully purged from memory.");
                    } else {
                        System.out.println("❌ Operation failed. ID mismatch.");
                    }
                    break;

                case 0:
                    System.out.println("Shutting down core engine... Goodbye!");
                    break;

                default:
                    System.out.println("⚠️ Unknown choice code execution bypassed.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
