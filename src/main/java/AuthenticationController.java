import java.util.UUID;

/**
 * Description: This class handles requests and acts as an interface between the outside world and the AuthenticationService.
 *
 * Intent: The AuthenticationController class serves as a controller for user authentication-related operations.
 * It handles incoming requests, such as user creation, sign-in, password changes, and username updates and deleting users. (CRUD functionality)
 * It delegates the request processing to the AuthenticationService to perform the required actions.
 */
public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public User createUser(String username, String password) {
        return authenticationService.createUser(username, password);
    }

    public boolean signInUser(String username, String password) {
        return authenticationService.signInUser(username, password);
    }

    public User changePassword(UUID id, String oldPassword, String newPassword) {
        return authenticationService.changePassword(id, oldPassword, newPassword);
    }

    public User changeUsername(UUID id, String currentUsername, String newUsername) {
        return authenticationService.changeUsername(currentUsername, newUsername);
    }
}
