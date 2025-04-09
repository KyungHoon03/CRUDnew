package com.example.likelion0408mini.service;


import com.example.likelion0408mini.dto.PostDto;
import com.example.likelion0408mini.entity.Post;
import com.example.likelion0408mini.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class PostService {
    private final PostRepository postRepository;

    public void save(PostDto postDto) {

        Post post = new Post();

        post.setTitle(postDto.getTitle());      // DTO에서 꺼낸 값 주입
        post.setContent(postDto.getContent());
        post.setName(postDto.getName());

        postRepository.save(post);
    }

    public Object findAll() {
        return postRepository.findAll();
    }
}
