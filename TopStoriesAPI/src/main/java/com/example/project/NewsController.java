package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class NewsController 
{
@Autowired
NewsService newsService;

@RequestMapping(value="/news/topstories",method=RequestMethod.GET)
@ResponseBody
public News getNews() throws Exception
 {
	System.out.println("Executing the Top News Strories Controller now...");
	return newsService.getTopStories();
 }
}
