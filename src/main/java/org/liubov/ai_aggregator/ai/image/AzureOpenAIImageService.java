package org.liubov.ai_aggregator.ai.image;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class AzureOpenAIImageService {

    public final OpenAiImageModel azureOpenaiImageModel;

    public AzureOpenAIImageService(OpenAiImageModel azureOpenaiImageModel) {
        this.azureOpenaiImageModel = azureOpenaiImageModel;
    }

    public ImageResponse send(String text) {
        ImageResponse response = azureOpenaiImageModel.call(
                new ImagePrompt(text,
                        OpenAiImageOptions.builder()
                                .quality("hd")
                                .N(1)
                                .height(1024)
                                .width(1024).build())

        );

        return response;
    }
}
