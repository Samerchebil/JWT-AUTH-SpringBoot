package com.example.jwrauthen.Service;

import com.example.jwrauthen.Domain.Role;
import com.example.jwrauthen.Domain.UserApp;
import com.example.jwrauthen.Repo.RoleRepo;
import com.example.jwrauthen.Repo.UserAppRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserAppRepo userAppRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserAppRepo userAppRepo, RoleRepo roleRepo,PasswordEncoder passwordEncoder) {
        this.userAppRepo = userAppRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder=passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<UserApp> user = userAppRepo.findByUserName(username);
       if (user == null){
           log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the data base");
       }
       else {
           log.info("User found in the database: {}", username);
       }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
       user.get().getRoles().forEach(role->{
           authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(), authorities);
    }

    @Override
    public UserApp saveUser(UserApp user) {
        log.info("saving a new user in the data base");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userAppRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName)
    {
        Optional<UserApp> user= userAppRepo.findByUserName(username);
        Role role = roleRepo.findByName(roleName);
        user.get().getRoles().add(role);
        userAppRepo.save(user.get());
    }

    @Override
    public UserApp getUser(String username) {
            return userAppRepo.findByUserName(username).get();
    }

    @Override
    public List<UserApp> getUsers() {
        return userAppRepo.findAll();
    }


    public List<Role> getRole() {
        return roleRepo.findAll();
    }


}
