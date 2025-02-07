package org.liubov.ai_aggregator.dto;

import lombok.Data;

@Data
public class ChatResponseDTO {
    private Long chatResponseId;

    private Long chatInterchangeId;

    private String textChatGPT;

    private String textGemini;

    private String textMistral;

    private String textAnthropic;
}
