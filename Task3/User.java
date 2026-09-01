public class User {

    private String name;

    // Constructor
    public User(String name) {
        this.name = name;
    }

    // Get user name
    public String getName() {
        return name;
    }

    // Display user information
    public void displayUser() {
        System.out.println("User Name: " + name);
    }
}