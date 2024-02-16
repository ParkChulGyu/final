package com.example.demo.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.example.demo.answer.Answer;
import com.example.demo.category.Category;
import com.example.demo.comment.Comment;
import com.example.demo.user.SiteUser;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
    
    private LocalDateTime modifyDate;
    
    
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) 
    private List<Answer> answerList;
    
    @ManyToOne
    private SiteUser author;
    
    @ManyToMany
    Set<SiteUser> voter;
    
    @Column(columnDefinition = "integer default 0")
    @NotNull
    private Integer views = 0;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    @ManyToOne
    private Category category;
    
}
