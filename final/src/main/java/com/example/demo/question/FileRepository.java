package com.example.demo.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FileRepository extends JpaRepository<Question, Integer> {

	void save(FileRequest file);

//	void saveAll(List<FileRequest> files);

	@Query("SELECT f FROM FileRequest f WHERE f.post.id = :postid")
	List<FileRequest> findAllByPostId(@Param("postid") long postid);

	
	@Query("SELECT f FROM FileRequest f WHERE f.id = :id")
	 FileRequest findAllById(@Param("id") Long id);

	
	@Modifying
	@Query("DELETE FROM FileRequest f WHERE f.id = :id")
	void deleteById(@Param("id") Long id);

	
	
	
	
	
}
