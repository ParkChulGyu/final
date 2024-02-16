package com.example.demo.board;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.BaseTimeEntity;
import com.example.demo.FileDownL.Photo;
import com.example.demo.Member.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "board")
public class Board extends BaseTimeEntity {
    //필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Member.class)
    @JoinColumn(name = "member_id", updatable = false)
    @JsonBackReference
    private Member member;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    
    @OneToMany(
     	   mappedBy = "board",
     	   cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
     	   orphanRemoval = true
     )
     private List<Photo> photo = new ArrayList<>();
    
  //빌더
    @Builder
    public Board(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
    }
    
    public void update(String title, String content) {
    	this.title = title;
    	this.content = content;
    }
    
 // Board에서 파일 처리 위함
    public void addPhoto(Photo photo) {
        this.photo.add(photo);

	// 게시글에 파일이 저장되어있지 않은 경우
        if(photo.getBoard() != this)
            // 파일 저장
            photo.setBoard(this);
    }
    
   
    
}
    
