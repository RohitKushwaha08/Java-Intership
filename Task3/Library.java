public class Library {

    private Book[] books;
    private int bookCount;

    // Constructor
    public Library() {
        books = new Book[10];
        bookCount = 0;
    }

    // Add book to library
    public void addBook(Book book) {

        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;

            System.out.println(book.getTitle() + " added successfully.");
        } else {
            System.out.println("Library is full!");
        }
    }

    // Display all books
    public void displayBooks() {

        System.out.println("\n--- Library Books ---");

        for (int i = 0; i < bookCount; i++) {
            books[i].displayBook();
        }
    }

    // Issue book
    public void issueBook(String title, User user) {

        for (int i = 0; i < bookCount; i++) {

            if (books[i].getTitle().equalsIgnoreCase(title)) {

                if (!books[i].isIssued()) {
                    books[i].issueBook();

                    System.out.println(
                        title + " issued to " + user.getName()
                    );

                } else {
                    System.out.println("Book is already issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Return book
    public void returnBook(String title) {

        for (int i = 0; i < bookCount; i++) {

            if (books[i].getTitle().equalsIgnoreCase(title)) {

                if (books[i].isIssued()) {
                    books[i].returnBook();

                    System.out.println(
                        title + " returned successfully."
                    );

                } else {
                    System.out.println("Book was not issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }
}
