package com.example.putpostbyuser.service;

import com.example.putpostbyuser.dto.CommentItem;

import java.util.List;

public interface CommentService {

    List<CommentItem> findAll();

    CommentItem add(CommentItem user);

    CommentItem update(CommentItem user, Long id);

    boolean delete(Long id);
}
