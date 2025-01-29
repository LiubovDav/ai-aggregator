package org.liubov.ai_aggregator.dto;

import lombok.Data;

@Data
public class ImageResponseDTO {
    private Integer imageRequestId;
    // todo: modify the type
    private String image;
}
