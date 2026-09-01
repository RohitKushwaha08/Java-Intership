public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Create library
        Library library = new Library();

        // Create books
        Book book1 = new Book(
            "Java Programming",
            "James Gosling"
        );

        Book book2 = new Book(
            "Python Basics",
            "Guido van Rossum"
        );

        Book book3 = new Book(
            "C++ Programming",
            "Bjarne Stroustrup"
        );

        // Add books to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Create user
        User user1 = new User("Ramraj");

        System.out.println("\n--- User ---");
        user1.displayUser();

        // Display books
        library.displayBooks();

        // Issue a book
        System.out.println("\n--- Issue Book ---");
        library.issueBook("Java Programming", user1);

        // Display books after issuing
        library.displayBooks();

        // Return a book
        System.out.println("\n--- Return Book ---");
        library.returnBook("Java Programming");

        // Display final status
        library.displayBooks();
    }
}