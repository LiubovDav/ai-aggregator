package org.liubov.ai_aggregator.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat_model")
@Data
public class ChatModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    private Long id;

    @Column(nullable = false)
    private String name; // ChatGPT

    @Column(nullable = false)
    private String fullName; // ChatGPT 4o mini

    @Column(nullable = false)
    private boolean active;

    @CreationTimestamp
    private LocalDateTime createdOn;
}
