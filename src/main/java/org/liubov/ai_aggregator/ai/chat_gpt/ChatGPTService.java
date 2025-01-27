package org.liubov.ai_aggregator.ai.chat_gpt;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatGPTService {

    @Value("${CHAT_GPT_API_KEY}")
    private String chatGptApiKey;

    public ChatResponse send(String text) {
        if (chatGptApiKey == null) {
            System.out.println("***************************************************************************************");
            System.out.println("chatGptApiKey is null");
            System.out.println("***************************************************************************************");
            return null;
        }

        // todo: initialize ones
        ChatModel chatModel = new OpenAiChatModel(new OpenAiApi(chatGptApiKey));

        ChatResponse response = chatModel.call(
                new Prompt(
                        text,
                        OpenAiChatOptions.builder()
//                                .model("gpt-4-o")
                                .model("gpt-4o-mini")
                                .temperature(0.4)
                                .build()
                ));

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
