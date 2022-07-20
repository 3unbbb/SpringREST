package com.itwillbs.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	
	//http://localhost:8088/web/create
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public void createGET() {
		
		log.info("createGET() 호출");
		
		
	
		}
	//http://localhost:8088/web/all
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String readGET() {
		
		
		//read 뷰에서 ajax로 rest컨트롤러 갔다 옴
		return "read";
	}
	
	//http://localhost:8088/web/12528
	@RequestMapping(value="/{bno}", method=RequestMethod.GET)
	//? >>paramata
	//{bno}는 @pathVariable
	public String readContentGET(@PathVariable("bno") Integer bno, Model model) {
		
		System.out.println("############## : readContentGET()");
		
		System.out.println("조회 글 번호 : " + bno);
		
		BoardVO vo = service.readContent(bno);
		
		model.addAttribute("vo",vo); 
		
		
		
		return "content";
	}

	
	
}
