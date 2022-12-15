package com.abnew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abnew.model.comments.Comments;
import com.abnew.model.comments.CommentsDao;

@Service
public class CommentsService {
	
	@Autowired 
	private CommentsDao commentsDao;
	
	public int createNewComments(Comments comments) {
		return commentsDao.createNewComments(comments);
	}
	
	public List<Comments> getAllComments() {
		return commentsDao.getAllComments();
	}
	
	public List<Comments> getAllCommentsByB_id(int b_id) {
		return commentsDao.getAllCommentsByB_id(b_id);
	}
	public int getCommentsCount(int b_id) {
		return commentsDao.getCommentsCount(b_id);
	}
	
	public int deleteCommentsById(int c_id) {
		return commentsDao.deleteCommentsById(c_id);
	}
}
