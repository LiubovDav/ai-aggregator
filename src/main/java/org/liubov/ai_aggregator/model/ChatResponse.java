package org.liubov.ai_aggregator.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import static org.liubov.ai_aggregator.config.AppValues.TEXT_MAX_LENGTH;

@Entity
@Table(name = "chat_response")
@Data
public class ChatResponse {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(value = AccessLevel.PRIVATE)
    private Long id;

    @OneToOne(mappedBy = "chatResponse")
    private ChatInterchange chatInterchange;

    @Column(length = TEXT_MAX_LENGTH)
    private String textChatGPT;

    @Column(length = TEXT_MAX_LENGTH)
    private String textGemini;

    @Column(length = TEXT_MAX_LENGTH)
    private String textMistral;

    @Column(length = TEXT_MAX_LENGTH)
    private String textAnthropic;

    @CreationTimestamp
    private LocalDateTime createdOn;
}
