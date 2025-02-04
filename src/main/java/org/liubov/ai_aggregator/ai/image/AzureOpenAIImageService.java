package org.liubov.ai_aggregator.ai.image;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AzureOpenAIImageService {

    public final OpenAiImageModel azureOpenaiImageModel;

    public AzureOpenAIImageService(OpenAiImageModel azureOpenaiImageModel) {
        this.azureOpenaiImageModel = azureOpenaiImageModel;
    }

    public ImageResponse send(String text) {
        log.info("***************************************************************************************");
        log.info("{} REQUEST: {}", this.getClass().getName(), text);
        ImageResponse response = azureOpenaiImageModel.call(
                new ImagePrompt(text,
                        OpenAiImageOptions.builder()
//                                .quality("hd")
                                .N(1)
//                                .height(1024)
//                                .width(1024)
                                .build()
                )
        );

        log.info("***************************************************************************************");
        log.info("{} METADATA: {}", this.getClass().getName(), text);
        log.info(response.getMetadata().toString());
        log.info("***************************************************************************************");
        log.info("{} RESULT: {}", this.getClass().getName(), text);
        log.info(response.getResult().toString());
        log.info("***************************************************************************************");
        log.info("{} RESULT B64Json: {}", this.getClass().getName(), text);
        log.info(response.getResult().getOutput().getB64Json());
        log.info("***************************************************************************************");
        log.info("{} RESULT URL: {}", this.getClass().getName(), text);
        log.info(response.getResult().getOutput().getUrl());
        log.info("***************************************************************************************");

        return response;
    }
}
