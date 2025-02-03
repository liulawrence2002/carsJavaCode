package com.grantapp.repository;

import com.grantapp.model.NewsAnnouncements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsAnnouncementsRepository extends JpaRepository<NewsAnnouncements, Long> {
}