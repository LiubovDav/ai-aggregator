package org.liubov.ai_aggregator.mapper;

import org.liubov.ai_aggregator.dto.ChatResponseDTO;
import org.liubov.ai_aggregator.model.ChatResponse;
import org.springframework.stereotype.Component;

import static org.liubov.ai_aggregator.config.AppValues.TEXT_MAX_LENGTH;

@Component
public class ChatResponseMapper {
    public ChatResponse toChatResponse(ChatResponseDTO chatResponseDTO) {
        if (chatResponseDTO == null) {
            return null;
        }
        ChatResponse chatResponse = new ChatResponse();
        // todo
//        chatResponse.setChatInterchangeId(chatResponseDTO.getChatInterchangeId());
        chatResponse.setTextChatGPT(chatResponseDTO.getTextChatGPT().substring(0,
                Math.min(chatResponseDTO.getTextChatGPT().length(), TEXT_MAX_LENGTH)));
        chatResponse.setTextGemini(chatResponseDTO.getTextGemini().substring(0,
                Math.min(chatResponseDTO.getTextGemini().length(), TEXT_MAX_LENGTH)));
        chatResponse.setTextMistral(chatResponseDTO.getTextMistral().substring(0,
                Math.min(chatResponseDTO.getTextMistral().length(), TEXT_MAX_LENGTH)));
        chatResponse.setTextAnthropic(chatResponseDTO.getTextAnthropic().substring(0,
                Math.min(chatResponseDTO.getTextAnthropic().length(), TEXT_MAX_LENGTH)));

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
        chatResponseDTO.setTextChatGPT(chatResponse.getTextChatGPT());
        chatResponseDTO.setTextGemini(chatResponse.getTextGemini());
        chatResponseDTO.setTextMistral(chatResponse.getTextMistral());
        chatResponseDTO.setTextAnthropic(chatResponse.getTextAnthropic());

        return chatResponseDTO;
    }
}
