public class AuthenticationService {

    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String password) {
        return new User(username, password);
    }

    public void changeUsername(String currentUsername, String newUsername) {
        if (newUsername == null || newUsername.isEmpty() || newUsername.trim().isEmpty()) {
            System.out.println("Please provide valid Username");
        } else {
            User oldUser = userRepository.getUserByUsername(currentUsername);
            User updatedUser = new User(newUsername, oldUser.getPassword());
            userRepository.updateUser(oldUser, updatedUser);
        }
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
        User oldUser = userRepository.getUserByUsername(username);

        if (authenticate(oldPassword, username)) {
            User newUser = new User(username, newPassword);
            userRepository.updateUser(oldUser, newUser);
            System.out.println("Password changed successfully");
        } else {
            System.out.println("Old password incorrect");
        }
    }

    public boolean authenticate(String password, String username) {
        User user = userRepository.getUserByUsername(username);
        return user.getPassword() == password && user.getName() == username;
    }


}
