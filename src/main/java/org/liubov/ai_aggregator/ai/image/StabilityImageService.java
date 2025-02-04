package org.liubov.ai_aggregator.ai.image;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.stabilityai.StabilityAiImageModel;
import org.springframework.ai.stabilityai.api.StabilityAiImageOptions;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StabilityImageService {

    private final StabilityAiImageModel stabilityaiImageModel;

    public StabilityImageService(StabilityAiImageModel stabilityaiImageModel) {
        this.stabilityaiImageModel = stabilityaiImageModel;
    }

    public ImageResponse send(String text) {
        log.info("***************************************************************************************");
        log.info("{} REQUEST: {}", this.getClass().getName(), text);
        ImageResponse response = stabilityaiImageModel.call(
                new ImagePrompt(text,
                        StabilityAiImageOptions.builder()
                                .stylePreset("cinematic")
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
