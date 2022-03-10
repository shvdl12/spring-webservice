package com.kms.webservice.service;

import com.kms.webservice.domain.posts.PostsRepository;
import com.kms.webservice.dto.PostMainResponseDto;
import com.kms.webservice.dto.PostSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
