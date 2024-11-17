package com.example.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.test.dto.BoardDto;

@SpringBootTest
class BoardDaoTest {

	@Autowired
	IBoardDao boardDao;
	
	@Test
	void testUpdate() {
		BoardDto board = BoardDto.builder()
				.bno(22)
				.title("수정 test21")
				.content("수정된 test21 내용입니다.")
				//.writer("admin")
				//.filename("ready.jpg")
				//.regdate(null)
				.build();
		int result = boardDao.update(board);
		
		assertEquals(result, 1);
	}
	
	//@Test
	void testDelete() {
		int result = boardDao.delete(24);
		
		assertEquals(result, 1);
	}
	
	//@Test
	void testFindByBno() {
		BoardDto board = boardDao.findByBno(1);
		
		assertEquals(board.getBno(), 1);
	}
	
	//@Test
	void testFindAll() {
		
		List<BoardDto> list = boardDao.findAll();
		
		assertNotNull(list);
	}
	
	//@Test
	void testInsert() {
		int result = 0;
		for(int count = 0; count < 24; count++) {
			BoardDto board = BoardDto.builder()
					.title("test" + count)
					.content("test " + count + "내용입니다.")
					.writer("admin")
					.filename("ready.jpg")
					//.regdate(null)
					.build();
			
			result += boardDao.insert(board);
		}
		System.out.println("result : " + result);
		assertEquals(result, 24);
	}

}
