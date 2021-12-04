package com.example.putpostbyuser.dto;

import com.example.putpostbyuser.entity.Blog;
import com.example.putpostbyuser.entity.Category;
import com.example.putpostbyuser.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BlogItem {

    private String title;

    private String content;

    private Long category;

    public static BlogItem fromBlog(Blog blog){
        BlogItem blogItem=new BlogItem();
        blogItem.setCategory(blog.getId());
        blogItem.setContent(blog.getContent());
        blogItem.setTitle(blog.getTitle());
        return blogItem;
    }
}
