package com.example.putpostbyuser.service;

import com.example.putpostbyuser.dto.BlogItem;

import java.util.List;

public interface BlogService {

    List<BlogItem> findAll();

    BlogItem add(BlogItem user);

    BlogItem update(BlogItem user, Long id);

    boolean delete(Long id);

}
