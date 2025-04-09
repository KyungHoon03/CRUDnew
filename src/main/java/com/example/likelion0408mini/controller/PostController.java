package com.example.likelion0408mini.controller;


import com.example.likelion0408mini.dto.PostDto;
import com.example.likelion0408mini.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")

public class PostController {
    private final PostService postService;

    // 등록 form 페이지 보여주기
    @GetMapping("/")
    public String newForm(Model model) {
        model.addAttribute("name", "");
        model.addAttribute("title", "");
        model.addAttribute("content", "");
        model.addAttribute("formAction", "/api/posts");
        // 새 게시글 작성이므로 수정 여부를 false로 전달
        model.addAttribute("isEdit", false);
        return "form";
    }

    // 게시글 저장 처리
    @PostMapping("/posts")
    public String save(@ModelAttribute PostDto dto) {
        postService.save(dto);
        return "redirect:/api/post"; // 저장 후 리스트 페이지로 이동
    }

    @GetMapping("/post")
    public String list(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "postList"; // 게시글 목록을 렌더링할 Mustache 템플릿 이름
    }


}
