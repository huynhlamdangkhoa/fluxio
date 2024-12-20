package service;

import DAO.AdminDAO;
import model.Admin;
import java.util.ArrayList;

public class AdminService {
    private AdminDAO adminDAO;

    public AdminService() {
        this.adminDAO = AdminDAO.getInstance();
    }

    public boolean addAdmin(Admin admin) {
        if (isValidAdmin(admin)) {
            return adminDAO.insert(admin) > 0;
        }
        return false;
    }

    public boolean updateAdmin(Admin admin) {
        if (admin != null && admin.getAdminId() > 0) {
            return adminDAO.update(admin) > 0;
        }
        return false;
    }

    public boolean deleteAdmin(int adminId) {
        Admin admin = new Admin(adminId, null, null, null, null);
        return adminDAO.delete(admin) > 0;
    }

    public ArrayList<Admin> getAllAdmins() {
        return adminDAO.selectAll();
    }

    public Admin getAdminById(int adminId) {
        Admin admin = new Admin(adminId, null, null, null, null);
        return adminDAO.selectById(admin);
    }

    private boolean isValidAdmin(Admin admin) {
        if (admin == null) return false;
        if (admin.getUsername() == null || admin.getUsername().isEmpty()) return false;
        if (admin.getPassword() == null || admin.getPassword().isEmpty()) return false;
        if (admin.getEmail() == null || !admin.getEmail().contains("@")) return false;
        if (admin.getRole() == null || admin.getRole().isEmpty()) return false;
        return true;
    }
}
