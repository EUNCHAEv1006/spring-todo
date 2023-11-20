package com.sparta.springtodo.controller;

import com.sparta.springtodo.dto.PostAddRequestDto;
import com.sparta.springtodo.dto.PostResponseDto;
import com.sparta.springtodo.dto.PostUpdateRequestDto;
import com.sparta.springtodo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PatchMapping("/{postId}")
    public ResponseEntity<PostResponseDto> updatePost(
            @PathVariable Long postId,
            @RequestBody PostUpdateRequestDto requestDto
    ) {
        PostResponseDto responseDto = postService.updatePost(postId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{postId}")
    public void deletePost(
            @PathVariable Long postId,
            @RequestHeader("password") String password
    ) {
        postService.deletePost(postId, password);
    }
}
