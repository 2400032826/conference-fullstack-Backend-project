package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}