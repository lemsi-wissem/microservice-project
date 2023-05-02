package com.example.notificationservice.repository;

import com.example.notificationservice.model.NotificationRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRequestRepository extends CrudRepository<NotificationRequest,Integer> {
}
