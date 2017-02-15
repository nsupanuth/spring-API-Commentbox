package com.example.commentbox.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.engine.spi.CascadingActions;

@Entity
public class Details {
	
	@Id
	@GeneratedValue
	private Integer id ;
	private String detail ;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Reply> replies ;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public List<Reply> getReplies() {
		return replies;
	}
	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	
	
	
}
