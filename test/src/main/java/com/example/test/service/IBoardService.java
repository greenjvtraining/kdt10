package com.example.test.service;

import java.util.List;

import com.example.test.dto.BoardDto;
import com.example.test.vo.Criteria;

public interface IBoardService {
	
	public int regist(BoardDto board);
	public BoardDto getBoard(int bno);
	public List<BoardDto> getList();
	public List<BoardDto> getListWithOption(BoardDto board);
	public int modify(BoardDto board);
	public int remove(int bno);
	public List<BoardDto> getListWithPaging(int startNum);
	public List<BoardDto> getListWithPaging2(Criteria cri);
	
	public int getCount();
}
