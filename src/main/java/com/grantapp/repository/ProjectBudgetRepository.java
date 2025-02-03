package com.grantapp.repository;

import com.grantapp.model.ProjectBudget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectBudgetRepository extends JpaRepository<ProjectBudget, Long> {
}