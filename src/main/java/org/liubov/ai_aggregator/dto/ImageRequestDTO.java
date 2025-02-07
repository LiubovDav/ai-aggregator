package org.liubov.ai_aggregator.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ImageRequestDTO {
    private Long imageDialogId;

    @NotEmpty(message = "Text should not be empty")
    private String text;
}
