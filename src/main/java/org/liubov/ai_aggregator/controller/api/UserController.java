package org.liubov.ai_aggregator.controller.api;

import org.liubov.ai_aggregator.dto.UserDTO;
import org.liubov.ai_aggregator.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> list() {
        return userService.findAll();
    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping ("/validate")
    public UserDTO validate(@RequestParam String email, @RequestParam String password) {
        return userService.validate(email, password);
    }

    @PostMapping("/save_test")
    public void saveUser() {
        UserDTO user1 = new UserDTO();
        user1.setName("John");
        user1.setEmail("john@gmail.com");
        user1.setPassword("111111");

        userService.save(user1);

        UserDTO user2 = new UserDTO();
        user2.setName("Anna");
        user2.setEmail("anna@gmail.com");
        user2.setPassword("222222");

        userService.save(user2);
    }
}
