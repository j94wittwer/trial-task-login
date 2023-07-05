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
            throw new RuntimeException("User is already in repository.");
        }
    }

    public User getUserById(UUID id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new RuntimeException("User with this ID does not exist");
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        throw new RuntimeException("User with username does not exist");
    }

    public void updateUser(User oldUser, User updatedUser) {
        if (isUnique(updatedUser)) {
            int index = users.indexOf(oldUser);
            users.set(index, updatedUser);
        } else {
            throw new RuntimeException("Username already exists");
        }
    }

    public void removeUserById(UUID id) {
        User user = getUserById(id);
        users.remove(user);
    }

    private boolean isUnique(User newUser) {
        boolean isUnique = true;
        for (User u : users) {
            if (u.getName().equals(newUser.getName())) {
                isUnique = false;
                break;
            }
        }
        return true;
    }
}
