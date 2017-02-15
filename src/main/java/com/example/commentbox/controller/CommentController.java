package com.example.commentbox.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.commentbox.model.Details;
import com.example.commentbox.model.Reply;
import com.example.commentbox.repository.CommentRepository;

@RestController
public class CommentController {
	
	//private static Map<String, String> MAPS = new HashMap<String, String>();
	private static List<Details> details = new ArrayList<Details>();
	private static List<Reply> replies = new ArrayList<Reply>();
	
	@Autowired
	private CommentRepository commentRepository;
		
	@RequestMapping(value = "/comment",method = RequestMethod.POST)
	public List<Details> post(@RequestBody Details detail){
//		details.add(detail);
//		return details ;	
		int check = commentRepository.findByDetailIs(detail.getDetail()).size();
		/* check repeat data */
		if(check == 0){
			commentRepository.save(detail);
		}
			
		return commentRepository.findAll();
		
	}
	
	@RequestMapping(value = "/comment",method = RequestMethod.GET)
	public List<Details> getComment(){
		return commentRepository.findAll() ;	
	}
	
	@RequestMapping(value = "comment/{page}/reply",method = RequestMethod.POST)
	public List<Details> replies(@PathVariable("page") int page,@RequestBody Reply reply){
		
		Details d = commentRepository.findOne(page);
		d.getReplies().add(reply);
		commentRepository.save(d);
		
		return commentRepository.findAll();
//		Details d = details.get(0);
//		replies.add(reply);
//		d.setReplies(replies);
//		
//		return details; 
		
	}
	
		

 
}
