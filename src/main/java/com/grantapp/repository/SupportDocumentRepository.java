package com.grantapp.repository;

import com.grantapp.model.SupportDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportDocumentRepository extends JpaRepository<SupportDocument, Long> {
}