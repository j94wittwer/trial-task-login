import java.util.UUID;

/**
 * Description: This class serves as a domain model for users.
 *
 * Intent: The User class represents user information, including the user's unique identifier, name, and password.
 * It provides methods to access and update user details.
 */
public class User {

    // Generated value
    private final UUID id;
    private String name;
    private String password;

    public User(UUID id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
