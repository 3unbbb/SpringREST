package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {
	
	
	//글쓰기(create)
	public int createBoard(BoardVO vo);
	
	//글조회
	public List<BoardVO> readBoardList();
	
	public BoardVO readContent(Integer bno);
	
	public Integer updateBoard(BoardVO vo);
	
	public Integer deleteBoard(Integer bno);

}
