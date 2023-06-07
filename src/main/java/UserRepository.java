import java.util.ArrayList;
import java.util.List;

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

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getName() == username) {
                return user;
            }
        }
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

    public void removeUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
        } else {
            System.out.println("User is not existent in repository.");
        }
    }

    public boolean isUnique(User newUser) {
        boolean isUnique = true;
        for (User user : users) {
            if (user.getName().equals(newUser.getName())) {
                isUnique = false;
                break;
            }
        }
        return isUnique;
    }

}
