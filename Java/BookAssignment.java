import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    String bookName;
    String authorName;
    String publisher;
    int cost;

    public void takeBookDetails() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter book name: ");
        this.bookName = scan.nextLine();

        System.out.print("Enter book's author name: ");
        this.authorName = scan.nextLine();

        System.out.print("Enter book's publisher name: ");
        this.publisher = scan.nextLine();

        System.out.print("Enter book's cost: ");
        this.cost = scan.nextInt();
    }

    public void displayBookDetails() {
        System.out.println("Title: " + this.bookName);
        System.out.println("Written by: " + this.authorName);
        System.out.println("Published by: " + this.publisher);
        System.out.println("Price: " + this.cost);
    }

}

public class BookAssignment {

    public static void main(String[] args) {
        int serialNumber;
        HashMap<Integer, Book> library = new HashMap<Integer, Book>();
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("1. Add new book");
            System.out.println("2. Search book");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nAdding a new book......");
                    System.out.print("Enter serial number: ");
                    serialNumber = scan.nextInt();
                    Book book = new Book();
                    book.takeBookDetails();
                    library.put(serialNumber, book);
                    System.out.println("Book added to library....\n");
                    break;

                case 2:
                    System.out.print("\nEnter book serial number: ");
                    int search = scan.nextInt();
                    for (Map.Entry<Integer, Book> entry : library.entrySet()) {
                        if (search == entry.getKey()) {
                            entry.getValue().displayBookDetails();
                            System.out.println("");
                        }
                    }
                    break;

                default:
                    System.out.println("Enter correct choice!");
                    break;
            }

        }
    }

}
