package com.example.putpostbyuser.service.impl;

import com.example.putpostbyuser.dto.BlogItem;
import com.example.putpostbyuser.entity.Blog;
import com.example.putpostbyuser.repository.BlogRepository;
import com.example.putpostbyuser.repository.CategoryRepository;
import com.example.putpostbyuser.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final CategoryRepository categoryRepository;

    public BlogServiceImpl(BlogRepository blogRepository, CategoryRepository categoryRepository) {
        this.blogRepository = blogRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<BlogItem> findAll() {
        return blogRepository.findAllNotDeleted()
                .stream()
                .map(BlogItem::fromBlog)
                .collect(Collectors.toList());
    }

    @Override
    public BlogItem add(BlogItem user) {
        Blog blog=new Blog();
        blog.setCategory(categoryRepository.getById(user.getCategory()));
        blog.setContent(user.getContent());
        blog.setTitle(user.getTitle());
        blogRepository.save(blog);
        return user;
    }

    @Override
    public BlogItem update(BlogItem user, Long id) {
        Blog blog=blogRepository.getOne(id);
        blog.setCategory(categoryRepository.getById(user.getCategory()));
        blog.setContent(user.getContent());
        blog.setTitle(user.getTitle());
        blogRepository.save(blog);
        return user;
    }

    @Override
    public boolean delete(Long id) {
        blogRepository.deleteById(id);
        return true;
    }
}
