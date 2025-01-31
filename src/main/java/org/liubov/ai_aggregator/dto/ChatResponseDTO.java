package org.liubov.ai_aggregator.dto;

import lombok.Data;

@Data
public class ChatResponseDTO {
    private Integer textRequestId;
    private String textChatGPT;
    private String textGemini;
    private String textMistral;
}
