package org.liubov.ai_aggregator.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ChatRequestDTO {
    private Long chatRequestId;

    private Long chatDialogId;

    private Long chatInterchangeId;

    private Double temperature;

    @NotEmpty(message = "Text should not be empty")
    private String text;
}
