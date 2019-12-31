package com.goWithU.springboot01.dao;

import com.goWithU.springboot01.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dav1d
 */
public interface PostRepository extends JpaRepository<Post, Integer> {
}
