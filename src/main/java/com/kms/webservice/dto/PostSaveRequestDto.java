package com.kms.webservice.dto;

import com.kms.webservice.domain.posts.Posts;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

    @Getter
    @Builder
    public static class Response {
        private int code;
        private String message;
    }
}
