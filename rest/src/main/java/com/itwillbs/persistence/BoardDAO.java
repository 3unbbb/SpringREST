package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	
	//글쓰기
	public int create(BoardVO vo);

	public List<BoardVO> readList();
	
	public BoardVO read(Integer bno);
	
	public Integer update(BoardVO vo);
	
	public Integer delete(Integer bno);
	
	
	
	
}
