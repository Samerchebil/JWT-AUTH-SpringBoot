package com.example.jwrauthen.Service;

import com.example.jwrauthen.Domain.Role;
import com.example.jwrauthen.Domain.UserApp;
//import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface    UserService {
    UserApp saveUser(UserApp user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    UserApp getUser(String username);
    List<UserApp>getUsers();
}
