package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "content", nullable = false)
	private String content;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "newID")
	private NewEntity news;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userID")
	private UserEntity user;

	/*
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "parentCommentID") private CommentEntity parentComment;
	 * 
	 * @JsonBackReference
	 * 
	 * @OneToMany(mappedBy = "parentComment") private List<CommentEntity>
	 * listChildComment = new ArrayList<>();
	 */
	
	@ManyToOne
	@JoinColumn(name = "parentCommentID")
	private CommentEntity parentComment;
	
	@JsonBackReference
	@OneToMany(mappedBy = "parentComment")
	private List<CommentEntity> listChildComment = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NewEntity getNews() {
		return news;
	}

	public void setNews(NewEntity news) {
		this.news = news;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public CommentEntity getParentComment() {
		return parentComment;
	}

	public void setParentComment(CommentEntity parentComment) {
		this.parentComment = parentComment;
	}

	public List<CommentEntity> getListChildComment() {
		return listChildComment;
	}

	public void setListChildComment(List<CommentEntity> listChildComment) {
		this.listChildComment = listChildComment;
	}

}
