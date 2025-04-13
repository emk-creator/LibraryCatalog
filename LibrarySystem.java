import java.util.*;

// Generic Library Item Class
class LibraryItem<T> {
    private String title;
    private String author;
    private T itemID;

    public LibraryItem(String title, String author, T itemID) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public T getItemID() {
        return itemID;
    }

    @Override
    public String toString() {
        return "Item ID: " + itemID + ", Title: " + title + ", Author: " + author;
    }
}

// Generic Catalog Class
class LibraryCatalog<T> {
    private List<T> catalog = new ArrayList<>();

    public void addItem(T item) {
        catalog.add(item);
        System.out.println("Item added successfully.");
    }

    public void removeItem(T item) {
        if (catalog.contains(item)) {
            catalog.remove(item);
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Error: Item not found in the catalog.");
        }
    }

    public void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            System.out.println("Library Catalog:");
            for (T item : catalog) {
                System.out.println(item);
            }
        }
    }
}

// Main Class with User Interface
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryCatalog<LibraryItem<String>> catalog = new LibraryCatalog<>();

        while (true) {
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Catalog");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Item ID: ");
                    String itemID = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    catalog.addItem(new LibraryItem<>(title, author, itemID));
                    break;
                case 2:
                    System.out.print("Enter Item ID to remove: ");
                    String removeID = scanner.nextLine();
                    catalog.removeItem(new LibraryItem<>("", "", removeID));
                    break;
                case 3:
                    catalog.displayCatalog();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
