package repository;

import com.kms.webservice.Application;
import com.kms.webservice.domain.posts.Posts;
import com.kms.webservice.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void clean() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        Posts post = Posts.builder()
                .title("제목")
                .content("본문")
                .author("shvdl12@gmail.com")
                .build();

        postsRepository.save(post);

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("제목"));
        assertThat(posts.getContent(), is("본문"));
    }
}
