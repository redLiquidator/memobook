package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.MemoService;
import com.example.demo.vo.Memo;

@RestController
public class MemoController {

	@Autowired
	MemoService memoService;
	
	/*
	 * { "id":"1", "content":"buy a chair", "create_date":20210710,
	 * "update_date":20210710 }
	 */ 
	
	//CRUD - for postman testing
	@PostMapping("/addMemo")
		public String addMemo(@RequestBody Memo memo) {
		System.out.println("controller>addMemo");
		System.out.println(memo);
		return memoService.addMemo(memo);	
	}
	
	@GetMapping("/getAllMemos") public List<Memo> getAllMemos(){
		return memoService.getAllMemos();
	}
	
	@GetMapping("/getMemo/{id}") public Memo getMemo(@PathVariable int id) {
		return memoService.getMemo(id);
	}
	
	@PostMapping("/updateMemo")
	public String updateMemo(@RequestBody Memo memo) {
		return memoService.updateMemo(memo);
	}
	
	@GetMapping("/deleteMemo/{id}") 
	  public String deleteUser(@PathVariable int id) { 
		  return memoService.deleteMemo(id); 
	   }
	
	//connect to view file  .... 
	//(fixed)Whitelabel Error Page...? fixed by setting in application.properties file
	@GetMapping("/front")     
	public ModelAndView front() {
    
    List<Memo> memolist = memoService.getAllMemos();
    
    //assign index.html file to mv
    ModelAndView mv = new ModelAndView("index");
	mv.addObject("memo",memolist);

	return mv;
	}
	
}
