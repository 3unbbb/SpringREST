package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@RestController
@RequestMapping("/boards")
public class BoardRestController {

	private static final Logger log = LoggerFactory.getLogger(BoardRestController.class);
	
	@Inject
	private BoardService service;
	
	
	//http://localhost:8088/web/boards/
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> addBoard(@RequestBody BoardVO vo) {
		
		log.info("addBoard()");
		log.info(vo+"");
		
		//서비스 - 
		int result = service.createBoard(vo);
		log.info(result+"");
		//글 처리 결과에 따른상태 정보 리턴
		ResponseEntity<String> entity = null;
		
		
		if(result==1) {
			//정상 글쓰기 처리
			entity = new ResponseEntity<String>("addOK",HttpStatus.OK);
		}else {
			//비정상 글쓰기 처리
			entity = new ResponseEntity<String>("aaERR",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return  entity;
		
	}
	

	//http://localhost:8088/web/boards/all
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> readALL(){
		
		System.out.println("@@@@@@@@@@@@@ readALL()");
		
		//서비스동작
		List<BoardVO> boardList = service.readBoardList();
		//상태에 따른 처리 구분
		ResponseEntity<List<BoardVO>> entity = null;
		
		try {
			entity = new ResponseEntity<List<BoardVO>>(boardList, HttpStatus.OK);
		}catch (Exception e) {
			entity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value ="/{bno}", method =RequestMethod.GET)
	public ResponseEntity<BoardVO> readContent(@PathVariable("bno") Integer bno){
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$ content");
		
		BoardVO vo = service.readContent(bno);
		ResponseEntity<BoardVO> entity = null;
		
		if(vo != null) {
			entity = new ResponseEntity<BoardVO>(vo, HttpStatus.OK);
		}else{
			entity = new ResponseEntity<BoardVO>(vo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
		
		
	}
	//http://localhost:8088/web/boards/12528
	@RequestMapping(value="/{bno}", method=RequestMethod.PUT)
	public ResponseEntity<String> modifyBoard(@PathVariable("bno") Integer bno,
		@RequestBody BoardVO vo){
		
		System.out.println("%%%%%%%%%%%%%%%% update");
		
		//글 번호 정보, 수정정보 저장
		log.info("@@@ bno"+bno);
		vo.setBno(bno);
		log.info("@@@ bno"+vo);
		
		//서비스 - 글정보 수정동작 호출
		int result = service.updateBoard(vo);
		//수정 여부에 따라 메세지 전달
		
		ResponseEntity<String> entity = null;
		
		if(result==1) {
			entity = new ResponseEntity<String>("modOK", HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>("modErr", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{bno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteBoard(@PathVariable("bno") Integer bno){
		//삭제할 글 번호 가져오기
		
		log.info("bno : "+bno);
		
		//서비스 - 글 삭제 동작 호출
		int result = service.deleteBoard(bno);
		//삭제 결과에 따른 페이지 이동처리
		ResponseEntity<String> entity = null;
		
		if(result ==1) {
			entity = new ResponseEntity<String>("delOK",HttpStatus.OK);
		}else {
			entity = new ResponseEntity<String>("delERR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return entity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
