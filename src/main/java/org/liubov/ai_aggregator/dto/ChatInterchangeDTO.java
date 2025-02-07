package org.liubov.ai_aggregator.dto;

import lombok.Data;

@Data
public class ChatInterchangeDTO {
    private Long chatInterchangeId;

    private Long chatDialogId;

    private ChatRequestDTO chatRequest;

    private ChatResponseDTO chatResponse;
}
