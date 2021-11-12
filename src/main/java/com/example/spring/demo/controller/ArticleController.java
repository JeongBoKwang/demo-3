package com.example.spring.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring.demo.dto.Article;
import com.example.spring.demo.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	public ArticleService articleService;
	
	@RequestMapping("/article/doAdd")
	@ResponseBody
	public Map<String, Object> doAdd(@RequestParam Map<String, Object> param) {
		
		 Map<String, Object> rs = articleService.add(param);
		
		return rs;
	}
	
	@RequestMapping("/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.getArticles();
	}
}
