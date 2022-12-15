package com.abnew.model.board;

public class Board {
	private int b_id;
	private String b_author_id;
	private String b_author_pw;
	private String b_title;
	private String b_content;
	private int b_like_count;
	private String b_date;
	private int comments_count;
	
	public Board() {
		super();
	}

	public Board(int b_id, String b_author_id, String b_author_pw, String b_title, String b_content, int b_like_count,
			String b_date, int comments_count) {
		super();
		this.b_id = b_id;
		this.b_author_id = b_author_id;
		this.b_author_pw = b_author_pw;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_like_count = b_like_count;
		this.b_date = b_date;
		this.comments_count = comments_count;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_author_id() {
		return b_author_id;
	}

	public void setB_author_id(String b_author_id) {
		this.b_author_id = b_author_id;
	}

	public String getB_author_pw() {
		return b_author_pw;
	}

	public void setB_author_pw(String b_author_pw) {
		this.b_author_pw = b_author_pw;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public int getB_like_count() {
		return b_like_count;
	}

	public void setB_like_count(int b_like_count) {
		this.b_like_count = b_like_count;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public int getComments_count() {
		return comments_count;
	}

	public void setComments_count(int comments_count) {
		this.comments_count = comments_count;
	}

	@Override
	public String toString() {
		return "Board [b_id=" + b_id + ", b_author_id=" + b_author_id + ", b_author_pw=" + b_author_pw + ", b_title="
				+ b_title + ", b_content=" + b_content + ", b_like_count=" + b_like_count + ", b_date=" + b_date
				+ ", comments_count=" + comments_count + "]";
	}
}
