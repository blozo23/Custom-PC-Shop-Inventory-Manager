# Ctrl S - Custom PC Shop Inventory Manager

A console-based inventory management system designed for **Ctrl S**, a custom desktop computer shop. This project serves as a practical demonstration of Object-Oriented Programming (OOP) principles in Java, utilizing dynamic memory structures to manage retail data workflows.

---

## 🚀 Features

The application operates on an interactive lifecycle loop (Menu System) allowing real-time data manipulation:
- **Full Inventory View:** Displays all active stock with clean, formatted console output.
- **Dynamic Insertion (CRUD):** Add new components dynamically into the system memory.
- **Attribute Modification:** Search for items by a unique identifier to update retail pricing and stock levels.
- **Data Manipulation & Sorting:** Rearrange data on the fly (e.g., sorting entire arrays by price boundaries).
- **Targeted Filtering:** Query and isolate items matching specific computer component categories (CPU, GPU, RAM, etc.).
- **Data Deletion:** Purge components safely from active memory storage.

---

## 🛠️ System Architecture & OOP Concepts

The project is structured across multiple decoupled files to respect separation of concerns:

1. **`Component.java` (Data Model):** Represents the core blueprint of a computer part. It enforces **Encapsulation** using private fields protected by public getter and setter accessors.
2. **`ShopManager.java` (Logic Controller):** Acts as the primary backend engine. It manages state using a Java `ArrayList<Component>` to simulate an in-memory database, exposing methods for data filtering and sorting algorithms.
3. **`Main.java` (User Interface):** Handles runtime initialization, user input scanning with `java.util.Scanner`, input validation guardrails, and control flow menus.

---

## 💻 How To Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed.
- A terminal or terminal integrated environment (like VS Code).

### Step-by-Step Execution

1. Clone or download the repository files into a single directory.
2. Open your terminal, navigate to the folder, and compile all source files simultaneously:
   ```bash
   javac Component.java ShopManager.java Main.java
