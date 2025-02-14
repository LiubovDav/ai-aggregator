package org.liubov.ai_aggregator.controller.api;

import org.liubov.ai_aggregator.ai.chat.*;
import org.liubov.ai_aggregator.dto.ChatInterchangeDTO;
import org.liubov.ai_aggregator.dto.ChatRequestDTO;
import org.liubov.ai_aggregator.dto.ChatResponseDTO;
import org.liubov.ai_aggregator.service.ChatInterchangeService;
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
    private final WatsonxChatService watsonxChatService;

    private final ChatInterchangeService chatInterchangeService;

    public ChatRequestController(ChatGPTChatService chatGPTChatService, GeminiChatService geminiChatService, MistralChatService mistralChatService, AnthropicChatService anthropicChatService, WatsonxChatService watsonxChatService, ChatInterchangeService chatInterchangeService) {
        this.chatGPTChatService = chatGPTChatService;
        this.geminiChatService = geminiChatService;
        this.mistralChatService = mistralChatService;
        this.anthropicChatService = anthropicChatService;
        this.watsonxChatService = watsonxChatService;
        this.chatInterchangeService = chatInterchangeService;
    }

    @PostMapping
    public ChatResponseDTO send(@RequestBody ChatRequestDTO chatRequestDTO) {
        ChatResponseDTO chatResponseDTO = new ChatResponseDTO();
        chatResponseDTO.setTemperature(chatRequestDTO.getTemperature());

        try {
            String chatGPTChatResponse = chatGPTChatService.send(chatRequestDTO.getText(), chatRequestDTO.getTemperature());
            chatResponseDTO.setTextChatGPT(chatGPTChatResponse);
        } catch (Exception e) {
            chatResponseDTO.setTextChatGPT("Error from ChatGPT");
        }

        try {
//            String geminiChatResponse = geminiChatService.send(chatRequestDTO.getText(), chatRequestDTO.getTemperature());
            String geminiChatResponse = chatGPTChatService.send(chatRequestDTO.getText(), chatRequestDTO.getTemperature());
            chatResponseDTO.setTextGemini(geminiChatResponse);
        } catch (Exception e) {
            chatResponseDTO.setTextGemini("Error from Gemini");
        }

        try {
            String mistralChatResponse = mistralChatService.send(chatRequestDTO.getText(), chatRequestDTO.getTemperature());
            chatResponseDTO.setTextMistral(mistralChatResponse);
        } catch (Exception e) {
            chatResponseDTO.setTextMistral("Error from Mistral");
        }

        try {
//            String anthropicChatResponse = anthropicChatService.send(chatRequestDTO.getText(), chatRequestDTO.getTemperature());
            String anthropicChatResponse = mistralChatService.send(chatRequestDTO.getText(), chatRequestDTO.getTemperature());
            chatResponseDTO.setTextAnthropic(anthropicChatResponse);
        } catch (Exception e) {
            chatResponseDTO.setTextAnthropic("Error from Anthropic");
        }

        // todo
//        String watsonxChatResponse = watsonxChatService.send(chatRequestDTO.getText(), chatRequestDTO.getTemperature());
//        chatResponseDTO.setTextWatsonx(watsonxChatResponse);

        ChatInterchangeDTO chatInterchangeDTO = new ChatInterchangeDTO();
        chatInterchangeDTO.setChatDialogId(chatRequestDTO.getChatDialogId());
        chatInterchangeDTO.setChatRequest(chatRequestDTO);
        chatInterchangeDTO.setChatResponse(chatResponseDTO);
        chatInterchangeService.save(chatInterchangeDTO);

        return chatResponseDTO;
    }

}
