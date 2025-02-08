package org.liubov.ai_aggregator.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat_request")
@Data
public class ChatRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    private Long id;

    @Column(nullable = false)
    private Long chatDialogId;

    @OneToOne(mappedBy = "chatRequest")
    private ChatInterchange chatInterchange;

    @Lob
    private String text;

    @CreationTimestamp
    private LocalDateTime createdOn;
}
