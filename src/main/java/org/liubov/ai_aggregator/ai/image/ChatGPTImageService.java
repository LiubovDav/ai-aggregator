package org.liubov.ai_aggregator.ai.image;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.ai.openai.api.OpenAiImageApi;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChatGPTImageService {

    private final OpenAiImageModel openaiImageModel;

    public ChatGPTImageService(OpenAiImageModel openaiImageModel) {
        this.openaiImageModel = openaiImageModel;
    }

    public ImageResponse send(String text) {
        log.info("***************************************************************************************");
        log.info("{} REQUEST: {}", this.getClass().getName(), text);
        ImageResponse response = openaiImageModel.call(
                new ImagePrompt(text,
                        OpenAiImageOptions.builder()
                                .model(OpenAiImageApi.ImageModel.DALL_E_2.getValue())
//                                .quality("hd")
                                .N(1)
//                                .height(256)
//                                .width(256)
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
