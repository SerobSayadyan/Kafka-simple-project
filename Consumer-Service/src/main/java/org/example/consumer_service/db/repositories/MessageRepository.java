package org.example.consumer_service.db.repositories;

import org.example.consumer_service.db.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> { }
