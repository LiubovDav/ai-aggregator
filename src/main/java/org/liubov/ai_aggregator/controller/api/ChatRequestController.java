package org.liubov.ai_aggregator.controller.api;

import org.liubov.ai_aggregator.ai.chat.AnthropicChatService;
import org.liubov.ai_aggregator.ai.chat.ChatGPTChatService;
import org.liubov.ai_aggregator.ai.chat.GeminiChatService;
import org.liubov.ai_aggregator.ai.chat.MistralChatService;
import org.liubov.ai_aggregator.dto.ChatRequestDTO;
import org.liubov.ai_aggregator.dto.ChatResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/chat_request")
public class ChatRequestController {

    private final ChatGPTChatService chatGPTChatService;
    private final GeminiChatService geminiChatService;
    private final MistralChatService mistralChatService;
    private final AnthropicChatService anthropicChatService;

    public ChatRequestController(ChatGPTChatService chatGPTChatService, GeminiChatService geminiChatService, MistralChatService mistralChatService, AnthropicChatService anthropicChatService) {
        this.chatGPTChatService = chatGPTChatService;
        this.geminiChatService = geminiChatService;
        this.mistralChatService = mistralChatService;
        this.anthropicChatService = anthropicChatService;
    }

    @PostMapping
    public ChatResponseDTO send(@RequestBody ChatRequestDTO chatRequestDTO) {
        ChatResponseDTO chatResponseDTO = new ChatResponseDTO();
        try {
            String chatGPTChatResponse = chatGPTChatService.send(chatRequestDTO.getText());
            chatResponseDTO.setTextChatGPT(chatGPTChatResponse);
        } catch (Exception e) {
            chatResponseDTO.setTextChatGPT("Error from ChatGPT");
        }

        try {
            String geminiChatResponse = geminiChatService.send(chatRequestDTO.getText());
            chatResponseDTO.setTextGemini(geminiChatResponse);
        } catch (Exception e) {
            chatResponseDTO.setTextGemini("Error from Gemini");
        }

        try {
            String mistralChatResponse = mistralChatService.send(chatRequestDTO.getText());
            chatResponseDTO.setTextMistral(mistralChatResponse);
        } catch (Exception e) {
            chatResponseDTO.setTextMistral("Error from Mistral");
        }

        try {
            String anthropicChatResponse = anthropicChatService.send(chatRequestDTO.getText());
            chatResponseDTO.setTextAnthropic(anthropicChatResponse);
        } catch (Exception e) {
            chatResponseDTO.setTextAnthropic("Error from Anthropic");
        }

        // save interchange to DB

        return chatResponseDTO;
    }

}
