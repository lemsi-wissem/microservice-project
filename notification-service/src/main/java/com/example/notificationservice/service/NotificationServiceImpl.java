package com.example.notificationservice.service;

import com.example.notificationservice.model.NotificationRequest;
import com.example.notificationservice.repository.NotificationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationRequestService {
    @Autowired
    NotificationRequestRepository notificationRequestRepository;


    @Override
    public NotificationRequest notificationRequestFindById(int id) {
        return notificationRequestRepository.findById(id).orElseThrow(()->new RuntimeException());
    }

    @Override
    public List<NotificationRequest> notificationRequestFindAll() {
        return (List<NotificationRequest>) notificationRequestRepository.findAll();
    }

    @Override
    public void notificationRequestSave(NotificationRequest notificationRequest) {
       notificationRequestRepository.save(notificationRequest);
    }
}
