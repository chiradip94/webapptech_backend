package com.webapptech.blog.Service.Impl;

import java.util.List;
import java.util.Optional;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapptech.blog.Model.Comments;
import com.webapptech.blog.Model.Post;
import com.webapptech.blog.Repository.PostRepository;
import com.webapptech.blog.Service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository repository;
	
	@Override
	public int createPost(Post post) {
		
		Post p = repository.save(post);
		return p.getId();
	}

	@Override
	public String updatePost(Post post) {
		Post upost = repository.save(post);
		return upost.getTitle();
	}

	@Override
	public List<Post> getAllPosts() {
		return repository.findAll();
	}

	@Override
	public Post getPostById(int id) {
		Optional<Post> post = repository.findById(id);
		return post.get();
	}

	@Override
	public void deletePostById(int id) {
		repository.deleteById(id);		
	}

	@Override
	public String addLikes(int id) {
		Optional<Post> post = repository.findById(id);
		int likes = post.get().getLikes();
		repository.addLike(id,likes+1);
		return post.get().getTitle();
	}

	@Override
	public String addDislikes(int id) {
		Optional<Post> post = repository.findById(id);
		int dislikes = post.get().getDislikes();
		repository.addDisLike(id,dislikes+1);
		return post.get().getTitle();
	}

	@Override
	public String addComments(int id, String comment) {
		Optional<Post> post = repository.findById(id);
		List<Comments> cmnts = post.get().getComments();
		Comments c = new Comments();
		c.setComment(comment);
		cmnts.add(c);
		post.get().setComments(cmnts);
		repository.save(post.get());
		return post.get().getTitle();
	}

}
