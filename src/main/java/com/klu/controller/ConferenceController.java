package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Conference;
import com.klu.repository.ConferenceRepository;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
@CrossOrigin
public class ConferenceController {

    @Autowired
    private ConferenceRepository repo;

    @PostMapping
    public Conference add(@RequestBody Conference c) {
        return repo.save(c);
    }

    @GetMapping
    public List<Conference> getAll() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repo.deleteById(id);
    }
}