package com.aisen.book.spring_boot_book.service.posts;

import com.aisen.book.spring_boot_book.domain.posts.Posts;
import com.aisen.book.spring_boot_book.domain.posts.PostsRepository;
import com.aisen.book.spring_boot_book.web.dto.PostsResponseDto;
import com.aisen.book.spring_boot_book.web.dto.PostsSaveRequestDto;
import com.aisen.book.spring_boot_book.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, PostsUpdateRequestDto requestDto) {

        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No posts by the provided id: " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No posts by the provided id: " + id));

        // returning dto because don't need everything from the entity
        return new PostsResponseDto(entity);
    }
}
