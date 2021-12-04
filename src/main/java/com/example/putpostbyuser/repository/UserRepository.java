package com.example.putpostbyuser.repository;

import com.example.putpostbyuser.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByEmail(String username);
}
