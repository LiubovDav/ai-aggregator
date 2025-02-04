package org.liubov.ai_aggregator.ai.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.ai.mistralai.MistralAiChatOptions;
import org.springframework.ai.mistralai.api.MistralAiApi;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MistralChatService {

    private final MistralAiChatModel chatModel;

    public MistralChatService(MistralAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String send(String text) {
        log.info("***************************************************************************************");
        log.info("{} REQUEST: {}", this.getClass().getName(), text);
        ChatResponse response = chatModel.call(
                new Prompt(text,
                        MistralAiChatOptions.builder()
                                .model(MistralAiApi.ChatModel.LARGE.getValue())
                                .temperature(0.5)
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
        log.info("{} OUTPUT TEXT: {}", this.getClass().getName(), text);
        log.info(response.getResult().getOutput().getText());
        log.info("***************************************************************************************");

        return response.getResult().getOutput().getText();
    }


}
