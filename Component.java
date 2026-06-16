public class Component {
    private String id;
    private String name;
    private String category; // e.g., GPU, CPU, RAM
    private double price;
    private int stockQuantity;

    // Constructor
    public Component(String id, String name, String category, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    // Helper method to display component details cleanly
    @Override
    public String toString() {
        return String.format("ID: %-6s | Name: %-20s | Category: %-10s | Price: €%-7.2f | Stock: %d", 
                id, name, category, price, stockQuantity);
    }
}
