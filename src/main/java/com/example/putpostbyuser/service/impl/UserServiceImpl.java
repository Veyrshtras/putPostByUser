package com.example.putpostbyuser.service.impl;

import com.example.putpostbyuser.dto.UserItem;
import com.example.putpostbyuser.entity.User;
import com.example.putpostbyuser.repository.UserRepository;
import com.example.putpostbyuser.service.UserService;
import org.hibernate.service.spi.InjectService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserItem get(Long id) {

        return UserItem.fromUser(userRepository.getOne(id));
    }

    @Override
    public List<UserItem> findAll() {

        return userRepository.findAllNotDeleted()
                .stream()
                .map(UserItem::fromUser)
                .collect(Collectors.toList());
    }

    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    @Override
    public UserItem add(UserItem user) {
        User user1=new User();
        user1.setEmail(user.getEmail());
        user1.setFullName(user.getFullName());
        user1.setPassword(encoder.encode(user.getPassword()));
        user1.setRole(user.getRole());
        user1.setConfirmed(true);
        userRepository.save(user1);
        return user;
    }

    @Override
    public UserItem update(UserItem user, Long id) {
        User user1=userRepository.getById(id);
        user1.setPassword(encoder.encode(user.getPassword()));
        user1.setFullName(user.getFullName());
        user1.setEmail(user.getEmail());
        user1.setRole(user.getRole());
        userRepository.save(user1);
        return user;
    }

    @Override
    public boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
