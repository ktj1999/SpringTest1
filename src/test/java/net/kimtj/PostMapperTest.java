package net.kimtj;

import net.kimtj.domain.post.PostMapper;
import net.kimtj.domain.post.PostRequest;
import net.kimtj.domain.post.PostResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;

@SpringBootTest
public class PostMapperTest {

    @Autowired
    PostMapper postMapper;
    /**
     * save() : 게시글 생성
     * PostRequest 객체를 생성 -> set()로 값 세팅 
     * -> PostMapper의 save()호출 -> PostMapper XML Mapper의 save() 실행
     * auto_increment에 의해 자동 증가
     */
    @Test
    void save() {
    	PostRequest params = new PostRequest();
    	params.setTitle("1번 게시글 제목");
    	params.setContent("1번 게시글 제목");
    	params.setWriter("테스터");
    	params.setNoticeYn(false);
    	postMapper.save(params);
    	
        List<PostResponse> posts = postMapper.findAll();
        System.out.println("전체 게시글 개수는 : " + posts.size() + "개입니다.");
    }
    /**
     * findById() : 게시글 조회
     * PK(=id) WHERE문으로 특정 게시글 조회
     * Jackson 라이브러리로 Json문자열로 변경후 출력
     */
    @Test
    void findById() {
        PostResponse post = postMapper.findById(1L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * update( ) : 게시글 정보 수정
     * WHERE로 사용할 PK(=id)를 파라미터로 전달후 수정
     */
    @Test
    void update() {
        // 1. 게시글 수정
        PostRequest params = new PostRequest();
        params.setId(1L);
        params.setTitle("1번 게시글 제목 수정합니다.");
        params.setContent("1번 게시글 내용 수정합니다.");
        params.setWriter("김태준");
        params.setNoticeYn(true);
        postMapper.update(params);

        // 2. 게시글 상세정보 조회
        PostResponse post = postMapper.findById(1L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
    void delete() {
        System.out.println("삭제 이전의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다.");
        postMapper.deleteById(1L);
        System.out.println("삭제 이후의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다.");
    }
}