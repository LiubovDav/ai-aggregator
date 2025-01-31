package org.liubov.ai_aggregator.controller.api;

import org.liubov.ai_aggregator.dto.ChatDialogDTO;
import org.liubov.ai_aggregator.service.ChatDialogService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/chat_dialog")
public class ChatDialogController {

    private final ChatDialogService chatDialogService;

    public ChatDialogController(ChatDialogService chatDialogService) {
        this.chatDialogService = chatDialogService;
    }

    @PostMapping
    public ChatDialogDTO createDialog(@PathVariable Integer userId) {

        ChatDialogDTO chatDialog = new ChatDialogDTO();
        chatDialog.setUserId(userId);

        return chatDialogService.save(chatDialog);
    }
}
