package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.klu.model.Session;
import com.klu.repository.SessionRepository;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin
public class SessionController {

    @Autowired
    private SessionRepository repo;

    @GetMapping
    public List<Session> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Session add(@RequestBody Session s) {
        return repo.save(s);
    }
}