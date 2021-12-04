package com.example.putpostbyuser.repository;

import com.example.putpostbyuser.entity.Blog;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends BaseRepository<Blog>{

    Blog findByTitle(String title);// I didn't use it, just wrote it for testing

}
