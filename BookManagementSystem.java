package task3;
// Book class
class Book {
    // Attributes
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor to initialize book attributes
    public Book(int bookID, String title, String author, boolean isAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    // Getter and setter methods for book attributes
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

// Library class
class Library {
    private Book[] books; // Array to store books
    private int count; // Counter to track the number of books added

    // Constructor to initialize the array
    public Library() {
        this.books = new Book[5]; // Limit the number of books to 5
        this.count = 0;
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
            System.out.println("Book added: " + book.getTitle());
        } else {
            System.out.println("Library is full, cannot add more books.");
        }
    }

    // Method to replace a book in the library by bookID
    public void replaceBook(int bookID, String newTitle, String newAuthor) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookID() == bookID) {
                books[i].setTitle(newTitle);
                books[i].setAuthor(newAuthor);
                System.out.println("Book replaced: " + books[i]);
                return;
            }
        }
        System.out.println("Book not found with ID: " + bookID);
    }

    // Method to display all books in the library
    public void displayBooks() {
        if (count == 0) {
            System.out.println("No books in the library.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(books[i]);
            }
        }
    }
}

// BookManagementSystem class
public class BookManagementSystem {
    public static void main(String[] args) {
        Library library = new Library(); // Create a library object

        // Add sample books
        library.addBook(new Book(101, "Java Basics", "John Doe", true));
        library.addBook(new Book(102, "Advanced Java", "Jane Smith", true));
        library.addBook(new Book(103, "OOP Concepts", "Robert Brown", false));
        library.addBook(new Book(104, "Advanced python", "Jane Smith", true));
        library.addBook(new Book(105, "OOP Concepts in Python", "Robert Brown", false));

        // Display all books in the library
        System.out.println("Books in Library before replacement:");
        library.displayBooks();
        // Replace a book by ID
        library.replaceBook(102, "Java Mastery", "Jane Williams");
        // Display all books in the library
        System.out.println("Books in Library after replacement:");
        library.displayBooks();
    }
}

//OUTPUT:

//Book added: Java Basics
//Book added: Advanced Java
//Book added: OOP Concepts
//Book added: Advanced python
//Book added: OOP Concepts in Python
//Books in Library before replacement:
//Book ID: 101, Title: Java Basics, Author: John Doe, Available: true
//Book ID: 102, Title: Advanced Java, Author: Jane Smith, Available: true
//Book ID: 103, Title: OOP Concepts, Author: Robert Brown, Available: false
//Book ID: 104, Title: Advanced python, Author: Jane Smith, Available: true
//Book ID: 105, Title: OOP Concepts in Python, Author: Robert Brown, Available: false
//Book replaced: Book ID: 102, Title: Java Mastery, Author: Jane Williams, Available: true
//Books in Library after replacement:
//Book ID: 101, Title: Java Basics, Author: John Doe, Available: true
//Book ID: 102, Title: Java Mastery, Author: Jane Williams, Available: true
//Book ID: 103, Title: OOP Concepts, Author: Robert Brown, Available: false
//Book ID: 104, Title: Advanced python, Author: Jane Smith, Available: true
//Book ID: 105, Title: OOP Concepts in Python, Author: Robert Brown, Available: false