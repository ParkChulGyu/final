package com.example.demo.question;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FileRequest {
	
//	private Long id;                // 파일 번호 (PK)
//    private String originalName;    // 원본 파일명
//    private String saveName;        // 저장 파일명
//	private long size;              // 파일 크기

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    @Column(name = "original_name", nullable = false)
    private String originalName;

    @Column(name = "save_name", nullable = false)
    private String saveName;

    @Column(name = "size", nullable = false)
    private long size;

    @Column(name = "delete_yn", nullable = false)
    private boolean deleteYN;

    @Column(name = "created_date", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDate;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Question post;
	
	
	public FileRequest() {
		
	}
	
	
	
	@Builder
    public FileRequest(String originalName, String saveName, long size) {
        this.originalName = originalName;
        this.saveName = saveName;
        this.size = size;
    }

    public void setPostId(Question post) {
        this.post = post;
    }

	
    
}
