package net.kimtj.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor //클래스 내 final로 선언된 모든 멤버 생성자 생성
public class PostService {
	/**
	 * 서비스 영역 
	 * - 비즈니스 로직 담당
	 */
    private final PostMapper postMapper;

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK(생성된 게시글 PK)
     */
    @Transactional //선언적 트랜잭션
    public Long savePost(final PostRequest params) {
        postMapper.save(params);
        return params.getId();
    }

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    public PostResponse findPostById(final Long id) {
        return postMapper.findById(id);
    }

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
    @Transactional
    public Long updatePost(final PostRequest params) {
        postMapper.update(params);
        return params.getId();
    }

    /**
     * 게시글 삭제
     * @param id - PK
     * @return PK
     */
    public Long deletePost(final Long id) {
        postMapper.deleteById(id);
        return id;
    }

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    public List<PostResponse> findAllPost() {
        return postMapper.findAll();
    }

}