package com.example.notificationservice.controller;
import com.example.notificationservice.model.NotificationRequest;
import com.example.notificationservice.service.NotificationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;

@RestController
@CrossOrigin
@RequestMapping("/notification")
public class NotificationController {



    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    NotificationRequestService notificationRequestService;

    @Value("${twilio.account-sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth-token}")
    private String twilioAuthToken;

    @Value("${twilio.from-number}")
    private String twilioFromNumber;

    @Value("${spring.mail.username}")
    private String gmailUsername;

    @Value("${spring.mail.password}")
    private String gmailPassword;

    @PostMapping("/send")
    public String sendNotifications(@RequestBody NotificationRequest request) {
        // Send email notification
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getRecipient());
        message.setFrom(gmailUsername);
        message.setSubject("New Notification");
        message.setText(request.getMessage());
        mailSender.send(message);

        // Send SMS notification
        Twilio.init(twilioAccountSid, twilioAuthToken);
        Message smsMessage = Message.creator(
                        new PhoneNumber(request.getNumber()),
                        new PhoneNumber(twilioFromNumber),
                        request.getMessage())
                .create();

        //save to db
        NotificationRequest notificationRequest = new NotificationRequest(request.getRecipient(), request.getMessage(), request.getNumber());
        notificationRequestService.notificationRequestSave(notificationRequest);

        return "Notifications sent";
    }
    @GetMapping("/{id}")
    ResponseEntity<NotificationRequest> findById(@PathVariable("id") int id){
        return ResponseEntity.ok(notificationRequestService.notificationRequestFindById(id));
    }

}
