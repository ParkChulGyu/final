package com.example.demo.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.FileDownL.BoardFileVO;
import com.example.demo.FileDownL.Photo;
import com.example.demo.FileDownL.PhotoDto;
import com.example.demo.FileDownL.PhotoResponseDto;
import com.example.demo.FileDownL.PhotoService;
import com.example.demo.Member.Member;
import com.example.demo.Member.MemberService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	private final PhotoService fileService;
    private final MemberService memberService;
	
	
	
	
	
	
	
	
	
	
	@PutMapping("/board/{id}")
    public Long update(@PathVariable Long id, BoardFileVO boardFileVO) throws Exception {

        BoardupdateRequestDto requestDto = BoardupdateRequestDto.builder()
            			     .title(boardFileVO.getTitle())
            			     .content(boardFileVO.getContent())
            			     .build();
        
        // DB에 저장되어있는 파일 불러오기 
        List<PhotoResponseDto> dbPhotoList = fileService.findAllByBoard(id);
        // 전달되어온 파일들
        List<MultipartFile> multipartList = boardFileVO.getFiles();
        // 새롭게 전달되어온 파일들의 목록을 저장할 List 선언
        List<MultipartFile> addFileList = new ArrayList<>();

        if(CollectionUtils.isEmpty(dbPhotoList)) { // DB에 아예 존재 x
            if(!CollectionUtils.isEmpty(multipartList)) { // 전달되어온 파일이 하나라도 존재
                for (MultipartFile multipartFile : multipartList)
                    addFileList.add(multipartFile);	// 저장할 파일 목록에 추가
            }
        }
        else {  // DB에 한 장 이상 존재
            if(CollectionUtils.isEmpty(multipartList)) { // 전달되어온 파일 아예 x
             	// 파일 삭제
                for(PhotoResponseDto dbPhoto : dbPhotoList)
                    fileService.deletePhoto(dbPhoto.getFileId());
            }
            else {  // 전달되어온 파일 한 장 이상 존재
            
            	// DB에 저장되어있는 파일 원본명 목록
                List<String> dbOriginNameList = new ArrayList<>();

		// DB의 파일 원본명 추출
                for(PhotoResponseDto dbPhoto : dbPhotoList) {
                    // file id로 DB에 저장된 파일 정보 얻어오기
                    PhotoDto dbPhotoDto = fileService.findByFileId(dbPhoto.getFileId());
                    // DB의 파일 원본명 얻어오기
                    String dbOrigFileName = dbPhotoDto.getOrigFileName();

                   if(!multipartList.contains(dbOrigFileName))  // 서버에 저장된 파일들 중 전달되어온 파일이 존재하지 않는다면
                        fileService.deletePhoto(dbPhoto.getFileId());  // 파일 삭제
                    else  // 그것도 아니라면
                        dbOriginNameList.add(dbOrigFileName);	// DB에 저장할 파일 목록에 추가
                }

                for (MultipartFile multipartFile : multipartList) { // 전달되어온 파일 하나씩 검사
                    // 파일의 원본명 얻어오기
                    String multipartOrigName = multipartFile.getOriginalFilename();
                    if(!dbOriginNameList.contains(multipartOrigName)){   // DB에 없는 파일이면
                        addFileList.add(multipartFile); // DB에 저장할 파일 목록에 추가
                    }
                }
            }
        }

	// 각각 인자로 게시글의 id, 수정할 정보, DB에 저장할 파일 목록을 넘겨주기
        return boardService.update(id, requestDto, addFileList);
    }
	
	@GetMapping("/board/{id}")
	public BoardResponseDto searchById(@PathVariable Long id) {
		// 게시글 id로 해당 게시글 첨부파일 전체 조회
    	List<PhotoResponseDto> photoResponseDtoList =
        	fileService.findAllByBoard(id);
        // 게시글 첨부파일 id 담을 List 객체 생성 
        List<Long> photoId = new ArrayList<>();
      	// 각 첨부파일 id 추가
        for(PhotoResponseDto photoResponseDto : photoResponseDtoList)
            photoId.add(photoResponseDto.getFileId());
        
        // 게시글 id와 첨부파일 id 목록 전달받아 결과 반환
        return boardService.searchById(id, photoId);
	}
	
	@GetMapping("/board")
	public String searchAllDesc(Model model){
		
		
		List<Board> boardList = boardService.searchAllDesc();
        // 반환할 List<BoardListResponseDto> 생성
        List<BoardListResponseDto> responseDtoList = new ArrayList<>();

        for(Board board : boardList){
            // 전체 조회하여 획득한 각 게시글 객체를 이용하여 BoardListResponseDto 생성
            BoardListResponseDto responseDto = new BoardListResponseDto(board);
            responseDtoList.add(responseDto);
        }

        model.addAttribute("responseDtoList",responseDtoList);
        return "qna/qnalist";
	}
	
	@DeleteMapping("/board/{id}")
	public void delete(@PathVariable Long id) {
		boardService.delete(id);
	}
	
	@GetMapping("/create")
	public String createform(BoardFileVO boardFileVO) {
		
		return "qna/create";
	}
	
	
	@PostMapping("/board")
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(BoardFileVO boardFileVO) throws Exception {
	// Member id로 조회하는 메소드 존재한다고 가정하에 진행
        Member member = memberService.searchMemberById(
        	Long.parseLong(boardFileVO.getMemberId()));

        BoardCreateRequestDto requestDto = 
        	BoardCreateRequestDto.builder()
            			     .member(member)
            			     .title(boardFileVO.getTitle())
            			     .content(boardFileVO.getContent())
            			     .build();

        return boardService.create(requestDto, boardFileVO.getFiles());
    }
	
}
