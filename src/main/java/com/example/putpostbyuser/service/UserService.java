package com.example.putpostbyuser.service;

import com.example.putpostbyuser.dto.UserItem;

import java.util.List;

public interface UserService {

    UserItem get(Long id);

    List<UserItem> findAll();

    UserItem add(UserItem user);

    UserItem update(UserItem user, Long id);

    boolean delete(Long id);
}
