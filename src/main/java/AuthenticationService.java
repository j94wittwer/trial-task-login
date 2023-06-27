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

    public User changeUsername(String currentUsername, String newUsername) {
        if (newUsername == null || newUsername.isEmpty() || newUsername.trim().isEmpty()) {
            System.out.println("Please provide valid Username");
            return null;
        } else {
            User oldUser = userRepository.getUserByUsername(currentUsername);
            User updatedUser = new User(oldUser.getId(), newUsername, oldUser.getPassword());
            userRepository.updateUser(oldUser, updatedUser);
            return updatedUser;
        }
    }

    public User changePassword(UUID id, String oldPassword, String newPassword) {
        User oldUser = userRepository.getUserById(id);

        if (authenticate(oldPassword, oldUser.getName())) {
            User updatedUser = new User(oldUser.getId(), oldUser.getName(), newPassword);
            userRepository.updateUser(oldUser, updatedUser);
            System.out.println("Password changed successfully");
            return updatedUser;
        } else {
            System.out.println("Username or password incorrect");
            return null;
        }
    }

    public boolean authenticate(String password, String username) {
        User user = userRepository.getUserByUsername(username);
        return user.getPassword().equals(password) && user.getName().equals(username);
    }

    public void deleteUser(UUID id) {
        userRepository.removeUserById(id);
    }
}
