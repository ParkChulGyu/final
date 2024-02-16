package com.example.demo.board;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.FileDownL.FileHandler;
import com.example.demo.FileDownL.Photo;
import com.example.demo.FileDownL.PhotoRepository;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	private final BoardRepository boardRepository;
	private final PhotoRepository photoRepository;
    private final FileHandler fileHandler;
	
    @Transactional
    public Long create(
    	BoardCreateRequestDto requestDto,
        List<MultipartFile> files
    ) throws Exception {
	// 파일 처리를 위한 Board 객체 생성
        Board board = new Board(
                requestDto.getMember(),
                requestDto.getTitle(),
                requestDto.getContent()
        );

        List<Photo> photoList = fileHandler.parseFileInfo(files, board);

  	// 파일이 존재할 때에만 처리
        if(!photoList.isEmpty()) {
            for(Photo photo : photoList) {
                // 파일을 DB에 저장
  		        board.addPhoto(photoRepository.save(photo));
            }
        }

        return boardRepository.save(board).getId();
    }
	
	@Transactional
    public Long update(Long id, BoardupdateRequestDto requestDto,List<MultipartFile> files)
    		throws Exception {
		Board board = boardRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        List<Photo> photoList = fileHandler.parseFileInfo(files, board);

        if(!photoList.isEmpty()){
            for(Photo photo : photoList) {
                photoRepository.save(photo);
            }
        }

        board.update(requestDto.getTitle(),
        	     requestDto.getContent());

        return id;
    }
	 /**
     * 개별 조회
     * */
    @Transactional
    public BoardResponseDto searchById(Long id, List<Long> fileId){
        Board entity = boardRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        return new BoardResponseDto(entity, fileId);
    }
	
    /**
     * 전체 조회
     * */
    @Transactional
    public List<Board> searchAllDesc() {
        return boardRepository.findAllByOrderByIdDesc();
    }
	
	@Transactional
	public void delete(Long id) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("해당 게시물이 존재하지 않습니다"));
		boardRepository.delete(board);
	}
	
	
	
}
