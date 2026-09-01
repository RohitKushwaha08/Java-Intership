public class Book {

    private String title;
    private String author;
    private boolean isIssued;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    // Get book title
    public String getTitle() {
        return title;
    }

    // Get book author
    public String getAuthor() {
        return author;
    }

    // Check if book is issued
    public boolean isIssued() {
        return isIssued;
    }

    // Issue the book
    public void issueBook() {
        isIssued = true;
    }

    // Return the book
    public void returnBook() {
        isIssued = false;
    }

    // Display book information
    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);

        if (isIssued) {
            System.out.println("Status: Issued");
        } else {
            System.out.println("Status: Available");
        }

        System.out.println("----------------------");
    }
}
