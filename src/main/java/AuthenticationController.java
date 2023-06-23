import java.util.UUID;

public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public User createUser(String username, String password) {
        return authenticationService.createUser(username, password);
    }

    public boolean signInUser(String username, String password) {
        return authenticationService.authenticate(username, password);
    }

    public User changePassword(UUID id, String oldPassword, String newPassword) {
        return authenticationService.changePassword(id, oldPassword, newPassword);
    }

    public User changeUsername(UUID id, String currentUsername, String newUsername) {
        return authenticationService.changeUsername(currentUsername, newUsername);
    }
}
