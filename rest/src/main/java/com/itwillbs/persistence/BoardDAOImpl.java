package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession session;
	
	private static final String NAMESPACE="com.itwillbs.mapper.BoardMapper";
	
	
	@Override
	public int create(BoardVO vo) {
		
		return session.insert(NAMESPACE+".createBoard", vo);
	}


	@Override
	public List<BoardVO> readList() {
		
		return session.selectList(NAMESPACE+".readList");
	}


	@Override
	public BoardVO read(Integer bno) {
		
		return session.selectOne(NAMESPACE+".read", bno);
	}


	@Override
	public Integer update(BoardVO vo) {
		
		return session.update(NAMESPACE+".modify", vo);
	}


	@Override
	public Integer delete(Integer bno) {
		return session.delete(NAMESPACE+".delete", bno);
	}

}
