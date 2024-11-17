package com.example.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.test.dto.BoardDto;
import com.example.test.service.IBoardService;
import com.example.test.vo.BoardVo;
import com.example.test.vo.Criteria;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

	@Autowired
	private IBoardService boardService;
	
	@Value("${app.page.amount}")
	private int amount;
	
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	
	@RequestMapping("/main")
	public @ResponseBody String main() {
		System.out.println("main...");
		return "board main...";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("board list..........");
		
		List<BoardDto> list = boardService.getList();
		model.addAttribute("list", list);
		
		return "/board/list";
	}
	
	@RequestMapping("/listWithPaging")
	public String listWithPaging(@RequestParam("pageNum")int pageNum, Model model) {
		log.info("board listWithPaging..........");
		//게시글 페이지 지정하기
		int startNum = pageNum * 10 - 10;
		List<BoardDto> list = boardService.getListWithPaging(startNum);
		model.addAttribute("list", list);
		
		//게시글 페이지 수 정하기
		int totalCnt = boardService.getCount();
		int endNum = Math.ceilDiv(totalCnt, 10);
		
		model.addAttribute("endNum", endNum);
		
		return "/board/listWithPaging";
	}
	
	@RequestMapping("/listWithPaging2")
	public String listWithPaging2(Criteria cri, Model model) {
		log.info("board listWithPaging2.........." + cri);
		//게시글 페이지 지정하기
		int startNum = cri.getPageNum() * cri.getAmount() - cri.getAmount();
		cri.setStartNum(startNum);
		List<BoardDto> list = boardService.getListWithPaging2(cri);
		model.addAttribute("list", list);
		
		model.addAttribute("cri", cri);
		
		//게시글 페이지 수 정하기
		int totalCnt = boardService.getCount();
		int endNum = Math.ceilDiv(totalCnt, cri.getAmount());
		
		model.addAttribute("endNum", endNum);
		
		return "/board/listWithPaging2";
	}
	
	
	@GetMapping("/board/{bno}")
	public String getBoard(@PathVariable("bno")int bno, Model model) {
		log.info("board getBoard...." + bno);
		
		BoardDto board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		
		return "/board/detail";
	}
	
	@GetMapping("/board/delete/{bno}")
	public String delete(@PathVariable("bno") int bno, RedirectAttributes rttr) {
		log.info("board delete...." + bno);
		
		int result = boardService.remove(bno);
		rttr.addAttribute("result", result);
		
		return "redirect:/board/listWithPaging2";
	}
	
	@RequestMapping("/modify")
	public String modify(BoardVo vo) {
		log.info("board modify...." + vo + ", amount: " + amount);
		MultipartFile file = vo.getFile();
		String filename = file.getOriginalFilename();
		
		BoardDto board = BoardDto.builder()
				.bno(vo.getBno())
				.title(vo.getTitle())
				.content(vo.getContent())
				//.writer(vo.getWriter())
				.filename(filename)
				.build();
		
		try {
			file.transferTo(new File(uploadPath + filename));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		int result = boardService.modify(board);
		log.info("result : " + result);
		
		int pageNum = Math.ceilDiv(board.getBno(), amount);
		
		return "redirect:/board/listWithPaging2?pageNum="+pageNum + "&amount=" + amount;
	}
	
	@RequestMapping("/registForm")
	public String registForm() {
		log.info("board registForm....");
		return "/board/registForm";
	}
	
	@RequestMapping("/regist")
	public String regist(BoardVo board) {
		log.info("board regist........." + board);

		MultipartFile file = board.getFile();
		String filename = file.getOriginalFilename();
		//String path = "C:\\uploads\\";
		
		File uploadFile = new File(uploadPath + filename);
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		BoardDto dto = BoardDto.builder()
				.title(board.getTitle())
				.content(board.getContent())
				.writer(board.getWriter())
				.filename(filename)
				.build();
		
		int result = boardService.regist(dto);
		log.info("regist result : " + result);
		
		return "redirect:/board/listWithPaging2";
	}
}
