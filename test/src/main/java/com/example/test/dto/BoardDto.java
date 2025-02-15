package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String filename;
	private String regdate;
	private String modifydate;
}
