package org.liubov.ai_aggregator.mapper;

import org.liubov.ai_aggregator.dto.ChatInterchangeDTO;
import org.liubov.ai_aggregator.model.ChatInterchange;
import org.springframework.stereotype.Component;

@Component
public class ChatInterchangeMapper {

    private final ChatRequestMapper chatRequestMapper;
    private final ChatResponseMapper chatResponseMapper;

    public ChatInterchangeMapper(ChatRequestMapper chatRequestMapper, ChatResponseMapper chatResponseMapper) {
        this.chatRequestMapper = chatRequestMapper;
        this.chatResponseMapper = chatResponseMapper;
    }

    public ChatInterchange toChatInterchange(ChatInterchangeDTO chatInterchangeDTO) {
        if (chatInterchangeDTO == null) {
            return null;
        }
        ChatInterchange chatInterchange = new ChatInterchange();
        chatInterchange.setChatDialogId(chatInterchangeDTO.getChatDialogId());
        chatInterchange.setChatRequest(chatRequestMapper.toChatRequest(chatInterchangeDTO.getChatRequest()));
        chatInterchange.setChatResponse(chatResponseMapper.toChatResponse(chatInterchangeDTO.getChatResponse()));

        return chatInterchange;
    }

    public ChatInterchangeDTO toChatInterchangeDTO(ChatInterchange chatInterchange) {
        if (chatInterchange == null) {
            return null;
        }
        ChatInterchangeDTO chatInterchangeDTO = new ChatInterchangeDTO();
        chatInterchangeDTO.setChatInterchangeId(chatInterchange.getId());
        chatInterchangeDTO.setChatDialogId(chatInterchange.getChatDialogId());
        chatInterchangeDTO.setChatRequest(chatRequestMapper.toChatRequestDTO(chatInterchange.getChatRequest()));
        chatInterchangeDTO.setChatResponse(chatResponseMapper.toChatResponseDTO(chatInterchange.getChatResponse()));

        return chatInterchangeDTO;
    }
}
