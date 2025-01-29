package org.liubov.ai_aggregator.controller.api;

import org.liubov.ai_aggregator.ai.image.AzureOpenAIImageService;
import org.liubov.ai_aggregator.ai.image.ChatGPTImageService;
import org.liubov.ai_aggregator.ai.image.StabilityImageService;
import org.liubov.ai_aggregator.dto.ImageRequestDTO;
import org.liubov.ai_aggregator.dto.ImageResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/image_request")
public class ImageRequestController {

    private final ChatGPTImageService chatGPTImageService;
    private final AzureOpenAIImageService azureOpenAIImageService;
    private final StabilityImageService stabilityImageService;

    public ImageRequestController(ChatGPTImageService chatGPTImageService, AzureOpenAIImageService azureOpenAIImageService, StabilityImageService stabilityImageService) {
        this.chatGPTImageService = chatGPTImageService;
        this.azureOpenAIImageService = azureOpenAIImageService;
        this.stabilityImageService = stabilityImageService;
    }

    @PostMapping
    public ImageResponseDTO send(@RequestBody ImageRequestDTO imageRequestDTO) {
        ImageResponseDTO imageResponseDTO = new ImageResponseDTO();
        chatGPTImageService.send("A light cream colored mini golden doodle");
        azureOpenAIImageService.send("A light cream colored mini golden doodle");
        stabilityImageService.send("A light cream colored mini golden doodle");
        return imageResponseDTO;
    }
}
