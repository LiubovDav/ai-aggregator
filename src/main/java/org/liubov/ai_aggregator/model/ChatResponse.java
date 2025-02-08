package org.liubov.ai_aggregator.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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

    @Lob
    private String textChatGPT;

    @Lob
    private String textGemini;

    @Lob
    private String textMistral;

    @Lob
    private String textAnthropic;

    @CreationTimestamp
    private LocalDateTime createdOn;
}
