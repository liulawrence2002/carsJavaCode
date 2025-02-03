package com.grantapp.controller;

import com.grantapp.model.NewsAnnouncements;
import com.grantapp.repository.NewsAnnouncementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsAnnouncementsController {

    @Autowired
    private NewsAnnouncementsRepository newsAnnouncementsRepository;

    @PostMapping("/getAllNews")
    public List<NewsAnnouncements> getAllNews() {
        return newsAnnouncementsRepository.findAll();
    }
}