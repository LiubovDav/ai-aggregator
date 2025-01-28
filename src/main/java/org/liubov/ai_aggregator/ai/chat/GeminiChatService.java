package org.liubov.ai_aggregator.ai.chat;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class GeminiChatService {

    private final VertexAiGeminiChatModel chatModel;

    public GeminiChatService(VertexAiGeminiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public ChatResponse send(String text) {
        ChatResponse response = chatModel.call(
                new Prompt(
                        text,
                        VertexAiGeminiChatOptions.builder()
                                .model(VertexAiGeminiChatModel.ChatModel.GEMINI_1_5_FLASH)
                                .temperature(0.4)
                                .build()
                )
        );

        System.out.println("***************************************************************************************");
        System.out.println(response.getMetadata().toString());
        System.out.println("***************************************************************************************");
        System.out.println(response.getResult().toString());
        System.out.println("***************************************************************************************");
        System.out.println(response.getResult().getOutput().getText());
        System.out.println("***************************************************************************************");

        return response;
    }
}
