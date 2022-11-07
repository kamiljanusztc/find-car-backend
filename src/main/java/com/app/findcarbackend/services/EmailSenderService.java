package com.app.findcarbackend.services;

import com.app.findcarbackend.domain.Client;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    public void sendEmail(Client clent) {
        System.out.println("Email to " + clent.getEmail() + ", have a good day :) Thanks for using our app !");
    }
}
