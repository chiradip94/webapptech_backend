package com.webapptech.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapptech.blog.Model.Post;
import com.webapptech.blog.Service.PostService;

@RestController
public class PostController {
	
	@Autowired
	private PostService service;

	@GetMapping("/post/all")
	public ResponseEntity<List<Post>> getAllPosts()
	{
		return new ResponseEntity<List<Post>>(service.getAllPosts(),HttpStatus.OK);
	}
	
	@GetMapping("/post")
	public ResponseEntity<Post> getPost(@RequestParam int id)
	{
		return new ResponseEntity<Post>(service.getPostById(id),HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> createPost(@RequestBody Post post)
	{
		int id = service.createPost(post);
		return new ResponseEntity<String>("Post(" +id+ ") has been submitted.",HttpStatus.CREATED);
	}
	
	@PutMapping("/post")
	public ResponseEntity<String> updatePost(@RequestBody Post post)
	{
		String title = service.updatePost(post);
		return new ResponseEntity<String>("Post(" +title+ ") has been updated.",HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/post")
	public ResponseEntity<String> deletePost(@RequestParam int id)
	{
		service.deletePostById(id);
		return new ResponseEntity<String>("Post deleted successfully.", HttpStatus.OK);
	}
	
	@PutMapping("/post/like")
	public ResponseEntity<String> addLike(@RequestParam int id)
	{
		String title = service.addLikes(id);
		return new ResponseEntity<String>(title+" post liked.", HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/post/dislike")
	public ResponseEntity<String> addDislike(@RequestParam int id)
	{
		String title = service.addDislikes(id);
		return new ResponseEntity<String>(title+" post disliked.", HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/post/comment")
	public ResponseEntity<String> addComment(@RequestParam int id, @RequestParam String comment)
	{
		String title = service.addComments(id, comment);
		return new ResponseEntity<String>("Comment added to "+title+" post.", HttpStatus.ACCEPTED);
	}
}
