package com.example.TobiasOblig.service;

import com.example.TobiasOblig.model.Mail;
import com.example.TobiasOblig.model.MyDTO;
import com.example.TobiasOblig.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MailServiceImpl implements MailService{
    private final MailRepository mailRepository;
    @Autowired
    public MailServiceImpl (MailRepository mailRepository){
        this.mailRepository = mailRepository;
    }
    @Override
    public Mail getMailById(Long id){
        Optional<Mail> optionalProduct = mailRepository.findById(id);
        return optionalProduct.orElse(null);
    }
    @Override
    public void saveMail(Mail mail){
        mailRepository.save(mail);
    }
    @Override
    public void deleteMail(Long id){
        mailRepository.deleteById(id);
    }
    @Override
    public List<Mail> getAllMails(){
        return mailRepository.findAll();
    }
    @Override
    public List<Mail> getAllFromEmail(String fromEmail){
        return mailRepository.findAllByFromEmail(fromEmail);
    }
    @Override
    public List<Mail> getAllToEmail(String toEmail){
        return mailRepository.findAllByToEmail(toEmail);
    }
    @Override
    public List<MyDTO> getAllDTOs(){
        ArrayList<MyDTO> myDTOS = new ArrayList<>();
        myDTOS.add(new MyDTO("n1", "l1"));
        myDTOS.add(new MyDTO("n2", "l2 "));
        return myDTOS;
    }
    @Override
    public List<Mail> getMailsByDomain(String domain) {
        return mailRepository.getMailByDomain(domain);
    }
}