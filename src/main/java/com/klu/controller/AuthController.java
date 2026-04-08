package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.model.User;
import com.klu.repository.UserRepository;
import com.klu.service.EmailService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private EmailService emailService;

 // ================= REGISTER =================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User existingUser = userRepo.findByEmail(user.getEmail());

            if (existingUser != null && existingUser.isVerified()) {
                return ResponseEntity.status(400).body("Email already exists");
            }

            String otp = String.valueOf((int)(Math.random() * 900000) + 100000);
            user.setOtp(otp);
            user.setVerified(false);

            // ✅ FIXED
            if (user.getRole() == null || user.getRole().isEmpty()) {
                user.setRole("participant");
            }

            userRepo.save(user);

            System.out.println("OTP for " + user.getEmail() + ": " + otp);

            try {
                emailService.sendEmail(
                    user.getEmail(),
                    "Your OTP Code",
                    "Your OTP is: " + otp
                );
            } catch (Exception e) {
                System.out.println("EMAIL FAILED BUT USER SAVED");
            }

            return ResponseEntity.ok("OTP sent");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Server error");
        }
    }
    // ================= VERIFY OTP =================
    @PostMapping("/verify")
    public ResponseEntity<?> verifyOtp(@RequestBody User user) {

        User dbUser = userRepo.findByEmail(user.getEmail());

        if (dbUser == null) {
            return ResponseEntity.status(404).body("User not found");
        }

        if (dbUser.getOtp() != null && dbUser.getOtp().equals(user.getOtp())) {
            dbUser.setVerified(true);
            userRepo.save(dbUser);
            return ResponseEntity.ok("Verified successfully");
        } else {
            return ResponseEntity.status(400).body("Invalid OTP");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        System.out.println("Entered Email: " + user.getEmail());
        System.out.println("Entered Password: " + user.getPassword());

        User u = userRepo.findByEmail(user.getEmail());

        if (u == null) {
            System.out.println("User NOT FOUND");
            return ResponseEntity.status(401).body("Invalid");
        }

        System.out.println("DB Password: " + u.getPassword());

        // 🔥 FIXED CONDITION
        if (u.getPassword().equals(user.getPassword())) {
            System.out.println("LOGIN SUCCESS");
            return ResponseEntity.ok(u);
        }

        System.out.println("PASSWORD MISMATCH");
        return ResponseEntity.status(401).body("Invalid");
    }
}