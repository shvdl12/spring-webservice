package service;

import com.kms.webservice.Application;
import com.kms.webservice.domain.posts.Posts;
import com.kms.webservice.domain.posts.PostsRepository;
import com.kms.webservice.dto.PostMainResponseDto;
import com.kms.webservice.dto.PostSaveRequestDto;
import com.kms.webservice.service.PostsService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PostserviceTest {

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    PostsService postsService;

    @Test
    public void 서비스로_바꾼거_테스트() {
        PostSaveRequestDto dto = PostSaveRequestDto.builder()
                .title("서비스로")
                .content("바꿨당")
                .author("귀찮")
                .build();

        postsService.save(dto);

        Posts post = postsRepository.findAll().get(0);
        assertThat(post.getTitle()).isEqualTo(dto.getTitle());
        assertThat(post.getContent()).isEqualTo(dto.getContent());
        assertThat(post.getAuthor()).isEqualTo(dto.getAuthor());
    }

    @Test void 역순조회() {

        for(int i=0; i<3; i++) {
            String _i = String.valueOf(i);
            PostSaveRequestDto dto = PostSaveRequestDto.builder()
                    .title(_i)
                    .content(_i)
                    .author(_i)
                    .build();
            postsService.save(dto);
        }

        PostMainResponseDto post = postsService.findAllDesc().get(0);
        assertThat(post.getTitle()).isEqualTo("2");
    }
}
