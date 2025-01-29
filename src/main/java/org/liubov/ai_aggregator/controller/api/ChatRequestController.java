package org.liubov.ai_aggregator.controller.api;

import org.liubov.ai_aggregator.ai.chat.ChatGPTChatService;
import org.liubov.ai_aggregator.ai.chat.GeminiChatService;
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

    public ChatRequestController(ChatGPTChatService chatGPTChatService, GeminiChatService geminiChatService) {
        this.chatGPTChatService = chatGPTChatService;
        this.geminiChatService = geminiChatService;
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
        return chatResponseDTO;
    }


}
