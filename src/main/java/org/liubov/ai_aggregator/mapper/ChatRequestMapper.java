package org.liubov.ai_aggregator.mapper;

import org.liubov.ai_aggregator.dto.ChatRequestDTO;
import org.liubov.ai_aggregator.model.ChatRequest;
import org.springframework.stereotype.Component;

import static org.liubov.ai_aggregator.config.AppValues.TEXT_MAX_LENGTH;

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
        chatRequest.setText(chatRequestDTO.getText().substring(0,
                Math.min(chatRequestDTO.getText().length(), TEXT_MAX_LENGTH)));

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
        chatRequestDTO.setText(chatRequest.getText());

        return chatRequestDTO;
    }
}
