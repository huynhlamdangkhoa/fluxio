package service;

import DAO.UserDAO;
import model.User;
import java.util.ArrayList;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = UserDAO.getInstance();
    }

    public boolean addUser(User user) {
        if (isValidUser(user)) {
            return userDAO.insert(user) > 0;
        }
        return false;
    }

    public boolean updateUser(User user) {
        if (user != null && user.getUserId() > 0) {
            return userDAO.update(user) > 0;
        }
        return false;
    }

    public boolean deleteUser(int userId) {
        User user = new User(userId, null, null, null, null);
        return userDAO.delete(user) > 0;
    }

    public ArrayList<User> getAllUsers() {
        return userDAO.selectAll();
    }

    public User getUserById(int userId) {
        User user = new User(userId, null, null, null, null);
        return userDAO.selectById(user);
    }

    private boolean isValidUser(User user) {
        if (user == null) return false;
        if (user.getUsername() == null || user.getUsername().isEmpty()) return false;
        if (user.getPassword() == null || user.getPassword().isEmpty()) return false;
        if (user.getEmail() == null || !user.getEmail().contains("@")) return false;
        if (user.getRole() == null || user.getRole().isEmpty()) return false;
        return true;
    }
}