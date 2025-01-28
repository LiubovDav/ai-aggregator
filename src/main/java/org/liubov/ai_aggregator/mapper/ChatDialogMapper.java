package org.liubov.ai_aggregator.mapper;

import org.liubov.ai_aggregator.dto.ChatDialogDTO;
import org.liubov.ai_aggregator.model.ChatDialog;
import org.springframework.stereotype.Component;

@Component
public class ChatDialogMapper {

    public ChatDialog toChatDialog(ChatDialogDTO chatDialogDTO) {
        if (chatDialogDTO == null) {
            return null;
        }
        ChatDialog chatDialog = new ChatDialog();
        chatDialog.setUserId(chatDialogDTO.getUserId());

        return chatDialog;
    }

    public ChatDialogDTO toChatDialogDTO(ChatDialog chatDialog) {
        if (chatDialog == null) {
            return null;
        }
        ChatDialogDTO chatDialogDTO = new ChatDialogDTO();
        chatDialogDTO.setChatDialogId(chatDialog.getId());
        chatDialogDTO.setUserId(chatDialog.getUserId());

        return chatDialogDTO;
    }
}
