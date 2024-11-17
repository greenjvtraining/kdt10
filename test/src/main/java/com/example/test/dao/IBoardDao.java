package com.example.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.test.dto.BoardDto;
import com.example.test.vo.Criteria;

@Mapper
public interface IBoardDao {

	public int insert(@Param("board")BoardDto board);
	public BoardDto findByBno(int bno);
	public List<BoardDto> findAll();
	public List<BoardDto> findByOptions(BoardDto board);
	public int update(@Param("board")BoardDto board);
	public int delete(int bno);
	public List<BoardDto> findAllWithPaging(int startNum);
	public List<BoardDto> findAllWithPaging2(@Param("cri")Criteria cri);
	public int getCount();
}
