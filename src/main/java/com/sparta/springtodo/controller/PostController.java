package com.sparta.springtodo.controller;

import com.sparta.springtodo.dto.PostAddRequestDto;
import com.sparta.springtodo.dto.PostResponseDto;
import com.sparta.springtodo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponseDto addPost(
            @RequestBody PostAddRequestDto requestDto
            ) {
        PostResponseDto responseDto = postService.addPost(requestDto);
        return responseDto;
    }

    @GetMapping("/{postId}")
    public PostResponseDto getPost(
            @PathVariable Long postId
    ) {
        return postService.getPost(postId);
    }

    @GetMapping
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }
}
