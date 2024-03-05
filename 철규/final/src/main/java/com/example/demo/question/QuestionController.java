package com.example.demo.question;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.answer.AnswerForm;
import com.example.demo.user.SiteUser;
import com.example.demo.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {
	
	private final QuestionService questionService;
	 private final UserService userService;
	 private final FileService fileService;
	    private final FileUtils fileUtils;
	
	@GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page,@RequestParam(value = "kw", defaultValue = "") String kw) {
		Page<Question> paging = this.questionService.getList(page,kw);
        model.addAttribute("paging", paging);
        model.addAttribute("kw", kw);
        return "question_list";
    }
	
	@GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id,AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
		return "question_detail";
    }
	
	@GetMapping("/create")
    public String questionCreate(QuestionForm questionForm, Question question,Model model) {
		model.addAttribute("question", question);
        return "question_form";
    }
	@PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult,@RequestParam(value="subject") String subject, @RequestParam(value="content") String content,Principal principal,PostRequest params, Model model) {
		if (bindingResult.hasErrors()) {
            return "question_form";
        }
		SiteUser siteUser = this.userService.getUser(principal.getName());
		Integer id = this.questionService.create(questionForm.getSubject(), questionForm.getContent(),siteUser); // TODO 질문을 저장한다.
		List<FileRequest> files = fileUtils.uploadFiles(params.getFiles());
		Question question = this.questionService.getQuestion(id);
		fileService.saveFiles(question, files);
		return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
	}
	
	@PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal,Model model) {
        Question question = this.questionService.getQuestion(id);
        if(!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        questionForm.setSubject(question.getSubject());
        questionForm.setContent(question.getContent());
        model.addAttribute("question", question);
        return "question_form";
    }
	@PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult, 
            Principal principal, @PathVariable("id") Integer id,final PostRequest params) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        Question question = this.questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
        
        // 2. 파일 업로드 (to disk)
        List<FileRequest> uploadFiles = fileUtils.uploadFiles(params.getFiles());

        // 3. 파일 정보 저장 (to database)
        fileService.saveFiles(question, uploadFiles);

        // 4. 삭제할 파일 정보 조회 (from database)
        List<FileRequest> deleteFiles = new ArrayList<>(); 
        for (Long Id : params.getRemoveFileIds()) {
        	deleteFiles.add(fileService.findAllFileById(Id));
        
        }
        // 5. 파일 삭제 (from disk)
        fileUtils.deleteFiles(deleteFiles);

        // 6. 파일 삭제 (from database)
        fileService.deleteAllFileByIds(params.getRemoveFileIds());
        
        
        
        return String.format("redirect:/question/detail/%s", id);
    }
	
	@PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String questionDelete(Principal principal, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.questionService.delete(question);
        return "redirect:/";
    }
	
	@PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}")
    public String questionVote(Principal principal, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.vote(question, siteUser);
        return String.format("redirect:/question/detail/%s", id);
    }
	
	
	
	
}
