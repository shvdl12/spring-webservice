package com.kms.webservice.web;

import com.kms.webservice.domain.posts.Posts;
import com.kms.webservice.domain.posts.PostsRepository;
import com.kms.webservice.dto.PostSaveRequestDto;
import com.kms.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {
    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostSaveRequestDto dto) {
        return postsService.save(dto);
    }
}
