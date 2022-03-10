package com.kms.webservice.dto;

import com.kms.webservice.domain.posts.BaseTimeEntity;
import com.kms.webservice.domain.posts.Posts;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
@ToString
@Slf4j
public class PostMainResponseDto {

    private Long id;
    private String title;
    private String author;
    private String modifiedAt;

    public PostMainResponseDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        modifiedAt = toStringDateTime(entity.getModifiedAt());
    }

    private String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
