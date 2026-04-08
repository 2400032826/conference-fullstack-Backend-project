package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
}