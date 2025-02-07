package org.liubov.ai_aggregator.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.liubov.ai_aggregator.dto.ChatInterchangeDTO;
import org.liubov.ai_aggregator.mapper.ChatInterchangeMapper;
import org.liubov.ai_aggregator.model.ChatInterchange;
import org.liubov.ai_aggregator.repository.ChatInterchangeRepository;
import org.liubov.ai_aggregator.service.ChatInterchangeService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatInterchangeServiceImpl implements ChatInterchangeService {

    private final ChatInterchangeMapper chatInterchangeMapper;

    private final ChatInterchangeRepository chatInterchangeRepository;

    public ChatInterchangeServiceImpl(ChatInterchangeMapper chatInterchangeMapper, ChatInterchangeRepository chatInterchangeRepository) {
        this.chatInterchangeMapper = chatInterchangeMapper;
        this.chatInterchangeRepository = chatInterchangeRepository;
    }

    @Override
    public ChatInterchangeDTO save(ChatInterchangeDTO chatInterchangeDTO) {
        ChatInterchange result = chatInterchangeRepository.save(chatInterchangeMapper.toChatInterchange(chatInterchangeDTO));
        log.info("ChatInterchange was successfully saved");
        return chatInterchangeMapper.toChatInterchangeDTO(result);
    }
}
