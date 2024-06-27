package org.example.consumer_service.db.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "message_entity")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String message;

}
