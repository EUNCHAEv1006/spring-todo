package com.sparta.springtodo.service;

import com.sparta.springtodo.dto.PostAddRequestDto;
import com.sparta.springtodo.dto.PostResponseDto;
import com.sparta.springtodo.entity.PostEntity;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    public PostResponseDto addPost(PostAddRequestDto requestDto) {
        // Dto -> Entity
        PostEntity postEntity = new PostEntity(requestDto);
    }
}
