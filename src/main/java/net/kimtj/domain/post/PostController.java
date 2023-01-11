package net.kimtj.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
@RequiredArgsConstructor 
public class PostController {
	/*
	 * Controller 클래스
	 * 사용자의 요청, 응답 처리(UI담당)
	 */
    private final PostService postService;

    // 게시글 작성 페이지
    // 신규 게시글 등록시 id = null
    // 수정시 idx(params) -> id로 게시글 응답 객체를 post라는 이름으로 뷰(View)로 전달
    // 등록은 required = flase -> idx가 필요 x
    @GetMapping("/post/write.do")
    public String openPostWrite(  
    		@RequestParam(value = "id", required = false) final Long id, Model model) 
    {
        if (id != null) {
            PostResponse post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "post/write";
    }
    
    // 신규 게시글 생성
    // 등록 URI(post/save.do)와 연결
    //PostRequest멤버와 사용자입력필드의 "name" 값이 동일시 
    //params 멤버에 "name"으로 전달된 value 매핑
    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params) {
        postService.savePost(params);
        return "redirect:/post/list.do";
    }
    

}
