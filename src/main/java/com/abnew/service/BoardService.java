package com.abnew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abnew.model.board.Board;
import com.abnew.model.board.BoardDao;

@Service	
public class BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	public Board getBoardById(int id) {
		return boardDao.getBoardById(id);
	}
	
	public List<Board> getBoardList() {
		return boardDao.getBoardList("desc");
	}
	
	public int postNewBoard(Board board) {
		return boardDao.postNewBoard(board);
	}
	
	public int updateBoard(Board board) {
		return boardDao.updateBoard(board);
	}
	
	public int updateLikeCount(Board board) {
		return boardDao.updateLikeCount(board);
	}

	public int updateCommentsCount(Board board) {
		return boardDao.updateCommentsCount(board);
	}
	
	public int deleteBoard(int id) {
		return boardDao.deleteBoard(id);
	}
}
