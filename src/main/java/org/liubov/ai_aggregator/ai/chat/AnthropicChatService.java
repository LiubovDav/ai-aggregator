package org.liubov.ai_aggregator.ai.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.anthropic.AnthropicChatOptions;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AnthropicChatService {

    private final AnthropicChatModel chatModel;

    public AnthropicChatService(AnthropicChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String send(String text) {
        log.info("***************************************************************************************");
        log.info("{} REQUEST: {}", this.getClass().getName(), text);
        ChatResponse response = chatModel.call(
                new Prompt(
                        text,
                        AnthropicChatOptions.builder()
                                .model("claude-2.1")
                                .temperature(0.4)
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
