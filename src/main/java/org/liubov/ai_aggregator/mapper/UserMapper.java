package org.liubov.ai_aggregator.mapper;

import org.liubov.ai_aggregator.dto.UserDTO;
import org.liubov.ai_aggregator.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User toUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setCreatedOn(userDTO.getCreatedOn());
        user.setUpdatedOn(userDTO.getUpdatedOn());

        return user;
    }

    public UserDTO toUserDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setCreatedOn(user.getCreatedOn());
        userDTO.setUpdatedOn(user.getUpdatedOn());

        return userDTO;
    }

    public List<User> toUserList(List<UserDTO> userDTOList) {
        List<User> userList = new ArrayList<>();

        for (UserDTO userDTO: userDTOList) {
            userList.add(toUser(userDTO));
        }

        return userList;
    }

    public List<UserDTO> toUserDTOList(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user: userList) {
            userDTOList.add(toUserDTO(user));
        }

        return userDTOList;
    }
}
