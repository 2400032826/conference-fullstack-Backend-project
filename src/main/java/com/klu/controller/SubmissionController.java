package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.klu.model.Submission;
import com.klu.model.User;
import com.klu.repository.SubmissionRepository;
import com.klu.repository.UserRepository;

import java.io.File;

@RestController
@RequestMapping("/api/submissions")

public class SubmissionController {

    @Autowired
    private SubmissionRepository submissionRepo;

    @Autowired
    private UserRepository userRepo;

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/submit")
   
    public String submit(
        @RequestParam("title") String title,
        @RequestParam("abstractText") String abstractText,
        @RequestParam("file") MultipartFile file,
        @RequestParam("email") String email
    ) {
        Submission s = new Submission();

        s.setTitle(title);
        s.setAbstractText(abstractText);
        s.setFileName(file.getOriginalFilename());
        s.setStatus("Under Review");

        submissionRepo.save(s); // 🔥 VERY IMPORTANT

        return "Saved";
    
    }

    @GetMapping
    public java.util.List<Submission> getAll() {
        return submissionRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        submissionRepo.deleteById(id);
    }
}