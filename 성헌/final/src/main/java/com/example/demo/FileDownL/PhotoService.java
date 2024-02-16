package com.example.demo.FileDownL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PhotoService {
	
	private final PhotoRepository photoRepository;
	
	@Transactional
    public PhotoDto findByFileId(Long id){

        Photo entity = photoRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 파일이 존재하지 않습니다."));

        PhotoDto photoDto = PhotoDto.builder()
                .origFileName(entity.getOrigFileName())
                .filePath(entity.getFilePath())
                .fileSize(entity.getFileSize())
                .build();

        return photoDto;
    }

    /**
     * 이미지 전체 조회
     */
    @Transactional
    public List<PhotoResponseDto> findAllByBoard(Long boardId){

        List<Photo> photoList = photoRepository.findAllByBoardId(boardId);

        return photoList.stream()
                .map(PhotoResponseDto::new)
                .collect(Collectors.toList());
    }
    
    
    @Transactional
    public void deletePhoto(Long fileid) {
    	Photo entity = photoRepository.findById(fileid).orElseThrow(()
                -> new IllegalArgumentException("해당 파일이 존재하지 않습니다."));
    	photoRepository.delete(entity);
    	
    	
    }
    
    

}