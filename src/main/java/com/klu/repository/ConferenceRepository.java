package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.model.Conference;

public interface ConferenceRepository extends JpaRepository<Conference, Integer> {
}