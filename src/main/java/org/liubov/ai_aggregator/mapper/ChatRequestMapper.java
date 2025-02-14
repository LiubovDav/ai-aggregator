package org.liubov.ai_aggregator.mapper;

import org.liubov.ai_aggregator.dto.ChatRequestDTO;
import org.liubov.ai_aggregator.model.ChatRequest;
import org.springframework.stereotype.Component;

@Component
public class ChatRequestMapper {
    
    public ChatRequest toChatRequest(ChatRequestDTO chatRequestDTO) {
        if (chatRequestDTO == null) {
            return null;
        }
        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setChatDialogId(chatRequestDTO.getChatDialogId());
        // todo
//        chatRequest.setChatInterchange(chatRequestDTO.getChatInterchange());
        chatRequest.setTemperature(chatRequestDTO.getTemperature());
        chatRequest.setText(chatRequestDTO.getText());

        return chatRequest;
    }

    public ChatRequestDTO toChatRequestDTO(ChatRequest chatRequest) {
        if (chatRequest == null) {
            return null;
        }
        ChatRequestDTO chatRequestDTO = new ChatRequestDTO();
        chatRequestDTO.setChatRequestId(chatRequest.getId());
        chatRequestDTO.setChatDialogId(chatRequest.getChatDialogId());
        // todo
//        chatRequestDTO.setChatInterchangeId(chatRequest.getChatInterchangeId());
        chatRequestDTO.setTemperature(chatRequest.getTemperature());
        chatRequestDTO.setText(chatRequest.getText());

        return chatRequestDTO;
    }
}
