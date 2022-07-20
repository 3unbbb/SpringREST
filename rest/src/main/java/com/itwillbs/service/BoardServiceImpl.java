package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{


private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public int createBoard(BoardVO vo) {
		
		return dao.create(vo);
		
		
	}

	@Override
	public List<BoardVO> readBoardList() {
		
		log.info("readBoardList() 호출");
		
		return dao.readList();
	}

	@Override
	public BoardVO readContent(Integer bno) {
		return dao.read(bno);
	}

	@Override
	public Integer updateBoard(BoardVO vo) {
		return dao.update(vo);
	}

	@Override
	public Integer deleteBoard(Integer bno) {
		return dao.delete(bno);
	}

	
	
}
