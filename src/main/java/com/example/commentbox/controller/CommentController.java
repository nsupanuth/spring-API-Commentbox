package com.example.commentbox.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.commentbox.model.Details;
import com.example.commentbox.model.Reply;

@RestController
public class CommentController {
	
	//private static Map<String, String> MAPS = new HashMap<String, String>();
	private static List<Map<String,Object>> details = new ArrayList<Map<String,Object>>();
	private static List<Map<String,Object>> replies = new ArrayList<Map<String,Object>>();
		
	@RequestMapping(value = "/comment",method = RequestMethod.POST)
	public List<Map<String,Object>> post(@RequestBody Map<String,Object> detail){
		details.add(detail);
		return details;
	}
	
	@RequestMapping(value = "/comment",method = RequestMethod.GET)
	public List<Map<String,Object>> getComment(){
		return details;
	}
	
	@RequestMapping(value = "/reply",method = RequestMethod.POST)
	public List<Map<String,Object>> replies(@RequestBody Map<String,Object> reply){
		Map<String,Object> m = details.get(0);
		replies.add(reply);
		m.put("replies",replies);
		
		return details;
		
		
	}
	
		

 
}
