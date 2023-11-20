package com.sparta.springtodo.service;

import com.sparta.springtodo.dto.PostAddRequestDto;
import com.sparta.springtodo.dto.PostResponseDto;
import com.sparta.springtodo.entity.PostEntity;
import com.sparta.springtodo.repository.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostJpaRepository postJpaRepository;

    public PostResponseDto addPost(PostAddRequestDto requestDto) {
        // Dto -> Entity
        PostEntity postEntity = new PostEntity(requestDto);
        PostEntity savePost = postJpaRepository.save(postEntity);
        return new PostResponseDto(savePost);
    }

    public PostResponseDto getPost(Long postId) {
       PostEntity postEntity = postJpaRepository.findById(postId)
               .orElseThrow(() -> new NullPointerException("해당 게시글을 찾을 수 없습니다."));

       return new PostResponseDto(postEntity);
    }

    public List<PostResponseDto> getPosts() {
        return postJpaRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }
}
