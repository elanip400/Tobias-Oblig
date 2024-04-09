package com.example.TobiasOblig.service;

import com.example.TobiasOblig.model.Mail;
import com.example.TobiasOblig.model.MyDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface MailService { // business logic
    Mail getMailById(Long id);
    void saveMail(Mail mail);
    void deleteMail(Long id);
    List <Mail> getAllMails();
    List<Mail> getAllFromEmail(String fromEmail);
    List<Mail> getAllToEmail(String toEmail);
    List<MyDTO> getAllDTOs();
    List<Mail> getMailsByDomain(String domain);
}