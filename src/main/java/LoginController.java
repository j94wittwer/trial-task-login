public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public boolean authenticateUser(String username, String password) {
        return authenticationService.authenticate(username, password);
    }

    public User createUser(String username, String password) {
        return authenticationService.createUser(username, password);
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
        authenticationService.changePassword(username, oldPassword, newPassword);
    }

    public void changeUsername(String currentUsername, String newUsername) {
        authenticationService.changeUsername(currentUsername, newUsername);
    }
}
