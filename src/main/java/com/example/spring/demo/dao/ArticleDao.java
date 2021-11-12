package com.example.spring.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.spring.demo.dto.Article;

@Component
public class ArticleDao {
	private List<Article> articleList;
	
	ArticleDao() {
		articleList = new ArrayList<>();
	}
	
	public void add(Article article) {
		articleList.add(article);
	}

	public Article getLastArticle() {
		if(articleList.size() > 0) {
			return articleList.get(articleList.size() -1);
		}
		return null;
	}

	public List<Article> getArticles() {
		return articleList;
	}
}
