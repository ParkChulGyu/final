package com.example.demo.board;

import com.example.demo.board.BoardCreateRequestDto.BoardCreateRequestDtoBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardupdateRequestDto {
	private String title;
	private String content;
	
	@Builder
	public BoardupdateRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}

	
}
