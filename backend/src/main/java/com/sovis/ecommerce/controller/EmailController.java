package com.sovis.ecommerce.controller;

import com.sovis.ecommerce.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "http://localhost:5173")
public class EmailController {

  private final EmailService emailService;

  @Autowired
  public EmailController(EmailService emailService) {
    this.emailService = emailService;
  }

  @PostMapping("/send")
  public void sendEmail(
      @RequestParam String to,
      @RequestParam String subject,
      @RequestParam String message) {
    emailService.sendEmail(to, subject, message);
  }
}

