package com.webapptech.blog.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Post {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int likes;
    private int dislikes;
    //@Column(unique = true)
    private String title;
    @Column(columnDefinition="VARCHAR(20000)") 
    private String content;
    @OneToMany(targetEntity = Comments.class,cascade = CascadeType.ALL)
    @JoinColumn(name="comment_fk",referencedColumnName = "id")
    private List<Comments> comments;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
    
    
}
