package com.example.spring.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring.demo.dao.ArticleDao;
import com.example.spring.demo.dto.Article;

@Component
public class ArticleService {
	@Autowired
	ArticleDao articleDao;
	
	public Map<String, Object> add(Map<String, Object> param) {
		Article lastArticle = articleDao.getLastArticle();
		
		int id = 1;
		
		if( lastArticle != null) {
			id = lastArticle.getId() + 1;
		}
		
		String title = (String)param.get("title");
		String body = (String)param.get("body");
		
		Article article = new Article(id, title, body);
		
		articleDao.add(article);
		
		Map<String, Object> rs = new HashMap<>();
		rs.put("resultCode", "S-1");
		rs.put("msg", "게시글이 잘 추가되었습니다.");
		rs.put("id", id);
		
		return rs;
	}

	public List<Article> getArticles() {
		return articleDao.getArticles();
	}
	
}
