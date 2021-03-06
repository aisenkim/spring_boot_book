package com.aisen.book.spring_boot_book.web;

import com.aisen.book.spring_boot_book.config.auth.LoginUser;
import com.aisen.book.spring_boot_book.config.auth.dto.SessionUser;
import com.aisen.book.spring_boot_book.service.posts.PostsService;
import com.aisen.book.spring_boot_book.web.dto.PostsResponseDto;
import com.aisen.book.spring_boot_book.web.dto.PostsSaveRequestDto;
import com.aisen.book.spring_boot_book.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto, @LoginUser SessionUser user) throws IllegalAccessException {
        return postsService.update(id, requestDto, user);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}

