package com.example.putpostbyuser.dto;

import com.example.putpostbyuser.entity.Blog;
import com.example.putpostbyuser.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentItem {

    private String title;

    private Long blog;
    public static CommentItem fromComment(Comment comment){
        CommentItem commentItem=new CommentItem();
        commentItem.setTitle(comment.getTitle());
        commentItem.setBlog(comment.getId());
        return commentItem;
    }
}
