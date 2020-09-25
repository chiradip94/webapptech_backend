package com.webapptech.blog.Service;

import java.util.List;

import com.webapptech.blog.Model.Post;

public interface PostService {
	public int createPost(Post post);
	public String updatePost(Post post);
	public List<Post> getAllPosts();
	public Post getPostById(int id);
	public void deletePostById(int id);
	public String addLikes(int id);
	public String addDislikes(int id);
	public String addComments(int id, String comment);
}
