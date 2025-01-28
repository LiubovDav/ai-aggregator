package org.liubov.ai_aggregator.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ChatDialogDTO {
    private Integer chatDialogId;
    @NotEmpty(message = "chatDialogId should not be empty")
    private Integer userId;
}
