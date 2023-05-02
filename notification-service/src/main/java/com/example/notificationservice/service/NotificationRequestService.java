package com.example.notificationservice.service;


import com.example.notificationservice.model.NotificationRequest;

import java.util.List;

public interface NotificationRequestService {
    public NotificationRequest notificationRequestFindById(int id);
    public List<NotificationRequest> notificationRequestFindAll();
    public void notificationRequestSave(NotificationRequest notificationRequest);
    }
