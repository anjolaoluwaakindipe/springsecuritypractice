package tech.anjolaakindipe.springsecuritypractice.service;

import java.util.List;

import tech.anjolaakindipe.springsecuritypractice.domain.Role;
import tech.anjolaakindipe.springsecuritypractice.domain.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
    
}
