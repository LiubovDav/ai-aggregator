package org.liubov.ai_aggregator.ai.image;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.stabilityai.StabilityAiImageModel;
import org.springframework.ai.stabilityai.api.StabilityAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class StabilityImageService {

    private final StabilityAiImageModel stabilityaiImageModel;

    public StabilityImageService(StabilityAiImageModel stabilityaiImageModel) {
        this.stabilityaiImageModel = stabilityaiImageModel;
    }

    public ImageResponse send(String text) {

        ImageResponse response = stabilityaiImageModel.call(
                new ImagePrompt(text,
                        StabilityAiImageOptions.builder()
                                .stylePreset("cinematic")
                                .N(1)
//                                .height(1024)
//                                .width(1024)
                                .build())
        );

        System.out.println("***************************************************************************************");
        System.out.println(response.getMetadata().toString());
        System.out.println("***************************************************************************************");
        System.out.println(response.getResult().toString());
        System.out.println("***************************************************************************************");
        System.out.println(response.getResult().getOutput().getB64Json());
        System.out.println("***************************************************************************************");
        System.out.println(response.getResult().getOutput().getUrl());
        System.out.println("***************************************************************************************");

        return response;
    }

}
