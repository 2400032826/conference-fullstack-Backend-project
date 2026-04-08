package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Registration;
import com.klu.repository.RegistrationRepository;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin
public class RegistrationController {

    @Autowired
    private RegistrationRepository repo;

    // ✅ REGISTER PARTICIPANT
    @PostMapping
    public Registration register(@RequestBody Registration r) {
        return repo.save(r);   // 🔥 FIXED (was c)
    }

    // ✅ GET ALL REGISTRATIONS
    @GetMapping
    public List<Registration> getAll() {
        return repo.findAll();
    }
}