package org.liubov.ai_aggregator.controller.api;

import org.liubov.ai_aggregator.dto.ChatDialogDTO;
import org.liubov.ai_aggregator.service.ChatDialogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/chat_dialog")
public class ChatDialogController {

    private final ChatDialogService chatDialogService;

    public ChatDialogController(ChatDialogService chatDialogService) {
        this.chatDialogService = chatDialogService;
    }

    @PostMapping
    public ChatDialogDTO createDialog(@RequestParam Long userId) {
        ChatDialogDTO chatDialog = new ChatDialogDTO();
        chatDialog.setUserId(userId);
        return chatDialogService.save(chatDialog);
    }
}
