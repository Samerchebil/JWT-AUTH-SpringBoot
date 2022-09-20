package com.example.jwrauthen.Repo;

import com.example.jwrauthen.Domain.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepo
        extends JpaRepository<UserApp,Long> {
Optional<UserApp> findByUserName(String username);
}
