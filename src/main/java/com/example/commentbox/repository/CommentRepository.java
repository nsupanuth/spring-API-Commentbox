package com.example.commentbox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commentbox.model.Details;

public interface CommentRepository extends JpaRepository<Details, Integer>{
	
	public List<Details> findByDetailIs(String detail);
	
}
