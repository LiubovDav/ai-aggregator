package org.liubov.ai_aggregator.ai.image;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.ai.openai.api.OpenAiImageApi;
import org.springframework.stereotype.Service;

@Service
public class ChatGPTImageService {

    private final OpenAiImageModel openaiImageModel;

    public ChatGPTImageService(OpenAiImageModel openaiImageModel) {
        this.openaiImageModel = openaiImageModel;
    }

    public ImageResponse send(String text) {
        ImageResponse response = openaiImageModel.call(
                new ImagePrompt(text,
                        OpenAiImageOptions.builder()
                                .model(OpenAiImageApi.ImageModel.DALL_E_2.getValue())
//                                .quality("hd")
                                .N(1)
//                                .height(256)
//                                .width(256)
                                .build())
        );

        System.out.println("***************************************************************************************");
        System.out.println(response.getMetadata().toString());
        System.out.println("***************************************************************************************");
        System.out.println(response.getResult().toString());
        System.out.println("***************************************************************************************");
        System.out.println(response.getResult().getOutput().getUrl());
        System.out.println("***************************************************************************************");
        System.out.println(response.getResult().getOutput().getB64Json());
        System.out.println("***************************************************************************************");

        return response;
    }

}
