package com.abnew.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abnew.model.board.Board;
import com.abnew.model.comments.Comments;
import com.abnew.service.BoardService;
import com.abnew.service.CommentsService;

@Controller
public class BoardController {

	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService boardService;
	@Autowired 
	private CommentsService commentsService;
		
	// 게시글 목록
	@GetMapping("/")
	public String board(Model model) {
		model.addAttribute("boards", boardService.getBoardList());
		log.debug("boards : {}", boardService.getBoardList());
		return "board/board_list";
	}
	
	// 게시글 내용 보기
	@GetMapping("/board/view/{id}")
	public String viewBoard(@PathVariable Integer id, Model model) {
		
		Board board = boardService.getBoardById(id);
		
		if(board.getComments_count() > 0) {
			model.addAttribute("comments_list", commentsService.getAllCommentsByB_id(id));
		}
		
		model.addAttribute("board", board);
		log.debug("viewBoard() b_id : {}", id);
		
		return "board/view_board";
	}
	
	// 게시글 작성 화면
	@GetMapping("/board") 
	public String showBoardForm() {
		return "board/new_board";
	}
	
	// 게시글 등록
	@PostMapping("/board") 
	public String createNewBoard(Board board, @RequestParam("like_count") String like_count) {

		board.setB_like_count(Integer.parseInt(like_count));
		board.setB_date(getNow());
		
		int result = boardService.postNewBoard(board);
		log.debug("result : {}", result);
		
		return "redirect:/";
	}
	
	// 글 수정
	@PostMapping("/board/update/{id}") 
	public String showUpdatePage(@PathVariable Integer id, @RequestParam("password") String password, Model model) {
		
		Board board = boardService.getBoardById(id);
		if(!board.getB_author_pw().equals(password)) {
			return "redirect:/board/view/" + id;
		}
		model.addAttribute("board", board);
		
		return "/board/update_board";
	}
	
	// 글 수정
	@PostMapping("/board/update")
	public String updateBoard(Board board) {
		
		log.debug("board : {}", board);
		boardService.updateBoard(board);
		int id = board.getB_id();
		
		return "redirect:/board/view/" + id;
	}
	
	// 글 삭제
	@PostMapping("/board/delete/{id}")
	public String deleteBoard(@PathVariable Integer id, @RequestParam("password") String password) {
		Board board = boardService.getBoardById(id);
		if(!board.getB_author_pw().equals(password)) {
			return "redirect:/board/view" + id;
		}
		
		boardService.deleteBoard(id);
		
		return "redirect:/";
	}
	
	// 댓글 등록 
	@PostMapping("/board/comments/{id}")
	public String createNewComments(@PathVariable Integer id, Comments comments) {
		
		comments.setB_id(id);
		comments.setC_date(getNow());
		
		log.debug("new comments : {}", comments);
		commentsService.createNewComments(comments);
		
		Board board = boardService.getBoardById(id);
		int comments_count = commentsService.getCommentsCount(board.getB_id());
		log.debug("b_id : {}, comments_count : {}", board.getB_id(), comments_count);
		
		board.setComments_count(comments_count);
		boardService.updateCommentsCount(board);
		log.debug("after update board : {}", boardService.getBoardById(id));
		
		return "redirect:/board/view/" + id;
	}	
	
	// 댓글 삭제
	@PostMapping("/board/comments/delete/{id}")
	public String deleteComments(@PathVariable Integer id, @RequestParam("b_id") Integer b_id) {
		
		commentsService.deleteCommentsById(id);
		
		Board board = boardService.getBoardById(b_id);
		board.setComments_count(board.getComments_count()-1);
		boardService.updateCommentsCount(board);
		
		return "redirect:/board/view/" + b_id; 
	}
	// 좋아요 
	@GetMapping("/board/like/{id}")
	public String boardLike(@PathVariable Integer id) {
		
		Board board = boardService.getBoardById(id);
		int like_count = board.getB_like_count();
		if(like_count < 9999) { 
			board.setB_like_count(like_count + 1);
			boardService.updateLikeCount(board);
		}
		log.debug("after update board : {}", boardService.getBoardById(id));
		return "redirect:/board/view/" + id;
	}
	
	private String getNow() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
	}
}
