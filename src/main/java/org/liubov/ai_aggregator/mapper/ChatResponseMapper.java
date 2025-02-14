package org.liubov.ai_aggregator.mapper;

import org.liubov.ai_aggregator.dto.ChatResponseDTO;
import org.liubov.ai_aggregator.model.ChatResponse;
import org.springframework.stereotype.Component;

@Component
public class ChatResponseMapper {
    public ChatResponse toChatResponse(ChatResponseDTO chatResponseDTO) {
        if (chatResponseDTO == null) {
            return null;
        }
        ChatResponse chatResponse = new ChatResponse();
        // todo
//        chatResponse.setChatInterchangeId(chatResponseDTO.getChatInterchangeId());
        chatResponse.setTemperature(chatResponseDTO.getTemperature());
        chatResponse.setTextChatGPT(chatResponseDTO.getTextChatGPT());
        chatResponse.setTextGemini(chatResponseDTO.getTextGemini());
        chatResponse.setTextMistral(chatResponseDTO.getTextMistral());
        chatResponse.setTextAnthropic(chatResponseDTO.getTextAnthropic());

        return chatResponse;
    }

    public ChatResponseDTO toChatResponseDTO(ChatResponse chatResponse) {
        if (chatResponse == null) {
            return null;
        }
        ChatResponseDTO chatResponseDTO = new ChatResponseDTO();
        chatResponseDTO.setChatResponseId(chatResponse.getId());
//        todo
//        chatResponseDTO.setChatInterchangeId(chatResponse.getChatInterchangeId());
        chatResponseDTO.setTemperature(chatResponse.getTemperature());
        chatResponseDTO.setTextChatGPT(chatResponse.getTextChatGPT());
        chatResponseDTO.setTextGemini(chatResponse.getTextGemini());
        chatResponseDTO.setTextMistral(chatResponse.getTextMistral());
        chatResponseDTO.setTextAnthropic(chatResponse.getTextAnthropic());

        return chatResponseDTO;
    }
}
