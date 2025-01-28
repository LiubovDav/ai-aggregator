package org.liubov.ai_aggregator.controller.api;

import org.liubov.ai_aggregator.ai.chat.ChatGPTChatService;
import org.liubov.ai_aggregator.ai.chat.GeminiChatService;
import org.liubov.ai_aggregator.ai.image.AzureOpenAIImageService;
import org.liubov.ai_aggregator.ai.image.ChatGPTImageService;
import org.liubov.ai_aggregator.dto.UserDTO;
import org.liubov.ai_aggregator.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;
    private final ChatGPTChatService chatGPTChatService;
    private final GeminiChatService geminiChatService;
    private final ChatGPTImageService chatGPTImageService;
    private final AzureOpenAIImageService azureOpenAIImageService;

    public UserController(UserService userService, ChatGPTChatService chatGPTChatService, GeminiChatService geminiChatService, ChatGPTImageService chatGPTImageService, AzureOpenAIImageService azureOpenAIImageService) {
        this.userService = userService;
        this.chatGPTChatService = chatGPTChatService;
        this.geminiChatService = geminiChatService;
        this.chatGPTImageService = chatGPTImageService;
        this.azureOpenAIImageService = azureOpenAIImageService;
    }

    @GetMapping
    public List<UserDTO> list() {
//        chatGPTService.send("Name the ten largest rivers on planet Earth");
//        geminiService.send("Name the ten largest rivers on planet Earth");
//        chatGPTImageService.send("A light cream colored mini golden doodle");
//        azureOpenAIImageService.send("A light cream colored mini golden doodle");
        
        return userService.findAll();
    }

    @PostMapping("/save_test")
    public void saveUser() {
        UserDTO user1 = new UserDTO();
        user1.setName("John");
        user1.setEmail("john@gmail.com");
        user1.setPassword("hgasjhdgajshdgj");

        userService.save(user1);

        UserDTO user2 = new UserDTO();
        user2.setName("Anna");
        user2.setEmail("anna@gmail.com");
        user2.setPassword("hfdhagsjhdgajshdg");

        userService.save(user2);
    }
}
