package com.abnew.model.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
	public int postNewBoard(Board board);
	public Board getBoardById(int id);
	public List<Board> getBoardList(String order);
	public int updateBoard(Board board);
	public int updateLikeCount(Board board);
	public int updateCommentsCount(Board board);
	public int deleteBoard(int id);
}
