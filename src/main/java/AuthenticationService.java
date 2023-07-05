import java.util.UUID;

/**
 * Description: This class handles user authentication, credential verification, and secure system access.
 *
 * Intent: The AuthenticationService class contains the core logic for user authentication. It provides methods to
 * create users, authenticate credentials, change usernames and passwords, and delete user accounts.
 * It interfaces with the UserRepository to fetch and update user information.
 */
public class AuthenticationService {

    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String password) {
        UUID id = UUID.randomUUID();
        return new User(id, username, password);
    }

    public User changeUsername(UUID id, String newUsername) {
        if (newUsername == null || newUsername.isEmpty() || newUsername.trim().isEmpty()) {
            throw new RuntimeException("Please provide a valid username");
        } else {
            User oldUser = userRepository.getUserById(id);
            User updatedUser = new User(oldUser.getId(), newUsername, oldUser.getPassword());
            userRepository.updateUser(oldUser, updatedUser);
            return updatedUser;
        }
    }

    public User changePassword(UUID id, String oldPassword, String newPassword) {
        User oldUser = userRepository.getUserById(id);

        if (id == signInUser(oldPassword, oldUser.getName())) {
            User updatedUser = new User(oldUser.getId(), oldUser.getName(), newPassword);
            userRepository.updateUser(oldUser, updatedUser);
            System.out.println("Password changed successfully");
            return updatedUser;
        } else {
            throw new RuntimeException("Failed to authenticate user");
        }
    }

    public UUID signInUser(String password, String username) {
        User user = userRepository.getUserByUsername(username);
        if (user.getPassword().equals(password) && user.getName().equals(username)) {
            return user.getId();
        } else {
            throw new RuntimeException("Username or password incorrect");
        }
    }

    public String deleteUser(UUID id) {
        try {
            userRepository.removeUserById(id);
            return "User removed successfully";
        } catch (Exception e) {
            return "User could not be removed";
        }
    }
}
