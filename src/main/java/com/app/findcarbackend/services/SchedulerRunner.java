package com.app.findcarbackend.services;

import com.app.findcarbackend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerRunner {

    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    ClientRepository clientRepository;

    @Scheduled(cron = "0 0 */1 * * *")
    public void cronTaskRunner() {
        clientRepository.findAll().forEach(client -> {
            emailSenderService.sendEmail(client);
        });
    }
}
