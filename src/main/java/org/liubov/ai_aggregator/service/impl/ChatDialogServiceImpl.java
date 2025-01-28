package org.liubov.ai_aggregator.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.liubov.ai_aggregator.dto.ChatDialogDTO;
import org.liubov.ai_aggregator.mapper.ChatDialogMapper;
import org.liubov.ai_aggregator.model.ChatDialog;
import org.liubov.ai_aggregator.repository.ChatDialogRepository;
import org.liubov.ai_aggregator.service.ChatDialogService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatDialogServiceImpl implements ChatDialogService {

    private final ChatDialogMapper chatDialogMapper;

    private final ChatDialogRepository chatDialogRepository;

    public ChatDialogServiceImpl(ChatDialogMapper chatDialogMapper, ChatDialogRepository chatDialogRepository) {
        this.chatDialogMapper = chatDialogMapper;
        this.chatDialogRepository = chatDialogRepository;
    }

    @Override
    public ChatDialogDTO save(ChatDialogDTO chatDialogDTO) {
        ChatDialog result = chatDialogRepository.save(chatDialogMapper.toChatDialog(chatDialogDTO));
        log.info("ChatDialog was successfully saved");
        return chatDialogMapper.toChatDialogDTO(result);
    }
}
