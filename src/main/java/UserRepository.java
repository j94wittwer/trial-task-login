import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Description: This class manages user data storage and retrieval.
 *
 * Intent: The UserRepository class handles the storage and retrieval of user objects. It provides methods to add,
 * retrieve, update, and remove users from the repository using their unique identifier or username. It also ensures
 * uniqueness of usernames to prevent duplicates.
 */
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        if (isUnique(user)) {
            users.add(user);
        } else {
            System.out.println("User is already in repository.");
        }
    }

    public User getUserById(UUID id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        System.out.println("User does not exist");
        return null;
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        System.out.println("Username does not exist");
        return null;
    }

    public void updateUser(User oldUser, User updatedUser) {
        if (isUnique(updatedUser)) {
            int index = users.indexOf(oldUser);
            users.set(index, updatedUser);
        } else {
            System.out.println("Username already exists");
        }
    }

    public void removeUserById(UUID id) {
        User user = getUserById(id);
        if (isUnique(user)) {
            users.remove(user);
        } else {
            System.out.println("Could not remove user");
        }
    }

    private boolean isUnique(User newUser) {
        boolean isUnique = true;
        for (User u : users) {
            if (u.getName().equals(newUser.getName())) {
                isUnique = false;
                break;
            }
        }
        return isUnique;
    }
}
