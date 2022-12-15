package com.abnew.model.comments;

public class Comments {
	private int b_id;
	private int c_id;
	private String c_author_id;
	private String c_author_pw;
	private String c_content;
	private String c_date;
	
	public Comments() {
		super();
	}


	public Comments(int b_id, int c_id, String c_author_id, String c_author_pw, String c_content, String c_date) {
		super();
		this.b_id = b_id;
		this.c_id = c_id;
		this.c_author_id = c_author_id;
		this.c_author_pw = c_author_pw;
		this.c_content = c_content;
		this.c_date = c_date;
	}


	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_author_id() {
		return c_author_id;
	}

	public void setC_author_id(String c_author_id) {
		this.c_author_id = c_author_id;
	}

	public String getC_author_pw() {
		return c_author_pw;
	}

	public void setC_author_pw(String c_author_pw) {
		this.c_author_pw = c_author_pw;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	@Override
	public String toString() {
		return "Comments [b_id=" + b_id + ", c_id=" + c_id + ", c_author_id=" + c_author_id + ", c_author_pw="
				+ c_author_pw + ", c_content=" + c_content + ", c_date=" + c_date + "]";
	}

}
