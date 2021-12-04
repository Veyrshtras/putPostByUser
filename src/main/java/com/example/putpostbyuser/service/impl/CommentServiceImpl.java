package com.example.putpostbyuser.service.impl;

import com.example.putpostbyuser.dto.CommentItem;
import com.example.putpostbyuser.entity.Comment;
import com.example.putpostbyuser.repository.BlogRepository;
import com.example.putpostbyuser.repository.CommentRepository;
import com.example.putpostbyuser.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;
    public CommentServiceImpl(CommentRepository commentRepository, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }

    @Override
    public List<CommentItem> findAll() {
        return commentRepository.findAllNotDeleted()
                .stream()
                .map(CommentItem::fromComment)
                .collect(Collectors.toList());
    }

    @Override
    public CommentItem add(CommentItem user) {
        Comment comment=new Comment();
        comment.setTitle(user.getTitle());
        comment.setBlog(blogRepository.getById(user.getBlog()));
        commentRepository.save(comment);
        return user;
    }

    @Override
    public CommentItem update(CommentItem user, Long id) {
        Comment comment=commentRepository.getOne(id);
        comment.setTitle(user.getTitle());
        comment.setBlog(blogRepository.getById(user.getBlog()));
        commentRepository.save(comment);
        return user;
    }

    @Override
    public boolean delete(Long id) {
        commentRepository.deleteById(id);
        return true;
    }
}
