package org.liubov.ai_aggregator.ai.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatOptions;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GeminiChatService {

    private final VertexAiGeminiChatModel chatModel;

    public GeminiChatService(VertexAiGeminiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String send(String text) {
        ChatResponse response = chatModel.call(
                new Prompt(
                        text,
                        VertexAiGeminiChatOptions.builder()
                                .model(VertexAiGeminiChatModel.ChatModel.GEMINI_1_5_FLASH)
                                .temperature(0.4)
                                .build()
                )
        );

        log.info("***************************************************************************************");
        log.info(response.getMetadata().toString());
        log.info("***************************************************************************************");
        log.info(response.getResult().toString());
        log.info("***************************************************************************************");
        log.info(response.getResult().getOutput().getText());
        log.info("***************************************************************************************");

        return response.getResult().getOutput().getText();
    }
}
