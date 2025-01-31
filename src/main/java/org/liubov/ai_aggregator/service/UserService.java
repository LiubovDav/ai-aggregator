package org.liubov.ai_aggregator.service;

import org.liubov.ai_aggregator.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO save(UserDTO userDTO);

    boolean validate(String email, String password);

    UserDTO findByEmail(String email);
}
