package org.liubov.ai_aggregator.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class ChatDialogDTO {
    private Long chatDialogId;

    @NotEmpty(message = "chatDialogId should not be empty")
    private Long userId;

    private List<ChatInterchangeDTO> chatInterchanges;
}
