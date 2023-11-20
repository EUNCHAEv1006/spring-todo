package com.sparta.springtodo.repository;

import com.sparta.springtodo.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findAllByOrderByCreatedAtDesc();
}
