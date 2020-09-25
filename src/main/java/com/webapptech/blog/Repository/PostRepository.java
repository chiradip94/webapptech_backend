package com.webapptech.blog.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webapptech.blog.Model.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE Post p SET p.likes = :likes WHERE p.id = :id")
	void addLike(@Param("id") int id,@Param("likes") int likes);
	
	@Transactional
	@Modifying
	@Query("UPDATE Post p SET p.dislikes = :dislikes WHERE p.id = :id")
	void addDisLike(@Param("id") int id,@Param("dislikes") int dislikes);
	
	/*@Query("UPDATE Post p SET p.comments = :comment")
	void addComment(@Param("id")int id, @Param("comment") String comment);*/
}
