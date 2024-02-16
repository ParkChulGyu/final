package com.example.demo.question;

import java.util.List;

import com.example.demo.category.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.user.SiteUser;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
    Page<Question> findAll(Pageable pageable);
    Page<Question> findAll(Specification<Question> spec, Pageable pageable);

    Page<Question> findByAuthor(SiteUser siteUser, Pageable pageable);

    Page<Question> findByCategory(Category category, Pageable pageable);
}
