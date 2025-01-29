package org.liubov.ai_aggregator.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ChatRequestDTO {
    private Integer chatDialogId;
    @NotEmpty(message = "Text should not be empty")
    private String text;
}
