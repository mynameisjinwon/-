package com.abnew.model.comments;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsDao {
	public int createNewComments(Comments comments);
	public List<Comments> getAllComments();
	public List<Comments> getAllCommentsByB_id(int b_id);
	public int getCommentsCount(int b_id);
	public int deleteCommentsById(int id);
}
