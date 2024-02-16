package com.example.demo.FileDownL;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PhotoController {
	
	
	
	 private final PhotoService photoService;
	/**
     * 썸네일용 이미지 조회
     */
    @CrossOrigin
    @GetMapping(
            value = "/thumbnail/{id}",
            // 출력하고자 하는 데이터 포맷 정의
            produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE}
    )
    public ResponseEntity<byte[]> getThumbnail(@PathVariable Long id) throws Exception {
    
    	// 이미지가 저장된 절대 경로 추출
        String absolutePath =
        	new File("").getAbsolutePath() + File.separator + File.separator;
        String path;

	
        if(id != 0) {  // 전달되어 온 이미지가 기본 썸네일이 아닐 경우
        	PhotoDto photoDto = photoService.findByFileId(id);
            path = photoDto.getFilePath();
        }
        else {  // 전달되어 온 이미지가 기본 썸네일일 경우
            path = "images" + File.separator + "thumbnail" + File.separator + "thumbnail.png";
        }
        
	// FileInputstream의 객체를 생성하여
    	// 이미지가 저장된 경로를 byte[] 형태의 값으로 encoding
        InputStream imageStream = new FileInputStream(absolutePath + path);
        byte[] imageByteArray = IOUtils.toByteArray(imageStream);
        imageStream.close();
        
        return new ResponseEntity<>(imageByteArray, HttpStatus.OK);
    }

    /**
     * 이미지 개별 조회
     */
    @CrossOrigin
    @GetMapping(
            value = "/image/{id}",
            produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE}
    )
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        PhotoDto photoDto = photoService.findByFileId(id);
        String absolutePath
        	= new File("").getAbsolutePath() + File.separator + File.separator;
        String path = photoDto.getFilePath();

        InputStream imageStream = new FileInputStream(absolutePath + path);
        byte[] imageByteArray = IOUtils.toByteArray(imageStream);
        imageStream.close();
        
        return new ResponseEntity<>(imageByteArray, HttpStatus.OK);
    }

}
