package com.example.demo.FileDownL;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long>{
	
	List<Photo> findAllByBoardId(Long boardId);

}
