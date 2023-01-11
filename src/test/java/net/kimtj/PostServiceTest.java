package net.kimtj;

import net.kimtj.domain.post.PostRequest;
import net.kimtj.domain.post.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void save() {
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        System.out.println("생성된 게시글 ID : "+postService.savePost(params));
    }
    
    @Test
    void findById() {
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        System.out.println("조회된 게시글 ID : "+postService.savePost(params));
    }
    
    @Test
    void update() {
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        System.out.println("변경된 게시글 ID : "+postService.savePost(params));
    }
    
    @Test
    void delete() {
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        System.out.println("삭제된 게시글 ID : "+postService.savePost(params));
    }
}