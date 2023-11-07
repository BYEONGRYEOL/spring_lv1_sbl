package com.main.sbl_spring_lv1.repository;

import com.main.sbl_spring_lv1.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}