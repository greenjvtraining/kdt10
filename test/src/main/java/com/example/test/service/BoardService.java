package com.example.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.IBoardDao;
import com.example.test.dto.BoardDto;
import com.example.test.vo.Criteria;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService implements IBoardService{
	
	@Autowired
	private IBoardDao boardDao;

	@Override
	public int regist(BoardDto board) {
		int result = boardDao.insert(board);
		
		return result;
	}

	@Override
	public BoardDto getBoard(int bno) {
		
		BoardDto board = boardDao.findByBno(bno);
		
		return board;
	}

	@Override
	public List<BoardDto> getList() {
		log.info("board service ... list...");
		
		List<BoardDto> list = boardDao.findAll();
		
		return list;
	}

	@Override
	public List<BoardDto> getListWithOption(BoardDto board) {
		return null;
	}

	@Override
	public int modify(BoardDto board) {
		log.info("board service .... modify...");
		int result = boardDao.update(board);
		
		return result;
	}

	@Override
	public int remove(int bno) {
		int result = boardDao.delete(bno);
		
		return result;
	}

	@Override
	public List<BoardDto> getListWithPaging(int startNum) {
		log.info("board service ... getListWithPaging...");
		
		List<BoardDto> list = boardDao.findAllWithPaging(startNum);
		
		return list;
	}
	
	@Override
	public List<BoardDto> getListWithPaging2(Criteria cri) {
		log.info("board service ... getListWithPaging..." + cri);
		
		List<BoardDto> list = boardDao.findAllWithPaging2(cri);
		
		return list;
	}

	@Override
	public int getCount() {
		log.info("board service ... getCount...");
		int count = boardDao.getCount();
		return count;
	}
	
	
}
