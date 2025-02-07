package org.liubov.ai_aggregator.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat_interchange")
@Data
public class ChatInterchange {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    private Long id;

    @Column(nullable = false)
    private Long chatDialogId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chat_request_id", referencedColumnName = "id")
    private ChatRequest chatRequest;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chat_response_id", referencedColumnName = "id")
    private ChatResponse chatResponse;

    @CreationTimestamp
    private LocalDateTime createdOn;
}
