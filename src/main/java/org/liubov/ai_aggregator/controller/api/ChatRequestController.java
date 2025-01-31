package org.liubov.ai_aggregator.controller.api;

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

    public ChatRequestController(ChatGPTChatService chatGPTChatService, GeminiChatService geminiChatService, MistralChatService mistralChatService) {
        this.chatGPTChatService = chatGPTChatService;
        this.geminiChatService = geminiChatService;
        this.mistralChatService = mistralChatService;
    }

    @PostMapping
    public ChatResponseDTO send(@RequestBody ChatRequestDTO chatRequestDTO) {
        ChatResponseDTO chatResponseDTO = new ChatResponseDTO();
        String chatGPTChatResponse = chatGPTChatService.send(chatRequestDTO.getText());
        chatResponseDTO.setTextChatGPT(chatGPTChatResponse);
        // todo: uncomment when the issue is resolved
//        String geminiChatResponse = geminiChatService.send(chatRequestDTO.getText());
//        chatResponseDTO.setTextGemini(geminiChatResponse);
        chatResponseDTO.setTextGemini("Some response from Gemini");
        String mistralChatResponse = mistralChatService.send(chatRequestDTO.getText());
        chatResponseDTO.setTextMistral(mistralChatResponse);
        return chatResponseDTO;
    }

}
