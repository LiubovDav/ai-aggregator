package org.liubov.ai_aggregator.ai.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChatGPTChatService {

    private final OpenAiChatModel chatModel;

    public ChatGPTChatService(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public ChatResponse send(String text) {
        ChatResponse response = chatModel.call(
                new Prompt(
                        text,
                        OpenAiChatOptions.builder()
                                .model(OpenAiApi.ChatModel.GPT_4_O_MINI)
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

        return response;
    }
}
