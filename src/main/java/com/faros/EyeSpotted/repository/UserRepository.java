package com.faros.EyeSpotted.repository;

import com.faros.EyeSpotted.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByName(String name);
    boolean existsUserByName(String name);
    boolean existsUserByEmail(String email);
}
