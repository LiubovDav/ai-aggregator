package org.liubov.ai_aggregator.ai.chat;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.stereotype.Service;

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
